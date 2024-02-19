<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="ntphong.utils.API" %>


<c:import url="./inc/_header.jsp"/>
<c:import url="./inc/_nav.jsp"/>


  <div class="container">
  <div class="row">
   <div class="card">
      <div class="row no-gutters">
        <!-- Image Column -->
        <div class="col-md-4">
          <img src="./assets/img/shop/${shop.image}" class="card-img" alt="Store Image">
        </div>
        <!-- Information Column -->
        <div class="col-md-8">
          <div class="card-body">
            <h5 class="card-title">${shop.name}</h5>
            <p class="card-text">${shop.address}</p>
            <p class="card-text">99+ đánh giá trên Phongpee</p>
            <p class="card-text"><a href="#">Xem thêm lượt đánh giá từ Foody</a></p>
            <p class="card-text">Giờ mở cửa: 07:00 - 22:00</p>
          </div>
        </div>
      </div>
    </div>
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
                <a href="
                    <c:if test="${user==null}">
                    login
                    </c:if>
                    <c:if test="${user!=null}">
                        quanan?shop_id=${shop.shop_id}&id_product=${product.id}
                    </c:if>
                   " class="btn btn-warning btn-add-to-cart">Thêm vào giỏ hàng</a>
            </li>
        </ul>
    </c:forEach>
    </div>
           
</div>
   
<c:import url="./inc/_footer.jsp"/>