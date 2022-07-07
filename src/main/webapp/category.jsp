<%--
  Created by IntelliJ IDEA.
  User: Dũng Sobin
  Date: 5/6/2022
  Time: 9:45 AM
  To change this template use File | Settings | File Templates.
--%>

<%@include file="includes/header.jsp" %>
<%@page pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <style>
        body {
            color: white;
        }

        .movie-list-item-title {
            text-align: left;
        }
    </style>
    <title>Title</title>
</head>
<body>
<div class="container">
    <c:if test="${requestScope.category != null}">
        <div class="movie-list-container">
            <h1 class="movie-list-title"><a href="category?id=${requestScope.category.id}">${requestScope.category.name}</a></h1>
            <div class="movie-list-wrapper">
                <c:forEach items="${requestScope.movie}" var="mov">
                    <div class="movie-list-item">
                        <a class="movie-list-item-img" href="watch?id=${mov.id}"
                           style="background-image: url('${mov.thuml_url}')"></a>
                        <a class="movie-list-item-title" href="watch?id=${mov.id}"
                           target="_blank">${mov.name}</a>
                    </div>
                </c:forEach>
            </div>
        </div>
    </c:if>


    <c:if test="${requestScope.actor != null}">
        <div class="movie-list-container">
            <h1 class="movie-list-title"><a href="actor?id=${requestScope.actor.id}">Phim ${requestScope.actor.name} đóng</a></h1>
            <div class="movie-list-wrapper">
                <c:forEach items="${requestScope.movie}" var="mov">
                    <div class="movie-list-item">
                        <a class="movie-list-item-img" href="watch?id=${mov.id}"
                           style="background-image: url('${mov.thuml_url}')"></a>
                        <a class="movie-list-item-title" href="watch?id=${mov.id}"
                           target="_blank">${mov.name}</a>
                    </div>
                </c:forEach>
            </div>
        </div>
    </c:if>
</div>

<a href="#top" style="position: fixed; bottom: 50px; right: 20px; height: 60px; width: 60px; background-color: RGB(26, 29, 36); border-radius: 50%; ; line-height: 60px; text-align: center; text-decoration: none"><i id="icon-up" style="font-size: 30px; color: RGB(254, 254, 254)" class="fa-solid fa-angles-up"></i></a>
<script>
    $("a[href='#top']").click(function() {
        $("html, body").animate({ scrollTop: 0 }, "slow");
        return false;
    });
</script>

<script src="scripts/script.js"></script>
</body>
</html>
<%@include file="includes/footer.jsp" %>