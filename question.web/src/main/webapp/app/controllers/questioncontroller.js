function QuestionController($scope,$http,$window){
	var self = this;
	
	self.questions = [];
	self.questionToAdd ={
			id :'',
			title:'',
			text:'',
			score:''
	};
	self.answers = [];
	self.answerToAdd ={
			id:'',
			uid :'',
			qid :'',
			desc:'',
		
	};
	self.user ={
			id :'',
			mail:'',
			name:'',
			password:''
	}
	self.addAnswer = function (qid) {
		$http.post("/answers/"+self.answerToAdd.uid+"/"+qid,{
			
			desc:self.answerToAdd.desc,
			
		}).then(function(response) {
			
			$window.location.href = '/index.html';
		});
		
	};
	
	self.addQuestion = function() {
		$http.post("/questions/"+self.questionToAdd.id, {
			title:self.questionToAdd.title,
			text:self.questionToAdd.text,
			score:self.questionToAdd.score
		}).then(function(response) {
			$window.location.href = '/index.html';
			self.getQuestions();
		});
		self.questionToAdd ={};
	}
	
	self.getQuestions = function(){
		$http.get("/questions").then(function(response){
			self.questions = response.data;
		});
	}
	
	self.getQuestions();
	
	self.removeQuestion =function(question){
		$http.delete("/questions/"+question.id, question)
		   .then(
		       function(response){
		    	   self.getQuestions();
		    	   $window.alert("Question deleted");
		       }, 
		       function(response){
		         // failure call back
		       }
		    );
	}
	
	self.removeAnswer =function(answer){
		$http.delete("/answers/"+answer.id, answer)
		   .then(
		       function(response){
		    	   self.getQuestions();
		    	   
		       }, 
		       function(response){
		         // failure call back
		       }
		    );
	}
}