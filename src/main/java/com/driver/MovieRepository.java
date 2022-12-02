package com.driver;


import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class MovieRepository {




        private Map<String, Movie> movmap;
        private Map<String, Director> direcmap;



    public MovieRepository() {


            this.movmap =new HashMap<String,Movie>();
            this.direcmap =new HashMap<String,Director>();

        }

    public void addmov(Movie  amov)
    {

        this.movmap.put(amov.getName(),amov);
    }
        public void addir(Director adir)
        {

           this.direcmap.put(adir.getName(), adir);
        }

    public void deld(String ddir)
    {

        direcmap.remove(ddir);
    }
    public void delm(String dmov)
    {

        movmap.remove(dmov);
    }

    public Movie getm(String gmov)
    {
         return this.movmap.get(gmov);

    }


    public Director getd(String gdir)
    {

         return this.direcmap.get(gdir);
    }


}
