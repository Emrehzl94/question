package question.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.context.annotation.Lazy;

import com.fasterxml.jackson.annotation.JsonIgnore;

import question.model.temporary.TemporaryQuestion;

@Entity
@Table(name="TBL_QUESTION")
public class Question {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="QTITLE",length=100)
	private String title;
	
	@Column(name="QTEXT",length=300)
	private String text;
	
	@Column(name="QSCORE",nullable=false)
	private int score;

	@Column(name="QDATE", nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;
	
	@OneToMany(fetch=FetchType.LAZY, cascade = CascadeType.ALL, mappedBy="question")
	private List<Answer> answers;
	@ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "question_tag", joinColumns = @JoinColumn(name = "question_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "tag_id", referencedColumnName = "id"))
    private List<Tag> tags;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JsonIgnore
	private User user;
	
	@PrePersist
	protected void onCreate() {
		date = new Date();
	}
	
	public Question() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Question(String title, String text) {
		super();
		this.title = title;
		this.text = text;
	}
	
	public Question(TemporaryQuestion question){
		super();
		this.title = question.getTitle();
		this.text=question.getText();
		this.score = question.getScore();
	}
	
	public Question(int id, String title, String text, int score) {
		super();
		this.id = id;
		this.title = title;
		this.text = text;
		this.score = score;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
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
		if(text!=null){
			this.text = text.toUpperCase();
		}
	}
	
	public int getScore() {
		return score;
	}
	
	public void setScore(int score) {
		this.score = score;
	}
	
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Question other = (Question) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
