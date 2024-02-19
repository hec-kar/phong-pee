<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="ntphong.utils.API" %>
     <!-- NAV -->
        <nav class="navbar navbar-expand-lg bg-body-tertiary ">
            <div class="container-fluid" style="width:  80%">
                <a class="nav-link" href="./home">
                <img src="./assets/img/icon/shopeefoodvn.png" alt="alt"/>
                </a>
          <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
          </button>
          <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
              <c:if test="${user == null}">
                <li class="nav-item">
                <a class="nav-link" href="./login">Login</a>
                </li>
              </c:if>
              <c:if test="${user != null}">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                      Hi 
                      <c:set var="s" value="${user.getName()}"> </c:set>
                        <% 
                        String name = (String)pageContext.getAttribute("s");
                        if (name != null) {
                            out.print(API.getName(name));
                        }
                        %>
                    </a>
                    <ul class="dropdown-menu">
                        <li><a class="dropdown-item" href="#">Profile</a></li>
                        <li><a class="dropdown-item" href="./views/logout.jsp">Log out</a></li>
                    </ul> 
                </li>
              </c:if>
              <li class="nav-item">
                <a class="nav-link" href="shopping-cart">
                  <span class="badge badge-pill bg-danger">${cart.size()}</span>
                  <span><i class="fas fa-shopping-cart"></i></span>
                </a>
              </li>
            </ul>
              
                  <form class="d-flex" role="search" action="#" method="get">
                <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search" name="query">
              <button class="btn btn-outline-success" type="submit">Search</button>
            </form>
          </div>
        </div>
      </nav>
<!-- NAV -->