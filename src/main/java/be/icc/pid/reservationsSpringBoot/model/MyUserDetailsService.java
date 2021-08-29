package be.icc.pid.reservationsSpringBoot.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


    @Service
    public class MyUserDetailsService implements UserDetailsService {
        @Autowired
        UserRepository userRepository;

        @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {

                User user = userRepository.findByLogin(login);
                return new MyUserDetails(user);
            }

    }

