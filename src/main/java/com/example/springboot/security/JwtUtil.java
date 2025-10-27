package com.example.springboot.security;

import io.jsonwebtoken.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class JwtUtil {

    // Clave secreta — en producción deberías poner algo mucho más seguro y externo
    private final String SECRET = "mi_clave_secreta";

    // 5 horas de expiración
    private final long EXPIRATION_TIME = 1000 * 60 * 60 * 5;

    // Genera token con claim "roles"
    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());
        claims.put("roles", roles);
        return generateToken(claims, userDetails.getUsername());
    }

    private String generateToken(Map<String, Object> claims, String subject) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS256, SECRET.getBytes())
                .compact();
    }

    // ✅ Nuevo: renueva token cuando está expirado
    public String refreshToken(String token) {
        try {
            Claims claims = getClaims(token);
            if (claims == null) {
                return null; // token inválido
            }
            return generateToken(claims, claims.getSubject());
        } catch (Exception e) {
            return null;
        }
    }

    // Extrae username (subject)
    public String extractUsername(String token) {
        Claims claims = getClaims(token);
        return claims != null ? claims.getSubject() : null;
    }

    // Extrae roles
    public List<String> extractRoles(String token) {
        Claims claims = getClaims(token);
        if (claims == null) return List.of();

        Object rolesObj = claims.get("roles");
        if (rolesObj instanceof List<?>) {
            return ((List<?>) rolesObj).stream()
                    .filter(obj -> obj instanceof String)
                    .map(obj -> (String) obj)
                    .collect(Collectors.toList());
        }
        return List.of();
    }

    // Valida token y lo renueva si hace falta
    public String validateOrRefreshToken(String token, UserDetails userDetails) {
        String username = extractUsername(token);
        if (username != null && username.equals(userDetails.getUsername())) {
            if (!isTokenExpired(token)) {
                return token; // token válido
            } else {
                // Si está expirado, lo renovamos automáticamente
                return refreshToken(token);
            }
        }
        return null; // inválido
    }

    // Verifica si expiró
    private boolean isTokenExpired(String token) {
        Claims claims = getClaims(token);
        if (claims == null) return true;
        Date expiration = claims.getExpiration();
        return expiration.before(new Date());
    }

    // Obtiene claims incluso si el token está expirado
    private Claims getClaims(String token) {
        try {
            return Jwts.parser()
                    .setSigningKey(SECRET.getBytes())
                    .parseClaimsJws(token)
                    .getBody();
        } catch (ExpiredJwtException e) {
            // ⚠️ Lo devolvemos aunque esté expirado, para poder renovarlo
            return e.getClaims();
        } catch (JwtException e) {
            return null;
        }
    }
}
