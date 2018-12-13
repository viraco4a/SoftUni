package bookshopsystemapp.controller;

import bookshopsystemapp.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

@Controller
public class BookshopController implements CommandLineRunner {

    private final AuthorService authorService;

    @Autowired
    public BookshopController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @Override
    public void run(String... args) throws Exception {
        this.authorService.seedAuthors();
    }
}
