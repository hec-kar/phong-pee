<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<div style="width: 60%;
            margin:auto;
            margin-top: 100px; /* Optional: Add margin for spacing */
            border-collapse: collapse;
            margin-bottom: 200px;
            text-align: center;">
    <h1>Danh sách đơn hàng</h1>
    <table class="table" >
        
  <thead>
    <tr>
      <th scope="col">Id đơn hàng</th>
      <th scope="col">Địa chỉ (Ghi chú)</th>
      <th scope="col">Thời gian đặt</th>
      <th scope="col">Thời gian dự kiến</th>
      <th scope="col">Hành động</th>
    </tr>
  </thead>
  <tbody>
      <c:forEach items="${listOrder}" var="order">
          <c:if test="${order.status == 0}">
            <tr>
            <th scope="row">${order.order_id}</th>
            <td>${order.note}</td>
            <td>${order.date}</td>
            <td>${order.due_time} phút</td>
            <td><a href="./admin-chitietdonhang?order_id=${order.order_id}"><button class="btn btn-primary">Xem chi tiết đơn hàng</button></a></td>
          </tr>
          </c:if>
          
      </c:forEach>
    
  </tbody>
</table>
</div>
