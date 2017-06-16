<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
   <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> Robotic Resume </title>
</head>
<body>
<h1>${myperson.Firstname }</h1>
<h1>${myperson.Lastname }</h1>
<h1>${myperson.Email}</h1>


<c:forEach items="${myperson.education}" var="edus">
   <h2> ${education.University} , ${education.Degree}, ${education.GraduationYear} </h2>
</c:forEach>



<c:forEach items="${myperson.experience}" var="exp">
   <h2> ${experience.JobTitle}</h2>
   <h2>${experience.Company}, ${experience.StartDate}, ${experience.EndDate}</h2>
   <h2>${experience.Duty1}</h2>
   <h2> ${experience.Duty2}</h2>
</c:forEach>


<c:forEach items="${myperson.skills}" var="ski">
   <h2> ${skills.Skill} , ${skills.SkillLevel}</h2>
</c:forEach>






</body>
</html>