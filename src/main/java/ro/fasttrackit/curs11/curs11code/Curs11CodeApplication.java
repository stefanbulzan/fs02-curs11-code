package ro.fasttrackit.curs11.curs11code;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ro.fasttrackit.curs11.curs11code.model.entity.LocationEntity;
import ro.fasttrackit.curs11.curs11code.model.entity.TrainEntity;
import ro.fasttrackit.curs11.curs11code.model.security.MyUser;
import ro.fasttrackit.curs11.curs11code.repository.LocationRepository;
import ro.fasttrackit.curs11.curs11code.repository.MyUserRepository;
import ro.fasttrackit.curs11.curs11code.repository.TrainRepository;

import java.util.List;
import java.util.UUID;

@SpringBootApplication
public class Curs11CodeApplication {

    public static void main(String[] args) {
        SpringApplication.run(Curs11CodeApplication.class, args);
    }

    CommandLineRunner addUsers(MyUserRepository repo) {
        return args -> repo.saveAll(List.of(
                new MyUser(UUID.randomUUID().toString(), "admin", "admin", "Oradea", List.of("ROLE_ADMIN", "READ", "WRITE")),
                new MyUser(UUID.randomUUID().toString(), "user", "user", "Cluj", List.of("ROLE_ADMIN", "READ", "WRITE"))
        ));
    }

    CommandLineRunner atStartup(TrainRepository trainRepository,
                                LocationRepository locationRepository) {
        return args -> {
            trainRepository.save(TrainEntity.builder()
                    .trainId(UUID.randomUUID().toString())
                    .model("Cluj 1988")
                    .carts(10)
                    .locationId(locationRepository.save(new LocationEntity(UUID.randomUUID().toString(), "Oradea")).locationId())
                    .build());
            trainRepository.save(TrainEntity.builder()
                    .trainId(UUID.randomUUID().toString())
                    .model("Sageata")
                    .carts(3)
                    .locationId(locationRepository.save(new LocationEntity(UUID.randomUUID().toString(), "Timisoara")).locationId())
                    .build());
        };
    }
}
