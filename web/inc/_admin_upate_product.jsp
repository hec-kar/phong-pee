

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>



<c:forEach var="product" items="${listProduct}">
<c:if test="${id == product.id}">
<div style="width: 50%; margin: auto; padding-top: 100px"  >
    <h1>Form Món ăn</h1>
    <form style="width: 100%;" action="#" method="post">
        <input type="text" hidden class="form-control" id="exampleInputPassword1" placeholder="giá món" name="product_id" value="${product.id}">
    <div class="form-group">
      <label for="exampleInputEmail1">Tên món ăn</label>
      <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Nhập tên món" name="name" value="${product.name}">
    </div>
    <div class="form-group">
      <label for="exampleInputPassword1">Mô tả</label>
      <input type="text" class="form-control" id="exampleInputPassword1" placeholder="mô tả" name="description" value="${product.description}">
    </div>
    <div class="form-group">
      <label for="exampleInputPassword1">Số lượng</label>
      <input type="text" class="form-control" id="exampleInputPassword1" placeholder="số lượng" name="quantity" value="${product.quantity}">
    </div>
    <div class="form-group">
    <label>Loại</label>
    <div class="form-check">
        <input type="radio" class="form-check-input" id="drinkRadio" name="type" value="1"
            <c:if test="${product.type == 1}">checked</c:if>
        >
        <label class="form-check-label" for="drinkRadio">Đồ uống</label>
    </div>
    <div class="form-check">
        <input type="radio" class="form-check-input" id="foodRadio" name="type" value="0"
            <c:if test="${product.type == 0}">checked</c:if>
        >
        <label class="form-check-label" for="foodRadio">Đồ ăn</label>
    </div>
    </div>
    <div class="form-group">
      <label for="exampleInputPassword1">Giá</label>
      <input type="text" class="form-control" id="exampleInputPassword1" placeholder="giá món" name="price" value="${product.price}">
    </div>
    <button type="submit" class="btn btn-primary">Sửa món</button>
  </form>
</div>
</c:if>
</c:forEach>