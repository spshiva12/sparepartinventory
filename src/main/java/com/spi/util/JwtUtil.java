package com.spi.util;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.spi.entity.User;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;


@Component
public class JwtUtil {
	
//	 private String secret = "mysecretkey";
	 private static final String SECRET_KEY = "your-secret-key";

	    public String extractToken(HttpServletRequest request) {
	        String token = request.getHeader("Authorization");
	        if (StringUtils.hasText(token) && token.startsWith("Bearer ")) {
	            return token.substring(7);
	        }
	        return null;
	    }

	    public User parseToken(String token) {
	        Claims body = Jwts.parser()
	                .setSigningKey(SECRET_KEY)
	                .parseClaimsJws(token)
	                .getBody();

	        User user = new User();
	        user.setUsername(body.getSubject());
	        user.setId(Long.parseLong((String) body.get("userId")));
	        user.setRoles((String) body.get("roles"));

	        return user;
	    }
	    
	    public static boolean validateToken(String token) {
	        try {
	            Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token);
	            return true;
	        } catch (JwtException | IllegalArgumentException e) {
	            return false;
	        }
	    }

	    public static String generateToken(User user) {
	        Claims claims = Jwts.claims().setSubject(user.getUsername());
	        claims.put("userId", user.getId().toString());
	        claims.put("roles", user.getRoles());

	        return Jwts.builder()
	                .setClaims(claims)
	                .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
	                .compact();
	    }

}
