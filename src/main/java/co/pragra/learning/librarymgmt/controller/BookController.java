package co.pragra.learning.librarymgmt.controller;

import co.pragra.learning.librarymgmt.entity.Book;
import co.pragra.learning.librarymgmt.repo.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class BookController {
    private BookRepository repository;

    public BookController(BookRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/book")
    public String bookHome(Model model){
        List<Book> books = repository.findAll();
        model.addAttribute("title","Library Managing Book - "+books.size());
        model.addAttribute("books",books);
        return "book"; //returning template/view
    }
    @GetMapping("/createbook")
    public String create(Model model){
        model.addAttribute("book", new Book());
        return "createBook";
    }

    @PostMapping("/book")
    public String createBook(@ModelAttribute Book book, Model model){
        repository.save(book);
        List<Book> all = repository.findAll();
        model.addAttribute("title","Library Managing Book - "+all.size());
        model.addAttribute("books",all);
        return "book";
    }
}
