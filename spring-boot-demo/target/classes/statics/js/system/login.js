function add(){
	var username = $("input[name='username']").val();
	var password = $("input[name='password']").val();
	$.ajax({
		url : "/add",
		type : "POST",
		data : {
			username : username,
			password : password
		}
	}).done(function(result) {
		console.log(result)
	}).fail(function(result) {
		console.log(2)
	});
}