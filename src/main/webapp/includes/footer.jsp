<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<footer class="footer">

    <div style="color:white" class="copyright">
        <jsp:useBean id="date" class="java.util.Date" />
        <small>&copy; Copyright <fmt:formatDate value="${date}" pattern="yyyy" />, SobinPhim.TV</small>
    </div>
    <div class="footer-container">
        <a href="https://github.com/dsb102"><i class="fa-brands fa-github footer-icon"></i></a>
        <a href="https://www.facebook.com/dungsobin102/"><i class="fa-brands fa-facebook footer-icon"></i></a>
        <a href="https://www.youtube.com/channel/UCerGI3bTjNLy31DxUcURlfw"><i class="fa-brands fa-youtube footer-icon"></i></a>
    </div>

</footer>
<%--<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>--%>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>