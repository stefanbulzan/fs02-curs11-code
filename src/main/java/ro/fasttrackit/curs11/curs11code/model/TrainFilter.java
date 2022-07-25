package ro.fasttrackit.curs11.curs11code.model;

import lombok.Builder;

import java.util.List;

@Builder
public record TrainFilter(
        String model,
        Integer minCarts,
        Integer maxCarts,
        List<String> city
) {
}
