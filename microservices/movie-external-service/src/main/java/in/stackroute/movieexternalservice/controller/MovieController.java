package in.stackroute.movieexternalservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import in.stackroute.movieexternalservice.dto.getbyid.Movie;
import in.stackroute.movieexternalservice.dto.search.SearchReponse;
import in.stackroute.movieexternalservice.services.MovieService;

@RestController
@RequestMapping("/movies")
public class MovieController {
    
    private MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/search/id/{id}")
    public Movie findMovieById(@PathVariable Long id) {
        return movieService.findMovieById(id);
    }

    @GetMapping("/search/name/{name}")
    public SearchReponse findMovieByName(@PathVariable String name) {
        return movieService.findMovies(name);
    }
}
