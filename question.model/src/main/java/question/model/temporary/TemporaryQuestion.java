package question.model.temporary;

public class TemporaryQuestion {
	private String title;
	private String text;
	private int score;
	
	public TemporaryQuestion() {
		super();
	}

	public TemporaryQuestion(String title, String text, int score) {
		super();
		this.title = title;
		this.text = text;
		this.score = score;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
	
	
}
