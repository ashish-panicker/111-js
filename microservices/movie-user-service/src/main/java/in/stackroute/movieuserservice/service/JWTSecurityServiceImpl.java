package in.stackroute.movieuserservice.service;

import java.util.Date;
import javax.security.auth.Subject;
import org.springframework.stereotype.Service;
import in.stackroute.movieuserservice.domain.User;
import in.stackroute.movieuserservice.dto.LoginResponseDto;
import in.stackroute.movieuserservice.dto.ValidationResponseDto;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class JWTSecurityServiceImpl implements SecurityService {

    private UserService userService;

    public JWTSecurityServiceImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String generateToken(User user) {
        return Jwts.builder().setSubject(user.getUserName()).setIssuedAt(new Date())
                .claim("userId", user.getUserId()).claim("userName", user.getUserName())
                .claim("email", user.getEmail()).signWith(SignatureAlgorithm.HS256, "secretkey")
                .compact();
    }

    @Override
    public ValidationResponseDto validateToken(String token) {
        String subject = "";
        try {
            Jws<Claims> parseClaimsJws =
                    Jwts.parser().setSigningKey("secretkey").parseClaimsJws(token.substring(7));
            Claims body = parseClaimsJws.getBody();
            subject = body.getSubject();
            User user=  userService.getUserByUserName(subject).orElseThrow();
            return new ValidationResponseDto(user.getUserName(), true);
        } catch (Exception e) {
            return new ValidationResponseDto(subject,  false);
        }

    }

}
