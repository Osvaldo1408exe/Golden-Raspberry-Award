package com.osvaldo.gra.model;

import jakarta.persistence.*;

@Entity
@Table(name = "movie")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_movie", nullable = false)
    private Integer id_movie;

    @Column(name = "movie_year", nullable = false )
    private int year;

    @Column(name = "title", nullable = false, length = 250)
    private String title;

    @Column(name = "studio", nullable = false, length = 250)
    private String studio;

    @Column(name = "producer", nullable = false, length = 250)
    private String producer;

    @Column(name = "winner", nullable = true, length = 4)
    private String winner;

    public int getId_movie() {
        return id_movie;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }
}
