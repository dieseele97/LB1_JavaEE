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
    <h2>Редагування ім'я та прізвища викладача</h2>
    <table border="1">
<tr><th>Ім'я викладача</th><th>Прізвище викладача</th><th></th></tr>   
           <c:forEach var="lecturer" items="${lecturers}">
                 <tr><td>${lecturer.name}</td>
                     <td>${lecturer.surname}</td>   
                     
<td><a href='<c:url value="/UpdateSelectLecturers?lectid=${lecturer.lectid}" />'>Редагувати</a>    |
<form method="post" action='<c:url value="/DeleteLecturers" />' style="display:inline;">
<input type="hidden" name="lectid" value="${lecturer.lectid}">
<input type="submit" value="Видалити">
</form> </td> </tr></c:forEach> </table>        
<p><a href=index.html> Повернутися на головну</a></p></center>
</body>
</html>
