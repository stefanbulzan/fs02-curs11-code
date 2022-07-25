package ro.fasttrackit.curs11.curs11code.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Bean
    SecurityFilterChain httpSecurityConfig(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(
                        authz -> authz
                                .mvcMatchers("/permit").permitAll()
                                .mvcMatchers("/trains").authenticated()
                                .mvcMatchers("/me").authenticated()
                                .anyRequest().denyAll()
                )
                .formLogin()
                .and()
                .httpBasic();
        return http.build();
    }
}
