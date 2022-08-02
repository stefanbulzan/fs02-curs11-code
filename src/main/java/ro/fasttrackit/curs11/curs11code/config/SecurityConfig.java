package ro.fasttrackit.curs11.curs11code.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CsrfFilter;
import ro.fasttrackit.curs11.curs11code.security.MyFilter;

@Configuration
@EnableGlobalMethodSecurity(jsr250Enabled = true, securedEnabled = true, prePostEnabled = true)
public class SecurityConfig {
    @Bean
    SecurityFilterChain httpSecurityConfig(HttpSecurity http) throws Exception {
        http.addFilterBefore(new MyFilter(), CsrfFilter.class)
                .authorizeHttpRequests(
                        authz -> authz
                                .mvcMatchers(HttpMethod.GET, "/students/**").hasRole("USER")
                                .mvcMatchers(HttpMethod.POST, "/students/**").hasRole("ADMIN")
                                .mvcMatchers(HttpMethod.DELETE, "/students/**").hasRole("ADMIN")
                                .mvcMatchers("/permit").permitAll()
                                .mvcMatchers("/trains").authenticated()
                                .mvcMatchers("/onlyAdmin").hasRole("ADMIN")
                                .mvcMatchers("/onlyRead").hasAnyAuthority("READ")
                                .mvcMatchers("/onlyManage").hasAnyAuthority("MANAGE")
                                .antMatchers("/readOrWriteNotAdmin").hasAnyAuthority("READ", "WRITE")
                                .mvcMatchers("/me").authenticated()
                                .anyRequest().authenticated()
                )
                .formLogin()
                .and()
                .httpBasic();
        return http.build();
    }
}
