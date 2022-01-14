<%@ include file="header.jsp" %>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Adding product</title>
</head>
<body>
    <h1>Add a product </h1>
    <form:form modelAttribute="product" method="post">
        <form:input path="title" type='text'/>
        <br>
        <form:input path="price"type='text'/>
        <br>
        <button>Submit</button>
    </form:form>
</body>


<%@ include file="footer.jsp" %>