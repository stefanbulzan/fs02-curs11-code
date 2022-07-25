package ro.fasttrackit.curs11.curs11code.service;

import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import ro.fasttrackit.curs11.curs11code.model.entity.LocationEntity;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LocationService {
    private final MongoTemplate mongo;

    public List<String> getCityIds(List<String> cities) {
        return mongo.findDistinct(
                        Query.query(Criteria.where("city").in(cities)),
                        "locationId",
                        LocationEntity.class,
                        ObjectId.class).stream()
                .map(ObjectId::toString)
                .toList();
    }
}
