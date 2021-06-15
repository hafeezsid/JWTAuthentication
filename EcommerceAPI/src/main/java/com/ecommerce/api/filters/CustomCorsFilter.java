package com.ecommerce.api.filters;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Component
public class CustomCorsFilter {

	
	/*
	 * @Bean public CorsFilter corsFilter() { CorsConfiguration configuration=new
	 * CorsConfiguration(); configuration.setAllowCredentials(true);
	 * configuration.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
	 * configuration.setAllowedHeaders(Arrays.asList("Origin",
	 * "Access-Control-Allow-Origin","Content-Type",
	 * "Access-Control-Reuqest-Method","Access-Control-Request-Headers,",
	 * "Accept","Authorization","Origin, Accept","X-Requested-With"));
	 * configuration.setExposedHeaders(Arrays.asList("Origin",
	 * "Access-Control-Allow-Origin","Content-Type",
	 * "Access-Control-Reuqest-Method","Access-Control-Request-Headers,",
	 * "Accept","Authorization"));
	 * configuration.setAllowedMethods(Arrays.asList("GET","POST","PUT","POST",
	 * "DELETE","OPTIONS"));
	 * 
	 * UrlBasedCorsConfigurationSource basedCorsConfigurationSource=new
	 * UrlBasedCorsConfigurationSource();
	 * basedCorsConfigurationSource.registerCorsConfiguration("/**", configuration);
	 * return new CorsFilter(basedCorsConfigurationSource);
	 * 
	 * }
	 */
	 
	@Bean
	   public WebMvcConfigurer corsConfigurer() {
	      return new WebMvcConfigurerAdapter() {
	         @Override
	         public void addCorsMappings(CorsRegistry registry) {
	            registry.addMapping("/**")
	            .allowedOrigins("*")
	            .allowedHeaders("Origin",
	            		 "Access-Control-Allow-Origin","Content-Type","Access-Control-Reuqest-Method",
	            		 "Access-Control-Request-Headers,",
	            		 "Accept","Authorization","Origin, Accept","X-Requested-With")
	            .allowedMethods("POST", "PUT", "GET", "OPTIONS", "DELETE")
	            .exposedHeaders("Origin", "Access-Control-Allow-Origin","Content-Type",
	            		"Access-Control-Reuqest-Method","Access-Control-Request-Headers,",	 "Accept","Authorization")
	            ;
	         }
	      };
	   }
}
