package com.driver;


import org.springframework.stereotype.Repository;

import java.util.*;



@Repository
public class MovieRepository {


    private Map<String, Movie> movmap;
    private Map<String, Director> dirmap;
    private Map<Director, List<Movie>> movdirmap;


    public MovieRepository() {


        this.movmap = new HashMap<String, Movie>();
        this.dirmap = new HashMap<String, Director>();
        this.movdirmap = new HashMap<Director, List<Movie>>();
    }

    public void addmov(Movie mov) {

        this.movmap.put(mov.getName(), mov);
    }

    public void addir(Director adir) {

        this.dirmap.put(adir.getDname(), adir);
    }

    public void savmovdir(String mov, String dir) {

        List<Movie> movie = new ArrayList<Movie>();

        Director di = new Director();
        di = dirmap.get(dir);

        if (dirmap.containsKey(dir)) {

            for (Movie mi : movmap.values()) {

                if (movmap.containsKey(mov) && dir.equals(di.dname)) {
                    Movie mo = new Movie();
                    mo = movmap.get(mov);
                    movie.add(mo);
                }

            }
            movdirmap.put(di, movie);

        }
    }


    public Movie findmov(String fmov) {
        return movmap.get(fmov);

    }

    public Director finddir(String fdir) {

        return dirmap.get(fdir);
    }

    public List<Movie> findmovbydir(String fmdir) {
        List<Movie> lis = new ArrayList<>();

        for (Director di : movdirmap.keySet()) {

            if (di.equals(fmdir)) {

                lis=movdirmap.get(fmdir);

            }
        }

        return lis;
    }






    public List<String> findallmov() {

        return new ArrayList<>(movmap.keySet());
    }


    public void deldir(String ddir) {
        List<Movie> lmov = new ArrayList<Movie>();

        if (movdirmap.containsKey(ddir)){
            lmov = movdirmap.get(ddir);

        for (Movie m :  lmov) {
            if (movmap.containsKey(m))
                movmap.remove(m);

        }
    }
     dirmap.remove(ddir);
}


    public void delalldir() {
        dirmap.clear();
        movmap.clear();
    }


    }

