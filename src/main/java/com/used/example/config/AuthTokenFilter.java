package com.used.example.config;




import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import com.used.example.service.UserService;

//import com.used.example.service.UserService;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public class AuthTokenFilter extends  OncePerRequestFilter{

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	@Autowired
	private JwtUtils jwtUtils;
	
	@Autowired
	private UserService userService;
	
	
	
	//request의 헤더에서 Authorization 가져오고 가공한다. //아래에서 사용함
	private String parseJwt(HttpServletRequest request) {
		
		String token = request.getHeader("access_token");
		logger.info("token:"+token);
		
		if(StringUtils.hasText(token) && token.startsWith("Bearer") ) {
			token= token.substring(7, token.length());
			return token;
		}

//		logger.info("왜 널이야??");
		return null;
	}
	
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain )
									throws ServletException, IOException{
		
		try {
			
			String jwt = parseJwt(request);

			
			
			if(jwt != null && jwtUtils.validateJwtToken(jwt)) {//
				
				String username= jwtUtils.getUserEmailFromToken(jwt);
				
				UserDetails userDetails= userService.loadUserByUsername(username);
				
				logger.info("userDetail:"+userDetails);
			
				
				
				UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
							userDetails, null, userDetails.getAuthorities());
				
				authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				
				SecurityContextHolder.getContext().setAuthentication(authentication);///???
				

			}
		} catch (Exception e) {
			logger.error("사용자의 authentication을 설정할수 없습니다: {}", e);
		}
		
		filterChain.doFilter(request, response);

	}
	



}