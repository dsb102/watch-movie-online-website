<%--
  Created by IntelliJ IDEA.
  User: Dũng Sobin
  Date: 5/6/2022
  Time: 9:45 AM
  To change this template use File | Settings | File Templates.
--%>

<%@include file="includes/header.jsp" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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

        .container-chose ul li a {
            cursor: pointer;
        }
    </style>
    <link rel="stylesheet" href="assets/CSS/danhsach.css">
</head>
<body>
<div class="container">
    <c:if test="${requestScope.context.contains('serie')}">
    <div class="slide-container">
        <div class="slide-item slider-1"
             style="background-image: url('https://static.fptplay.net/static/img/share/video/03_01_2022/co-tay-ao-mau-do-fpt-play-1080-203-01-2022_14g42-35.jpg?w=1138&mode=scale&fmt=webp')">
            <div class="slide-item-content">
                <div class="slide-item-title">Cổ tay áo màu đỏ</div>
                <div class="slide-item-desc">
                    Lee Junho đoạt giải Nam diễn viên chính xuất sắc nhất trong Baeksang Awards 2022.
                </div>
            </div>
            <a href="watch?id=12" class="slide-item-btn"><span>Xem ngay</span><i
                    class="fa-solid fa-chevron-right menu-icon"></i></a>
        </div>
        <div class="slide-item slider-2"
             style="background-image: url('https://static.fptplay.net/static/img/share/video/21_03_2022/1080-1-dq21-03-2022_09g47-12.jpg?w=1138&mode=scale&fmt=webp')">
            <div class="slide-item-content">
                <div class="slide-item-title"> Lời Nguyền Ma Lai</div>
                <div class="slide-item-desc"></div>
            </div>
            <a href="watch?id=12" class="slide-item-btn"><span>Xem ngay</span><i
                    class="fa-solid fa-chevron-right menu-icon"></i></a>
        </div>
        <div class="slide-item slider-3"
             style="background-image: url('https://static.fptplay.net/static/img/share/video/OTT/VOD/2022/04/29/masterwaitamoment_2021_cn_b_26t_bghd29-04-2022_09g16-38.jpg?w=1138&mode=scale&fmt=webp')">
            <div class="slide-item-content">
                <div class="slide-item-title">Bắt ma phá án</div>
                <div class="slide-item-desc"></div>
            </div>
            <a href="watch?id=12" class="slide-item-btn"><span>Xem ngay</span><i
                    class="fa-solid fa-chevron-right menu-icon"></i></a>
        </div>
        <i class="fa-solid fa-chevron-right slide-item-btn-right"></i>
        <i class="fa-solid fa-chevron-left slide-item-btn-left"></i>
    </div>
    <div class="movie-list-container">
        <h1 class="movie-list-title"><a href="serie">Phim bộ</a></h1>
        <div class="container-chose">
            <ul>
                <li><a onclick="show('2022')">Năm 2022</a></li>
                <li><a onclick="show('tinhcam')">Tình cảm</a></li>
                <li><a onclick="show('hanhdong')">Hành động</a></li>
                <li><a onclick="show('view')">Lượt xem nhiều</a></li>
            </ul>
        </div>
        <div id="content" class="movie-list-wrapper">
            <c:forEach items="${requestScope.series}" var="serie">
                <div class="movie-list-item movie-list-quantity">
                    <a class="movie-list-item-img" href="watch?id=${serie.id}"
                       style="background-image: url('${serie.thuml_url}')"></a>
                    <a class="movie-list-item-title" href="watch?id=${serie.id}"
                       target="_blank">${serie.name}</a>
                </div>
            </c:forEach>
        </div>
        <button class="btn" id="btn-load" style="background-color: RGB(254, 153, 0)" onclick="loadMore()">Tải thêm
        </button>
    </div>


</div>

