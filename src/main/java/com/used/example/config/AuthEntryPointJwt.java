package com.used.example.config;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

@Component
public class AuthEntryPointJwt implements AuthenticationEntryPoint {
	
	//logger는 콘솔창에 뭐가 문제인지 에러를 띄우기 위해서 사용//여기서는 그 에러가 401임
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	//응답에 401에러를 보내는 과정 
	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException, ServletException {
		
		logger.error("Unauthorized error: {}", authException.getMessage());
		
		response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Error: Unauthorized");
	}
}