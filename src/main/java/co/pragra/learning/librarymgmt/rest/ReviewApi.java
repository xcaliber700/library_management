package co.pragra.learning.librarymgmt.rest;

import co.pragra.learning.librarymgmt.entity.Book;
import co.pragra.learning.librarymgmt.entity.Review;
import co.pragra.learning.librarymgmt.repo.BookRepository;
import co.pragra.learning.librarymgmt.repo.ReviewRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ReviewApi {
    private ReviewRepository repo;
    private BookRepository bookRepository;

    public ReviewApi(ReviewRepository repo, BookRepository bookRepository) {
        this.repo = repo;
        this.bookRepository = bookRepository;
    }

    @PostMapping("/api/book/{bookId}/review")
    public Review addReview(@PathVariable int bookId, @RequestBody Review review){
        Optional<Book> byId = bookRepository.findById(bookId);
        if (byId.isPresent()) {
            Review savedReview = repo.save(review);
            Book book = byId.get();
            book.getReviews().add(savedReview);
            bookRepository.save(book);
            return savedReview;
        }
        return null;
    }

    @GetMapping("/api/review")
    public List<Review> getAll(){
        return repo.findAll();
    }
}
