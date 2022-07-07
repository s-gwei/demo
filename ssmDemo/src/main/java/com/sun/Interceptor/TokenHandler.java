package com.sun.Interceptor;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Component
@Slf4j
public class TokenHandler implements HandlerInterceptor {

	
	private  final Logger logger = LoggerFactory.getLogger(TokenHandler.class);
	@Override
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
	
//    public UserDTO selectIsExistUserInfo(String phone) {
//        //TODO 伪代码 验证用户信息 
//        UserDTO info = 查询用户信息
//        if (info != null) {
//            String token = TokenUtil.sign(info.getUsername(), info.getUserId(), 6 * 60 * 60 * 1000);
//            info.setToken(token);
//        }
//        return info;
//    }
}
