package question.service.beans;

import org.springframework.stereotype.Component;

@Component("en")
public class EngMessageService implements MessageService {

	@Override
	public String getMessage() {
		return "Hello";
	}

}
