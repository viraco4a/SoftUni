package hiberspring.service;

import com.google.gson.Gson;
import hiberspring.common.Constants;
import hiberspring.domain.dtos.EmployeeCardImportDto;
import hiberspring.domain.entities.EmployeeCard;
import hiberspring.repository.EmployeeCardRepository;
import hiberspring.util.FileUtil;
import hiberspring.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Arrays;

@Service
public class EmployeeCardServiceImpl implements EmployeeCardService {

    private final static String EMPLOYEE_CARDS_JSON_FILE_PATH =
            Constants.PATH_TO_FILES + "employee-cards.json";

    private final EmployeeCardRepository employeeCardRepository;
    private final FileUtil fileUtil;
    private final ValidationUtil validationUtil;
    private final Gson gson;
    private final ModelMapper modelMapper;

    @Autowired
    public EmployeeCardServiceImpl(EmployeeCardRepository employeeCardRepository,
                                   FileUtil fileUtil,
                                   ValidationUtil validationUtil,
                                   Gson gson,
                                   ModelMapper modelMapper) {
        this.employeeCardRepository = employeeCardRepository;
        this.fileUtil = fileUtil;
        this.validationUtil = validationUtil;
        this.gson = gson;
        this.modelMapper = modelMapper;
    }

    @Override
    public Boolean employeeCardsAreImported() {
        return this.employeeCardRepository.count() > 0;
    }

    @Override
    public String readEmployeeCardsJsonFile() throws IOException {
        return this.fileUtil.readFile(EMPLOYEE_CARDS_JSON_FILE_PATH);
    }

    @Override
    public String importEmployeeCards(String employeeCardsFileContent) {
        StringBuilder importResult = new StringBuilder();

        EmployeeCardImportDto[] employeeCardImportDtos = this.gson.fromJson(
                employeeCardsFileContent,
                EmployeeCardImportDto[].class
        );

        Arrays.stream(employeeCardImportDtos)
                .forEach(employeeCardImportDto -> {
                    EmployeeCard employeeCardEntity = this.employeeCardRepository
                            .findByNumber(employeeCardImportDto.getNumber())
                            .orElse(null);

                    if (employeeCardEntity != null ||
                            !this.validationUtil.isValid(employeeCardImportDto)){
                        importResult
                                .append(Constants.INCORRECT_DATA_MESSAGE)
                                .append(System.lineSeparator());

                        return;
                    }

                    employeeCardEntity = this.modelMapper.map(employeeCardImportDto, EmployeeCard.class);
                    this.employeeCardRepository.saveAndFlush(employeeCardEntity);

                    importResult
                            .append(String.format(
                                    Constants.SUCCESSFUL_IMPORT_MESSAGE,
                                    employeeCardEntity.getClass().getSimpleName(),
                                    employeeCardEntity.getNumber()
                            ))
                            .append(System.lineSeparator());
                });

        return importResult.toString().trim();
    }
}
