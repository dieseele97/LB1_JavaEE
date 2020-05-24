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
<h2>Змінити назву дисципліни</h2>
 <form onSubmit="return check3()" method="post" action="UpdateDisciplines">
<input type="hidden" value="${disciplines.disid}" name="disid" />
<label>Редагувати назву дисципліни</label><br>
<input name="discipline" value="${disciplines.discipline}" id="newdiscipline"/><br><br>
<input type="submit" value="Редагувати" />
</form>
<script type="text/javascript" language="javascript">
function check3(){
var newdiscipline = document.getElementById("newdiscipline");
if (newdiscipline.value.length==""){
            alert("Введіть іназву дисципліни!!!");
             return false;
        }
    }
</script>
<p><a href=index.html> Повернутися на головну</a></p>
</center>
</body>
</html>
