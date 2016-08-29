<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Desafio Concrete Solutions - Cadastro</title>
<script type="text/javascript" src="js/jquery-3.1.0.js"></script>


</head>
<body>
<script type="text/javascript" >
$(document).ready(function(){  
	
    $('#add').click(function(){
    	
         var obj = {}; 
         var phones = [{"ddd":$("#ddd").val(),"number":$("#number").val()}];
         
    	 obj["name"] = $("#name").val(),
    	 obj["email"] = $("#email").val(),
    	 obj["password"] = $("#password").val(),
    	 obj["phones"] = phones;
         
    	var json = JSON.stringify(obj); 
   
        $.ajax({  
            url:"http://localhost:8181/desafioConcrete/register",  
            type:"post",  
            dataType: "json",
            contentType: 'application/json',
            data: json
        });  
    });  
}); 
</script>
	Desafio Concrete Solutions
	<form method="POST" action="login">
		<table cellpadding="0" cellspacing="0" border="0" >
			<tr>
				<td>
					Name:
				</td>
				<td>
					<input type="text" name="name" id="name"/>
				</td>
		    </tr>
		    <tr>
				<td>
					Email:
				</td>
				<td>
					<input type="text" name="email" id="email" />
				</td>
		    </tr>
		    <tr>
				<td>
					Password:
				</td>
				<td>
					<input type="password" name="password" id="password" />
				</td>
		    </tr>
		    <tr>
				<td>
					DDD:
				</td>
				<td>
					<input type="text" name="ddd" id="ddd" maxlength="3" />
				</td>
		    </tr>
		    <tr>
				<td>
					Number:
				</td>
				<td>
					<input type="text" name="number" id="number" maxlength="9" />
				</td>
		    </tr>
		    <tr>
		    	<td colspan="2" height="10px"></td>
		    </tr>
		    <tr>
		    	<td colspan="2" align="right">
		    		<input type="button" id="add" value="Add" />
		    	</td>
		    </tr>
		 </table>
	 </form>		
</body>
</html>