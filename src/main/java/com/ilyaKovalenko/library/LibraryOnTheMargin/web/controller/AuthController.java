package com.ilyaKovalenko.library.LibraryOnTheMargin.web.controller;

import com.ilyaKovalenko.library.LibraryOnTheMargin.domain.user.User;
import com.ilyaKovalenko.library.LibraryOnTheMargin.service.Props.ScheduledProps;
import com.ilyaKovalenko.library.LibraryOnTheMargin.service.UserAuthenticationService;
import com.ilyaKovalenko.library.LibraryOnTheMargin.web.dto.Jwt.JwtRequest;
import com.ilyaKovalenko.library.LibraryOnTheMargin.web.dto.Jwt.JwtResponse;
import com.ilyaKovalenko.library.LibraryOnTheMargin.web.dto.User.UserDtoRequest;
import com.ilyaKovalenko.library.LibraryOnTheMargin.web.dto.User.UserDtoResponse;
import com.ilyaKovalenko.library.LibraryOnTheMargin.web.dto.markers.OnCreate;
import com.ilyaKovalenko.library.LibraryOnTheMargin.web.mapper.UserMapper;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth/")
public class AuthController {

    private final UserMapper userMapper;
    private final UserAuthenticationService authenticationService;
    private final ScheduledProps scheduledProps;

    @PostMapping("/register")
    public UserDtoResponse register(@RequestBody @Validated(OnCreate.class) UserDtoRequest userDtoRequest){
        User user = userMapper.toEntity(userDtoRequest);
        authenticationService.create(user);
        return userMapper.toDto(user);
    }

    @GetMapping("/login")
    public JwtResponse login(@RequestBody JwtRequest jwtRequest){
        return authenticationService.login(jwtRequest);
    }

    @Scheduled(fixedRateString = "#{scheduledProps.jwtTokenCheck}")
    public void testTokenValidity(){
        authenticationService.deleteExpiredTokens();
    }

}
