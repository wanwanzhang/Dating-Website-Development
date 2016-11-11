<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Profile Added Successfully</title>
    </head>
    <body>
        Your Profile is Added Successfully: ${user.username}<br>
        
        <a href="home.htm">let's Get Start !!!</a><br>
        <form>
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
        </form>
    </body>
</html>