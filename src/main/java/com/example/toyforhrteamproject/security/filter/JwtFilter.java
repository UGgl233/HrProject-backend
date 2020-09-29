package com.example.toyforhrteamproject.security.filter;

import com.example.toyforhrteamproject.constant.Constant;
import com.example.toyforhrteamproject.security.util.JwtUtil;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {

//        String username = JwtUtil.getSubject(httpServletRequest, Constant.JWT_TOKEN_COOKIE_NAME, Constant.SIGNING_KEY);
//        if(username == null){
////            String authService = this.getFilterConfig().getInitParameter("services.auth");
//            httpServletResponse.sendError(HttpServletResponse.SC_FORBIDDEN);
////            httpServletResponse.sendRedirect(authService + "?redirect=" + httpServletRequest.getRequestURL());
//        } else{
//            httpServletRequest.setAttribute("username", username);
//            filterChain.doFilter(httpServletRequest, httpServletResponse);
//        }
    }
}
