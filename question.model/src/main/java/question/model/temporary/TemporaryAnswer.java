package question.model.temporary;

public class TemporaryAnswer {
	private int userID;
	private int questionID;
	private String desc;
	
	public TemporaryAnswer() {
		super();
	}

	public TemporaryAnswer(int userID, int questionID, String desc) {
		super();
		this.userID = userID;
		this.questionID = questionID;
		this.desc = desc;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public int getQuestionID() {
		return questionID;
	}

	public void setQuestionID(int questionID) {
		this.questionID = questionID;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	@Override
	public String toString() {
		return "TemporaryAnswer [userID=" + userID + ", questionID=" + questionID + ", desc=" + desc + "]";
	}
	
}
