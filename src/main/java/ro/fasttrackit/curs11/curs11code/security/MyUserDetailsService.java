package ro.fasttrackit.curs11.curs11code.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ro.fasttrackit.curs11.curs11code.model.security.MyUserDetails;
import ro.fasttrackit.curs11.curs11code.repository.MyUserRepository;

@Service
@RequiredArgsConstructor
public class MyUserDetailsService implements UserDetailsService {
    private final MyUserRepository repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repo.findByUsername(username)
                .map(myuser -> new MyUserDetails(myuser.username(), myuser.password(), myuser.roles()))
                .orElseThrow(() -> new UsernameNotFoundException("Invalid credentials"));
    }
}


