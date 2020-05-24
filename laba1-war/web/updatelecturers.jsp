<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Редагування даних</title>
</head>
<body>
<center>   
<h1>Редагування інформації щодо дистанційного навчання</h1>
<h2>Змінити ім'я та прізвище викладача</h2>
 <form onSubmit="return check3()" method="post" action="UpdateLecturers">
<input type="hidden" value="${lecturers.lectid}" name="lectid" />
<label>Редагувати ім'я викладача</label><br>
<input name="name" value="${lecturers.name}" id="newname" /><br><br>
<label>Редагувати прізвище викладача</label><br>
<input name="surname" value="${lecturers.surname}" id="newsurname"/><br><br>
<input type="submit" value="Редагувати" />
</form>
<script type="text/javascript" language="javascript">
function check3(){
var newname = document.getElementById("newname");
var newsurname = document.getElementById("newsurname") ;
if (newname.value.length==""){
            alert("Введіть ім'я викладача!!!");
             return false;
        }
if (newsurname.value.length==""){
            alert("Введіть прізвище викладача!!!!");
            return false;
        }
    }
</script>
<p><a href=index.html> Повернутися на головну</a></p>
</center>
</body>
</html>
