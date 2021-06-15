package com.ecommerce.api.constants;

public class SecurityConstant {
	
	public static final long EXPIRATION_TIME= 900000; // 60 * 1000
	public static final String TOKEN_PREFIX= "Bearer ";
	public static final String TOKEN_ISSUER= "Organic Farm LTD";
	public static final String JWT_TOKEN_HEADER="Jwt-Token";
	public static final String TOKEN_NOT_VERRIFIED_MESSAGE="Token cannot be verified";
	public static final String ACCESS_DENIED_MESSAGE="You do not have access to this page.";
	public static final String FORBIDDEN_MESSAGE="Forbidden error. Please login";
	public static final String OPTION_HTTP_METHOD="Options";
	public static final String AUTORITIES="authorities";
	public static final String [] PUBLIC_URLS= {"/user/login","/user/register","/user/resetPassword/**"};
	

}
