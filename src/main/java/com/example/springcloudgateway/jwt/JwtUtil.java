package com.example.springcloudgateway.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import jakarta.xml.bind.DatatypeConverter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Slf4j
public class JwtUtil {
    @Value("${spring.jwt.secret}")
    String secretKey;

    public boolean isValidToken(String token) {
        // TODO Auto-generated method stub
        token = token.replace("Bearer ", "");
        System.out.println("token :: " + token);
        try {
            Claims accessClaims = getClaimsFormToken(token);
            System.out.println("accessClaims is : " + accessClaims);
            System.out.println("Access expireTime: " + accessClaims.getExpiration());
            System.out.println("Access email: " + accessClaims.get("sub"));
		    return !accessClaims.getExpiration().before(new Date());
//            return "success";
        } catch (ExpiredJwtException exception) {
            System.out.println("Token Expired UserID : " + exception.getClaims().getSubject());
//            return "expired";
            return false;
        } catch (JwtException exception) {
            System.out.println("Token Tampered");
//            return "tampered";
            return false;
        } catch (NullPointerException exception) {
            System.out.println("Token is null");
            return false;
//            return "null";
        }
    }

    Claims getClaimsFormToken(String token) {
        // TODO Auto-generated method stub
        return Jwts.parser()
                .setSigningKey(DatatypeConverter.parseBase64Binary("secretKey"))
                .parseClaimsJws(token)
                .getBody();
    }
}
