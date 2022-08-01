package in.stackroute.movieexternalservice.services;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import in.stackroute.movieexternalservice.dto.getbyid.Movie;
import in.stackroute.movieexternalservice.dto.search.SearchReponse;

@Service
public class MovieServiceImpl implements MovieService {

    private RestTemplate restTemplate;

    public MovieServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    private static final String API_KEY = "75d707e753725ec14d9e86a41db18f38";
    private static final String BASE_URL = "https://api.themoviedb.org/3/";
    private static final String SEARCH_MOVIE_BY_NAME = BASE_URL
            + "/search/movie?api_key={apiKey}&language=en-US&query={query}&page=1&include_adult=false";
    private static final String GET_MOVIE_BY_ID =
            BASE_URL + "/movie/{id}?api_key={apiKey}&language=en-US";

            // HTTP GET https:// api.themoviedb.org/3/movie/75d707e753725ec14d9e86a41db18f38?api_key=121&language=en-US
            // HTTP GET
            // https://api.themoviedb.org/3/movie/121?api_key=75d707e753725ec14d9e86a41db18f38&language=en-US

    @Override
    public SearchReponse findMovies(String movieName) {
        return restTemplate.getForObject(SEARCH_MOVIE_BY_NAME, SearchReponse.class, API_KEY,
                movieName);
    }

    @Override
    public Movie findMovieById(Long id) {
        return restTemplate.getForObject(GET_MOVIE_BY_ID, Movie.class, id, API_KEY);
    }


}
