<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> Enter your education </title>
</head>
<body>
 <form action="infoservlet" method="post">
  University: <input type="text" name="funiversity"><br>
  Degree: <input type="text" name="fdegree"><br>
  Graduation Year: <input type="text" name ="fyear"><br>
  <input type ="hidden" name ="act" value="addedu">
  <input type="submit" value="Submit">  
</form> 




</body>
</html>