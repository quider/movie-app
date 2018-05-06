package app.movie.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document(collection = "/Reviews")
public class Review {

    @Id
    private String id;
    private String description;
    private boolean accepted;

    protected Review(){
        this.id = UUID.randomUUID().toString();
        this.accepted = false;
    }

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isAccepted() {
        return accepted;
    }

    public void setAccepted(boolean accepted) {
        this.accepted = accepted;
    }
}