<script type="text/javascript" charset="UTF-8">
    // function yHandler() {
    //     var wrap = document.getElementById('content');
    //     var contentHeight = wrap.offsetHeight; // chiều cao page
    //     var yOffset = window.pageYOffset; // vị trí chiều dọc scroll
    //     var y = yOffset + window.innerHeight;
    //     if (y >= contentHeight) {
    //         loadMore();
    //     }
    //     console.log(y + ' | ' + contentHeight);
    // }
    // window.onscroll = yHandler;

    function loadMore() {
        let start = document.getElementsByClassName("movie-list-quantity").length;
        $.ajax({
            url: '/WebMovie_war_exploded/load',
            type: 'get',
            data: {
                start: start
            },
            success: function (data) {
                var row = document.getElementById("content");
                row.innerHTML += data;
                if (data == '')
                    document.getElementById("btn-load").style.display = 'none';
            },
            error: function (xhr) {
                //
            }
        });
    }

    function show(param) {
        document.getElementById("btn-load").style.display = 'none';
        $.ajax({
            url: '/WebMovie_war_exploded/load',
            type: 'get',
            data: {
                para: param
            },
            success: function (data) {
                var row = document.getElementById("content");
                row.innerHTML = data;
            },
            error: function (xhr) {
                //
            }
        });
    }


</script>


</c:if>
<c:if test="${requestScope.context.contains('single')}">
    <div class="slide-container">
        <div class="slide-item slider-1"
             style="background-image: url('https://static.fptplay.net/static/img/share/video/03_01_2022/co-tay-ao-mau-do-fpt-play-1080-203-01-2022_14g42-35.jpg?w=1138&mode=scale&fmt=webp')">
            <div class="slide-item-content">
                <div class="slide-item-title">Cổ tay áo màu đỏ</div>
                <div class="slide-item-desc">
                    Lee Junho đoạt giải Nam diễn viên chính xuất sắc nhất trong Baeksang Awards 2022.
                </div>
            </div>
            <a href="#" class="slide-item-btn"><span>Xem ngay</span><i class="fa-solid fa-chevron-right menu-icon"></i></a>
        </div>
        <div class="slide-item slider-2"
             style="background-image: url('https://static.fptplay.net/static/img/share/video/21_03_2022/1080-1-dq21-03-2022_09g47-12.jpg?w=1138&mode=scale&fmt=webp')">
            <div class="slide-item-content">
                <div class="slide-item-title"> Lời Nguyền Ma Lai</div>
                <div class="slide-item-desc"></div>
            </div>
            <a href="#" class="slide-item-btn"><span>Xem ngay</span><i class="fa-solid fa-chevron-right menu-icon"></i></a>
        </div>
        <div class="slide-item slider-3"
             style="background-image: url('https://static.fptplay.net/static/img/share/video/OTT/VOD/2022/04/29/masterwaitamoment_2021_cn_b_26t_bghd29-04-2022_09g16-38.jpg?w=1138&mode=scale&fmt=webp')">
            <div class="slide-item-content">
                <div class="slide-item-title">Bắt ma phá án</div>
                <div class="slide-item-desc"></div>
            </div>
            <a href="" class="slide-item-btn"><span>Xem ngay</span><i
                    class="fa-solid fa-chevron-right menu-icon"></i></a>
        </div>
        <i class="fa-solid fa-chevron-right slide-item-btn-right"></i>
        <i class="fa-solid fa-chevron-left slide-item-btn-left"></i>
    </div>
    <div class="movie-list-container">
        <h1 class="movie-list-title"><a href="single">Phim lẻ</a></h1>
        <div class="container-chose">
            <ul>
                <li><a onclick="show1('2022')">Năm 2022</a></li>
                <li><a onclick="show1('tinhcam')">Tình cảm</a></li>
                <li><a onclick="show1('hanhdong')">Hành động</a></li>
                <li><a onclick="show1('view')">Lượt xem nhiều</a></li>
            </ul>
        </div>
        <div id="content1" class="movie-list-wrapper">
            <c:forEach items="${requestScope.single}" var="sin">
                <div class="movie-list-item movie-list-quantity1">
                    <a class="movie-list-item-img" href="watch?id=${sin.id}"
                       style="background-image: url('${sin.thuml_url}')"></a>
                    <a class="movie-list-item-title" href="watch?id=${sin.id}"
                       target="_blank">${sin.name}</a>
                </div>
            </c:forEach>
        </div>
        <button class="btn" id="btn-load1" style="background-color: RGB(254, 153, 0)" onclick="loadMore1()">Tải thêm
        </button>
    </div>
    </div>
