<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
		.button {
  background-color: #4CAF50; /* Green */
  border: none;
  color: white;
  padding: 15px 32px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  margin: 4px 2px;
  cursor: pointer;
  -webkit-transition-duration: 0.4s; /* Safari */
  transition-duration: 0.4s;
}
table {
  border-collapse: collapse;
  width: 100%;
}

th, td {
  padding: 8px;
  text-align: left;
  border-bottom: 1px solid #ddd;
}

.button1 {
  box-shadow: 0 8px 16px 0 rgba(0,0,0,0.2), 0 6px 20px 0 rgba(0,0,0,0.19);
}

ul {
  list-style-type: none;
  margin: 0;
  padding: 0;
  overflow: hidden;
  background-color: #333;
}

li {
  float: left;
}

li a {
  display: block;
  color: white;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
}

li a:hover {
  background-color: green;
}
</style>
</head>
<body>
<ul>
	<li><a class="active" href="home">Servers</a></li>		
  <li><a class="active" href="addServer">Add Server</a></li>
  <li><a href="getServerById">Search Server By ID</a></li>
  <li><a href="getServerByName">Search Server By Name</a></li>
  <li><a href="deleteServer">Delete Server</a></li>
</ul>
<div align="center">
	<h1>Servers List:</h1>
	<table>
	
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Language</th>
			<th>Framework</th>
		</tr>
	
	
		 <c:forEach var="server" items="${servers}">
                <tr>
                    <td><c:out value="${server.id}" /></td>
                    <td><c:out value="${server.name}" /></td>
                    <td><c:out value="${server.language}" /></td>
                    <td><c:out value="${server.framework}" /></td>
                </tr>
          </c:forEach>
                
	
	
	</table>
	
	<a href="addServer"><button  class="button button1" >Add Server</button></a>
</div>
</body>
</html>