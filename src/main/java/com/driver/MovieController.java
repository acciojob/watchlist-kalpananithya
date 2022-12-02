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

    @DeleteMapping("/del_director")
    public ResponseEntity<String> delDir(@RequestParam String dir)
    {

        service.delDirector(dir);
        return new ResponseEntity<>("director deleted",HttpStatus.CREATED);


    }
    @DeleteMapping("/del_movie")
    public ResponseEntity<String> delMov(@RequestParam String mov)
    {

        service.delMovie(mov);
        return new ResponseEntity<>("movie deleted",HttpStatus.CREATED);


    }

    @GetMapping("/get_movie")
    public ResponseEntity<String> getMov(@PathVariable String mname)
    {

        service.getMovie(mname);
        return new ResponseEntity<>("new movie added",HttpStatus.CREATED);


    }
    @GetMapping("/get_direct")
    public ResponseEntity<String> getDir(@PathVariable String dname)
    {

        service.getDirect(dname);
        return new ResponseEntity<>("new movie added",HttpStatus.CREATED);


    }






}
