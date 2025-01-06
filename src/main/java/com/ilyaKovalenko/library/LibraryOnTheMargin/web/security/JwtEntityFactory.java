package com.ilyaKovalenko.library.LibraryOnTheMargin.web.security;

import com.ilyaKovalenko.library.LibraryOnTheMargin.domain.user.User;

public class JwtEntityFactory {

    public static JwtEntity create(User user){
        return new JwtEntity(user.getId(), user.getName(), user.getUsername(), user.getPassword());
    }

}
