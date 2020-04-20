<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

    <title>Система учета студентов</title>


    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
            integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
            integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
            crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
            integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
            crossorigin="anonymous"></script>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="#">Студенты</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="/">главная <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownGroup" role="button"
                   data-toggle="dropdown"
                   aria-haspopup="true" aria-expanded="false">
                    группы
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <a class="dropdown-item" href="${pageContext.request.contextPath}/showAllGroups">все группы</a>
                    <a class="dropdown-item" href="${pageContext.request.contextPath}/addGroup">добавить группу</a>
                    <a class="dropdown-item" href="${pageContext.request.contextPath}/addStudentToGroup">добавить
                        студента в группу</a>
                </div>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownStudent" role="button"
                   data-toggle="dropdown"
                   aria-haspopup="true" aria-expanded="false">
                    студенты
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <a class="dropdown-item" href="${pageContext.request.contextPath}/showAllStudents">все студенты</a>
                    <a class="dropdown-item" href="${pageContext.request.contextPath}/addStudent">добавить студента</a>
                </div>
            </li>
        </ul>
    </div>
</nav>
<div class="container">
    <div class="row justify-content-center py-3">
        <input type="text" value="${student.id}" name="id" hidden>
        <div class="form-group text-center form-check-inline">
            <label for="idStudent">id </label>
            <input type="text" value="${student.id}" class="form-control" id="idStudent" name="idStudent" disabled>
        </div>
        <div class="form-group text-center form-check-inline">
            <label for="firstname">Имя </label>
            <input type="text" value="${student.firstname}" class="form-control" id="firstname" name="firstname"
                   disabled>
        </div>
        <div class="form-group text-center form-check-inline">
            <label for="lastname">Фамилия </label>
            <input type="text" value="${student.lastname}" class="form-control" id="lastname" name="lastname"
                   disabled>
        </div>
    </div>
    <div class="row justify-content-center">
        <div class="h4 text-center">Группы студента</div>
    </div>
    <div class="row justify-content-center">
        <div class="list-group text-center">
            <c:forEach items="${groups}" var="group">
                <a href="${pageContext.request.contextPath}/showGroup?id=${group.id}"
                   class="list-group-item list-group-item-action">${group.name}</a>
            </c:forEach>
        </div>
    </div>
</div>
</body>
</html>