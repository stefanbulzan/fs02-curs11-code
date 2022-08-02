package ro.fasttrackit.curs11.curs11code.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.access.prepost.PreFilter;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MethodLevelService {

    @RolesAllowed("ADMIN")
    public SecurityContext allowAdmin() {
        return SecurityContextHolder.getContext();
    }

    @PreAuthorize("hasRole('ADMIN') OR (hasRole('USER') AND hasAuthority('WRITE'))")
    public SecurityContext preAllowAdmin() {
        return SecurityContextHolder.getContext();
    }

    @PreFilter("filterObject.startsWith('A')")
    public List<String> prefilter(List<String> elements) {
        return elements;
    }
}
