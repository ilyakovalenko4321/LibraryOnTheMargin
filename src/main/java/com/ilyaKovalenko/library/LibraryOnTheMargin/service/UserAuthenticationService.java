package com.ilyaKovalenko.library.LibraryOnTheMargin.service;

import com.ilyaKovalenko.library.LibraryOnTheMargin.domain.user.User;
import com.ilyaKovalenko.library.LibraryOnTheMargin.web.dto.Jwt.JwtRequest;
import com.ilyaKovalenko.library.LibraryOnTheMargin.web.dto.Jwt.JwtResponse;

public interface UserAuthenticationService {

    void create(User user);

    JwtResponse login(JwtRequest jwtRequest);

    void deleteExpiredTokens();
}
