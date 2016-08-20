package question.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import question.model.Question;
import question.model.temporary.TemporaryQuestion;
import question.service.repo.QuestionRepository;
import question.service.repo.UserRepository;

@RestController
public class QuestionController {
	@Autowired
	QuestionRepository questionRepo;
	@Autowired
	UserRepository userRepo;
	
	/***
	 * 
	 * @return
	 */
	@RequestMapping(value="/questions", method=RequestMethod.GET)
	public List<Question> getQuestions() {
		
		return (List<Question>) questionRepo.findAll();
		
	}
	
	/***
	 * 
	 * @param question
	 * @return
	 */
	@RequestMapping(value="/questions/{id}", method=RequestMethod.POST)
	public Question saveQuestion(@PathVariable int id,@RequestBody TemporaryQuestion tempQuestion) {
		Question q = new Question();
		q.setUser(userRepo.findOne(id));
		q.setScore(tempQuestion.getScore());
		q.setText(tempQuestion.getText());
		q.setTitle(tempQuestion.getTitle());
		return questionRepo.save(q);
	}
	
	/***
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/questions/{id}",method=RequestMethod.GET)
	public Question getQuestion(@PathVariable("id")int id){
		
		return questionRepo.findOne(id);
		
	}
	
	/***
	 * 
	 * @param id
	 * @param question
	 * @return
	 */
	@RequestMapping(value="/questions/{id}",method=RequestMethod.PUT)
	public Question setQuestion(@PathVariable("id")int id,@RequestBody Question question){
		Question q = questionRepo.findOne(id);
		q.setScore(question.getScore());
		q.setText(question.getText());
		q.setTitle(question.getTitle());
		questionRepo.save(q);
		return questionRepo.findOne(id);
	}
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/questions/{id}",method=RequestMethod.DELETE)
	public Question deleteQuestion(@PathVariable("id")int id){
		Question question = questionRepo.findOne(id);
		questionRepo.delete(question);
		return question;
	}
	
	
	
}
