<jsp:include page="header.jsp"/>

<h1>${item.name}</h1>

<div class="card" style="width: 18rem;">
  <img src="${pageContext.request.contextPath}/product/item/${item.id}/image" class="card-img-top" alt="...">
  <div class="card-body">
    <h5 class="card-title">${item.price} BYN</h5>
    <p class="card-text">Product S/N ${item.id}</p>
    <a href="#" class="btn btn-primary">Buy</a>
  </div>
</div>

<jsp:include page="footer.jsp"/>