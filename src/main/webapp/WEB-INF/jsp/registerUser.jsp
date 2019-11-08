<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="header.jsp"/>

<h1>Register New User</h1>

<form action="${pageContext.request.contextPath}/register" method="POST">
  <div class="form-group">
    <label for="name">Last and Second Name</label>
    <input type="text" name="name" class="form-control" id="name" placeholder="Enter your name">
  </div>
  <div class="form-group">
    <label for="email">Email</label>
    <input type="email" name="email" class="form-control" id="email" placeholder="Enter email">
  </div>
  <div class="form-group">
      <label for="username">User Login</label>
      <input type="text" name="username" class="form-control" id="username" placeholder="Enter login">
    </div>
  <div class="form-group">
      <label for="password">Password</label>
      <input type="password" name="password" class="form-control" id="password" placeholder="Password">
  </div>
  <div class="form-group">
    <select name="role" id="role" class="form-control">
        <c:forEach var="role" items="${roles}">
        <option>${role}</option>
        </c:forEach>
    </select>
  </div>
  <button type="submit" class="btn btn-primary">Submit</button>
</form>

<jsp:include page="footer.jsp"/>