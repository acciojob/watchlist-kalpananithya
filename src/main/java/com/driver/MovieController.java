package com.driver;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("movies")
public class MovieController {

    @Autowired
    MovieService  service;


    @PostMapping("/add-movie")
    public ResponseEntity<String>  addMovie(@RequestBody Movie movie)
    {

        service.addMovie(movie);
        return new ResponseEntity<>("new movie added",HttpStatus.CREATED);


    }
    @PostMapping("/add-director")
    public ResponseEntity<String> addDirector(@RequestBody Director direct)
    {

        service.addDirector(direct);
        return new ResponseEntity<>("new director added",HttpStatus.CREATED);


    }


    @PutMapping("/add_mov_dir")
    public ResponseEntity<String> addMovieDirectorPair(@RequestParam("mov") String mov,@RequestParam("direct") String direct)
    {

        service.addmovieDirector(mov,direct);
        return new ResponseEntity<>("new pair added",HttpStatus.CREATED);

    }

     @GetMapping("/get-movie-by-name")
    public ResponseEntity <Movie> getMovieByName(@RequestParam("movie") String movie)
     {

        Movie mo=service.finmov(movie);
         return new ResponseEntity<>(mo,HttpStatus.CREATED);

     }


    @GetMapping("/get-director-by-name")
    public ResponseEntity <Director>  getDirectorByName(@RequestParam("name") String name)
    {

        Director di=service.finddir(name);
        return new ResponseEntity<>(di,HttpStatus.CREATED);

    }

    @GetMapping("/get-movies-by-director-name")
    public ResponseEntity <List<String>> getMoviesByDirectorName(@RequestParam String fdirect)
    {

        List<String> movies=service.fmbyd(fdirect);
        return new ResponseEntity<>(movies,HttpStatus.CREATED);

    }

    @GetMapping("/get-all-movies")
    public ResponseEntity <List<String>>  findAllMovies()
    {

        List<String> movies=service.fallm();
        return new ResponseEntity<>(movies,HttpStatus.CREATED);

    }




    @DeleteMapping("/delete-director-by-name")
    public ResponseEntity<String> deleteDirectorByName(@RequestParam String dir)
    {

        service.deld(dir);
        return new ResponseEntity<>("director deleted",HttpStatus.CREATED);


    }

    @DeleteMapping("/delete-all-directors")
    public ResponseEntity<String> deleteAllDirectors()
    {

        service.delalld();
        return new ResponseEntity<>(" all director deleted",HttpStatus.CREATED);


    }


}
