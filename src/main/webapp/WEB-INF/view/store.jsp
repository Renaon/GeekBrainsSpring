<%@ include file="header.jsp" %>

<body modelAttribute="products">
<h1>Store</h1>
	<ul>
        <c:forEach var="item" items="${products}">
            <li>${item.title}</li>
            <li>${item.price}</li>
        </c:forEach>
    </ul>

</body>
<%@ include file="footer.jsp" %>