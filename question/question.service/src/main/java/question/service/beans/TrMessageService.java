package question.service.beans;

import org.springframework.stereotype.Component;

@Component("tr")
public class TrMessageService implements MessageService {

	@Override
	public String getMessage() {
		return "Merhaba";
	}

}
