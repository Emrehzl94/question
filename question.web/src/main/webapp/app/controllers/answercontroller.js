function AnswerController ($scope,$http,$window){
	var self = this;
	self.answers = [];
	self.answerToAdd ={
			uid :'',
			qid :'',
			desc:'',
		
	}
	
	self.addAnswer = function () {
		$http.post("/answers/"+self.answerToAdd.uid+"/"+self.answerToAdd.qid,{
			
			text:self.answerToAdd.desc,
			
		}).then(function(response) {
			
			$window.location.href = '/index.html';
		});
		
	}
	
	
}