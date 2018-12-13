package bookshopsystemapp.service;

import bookshopsystemapp.repository.CategoryRepository;
import bookshopsystemapp.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final static String CATEGORIES_FILE_PATH =
            "C:\\Coding\\SoftUni\\JavaDB\\DatabaseAdvancedFrameworks\\SpringIntroEx\\src\\main\\resources\\files\\categories.txt";
    private final CategoryRepository categoryRepository;
    private final FileUtil fileUtil;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository, FileUtil fileUtil) {
        this.categoryRepository = categoryRepository;
        this.fileUtil = fileUtil;
    }

    @Override
    public void seedCategories() throws IOException {
        if (this.categoryRepository.count() != 0){
            return;
        }

        String[] categoryFileContent =
                this.fileUtil.getFileContent(CATEGORIES_FILE_PATH);

        for (String line : categoryFileContent) {
            //TODO
        }
    }
}
