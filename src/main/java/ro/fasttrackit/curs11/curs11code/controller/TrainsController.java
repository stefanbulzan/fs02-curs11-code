package ro.fasttrackit.curs11.curs11code.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.fasttrackit.curs11.curs11code.model.TrainFilter;
import ro.fasttrackit.curs11.curs11code.model.entity.TrainEntity;
import ro.fasttrackit.curs11.curs11code.service.TrainsService;

import java.util.List;

@RestController
@RequestMapping("trains")
@RequiredArgsConstructor
public class TrainsController {
    private final TrainsService service;

    @GetMapping
    List<TrainEntity> getAll(TrainFilter trainFilter) {
        return service.getAll(trainFilter);
    }
}
