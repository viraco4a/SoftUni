package mostwanted.service;

import com.google.gson.Gson;
import mostwanted.domain.dtos.CarImportDto;
import mostwanted.domain.entities.Car;
import mostwanted.repository.CarRepository;
import mostwanted.repository.RacerRepository;
import mostwanted.util.FileUtil;
import mostwanted.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Arrays;

@Service
public class CarServiceImpl implements CarService {

    private final static String CARS_JSON_FILE_PATH =
            System.getProperty("user.dir") + "/src/main/resources/files/cars.json";

    private final CarRepository carRepository;
    private final RacerRepository racerRepository;
    private final FileUtil fileUtil;
    private final Gson gson;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;

    @Autowired
    public CarServiceImpl(CarRepository carRepository,
                          RacerRepository racerRepository,
                          FileUtil fileUtil,
                          Gson gson,
                          ValidationUtil validationUtil,
                          ModelMapper modelMapper) {
        this.carRepository = carRepository;
        this.racerRepository = racerRepository;
        this.fileUtil = fileUtil;
        this.gson = gson;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public Boolean carsAreImported() {
        return this.carRepository.count() > 0;
    }

    @Override
    public String readCarsJsonFile() throws IOException {
        return this.fileUtil.readFile(CARS_JSON_FILE_PATH);
    }

    @Override
    public String importCars(String carsFileContent) {

        StringBuilder importResult = new StringBuilder();

        CarImportDto[] carImportDtos = this.gson.fromJson(
                carsFileContent,
                CarImportDto[].class
        );

        Arrays.stream(carImportDtos)
                .forEach(carImportDto -> {
                    //Car carEntity = this.carRepository.findById(carImportDto.get) // TODO id not workable - no id in dto
                });

        return importResult.toString().trim();
    }
}
