package com.osvaldo.gra.startup;

import com.osvaldo.gra.model.Movie;
import com.osvaldo.gra.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

@Component
@Profile("!test")
public class CsvInsert implements CommandLineRunner {

    @Autowired
    private MovieRepository movieRepository;

    @Override
    public void run(String... args) throws Exception {
        InputStream inputStream = getClass().getResourceAsStream("/movielist.csv");
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        reader.readLine();

        String line;
        while ((line = reader.readLine()) != null) {
            String[] fields = line.split(";");
            Movie movie = new Movie();
            movie.setYear(Integer.parseInt(fields[0]));
            movie.setTitle(fields[1]);
            movie.setStudio(fields[2]);
            movie.setProducer(fields[3]);
            String winner = (fields.length > 4 && "yes".equalsIgnoreCase(fields[4].trim())) ? "yes" : "no";
            movie.setWinner(winner);
            movieRepository.save(movie);
        }
        reader.close();
    }
}