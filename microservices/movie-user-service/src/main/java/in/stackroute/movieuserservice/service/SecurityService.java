package in.stackroute.movieuserservice.service;

import in.stackroute.movieuserservice.domain.User;

public interface SecurityService {
    
    String generateToken(User user);

    void validateToken(String token);
}
