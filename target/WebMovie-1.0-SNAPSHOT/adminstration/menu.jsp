<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="includes/header.jsp" %>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.9.4/Chart.js"></script>
<script type="text/javascript" src="https://cdn.jsdelivr.net/npm/chart.js"></script>

<!-- End Navbar -->
<div class="content">
    <div class="container-fluid">
        <h1>Thống kê phân tích phim</h1>


        <canvas id="myChart"></canvas>

        <canvas id="myChart1"></canvas>

        <canvas id="myChart2"></canvas>

        <canvas id="myChart3"></canvas>

        <canvas id="barChart" style="width:100%"></canvas>

        <canvas id="pieChart" style="width: 500px"></canvas>


    </div>
</div>
<%@include file="includes/footer.jsp" %>
</div>
</div>

<script>
    // setup
    <c:set var="singles" value="${requestScope.movieSingle}"/>
    array = [];
    dataView = [];
    dataVote = [];
    <c:forEach items="${singles}" var="single">
    array.push("${single.name}");
    </c:forEach>

    <c:forEach items="${singles}" var="single">
    dataView.push(${single.sum});
    </c:forEach>

    <c:forEach items="${singles}" var="single">
    dataVote.push(${single.avg});
    </c:forEach>

    var data = {
        labels: array,
        datasets: [{
            label: 'Lượt xem',
            data: dataView,
            backgroundColor: [
                'rgba(255, 26, 104, 0.2)',
                'rgba(54, 162, 235, 0.2)',
                'rgba(255, 206, 86, 0.2)',
                'rgba(75, 192, 192, 0.2)',
                'rgba(153, 102, 255, 0.2)',
                'rgba(255, 159, 64, 0.2)',
                'rgba(0, 0, 0, 0.2)'
            ],
            borderColor: [
                'rgba(255, 26, 104, 1)',
                'rgba(54, 162, 235, 1)',
                'rgba(255, 206, 86, 1)',
                'rgba(75, 192, 192, 1)',
                'rgba(153, 102, 255, 1)',
                'rgba(255, 159, 64, 1)',
                'rgba(0, 0, 0, 1)'
            ],
            borderWidth: 1,
            yAxisID: 'views'
        }, {

            label: 'Sao',
            data: dataVote,
            backgroundColor: [
                'rgba(255, 26, 104, 0.2)'

            ],
            borderColor: [
                'rgb(17,54,236, 1)'
            ],
            type: 'line',
            yAxisID: 'stars'
        }]
    };

    // config
    var config = {
        type: 'bar',
        data,
        options: {
            scales: {
                views: {
                    beginAtZero: true,
                    type: 'linear',
                    position: 'left'
                },
                stars: {
                    beginAtZero: true,
                    type: 'linear',
                    position: 'right'
                }
            },
            plugins: {
                title: {
                    display: true,
                    text: 'Biểu đồ cột đường Top 10 lượt xem và số sao phim lẻ'
                }
            }
        }
    };

    // render init block
    const myChart = new Chart(
        document.getElementById('myChart'),
        config,
    );
</script>

<script>
    // setup
    <c:set var="series" value="${requestScope.movieSeries}"/>
    array1 = [];
    dataView1 = [];
    dataVote1 = []
    <c:forEach items="${series}" var="serie">
    array1.push("${serie.name}");
    </c:forEach>

    <c:forEach items="${series}" var="serie">
    dataView1.push(${serie.sum});
    </c:forEach>

    <c:forEach items="${series}" var="serie">
    dataVote1.push(${serie.avg});
    </c:forEach>

    var data = {
        labels: array1,
        datasets: [{
            label: 'Lượt xem',
            data: dataView1,
            backgroundColor: [
                'rgba(255, 124, 104, 0.2)',
                'rgba(54, 162, 215, 0.2)',
                'rgba(255, 206, 96, 0.2)',
                'rgba(75, 214, 192, 0.2)',
                'rgba(153, 102, 45, 0.2)',
                'rgba(255, 25, 64, 0.2)',
                'rgba(0, 0, 0, 0.2)'
            ],
            borderColor: [
                'rgba(255, 26, 104, 1)',
                'rgba(54, 162, 235, 1)',
                'rgba(255, 206, 86, 1)',
                'rgba(75, 192, 192, 1)',
                'rgba(153, 102, 255, 1)',
                'rgba(255, 159, 64, 1)',
                'rgba(0, 0, 0, 1)'
            ],
            borderWidth: 1,
            yAxisID: 'views'
        }, {
            label: 'Sao',
            data: dataVote1,
            backgroundColor: [
                'rgba(255, 26, 104, 0.2)'

            ],
            borderColor: [
                'rgb(248,248,8)'
            ],
            type: 'line',
            yAxisID: 'stars'
        }]
    };

    // config
    var config1 = {
        type: 'bar',
        data,
        options: {
            scales: {
                views: {
                    beginAtZero: true,
                    type: 'linear',
                    position: 'left'
                },
                stars: {
                    beginAtZero: true,
                    type: 'linear',
                    position: 'right'
                }
            },
            plugins: {
                title: {
                    display: true,
                    text: 'Biểu đồ cột đường Top 10 lượt xem và số sao phim bộ'
                }
            }
        }
    };

    // render init block
    const myChart1 = new Chart(
        document.getElementById('myChart1'),
        config1,
    );

