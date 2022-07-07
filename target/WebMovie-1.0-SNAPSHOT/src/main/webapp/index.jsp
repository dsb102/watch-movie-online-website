<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="includes/header.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
    a.movie-list-item-title {
        height: 30px;
    }


</style>

<div class="container">
    <div class="slide-container">
        <div class="slide-item slider-1"
             style="background-image: url('https://cdn.tgdd.vn//GameApp/1340319//thumb-800x450.jpg')">
            <div class="slide-item-content">
                <div class="slide-item-title">Siêu trộm</div>
                <div class="slide-item-desc"></div>
            </div>
            <a href="watch?id=254" class="slide-item-btn"><span>Xem ngay</span><i
                    class="fa-solid fa-chevron-right menu-icon"></i></a>
        </div>
        <div class="slide-item slider-2" style="background-image: url('https://i.imgur.com/9lHOkP0.jpeg')">
            <div class="slide-item-content">
                <div class="slide-item-title">Biệt Đội Titans (Phần 3)</div>
                <div class="slide-item-desc"></div>
            </div>
            <a href="watch?id=255" class="slide-item-btn"><span>Xem ngay</span><i
                    class="fa-solid fa-chevron-right menu-icon"></i></a>
        </div>
        <div class="slide-item slider-3"
             style="background-image: url('https://e.khoahoc.tv/photos/image/2015/05/04/lau_dai_4.jpg')">
            <div class="slide-item-content">
                <div class="slide-item-title">Lâu đài bất tử</div>
                <div class="slide-item-desc">The Haunted Manision</div>
            </div>
            <a href="watch?id=256" class="slide-item-btn"><span>Xem ngay</span><i
                    class="fa-solid fa-chevron-right menu-icon"></i></a>
        </div>
        <i class="fa-solid fa-chevron-right slide-item-btn-right"></i>
        <i class="fa-solid fa-chevron-left slide-item-btn-left"></i>
    </div>

    <div class="ads-container"
         style="position: fixed; z-index: 100; top: 50%; left: 50%; transform: translate(-50%, -50%)"

    >
        <a href="${sessionScope.ads.link}">
            <img style="border-radius: 5px" src="${sessionScope.ads.img}" alt="Quảng cáo">
        </a>
        <button id="xoa-quangcao">Xóa</button>
    </div>

    <div class="movie-list-container">
        <h1 class="movie-list-title"><a href="serie">Phim mới cập nhật</a></h1>
        <div class="movie-list-wrapper">
            <div class="movie-list">
                <c:forEach items="${requestScope.news}" var="mov_new">
                    <div class="movie-list-item">
                        <a class="movie-list-item-img" href="watch?id=${mov_new.id}"
                           style="background-image: url('${mov_new.thuml_url}')">

                        </a>
                        <a class="movie-list-item-title" href="watch?id=${mov_new.id}"
                           target="_blank">${mov_new.name}</a>
                    </div>
                </c:forEach>
                <%--                <i class="fa-solid fa-chevron-left arrow arrow-left"></i>--%>
            </div>
            <i class="fa-solid fa-chevron-right arrow arrow-right"></i>
        </div>

        <h1 class="movie-list-title"><a href="serie">Phim bộ</a></h1>
        <div class="movie-list-wrapper">
            <div class="movie-list">
                <c:forEach items="${requestScope.series}" var="serie">
                    <div class="movie-list-item">
                        <a class="movie-list-item-img" href="watch?id=${serie.id}"
                           style="background-image: url('${serie.thuml_url}')">

                        </a>
                        <a class="movie-list-item-title" href="watch?id=${serie.id}" target="_blank">${serie.name}</a>
                    </div>
                </c:forEach>
                <%--                <i class="fa-solid fa-chevron-left arrow arrow-left"></i>--%>


            </div>
            <i class="fa-solid fa-chevron-right arrow arrow-right"></i>
        </div>

        <div class="movie-list-container">
            <h1 class="movie-list-title"><a href="single">Phim lẻ</a></h1>
            <div class="movie-list-wrapper">
                <div class="movie-list">
                    <c:forEach items="${requestScope.phimles}" var="phimle">
                        <div class="movie-list-item">
                            <a class="movie-list-item-img" href="watch?id=${phimle.id}"
                               style="background-image: url('${phimle.thuml_url}')"></a>
                            <a class="movie-list-item-title" href="watch?id=${phimle.id}"
                               target="_blank">${phimle.name}</a>
                        </div>
                    </c:forEach>
                    <%--                    <i class="fa-solid fa-chevron-left arrow arrow-left"></i>--%>

                </div>
                <i class="fa-solid fa-chevron-right arrow arrow-right"></i>
            </div>

            <div class="movie-list-container">
                <h1 class="movie-list-title"><a href="shows">TVShow</a></h1>
                <div class="movie-list-wrapper">
                    <div class="movie-list">
                        <c:forEach items="${requestScope.shows}" var="show">
                            <div class="movie-list-item">
                                <a class="movie-list-item-img" href="watch?id=${show.id}"
                                   style="background-image: url('${show.thuml_url}')"></a>
                                <a class="movie-list-item-title" href="watch?id=${show.id}"
                                   target="_blank">${show.name}</a>
                            </div>
                        </c:forEach>
                        <%--                        <i class="fa-solid fa-chevron-left arrow arrow-left"></i>--%>

                    </div>
                    <i class="fa-solid fa-chevron-right arrow arrow-right"></i>
                </div>
            </div>

            <div class="movie-list-container">
                <h1 class="movie-list-title"><a href="cartoon">Hoạt hình</a></h1>
                <div class="movie-list-wrapper">
                    <div class="movie-list">
                        <c:forEach items="${requestScope.hoathinhs}" var="hoathinh">
                            <div class="movie-list-item">
                                <a class="movie-list-item-img" href="watch?id=${hoathinh.id}"
                                   style="background-image: url('${hoathinh.thuml_url}')"></a>
                                <a class="movie-list-item-title" href="watch?id=${hoathinh.id}"
                                   target="_blank">${hoathinh.name}</a>
                            </div>
                        </c:forEach>
                        <%--                        <i class="fa-solid fa-chevron-left arrow arrow-left"></i>--%>

                    </div>
                    <i class="fa-solid fa-chevron-right arrow arrow-right"></i>
                </div>
            </div>

            <c:forEach items="${requestScope.categories}" var="category">
                <div class="movie-list-container">
                    <h1 class="movie-list-title"><a href="category?id=${category.id}">${category.name}</a></h1>
                    <div class="movie-list-wrapper">
                        <div class="movie-list">
                            <c:forEach items="${requestScope.md.getMovieByIDCategory(category.id)}" var="movieCat">
                                <div class="movie-list-item">
                                    <a class="movie-list-item-img" href="watch?id=${movieCat.id}"
                                       style="background-image: url('${movieCat.thuml_url}')"></a>
                                    <a class="movie-list-item-title" href="watch?id=${movieCat.id}"
                                       target="_blank">${movieCat.name}</a>
                                </div>
                            </c:forEach>
                                <%--                            <i class="fa-solid fa-chevron-left arrow arrow-left"></i>--%>

                        </div>
                        <i class="fa-solid fa-chevron-right arrow arrow-right"></i>
                    </div>
                </div>
            </c:forEach>

            <a href="#top"
               style="position: fixed; bottom: 50px; right: 20px; height: 60px; width: 60px; background-color: RGB(26, 29, 36); border-radius: 50%; ; line-height: 60px; text-align: center; text-decoration: none"><i
                    id="icon-up" style="font-size: 30px; color: RGB(254, 254, 254)"
                    class="fa-solid fa-angles-up"></i></a>
            <script>
                $("a[href='#top']").click(function () {
                    $("html, body").animate({scrollTop: 0}, "slow");
                    return false;
                });
            </script>


        </div>
    </div>
</div>
        <%@include file="includes/footer.jsp" %>


        <script>
            var remove = document.getElementById("xoa-quangcao");
            var ads = document.querySelector(".ads-container")
            remove.addEventListener("click", () => {
                ads.style.display = 'none';
            })
        </script>

        <script src="scripts/script.js"></script>

