<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@include file="includes/header.jsp" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="assets/CSS/xemphim.css">
    <style>

        .container-tap {
            display: flex;
            justify-content: center;

        }

        .container-tap__so {
            height: 50px;
            margin: 10px 10px

        }

        .container-tap__so a {
            padding: 10px 10px;
            display: block;
            line-height: 30px;
            transition: 0.3s all ease-in-out;
        }

        [id="heart"] {
            position: absolute;
            left: -100vw;
        }

        .container-heart {

        }



        [for="heart"] {
            color: #f6f6f6;
            cursor: pointer;
            font-size: 3em;
            align-self: center;
            transition: color 0.2s ease-in-out;
        }

        [for="heart"]:hover {
            color: #1033e7;
        }

        [for="heart"]::selection {
            color: none;
            background: transparent;
        }

        [for="heart"]::moz-selection {
            color: none;
            background: transparent;
        }

        [id="heart"]:checked + label {
            color: #e2264d;
            will-change: font-size;
            animation: heart 1s cubic-bezier(.17, .89, .32, 1.49);
        }


        @keyframes heart {
            0%, 17.5% {
                font-size: 0;
            }
        }

        a.movie-list-item-title {
            height: 30px;
        }

        @media only screen and (max-width: 1024px) {
            .container-info {
                flex-direction: column;
            }
            .info-content__property {
                width: 68px;
            }
            .content-film {
                max-width: 100%;
            }


        }
    </style>
</head>

<body>
<div class="container">
    <div id="fb-root"></div>
    <script async defer crossorigin="anonymous" src="https://connect.facebook.net/vi_VN/sdk.js#xfbml=1&version=v13.0"
            nonce="4z5zDajS"></script>
    <div class="phim">
        <iframe class="iframe-cls" src="${requestScope.episode.link_embed}" frameborder="0" allowfullscreen></iframe>
    </div>

    <div>
        <h5 style="color: whitesmoke; float: right; margin-right: 50px"><i
                class="fa-solid fa-eye"></i> ${requestScope.episode.view}</h5>
    </div>
    <div>
        <h4 style="color: whitesmoke" class="tap-phim">Tập phim</h4>
        <div class="container-tap">
            <c:forEach items="${requestScope.movie.episodes}" var="episode">
                <div class="container-tap__so">
                    <a href="watch?id=${requestScope.movie.id}&name=${episode.name}">Tập ${episode.name}</a>
                </div>
            </c:forEach>
        </div>
    </div>

    <div class="container-info">
        <c:set var="movie" value="${requestScope.movie}"/>
        <div class="info-img">
            <img
                    src="${movie.thuml_url}"
                    alt="Ảnh phim"

            />

        </div>
        <div class="content-film">
            <h4>${movie.name}</h4>
            <h5>${movie.orinal_name}</h5>
            <div class="container-heart">
                <h6 style="color: white">Thêm vào mục yêu thích</h6>
                <input id="heart"
                       <c:if test="${requestScope.checkFavorite != 0}">checked</c:if>
                       onclick="addFavorite()" name="heart" type="checkbox"/>
                <label for="heart">❤</label>
            </div>

            <h6 style="color: white">Nội dung phim</h6>

            ${movie.content}
        </div>

        <div class="info-content">
            <table class="info-content__table">
                <tr>
                    <td class="info-content__property">Trạng thái</td>
                    <td class="info-content__value">${movie.status}</td>
                </tr>
                <tr>
                    <td class="info-content__property">Số tập</td>
                    <td class="info-content__value">${movie.episode_total}</td>
                </tr>
                <tr>
                    <td class="info-content__property">Thời Lượng</td>
                    <td class="info-content__value">${movie.time}</td>
                </tr>
                <tr>
                    <td class="info-content__property">Năm Phát Hành</td>
                    <td class="info-content__value">${movie.year}</td>
                </tr>
                <tr>
                    <td class="info-content__property">Chất Lượng</td>
                    <td class="info-content__value">${movie.quality}</td>
                </tr>
                <tr>
                    <td class="info-content__property">Ngôn Ngữ</td>
                    <td class="info-content__value">${movie.lang}</td>
                </tr>
                <tr>
                    <td class="info-content__property">Đạo Diễn</td>
                    <td class="info-content__value">${movie.director}</td>
                </tr>
                <tr>
                    <td class="info-content__property">Diễn Viên</td>
                    <td class="info-content__value">
