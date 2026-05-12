package com.bank.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import javax.crypto.SecretKey;
import java.util.Date;

@Service
public class JwtService {

    @Value("${jwt.secret}")
    private String SECRET;

    // مدة صلاحية الـ token — ساعة واحدة
    private static final long EXPIRATION_MS = 1000 * 60 * 60 ;

    // توليد token جديد للمستخدم
    public String generateToken(String username) {
        return Jwts.builder()
                .subject(username)
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + EXPIRATION_MS))
                .signWith(getKey())
                .compact();
    }

    // استخراج اسم المستخدم من الـ token
    public String extractUsername(String token) {
        return getClaims(token).getSubject();
    }

    // التحقق من صحة الـ token
    public boolean isValid(String token, String username) {
        return extractUsername(token).equals(username)
                && !isExpired(token);
    }

    // التحقق من انتهاء صلاحية الـ token
    private boolean isExpired(String token) {
        return getClaims(token).getExpiration().before(new Date());
    }

    // قراءة محتوى الـ token
    private Claims getClaims(String token) {
        return Jwts.parser()
                .verifyWith(getKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    // تحويل الـ SECRET لمفتاح تشفير
    private SecretKey getKey() {
        return Keys.hmacShaKeyFor(SECRET.getBytes());
    }
}
