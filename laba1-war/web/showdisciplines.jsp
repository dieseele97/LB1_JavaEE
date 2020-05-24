<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Управління системою дистанційного навчання</title>
    </head>
    <body> 
    <center>
    <h1>Управління системою дистанційного навчання</h1>
    <h2>Редагування назви дисципліни</h2>
    <table border="1">
<tr><th>Назва дисципліни</th><th></th></tr>   
           <c:forEach var="discipline" items="${disciplines}">
                 <tr><td>${discipline.discipline}</td>        
<td><a href='<c:url value="/UpdateSelectDisciplines?disid=${discipline.disid}" />'>Редагувати</a>    |
<form method="post" action='<c:url value="/DeleteDiscipline" />' style="display:inline;">
<input type="hidden" name="disid" value="${discipline.disid}">
<input type="submit" value="Видалити">
</form> </td> </tr></c:forEach> </table>        
<p><a href=index.html> Повернутися на головну</a></p></center>
</body>
</html>
