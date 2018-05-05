package app.movie.seeder;

import app.movie.model.Movie;
import app.movie.repo.MovieRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Component
public class DbSeeder implements CommandLineRunner {

    private LocalDateTime createdAt;

    private MovieRepository movieRepository;

    public DbSeeder(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
        createdAt = LocalDateTime.now();
    }

    @Override
    public void run(String... args) throws Exception {

        Movie matrix = new Movie("Matrix"
                ,9.9
                ,"Larry and Andy Wachowski"
                ,"Keanu Reeves\n" + "Laurence Fishburne"
                , createdAt);

        Movie thePrestige = new Movie("The Prestige"
                ,8.8
                ,"Christopher Nolan"
                ,"Hugh Jackman, Christian Bale"
                , createdAt);

        Movie theGodfather = new Movie("The Godfather"
                ,10.0
                ,"Francis Ford Coppola"
                ,"Marlon Brando, Al Pacino"
                , createdAt);

        //drop existing collection
        this.movieRepository.deleteAll();

        //add movies to db
        List<Movie> movies = Arrays.asList(matrix, thePrestige, theGodfather);
        this.movieRepository.saveAll(movies);
    }
}
