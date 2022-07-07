<%--
  Created by IntelliJ IDEA.
  User: Dũng Sobin
  Date: 5/6/2022
  Time: 2:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@include file="includes/header.jsp" %>
<%@page pageEncoding="UTF-8" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="assets/CSS/search.css">
</head>
<body>
<div class="container">

    <h1 class="key-searching">Keyword đang tìm: ${requestScope.key}</h1>

    <div class="show-movie">
        <div class="movie-list-wrapper" id="content5">

            <c:forEach items="${requestScope.movies}" var="movie">
                <div class="movie-list-item movie-list-quantity3">
                    <a class="movie-list-item-img" href="watch?id=${movie.id}"
                       style="background-image: url('${movie.thuml_url}')">

                    </a>
                    <a class="movie-list-item-title" href="watch?id=${movie.id}" target="_blank">${movie.name}</a>
                </div>
            </c:forEach>


        </div>
    </div>
    <button class="btn" id="btn-load3" style="background-color: RGB(254, 153, 0)" onclick="loadMore3()">Tải thêm
    </button>
</div>

<script>
    function loadMore3() {
        let start3 = document.getElementsByClassName("movie-list-quantity3").length;
        $.ajax({
            url: '/WebMovie_war_exploded/searchAjax',
            type: 'post',
            data: {
                keySearch: key,
                start: start3
            },
            success: function (data) {
                var row33 = document.getElementById("content5");
                row33.innerHTML += data;
                // console.log(data)
                if (data == '')
                    document.getElementById("btn-load3").style.display = 'none';

            },
            error: function (xhr) {
                //
            }
        });
    }
</script>

<script>
    var key;
    function searchByName(param) {


        key = param.value;
        $.ajax({
            url: '/WebMovie_war_exploded/searchAjax',
            type: 'get',
            data: {
                searchKey: key
            },
            success: function (data) {
                var row = document.getElementById("content5");
                row.innerHTML = data;
                // console.log(data);
            },
            error: function (xhr) {
                //
            }
        });
    }
</script>

</body>
</html>
<%@include file="includes/footer.jsp" %>
