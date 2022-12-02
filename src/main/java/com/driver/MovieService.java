package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public void delDirector(String dir) {

        repository.deld(dir);
    }

    public void delMovie(String mov) {

        repository.delm(mov);
    }

    public void getMovie(String gmov) {

        repository.getm(gmov);
    }

        public void getDirect(String gdir)
        {

            repository.getd(gdir);
        }


    }








