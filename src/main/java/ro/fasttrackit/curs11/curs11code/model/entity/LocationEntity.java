package ro.fasttrackit.curs11.curs11code.model.entity;

import lombok.Builder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Builder
@Document(collection = "locations")
public record LocationEntity(
        @Id
        String locationId,
        @Indexed(unique = true)
        String city
) {
}
