package com.ilyaKovalenko.library.LibraryOnTheMargin.web.dto.User;

import lombok.Data;

import java.util.UUID;

@Data
public class UserDtoResponse {

    private UUID id;

    private String name;

    private String username;

    private String email;
}
