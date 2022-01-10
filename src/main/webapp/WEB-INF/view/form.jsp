<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html lang="ru" xmlns:form="http://www.w3.org/1999/xhtml" xmlns:th="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Введите Ваше имя</title>
</head>
<body>
    <form:form action="processForm" modelAttribute="product">
        <legend><h1>Добавить товар </h1></legend>
        Title: <form:input path="title" />
        <br>
        Cost: <form:input path="price" />
        <br>
        <input type="submit" value="Submit" />
    </form:form>
</body>
</html>