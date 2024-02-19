
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<div >
    <table class="table" >
  <thead>
    <tr>
      <th scope="col">Id đơn hàng</th>
      <th scope="col">Địa chỉ (Ghi chú)</th>
      <th scope="col">Thời gian đặt</th>
      <th scope="col">Thời gian dự kiến</th>
    </tr>
  </thead>
  <tbody>
            <tr>
            <th scope="row">${order.order_id}</th>
            <td>${order.note}</td>
            <td>${order.date}</td>
            <td>${order.due_time} phút</td>
          </tr>
  </tbody>
</table>
</div>

<div class="col-md-18" style="margin-top: 100px">
    <c:forEach items="${listProduct}" var="product">
        <ul class="list-group" style="height: 200px; width: auto; ">
            <li class="list-group-item d-flex justify-content-between align-items-center">
                <img src="./assets/img/food/${product.image}" alt="${product.image}" width="100" class="flex-shrink-0">
                <div class="product-info flex-fill" style="margin-left: 20px">
                    <h5 class="product-name">${product.name}</h5>
                    <p class="product-description">${product.description}</p>
                    <c:set var="money" value="${product.getPrice()}"></c:set>
                    <p class="product-price">${API.numberToMoney(product.getPrice())}</p>
                    <p class="product-quantity">Số lượng: ${product.quantity}</p>
                </div>
            </li>
        </ul>
    </c:forEach>
</div>
          
          <form action="#" method="post">
              <button type="submit" value="${order.order_id}" onclick="showSuccess()" class="btn btn-primary">Xác nhận đơn hàng</button>
          </form>
          
          <script> 
              function showSuccess() {
                  window.alert("Xác nhận thành công!!");
              }
          </script>