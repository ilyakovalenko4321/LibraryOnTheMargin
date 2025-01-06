package com.ilyaKovalenko.library.LibraryOnTheMargin.web.dto.Jwt;

import lombok.Data;

import java.util.UUID;

@Data
public class JwtResponse {

    private String username;
    private String accessToken;

}
