<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<style>
img { 
    width:100%; 
}
</style>
</head>
<body>
 <jsp:include page="menu.jsp"/>
 <a href="viewcontacts.htm" >Check All Contacts</a><br>

 <table border="1" cellpadding="5" cellspacing="5">
            <tr>
                <td><b>CITY</b></td>
                <td><b>ID</b></td>
                
            </tr>
            
                <tr>
                    <td>${u.profile.city}</td>
                    <td>${u.profile.profileId}</td>
                    
                    
                   
                   
                </tr>
            
        </table>
</body>
</html>