package com.driver;


import org.springframework.stereotype.Repository;

import java.util.*;



@Repository
public class MovieRepository {


    private Map<String, Movie> movmap;
    private Map<String, Director> direcmap;
    private Map<String, List<String>> movdirmap;


    public MovieRepository() {


        this.movmap = new HashMap<String, Movie>();
        this.direcmap = new HashMap<String, Director>();
        this.movdirmap = new HashMap<String, List<String>>();
    }

    public void addmov(Movie amov) {

        this.movmap.put(amov.getName(), amov);
    }

    public void addir(Director adir) {

        this.direcmap.put(adir.getName(), adir);
    }

    public void savmovdir(String mov, String dir) {
        if (movmap.containsKey(mov) && movmap.containsKey(dir)) {
            List<String> movies = new ArrayList<String>();

            if (movdirmap.containsKey(dir))

                movies = movdirmap.get(dir);
            movies.add(mov);
            movdirmap.put(dir, movies);

        }
    }

    public Movie findmov(String fmov) {
        return movmap.get(fmov);

    }

    public Director finddir(String fdir) {

        return direcmap.get(fdir);
    }

    public List<String> findmovbydir(String fmdir) {
        List<String> lis = new ArrayList<>();
        if (movdirmap.containsKey(fmdir))
            lis = movdirmap.get(fmdir);
        return lis;
    }

    public List<String> findallmov() {

        return new ArrayList<>(movmap.keySet());
    }


    public void deldir(String ddir) {
        List<String> lmov = new ArrayList<String>();

        if (movdirmap.containsKey(ddir)){
            lmov = movdirmap.get(ddir);

        for (String str : lmov) {
            if (movmap.containsKey(lmov))
                movmap.remove(str);

        }
    }
     direcmap.remove(ddir);
}


    public void delalldir() {
        HashSet<String> mset=new HashSet<String>();



        for (String direct :movdirmap.keySet()) {
            for (String mov : movdirmap.get(direct)) {
                mset.add(mov);
            }
        }

        for (String mov :mset)
        {
            if(movmap.containsKey(mov))
                movmap.remove(mov);
        }
    }


    }











