package app.movie.controller;

import app.movie.model.Movie;
import app.movie.model.Review;
import app.movie.services.MovieService;
import org.springframework.data.domain.Sort;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/movies")
public class MovieController {

    private MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/all")
    public List<Movie> getAllMovies(){
        Sort sortByRating = new Sort(Sort.Direction.DESC, "ratings");
        List<Movie> movies = movieService.getAllMovies(sortByRating);
        for (Movie movie:movies)
        {
            List<Review> acceptedReviews = movie.getReviews().stream().filter(r->r.isAccepted()).collect(Collectors.toList());
            movie.setReviews(acceptedReviews);
        }return movies;
    }

    @PostMapping
    public void insertMovie(@RequestBody @Valid Movie movie, BindingResult bindingResult){
        if (bindingResult.hasErrors())
            throw new TitleException();
        this.movieService.insertMovie(movie);
    }

    @PutMapping
    public void updateMovie(@RequestBody Movie movie){
        this.movieService.updateMovie(movie);
    }

    @DeleteMapping("/{id}")
    public void deleteMovie(@PathVariable String id){
        this.movieService.deleteMovie(id);
    }
}
