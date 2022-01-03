<%-- 
    Document   : navbar
    Created on : Dec 18, 2021, 8:25:56 PM
    Author     : thunv
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<header class="header">

    <a href="#" class="logo">
        <img src="${pageContext.request.contextPath}/assets/images/logobook.png" alt="">
    </a>

    <nav class="navbar">
        <a href="/eCommerce">trang chủ</a>
        <a href="#about">giới thiệu</a>
        <a href="#menu">danh mục</a>
        <a href="#products">sản phẩm</a>
        <a href="#review">đánh giá</a>
        <a href="#contact">liên hệ</a>
        <a href="#blogs">blogs</a>
    </nav>

    <div class="icons d-flex align-items-center">
        <div class="fas fa-search" id="search-btn"></div>
        <div class="fas fa-shopping-cart" id="cart-btn" style="position: relative" onclick="window.location = '/eCommerce/cart'">
            <span id="countItems"></span>
        </div>
        <a class="ms-4 me-2 link-account" id="btnRegister" style="font-size: 2rem; color: #fff" href="">Đăng ký</a>
        <span style="font-size: 2rem; color: #fff" id="character">/</span>
        <a class=" ms-2 link-account" id="btnLogin" style="font-size: 2rem; color: #fff" href="/eCommerce/login">Đăng nhập</a>
        <a class=" ms-4 link-account" style="font-size: 2rem; color: #fff; text-decoration: none; text-transform: none" href="" id="usernameText"> </a>
        <div class="fas fa-bars" id="menu-btn"></div>
    </div>

</header>