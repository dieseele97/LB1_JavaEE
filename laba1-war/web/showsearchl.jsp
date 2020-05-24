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
        <tr><th>Ім'я викладача</th><th>Прізвище викладача</th><th>Дисципліна</th></tr>   
           <c:forEach var="lecturer" items="${lecturers}">
                 <tr><td>${lecturer.name}</td>
                   <td>${lecturer.surname}</td>
                   <td>${lecturer.discipline}</td>
                    </c:forEach>   
</form>  </tr> </table>        
<p><a href=index.html> Повернутися на головну</a></p></center>
</body>
</html>