package question.service.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("greeting")
public class SayGreeting {
	@Autowired
	@Qualifier("tr")
	private MessageService service;
	
	@Autowired
	@Qualifier("myds")
	private DataSource ds;
	
	public String sayHello(){
		return service.getMessage()+" Spring" + ds.getUrl();
	}
}
