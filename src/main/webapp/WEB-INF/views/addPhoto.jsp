<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>add profile Page</title>
        <script>
        function checkphoto(){
        	var photo = document.getElementById('photo');
        	if(photo==""){
        		alert("File is empty");
        	}
        	 
        }
        </script>
    </head>
    <body>
        <h1>Your Photo</h1>
        <form:form action='addphoto.htm' method="post" enctype="multipart/form-data">
                
               
               Select Photo (Max Size: 5MB): <form:input path="photo" type="file" id="photo" onblur ="return checkphoto()"/>
              <form:errors cssStyle="color:red" path="photo"/> <br><br>
                
                <input type="hidden" name="action" value="addphoto" />
                <input type="submit" value="APhoto"/>
                
                <td colspan="2">
                 
      </form:form>
        </body>
        </html>
        