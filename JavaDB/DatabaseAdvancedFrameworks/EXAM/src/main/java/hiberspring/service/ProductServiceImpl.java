package hiberspring.service;

import hiberspring.common.Constants;
import hiberspring.domain.dtos.products.ProductImportRootDto;
import hiberspring.domain.entities.Branch;
import hiberspring.domain.entities.Product;
import hiberspring.repository.BranchRepository;
import hiberspring.repository.ProductRepository;
import hiberspring.util.FileUtil;
import hiberspring.util.ValidationUtil;
import hiberspring.util.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.Arrays;

@Service
public class ProductServiceImpl implements ProductService {

    private final static String PRODUCTS_XML_FILE_PATH =
            Constants.PATH_TO_FILES + "products.xml";

    private final ProductRepository productRepository;
    private final BranchRepository branchRepository;
    private final FileUtil fileUtil;
    private final ValidationUtil validationUtil;
    private final XmlParser xmlParser;
    private final ModelMapper modelMapper;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository,
                              BranchRepository branchRepository,
                              FileUtil fileUtil,
                              ValidationUtil validationUtil,
                              XmlParser xmlParser,
                              ModelMapper modelMapper) {
        this.productRepository = productRepository;
        this.branchRepository = branchRepository;
        this.fileUtil = fileUtil;
        this.validationUtil = validationUtil;
        this.xmlParser = xmlParser;
        this.modelMapper = modelMapper;
    }

    @Override
    public Boolean productsAreImported() {
        return this.productRepository.count() > 0;
    }

    @Override
    public String readProductsXmlFile() throws IOException {
        return this.fileUtil.readFile(PRODUCTS_XML_FILE_PATH);
    }

    @Override
    public String importProducts() throws JAXBException {
        StringBuilder importResult = new StringBuilder();

        ProductImportRootDto productImportRootDto = this.xmlParser
                .parseXml(
                        ProductImportRootDto.class,
                        PRODUCTS_XML_FILE_PATH
                );

        Arrays.stream(productImportRootDto.getProductImportDtos())
                .forEach(productImportDto -> {
                    Branch branchEntity = this.branchRepository
                            .findByName(productImportDto.getBranch())
                            .orElse(null);

                    Product productEntity = this.productRepository
                            .findByName(productImportDto.getName())
                            .orElse(null);

                    if (branchEntity == null ||
                    productEntity != null ||
                    !this.validationUtil.isValid(productImportDto)){
                        importResult
                                .append(Constants.INCORRECT_DATA_MESSAGE)
                                .append(System.lineSeparator());

                        return;
                    }

                    productEntity = this.modelMapper.map(productImportDto, Product.class);
                    productEntity.setBranch(branchEntity);
                    this.productRepository.saveAndFlush(productEntity);

                    importResult
                            .append(String.format(
                                    Constants.SUCCESSFUL_IMPORT_MESSAGE,
                                    productEntity.getClass().getSimpleName(),
                                    productEntity.getName()
                            ))
                            .append(System.lineSeparator());
                });

        return importResult.toString().trim();
    }
}
