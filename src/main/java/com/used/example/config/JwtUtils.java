package com.used.example.config;

import java.util.Date;

import java.util.HashMap;
import java.util.Map;
import javax.xml.bind.DatatypeConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import com.used.example.domain.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import lombok.RequiredArgsConstructor;


@Component
@RequiredArgsConstructor
public class JwtUtils {

	private static final String jwtSecret = "lcomputerstudyexample"; //jwt비밀키 생성
	
	private static final int jwtExpirationMs = 864000;//만료 시간
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
    
	//토큰 만드는 과정
	public String generateJwtToken(Authentication authentication) {

		User user = (User) authentication.getPrincipal(); // 현재 이용중인 사용자 정보를 가져오는 방법

		return Jwts.builder()
				.setSubject((user.getUsername()))
				.setIssuedAt(new Date())
				.setExpiration(new Date((new Date()).getTime() + jwtExpirationMs))
				.signWith(SignatureAlgorithm.HS512, jwtSecret)
				.compact();
	}
	
	//토큰으로 부터 username 빼내기
	public String getUserNameFromJwtToken(String token) {
		return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
	}
	 
	
	//토큰으로 부터 payload 즉 Body꺼내기
	 private static Claims getClaimsFormToken(String token) {
        return (Claims) Jwts.parser().setSigningKey(DatatypeConverter.parseBase64Binary(jwtSecret))
        		.parseClaimsJws(token).getBody();
    }
	 
	 
	 //위의 2개 클래스를 이용하여 username꺼내기
	 public static String getUserEmailFromToken(String token) {
	        Claims claims = getClaimsFormToken(token);
	        Map<String, Object> map = new HashMap<>(claims);
	        String username = (String) map.get("sub");
	        
	        return username;
	    }
	 
	 //이토큰 괜찮은거 맞아??!!!
	public boolean validateJwtToken(String authToken) {
		try {
			Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
			return true;
		} catch (SignatureException e) {
			logger.error("Invalid JWT signature: {}", e.getMessage());
		} catch (MalformedJwtException e) {
			logger.error("Invalid JWT token: {}", e.getMessage());
		} catch (ExpiredJwtException e) {
			logger.error("JWT token is expired: {}", e.getMessage());
		} catch (UnsupportedJwtException e) {
			logger.error("JWT token is unsupported: {}", e.getMessage());
		} catch (IllegalArgumentException e) {
			logger.error("JWT claims string is empty: {}", e.getMessage());
		}

		return false;
	}
	
}	