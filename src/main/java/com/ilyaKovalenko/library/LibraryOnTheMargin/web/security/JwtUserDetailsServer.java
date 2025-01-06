package com.ilyaKovalenko.library.LibraryOnTheMargin.web.security;

import com.ilyaKovalenko.library.LibraryOnTheMargin.repository.UserRepository;
import lombok.Data;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.ilyaKovalenko.library.LibraryOnTheMargin.domain.user.User;

import java.util.NoSuchElementException;

@Service
@Data
public class JwtUserDetailsServer implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = new User();
        try{
            user = userRepository.findByUsername(username).orElseThrow(() -> new NoSuchElementException("Couldn't find such user by username"));
        }catch (Exception e){
            throw new NoSuchElementException(e.getMessage());
        }

        return JwtEntityFactory.create(user);
    }
}
