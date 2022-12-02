package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    MovieRepository repository;


    public void addMovie(Movie movie) {

        repository.addmov(movie);
    }

    public void addDirector(Director dir) {

        repository.addir(dir);
    }

    public void addmovieDirector(String mov,String dir) {

        repository.savmovdir(mov,dir);
    }
    public Movie finmov(String mov) {

        return repository.findmov(mov);
    }

    public Director finddir(String dir) {

        return repository.finddir(dir);
    }
    public List<String> fmbyd(String dir) {

        return repository.findmovbydir(dir);
    }


    public List<String> fallm() {

        return repository.findallmov();
    }

    public void deld(String di) {

        repository.deldir(di);
    }
    public void delalld() {

         repository.delalldir();
    }


}
