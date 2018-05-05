package app.movie.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "Movies")
public class Movie {

    @Id
    private String id;

    private String title;

    @Indexed(direction = IndexDirection.DESCENDING)
    private double ratings;

    private String director;
    private String actors;
    private LocalDateTime createdAt;

    public Movie(String title, double ratings, String director, String actors,LocalDateTime createdAt) {
        this.title = title;
        this.ratings = ratings;
        this.director = director;
        this.actors = actors;
        this.createdAt = createdAt;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public double getRatings() {
        return ratings;
    }

    public String getDirector() {
        return director;
    }

    public String getActors() {
        return actors;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
