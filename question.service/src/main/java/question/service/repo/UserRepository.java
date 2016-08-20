package question.service.repo;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import question.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> 
{
	
}