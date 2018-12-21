package hiberspring.service;

import com.google.gson.Gson;
import hiberspring.common.Constants;
import hiberspring.domain.dtos.TownImportDto;
import hiberspring.domain.entities.Town;
import hiberspring.repository.TownRepository;
import hiberspring.util.FileUtil;
import hiberspring.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Arrays;

@Service
public class TownServiceImpl implements TownService {

    private final static String TOWNS_JSON_FILE_PATH =
            Constants.PATH_TO_FILES + "towns.json";

    private final TownRepository townRepository;
    private final FileUtil fileUtil;
    private final ValidationUtil validationUtil;
    private final Gson gson;
    private final ModelMapper modelMapper;

    @Autowired
    public TownServiceImpl(TownRepository townRepository,
                           FileUtil fileUtil,
                           ValidationUtil validationUtil,
                           Gson gson,
                           ModelMapper modelMapper) {
        this.townRepository = townRepository;
        this.fileUtil = fileUtil;
        this.validationUtil = validationUtil;
        this.gson = gson;
        this.modelMapper = modelMapper;
    }

    @Override
    public Boolean townsAreImported() {
        return this.townRepository.count() > 0;
    }

    @Override
    public String readTownsJsonFile() throws IOException {
        System.out.println();
        return this.fileUtil.readFile(TOWNS_JSON_FILE_PATH);
    }

    @Override
    public String importTowns(String townsFileContent) {
        StringBuilder importResult = new StringBuilder();

        TownImportDto[] townImportDtos = this.gson.fromJson(
                townsFileContent,
                TownImportDto[].class
        );

        Arrays.stream(townImportDtos)
                .forEach(townImportDto -> {
                    Town townEntity = this.townRepository
                            .findByName(townImportDto.getName())
                            .orElse(null);

                    if (townEntity != null ||
                    !this.validationUtil.isValid(townImportDto)){
                        importResult
                                .append(Constants.INCORRECT_DATA_MESSAGE)
                                .append(System.lineSeparator());

                        return;
                    }

                    townEntity = this.modelMapper.map(townImportDto, Town.class);
                    this.townRepository.saveAndFlush(townEntity);

                    importResult
                            .append(String.format(
                                    Constants.SUCCESSFUL_IMPORT_MESSAGE,
                                    townEntity.getClass().getSimpleName(),
                                    townEntity.getName()
                            ))
                            .append(System.lineSeparator());
                });

        return importResult.toString().trim();
    }
}
