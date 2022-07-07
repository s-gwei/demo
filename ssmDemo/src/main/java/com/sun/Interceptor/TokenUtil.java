package com.sun.Interceptor;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class TokenUtil {
	
	    //Token的过期时间
		private static final long EXPIRE_TIME = 30 * 60 * 1000;
		//Token的私钥
		private static final String TOKEN_SECRET = "jytoken_secret";
		
		
		/**
		 * 生成签名，30分钟过期
		 * @param **userInfo**	用户信息 用户姓名
		 * @param **other** 用户其他信息 用户id
		 * @return
		 */
		public static String sign(String userInfo, String other) {
		    try {
		    	// 设置过期时间
		    	Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);
		    	//私钥和加密算法
		        Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
		        // 设置头部信息
		        Map<String, Object> header = new HashMap<>(2);
		        header.put("Type", "Jwt");
		        header.put("alg", "HS256");
		        // 返回token字符串
		        return JWT.create()
		                .withHeader(header)
		                .withClaim("userInfo", userInfo)
		                .withClaim("other", other)
		                .withExpiresAt(date)
		                .sign(algorithm);
		    } catch (Exception e) {
		        e.printStackTrace();
		        return null;
		    }
		}
		
		/**
		 * 生成签名，30分钟过期
		 * @param **userInfo**	用户信息 用户姓名
		* @param **other** 用户其他信息 用户id
		* @return
		 */
		public static String sign(String userInfo, String other,long expire) {
		    try {
		    	// 设置过期时间
		    	Date date = new Date(System.currentTimeMillis() + expire);
		    	//私钥和加密算法
		        Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
		        // 设置头部信息
		        Map<String, Object> header = new HashMap<>(2);
		        header.put("Type", "Jwt");
		        header.put("alg", "HS256");
		        // 返回token字符串
		        return JWT.create()
		                .withHeader(header)
		                .withClaim("userInfo", userInfo)
		                .withClaim("other", other)
		                .withExpiresAt(date)
		                .sign(algorithm);
		    } catch (Exception e) {
		        e.printStackTrace();
		        return null;
		    }
		}
		
		
		/**
		 * 检验token是否正确
		 * @param **token**
		* @return
		 */
		public static boolean verify(String token){
		    try {
		        Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
		        JWTVerifier verifier = JWT.require(algorithm).build();
		        verifier.verify(token);//未验证通过会抛出异常
		        return true;
		    } catch (Exception e){
		        return false;
		    }
		}
		
		/**
		 * 从token中获取info信息
		 * @param **token**
		* @return
		 */
		public static String getUserName(String token,String info){
		    try {
		        DecodedJWT jwt = JWT.decode(token);
		        return jwt.getClaim(info).asString();
		    } catch (JWTDecodeException e){
		        e.printStackTrace();
		    }
		    return null;
		}
		

}
