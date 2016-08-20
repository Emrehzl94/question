package question.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="TBL_ANSWER")
public class Answer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="ADATE", nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;
	@Column(name="ADESC",length=300)
	private String desc;
	@Column(name="AAPROVED")
	@Type(type = "org.hibernate.type.NumericBooleanType")
	private boolean approved;
	@ManyToOne(fetch=FetchType.LAZY)
	@JsonIgnore
	private Question question;
	@ManyToOne
//	@JsonIgnore
	private User user;
	
	@PrePersist
	protected void onCreate() {
		date = new Date();
		approved = false;
	}
	
	public Answer() {
		super();
	}

	public Answer(String desc, Question question) {
		super();
		this.desc = desc;
		this.question = question;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public boolean isApproved() {
		return approved;
	}

	public void setApproved(boolean approved) {
		this.approved = approved;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Answer [desc=" + desc + ", approved=" + approved + ", question=" + question + "]";
	}
	
}
