package ro.fasttrackit.curs11.curs11code.service;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class MyPermissionService {
    public boolean authorize(String value, Authentication authentication) {
        return value.length() > 5;
    }
}
