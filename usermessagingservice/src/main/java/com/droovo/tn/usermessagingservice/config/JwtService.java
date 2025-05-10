package com.droovo.tn.usermessagingservice.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
<<<<<<< HEAD
import com.droovo.tn.usermessagingservice.Entites.Utilisateur;
=======
import com.droovo.tn.usermessagingservice.Entites.UserDetail;
>>>>>>> rebuild

import java.security.Key;
import java.util.Date;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtService {
    private static final String SECRET_KEY = "cxd8+rn4lIWl3XHGUsR5q8sbXk04BYKtPakDhd4CGYYVcdantBGMYCoZj5zvBlehJVBrh52vsnL5L/1B6FMhklMX2McIPv/Sz6I/e2cRQlXYlxgcymQGb8X+Fvz43rU8+/SPXsafX9qeTL8HeNlzVY4lLSKS4dcPdKE7dlWXrTWkrazKVXMqFP7Xt3bs4dIK7YKfARJyPRPEpEf+XzADf4qlmwvEwlOpsN/KnUmZXfbEEvroptPZ2rSmWaSpl0MD5gCbYcrV89Et4huEq9wSi7c5DxeRL3RNDEsK2rR6jTWcVclpDQqr1LRU/cPYRvZPuTOfIaz/AOH9JercQnqKLSM3O3hNoaBkqjMuo+haNf8";
    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }
    //is Token valid
    public boolean isTokenValid(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    //is Token expired or not expired
    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }
    //extract expiration date from token string
    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    //generate token with user details as parameter
<<<<<<< HEAD
    public String generateToken(Utilisateur userDetails) {
=======
    public String generateToken(UserDetail userDetails) {
>>>>>>> rebuild
        return generateToken(Map.of(), userDetails);
    }
    //generate token with extra claims and user details as parameter
    public String generateToken(
            Map<String, Object> extraClaims,
<<<<<<< HEAD
            Utilisateur userDetails
=======
            UserDetail userDetails
>>>>>>> rebuild
    ) {
        return Jwts
                .builder()
                .setClaims(extraClaims)
                .setId(userDetails.getId().toString())
                .claim("role", userDetails.getType())
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
<<<<<<< HEAD
                  .addClaims( Map.of("user_id",((Utilisateur) userDetails).getId().toString() ))
=======
                  .addClaims( Map.of("user_id",((UserDetail) userDetails).getId().toString() ))
>>>>>>> rebuild
                //10 hours
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
                .signWith(getSigningKey(), SignatureAlgorithm.HS256)
                .compact();
    }
    public <T> T extractClaim(String token, Function<Claims,T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }
    private Claims extractAllClaims(String token) {
        return Jwts
                //to pars the builder
                .parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    //get the key to sign the token
    private Key getSigningKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        //Algorithm to sign the key
        return Keys.hmacShaKeyFor(keyBytes);

    }
}
