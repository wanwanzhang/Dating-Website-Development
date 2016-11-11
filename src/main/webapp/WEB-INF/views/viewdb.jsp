 


<%@ page import="java.io.*"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <title>JSP Page</title>
        
       
    </head>
    <body>
          <h1>User Database</h1>
        <table border="1" cellpadding="5" cellspacing="5">
            <tr>
                <td><b>User Name</b></td>
                <td><b>Photo</b></td>
                <td><b>Profile</b>
            </tr>
            <c:forEach var="user" items="${showusers}">
                <tr>
                    <td>${user.username}</td>
                    <td>${user.photoName}</td>
                    <td>${user.profile.city}</td>
                   
                </tr>
            </c:forEach>
        </table>
    </body>
</html>