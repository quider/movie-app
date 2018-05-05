package app.movie.controller;

import app.movie.model.Movie;
import app.movie.services.MovieService;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/movies")
public class MovieController {

    private MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping
    public void insertMovie(@RequestBody Movie movie){
        this.movieService.insertMovie(movie);
    }

    @PutMapping
    public void updateMovie(@RequestBody Movie movie){
        this.movieService.updateMovie(movie);
    }

    @DeleteMapping
    public void deleteMovie(@RequestBody String id){
        this.movieService.deleteMovie(id);
    }
}
