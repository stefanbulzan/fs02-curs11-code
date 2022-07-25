package ro.fasttrackit.curs11.curs11code.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ro.fasttrackit.curs11.curs11code.model.entity.TrainEntity;

public interface TrainRepository extends MongoRepository<TrainEntity, String> {
}
