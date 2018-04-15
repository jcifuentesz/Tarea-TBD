package cl.citiaps.spring.backend.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import cl.citiaps.spring.backend.entities.Actor;
import cl.citiaps.spring.backend.repository.ActorRepository;

@CrossOrigin
@RestController  
@RequestMapping("/actors")
public class ActorService {
	
	@Autowired
	private ActorRepository actorRepository;

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public Iterable<Actor> getAllUsers() {
		return actorRepository.findAll();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public  Actor findOne(@PathVariable("id") Integer id) {
		return actorRepository.findOne(id);
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Actor> create(@RequestBody Actor resource) {
		if (resource.getFirstName().isEmpty() || resource.getLastName().isEmpty()){
			return new ResponseEntity<Actor>(HttpStatus.BAD_REQUEST);
		}else{
			return new ResponseEntity<Actor>(actorRepository.save(resource), HttpStatus.CREATED);
		}
	}
}