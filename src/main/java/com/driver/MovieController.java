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


    @PostMapping("/add_movie")
    public ResponseEntity<String> addMov(@RequestBody Movie movie)
    {

        service.addMovie(movie);
        return new ResponseEntity<>("new movie added",HttpStatus.CREATED);


    }
    @PostMapping("/add_director")
    public ResponseEntity<String> addDir(@RequestBody Director direct)
    {

        service.addDirector(direct);
        return new ResponseEntity<>("new director added",HttpStatus.CREATED);


    }


    @PutMapping("/add_mov_dir")
    public ResponseEntity<String> addpair(@RequestParam("mov") String mov,@RequestParam("direct") String direct)
    {

        service.addmovieDirector(mov,direct);
        return new ResponseEntity<>("new pair added",HttpStatus.CREATED);

    }

     @GetMapping("get_movie_name")
    public ResponseEntity <Movie> findmovie(@RequestParam("movie") String movie)
     {

        Movie mo=service.finmov(movie);
         return new ResponseEntity<>(mo,HttpStatus.CREATED);

     }


    @GetMapping("/get_dir_name")
    public ResponseEntity <Director> find1(@RequestParam("name") String name)
    {

        Director di=service.finddir(name);
        return new ResponseEntity<>(di,HttpStatus.CREATED);

    }

    @GetMapping("/get_mov_dir_name")
    public ResponseEntity <List<String>> fmovbydi(@RequestParam String fdirect)
    {

        List<String> movies=service.fmbyd(fdirect);
        return new ResponseEntity<>(movies,HttpStatus.CREATED);

    }

    @GetMapping("/get_mov_all")
    public ResponseEntity <List<String>> fmovbydi()
    {

        List<String> movies=service.fallm();
        return new ResponseEntity<>(movies,HttpStatus.CREATED);

    }




    @DeleteMapping("/del_director")
    public ResponseEntity<String> delDir(@RequestParam String dir)
    {

        service.deld(dir);
        return new ResponseEntity<>("director deleted",HttpStatus.CREATED);


    }

    @DeleteMapping("/del_all_director")
    public ResponseEntity<String> delallDir()
    {

        service.delalld();
        return new ResponseEntity<>(" all director deleted",HttpStatus.CREATED);


    }


}
