package org.alan.flightbooking.filter;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.filter.GenericFilterBean;

public class JwtFilter extends GenericFilterBean {

    private static final ThreadLocal<Claims> userClaims = new ThreadLocal<>();

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException, IOException {
        final HttpServletRequest request = (HttpServletRequest) servletRequest;
        final HttpServletResponse response = (HttpServletResponse) servletResponse;
        final String authHeader = request.getHeader("authorization");

        if ("OPTIONS".equals(request.getMethod())) {
            response.setStatus(HttpServletResponse.SC_OK);
            filterChain.doFilter(request, response);
            return;
        }

        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            throw new ServletException("Missing or invalid Authorization header");
        }

        final String token = authHeader.substring(7);

        try {
            Claims claims = Jwts.parser()
                    .setSigningKey("secret")
                    .parseClaimsJws(token)
                    .getBody();
            userClaims.set(claims);
            request.setAttribute("claims", claims);
        } catch (Exception e) {
            throw new ServletException("Invalid token");
        }

        filterChain.doFilter(request, response);
    }

    public static Claims getUserClaims() {
        return userClaims.get();
    }

    public static void clear() {
        userClaims.remove();
    }
}
