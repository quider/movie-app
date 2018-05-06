package app.movie.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Document(collection = "Movies")
public class Movie {

    @Id
    private String id;

    @Size(min = 3, max = 50)
    @Field("Title")
    private String title;

    @Indexed(direction = IndexDirection.DESCENDING)
    private double ratings;

    private String director;
    private String actors;
    private LocalDateTime createdAt;

    protected Movie(){
        this.createdAt = LocalDateTime.now();
    }

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

    @Field("Title")
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
