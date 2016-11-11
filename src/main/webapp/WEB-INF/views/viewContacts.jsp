 


<%@ page import="java.io.*"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
;

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <title>JSP Page</title>
        
        
    </head>
    <body>
    <jsp:include page="menu.jsp"/>

        <table border="1" cellpadding="5" cellspacing="5">
            <tr>
                <td><b>Contact Name</b></td>
                <td><b>dateAdded</b></td>
                <td><b>Send Message</b></Std>
                
            </tr>
            <c:forEach var="contact" items="${contactlist}">
                <tr>
                    <td>${contact.contactName}</td>
                    <td>${contact.dateAdded}</td>
                    <td><a href="sendmessage.htm?name='${contact.contactName}'&action=add">Send Message</td>
                   
                </tr>
            </c:forEach>
        </table>
    </body>
</html>