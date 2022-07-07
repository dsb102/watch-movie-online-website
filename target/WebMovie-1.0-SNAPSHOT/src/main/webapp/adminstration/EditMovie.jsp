<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="includes/header.jsp" %>


<!-- End Navbar -->
<div class="content">
    <div class="container-fluid">
        <h2>Thông tin</h2>
        <form action="UpdateMovie" , method="post">
            <c:set var="movie" value="${requestScope.movie}"></c:set>
            <label for="movie1">ID</label>
            <input type="text" value="${movie.id}" class="form-control" id="movie1" name="id" readonly content="">
            <label for="movie2">Name</label>
            <input type="text" name="name" class="form-control" id="movie2" value="${movie.name}">
            <label for="movie3">Origin name</label>
            <input type="text" id="movie3" class="form-control" name="orinal_name" value="${movie.orinal_name}">
            <label for="movie4">Thumb Url</label>
            <input type="text" id="movie4" class="form-control" name="thumb_url" value="${movie.thuml_url}">
            <label for="movie5">Trailer url</label>
            <input type="text" class="form-control" id="movie5" name="trailer_url" value="${movie.trailer_url}">
            <label for="movie6">Content</label>
            <textarea name="content" id="movie6" cols="30" class="form-control" value="${movie.content}" rows="10"></textarea>
            <label for="movie7">Số tập</label>
            <input type="text" id="movie7" class="form-control" name="episode_total" value="${movie.episode_total}">
            <label for="movie8">Chất lượng</label>
            <input type="text" name="quality" id="movie8" class="form-control" value="${movie.quality}">
            <label for="movie9">Year</label>
            <input type="text" id="movie9" class="form-control" name="year" value="${movie.year}">
            <label for="movie10">Đạo diễn</label>
            <input id="movie10" type="text" class="form-control" name="director" value="${movie.director}"> <br>
            <button type="submit" class="btn btn-primary">Cập nhật</button>
        </form>

        <h2>Diễn viên</h2>
        <form action="AddActor" method="post">
            <input type="hidden" name="id_movie-actor" value="${requestScope.movie.id}">
            <label for="exactor1">Name</label>
            <input type="text" name="name-actor" id="exactor1" placeholder="Tên diễn viên"> <br>
            <button type="submit" class="btn btn-primary">Thêm</button>
        </form>
        <table border="1px" class="table">
            <thead class="thead-dark">
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Sửa</th>
                <th>Xóa</th>
            </tr>
            </thead>

            <tbody>
            <c:forEach items="${requestScope.actors}" var="actor">
                <tr>
                    <td>${actor.id}</td>
                    <td>${actor.name}</td>
                    <td><a href="EditActor?id_actor=${actor.id}&id_movie=${movie.id}">Sửa</a></td>
                    <td><a href="UpdateActor?id_actor=${actor.id}&id_movie=${movie.id}">Xóa</a></td>
                </tr>
            </c:forEach>
            </tbody>


        </table>

        <h2>Thể loại</h2>
        <form action="">
            <label for="exampleInput1">Name</label>
            <input type="text" id="exampleInput1" class="form-control" placeholder="Thể loại"> <br>
            <button type="submit" class="btn btn-primary">Thêm</button>
        </form>
        <table class="table table-bordered">
            <thead class="thead-light">
            <tr>
                <th scope="col">ID</th>
                <th scope="col">Name</th>
                <th scope="col">Sửa</th>
                <th scope="col">Xóa</th>
            </tr>
            </thead>

            <tbody>
            <c:forEach items="${requestScope.categories}" var="category">
                <tr>
                    <th scope="row">${category.id}</th>
                    <td>${category.name}</td>
                    <td><a href="">Sửa</a></td>
                    <td><a href="">Xóa</a></td>
                </tr>
            </c:forEach>
            </tbody>

        </table>

        <h2>Tập phim</h2>
        <form action="">
            <label for="exx1">Name</label>
            <input type="text" id="exx1" class="form-control" placeholder="Tập phim">
            <label for="exx2">Link embed</label>
            <input type="text" id="exx2" class="form-control" placeholder="Link embed"> <br>
            <button type="submit" class="btn btn-primary">Thêm</button>
        </form>
        <table border="1px" class="table table-bordered">
            <thead class="thead-light">
            <tr>
                <th scope="col">ID</th>
                <th scope="col">Name</th>
                <th scope="col">Link embed</th>
                <th scope="col">Sửa</th>
                <th scope="col">Xóa</th>
            </tr>
            </thead>

            <tbody>
            <c:forEach items="${requestScope.episodes}" var="episode">
                <tr>
                    <th scope="row">${episode.id}</th>
                    <td>${episode.name}</td>
                    <td>${episode.link_embed}</td>
                    <td><a href="">Sửa</a></td>
                    <td><a href="">Xóa</a></td>
                </tr>
            </c:forEach>
            </tbody>

        </table>
    </div>
</div>
<%@include file="includes/footer.jsp" %>
</div>
</div>

</body>
<!-- Core JS Files -->
<script src="../assets/js/core/jquery.3.2.1.min.js" type="text/javascript"></script>
<script src="../assets/js/core/popper.min.js" type="text/javascript"></script>
<script src="../assets/js/core/bootstrap.min.js" type="text/javascript"></script>
<!-- Plugin for Switches, full documentation here: http://www.jque.re/plugins/version3/bootstrap.switch/ -->
<script src="../assets/js/plugins/bootstrap-switch.js"></script>
<!-- Google Maps Plugin -->
<script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?key=YOUR_KEY_HERE"></script>
<!-- Chartist Plugin -->
<script src="../assets/js/plugins/chartist.min.js"></script>
<!-- Notifications Plugin -->
<script src="../assets/js/plugins/bootstrap-notify.js"></script>
<!-- Control Center for Light Bootstrap Dashboard: scripts for the example pages etc -->
<script src="../assets/js/light-bootstrap-dashboard.js?v=2.0.0 " type="text/javascript"></script>
<!-- Light Bootstrap Dashboard DEMO methods, don't include it in your project! -->
<script src="../assets/js/demo.js"></script>

</html>
