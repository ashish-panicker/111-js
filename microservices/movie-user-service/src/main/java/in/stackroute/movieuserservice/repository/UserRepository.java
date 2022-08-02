package in.stackroute.movieuserservice.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import in.stackroute.movieuserservice.domain.User;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByUserName(String userName);
    
    Optional<User> findByUserNameAndPassword(String userName, String password);


    
}
