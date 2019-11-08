<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header.jsp"/>

<h1>Add product page</h1>

<form action="${pageContext.request.contextPath}/add/product" method="POST" enctype="multipart/form-data">
  <div class="form-group">
    <label for="exampleInputEmail1">Product Name</label>
    <input type="text" name="name" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter name">
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1">Price</label>
    <input type="number" name="price" class="form-control" id="exampleInputPassword1" placeholder="Enter price">
  </div>
  <div class="form-group form-check">
    <input type="checkbox" name="isTopProduct" class="form-check-input" id="exampleCheck1">
    <label class="form-check-label" for="exampleCheck1">This is top product</label>
  </div>
  <div class="form-group">
      <label for="exampleFormControlFile1">Product picture</label>
      <input type="file" name="image" class="form-control-file" id="exampleFormControlFile1">
  </div>
  <button type="submit" class="btn btn-primary">Submit</button>
</form>
<c:forEach var="error" items="${errors}">
<h2 color="red">${error.defaultMessage}</h2>
</c:forEach>
<jsp:include page="footer.jsp"/>