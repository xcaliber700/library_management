package co.pragra.learning.librarymgmt.rest;

import co.pragra.learning.librarymgmt.entity.Author;
//import co.pragra.learning.librarymgmt.repo.AuthorRepo;
import co.pragra.learning.librarymgmt.repo.AuthorRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
public class AuthorApi {
    private AuthorRepository repo;

    public AuthorApi(AuthorRepository repo) {
        this.repo = repo;
    }


    @PostMapping("/api/author")
    public Author creAuthor(@RequestBody Author author){
        return repo.save(author);
    }

    @GetMapping("/api/author")
    public List<Author> getAll(){return repo.findAll();}

    @GetMapping("/api/author/id/{id}")
    public Optional<Author> getById(@PathVariable int id){return repo.findById(id);}

    @PutMapping("/api/author")
    public Author update(@RequestBody Author author){return repo.save(author);}

}

