
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<div class="container mt-5">
    <h2>Danh sách món</h2>
    <table class="table">
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Description</th>
                <th>Quantity</th>
                <th>Price</th>
                <th>Type</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
            <!-- Loop through the product list -->
            <c:forEach var="product" items="${listProduct}">
                <tr>
                    <td>${product.id}</td>
                    <td>${product.name}</td>
                    <td>${product.description}</td>
                    <td>${product.quantity}</td>
                    <td>${product.price}</td>
                    <td>${product.type == 1 ? 'Drink' : 'Food'}</td>
                    <td>
                        <!-- Add any actions you want (e.g., edit, delete) -->
                        <!-- For example: -->
                        <a href="admin-quanlymon-update?id=${product.id}" class="btn btn-primary btn-sm">Edit</a>
                        <a href="admin-quanlymon?action=delete&id=${product.id}" class="btn btn-danger btn-sm">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>

<%
    String action = request.getParameter("action");
    String id = request.getParameter("id");
%>


<c:if test="${action == null && id == null}">
<div style="width: 50%; margin: auto; padding-top: 100px"  >
    <h1>Form Món ăn</h1>
    <form style="width: 100%;" method="post">
    <div class="form-group"  method="post">
      <label for="exampleInputEmail1">Tên món ăn</label>
      <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Nhập tên món" name="name">
    </div>
    <div class="form-group">
      <label for="exampleInputPassword1">Mô tả</label>
      <input type="text" class="form-control" id="exampleInputPassword1" placeholder="mô tả" name="description">
    </div>
    <div class="form-group">
      <label for="exampleInputPassword1">Số lượng</label>
      <input type="text" class="form-control" id="exampleInputPassword1" placeholder="số lượng" name="quantity">
    </div>
    <div class="form-group">
    <label>Loại</label>
    <div class="form-check">
      <input type="radio" class="form-check-input" id="drinkRadio" name="type" value="1" checked>
      <label class="form-check-label" for="drinkRadio">Đồ uống</label>
    </div>
    <div class="form-check">
      <input type="radio" class="form-check-input" id="foodRadio" name="type" value="0">
      <label class="form-check-label" for="foodRadio">Đồ ăn</label>
    </div>
  </div>
    <div class="form-group">
      <label for="exampleInputPassword1">Giá</label>
      <input type="text" class="form-control" id="exampleInputPassword1" placeholder="giá món" name="price">
    </div>
    <button type="submit" class="btn btn-primary">Thêm món</button>
  </form>
</div>
</c:if>


