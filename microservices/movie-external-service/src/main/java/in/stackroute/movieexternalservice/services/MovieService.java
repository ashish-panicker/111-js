package in.stackroute.movieexternalservice.services;

import java.util.List;
import javax.naming.directory.SearchResult;
import in.stackroute.movieexternalservice.dto.getbyid.Movie;
import in.stackroute.movieexternalservice.dto.search.SearchReponse;

public interface MovieService {
    
    SearchReponse findMovies(String movieName);

    Movie findMovieById(Long id);
}
