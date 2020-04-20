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
    <div class="row">
        <div class="col-md-12 text-center py-3">
            <div class="h2">ДОБАВИТЬ СТУДЕНТА В ГРУППУ</div>
        </div>
    </div>
    <form action="${pageContext.request.contextPath}/addStudentToGroup" method="post">
        <div class="row justify-content-center">
            <div class="col-md-6">
                <div class="row justify-content-center pt-1">
                    <h4>ГРУППЫ</h4>
                </div>
                <c:forEach items="${groups}" var="group">
                    <div class="row justify-content-center pt-1">
                        <div class="form-check text-center">
                            <input class="form-check-input" type="radio" name="idGroup" id="idGroup"
                                   value="${group.id}">
                            <label class="form-check-label" for="idGroup">
                                    ${group.name}
                            </label>
                        </div>
                    </div>
                </c:forEach>
            </div>
            <div class="col-md-6">
                <div class="row justify-content-center pt-1">
                    <h4>СТУДЕНТЫ</h4>
                </div>
                <c:forEach items="${students}" var="student">
                    <div class="row justify-content-center pt-1">
                        <div class="form-check text-center">
                            <input class="form-check-input" type="radio" name="idStudent" id="idStudent"
                                   value="${student.id}">
                            <label class="form-check-label" for="idStudent">
                                    ${student.firstname} ${student.lastname}
                            </label>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
        <div class="form-group text-center">
            <button type="submit" class="btn btn-primary">Добавить</button>
        </div>
    </form>
</div>
</body>
</html>