</c:if>

<script type="text/javascript" charset="UTF-8">
    // function yHandler() {
    //     var wrap = document.getElementById('content');
    //     var contentHeight = wrap.offsetHeight; // chiều cao page
    //     var yOffset = window.pageYOffset; // vị trí chiều dọc scroll
    //     var y = yOffset + window.innerHeight;
    //     if (y >= contentHeight) {
    //         loadMore();
    //     }
    //     console.log(y + ' | ' + contentHeight);
    // }
    // window.onscroll = yHandler;

    function loadMore1() {
        let start1 = document.getElementsByClassName("movie-list-quantity1").length;
        console.log(start1);
        $.ajax({
            url: '/WebMovie_war_exploded/load',
            type: 'get',
            data: {
                start: start1
            },
            success: function (data) {
                var row11 = document.getElementById("content1");
                row11.innerHTML += data;
                if (data == '')
                    document.getElementById("btn-load1").style.display = 'none';
            },
            error: function (xhr) {
                //
            }
        });
    }

    function show1(param) {
        document.getElementById("btn-load1").style.display = 'none';
        $.ajax({
            url: '/WebMovie_war_exploded/load',
            type: 'get',
            data: {
                para: param
            },
            success: function (data) {
                var row1 = document.getElementById("content1");
                row1.innerHTML = data;
            },
            error: function (xhr) {
                //
            }
        });
    }


</script>

<c:if test="${requestScope.context.contains('shows')}">
    <div class="slide-container">
        <div class="slide-item slider-1"
             style="background-image: url('https://static.fptplay.net/static/img/share/video/03_01_2022/co-tay-ao-mau-do-fpt-play-1080-203-01-2022_14g42-35.jpg?w=1138&mode=scale&fmt=webp')">
            <div class="slide-item-content">
                <div class="slide-item-title">Cổ tay áo màu đỏ</div>
                <div class="slide-item-desc">
                    Lee Junho đoạt giải Nam diễn viên chính xuất sắc nhất trong Baeksang Awards 2022.
                </div>
            </div>
            <a href="#" class="slide-item-btn"><span>Xem ngay</span><i class="fa-solid fa-chevron-right menu-icon"></i></a>
        </div>
        <div class="slide-item slider-2"
             style="background-image: url('https://static.fptplay.net/static/img/share/video/21_03_2022/1080-1-dq21-03-2022_09g47-12.jpg?w=1138&mode=scale&fmt=webp')">
            <div class="slide-item-content">
                <div class="slide-item-title"> Lời Nguyền Ma Lai</div>
                <div class="slide-item-desc"></div>
            </div>
            <a href="#" class="slide-item-btn"><span>Xem ngay</span><i class="fa-solid fa-chevron-right menu-icon"></i></a>
        </div>
        <div class="slide-item slider-3"
             style="background-image: url('https://static.fptplay.net/static/img/share/video/OTT/VOD/2022/04/29/masterwaitamoment_2021_cn_b_26t_bghd29-04-2022_09g16-38.jpg?w=1138&mode=scale&fmt=webp')">
            <div class="slide-item-content">
                <div class="slide-item-title">Bắt ma phá án</div>
                <div class="slide-item-desc"></div>
            </div>
            <a href="" class="slide-item-btn"><span>Xem ngay</span><i
                    class="fa-solid fa-chevron-right menu-icon"></i></a>
        </div>
        <i class="fa-solid fa-chevron-right slide-item-btn-right"></i>
        <i class="fa-solid fa-chevron-left slide-item-btn-left"></i>
    </div>
    <div class="movie-list-container">
        <h1 class="movie-list-title"><a href="shows">TV Show</a></h1>
        <div class="container-chose">
            <ul>
                <li><a onclick="show2('2022')">Năm 2022</a></li>
                <li><a onclick="show2('tinhcam')">Tình cảm</a></li>
                <li><a onclick="show2('hanhdong')">Hành động</a></li>
                <li><a onclick="show2('view')">Lượt xem nhiều</a></li>
            </ul>
        </div>
        <div id="content2" class="movie-list-wrapper">
            <c:forEach items="${requestScope.shows}" var="show">
                <div class="movie-list-item movie-list-quantity2">
                    <a class="movie-list-item-img" href="watch?id=${show.id}"
                       style="background-image: url('${show.thuml_url}')"></a>
                    <a class="movie-list-item-title" href="watch?id=${show.id}"
                       target="_blank">${show.name}</a>
                </div>
            </c:forEach>
        </div>
        <button class="btn" id="btn-load2" style="background-color: RGB(254, 153, 0)" onclick="loadMore2()">Tải thêm
        </button>
    </div>
    </div>
