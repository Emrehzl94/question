function UserController($scope,$http,$window){
	var self = this;
	
	self.users = [];
	self.userToAdd ={
			id :'',
			mail:'',
			name:'',
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
			$window.location.href = '/index.html#/userList';
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
	
	self.updateUser = function(user){
		$http.put("/user/"+user.id,user)
			 .then(
				function(response){
				  self.getContacts();
				}, 
				function(response){
				  // failure call back
				}	 
			 );
		self.userToAdd={};
	}
	
	
}