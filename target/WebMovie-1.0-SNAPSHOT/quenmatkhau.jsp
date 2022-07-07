<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
  <title>SobinPHIM - Website xem phim trực tuyến miễn phí</title>
  <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
  <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
  <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
  <!------ Include the above in your HEAD tag ---------->

  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
  <style>
    .form-gap {
      padding-top: 70px;
    }
  </style>
</head>
<body>

<div class="form-gap"></div>
<div class="container">
  <div class="row">
    <div class="col-md-4 col-md-offset-4">
      <div class="panel panel-default">
        <div class="panel-body">
          <div class="text-center">
            <h3><i class="fa fa-lock fa-4x"></i></h3>
            <h2 class="text-center">Quên mật khẩu?</h2>
            <p>Nhập địa chỉ email</p>
            <c:if test="${requestScope.message != null}">
              <div style="color: ${((requestScope.message != null && requestScope.message == 'Vui lòng kiểm tra hộp thư để nhận mật khẩu') ? 'green':'red')}">${requestScope.message}</div>
            </c:if>
            <div class="panel-body">

              <form id="register-form" role="form" autocomplete="off" class="form" method="post">

                <div class="form-group">
                  <div class="input-group">
                    <span class="input-group-addon"><i class="glyphicon glyphicon-envelope color-blue"></i></span>
                    <input id="email" name="email" placeholder="email address" class="form-control"  type="email">
                  </div>
                </div>
                <div class="form-group">
                  <input name="recover-submit" class="btn btn-lg btn-primary btn-block" value="Đặt lại mật khẩu" type="submit">
                </div>

                <div class="login-register">
                  <a href="login">Đăng nhập</a>
                </div>

                <input type="hidden" class="hide" name="token" id="token" value="">
              </form>

            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
</body>
</html>