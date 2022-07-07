<%--
  Created by IntelliJ IDEA.
  User: Dũng Sobin
  Date: 5/11/2022
  Time: 5:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css"/>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
    <style>
        .rating-num {
            color: black;
        }


        .fa {
            margin-right: 5px;
        }

        .rating .fa {
            font-size: 22px;
        }

        .rating-num {
            margin-top: 0px;
            font-size: 60px;
        }

        .progress {
            margin-bottom: 5px;
        }

        .progress-bar {
            text-align: left;
        }

        .rating-desc .col-md-3 {
            padding-right: 0px;
        }

        .sr-only {
            margin-left: 5px;
            overflow: visible;
            clip: auto;
        }
        div,label{margin:0;padding:0;color: black;}

        span.fa.fa-user {
            color: black;
        }

        .fa.fa-star {
            color: RGB(255, 215, 0);
        }

        .progress-bar.progress-bar-success {
            width: 0%;
            transition: 0.5s width ease-in;
        }

        #voting-star {
            margin-top: 83px;
        }

    </style>
</head>
<body>
<div >
    <div class="row">
        <div class="col-md-3"></div>
        <div class="col-md-6">
            <div class="well well-sm" id="voting-star">
                <div class="row">
                    <div class="col-xs-12 col-md-6">
                        <div class="row rating-desc">

                            <div class="col-xs-3 col-md-3 text-right">
                                <span class="fa fa-star"></span>5
                            </div>
                            <div class="col-xs-8 col-md-9">
                                <div class="progress">
                                    <div id="personFive" class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="20"
                                         aria-valuemin="0" aria-valuemax="100" style="width: <fmt:formatNumber value="${percentFive}" maxFractionDigits="0"/>%">
                                        <span  class="sr-only"><fmt:formatNumber value="${percentFive}" maxFractionDigits="0"/>%</span>
                                    </div>
                                </div>
                            </div>
                            <div class="col-xs-3 col-md-3 text-right">
                                <span class="fa fa-star"></span>4
                            </div>
                            <div class="col-xs-8 col-md-9">
                                <div class="progress">
                                    <div id="personFour" class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="20"
                                         aria-valuemin="0" aria-valuemax="100" style="width: <fmt:formatNumber value="${percentFour}" maxFractionDigits="0"/>%">
                                        <span  class="sr-only"><fmt:formatNumber value="${percentFour}" maxFractionDigits="0"/>%</span>
                                    </div>
                                </div>
                            </div>
                            <div class="col-xs-3 col-md-3 text-right">
                                <span class="fa fa-star"></span>3
                            </div>
                            <div class="col-xs-8 col-md-9">
                                <div class="progress">
                                    <div id="personThree" class="progress-bar progress-bar-info" role="progressbar" aria-valuenow="20"
                                         aria-valuemin="0" aria-valuemax="100" style="width: <fmt:formatNumber value="${percentThree}" maxFractionDigits="0"/>%">
                                        <span  class="sr-only"><fmt:formatNumber value="${percentThree}" maxFractionDigits="0"/>%</span>
                                    </div>
                                </div>
                            </div>
                            <div class="col-xs-3 col-md-3 text-right">
                                <span class="fa fa-star"></span>2
                            </div>
                            <div class="col-xs-8 col-md-9">
                                <div class="progress">
                                    <div id="personTwo" class="progress-bar progress-bar-warning" role="progressbar" aria-valuenow="20"
                                         aria-valuemin="0" aria-valuemax="100" style="width: <fmt:formatNumber value="${percentTwo}" maxFractionDigits="0"/>%">
                                        <span  class="sr-only"><fmt:formatNumber value="${percentTwo}" maxFractionDigits="0"/>%</span>
                                    </div>
                                </div>
                            </div>
                            <div class="col-xs-3 col-md-3 text-right">
                                <span class="fa fa-star"></span>1
                            </div>
                            <div class="col-xs-8 col-md-9">
                                <div class="progress">
                                    <div id="personOne" class="progress-bar progress-bar-danger" role="progressbar" aria-valuenow="80"
                                         aria-valuemin="0" aria-valuemax="100" style="width: <fmt:formatNumber value="${percentOne}" maxFractionDigits="0"/>%">
                                        <span id="personOne1" class="sr-only"><fmt:formatNumber value="${percentOne}" maxFractionDigits="0"/>%</span>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!-- end row -->
                    </div>
                    <div class="col-xs-12 col-md-6 text-center">
                        <h1 id="average" class="rating-num"><fmt:formatNumber value="${requestScope.avg}" maxFractionDigits="1"/></h1>
                        <div class="rating">
                            <span class="fa fa-star "></span>
                            <span class="fa fa-star "></span>
                            <span class="fa fa-star "></span>
                            <span class="fa fa-star "></span>
                            <span class="fa fa-star "></span>
                        </div>
                        <div id="total">
                            <span  class="fa fa-user"></span>${totalVote} total votes
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-md-3"></div>
    </div>
</div>

</body>
</html>
