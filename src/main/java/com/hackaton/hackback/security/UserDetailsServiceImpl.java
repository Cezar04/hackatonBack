package com.hackaton.hackback.security;

import com.hackaton.hackback.security.token.ConfirmationTokenService;
import com.hackaton.hackback.user.UserDetailsImpl;
import com.hackaton.hackback.user.UserModel;
import com.hackaton.hackback.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    ConfirmationTokenService confirmationTokenService;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserModel user =userRepository.findByUsername(username)
                .orElseThrow(()->new UsernameNotFoundException("UserNot Found with username"+ username));
        return UserDetailsImpl.build(user);
    }

    public int enableAppUser(String email) {
        return userRepository.enableAppUser(email);
    }
}
