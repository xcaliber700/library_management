package co.pragra.learning.librarymgmt.rest;

import co.pragra.learning.librarymgmt.entity.Book;
import co.pragra.learning.librarymgmt.repo.BookRepo;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
public class BookApi {
    public BookRepo repo;

    public BookApi(BookRepo repo) {
        this.repo = repo;
    }

    @PostMapping("/api/book")
    public Book createBook(@RequestBody Book book) {
        if (book.getId() == 0) {
            book.setId((int) Math.floor(Math.random() * 10000));
        }
        return repo.create(book);

    }

    @GetMapping("/api/book")
    public List<Book> getAll() {
        return repo.getAll(Collections.emptyMap());
    }
}

