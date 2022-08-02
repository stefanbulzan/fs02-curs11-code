package ro.fasttrackit.curs11.curs11code.security;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;

//@Component
public class MyAuthenticationProvider implements AuthenticationProvider {
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        if (String.valueOf(authentication.getPrincipal()).startsWith("sudo")) {
            return new UsernamePasswordAuthenticationToken("altuser", null, List.of(new SimpleGrantedAuthority("ROLE_admin")));
        } else {
            return null;
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return true;
//        return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
    }
}
