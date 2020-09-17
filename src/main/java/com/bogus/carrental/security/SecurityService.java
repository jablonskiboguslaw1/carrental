package com.bogus.carrental.security;

import com.bogus.carrental.database.UserRepository;
import com.bogus.carrental.model.Employee;
import com.bogus.carrental.model.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SecurityService implements UserDetailsService {

    private final UserRepository<UserEntity> userRepository;
    private final BCryptPasswordEncoder PasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        UserEntity user = userRepository.findByName(name).orElseThrow();
        SimpleGrantedAuthority authority;
        if (user instanceof Employee) {
            authority = new SimpleGrantedAuthority(((Employee) user).getPosition().toString());
        } else {
            authority = new SimpleGrantedAuthority("CLIENT");
        }
        return new User(
                user.getName(),
                user.getPassword(),
                List.of(authority));
    }
}

