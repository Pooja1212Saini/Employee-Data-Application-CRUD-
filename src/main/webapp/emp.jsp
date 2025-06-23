<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Search Employees</title>
</head>
<body>

<h2>Search Employee</h2>

<a href="index.jsp">Add New Employee</a>
<br/><br/>

<!-- Search Form -->
<form action="select" method="post">
    <table>
        <tr>
            <td>Gender:</td>
            <td>
                <select name="gender">
                    <option value="">--Select--</option>
                    <option value="male">Male</option>
                    <option value="female">Female</option>
                </select>
            </td>
        </tr>

        <tr>
            <td>Department:</td>
            <td>
                <select name="dept">
                    <option value="">--Select--</option>
                    <option value="development">Development</option>
                    <option value="testing">Testing</option>
                    <option value="database">Database</option>
                    <option value="ops">Operations</option>
                </select>
            </td>
        </tr>

        <tr>
            <td>Experience:</td>
            <td>
                <select name="exp">
                    <option value="">--Select--</option>
                    <option value="1">1 Year</option>
                    <option value="2">2 Years</option>
                    <option value="3">3 Years</option>
                    <option value="4">4 Years</option>
                </select>
            </td>
        </tr>

        <tr>
            <td colspan="2"><input type="submit" value="Search"/></td>
        </tr>
    </table>
</form>

<br/><hr/><br/>

<!-- Results Table -->
<h3>Employee List</h3>
<table border="1" cellpadding="5" cellspacing="0">
    <thead>
        <tr>
            <th>S.No</th>
            <th>Name</th>
            <th>Email</th>
            <th>Gender</th>
            <th>Department</th>
            <th>Experience</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${emps}" var="emp" varStatus="index">
            <tr>
                <td>${index.count}</td>
                <td>${emp.emp_name}</td>
                <td>${emp.emp_email}</td>
                <td>${emp.emp_gender}</td>
                <td>${emp.emp_department}</td>
                <td>${emp.emp_experience} years</td>
            </tr>
        </c:forEach>

        <c:if test="${empty emps}">
            <tr><td colspan="6" style="color:red;">No records found</td></tr>
        </c:if>
    </tbody>
</table>

</body>
</html>














