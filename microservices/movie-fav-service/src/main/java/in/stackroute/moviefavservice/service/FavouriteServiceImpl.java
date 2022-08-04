package in.stackroute.moviefavservice.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import in.stackroute.moviefavservice.domain.Favourite;
import in.stackroute.moviefavservice.repository.FavouriteRepository;

@Service
public class FavouriteServiceImpl implements FavouriteService {

    private FavouriteRepository favoriteRepository;

    public FavouriteServiceImpl(FavouriteRepository favoriteRepository) {
        this.favoriteRepository = favoriteRepository;
    }

    @Override
    public List<Favourite> getAllFavourites(String userName) {
        return favoriteRepository.findByUserName(userName);
    }

    @Override
    public Optional<Favourite> getFavouriteById(String id) {
        return favoriteRepository.findById(id);
    }

    @Override
    public Favourite createFavourite(Favourite favourite) {
        return favoriteRepository.save(favourite);
    }

    @Override
    public Favourite updateFavourite(Favourite favourite) {
        return favoriteRepository.save(favourite);
    }

    @Override
    public void deleteFavourite(String id) {
        favoriteRepository.deleteById(id);
    }


}
