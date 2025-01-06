package com.ilyaKovalenko.library.LibraryOnTheMargin.service.Impl;

import com.ilyaKovalenko.library.LibraryOnTheMargin.domain.user.User;
import com.ilyaKovalenko.library.LibraryOnTheMargin.repository.AuthRepository;
import com.ilyaKovalenko.library.LibraryOnTheMargin.repository.UserRepository;
import com.ilyaKovalenko.library.LibraryOnTheMargin.service.UserAuthenticationService;
import com.ilyaKovalenko.library.LibraryOnTheMargin.service.UserService;
import com.ilyaKovalenko.library.LibraryOnTheMargin.web.dto.Jwt.JwtRequest;
import com.ilyaKovalenko.library.LibraryOnTheMargin.web.dto.Jwt.JwtResponse;
import com.ilyaKovalenko.library.LibraryOnTheMargin.web.security.JwtEntity;
import com.ilyaKovalenko.library.LibraryOnTheMargin.web.security.JwtTokenProvider;
import com.ilyaKovalenko.library.LibraryOnTheMargin.web.security.JwtUserDetailsServer;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class UserAuthenticationServiceImpl implements UserAuthenticationService {

    private final UserRepository userRepository;
    private final UserService userService;
    private final JwtTokenProvider jwtTokenProvider;
    private final PasswordEncoder passwordEncoder;
    private final AuthRepository authRepository;

    @Override
    @Transactional
    public void create(User user) {
        String password = passwordEncoder.encode(user.getPassword());
        user.setPassword(password);
        userRepository.save(user);
    }

    @Override
    @Transactional
    public JwtResponse login(JwtRequest jwtRequest) {
        JwtResponse jwtResponse = new JwtResponse();
        User loadedUser = userService.getByUsername(jwtRequest.getUsername());
        String token = jwtTokenProvider.createToken(loadedUser.getId() ,loadedUser.getUsername());
        jwtResponse.setUsername(jwtRequest.getUsername());
        jwtResponse.setAccessToken(token);
        return jwtResponse;
    }

    @Transactional
    public void deleteExpiredTokens(){
        authRepository.deleteExpiredTokens(LocalDateTime.now());
    }
}
