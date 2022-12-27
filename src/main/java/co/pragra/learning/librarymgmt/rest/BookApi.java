package co.pragra.learning.librarymgmt.rest;

import co.pragra.learning.librarymgmt.dto.ErrorResponse;
import co.pragra.learning.librarymgmt.entity.Author;
import co.pragra.learning.librarymgmt.entity.Book;
//import co.pragra.learning.librarymgmt.repo.BookRepo;
import co.pragra.learning.librarymgmt.repo.BookRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class BookApi {
    public BookRepository repo;

    public BookApi(BookRepository repo) {
        this.repo = repo;
    }

    @PostMapping("/api/book")
    public Book createBook(@RequestBody Book book) {
//        if (book.getId() == 0) {
//            book.setId((int) Math.floor(Math.random() * 10000));
//        } //if id id not auto generated or sequence is not used
        return repo.save(book);

    }

    @GetMapping("/api/book")
    public ResponseEntity<?> getAll(@RequestParam(name = "title") Optional<String> title,
                                    @RequestParam(name = "isbn", defaultValue = "all") String isbn,
                                    @RequestHeader(name = "X-Market",defaultValue = "US")String header) {
        List<Book> books = repo.findAll();
        if(isbn.equals("all")){
            if(title.isPresent()){
                return ResponseEntity.status(200).header("X-RETURNEDVALUE",header).body(books.stream().filter(book -> book.getTitle().equalsIgnoreCase(title.get())).collect(Collectors.toList()));
            }
//            return ResponseEntity.status(201).body(books);
            return ResponseEntity.ok(books);
        }
        return getByIsbn(isbn);
    }
    @GetMapping("/api/book/noreviews")
    public List<Book> getAllwithNoReviews() {
//        return repo.getAllWithNoReviews();
        return repo.findAll().stream().filter(book -> book.getReviews().size()==0).collect(Collectors.toList());
    }

    @GetMapping("/api/book/id/{id}")
    public Optional<Book> getById(@PathVariable int id){return repo.findById(id);}
    @GetMapping("/api/book/isbn/{isbn}")
    public ResponseEntity<?> getByIsbn(@PathVariable String isbn){
        Optional<Book> optionalBook= repo.findByIsbn(isbn);
        if (optionalBook.isPresent()){
            return ResponseEntity.status(200).header("X.provider", "Baban").body(optionalBook.get());
        }
        ErrorResponse errorResponse = ErrorResponse.builder()
                .appID("LIB01")
                .errorCode(404)
                .dateTime(new Date())
                .message(String.format("Book for isbn=[%s] not found in database", isbn))
                .build();
        return ResponseEntity.status(404).header("X.provider", "Reza").body(errorResponse);
    }
    @DeleteMapping("/api/book/id/{id}")
    public Book deleteById(@PathVariable int id){
        Optional<Book> byId = repo.findById(id);
        if(byId.isPresent()){
            repo.deleteById(id);
        }
        return byId.get();
    }
    @PutMapping("/api/book")
    public Book update(@RequestBody Book book){return repo.save(book);}

}

