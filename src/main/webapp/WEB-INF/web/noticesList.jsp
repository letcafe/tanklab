<%--
  Created by IntelliJ IDEA.
  User: minoz
  Date: 2018/1/30
  Time: 16:02
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<!doctype html>
<!--[if lt IE 7]>		<html class="no-js lt-ie9 lt-ie8 lt-ie7" lang=""> <![endif]-->
<!--[if IE 7]>			<html class="no-js lt-ie9 lt-ie8" lang=""> <![endif]-->
<!--[if IE 8]>			<html class="no-js lt-ie9" lang=""> <![endif]-->
<!--[if gt IE 8]><!-->	<html class="no-js" lang="zxx"> <!--<![endif]-->
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>TANK先进未来网络实验室</title>
    <meta name="description" content="">4
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="apple-touch-icon" href="apple-touch-icon.png">
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/normalize.css">
    <link rel="stylesheet" href="css/font-awesome.min.css">
    <link rel="stylesheet" href="css/icomoon.css">
    <link rel="stylesheet" href="css/animate.css">
    <link rel="stylesheet" href="css/prettyPhoto.css">
    <link rel="stylesheet" href="css/owl.carousel.css">
    <link rel="stylesheet" href="css/owl.theme.default.css">
    <link rel="stylesheet" href="css/transitions.css">
    <link rel="stylesheet" href="css/main.css">
    <link rel="stylesheet" href="css/color.css">
    <link rel="stylesheet" href="css/responsive.css">
    <script src="js/vendor/modernizr-2.8.3-respond-1.4.2.min.js"></script>

    <!-- 自定义index.html的CSS -->
    <style>
        #quickLinkList li a {
            padding-top:17px;
            padding-bottom:17px;
        }
        /* bug模拟修复：去除删掉signupbox带来的下排图标在上面切换按钮时会被选中的情况 */
        .tg-signupbox {
            background:white;
            padding:1px;
        }
        #copyright {
            display:inline;
            text-align:center;
        }
        #titleRight {
            width:360px;
            font-style:italic;
            text-align:right;
            padding-top:15px;
        }
        #titleRight span {
            color:#C0C0C0;
        }
        figure {
            margin-left:0px;
            margin-right:0px;
        }
        figure a img {
            width:170px;
            height:170px;
        }
        .tg-themepostcontent {
            text-align:center;
        }
        .tg-themeposttitle {
            height:40px;
        }
        .tg-themeposttags {
            font-size:18px;
        }
        .tg-themeposttags li{
            float:none;
        }
        .tg-themeposttitle h3 {
            font-size:10px;
        }
        .tg-course {
            text-align:center;
        }
        .left_picture {
            width:250px !important;
        }
        .tg-themepostcontent {
            padding:0px 0px 0px 15px !important;
        }
    </style>
</head>
<body class="tg-home tg-homeone">
<!--[if lt IE 8]>
<p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
<![endif]-->
<!--************************************
        Wrapper Start
*************************************-->
<div id="tg-wrapper" class="tg-wrapper">
    <!--************************************
            Header Start
    *************************************-->
    <%@ include file = "header.jsp" %>
    <!--************************************
            Header End
    *************************************-->
    <!--************************************
            Home Slider Start
    *************************************-->
    <!--************************************
            Home Slider End
    *************************************-->
    <!--************************************
            Main Start
    *************************************-->
    <main id="tg-main" class="tg-main tg-haslayout">
        <div class="container">
            <div class="row">
                <div id="tg-twocolumns" class="tg-twocolumns">
                    <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 pull-right">
                        <div id="tg-content" class="tg-content">
                            <div class="tg-titleborder">
                                <h2>实验室近期公告</h2>
                            </div>
                            <div class="tg-newsandarticle tg-list">
                                <table id="fileListView" class="table table-hover">
                                    <tbody id="notices_form_body">
                                    <c:forEach items="${pagedNotices}" var="notices">
                                        <tr>
                                            <td class="col-xs-2" style="border-right: 0;border-left: 0;border-top: 0"><c:out value="${notices.date}"></c:out></td>
                                            <td class="col-xs-2" style="border-right: 0;border-left: 0;border-top: 0"><c:out value="${notices.title}"></c:out></td>
                                            <td class="col-xs-1" style="border-right: 0;border-left: 0;border-top: 0"><button class="label"><a href="/tanklab/detailNotices?id=${notices.id}">详情</a></button></td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            <nav class="tg-pagination">
                                <ul>
                                    <%--page不等于1显示首页--%>
                                    <c:if test="${page != 1}">
                                        <li class="tg-prevpage"><a href="/tanklab/noticesList?page=1">首页</a></li>
                                    </c:if>
                                    <%--前一页不为空显示上一页--%>
                                    <c:if test="${prePageIndex != null}">
                                        <li class="tg-prevpage"><a href="/tanklab/noticesList?page=${prePageIndex}">上页</a></li>
                                    </c:if>
                                    <%--遍历列表--%>
                                    <c:forEach var="index" begin="1" end="${maxPage}" step="1">
                                        <c:choose>
                                            <%--如果page等于当前页，当前页高亮--%>
                                            <c:when test="${page == index}">
                                                <li class="tg-active"><a href="/tanklab/noticesList?page=${index}">${index}</a></li>
                                            </c:when>
                                            <%--否则正常输出--%>
                                            <c:otherwise>
                                                <li><a href="/tanklab/noticesList?page=${index}">${index}</a></li>
                                            </c:otherwise>
                                        </c:choose>
                                    </c:forEach>
                                    <%--前一页不为空显示上一页--%>
                                    <c:if test="${nextPageIndex != null}">
                                        <li class="tg-nextpage"><a href="/tanklab/noticesList?page=${nextPageIndex}">下页</a></li>
                                    </c:if>
                                    <%--page不等于maxPage显示尾页--%>
                                    <c:if test="${page != maxPage}">
                                        <li class="tg-nextpage"><a href="/tanklab/noticesList?page=${maxPage}">尾页</a></li>
                                    </c:if>
                                </ul>
                            </nav>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </main>
    <!--************************************
            Main End
    *************************************-->
    <!--************************************
            Footer Start
    *************************************-->
    <%@ include file ="footer.jsp" %>
    <!--************************************
            Footer End
    *************************************-->
</div>
<!--************************************
        Wrapper End
*************************************-->
<script src="js/vendor/jquery-library.js"></script>
<script src="js/vendor/bootstrap.min.js"></script>
<script src="js/mapclustering/data.json"></script>
<!-- 谷歌地图js，在未使用vpn的情况下，加载超时，因此注释此插件 -->
<!-- <script src="https://maps.google.com/maps/api/js?key=AIzaSyCR-KEWAVCn52mSdeVeTqZjtqbmVJyfSus&language=en"></script> -->
<script src="js/mapclustering/markerclusterer.min.js"></script>
<script src="js/mapclustering/infobox.js"></script>
<script src="js/mapclustering/map.js"></script>
<script src="js/owl.carousel.min.js"></script>
<script src="js/isotope.pkgd.js"></script>
<script src="js/prettyPhoto.js"></script>
<script src="js/countdown.js"></script>
<script src="js/collapse.js"></script>
<script src="js/moment.js"></script>
<script src="js/gmap3.js"></script>
<script src="js/main.js"></script>
<script src="js/newsList.js"></script>
</body>
</html>