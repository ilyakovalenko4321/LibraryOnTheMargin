package com.ilyaKovalenko.library.LibraryOnTheMargin.web.mapper;

import com.ilyaKovalenko.library.LibraryOnTheMargin.domain.user.User;
import com.ilyaKovalenko.library.LibraryOnTheMargin.web.dto.User.UserDtoRequest;
import com.ilyaKovalenko.library.LibraryOnTheMargin.web.dto.User.UserDtoResponse;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class UserMapper {

    // Конвертируем из User в UserDtoResponse
    @Transactional(readOnly = true)
    public UserDtoResponse toDto(User user) {
        if (user == null) {
            return null;
        }

        UserDtoResponse response = new UserDtoResponse();
        response.setId(user.getId());
        response.setName(user.getName());
        response.setUsername(user.getUsername());
        response.setEmail(user.getEmail());
        return response;
    }

    // Конвертируем из UserDtoRequest в User
    @Transactional(readOnly = true)
    public User toEntity(UserDtoRequest dtoRequest) {
        if (dtoRequest == null) {
            return null;
        }

        User user = new User();
        // Не устанавливаем ID, оно будет автоматически сгенерировано
        user.setName(dtoRequest.getName());
        user.setUsername(dtoRequest.getUsername());
        user.setEmail(dtoRequest.getEmail());
        user.setPassword(dtoRequest.getPassword());
        user.setCreatedAt(java.time.LocalDateTime.now()); // Добавляем текущую дату

        // password можно назначить по аналогии, если хотите
        return user;
    }

}
