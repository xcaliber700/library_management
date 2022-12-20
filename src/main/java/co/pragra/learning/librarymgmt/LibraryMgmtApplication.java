package co.pragra.learning.librarymgmt;

import co.pragra.learning.librarymgmt.entity.Author;
import co.pragra.learning.librarymgmt.entity.Book;
//import co.pragra.learning.librarymgmt.repo.AuthorRepo;
//import co.pragra.learning.librarymgmt.repo.BookRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Collections;
import java.util.Date;

@SpringBootApplication
public class LibraryMgmtApplication {

//    private BookRepo repo;
//    private AuthorRepo authorRepo;
//
//    public LibraryMgmtApplication(BookRepo repo, AuthorRepo authorRepo) {
//        this.repo = repo;
//        this.authorRepo = authorRepo;
//    }

    public static void main(String[] args) {
        SpringApplication.run(LibraryMgmtApplication.class, args);
    }
//
//    @Bean
//    CommandLineRunner runner(){
//        return args -> {
////            repo.createSchema();
////            repo.create(Book.builder()
////                            .id(2)
////                            .isbn("ISBN2883736")
////                            .category("Programming-2")
////                            .author(Author.builder().id(2).name("Ashish").build())
////                            .publishDate(new Date())
////                            .createDate(new Date())
////                            .title("Awesome Spring and winters")
////                    .build());
////            repo.create(Book.builder()
////                    .id(3)
////                    .isbn("ISBN2883737")
////                    .category("Programming-3")
////                    .author(Author.builder().id(3).name("Prabh").build())
////                    .publishDate(new Date())
////                    .createDate(new Date())
////                    .title("As you like it")
////                    .build());
//            System.out.println(repo.getAll(Collections.emptyMap()));
//            System.out.println(repo.getById(2));
//        };
//    }
}
