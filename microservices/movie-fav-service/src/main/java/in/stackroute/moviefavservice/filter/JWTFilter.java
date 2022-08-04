package in.stackroute.moviefavservice.filter;

import java.io.IOException;
import java.util.Map;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;
import in.stackroute.moviefavservice.dto.IdentityResponse;
import in.stackroute.moviefavservice.service.UserService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class JWTFilter extends GenericFilterBean {

    private UserService userService;

    public JWTFilter(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
            FilterChain chain) throws IOException, ServletException {



        log.debug("msg: {}", "JWTFilter");
        
        log.debug("FILTER");
        final HttpServletRequest request = (HttpServletRequest) servletRequest;
        final HttpServletResponse response = (HttpServletResponse) servletResponse;
        final String authHeader = request.getHeader("Authorization");
        
        if ("OPTIONS".equals(request.getMethod())) {
            response.setStatus(HttpServletResponse.SC_OK);
            
            log.debug("msg: {}", "JWTFilter - OPTIONS");
            chain.doFilter(request, response);
        }
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            throw new ServletException("Missing or invalid Authorization header");
        }
        final String token = authHeader.substring(7);
        final IdentityResponse tokenResponse = userService.validateToken(token);
        if (!tokenResponse.isValid()) {
            response.setContentType("text/json");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().write(Map
                    .of("message", "Invalid token", "status", HttpStatus.UNAUTHORIZED).toString());
            return;
        }
        log.debug("msg {}", "JWTFilter - done");
        chain.doFilter(request, response);


    }
}
