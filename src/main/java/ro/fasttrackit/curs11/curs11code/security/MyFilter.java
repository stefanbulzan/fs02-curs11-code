package ro.fasttrackit.curs11.curs11code.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Slf4j
@Component
public class MyFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        if (servletRequest instanceof HttpServletRequest request) {
            log.info("Received request for " + request.getRequestURI());
            filterChain.doFilter(servletRequest, servletResponse);
            log.info("Done with request for " + request.getRequestURI());
        }
    }
}
