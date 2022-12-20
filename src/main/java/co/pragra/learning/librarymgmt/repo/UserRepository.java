package co.pragra.learning.librarymgmt.repo;

import co.pragra.learning.librarymgmt.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
}
