<%@ page import="by.epam.task4.java.model.entity.Client" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Osten
  Date: 14.05.2018
  Time: 5:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>main</title>
    <script type="text/javascript">
        <!--
    function deleteFun($type,$id) {
    window.location.href = '/main?type='+$type+'&id='+$id;
    }
    function insertFun($type,$p1,$p2,$p3,$p4) {
    window.location.href = '/main?type='+$type+'&name='+$p1+'&patronymic='+$p2+'&surname='+$p3+'&birthday='+$p4;
        }
        function updateFun($type,$id,$p1,$p2,$p3,$p4) {
            window.location.href = '/main?type='+$type+'&id='+$id+'&name='+$p1+'&patronymic='+$p2+'&surname='+$p3+'&birthday='+$p4;
        }
        //-->
    </script>
    <style type="text/css">
        th {border-bottom: 1px solid grey;}
        td {border-bottom: 1px solid grey; border-spacing: 10px 40px;}
        tr {border-bottom: 1px solid grey;}
        caption {
            caption-side: bottom;
            text-align: right;
            padding: 10px 0;
            font-size: 14px;
        }
        table { border-collapse: separate; border-spacing: 10px 20px;
        border: 1px solid grey;
        }
    </style>
</head>
<body>
<table>
    <caption>Таблица Пользователей</caption>

    <%
        out.println("<tr><th>ID</th><th>Name</th><th>Patronymic</th>"+
                "<th>Surname</th><th>Birthday</th></tr>");
        ArrayList<Client> clients = (ArrayList<Client>)request.getAttribute("clients");
        for(Client client: clients) {
            out.println("<tr><td>"+client.getId()+"</td><td>"+client.getName()+"</td><td>"+client.getPatronymic()+"</td>"+
                    "<td>"+client.getSurname()+"</td><td>"+client.getBirthday()+"</td></tr>");
        }
    %>
</table>
    <input type="text" id="ID_delete" name="inputID" value="ID">
    <input type="submit" value="Delete" onclick="deleteFun('delete', document.getElementById('ID_delete').value);">
    <br><br>
<input type="text" id="Insert_Name" name="inputName" value="name">
<input type="text" id="Insert_Patronymic" name="inputPatronymic" value="patronymic">
<input type="text" id="Insert_Surname" name="inputSurname" value="surname">
<input type="text" id="Insert_Birthday" name="inputBirthday" value="birthday">

    <input type="submit" value="Insert" onclick="insertFun('insert', document.getElementById('Insert_Name').value,
                                                                     document.getElementById('Insert_Patronymic').value,
                                                                      document.getElementById('Insert_Surname').value,
                                                                       document.getElementById('Insert_Birthday').value);">
    <br><br>
<input type="text" id="Edit_ID" name="inputID" value="ID">
<input type="text" id="Edit_Name" name="inputName" value="name">
<input type="text" id="Edit_Patronymic" name="inputPatronymic" value="patronymic">
<input type="text" id="Edit_Surname" name="inputSurname" value="surname">
<input type="text" id="Edit_Birthday" name="inputBirthday" value="birthday">

    <input type="submit" value="Edit" onclick="updateFun('edit', document.getElementById('Edit_ID').value,
                                                                     document.getElementById('Edit_Name').value,
                                                                     document.getElementById('Edit_Patronymic').value,
                                                                      document.getElementById('Edit_Surname').value,
                                                                       document.getElementById('Edit_Birthday').value);">
    <br>
</body>
</html>
