package com.ilyaKovalenko.library.LibraryOnTheMargin.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Optional;

@Repository
public class AuthRepository {

    private final JdbcTemplate jdbcTemplate;

    public AuthRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Transactional
    public void deleteExpiredTokens(LocalDateTime currentTime) {
        String sql = "DELETE FROM tokens WHERE expired_time <= ?";
        jdbcTemplate.update(sql, currentTime);
    }

    public Optional<String> findToken(String token) {
        String sql = "SELECT token FROM tokens WHERE token = ?";
        return jdbcTemplate.query(sql, rs -> rs.next() ? Optional.of(rs.getString("token")) : Optional.empty(), token);
    }

    @Transactional
    public void createToken(String token, Instant expirationDate) {
        String sql = "INSERT INTO tokens (token, expired_time) VALUES (?, ?)";
        LocalDateTime expirationDateTime = LocalDateTime.ofInstant(expirationDate, ZoneId.systemDefault());
        jdbcTemplate.update(sql, token, expirationDateTime);
    }
}
