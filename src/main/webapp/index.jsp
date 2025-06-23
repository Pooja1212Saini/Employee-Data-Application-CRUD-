<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee Data</title>
</head>
<body>


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<c:if test="${not empty msg}">
    <p style="color: green;">${msg}</p>
</c:if>



<%
    String msg = (String) request.getAttribute("msg");
    if (msg != null) {
%>
    <p style="color: green;"><%= msg %></p>
<%
    }
%>



<form action="insert" method="post">
<table>


<tr>
<td>Emp Name</td>
<td><input type ="text" name="name"></td>
</tr>

<tr>
<td>Emp Email </td>
<td><input type ="email" name="email"></td>
</tr>


<tr>
<td>Emp Gender</td>
<td> 
<input type ="radio" name="gender" value="Male">Male
<input type ="radio" name="gender" value="Female">Female
</td>
</tr>


<tr>

<td>Emp Dept</td>
<td>
<!-- Department -->
<select name="dept">
  <option value="">-Select-</option>
  <option value="development">Development</option>
  <option value="testing">Testing</option>
  <option value="database">Database</option>
  <option value="ops">Operations</option>
</select>

</td>
</tr>



<tr>
<td>Emp Exp</td>
<td>
<!-- Experience -->
<select name="exp">
  <option value="">-Select-</option>
  <option value="1">1</option>
  <option value="2">2</option>
  <option value="3">3</option>
  <option value="4">4</option>
</select>
</td>
</tr>

<tr>
<td></td>
<td><input type="submit" value ="Save"/></td>
</tr>





</table>
</form>


<a href ="emp.jsp">View Employee</a>

</body>
</html>