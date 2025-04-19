package com.osvaldo.gra.repository;

import com.osvaldo.gra.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {
    List<Movie> findByWinnerIgnoreCase(String yes);
}