<%--                        ${movie.showNameActors()}--%>
                            <c:forEach items="${movie.actors}" var="actor">
                                <a href="actor?id=${actor.id}">${actor.name}, </a>
                            </c:forEach>
                    </td>
                </tr>
                <tr>
                    <td class="info-content__property">Thể Loại</td>
                    <td class="info-content__value">
<%--                        ${movie.showNameCategorys()}--%>
                        <c:forEach items="${movie.categorys}" var="category">
                            <a href="category?id=${category.id}">${category.name}, </a>
                        </c:forEach>
                    </td>
                </tr>
                <tr>
                    <td class="info-content__property">Quốc Gia</td>
                    <td class="info-content__value">${movie.country}</td>
                </tr>
            </table>
        </div>
    </div>

    <div class="comment-trailer">

        <div class="col-sm-6">
            <div class="comment-facebook">
                <h3 style="color: RGB(234, 143, 28)">Bình luận phim ${movie.name}</h3>
                <div class="fb-comments" data-href="${requestScope.linkComment}" data-width="" data-numposts="5"></div>
            </div>
        </div>

        <div class="show-rating" style="color: white">
            <c:set var="totalVote"
                   value="${requestScope.rate1 + requestScope.rate2 + requestScope.rate3 + requestScope.rate4 + requestScope.rate5}"></c:set>

            <c:set var="percentOne" value="${requestScope.rate1 / totalVote * 100}"></c:set>

            <c:set var="percentTwo" value="${requestScope.rate2 / totalVote * 100}"></c:set>
            <c:set var="percentThree" value="${requestScope.rate3 / totalVote * 100}"></c:set>
            <c:set var="percentFour" value="${requestScope.rate4 / totalVote * 100}"></c:set>
            <c:set var="percentFive" value="${requestScope.rate5 / totalVote * 100}"></c:set>
            <c:if test="${totalVote == 0}">
                <c:set var="percentOne" value="${0}"></c:set>
                <c:set var="percentTwo" value="${0}"></c:set>
                <c:set var="percentThree" value="${0}"></c:set>
                <c:set var="percentFour" value="${0}"></c:set>
                <c:set var="percentFive" value="${0}"></c:set>
            </c:if>
        </div>


        <div class="container-rating">
            <%@include file="voting.jsp" %>
            <form id="form-rating" action="rate" name="form-rating" method="post">
                <div id="rating">
                    <input type="radio" id="star5" name="rating" checked value="5"/>
                    <label class="full" for="star5" title="Awesome - 5 stars"></label>

                    <input type="radio" id="star4" name="rating" value="4"/>
                    <label class="full" for="star4" title="Pretty good - 4 stars"></label>

                    <input type="radio" id="star3" name="rating" value="3"/>
                    <label class="full" for="star3" title="Meh - 3 stars"></label>

                    <input type="radio" id="star2" name="rating" value="2"/>
                    <label class="full" for="star2" title="Kinda bad - 2 stars"></label>

                    <input type="radio" id="star1" name="rating" value="1"/>
                    <label class="full" for="star1" title="Sucks big time - 1 star"></label>

                    <input type="hidden" name="id" , value="${movie.id}">
                </div>
                <input onclick="submitForm()" type="button" style="color: #ea8f1c; cursor: pointer;
                background-color: #362929; border: none; outline: none; padding: 10px 10px;
                 border-radius: 5px; cursor: pointer; margin-left: 10px" value="Gửi đánh giá">

            </form>
        </div>
        <script>

            function submitForm() {
                let star = $('input[name=rating]:checked', '#form-rating').val();
                let id = ${movie.id};
                $.ajax({
                    url: '/WebMovie_war_exploded/rate',
                    type: 'post',
                    data: {
                        rating: star,
                        id: id
                    },
                    success: function (data) {
                        arr = data.toString().split(",");
                        // console.log(arr)
                        let rate1 = Number(arr[0]);
                        let rate2 = Number(arr[1]);
                        let rate3 = Number(arr[2]);
                        let rate4 = Number(arr[3]);
                        let rate5 = Number(arr[4]);
                        let avg = Math.round(Number(arr[5]) * 10) / 10;
                        let totalVote = rate1 + rate2 + rate3 + rate4 + rate5;
                        let percent1 = Math.round(rate1 / totalVote * 100);
                        let percent2 = Math.round(rate2 / totalVote * 100);
                        let percent3 = Math.round(rate3 / totalVote * 100);
                        let percent4 = Math.round(rate4 / totalVote * 100);
                        let percent5 = Math.round(rate5 / totalVote * 100);


                        // console.log(percent1);
                        console.log(percent5);
                        console.log(percent4);
                        console.log(percent3);
                        console.log(percent2);
                        console.log(percent1);

                        document.getElementById("personFive").style.width = percent5 + '%';
                        document.querySelector('#personFive span').innerHTML = percent5 + '%';
                        document.getElementById("personFour").style.width = percent4 + '%';
                        document.querySelector('#personFour span').innerHTML = percent4 + '%';
                        document.getElementById("personThree").style.width = percent3 + '%';
                        document.querySelector('#personThree span').innerHTML = percent3 + '%';
                        document.getElementById("personTwo").style.width = percent2 + '%';
                        document.querySelector('#personTwo span').innerHTML = percent2 + '%';
                        document.getElementById("personOne").style.width = percent1 + '%';
                        document.querySelector('#personOne span').innerHTML = percent1 + '%';
                        document.querySelector('#total').innerHTML = '<span  class="fa fa-user"></span>' + totalVote + ' total votes';
                        document.querySelector('#average').innerHTML = avg;
                        // console.log(document.querySelector('#personFive span'))
                    },
                    error: function (xhr) {
                        //
                    }
                });
            }
        </script>

        <script>
            function addFavorite() {
                var check = document.querySelector('#heart').checked ? 1 : 0;
                var id = ${movie.id}
                    // alert(check)
                    $.ajax({
                        url: '/WebMovie_war_exploded/addFavorite',
                        type: 'post',
                        data: {
                            value: check,
                            id: id
                        },
                        success: function (data) {

                        },
                        error: function (xhr) {
                            //
                        }
                    });
            }

        </script>

        <script>
            function calcRate(r) {
                const f = ~~r,//Tương tự Math.floor(r)
                    id = 'star' + f + (r % f ? 'half' : '')
                id && (document.getElementById(id).checked = !0)
            }
        </script>

        <%--        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"--%>
        <%--                integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"--%>
        <%--                crossorigin="anonymous"></script>--%>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js"
                integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
                crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js"
                integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
                crossorigin="anonymous"></script>
    </div>

    <div class="movie-list-container">
        <h1 class="movie-list-title"><a href="#">Top phim hot liên quan</a></h1>
        <div class="movie-list-wrapper">
            <div class="movie-list">
                <c:forEach items="${requestScope.ralatedMovie}" var="movie">
                    <div class="movie-list-item">
                        <a class="movie-list-item-img" href="watch?id=${movie.id}"
                           style="background-image: url('${movie.thuml_url}')"></a>
                        <a class="movie-list-item-title" href="watch?id=${movie.id}"
                           target="_blank">${movie.name}</a>
                    </div>
                </c:forEach>
                <%--                            <i class="fa-solid fa-chevron-left arrow arrow-left"></i>--%>

            </div>
            <i class="fa-solid fa-chevron-right arrow arrow-right"></i>
        </div>
    </div>

    <script>

        const arrowRightFilms = document.querySelectorAll(".arrow-right");
        // const arrowLeftFilms = document.querySelectorAll(".arrow-left");

        const movieLists = document.querySelectorAll(".movie-list");


        arrowRightFilms.forEach((arrowRight, i) => {

            const itemNumber = movieLists[i].querySelectorAll(".movie-list-item-img").length
            let clickCounter = 0;
            arrowRight.addEventListener("click", () => {
                const numberFilmsOnPage = Math.floor(window.innerWidth / 235);
                clickCounter++;

                if (itemNumber - (5 + clickCounter) + (5 - numberFilmsOnPage) >= 0) {
                    //backtick js
                    movieLists[i].style.transform = `translateX(${movieLists[i].computedStyleMap().get("transform")[0].x.value - 235}px)`;
                } else {
                    movieLists[i].style.transform = "translateX(0)";
                    clickCounter = 0;
                }

            })

            // console.log(movieLists[i].computedStyleMap().get("transform")[0].x.value);
            // console.log(movieLists[i].querySelectorAll(".movie-list-item-img").length);
            // console.log(Math.floor(window.innerWidth/235));
        })


    </script>
</div>

</body>
</html>


<%@include file="includes/footer.jsp" %>