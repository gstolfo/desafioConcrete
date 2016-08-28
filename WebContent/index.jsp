<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Desafio Concrete Solutions</title>
<script type="text/javascript" src="js/jquery-3.1.0.js"></script>


</head>
<body>
<script type="text/javascript" >
$(document).ready(function(){  

    $('#sign').click(function(){  
        $.ajax({  
            url:"http://localhost:8181/desafioConcrete/login",  
            type:"post",  
            dataType: "json",
            contentType: 'application/json',
            data: JSON.stringify({
                email:$("#email").val(),
                password:$("#password").val()
            }), 
        });  
    });  
}); 
</script>
	Desafio Concrete Solutions
	<form method="POST" action="login">
		<table cellpadding="0" cellspacing="0" border="0" >
			<tr>
				<td>
					Email:
				</td>
				<td>
					<input type="text" name="email" id="email"/>
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
		    	<td colspan="2" align="right">
		    		<input type="button" id="sign" value="Sign" />
		    	</td>
		    </tr>
		 </table>
	 </form>		
</body>
</html>