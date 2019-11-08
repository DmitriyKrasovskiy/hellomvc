<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="header.jsp"/>

<h1>Our new products</h1>

<table class="table">
  <thead class="thead-light">
    <tr>
      <th scope="col">S/N</th>
      <th scope="col">Product Name</th>
      <th scope="col">Price</th>
    </tr>
  </thead>
  <tbody>
    <c:forEach var="item" items="${items}">
    <tr>
      <th scope="row">${item.id}</th>
      <td><a href="${pageContext.request.contextPath}/product/item/${item.id}">${item.name}</a></td>
      <td>${item.price}</td>
    </tr>
    </c:forEach>
  </tbody>
</table>

<jsp:include page="footer.jsp"/>
