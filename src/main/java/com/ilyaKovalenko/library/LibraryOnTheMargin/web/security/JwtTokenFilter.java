package com.ilyaKovalenko.library.LibraryOnTheMargin.web.security;

import com.ilyaKovalenko.library.LibraryOnTheMargin.repository.AuthRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.security.core.Authentication;
import org.springframework.web.filter.GenericFilterBean;

import java.io.IOException;
import java.nio.file.AccessDeniedException;

@Service
@RequiredArgsConstructor
public class JwtTokenFilter extends GenericFilterBean {

    private final JwtTokenProvider tokenProvider;
    private final AuthRepository authRepository;


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        try {
            String bearerToken = request.getHeader("Authorization");
            if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
                bearerToken = bearerToken.substring(7);
            }
            if (bearerToken != null && tokenProvider.validateToken(bearerToken)) {
                if(authRepository.findToken(bearerToken).isEmpty()){
                    throw new AccessDeniedException("You'r token not present in our list");
                }
                Authentication authentication = tokenProvider.getAuthentication(bearerToken);
                if (authentication != null) {
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                }
            }
            filterChain.doFilter(request, response);
        } catch (Exception e) {
            // Установка статуса ответа и возвращение сообщения об ошибке
            response.setContentType("application/json");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED); // HTTP статус 401
            response.getWriter().write("{\"error\": \"" + e.getMessage() + "\"}");
        }
    }
}
