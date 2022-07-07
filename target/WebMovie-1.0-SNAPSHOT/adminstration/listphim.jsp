<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="includes/header.jsp"%>




    <!-- End Navbar -->
    <div class="content">
        <div class="container-fluid">
            <form action="listphim" method="get">
                <input type="text" name="key" class="form-control" id="exxx1" placeholder="Nhập tên phim">
                <button type="submit" class="btn btn-primary">Tìm kiếm</button>
            </form>

            <a href="AddMovie.jsp">Thêm phim</a> <br>
<%--            <a href="upload-all" >Upload toàn bộ web phim</a>--%>
            <form action="upload-page">
                <div class="form-group">
                    <label for="page">Upload từng trang</label>
                    <select name="page" id="page" class="form-select" aria-label="Default select example">
                        <option value="0" selected>Chọn trang</option>
                        <c:forEach begin="1" end="453" step="1" var="i">
                            <option value="${i}">${i}</option>
                        </c:forEach>
                    </select>
                    <button class="btn btn-primary">Cập nhật</button>
                </div>
            </form>

            <table class="table table-bordered" style="border-radius: 5px">
                <thead class="thead-dark">
                <tr>
                    <th scope="col">ID</th>
                    <th scope="col">Name</th>
                    <th scope="col">Origin Name</th>
                    <th scope="col">Quality</th>
                    <th scope="col">Lang</th>
                    <th scope="col">Year</th>
                    <th scope="col">Sửa</th>
                    <th scope="col">Xóa</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${requestScope.movies}" var="movie">
                    <tr>
                        <th scope="row">${movie.id}</th>
                        <td>${movie.name}</td>
                        <td>${movie.orinal_name}</td>
                        <td>${movie.quality}</td>
                        <td>${movie.lang}</td>
                        <td>${movie.year}</td>
                        <td><a href="UpdateMovie?id=${movie.id}">Edit</a></td>
                        <td><a href="RemoveMovie?id=${movie.id}">Xóa</a></td>
                    </tr>
                </c:forEach>
                </tbody>

            </table>
        </div>
    </div>
    <%@include file="includes/footer.jsp"%>
</div>
</div>

</body>
<!--   Core JS Files   -->
<script src="../assets/js/core/jquery.3.2.1.min.js" type="text/javascript"></script>
<script src="../assets/js/core/popper.min.js" type="text/javascript"></script>
<script src="../assets/js/core/bootstrap.min.js" type="text/javascript"></script>
<!--  Plugin for Switches, full documentation here: http://www.jque.re/plugins/version3/bootstrap.switch/ -->
<script src="../assets/js/plugins/bootstrap-switch.js"></script>
<!--  Google Maps Plugin    -->
<script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?key=YOUR_KEY_HERE"></script>
<!--  Chartist Plugin  -->
<script src="../assets/js/plugins/chartist.min.js"></script>
<!--  Notifications Plugin    -->
<script src="../assets/js/plugins/bootstrap-notify.js"></script>
<!-- Control Center for Light Bootstrap Dashboard: scripts for the example pages etc -->
<script src="../assets/js/light-bootstrap-dashboard.js?v=2.0.0 " type="text/javascript"></script>
<!-- Light Bootstrap Dashboard DEMO methods, don't include it in your project! -->
<script src="../assets/js/demo.js"></script>

</html>
