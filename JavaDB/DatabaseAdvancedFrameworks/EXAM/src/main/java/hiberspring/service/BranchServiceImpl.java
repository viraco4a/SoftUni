package hiberspring.service;

import com.google.gson.Gson;
import hiberspring.common.Constants;
import hiberspring.domain.dtos.BranchImportDto;
import hiberspring.domain.dtos.TownImportDto;
import hiberspring.domain.entities.Branch;
import hiberspring.domain.entities.Town;
import hiberspring.repository.BranchRepository;
import hiberspring.repository.TownRepository;
import hiberspring.util.FileUtil;
import hiberspring.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Arrays;

@Service
public class BranchServiceImpl implements BranchService{

    private final static String BRANCHES_JSON_FILE_PATH =
            Constants.PATH_TO_FILES + "branches.json";

    private final BranchRepository branchRepository;
    private final TownRepository townRepository;
    private final FileUtil fileUtil;
    private final ValidationUtil validationUtil;
    private final Gson gson;
    private final ModelMapper modelMapper;


    @Autowired
    public BranchServiceImpl(BranchRepository branchRepository,
                             TownRepository townRepository,
                             FileUtil fileUtil,
                             ValidationUtil validationUtil,
                             Gson gson,
                             ModelMapper modelMapper) {
        this.branchRepository = branchRepository;
        this.townRepository = townRepository;
        this.fileUtil = fileUtil;
        this.validationUtil = validationUtil;
        this.gson = gson;
        this.modelMapper = modelMapper;
    }

    @Override
    public Boolean branchesAreImported() {
        return this.branchRepository.count() > 0;
    }

    @Override
    public String readBranchesJsonFile() throws IOException {
        return this.fileUtil.readFile(BRANCHES_JSON_FILE_PATH);
    }

    @Override
    public String importBranches(String branchesFileContent) {
        StringBuilder importResult = new StringBuilder();

        BranchImportDto[] branchImportDtos = this.gson.fromJson(
                branchesFileContent,
                BranchImportDto[].class
        );

        Arrays.stream(branchImportDtos)
                .forEach(branchImportDto -> {
                    Town townEntity = this.townRepository
                            .findByName(branchImportDto.getTown())
                            .orElse(null);

                    Branch branchEntity = this.branchRepository
                            .findByName(branchImportDto.getName())
                            .orElse(null);

                    if (townEntity == null ||
                            branchEntity != null ||
                            !this.validationUtil.isValid(branchImportDto)){
                        importResult
                                .append(Constants.INCORRECT_DATA_MESSAGE)
                                .append(System.lineSeparator());

                        return;
                    }

                    branchEntity = this.modelMapper.map(branchImportDto, Branch.class);
                    branchEntity.setTown(townEntity);
                    this.branchRepository.saveAndFlush(branchEntity);

                    importResult
                            .append(String.format(
                                    Constants.SUCCESSFUL_IMPORT_MESSAGE,
                                    branchEntity.getClass().getSimpleName(),
                                    branchEntity.getName()
                            ))
                            .append(System.lineSeparator());
                });

        return importResult.toString().trim();
    }
}
