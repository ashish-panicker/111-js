package in.stackroute.movieuserservice.service;

import java.util.Date;
import org.springframework.stereotype.Service;
import in.stackroute.movieuserservice.domain.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class JWTSecurityServiceImpl implements SecurityService{
    
    @Override
    public String generateToken(User user) {
        return Jwts.builder()
                .setSubject(user.getUserName())
                .setIssuedAt(new Date())
                .claim("userId", user.getUserId())
                .claim("userName", user.getUserName())
                .claim("email", user.getEmail())
                .signWith(SignatureAlgorithm.HS256, "secretkey")
                .compact();
    }

    @Override
    public void validateToken(String token) {
        Jws<Claims> parseClaimsJws = Jwts.parser().setSigningKey("secretkey").parseClaimsJws(token);
        Claims body = parseClaimsJws.getBody();
        if(body.getExpiration().before(new Date())){
            throw new RuntimeException("Token expired");
        }
    }
    
}
