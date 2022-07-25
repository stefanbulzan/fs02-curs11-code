package ro.fasttrackit.curs11.curs11code.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ro.fasttrackit.curs11.curs11code.model.security.MyUser;

import java.util.Optional;

public interface MyUserRepository extends MongoRepository<MyUser, String> {
    Optional<MyUser> findByUsername(String username);
}
