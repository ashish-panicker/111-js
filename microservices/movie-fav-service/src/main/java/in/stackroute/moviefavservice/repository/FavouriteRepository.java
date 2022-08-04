package in.stackroute.moviefavservice.repository;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import in.stackroute.moviefavservice.domain.Favourite;

public interface FavouriteRepository extends MongoRepository<Favourite, String> {

    @Query("{'userName': ?0}")
    public List<Favourite> findByUserName(String userName);

}
