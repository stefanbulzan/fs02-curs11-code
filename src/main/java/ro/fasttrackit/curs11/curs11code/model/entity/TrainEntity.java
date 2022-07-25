package ro.fasttrackit.curs11.curs11code.model.entity;

import lombok.Builder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Builder
@Document(collection = "trains")
public record TrainEntity(
        @Id
        String trainId,
        String model,
        int carts,
        String locationId
) {
}
