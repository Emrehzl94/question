package question.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import question.model.Answer;
import question.service.repo.AnswerRepository;
import question.service.repo.QuestionRepository;
import question.service.repo.UserRepository;

@RestController
public class AnswerController {
	@Autowired
	AnswerRepository answerRepo;
	@Autowired
	QuestionRepository questionRepo;
	@Autowired
	UserRepository userRepo;
	
	@RequestMapping(value="/answers", method=RequestMethod.GET)
	public List<Answer> getAnswerList(){
		return (List<Answer>) answerRepo.findAll();
	}
	
	@RequestMapping(value="/answers/uid={uid}&qid={qid}&desc={desc}", method=RequestMethod.POST)
	public Answer createAnswer(@PathVariable int uid,@PathVariable int qid,@PathVariable String desc){
		Answer answer = new Answer();
		answer.setUser(userRepo.findOne(uid));
		answer.setQuestion(questionRepo.findOne(qid));
		answer.setApproved(false);
		answer.setDesc(desc);
		answerRepo.save(answer);
		return answer;
	}
	
	@RequestMapping(value="/answers/{id}",method=RequestMethod.GET)
	public Answer getAnswer(@PathVariable int id){
		return answerRepo.findOne(id);
	}
	
	@RequestMapping(value="/answers/aid={id}&desc={desc}",method=RequestMethod.PUT)
	public Answer setAnswer(@PathVariable int id,@PathVariable String desc){
		Answer answer = answerRepo.findOne(id);
		answer.setDesc(desc);
		answerRepo.save(answer);
		return answer;
	}
	
	@RequestMapping(value="/answers/{id}",method=RequestMethod.DELETE)
	public Answer deleteAnswer(@PathVariable int id){
		Answer answer = answerRepo.findOne(id);
		answerRepo.delete(answer);
		return answer;
	}

}
