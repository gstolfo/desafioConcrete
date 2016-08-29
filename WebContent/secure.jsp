<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="js/jquery-3.1.0.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<script>
$(document).ready(function(){  
$.urlParam = function(name){
	var results = new RegExp('[\?&]' + name + '=([^&#]*)').exec(window.location.href);
	return results != null?(results[1] || 0):"";
}
$.ajax({  
    url:"http://localhost:8181/desafioConcrete/secure?token="+$.urlParam('token'),
    type:"get",  
    dataType: "json",
    contentType: 'application/json',
    success: function(data){
    	var json = JSON.stringify(data);
    	var obj = $.parseJSON(json);
    	
    	if(obj["httpStatus"] === "FORBIDDEN" && obj["codHttpStatus"] === 403){
    		window.location.href="index.jsp";
    	}
    	   
    }
});
});
</script>
Secure
</body>
</html>