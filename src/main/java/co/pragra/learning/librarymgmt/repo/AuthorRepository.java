package co.pragra.learning.librarymgmt.repo;

import co.pragra.learning.librarymgmt.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author,Integer> {
}
