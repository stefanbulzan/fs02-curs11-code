package ro.fasttrackit.curs11.curs11code.controller;

import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    @GetMapping("permit")
    SecurityContext permit() {
        return SecurityContextHolder.getContext();
    }

    @GetMapping("me")
    SecurityContext me() {
        return SecurityContextHolder.getContext();
    }

    @GetMapping("onlyAdmin")
    SecurityContext onlyAdmin() {
        return SecurityContextHolder.getContext();
    }

    @GetMapping("onlyRead")
    SecurityContext onlyRead(){
        return SecurityContextHolder.getContext();
    }

    @GetMapping("onlyManage")
    SecurityContext onlyManage(){
        return SecurityContextHolder.getContext();
    }

    @GetMapping("readOrWriteNotAdmin")
    SecurityContext readOrWriteNotAdmin(){
        return SecurityContextHolder.getContext();
    }
}
