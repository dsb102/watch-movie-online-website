<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="icon" type="image/png" sizes="16x16"  href="favicons/favicon-16x16.png">
    <meta name="msapplication-TileColor" content="#ffffff">
    <meta name="theme-color" content="#ffffff">
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="assets/CSS/style.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link
            href="https://fonts.googleapis.com/css2?family=Roboto:wght@100;300;400;500;700&family=Sen:wght@400;700;800&display=swap"
            rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <meta charset="UTF-8">

    <title>SobinPHIM - Website xem phim trực tuyến miễn phí</title>
    <style>
        .mobile-container {
            max-width: 480px;
            margin: auto;
            background-color: #555;
            height: 500px;
            color: white;
            border-radius: 10px;
        }

        .topnav {
            overflow: hidden;
            background-color: RGB(0, 0, 0);
            position: relative;
        }

        .topnav #myLinks {
            display: none;
            height: 100vh;
        }

        .topnav a {
            color: white;
            padding: 14px 16px;
            text-decoration: none;
            font-size: 17px;
            display: block;
        }

        .topnav a.icon {
            background: black;
            display: block;
            position: absolute;
            right: 0;
            top: 0;
        }

        .topnav a:hover {
            background-color: #ddd;
            color: black;
        }

        .active {
            background-color: #04AA6D;
            color: white;
        }
        .header-mobile {
            display: none;
        }
        @media only screen and (max-width: 1024px) {
            .header {
                display: none;
            }
            .header-mobile{
                display: block;
            }
            .topnav a {
                text-align: center;
            }

        }


    </style>
</head>
<body>
<header>
    <div class="header">
        <div class="navbar">
            <div class="logo-container">
                <a href="home">
                    <img class="logo" src="assets/img/logo.png" alt="">
                </a>
            </div>
            <div class="search-container">
                <form action="search" method="">
                    <input class="search-input" value="${key}" oninput="searchByName(this)" type="text" name="searchKey" placeholder="Tìm kiếm tên phim">
                    <button type="submit">
                        <i class="fa-solid fa-magnifying-glass btn-search-icon"></i>
                    </button>
                </form>
            </div>
            <div class="log-container">
                <c:if test="${sessionScope.user == null}">
                    <a href="register" class="btn btn-register">Đăng ký</a>
                </c:if>
                <c:if test="${sessionScope.user == null}">
                    <a href="login" class="btn btn-login">Đăng nhập</a>
                </c:if>
                <c:if test="${sessionScope.user != null}">
                    <a href="logout" class="btn btn-login">Đăng xuất</a>
                </c:if>
                <c:if test="${sessionScope.user != null && sessionScope.user.role  > 1}">
                    <a href="adminstration/menu" class="btn btn-login">Quản lý</a>
                </c:if>
                <c:if test="${sessionScope.user != null}">
                    <a href="favorite" class="btn btn-login">Yêu thích</a>
                </c:if>

            </div>
        </div>

        <div class="menu-container">
            <ul class="root-menu">
                <li><a href="home"
                <%--                   class="menu-active"--%>
                >Trang Chủ</a></li>
                <li><a href="serie">Phim Bộ</a></li>
                <li><a href="single">Phim Lẻ</a></li>
                <li><a href="shows">Shows</a></li>
                <li><a href="cartoon">Hoạt Hình</a></li>
                <li>
                    <a href="search">
                        <span>Thể Loại</span>
                        <i class="fa fa-angle-down menu-icon" aria-hidden="true">
                        </i>
                    </a>

                    <ul class="submenu">
                        <c:forEach items="${requestScope.categories}" var="category">
                            <li><a href="category?id=${category.id}">${category.name}</a></li>
                        </c:forEach>
                    </ul>
                </li>
                <%--            <li>--%>
                <%--                <a href="national" class="menu-li-nation">--%>
                <%--                    <span>Quốc gia</span>--%>
                <%--                    <i class="fa fa-angle-down menu-icon" aria-hidden="true">--%>
                <%--                    </i>--%>
                <%--                </a>--%>

                <%--                <ul class="submenu">--%>
                <%--                    <c:forEach items="${requestScope.categories}" var="category">--%>
                <%--                        <li><a href="#">${category.name}</a></li>--%>
                <%--                    </c:forEach>--%>
                <%--                </ul>--%>
                <%--            </li>--%>
            </ul>
        </div>
    </div>

    <div class="header-mobile">
        <div class="topnav">
            <a href="home">
                <img class="logo" style="height: 100px;" src="assets/img/logo.png" alt="">
            </a>
            <div id="myLinks">
                <a href="home">Trang Chủ</a>
                <a href="serie">Phim Bộ</a>
                <a href="single">Phim Lẻ</a>
                <a href="shows">Shows</a>
               <a href="cartoon">Hoạt Hình</a>

                <c:if test="${sessionScope.user == null}">
                    <a href="register" class="">Đăng ký</a>
                </c:if>
                <c:if test="${sessionScope.user == null}">
                    <a href="login" class="">Đăng nhập</a>
                </c:if>
                <c:if test="${sessionScope.user != null}">
                    <a href="logout" class="">Đăng xuất</a>
                </c:if>
                <c:if test="${sessionScope.user != null && sessionScope.user.role  > 1}">
                    <a href="adminstration/menu" class="">Quản lý</a>
                </c:if>
                <c:if test="${sessionScope.user != null}">
                    <a href="favorite" class="">Yêu thích</a>
                </c:if>
            </div>
            <a href="javascript:void(0);" class="icon" onclick="myFunction()">
                <i class="fa fa-bars"></i>
            </a>
        </div>
    </div>

</header>


<script>
    function myFunction() {
        var x = document.getElementById("myLinks");
        if (x.style.display === "block") {
            x.style.display = "none";
        } else {
            x.style.display = "block";
        }
    }
</script>
