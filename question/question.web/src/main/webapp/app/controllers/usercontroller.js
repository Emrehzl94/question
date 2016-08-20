function UserController($scope,$http){
	var self = this;
	
	self.users = [];
	
	self.userToAdd ={
		id:'',
		name: '',
		mail:'',
		password:''
	}
	
	self.getContacts = function(){
		$http.get("/user").then(function(response){
			self.users = response.data;
		});
	}
	
	self.getContacts();
	
	self.addUser = function() {
		$http.post("/user", {
			name : self.userToAdd.name,
			mail : self.userToAdd.mail,
			password : self.userToAdd.password
		}).then(function(response) {
			self.getContacts();
		});
	}
	
	self.removeUser =function(user){
		$http.delete("/user/"+user.id, user)
		   .then(
		       function(response){
		    	   self.getContacts();
		       }, 
		       function(response){
		         // failure call back
		       }
		    );
	}
	
	
}