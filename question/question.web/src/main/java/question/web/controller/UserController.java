package question.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import question.model.User;
import question.service.repo.UserRepository;

@RestController
public class UserController {
	@Autowired
	UserRepository repo;
	
	/***
	 * 
	 * @return
	 */
	@RequestMapping(value="/user", method=RequestMethod.GET)
	public List<User> getUserList(){
		return (List<User>) repo.findAll();
	}
	
	/***
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping(value="/user", method=RequestMethod.POST)
	public User saveUser(@RequestBody User user){
		return repo.save(user);
	}
	
	/***
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/user/{id}", method=RequestMethod.GET)
	public User getUser(@PathVariable("id")int id){
		return repo.findOne(id);
	}
	
	/**
	 * 
	 * @param id
	 * @param user
	 * @return
	 */
	@RequestMapping(value="/user/{id}", method=RequestMethod.PUT)
	public User setUser(@PathVariable("id")int id,@RequestBody User user){
		User r = repo.findOne(id);
		r.setName(user.getName());
		r.setPassword(user.getPassword());
		repo.save(r);
		return repo.findOne(id);
	}
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/user/{id}", method=RequestMethod.DELETE)
	public User deleteUser(@PathVariable("id")int id){
		User user = repo.findOne(id);
		repo.delete(user);
		return user;
	}
	
	
}	
