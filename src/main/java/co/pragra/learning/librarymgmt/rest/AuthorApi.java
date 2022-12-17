package co.pragra.learning.librarymgmt.rest;

import co.pragra.learning.librarymgmt.entity.Author;
import co.pragra.learning.librarymgmt.repo.AuthorRepo;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
public class AuthorApi {
    private AuthorRepo repo;

    public AuthorApi(AuthorRepo repo) {
        this.repo = repo;
    }


    @PostMapping("/api/author")
    public Author creAuthor(@RequestBody Author author){
        return repo.create(author);
    }

    @GetMapping("/api/author")
    public List<Author> getAll(){return repo.getAll(Collections.emptyMap());}

    @GetMapping("/api/author/id/{id}")
    public Optional<Author> getById(@PathVariable int id){return repo.getById(id);}

    @PutMapping("/api/author")
    public Author update(@RequestBody Author author){return repo.update(author);}

}

