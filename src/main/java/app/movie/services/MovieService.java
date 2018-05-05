package app.movie.services;

import app.movie.model.Movie;
import app.movie.repo.MovieRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    private MovieRepository movieRepository;
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> getAllMovies(Sort sortByRating){
        return movieRepository.findAll(sortByRating);
    }

    public void insertMovie(Movie movie){
        this.movieRepository.insert(movie);
    }

    public void updateMovie(Movie movie){
        this.movieRepository.save(movie);
    }

    public void deleteMovie(String id){
        this.movieRepository.deleteById(id);
    }
}
