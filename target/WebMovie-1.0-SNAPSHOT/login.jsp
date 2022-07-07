<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Dũng Sobin
  Date: 5/6/2022
  Time: 10:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="icon" type="image/png" sizes="16x16"  href="favicons/favicon-16x16.png">
    <meta name="msapplication-TileColor" content="#ffffff">
    <meta name="theme-color" content="#ffffff">
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <link rel="stylesheet" href="assets/CSS/login.css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <title>SobinPHIM - Website xem phim trực tuyến miễn phí</title>
</head>
<body>

<!------ Include the above in your HEAD tag ---------->

<div class="wrapper fadeInDown">
    <div id="formContent">
        <!-- Tabs Titles -->

        <!-- Icon -->
        <h1>SobinPhim.TV</h1>
        <div class="fadeIn first">
            <img src="https://thumbs.dreamstime.com/b/user-icon-trendy-flat-style-isolated-grey-background-user-symbol-user-icon-trendy-flat-style-isolated-grey-background-123663238.jpg" id="icon" alt="User Icon" />
        </div>

        <!-- Login Form -->
        <c:set var="cookie" value="${pageContext.request.cookies}"></c:set>
        <form action="login" method="post">
            <p style="color: red">${message}</p>
            <input type="text" id="login" class="fadeIn second" name="username" placeholder="username" value="${cookie.user.value}">
            <input type="password" id="password" class="fadeIn.third" name="password" placeholder="password" value="${cookie.pass.value}"> <br>
            <input type="checkbox" ${(cookie.rem != null ? 'checked':'')} name="rem" value="ON">  Remember me? <br>
            <input type="submit" class="fadeIn fourth" value="Đăng nhập">
        </form>

        <div class="login-register">
            <a href="register">Đăng ký</a>
        </div>

        <!-- Remind Passowrd -->
        <div id="formFooter">
            <a class="underlineHover" href="forgot">Quên mật khẩu?</a>
        </div>
    </div>
</div>
</body>
</html>