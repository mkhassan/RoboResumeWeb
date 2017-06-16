<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

 <form action="expServlet" method="post">
  Job Title: <input type="text" name="fjobtitle"><br>
  Company: <input type="text" name="fcompany"><br>
  Start Date: <input type="text" name ="fstart"><br>
  End Date: <input type="text" name ="fend"><br>
  Duty 1: <input type="text" name ="fduty1"><br>
  Duty 2: <input type="text" name ="fduty2"><br>
  <input type ="hidden" name ="act" value="addexp">
  <input type="submit" value="Submit">  
</form> 




</body>
</html>