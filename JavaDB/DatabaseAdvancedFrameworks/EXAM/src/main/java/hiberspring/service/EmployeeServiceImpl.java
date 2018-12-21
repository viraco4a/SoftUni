package hiberspring.service;

import hiberspring.common.Constants;
import hiberspring.domain.dtos.employees.EmployeeImportRootDto;
import hiberspring.domain.entities.Branch;
import hiberspring.domain.entities.Employee;
import hiberspring.domain.entities.EmployeeCard;
import hiberspring.repository.BranchRepository;
import hiberspring.repository.EmployeeCardRepository;
import hiberspring.repository.EmployeeRepository;
import hiberspring.util.FileUtil;
import hiberspring.util.ValidationUtil;
import hiberspring.util.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final static String EMPLOYEES_XML_FILE_PATH =
            Constants.PATH_TO_FILES + "employees.xml";

    private final EmployeeRepository employeeRepository;
    private final EmployeeCardRepository employeeCardRepository;
    private final BranchRepository branchRepository;
    private final FileUtil fileUtil;
    private final ValidationUtil validationUtil;
    private final XmlParser xmlParser;
    private final ModelMapper modelMapper;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository,
                               EmployeeCardRepository employeeCardRepository,
                               BranchRepository branchRepository,
                               FileUtil fileUtil,
                               ValidationUtil validationUtil,
                               XmlParser xmlParser,
                               ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.employeeCardRepository = employeeCardRepository;
        this.branchRepository = branchRepository;
        this.fileUtil = fileUtil;
        this.validationUtil = validationUtil;
        this.xmlParser = xmlParser;
        this.modelMapper = modelMapper;
    }

    @Override
    public Boolean employeesAreImported() {
        return this.employeeRepository.count() > 0;
    }

    @Override
    public String readEmployeesXmlFile() throws IOException {
        return this.fileUtil.readFile(EMPLOYEES_XML_FILE_PATH);
    }

    @Override
    public String importEmployees() throws JAXBException {
        StringBuilder importResult = new StringBuilder();

        List<String> usedCards = new ArrayList<>();

        EmployeeImportRootDto employeeImportRootDto = this.xmlParser
                .parseXml(
                        EmployeeImportRootDto.class,
                        EMPLOYEES_XML_FILE_PATH
                );


        Arrays.stream(employeeImportRootDto.getEmployeeImportDtos())
                .forEach(employeeImportDto -> {
                    Branch branchEntity = this.branchRepository
                            .findByName(employeeImportDto.getBranch())
                            .orElse(null);

                    EmployeeCard employeeCardEntity = this.employeeCardRepository
                            .findByNumber(employeeImportDto.getCard())
                            .orElse(null);

                    String cardName = employeeImportDto.getCard();


                    if (branchEntity == null ||
                            employeeCardEntity == null ||
                            usedCards.contains(cardName) ||
                            !this.validationUtil.isValid(employeeImportDto)){
                        importResult
                                .append(Constants.INCORRECT_DATA_MESSAGE)
                                .append(System.lineSeparator());

                        return;
                    }

                    usedCards.add(cardName);
                    Employee employeeEntity = this.modelMapper.map(employeeImportDto, Employee.class);
                    employeeEntity.setBranch(branchEntity);
                    employeeEntity.setCard(employeeCardEntity);
                    employeeEntity = this.employeeRepository.saveAndFlush(employeeEntity);

                    importResult
                            .append(String.format(
                                    Constants.SUCCESSFUL_IMPORT_MESSAGE,
                                    employeeEntity.getClass().getSimpleName(),
                                    String.format("%s %s",
                                            employeeEntity.getFirstName(),
                                            employeeEntity.getLastName())))
                            .append(System.lineSeparator());
                });

        return importResult.toString().trim();
    }

    @Override
    public String exportProductiveEmployees() {
        StringBuilder exportResult = new StringBuilder();
        List<Employee> employees = this.employeeRepository.exportEmployees();

        employees.stream().forEach(employee -> {
            exportResult
                    .append(String.format("Name: %s %s",
                            employee.getFirstName(),
                            employee.getLastName()))
                    .append(System.lineSeparator())
                    .append(String.format("Position: %s",
                            employee.getPosition()))
                    .append(System.lineSeparator())
                    .append(String.format("Card Number: %s",
                            employee.getCard().getNumber()))
                    .append(System.lineSeparator())
                    .append("-------------------------")
                    .append(System.lineSeparator());
        });

        return exportResult.toString().trim();
    }
}
