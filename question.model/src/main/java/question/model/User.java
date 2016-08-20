package question.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="TBL_USER")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="UMAIL",length=100,updatable=false,unique=true,nullable=false)
	private String mail;
	@Column(name="UNAME",length=50)
	private String name;
	@Column(name="UPASSWORD",length=25)
	private String password;
	@OneToMany(fetch=FetchType.LAZY, cascade = CascadeType.ALL, mappedBy="user")
	@JsonIgnore
	private List<Question> questions;
	@OneToMany(fetch=FetchType.LAZY, cascade = CascadeType.ALL, mappedBy="user")
	@JsonIgnore
	private List<Answer> answers;
	
	public User(){
		
	}
	
	public User(String mail, String name, String password) {
		super();
		this.mail = mail;
		this.name = name;
		this.password = password;
	}

	public User(int id, String mail, String name, String password) {
		super();
		this.id = id;
		this.mail = mail;
		this.name = name;
		this.password = password;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

	@Override
	public String toString() {
		return "User [mail=" + mail + ", name=" + name + ", password=" + password + "]";
	}
	
}
