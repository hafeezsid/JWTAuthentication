package com.example.demo.filters;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.demo.exceptionHandler.CustomException;
import com.example.demo.model.ExceptionResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class ExceptionHandlerFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		 try {
	            filterChain.doFilter(request, response);

	        }  catch (RuntimeException e) {
	            e.printStackTrace();
	            setErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, response, e);
	       
		
	}

}
	 public void setErrorResponse(HttpStatus status, HttpServletResponse response, Throwable ex){
	        response.setStatus(status.value());
	        response.setContentType("application/json");
	        ExceptionResponse excp=new ExceptionResponse();
	        excp.setMessage(ex.getMessage());
	        excp.setErrorCode("Server Error while Filtering request");
	        excp.setExceptionTime(LocalDateTime.now());
			ObjectMapper objMap=new ObjectMapper();
			try {
				response.getWriter().write(objMap.writeValueAsString(excp));
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
			catch (IOException e) {
				e.printStackTrace();
			}
	    }
}
