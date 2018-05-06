package app.movie.controller;

import app.movie.model.Review;
import app.movie.services.MovieService;
import app.movie.services.ReviewService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

    private MovieService movieService;
    private ReviewService reviewServicce;

    public ReviewController(MovieService movieService, ReviewService reviewService) {

        this.movieService = movieService;
        this.reviewServicce = reviewService;
    }

    @PostMapping("/{idMov}/addReview")
    public void addReviewToMovie(@PathVariable String idMov, @RequestBody Review review)
    {
        reviewServicce.addReviewForMovie(idMov, review);
    }

    @PutMapping("/{id}/accept/{idRev}")
    public void reviewAccepted(@PathVariable("id") String id, @PathVariable("idRev") String idRev){
        reviewServicce.acceptReviewForMovie(id, idRev);
    }

    @GetMapping("/all/toReview")
    public List<Review> getAllMoviesToReview(){
        return reviewServicce.getReviewsToAccept();
    }


}