</c:if>

<script type="text/javascript" charset="UTF-8">
    // function yHandler() {
    //     var wrap = document.getElementById('content');
    //     var contentHeight = wrap.offsetHeight; // chiều cao page
    //     var yOffset = window.pageYOffset; // vị trí chiều dọc scroll
    //     var y = yOffset + window.innerHeight;
    //     if (y >= contentHeight) {
    //         loadMore();
    //     }
    //     console.log(y + ' | ' + contentHeight);
    // }
    // window.onscroll = yHandler;

    function loadMore2() {
        var start2 = document.getElementsByClassName("movie-list-quantity2").length;
        $.ajax({
            url: '/WebMovie_war_exploded/load',
            type: 'get',
            data: {
                start: start2
            },
            success: function (data) {
                var row22 = document.getElementById("content2");
                row22.innerHTML += data;
                if (data == '')
                    document.getElementById("btn-load2").style.display = 'none';
            },
            error: function (xhr) {
                //
            }
        });
    }

    function show2(param) {
        document.getElementById("btn-load2").style.display = 'none';
        $.ajax({
            url: '/WebMovie_war_exploded/load',
            type: 'get',
            data: {
                para: param
            },
            success: function (data) {
                var row2 = document.getElementById("content2");
                row2.innerHTML = data;
            },
            error: function (xhr) {
                //
            }
        });
    }


</script>
<c:if test="${requestScope.context.contains('cartoon')}">
    <div class="slide-container">
        <div class="slide-item slider-1"
             style="background-image: url('https://static.fptplay.net/static/img/share/video/06_04_2022/therisingoftheshieldheroseason2_2022_jp_b_13t_bghd06-04-2022_21g04-25.jpg?w=1138&mode=scale&fmt=webp')">
            <div class="slide-item-content">
                <div class="slide-item-title">Sợ trỗi dậy của khiên hiệp sĩ phần 2</div>
                <div class="slide-item-desc">
                    Phần 2
                </div>
            </div>
            <a href="watch?id=13" class="slide-item-btn"><span>Xem ngay</span><i
                    class="fa-solid fa-chevron-right menu-icon"></i></a>
        </div>
        <div class="slide-item slider-2"
             style="background-image: url('https://static.fptplay.net/static/img/share/video/14_01_2022/the-case-study-of-vanitas-season-2-fpt-play14-01-2022_22g55-36.jpg?w=1138&mode=scale&fmt=webp')">
            <div class="slide-item-content">
                <div class="slide-item-title">Hồi kí Vanitas</div>
                <div class="slide-item-desc"></div>
            </div>
            <a href="watch?id=13" class="slide-item-btn"><span>Xem ngay</span><i
                    class="fa-solid fa-chevron-right menu-icon"></i></a>
        </div>
        <div class="slide-item slider-3"
             style="background-image: url('https://static.fptplay.net/static/img/share/video/10_01_2022/dai-chien-nguoi-khong-lo-phan-cuoi-fpt-play-attack-on-titan-final-seasonfpt-play10-01-2022_17g09-16.jpg?w=1138&mode=scale&fmt=webp')">
            <div class="slide-item-content">
                <div class="slide-item-title">Đại chiến người khổng lồ</div>
                <div class="slide-item-desc">Phần cuối</div>
            </div>
            <a href="watch?id=13" class="slide-item-btn"><span>Xem ngay</span><i
                    class="fa-solid fa-chevron-right menu-icon"></i></a>
        </div>
        <i class="fa-solid fa-chevron-right slide-item-btn-right"></i>
        <i class="fa-solid fa-chevron-left slide-item-btn-left"></i>
    </div>
    <div class="movie-list-container">
        <h1 class="movie-list-title"><a href="cartoon">Hoạt hình</a></h1>
        <div class="container-chose">
            <ul>
                <li><a onclick="show3('2022')">Năm 2022</a></li>
                <li><a onclick="show3('tinhcam')">Tình cảm</a></li>
                <li><a onclick="show3('hanhdong')">Hành động</a></li>
                <li><a onclick="show3('view')">Lượt xem nhiều</a></li>
            </ul>
        </div>
        <div id="content3" class="movie-list-wrapper">
            <c:forEach items="${requestScope.cartoon}" var="cart">
                <div class="movie-list-item movie-list-quantity3">
                    <a class="movie-list-item-img" href="watch?id=${cart.id}"
                       style="background-image: url('${cart.thuml_url}')"></a>
                    <a class="movie-list-item-title" href="watch?id=${cart.id}"
                       target="_blank">${cart.name}</a>
                </div>
            </c:forEach>
        </div>
        <button class="btn" id="btn-load3" style="background-color: RGB(254, 153, 0)" onclick="loadMore3()">Tải thêm
        </button>
    </div>
    </div>

