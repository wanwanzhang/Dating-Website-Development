<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Created Successfully</title>
    </head>
    <body>
        Your account is Created Successfully: ${user.username}<br>
       <table>
    <tr>
    <td>Last Name:</td>
    <td>${user.lastName}</td>
    </tr>
    <tr>
    <td>First Name:</td>
    <td>${user.firstName}</td>
    </tr>
    <tr>
    <td>UserName:</td>
    <td>${user.username} </td>
    </tr>
    <tr>
    <td>Password:</td>
    <td>${user.password} </td>
    </tr>
    <tr>
    <td>Email:</td>
    <td>${user.email.emailId}</td>
    </tr>
    <tr>
    <td>Photo:</td>
    <td>${user.photoName}</td>
    </tr>
    </table>

       <form action='uploadfile.htm' method="post"  enctype="multipart/form-data">
               Select Photo (Max Size: 5MB): 
               <input name="photo" type="file" id="photo" />
              <br/><br/>
                
                <input type="hidden" name="action" value="addphoto" />
                <input type="submit" value="Add Photo"/>
                
                
                 
      </form>
    </body>
</html>