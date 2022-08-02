package in.stackroute.movieuserservice.service;

import java.util.Optional;
import org.springframework.stereotype.Service;
import in.stackroute.movieuserservice.domain.User;
import in.stackroute.movieuserservice.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public Optional<User> getUserByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }

    @Override
    public Optional<User> getUserByUserNameAndPassword(String userName, String password) {
        return userRepository.findByUserNameAndPassword(userName, password);
    }

}
