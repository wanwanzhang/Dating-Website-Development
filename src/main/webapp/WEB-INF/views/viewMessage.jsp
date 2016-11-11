 


<%@ page import="java.io.*"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
;

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <title>JSP Page</title>
        
        
    </head>
    <body>
    <jsp:include page="menu.jsp"/><a href="home.htm">

        <table border="1" cellpadding="5" cellspacing="5">
            <tr>
                <td><b>User Name</b></td>
                <td><b>to User</b></td>
                <td><b>Message</b></Std>
                <td><b>Action</b></Std>
                <td><b>Delete</b></Std>
            </tr>
            <c:forEach var="message" items="${showmessages}">
                <tr>
                    <td>${message.user.username}</td>
                    <td>${message.touser}</td>
                    <td>${message.message}</td>
                    <td><a href="sendmessage.htm?name='${message.user.username}'&action=add">Reply Message</td>
                   <td><a href="deletemessage.htm?name='${message.user.username}'&action=add">Delete Message</td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>