</script>

<script>
    // setup
    <c:set var="tvshows" value="${requestScope.movieTvshows}"/>
    array2 = [];
    dataView2 = [];
    dataVote2 = []
    <c:forEach items="${tvshows}" var="tvshow">
    array2.push("${tvshow.name}");
    </c:forEach>

    <c:forEach items="${tvshows}" var="tvshow">
    dataView2.push(${tvshow.sum});
    </c:forEach>

    <c:forEach items="${tvshows}" var="tvshow">
    dataVote2.push(${tvshow.avg});
    </c:forEach>

    var data = {
        labels: array2,
        datasets: [{
            label: 'Lượt xem',
            data: dataView2,
            backgroundColor: [
                'rgba(255, 45, 104, 0.2)',
                'rgba(54, 162, 72, 0.2)',
                'rgba(255, 206, 86, 0.2)',
                'rgba(75, 192, 192, 0.2)',
                'rgba(153, 89, 255, 0.2)',
                'rgba(255, 159, 102, 0.2)',
                'rgba(0, 0, 0, 0.2)'
            ],
            borderColor: [
                'rgba(255, 26, 104, 1)',
                'rgba(54, 162, 235, 1)',
                'rgba(255, 206, 86, 1)',
                'rgba(75, 192, 192, 1)',
                'rgba(153, 102, 255, 1)',
                'rgba(255, 159, 64, 1)',
                'rgba(0, 0, 0, 1)'
            ],
            borderWidth: 1,
            yAxisID: 'views'
        }, {
            label: 'Sao',
            data: dataVote2,
            backgroundColor: [
                'rgba(255, 26, 104, 0.2)'

            ],
            borderColor: [
                'rgb(232,141,9,1)'
            ],
            type: 'line',
            yAxisID: 'stars'
        }]
    };

    // config
    var config2 = {
        type: 'bar',
        data,
        options: {
            scales: {
                views: {
                    beginAtZero: true,
                    type: 'linear',
                    position: 'left'
                },
                stars: {
                    beginAtZero: true,
                    type: 'linear',
                    position: 'right'
                }
            },
            plugins: {
                title: {
                    display: true,
                    text: 'Biểu đồ cột đường Top 10 lượt xem và số sao TV Show'
                }
            }
        }
    };

    // render init block
    const myChart2 = new Chart(
        document.getElementById('myChart2'),
        config2,
    );
</script>

<script>
    // setup
    <c:set var="hoathinhs" value="${requestScope.movieHoathinh}"/>
    array3 = [];
    dataView3 = [];
    dataVote3 = []
    <c:forEach items="${hoathinhs}" var="hoathinh">
    array3.push("${hoathinh.name}");
    </c:forEach>

    <c:forEach items="${hoathinhs}" var="hoathinh">
    dataView3.push(${hoathinh.sum});
    </c:forEach>

    <c:forEach items="${hoathinhs}" var="hoathinh">
    dataVote3.push(${hoathinh.avg});
    </c:forEach>

    var data = {
        labels: array3,
        datasets: [{
            label: 'Lượt xem',
            data: dataView3,
            backgroundColor: [
                'rgba(255, 40, 104, 0.2)',
                'rgba(20, 162, 235, 0.2)',
                'rgba(20, 206, 86, 0.2)',
                'rgba(75, 192, 192, 0.2)',
                'rgba(153, 32, 255, 0.2)',
                'rgba(45, 159, 64, 0.2)',
                'rgba(0, 0, 0, 0.2)'
            ],
            borderColor: [
                'rgba(255, 26, 104, 1)',
                'rgba(54, 162, 235, 1)',
                'rgba(255, 206, 86, 1)',
                'rgba(75, 192, 192, 1)',
                'rgba(153, 102, 255, 1)',
                'rgba(255, 159, 64, 1)',
                'rgba(0, 0, 0, 1)'
            ],
            borderWidth: 1,
            yAxisID: 'views'
        }, {
            label: 'Sao',
            data: dataVote3,
            backgroundColor: [
                'rgba(255, 26, 104, 0.2)'

            ],
            borderColor: [
                'rgb(5,243,8, 1)'
            ],
            type: 'line',
            yAxisID: 'stars'
        }]
    };

    // config
    var config3 = {
        type: 'bar',
        data,
        options: {
            scales: {
                views: {
                    beginAtZero: true,
                    type: 'linear',
                    position: 'left'
                },
                stars: {
                    beginAtZero: true,
                    type: 'linear',
                    position: 'right'
                },
                // y: {
                //     min:10,
                //     max:70,
                // }
            },
            plugins: {
                title: {
                    display: true,
                    text: 'Biểu đồ cột đường Top 10 lượt xem và số sao phim hoạt hình'
                }
            }
        }
    };

    // render init block
    const myChart3 = new Chart(
        document.getElementById('myChart3'),
        config3,
    );
