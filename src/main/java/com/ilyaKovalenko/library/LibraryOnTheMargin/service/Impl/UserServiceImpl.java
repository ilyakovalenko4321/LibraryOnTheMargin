package com.ilyaKovalenko.library.LibraryOnTheMargin.service.Impl;

import com.ilyaKovalenko.library.LibraryOnTheMargin.domain.exceptions.NoSuchResourceException;
import com.ilyaKovalenko.library.LibraryOnTheMargin.domain.user.User;
import com.ilyaKovalenko.library.LibraryOnTheMargin.repository.UserRepository;
import com.ilyaKovalenko.library.LibraryOnTheMargin.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    @Transactional(readOnly = true)
    public User getByUsername(String username) {
        return userRepository.findByUsername(username).orElseThrow(() -> new NoSuchElementException("F'u"));
    }
}
