package com.zerock.mallapi.security.filter;

import com.google.gson.Gson;
import com.zerock.mallapi.util.JWTUtil;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.parameters.P;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

public class JWTCheckFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authHeader = request.getHeader("Authorization");

        try {
            String accessToken = authHeader.substring(7);
            Map<String, Object> claims = JWTUtil.validateToken(accessToken);
            filterChain.doFilter(request,response);
        } catch (Exception e) {
            Gson gson = new Gson();

            String jsonStr = gson.toJson(Map.of("error", "ACCESS_TOKEN_ERROR"));

            response.setContentType("application/json; charset=UTF-8");
            PrintWriter printWriter = response.getWriter();
            printWriter.println(jsonStr);
            printWriter.close();
        }


        filterChain.doFilter(request, response);
    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
        if (request.getMethod().equals("OPTIONS")) {
            return true;
        }
        String path = request.getRequestURI();
        if (path.startsWith("/api/member")) {
            return true;
        }

        if (path.startsWith("/api/products/view/")) {
            return true;
        }

        return false;
    }
}
