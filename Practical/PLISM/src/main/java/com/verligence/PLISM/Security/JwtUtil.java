package com.verligence.PLISM.Security;

import java.util.Date;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.*;

@Component
public class JwtUtil {

    private final String SECRET_KEY = "phyLabInvSys";

    public String generateToken(String username) {
        return Jwts.builder().setSubject(username).setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY).compact();
    }

    public String extractUsername(String token) {

        try {
            return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody().getSubject();
        } catch (JwtException | IllegalArgumentException e) {
            throw new IllegalStateException("Invalid or expired token", e);
        }

    }

    public boolean validateToken(String token, String username) {
        try {
            String doneUsername = extractUsername(token);
            return (username.equals(doneUsername) && !isTokenExpired(token));
        } catch (IllegalStateException e) {
            return false;
        }
    }

    private boolean isTokenExpired(String token) {
        try {
            Date expiration = Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody().getExpiration();
            return expiration.before(new Date());
        } catch (JwtException | IllegalArgumentException e) {
            throw new IllegalStateException("Invalid token", e);
        }
    }
}
