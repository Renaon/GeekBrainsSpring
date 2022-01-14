<%@ include file="header.jsp" %>
<%@ page import="ru.geekbrains.hw3.repositories.ProductsRepository" %>

<body modelAttribute="productsRepository">
<h1>Store</h1>
	<%
		for(int i=0; i<productsRepository.size(); i++){
			String printTitle = productsRepository.getTitleById(i);
			int printPrice = productsRepository.getPriceById(i);
			%>
			${printTitle}
			${printTitle}
			<%
		}
	%>

</body>
<%@ include file="footer.jsp" %>