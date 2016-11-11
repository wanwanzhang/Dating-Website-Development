
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page session="false" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>

    </head>
    <body>
        <h1>Welcome to Login in!</h1>
        <c:if test="${sessionScope.checkNoUser=='NoUser'}">
            <p style="color:red;">Please enter valid credentials and login</p>
        </c:if>
        <c:choose>
            <c:when test="${!empty sessionScope.currentusername}">
                <p style="color:red">Can not be empty!</p>
                <c:redirect url="login.htm?action=login"/>
                
            </c:when>
            <c:otherwise>
       
                <form:form action='login.htm' commandName="user" method='post'>
                UserName : <form:input  path ='username' id ='username' value='${cookie.username.value}'/><font color="red"><form:errors path="username"/></font><br /><br />
                Password : <form:input  path ='password' id ='password' value='${cookie.password.value}'/><font color="red"><form:errors path="password"/></font><br /><br />
                       
                <input type='checkbox' name='rememberMe' value="rememberMe"> Remember Me <br /><br />
                <input type="submit" value="Submit"> 
               
                <input type="hidden" name="action" value="login" />
                 <c:if test="${sessionScope.checkNoUser=='NoUser'}">
               
                <p style="color:red">Invalid credentials</p>
                </c:if>
                </form:form>
            </c:otherwise>
            
        </c:choose>
        
        
        
    </body>
</html>
