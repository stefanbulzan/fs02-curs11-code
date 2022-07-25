package ro.fasttrackit.curs11.curs11code.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ro.fasttrackit.curs11.curs11code.model.entity.LocationEntity;

import java.util.List;

public interface LocationRepository extends MongoRepository<LocationEntity, String> {
    List<LocationEntity> findIdByCityIn(List<String> cities);
}
