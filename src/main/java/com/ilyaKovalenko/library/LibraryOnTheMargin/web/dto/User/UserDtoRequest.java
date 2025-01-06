package com.ilyaKovalenko.library.LibraryOnTheMargin.web.dto.User;

import com.ilyaKovalenko.library.LibraryOnTheMargin.web.dto.markers.OnCreate;
import com.ilyaKovalenko.library.LibraryOnTheMargin.web.dto.markers.OnUpdate;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.UUID;

@Data
public class UserDtoRequest {


    private UUID id;

    @NotNull(groups = OnCreate.class)
    private String name;

    @NotNull(groups = {OnCreate.class, OnUpdate.class})
    private String username;

    @Email(groups = OnCreate.class)
    private String email;

    @NotNull(groups = {OnCreate.class, OnUpdate.class})
    private String password;

    @NotNull(groups = OnCreate.class)
    private String passwordConfirmation;

}
