package in.stackroute.moviefavservice.service;

import java.util.List;
import java.util.Optional;
import in.stackroute.moviefavservice.domain.Favourite;

public interface FavouriteService {
    
    public List<Favourite> getAllFavourites(String userName);
    
    public Optional<Favourite> getFavouriteById(String id);
    
    public Favourite createFavourite(Favourite favourite);
    
    public Favourite updateFavourite(Favourite favourite);
    
    public void deleteFavourite(String id);
    
}
