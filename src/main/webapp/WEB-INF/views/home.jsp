 


<%@ page import="java.io.*"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <title>JSP Page</title>
        
       
    </head>
    <body>
    <jsp:include page="menu.jsp"/>
 <a href="viewcontacts.htm" >Check All Contacts</a><br>
 <a href="viewmessage.htm" >View Messages</a><br>

        <table border="1" cellpadding="5" cellspacing="5">
            <tr>
                <td><b>User Name</b></td>
                <td><b>Photo</b></td>
                <td><b>Add Friend</b>
            </tr>
            <c:forEach var="user" items="${showusers}">
                <tr>
                    <td>${user.username}</td>
                    <td>${user.photoName}</td>
                    
                    
                    <td><a href="addcontact.htm?name='${user.username}'&action=add">AddContact</td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>