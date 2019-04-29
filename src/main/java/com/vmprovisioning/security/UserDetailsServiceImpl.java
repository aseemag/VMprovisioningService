package com.vmprovisioning.security;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.vmprovisioning.exceptions.UserAuthorizationException;
import com.vmprovisioning.models.Users;
import com.vmprovisioning.repository.UserRepository;
import static java.util.Collections.emptyList;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private UserRepository applicationUserRepository;

    public UserDetailsServiceImpl(UserRepository applicationUserRepository) {
        this.applicationUserRepository = applicationUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users applicationUser = applicationUserRepository.findByName(username);
        if (applicationUser == null) {
            throw new UserAuthorizationException("Invalid User Credentials");
        }
        return new User(applicationUser.getName(), applicationUser.getPassword(), emptyList());
    }
}
