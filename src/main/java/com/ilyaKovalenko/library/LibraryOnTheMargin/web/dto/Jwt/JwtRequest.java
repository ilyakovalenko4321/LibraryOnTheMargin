package com.ilyaKovalenko.library.LibraryOnTheMargin.web.dto.Jwt;

import lombok.Data;

import java.util.UUID;

@Data
public class JwtRequest {

    private UUID id;
    private String username;
    private String password;

}
