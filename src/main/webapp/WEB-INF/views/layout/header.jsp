<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 3/21/2023
  Time: 11:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link
        href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
        rel="stylesheet"
        integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
        crossorigin="anonymous"
/>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/home.css">
<div class="container">
    <div class="row">
        <div class="col-lg-3">
            <a href="/home" role="img"><img src="/banner/logo.png" alt="" width="100px"/></a>
        </div>
        <div class="col-lg-6">
            <form class="d-flex" role="search">
                <input
                        class="form-control me-2"
                        type="search"
                        placeholder="Search"
                        aria-label="Search"
                />
                <button class="btn btn-outline-success" type="submit">Search</button>
            </form>
        </div>
        <div class="col-lg-3">
            <a href="/login" class="aheader" id="koko">Login</a>
            <a
                    href=""
                    class="aheader"
                    id="kko"
                    style="display: none"
            >Đăng xuất</a
            >
            <a href="" class="aheader">My page</a>
            <button
                    type="button"
                    class="btn btn-primary position-relative"
                    id="heart"
            >
                <a href="/cart"
                ><img
                        src="/banner/353439-basket-buy-cart-ecommerce-online-purse-shop-shopping_107515.png"
                        alt=""
                /></a>
                <span
                        class="position-absolute top-0 start-100 translate-middle badge rounded-pill bg-danger"
                        id="icon_header"
                >
          ${quantity}
          <span class="visually-hidden">unread messages</span>
        </span>
            </button>
        </div>
    </div>
    <div class="row">
        <div class="col-lg-12">
            <nav class="navbar navbar-expand-lg">
                <div class="container-fluid">
                    <div class="collapse navbar-collapse" id="navbarSupportedContent">
                        <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                            <li class="nav-item">
                                <a class="nav-link active" aria-current="page" href="/home"
                                >Home</a
                                >
                            </li>
                            <li class="nav-item">
                                <a class="nav-link active" aria-current="page" href="/product-details/view-all"
                                >Product Details</a
                                >
                            </li>
                            <div class="dropdown">
                                <button class="btn btn-secondary dropdown-toggle" type="button"
                                        data-bs-toggle="dropdown" aria-expanded="false">
                                    Manage
                                </button>
                                <ul class="dropdown-menu">
                                    <li><a class="dropdown-item" href="/customer/view-all">Customer</a></li>
                                    <li><a class="dropdown-item" href="/category/view-all">Category</a></li>
                                    <li><a class="dropdown-item" href="/color/view-all">Color</a></li>
                                    <li><a class="dropdown-item" href="/capacity/view-all">Capacity</a></li>
                                    <li><a class="dropdown-item" href="/product-line/view-all">Product Line</a></li>
                                    <li><a class="dropdown-item" href="/manufacturer/view-all">Manufacturer</a></li>
                                    <li><a class="dropdown-item" href="/search-bill">Search Bill</a></li>
                                </ul>
                            </div>
                            <li class="nav-item">
                                <a class="nav-link active" aria-current="page" href="/introduce"
                                >Introduce</a
                                >
                            </li>
                            <li class="nav-item">
                                <a class="nav-link active" aria-current="page" href="/contact"
                                >Contact</a
                                >
                            </li>
                        </ul>
                    </div>
                </div>
            </nav>
        </div>
    </div>
</div>
