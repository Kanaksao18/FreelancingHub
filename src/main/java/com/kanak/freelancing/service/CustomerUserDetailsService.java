package com.kanak.freelancing.service;

import com.kanak.freelancing.entity.User;
import com.kanak.freelancing.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerUserDetailsService implements UserDetailsService {

    private UserRepository userRepository;

   @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       User user = userRepository.findByEmail(username)
               .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));

       return org.springframework.security.core.userdetails.User.builder()
               .username(user.getEmail())
               .password(user.getPassword())
               .roles(user.getRole().name())
               .build();
   }
}
