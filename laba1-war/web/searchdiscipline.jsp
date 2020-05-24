<%@page  contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Результати пошуку</title>
    </head>
    <body> 
    <center>
    <h1>Результати пошуку: </h1>  
    <table border="1">
<tr><th>Назва дисципліни</th><th>Ім`я викладача</th><th>Прізвище викладача</th></tr>   
           <c:forEach var="discipline" items="${disciplines}">
                 <tr><td>${discipline.discipline}</td>
                   <td>${discipline.lecturers}</td>  
                   <td>${discipline.lecturerssn}</td>  
                          
</form> </td> </tr></c:forEach> </table>        
<p><a href=index.html> Повернутися на головну</a></p></center>
</body>
</html>
