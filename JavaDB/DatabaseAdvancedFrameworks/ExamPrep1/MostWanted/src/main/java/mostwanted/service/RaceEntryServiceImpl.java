package mostwanted.service;

import mostwanted.common.Constants;
import mostwanted.domain.dtos.raceentries.RaceEntryImportRootDto;
import mostwanted.domain.entities.Car;
import mostwanted.domain.entities.RaceEntry;
import mostwanted.domain.entities.Racer;
import mostwanted.repository.CarRepository;
import mostwanted.repository.RaceEntryRepository;
import mostwanted.repository.RacerRepository;
import mostwanted.util.FileUtil;
import mostwanted.util.ValidationUtil;
import mostwanted.util.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.Arrays;

@Service
public class RaceEntryServiceImpl implements RaceEntryService {

    private final static String RACE_ENTRIES_XML_FILE_PATH =
            System.getProperty("user.dir") + "/src/main/resources/files/race-entries.xml";

    private final RaceEntryRepository raceEntryRepository;
    private final CarRepository carRepository;
    private final RacerRepository racerRepository;
    private final FileUtil fileUtil;
    private final XmlParser xmlParser;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;

    @Autowired
    public RaceEntryServiceImpl(RaceEntryRepository raceEntryRepository,
                                CarRepository carRepository,
                                RacerRepository racerRepository,
                                FileUtil fileUtil,
                                XmlParser xmlParser,
                                ValidationUtil validationUtil,
                                ModelMapper modelMapper) {
        this.raceEntryRepository = raceEntryRepository;
        this.carRepository = carRepository;
        this.racerRepository = racerRepository;
        this.fileUtil = fileUtil;
        this.xmlParser = xmlParser;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public Boolean raceEntriesAreImported() {
        return this.raceEntryRepository.count() > 0;
    }

    @Override
    public String readRaceEntriesXmlFile() throws IOException {
        return this.fileUtil.readFile(RACE_ENTRIES_XML_FILE_PATH);
    }

    @Override
    public String importRaceEntries() throws JAXBException {
        StringBuilder importResult = new StringBuilder();

        RaceEntryImportRootDto raceEntryImportRootDto = this.xmlParser
                .parseXml(RaceEntryImportRootDto.class, RACE_ENTRIES_XML_FILE_PATH);

        Arrays.stream(raceEntryImportRootDto.getRaceEntryImportDtos())
                .forEach(raceEntryImportDto -> {
                    Racer racerEntity = this.racerRepository
                            .findByName(raceEntryImportDto.getRacer())
                            .orElse(null);
                    Car carEntity = this.carRepository
                            .findById(raceEntryImportDto.getCarId())
                            .orElse(null);

                    if (racerEntity == null || carEntity == null){
                        importResult
                                .append(Constants.INCORRECT_DATA_MESSAGE)
                                .append(System.lineSeparator());

                        return;
                    }

                    RaceEntry raceEntryEntity = this.modelMapper.map(
                            raceEntryImportDto,
                            RaceEntry.class
                    );
                    raceEntryEntity.setCar(carEntity);
                    raceEntryEntity.setRacer(racerEntity);
                    raceEntryEntity.setRace(null);
                    raceEntryEntity = this.raceEntryRepository.saveAndFlush(raceEntryEntity);

                    importResult
                            .append(String.format(
                                    Constants.SUCCESSFUL_IMPORT_MESSAGE,
                                    raceEntryEntity.getClass().getSimpleName(),
                                    raceEntryEntity.getId()
                            ))
                            .append(System.lineSeparator());
                });

        return importResult.toString().trim();
    }
}
