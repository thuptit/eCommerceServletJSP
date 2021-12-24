<%-- 
    Document   : head
    Created on : Dec 18, 2021, 11:08:08 PM
    Author     : thunv
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Quản lý đơn hàng</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/all.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/11.1.10/sweetalert2.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/admin_style.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/toastr.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.5.0/Chart.min.js"></script>
</head>
<body>
<input type="checkbox" id="check">
<header>
    <div class="header-toggle">
        <label for="check" style="cursor: pointer;">
            <i class="fas fa-stream"></i>
        </label>
    </div>
    <div class="header-logout d-flex align-items-center">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            <i class="fas fa-user"></i>
            Xin chào
        </a>
        <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
            <li><a class="dropdown-item" href="#"><i class="fas fa-lock"></i>Đổi mật khẩu</a></li>
            <li><a class="dropdown-item" href="#"><i class="fas fa-sign-out-alt"></i>Đăng xuất</a></li>
        </ul>
    </div>
</header>
<div class="sidebar">
    <div class="sidebar-header d-flex align-items-center justify-content-center">
        <h6 class="logo">
            <span>DASH</span>
        </h6>
    </div>
    <div class="sidebar-menu">
        <nav class="nav">
            <ul class="nav-bar">
                <li class="nav-link ">
                    <a href="/eCommerce/admin/dashboard">
                        <span class="nav-icons"><i class="fas fa-home"></i></span>
                        <span class="nav-title">Trang chủ</span>
                    </a>
                </li>
                <li class="nav-link ">
                    <a href="/eCommerce/admin/category">
                        <span class="nav-icons"><i class="fas fa-sort-amount-down-alt"></i></span>
                        <span class="nav-title">Danh mục</span>
                    </a>
                </li>
                <li class="nav-link ">
                    <a href="/eCommerce/admin/book">
                        <span class="nav-icons"><i class="fas fa-list-ul"></i></span>
                        <span class="nav-title">Quản lý sách</span>
                    </a>
                </li>
                <li class="nav-link ">
                    <a href="/eCommerce/admin/publisher">
                        <span class="nav-icons"><i class="fas fa-archway"></i></span>
                        <span class="nav-title">Quản lý NXB</span>
                    </a>
                </li>
                <li class="nav-link">
                    <a href="/eCommerce/admin/author">
                        <span class="nav-icons"><i class="fas fa-users"></i></span>
                        <span class="nav-title">Quản lý tác giả</span>
                    </a>
                </li>
            </ul>
        </nav>
    </div>
</div>
