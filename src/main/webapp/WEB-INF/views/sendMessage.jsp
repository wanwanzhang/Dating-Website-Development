<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Send Message</title>
    </head>
    <body>
        <jsp:include page="menu.jsp"/>
        <h1>Welcome <c:out value="${user.username}"></c:out></h1>
        <form action="sentMessage.htm" method="post">
                 <h3>From:</h3>
                 
                <c:out value="${sessionScope.from}"></c:out>

                <h3>To:</h3>${sessionScope.to}
               
             
            <h3>Message:</h3>
                <textarea name="message" rows="6" cols="10"></textarea>
                <br /><input type="submit" value="Send" /> 
                
                <input type="hidden" name="to" value="${param.to}"/>
               
        </form>
    </body>
</html>