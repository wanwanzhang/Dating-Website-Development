<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html>
<head>
    <title>Add User Form</title>
            <script>
function checkphoto(){
	var photo = document.getElementById('photo');
	
}
        //AJAX check username if exsit 

        var xmlHttp;
        xmlHttp = GetXmlHttpObject();
        function checkUser() {
        	  if (xmlHttp == null)
              {
                  alert("Your browser does not support AJAX!");
                  return;
              }
              var username = document.getElementById("username").value;
              //var password = document.getElementById("password").value;
              var query = "action=ajaxCheck&name="+username;
              xmlHttp.onreadystatechange = function stateChanged()
              {
                  if (xmlHttp.readyState == 4)
                  {
                      //alert(xmlHttp.responseText);
                      //var json = JSON.parse(xmlHttp.responseText);
                      document.getElementById("error").innerHTML = xmlHttp.responseText;
                  }
              };
              xmlHttp.open("POST", "ajax.htm", true);
              
              xmlHttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
              
              xmlHttp.send(query);
             return false;
          }
          
              
              function GetXmlHttpObject()
              {
                  var xmlHttp = null;
                  try
                  {
                      // Firefox, Opera 8.0+, Safari
                      xmlHttp = new XMLHttpRequest();
                  } catch (e)
                  {
                      // Internet Explorer
                      try
                      {
                          xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
                      } catch (e)
                      {
                          xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
                      }
                  }
                  return xmlHttp;
              }
              
        
        
        </script>
</head>
<body>
 <a href="login.htm" >I am a member login User</a><br>
 <h3>Welcome to Dating Web Site</h3>
<h2>Register a New User</h2>

<form:form action="adduser.htm" commandName="user" method="post" >

<table>
<tr>
    <td>First Name:</td>
    <td><form:input path="firstName" size="30"/> <font color="red"><form:errors path="firstName"/></font></td>
</tr>

<tr>
    <td>Last Name:</td>
    <td><form:input path="lastName" size="30" /> <font color="red"><form:errors path="lastName"/></font></td>
</tr>


<tr>
    <td>User Name:</td>
    <td><form:input path="username" size="30"  id="username" onblur="return checkUser() "/> <font color="red"><form:errors path="username"/></font></td>
    
</tr>

<tr>
    <td>Password:</td>
    <td><form:password path="password" size="30" /> <font color="red"><form:errors path="password"/></font></td>
</tr>

 <tr>
    <td>Email Id:</td>
    <td><form:input path="email.emailId" size="30" /> <font color="red"><form:errors path="email.emailId"/></font></td>
</tr> 


</table>

                <input type="submit" value="Create User"/>
                
                <td colspan="2">
                 
 <div id="error" style="color:red"></div>
</form:form>

 
</body>
</html>