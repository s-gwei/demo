package com.sun.Interceptor;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Slf4j
public class JwtInterceptor implements HandlerInterceptor {

	private  final Logger logger = LoggerFactory.getLogger(TokenHandler.class);
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)  throws Exception {
		 
        String token = request.getHeader("Authentication");
        if (token != null){
            boolean result = TokenUtil.verify(token);
            if(result){
            	logger.info("通过拦截器");
                return true;
            }
        }
        logger.info("认证失败");
        
        return false;
   }
}
