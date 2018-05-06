package app.movie.services;

import app.movie.collectors.collectors;
import app.movie.model.Movie;
import app.movie.model.Review;
import app.movie.repo.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReviewService {

    MovieRepository movieRepository;

    public ReviewService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public void acceptReviewForMovie(String idMovie, String idReview){
        Movie movie = movieRepository.findAllById(idMovie);
        Review review = movie.getReviews().stream().filter(x->x.getId().equals(idReview)).collect(collectors.singletonCollector());
        review.setAccepted(true);
        movieRepository.save(movie);
    }

    public void addReviewForMovie(String idMovie, Review review){
        Movie movie = movieRepository.findAllById(idMovie);
        movie.getReviews().add(review);
        movieRepository.save(movie);
    }

    public List<Review> getReviewsToAccept(){
        List<Review> review = movieRepository.findAll()
                        .stream()
                        .filter(m -> m.getReviews()
                        .stream()
                        .anyMatch(r -> !r.isAccepted()))
                        .flatMap(m -> m.getReviews().stream())
                        .collect(Collectors.toList());

        return review;
    }
}
