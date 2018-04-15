package cl.citiaps.spring.backend.rest;

import cl.citiaps.spring.backend.entities.Film;
import cl.citiaps.spring.backend.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/films")
public class FilmService {
    @Autowired
    private FilmRepository filmRepository;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public Iterable<Film> getAllUsers(){return filmRepository.findAll();}

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Film findOne(@PathVariable("id") Integer id){return filmRepository.findOne(id);}

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Film> create(@RequestBody Film resource){
        if (resource.getDescription().isEmpty() || resource.getTitle().isEmpty()){
            return new ResponseEntity<Film>(HttpStatus.BAD_REQUEST);
        }else{
            return new ResponseEntity<Film>(filmRepository.save(resource), HttpStatus.CREATED);
        }
    }
}