package com.osvaldo.gra.service;

import com.osvaldo.gra.dto.AwardIntervalResponse;
import com.osvaldo.gra.dto.ProducerIntervalDTO;
import com.osvaldo.gra.model.Movie;
import com.osvaldo.gra.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class AwardService {

    private final MovieRepository movieRepository;

    public AwardService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public AwardIntervalResponse calculateAwardIntervals() {
        List<Movie> winners = movieRepository.findByWinnerIgnoreCase("yes");

        Map<String, List<Integer>> producerWins = new HashMap<>();

        for (Movie movie : winners) {
            String[] producers = movie.getProducer().split(",| and ");
            for (String p : producers) {
                String producer = p.trim();
                if (!producer.isEmpty()) {
                    producerWins.computeIfAbsent(producer, k -> new ArrayList<>()).add(movie.getYear());
                }
            }
        }

        List<ProducerIntervalDTO> intervals = new ArrayList<>();

        for (Map.Entry<String, List<Integer>> entry : producerWins.entrySet()) {
            List<Integer> years = entry.getValue();
            if (years.size() > 1) {
                Collections.sort(years);
                for (int i = 1; i < years.size(); i++) {
                    int interval = years.get(i) - years.get(i - 1);
                    intervals.add(new ProducerIntervalDTO(entry.getKey(), interval, years.get(i - 1), years.get(i)));
                }
            }
        }

        if (intervals.isEmpty()) return new AwardIntervalResponse(List.of(), List.of());

        int minInterval = intervals.stream().mapToInt(ProducerIntervalDTO::getInterval).min().getAsInt();
        int maxInterval = intervals.stream().mapToInt(ProducerIntervalDTO::getInterval).max().getAsInt();

        List<ProducerIntervalDTO> min = intervals.stream()
                .filter(i -> i.getInterval() == minInterval)
                .collect(Collectors.toList());

        List<ProducerIntervalDTO> max = intervals.stream()
                .filter(i -> i.getInterval() == maxInterval)
                .collect(Collectors.toList());

        return new AwardIntervalResponse(min, max);
    }
}