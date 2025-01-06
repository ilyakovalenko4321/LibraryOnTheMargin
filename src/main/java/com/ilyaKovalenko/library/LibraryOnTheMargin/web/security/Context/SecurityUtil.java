package com.ilyaKovalenko.library.LibraryOnTheMargin.web.security.Context;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class SecurityUtil {

    public static UUID getCurrentUserId() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getDetails() instanceof String) {
            return UUID.fromString((String) authentication.getDetails());
        }
        throw new IllegalStateException("UserId not found in security context");
    }

}
