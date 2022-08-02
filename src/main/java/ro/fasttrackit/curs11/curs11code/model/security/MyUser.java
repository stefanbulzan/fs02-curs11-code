package ro.fasttrackit.curs11.curs11code.model.security;

import lombok.Builder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document("users")
@Builder
public record MyUser(
        @Id
        String userId,
        @Indexed(unique = true)
        String username,
        String password,
        String city,
        List<String> roles
) {
}
