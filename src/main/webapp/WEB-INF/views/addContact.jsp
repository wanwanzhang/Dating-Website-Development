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
        <form:form action='addprofile.htm' commandName="user" method="post" enctype="multipart/form-data">
                City : <input type ='text' name ='city' value='city'><br /><br />
               
               Select Photo (Max Size: 5MB): <form:input path="photo" type="file"/>
              <form:errors cssStyle="color:red" path="photo"/> <br><br>
                
                <input type="hidden" name="action" value="addprofile" />
                 <td colspan="2"><input type="submit" value="Add Profile" /></td>
      </form:form>
        </body>
        </html>
        