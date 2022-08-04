package in.stackroute.moviefavservice.service;

import in.stackroute.moviefavservice.dto.IdentityResponse;

public interface UserService {
    
    public IdentityResponse validateToken(String token);
}
