<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<jsp:include page="header.jsp"/>

<h1>Search Result</h1>
<sec:authorize access="hasRole('ADMIN')">
<a class="btn btn-primary" href="${pageContext.request.contextPath}/add" role="button">Add new product</a>
</sec:authorize>
<table class="table">
  <thead class="thead-light">
    <tr>
      <th scope="col">S/N</th>
      <th scope="col">Product Name</th>
      <th scope="col">Price</th>
      <th scope="col">Top Product</th>
    </tr>
  </thead>
  <tbody>
    <c:forEach var="item" items="${items}">
    <tr>
      <th scope="row">${item.id}</th>
      <td>${item.name}</td>
      <td>${item.price}</td>
      <c:choose>
          <c:when test="${item.isTopProduct()}">
              <td>Yes</td>
          </c:when>
          <c:otherwise>
              <td>No</td>
          </c:otherwise>
      </c:choose>
    </tr>
    </c:forEach>
  </tbody>
</table>

<jsp:include page="footer.jsp"/>