package ro.fasttrackit.curs11.curs11code.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ro.fasttrackit.curs11.curs11code.service.MethodLevelService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("method")
@RequiredArgsConstructor
public class MethodLevelController {
    private final MethodLevelService service;

    @GetMapping("allowAdmin")
    SecurityContext allowAdmin() {
        System.out.println("-----------+");
        return service.allowAdmin();
    }

    @GetMapping("allowUser")
    @Secured({"WRITE"})
    SecurityContext allowUserRead() {
        return SecurityContextHolder.getContext();
    }

    @GetMapping("preauthorize/allowAdmin")
    SecurityContext preAllowAdmin() {
        return service.preAllowAdmin();
    }

    @GetMapping("preauthorize/bean")
    @PreAuthorize("@myPermissionService.authorize(#value, authentication)")
    SecurityContext beanAuthorization(@RequestParam(required = false) String value) {
        return SecurityContextHolder.getContext();
    }

    @GetMapping("preauthorize/param")
    @PreAuthorize("#please ==  true")
    SecurityContext paramAuthorization(@RequestParam(required = false) boolean please) {
        return SecurityContextHolder.getContext();
    }

    @GetMapping("postauthorize")
    @PostAuthorize("returnObject.msg() == 'OK'")
    Result postAuthorize() {
        return new Result("OK");
    }

    @GetMapping("prefilter")
    List<String> preFilter(@RequestParam List<String> elements) {
        System.out.println(elements);
        return service.prefilter(elements);
    }

    @GetMapping("postfilter")
    @PostFilter("filterObject.username== authentication.principal.username")
    List<Grade> postFilter() {
        return new ArrayList<>(List.of(
                new Grade("mongoadmin", 5),
                new Grade("test", 7),
                new Grade("mongouser", 9),
                new Grade("mongoadmin", 5),
                new Grade("Ana", 3),
                new Grade("mongouser", 10),
                new Grade("mongoadmin", 10)
        ));
    }

}

record Grade(String username, int grade) {
}

record Result(String msg) {
}
