package ro.fasttrackit.curs11.curs11code.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.CriteriaDefinition;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import ro.fasttrackit.curs11.curs11code.model.TrainFilter;
import ro.fasttrackit.curs11.curs11code.model.entity.TrainEntity;

import java.util.List;

import static java.util.Optional.ofNullable;

@Service
@RequiredArgsConstructor
public class TrainsService {
    private final MongoTemplate mongo;
    private final LocationService locationService;


    public List<TrainEntity> getAll(TrainFilter trainFilter) {
        return mongo.find(Query.query(toCriteria(trainFilter)), TrainEntity.class);
    }

    private CriteriaDefinition toCriteria(TrainFilter trainFilter) {
        Criteria result = new Criteria();
        ofNullable(trainFilter.model())
                .ifPresent(model -> result.and("model").is(model));
        if (trainFilter.minCarts() != null || trainFilter.maxCarts() != null) {
            Criteria cartsCriteria = result.and("carts");
            ofNullable(trainFilter.minCarts())
                    .ifPresent(cartsCriteria::gte);
            ofNullable(trainFilter.maxCarts())
                    .ifPresent(cartsCriteria::lte);
        }

        ofNullable(trainFilter.city())
                .ifPresent(cities -> result.and("locationId").in(locationService.getCityIds(cities)));

        return result;
    }
}
