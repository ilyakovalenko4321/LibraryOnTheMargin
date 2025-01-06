package com.ilyaKovalenko.library.LibraryOnTheMargin.service;

import com.ilyaKovalenko.library.LibraryOnTheMargin.domain.user.User;

public interface UserService {

    User getByUsername(String username);

}
