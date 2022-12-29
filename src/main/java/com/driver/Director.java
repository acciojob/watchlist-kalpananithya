package com.driver;

public class Director {

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    String dname;
    int numberOfMovies;
    double imdbRating;

    public Director() {
    }

    public Director(String name, int numberOfMovies, double imdbRating) {
        this.dname = name;
        this.numberOfMovies = numberOfMovies;
        this.imdbRating = imdbRating;
    }



    public int getNumberOfMovies() {
        return numberOfMovies;
    }

    public void setNumberOfMovies(int numberOfMovies) {
        this.numberOfMovies = numberOfMovies;
    }

    public double getImdbRating() {
        return imdbRating;
    }

    public void setImdbRating(double imdbRating) {
        this.imdbRating = imdbRating;
    }
}
