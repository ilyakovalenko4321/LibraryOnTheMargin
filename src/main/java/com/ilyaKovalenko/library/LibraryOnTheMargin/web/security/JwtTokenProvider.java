package com.ilyaKovalenko.library.LibraryOnTheMargin.web.security;

import com.ilyaKovalenko.library.LibraryOnTheMargin.repository.AuthRepository;
import com.ilyaKovalenko.library.LibraryOnTheMargin.service.Props.JwtTokenProps;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import lombok.Data;
import org.apache.logging.log4j.CloseableThreadContext;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import io.jsonwebtoken.Claims;

import javax.crypto.SecretKey;
import java.security.Key;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Data
public class JwtTokenProvider {

    private final JwtTokenProps props;
    private Key key;
    private final UserDetailsService userDetailsService;
    private final AuthRepository authRepository;

    @PostConstruct
    private void init(){
        this.key = Keys.hmacShaKeyFor(props.getSecretKey().getBytes());
    }

    public String createToken(UUID id, String username){

        Claims claims = Jwts.claims()
                .subject(username)
                .add("id", id)
                .build();

        Instant validity = Instant.now().plus(props.getValidity(), ChronoUnit.SECONDS);

        String token =  Jwts.builder()
                .claims(claims)
                .signWith(key)
                .expiration(Date.from(validity))
                .compact();
        authRepository.createToken(token, validity);
        return token;
    }

    public boolean validateToken(String token){
        Jws<Claims> claimsJws = Jwts.parser().verifyWith((SecretKey) key).build().parseSignedClaims(token);
        return claimsJws.getPayload().getExpiration().after(new Date());
    }

    private String getUsername(String token){
        return Jwts.parser().verifyWith((SecretKey) key).build().parseSignedClaims(token).getPayload().getSubject();
    }

    public Authentication getAuthentication(String token){
        String username = getUsername(token);
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        return new UsernamePasswordAuthenticationToken(userDetails, "", List.of());
    }

}
