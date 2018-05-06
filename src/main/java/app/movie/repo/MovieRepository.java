package app.movie.repo;

import app.movie.model.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends MongoRepository<Movie, String> {
    Movie findAllById(String id);
    List<Movie> findMoviesByRatingsOrderByRatingsDesc(double rating);
}
