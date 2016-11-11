<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>add profile Page</title>
    </head>
    <body>
        <h1>Your Profile Information</h1>
        <form:form action='addprofile.htm' commandName="profile" method="post" enctype="multipart/form-data">
                City : <input type ='text' name ='city'><br /><br />
               
             
                
                <input type="hidden" name="action" value="addprofile" />
                 <td colspan="2"><input type="submit" value="Add Profile" /></td>
      </form:form>
        </body>
        </html>
        