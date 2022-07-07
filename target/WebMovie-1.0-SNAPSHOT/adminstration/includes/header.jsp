<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">

<head>
    <meta charset="utf-8"/>
    <link rel="icon" type="image/png" sizes="16x16"  href="../favicons/favicon-16x16.png">
    <meta name="msapplication-TileColor" content="#ffffff">
    <meta name="theme-color" content="#ffffff">
    <link rel="apple-touch-icon" sizes="76x76" href="../assets/img/apple-icon.png">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
    <title>Admin SobinPhim.TV</title>
    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0, shrink-to-fit=no'
          name='viewport'/>
    <!--     Fonts and icons     -->
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700,200" rel="stylesheet"/>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css"/>
    <!-- CSS Files -->
    <link href="../assets/CSS/bootstrap.min.css" rel="stylesheet"/>
    <link href="../assets/CSS/light-bootstrap-dashboard.css?v=2.0.0 " rel="stylesheet"/>
    <!-- CSS Just for demo purpose, don't include it in your project -->
    <link href="../assets/CSS/demo.css" rel="stylesheet"/>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css">
</head>
<body>
<div class="wrapper">
    <div class="sidebar" data-image="../assets/img/sidebar-5.jpg">
        <!--
    Tip 1: You can change the color of the sidebar using: data-color="purple | blue | green | orange | red"

    Tip 2: you can also add an image using data-image tag
-->
        <div class="sidebar-wrapper">
            <div class="logo">
                <a href="http://fb.com/dungsobin102" class="simple-text">
                    SobinPhim.TV Admin
                </a>
            </div>
            <ul class="nav">
                <li>
                    <a class="nav-link" href="menu">
                        <i class="nc-icon nc-chart-pie-35"></i>
                        <p>Thống kê</p>
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="listphim">
                        <i class="nc-icon nc-atom"></i>
                        <p>List Phim</p>
                    </a>
                </li>
                <li>
                    <a class="nav-link" href="listcategory">
                        <i class="nc-icon nc-notes"></i>
                        <p>Thể loại</p>
                    </a>
                </li>
                <li>
                    <a class="nav-link" href="listactor">
                        <i class="nc-icon nc-paper-2"></i>
                        <p>Diễn viên</p>
                    </a>
                </li>
                <c:if test="${sessionScope.user.role == 3}">
                    <li>
                        <a class="nav-link" href="listuser">

                            <i class="nc-icon nc-circle-09"></i>
                            <p>User</p>
                        </a>
                    </li>
                </c:if>


                <li>
                    <a class="nav-link" href="ads">
                        <i class="nc-icon nc-bell-55"></i>
                        <p>Quảng cáo</p>
                    </a>
                </li>
            </ul>
        </div>
    </div>

    <div class="main-panel">
        <!-- Navbar -->
        <nav class="navbar navbar-expand-lg " color-on-scroll="500">
            <div class="container-fluid">
                <a class="navbar-brand" href="#pablo"> Hi
                    <c:if test="${sessionScope.user.role == 3}">
                        Admin
                    </c:if>
                    <c:if test="${sessionScope.user.role == 2}">
                        BTV
                    </c:if>

                    ${sessionScope.user.username} </a>
                <button href="" class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" aria-controls="navigation-index" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-bar burger-lines"></span>
                    <span class="navbar-toggler-bar burger-lines"></span>
                    <span class="navbar-toggler-bar burger-lines"></span>
                </button>
                <div class="collapse navbar-collapse justify-content-end" id="navigation">
                    </ul>
                    <ul class="navbar-nav ml-auto">
                        <li class="nav-item">
                            <a class="nav-link" href="../home">
                                <span class="no-icon">Đăng nhập với vai trò người dùng</span>
                            </a>
                        </li>
<%--                        <li class="nav-item dropdown">--%>
<%--                            <a class="nav-link dropdown-toggle" href="http://example.com" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">--%>
<%--                                <span class="no-icon">Dropdown</span>--%>
<%--                            </a>--%>
<%--                            <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">--%>
<%--                                <a class="dropdown-item" href="#">Action</a>--%>
<%--                                <a class="dropdown-item" href="#">Another action</a>--%>
<%--                                <a class="dropdown-item" href="#">Something</a>--%>
<%--                                <a class="dropdown-item" href="#">Something else here</a>--%>
<%--                                <div class="divider"></div>--%>
<%--                                <a class="dropdown-item" href="#">Separated link</a>--%>
<%--                            </div>--%>
<%--                        </li>--%>
                        <li class="nav-item">
                            <a class="nav-link" href="../logout">
                                <span class="no-icon">Log out</span>
                            </a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>