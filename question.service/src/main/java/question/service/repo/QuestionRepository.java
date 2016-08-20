package question.service.repo;

import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;


import question.model.Question;



@Repository
public interface QuestionRepository extends CrudRepository<Question, Integer> 
{
	
	
}