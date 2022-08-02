package in.stackroute.movieuserservice.service;

import in.stackroute.movieuserservice.domain.User;
import in.stackroute.movieuserservice.dto.LoginResponseDto;
import in.stackroute.movieuserservice.dto.ValidationResponseDto;

public interface SecurityService {
    
    String generateToken(User user);

    ValidationResponseDto validateToken(String token);
}
