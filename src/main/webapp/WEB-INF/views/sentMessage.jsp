<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Profile Added Successfully</title>
    </head>
    <body>
        Your message is sent Successfully: ${user.username}<br>
        <table>
        <tr>
        From User: <td>${message.username}</td>
        </tr>
        <tr>
        To: <td>${message.touser}</td>
        </tr>
        <tr>
        Message:<td>${message.message}</td>
        </tr>
        </table>
        
        <a href="viewmessage.htm">view Message!!!</a><br>
    </body>
</html>