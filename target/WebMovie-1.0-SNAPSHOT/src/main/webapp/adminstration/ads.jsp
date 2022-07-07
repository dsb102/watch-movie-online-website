<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="includes/header.jsp" %>


<div class="content">
    <div class="container-fluid">
        <table class="table table-bordered .table-hover .table-responsive">
            <thead class="thead-dark">
            <tr>
                <th scope="col">ID</th>
                <th scope="col">Tên quảng cáo</th>
                <th scope="col">Link quảng cáo</th>
                <th scope="col">Link thumb</th>
                <th scope="col">Lượt xem</th>
                <th scope="col">Active</th>
            </tr>
            </thead>

            <tbody>
            <c:forEach items="${requestScope.ads}" var="ad">
                <tr>
                    <td scope="row">${ad.id}</td>
                    <td>${ad.name}</td>
                    <td>${ad.link}</td>
                    <td>${ad.img}</td>
                    <td>${ad.view}</td>
                    <c:if test="${ad.active == 1}">
                        <td><a href="#">Active</a></td>
                    </c:if>
                    <c:if test="${ad.active == 0}">
                        <td><a style="color: black" href="ActiveAds?id=${ad.id}">Active</a></td>
                    </c:if>
                </tr>
            </c:forEach>
            <tr>
                <form action="ads" method="post">
                    <td>
                        <label for=>Nhập quảng cáo</label>
<%--                        <input type="text" readonly value="Nhập quảng cáo" class="form-control" placeholder="Nhập quảng cáo" id="exampleFormControlInput1">--%>
                    </td>
                    <td>
<%--                        <label for="exampleFormControlInput2"></label>--%>
                        <input type="text" name="name_ad"  class="form-control" id="exampleFormControlInput2">
                    </td>
                    <td>
<%--                        <label for="exampleFormControlInput3"></label>--%>
                        <input type="text" name="link_ad"  class="form-control" id="exampleFormControlInput3">
<%--                        <input type="text" name="link_ad">--%>
                    </td>
                    <td>
                        <input type="text" name="img"  class="form-control" id="exampleFormControlInput4">
                    </td>
                    <td>
                        <button type="submit" class="btn btn-primary">Nhập</button>
                    </td>
                </form>
            </tr>
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
