package com.bogus.carrental.security;

import com.bogus.carrental.database.ClientRepository;
import com.bogus.carrental.database.EmployeeRepository;
import com.bogus.carrental.model.Client;
import com.bogus.carrental.model.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class SecurityService implements UserDetailsService {

    private final ClientRepository clientRepository;
    private final EmployeeRepository employeeRepository;


    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {


        Client client = clientRepository.findByName(name);
        if (client != null) {
            return new UserDetailsImpl() {
                @Override
                public Collection<? extends GrantedAuthority> getAuthorities() {
                    return Collections.singleton(new SimpleGrantedAuthority("CLIENT"));
                }

                @Override
                public Long getId() {
                    return client.getId();
                }

                @Override
                public String getPassword() {
                    return client.getPassword();
                }

                @Override
                public String getUsername() {
                    return client.getName();
                }

                @Override
                public boolean isAccountNonExpired() {
                    return true;
                }

                @Override
                public boolean isAccountNonLocked() {
                    return true;
                }

                @Override
                public boolean isCredentialsNonExpired() {
                    return true;
                }

                @Override
                public boolean isEnabled() {
                    return true;
                }

            };
        } else {
            Employee employee = employeeRepository.findByName(name);
            if (employee != null) {
                return new UserDetailsImpl() {
                    @Override
                    public Collection<? extends GrantedAuthority> getAuthorities() {
                        return Collections.singleton(new SimpleGrantedAuthority(employee.getPosition().toString()));
                    }

                    @Override
                    public Long getId() {
                        return employee.getId();
                    }

                    @Override
                    public String getEmail() {
                        return employee.getEmail();
                    }

                    @Override
                    public String getPassword() {
                        return employee.getPassword();
                    }

                    @Override
                    public String getUsername() {
                        return employee.getName();
                    }

                    @Override
                    public boolean isAccountNonExpired() {
                        return true;
                    }

                    @Override
                    public boolean isAccountNonLocked() {
                        return true;
                    }

                    @Override
                    public boolean isCredentialsNonExpired() {
                        return true;
                    }

                    @Override
                    public boolean isEnabled() {
                        return true;
                    }
                };
            } else throw new NoSuchElementException(name);
        }
    }
}




