package in.stackroute.movieuserservice.service;

import java.util.Optional;
import in.stackroute.movieuserservice.domain.User;

public interface UserService {
    
    public User saveUser(User user);
    
    public Optional<User> getUserByUserName(String userName);
    
    public Optional<User> getUserByUserNameAndPassword(String userName, String password);
        
}