</c:if>

<a href="#top" style="position: fixed; bottom: 50px; right: 20px; height: 60px; width: 60px; background-color: RGB(26, 29, 36); border-radius: 50%; ; line-height: 60px; text-align: center; text-decoration: none"><i id="icon-up" style="font-size: 30px; color: RGB(254, 254, 254)" class="fa-solid fa-angles-up"></i></a>
<script>
    $("a[href='#top']").click(function() {
        $("html, body").animate({ scrollTop: 0 }, "slow");
        return false;
    });
</script>
<script type="text/javascript" charset="UTF-8">
    // function yHandler() {
    //     var wrap = document.getElementById('content');
    //     var contentHeight = wrap.offsetHeight; // chiều cao page
    //     var yOffset = window.pageYOffset; // vị trí chiều dọc scroll
    //     var y = yOffset + window.innerHeight;
    //     if (y >= contentHeight) {
    //         loadMore();
    //     }
    //     console.log(y + ' | ' + contentHeight);
    // }
    // window.onscroll = yHandler;

    function loadMore3() {
        var start3 = document.getElementsByClassName("movie-list-quantity3").length;
        $.ajax({
            url: '/WebMovie_war_exploded/load',
            type: 'get',
            data: {
                start: start3
            },
            success: function (data) {
                var row33 = document.getElementById("content3");
                row33.innerHTML += data;
                if (data == '')
                    document.getElementById("btn-load3").style.display = 'none';
            },
            error: function (xhr) {
                //
            }
        });
    }

    function show3(param) {
        document.getElementById("btn-load3").style.display = 'none';
        $.ajax({
            url: '/WebMovie_war_exploded/load',
            type: 'get',
            data: {
                para: param
            },
            success: function (data) {
                var row3 = document.getElementById("content3");
                row3.innerHTML = data;
            },
            error: function (xhr) {
                //
            }
        });
    }



</script>
<c:if test="${requestScope.context.contains('favorite')}">
    <div class="movie-list-container">
        <h1 class="movie-list-title"><a href="favorite">Phim yêu thích của bạn</a></h1>
        <div  class="movie-list-wrapper">
            <c:forEach items="${requestScope.favorite}" var="cart">
                <div class="movie-list-item">
                    <a class="movie-list-item-img" href="watch?id=${cart.id}"
                       style="background-image: url('${cart.thuml_url}')"></a>
                    <a class="movie-list-item-title" href="watch?id=${cart.id}"
                       target="_blank">${cart.name}</a>
                </div>
            </c:forEach>
        </div>
    </div>
    </div>

</c:if>
<script src="scripts/script.js"></script>
</body>
</html>
<%@include file="includes/footer.jsp" %>