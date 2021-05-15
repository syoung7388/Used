package com.used.example.config;

import static org.hamcrest.CoreMatchers.containsStringIgnoringCase;

import java.io.UnsupportedEncodingException;
import java.security.Key;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

import java.util.HashMap;
import java.util.Map;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import com.used.example.domain.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Header;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import lombok.RequiredArgsConstructor;


@Component
@RequiredArgsConstructor
public class JwtUtils {

	private static final String jwtSecret = "scretsuyoung"; //jwt비밀키 생성
	
	private static final long jwtExpirationMs = 864000;//만료 시간
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
    
	//토큰 만드는 과정
	public String generateJwtToken(Authentication authentication) {

		User user = (User)authentication.getPrincipal();

		
		JwtBuilder builder = Jwts.builder()
				.setHeader(CreateHeader())
				.setSubject(user.getUsername())			
				.setClaims(CreateClaims(user))
				.setExpiration(CreateTime())
				.signWith(SignatureAlgorithm.HS256, CreatSecretKey());

		
		return builder.compact();
		
		
		
	}
	
	private Key  CreatSecretKey() {
		byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(jwtSecret); 
		
		return new SecretKeySpec(apiKeySecretBytes, SignatureAlgorithm.HS256.getJcaName());

	}
	
	

	private static Date CreateTime() {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DATE, 30);
		System.out.println("4(시간):"+c.getTime());
		return c.getTime();
	}



	private static Map<String, Object> CreateClaims(User user) {
		
		Map<String, Object> claims_map = new HashMap<String, Object>();
		claims_map.put("username", user.getUsername());
		claims_map.put("role", user.getAuthorities());
		
		return claims_map;
	}

	private static Map<String,Object> CreateHeader() {
		
		Map<String, Object> header  = new HashMap<>();
		
		header.put("typ", "JWT");
		header.put("alg", "HS256");
		header.put("regDate", System.currentTimeMillis());
		
		return header;
	}
	 
	 //이토큰 괜찮은거 맞아??!!!
	public boolean validateJwtToken(String authToken) {
		try {
			
			Claims claims = getClaimsFromToken(authToken);
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



	private static Claims getClaimsFromToken(String authToken) {
	

		return Jwts.parser().setSigningKey(DatatypeConverter.parseBase64Binary(jwtSecret)) .parseClaimsJws(authToken).getBody();

		
	}
	
	public static String getUserEmailFromToken(String token) {
		
		Claims claims = getClaimsFromToken(token);
		return (String)claims.get("username");
	}
	
	public static String getRoleFromToken(String token) {
		Claims claims = getClaimsFromToken(token);
		return (String)claims.get("username");
	}
	
	
	
}	