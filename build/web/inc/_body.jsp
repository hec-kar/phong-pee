<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


 <!-- Products -->
        
        <section>
          <div class="container my-5">
            <header class="mb-4">
              <h3>Quán ăn</h3>
            </header>
            <div class="row">
                <c:forEach items="${listShop}" var="shop">
                        <div class="col-lg-3 col-md-6 col-sm-6 d-flex">
                          <div class="card w-100 my-2 shadow-2-strong">
                            <img src="./assets/img/shop/${shop.image}" class="card-img-top" style="aspect-ratio: 1 / 1" />
                            <div class="card-body d-flex flex-column">
                              <h5 class="card-title">${shop.name}</h5>
                              <p class="card-text">${shop.address}</p>
                              <div class="card-footer d-flex align-items-end pt-3 px-0 pb-0 mt-auto">
                                <a href="./quanan?shop_id=${shop.shop_id}" class="btn btn-warning shadow-0 me-1">Xem thêm</a>
                              </div>
                            </div>
                          </div>
                        </div>
                </c:forEach>
            </div>
          </div>
        </section>
        <!-- Products -->