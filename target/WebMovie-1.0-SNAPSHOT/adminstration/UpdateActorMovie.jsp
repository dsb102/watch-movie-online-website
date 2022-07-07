<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="includes/header.jsp" %>


<!-- End Navbar -->
<div class="content">
    <div class="container-fluid">
        <form action="EditActor" method="post">
            <c:set var="actor" value="${requestScope.actor}"/>
            <label for="ex1">ID</label>
            <input type="text" name="id_actor" class="form-control" id="ex1" value="${actor.id}" readonly>
            <label for="ex2">Tên diễn viên</label>
            <input type="text" name="name_actor" id="ex2" placeholder="${actor.name}"> <br>
            <input type="hidden" name="id_movie" value="${requestScope.id_movie}">
            <button type="submit" class="btn btn-primary">Sửa</button>
        </form>
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