</script>

<script>

    var xValues = ["2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022"];
    var yValues = [];
    yValues.push(${requestScope.year_2015}); yValues.push(${requestScope.year_2016});
    yValues.push(${requestScope.year_2017}); yValues.push(${requestScope.year_2018});
    yValues.push(${requestScope.year_2019}); yValues.push(${requestScope.year_2020});
    yValues.push(${requestScope.year_2021}); yValues.push(${requestScope.year_2022});
    var barColors = [
        'rgba(255, 26, 104, 0.2)',
        'rgba(54, 162, 235, 0.2)',
        'rgba(255, 206, 86, 0.2)',
        'rgba(75, 192, 192, 0.2)',
        'rgba(153, 102, 255, 0.2)',
        'rgba(255, 159, 64, 0.2)',
        'rgba(0, 0, 0, 0.2)',
        'rgba(75, 102, 192, 0.2)'
    ];

    new Chart("barChart", {
        type: "line",
        data: {
            labels: xValues,
            datasets: [{
                label: 'Lượt xem',
                backgroundColor: barColors,
                data: yValues,
                yAxisID: 'views',
                borderColor: [
                    'rgb(6,239,248)'
                ]
            }]
        },
        options: {
            legend: {display: false},
            scales: {
                views: {
                    beginAtZero: true,
                    type: 'linear',
                    position: 'left'
                }
                // y: {
                //     min:10,
                //     max:70,
                // }
            },
            // scales: {
            //     yAxes: [{ticks: {min: 6, max:60}}],
            // },
            plugins: {
                title: {
                    display: true,
                    text: 'Biểu đồ cột thống kê lượt xem theo năm phát hành'
                }
            }
        }
    });
</script>

<script>
    var xValues = ["Phim lẻ", "Phim bộ", "TVShow", "Hoạt hình"];
    var yValues = [];
    yValues.push(${requestScope.single});
    yValues.push(${requestScope.series});
    yValues.push(${requestScope.tvshows});
    yValues.push(${requestScope.hoathinh});
    var barColors = [
        "#b91d47",
        "#00aba9",
        "#2b5797",
        "#e8c3b9"
    ];

    new Chart("pieChart", {
        type: "pie",
        data: {
            labels: xValues,
            datasets: [{
                backgroundColor: barColors,
                data: yValues
            }]
        },
        options: {
            plugins: {
                title: {
                    display: true,
                    text: 'Biểu đồ hình quạt thống kê lượt xem loại phim'
                }
            }
        }
    });
</script>

<script>
    var xValues = [100, 200, 300, 400, 500, 600, 700, 800, 900, 1000];

    new Chart("multiChart", {
        type: "line",
        data: {
            labels: xValues,
            datasets: [{
                data: [860, 1140, 1060, 1060, 1070, 1110, 1330, 2210, 7830, 2478],
                borderColor: "red",
                fill: false
            }, {
                data: [1600, 1700, 1700, 1900, 2000, 2700, 4000, 5000, 6000, 7000],
                borderColor: "green",
                fill: false
            }, {
                data: [300, 700, 2000, 5000, 6000, 4000, 2000, 1000, 200, 100],
                borderColor: "blue",
                fill: false
            }]
        },
        options: {
            legend: {display: false}
        }
    });
</script>
</body>
<!-- Core JS Files -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.5.0/Chart.min.js"></script>
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
