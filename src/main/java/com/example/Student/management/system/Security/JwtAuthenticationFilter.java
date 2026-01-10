package com.example.Student.management.system.Security;

import com.example.Student.management.system.Repository.UserRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;


@Component
//This class extracts the username from the JWT token, loads the user from the database,
// and tells Spring Security that this user is authenticated for this request.
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private UserRepository userRepository;
    private UserDetailsServiceImpl userDetailsServiceImpl;

    public JwtAuthenticationFilter(UserRepository userRepository, UserDetailsServiceImpl userDetailsServiceImpl) {
        this.userRepository = userRepository;
        this.userDetailsServiceImpl = userDetailsServiceImpl;
    }

    @Override
    //This method doFilterInternal runs for EVERY request that comes to your backend
    protected void doFilterInternal(HttpServletRequest request
            , HttpServletResponse response
            , FilterChain filterChain) throws ServletException, IOException {

        String authHeader= request.getHeader("Authorization");

        if (authHeader !=null && authHeader.startsWith("Bearer ")) {
            String jwt = authHeader.substring(7);
            String username= JwtService.extractUsername(jwt);

            UserDetails userDetails = userDetailsServiceImpl.loadUserByUsername(username);

            UsernamePasswordAuthenticationToken authToken =
                    new UsernamePasswordAuthenticationToken(
                            userDetails, null, userDetails.getAuthorities());

            SecurityContextHolder.getContext().setAuthentication(authToken);
        }

        filterChain.doFilter(request,response);
    }


}
