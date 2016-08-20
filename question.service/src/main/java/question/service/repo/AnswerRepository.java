package question.service.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import question.model.Answer;

@Repository
public interface AnswerRepository extends CrudRepository<Answer,Integer> 
{
	
	
}
