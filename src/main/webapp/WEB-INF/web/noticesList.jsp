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
    <header id="tg-header" class="tg-header tg-haslayout">
        <div class="tg-topbar">
            <div class="tg-leftbox">
                <span id="tg-datebox" class="tg-datebox"></span>
                <span class="tg-rtltextbox"><em>天津市先进网络技术与应用重点实验室</em></span>
            </div>
            <div class="tg-rightbox">
                <span class="tg-tollfree">地址: 天津大学计算机科学与技术学院B214</span>
                <div class="tg-themedropdown tg-languagesdropdown">
                    <a href="javascript:void(0);" id="tg-languages" class="tg-btndropdown" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        <span><img src="images/flags/img-01.jpg" alt="image description"></span>
                        <span>中文</span>
                    </a>
                    <div class="tg-themedropdownbox" aria-labelledby="tg-languages">
                        <ul class="tg-languageslist">
                            <li>
                                <span><img src="images/flags/img-01.jpg" alt="image description"></span>
                                <span>中文</span>
                            </li>
                            <li>
                                <span><img src="images/flags/img-02.jpg" alt="image description"></span>
                                <span>English</span>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
        <div class="clearfix"></div>
        <div class="container">
            <div class="row">
                <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
                    <div class="tg-logoandnoticeboard">
                        <strong class="tg-logo"><a href="index.jsp"><img src="images/logo.png" alt="University of Education and knowledge"></a></strong>
                        <div class="tg-noticeboard hidden-xs">
                            <div id="titleRight" class="tg-textbox">
                                <span>“The people who are crazy enough to think that they can change the world, are the ones who do.”</span>
                            </div>
                        </div>
                    </div>
                    <div class="tg-navigationarea">
                        <nav id="tg-nav" class="tg-nav">
                            <div class="navbar-header">
                                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#tg-navigation" aria-expanded="false">
                                    <span class="sr-only">Toggle navigation</span>
                                    <span class="icon-bar"></span>
                                    <span class="icon-bar"></span>
                                    <span class="icon-bar"></span>
                                </button>
                            </div>
                            <div id="tg-navigation" class="collapse navbar-collapse tg-navigation">
                                <ul>
                                    <li>
                                        <a href="javascript:void(0);">首页</a>
                                    </li>
                                    <li class="menu-item-has-children">
                                        <a href="javascript:void(0);">实验室</a>
                                        <ul class="sub-menu">
                                            <li><a href="departments.html">实验室简介</a></li>
                                            <li><a href="departmentdetail.html">主任祝语</a></li>
                                            <li><a href="departments.html">学术委员会</a></li>
                                            <li><a href="departmentdetail.html">仪器设备</a></li>
                                            <li><a href="departmentdetail.html">科研环境</a></li>
                                        </ul>
                                    </li>
                                    <li class="menu-item-has-children">
                                        <a href="javascript:void(0);">资讯速递</a>
                                        <ul class="sub-menu">
                                            <li><a href="admissions.html">通知公告</a></li>
                                            <li><a href="newsList.jsp">新闻动态</a></li>
                                        </ul>
                                    </li>
                                    <li class="menu-item-has-children">
                                        <a href="javascript:void(0);">科研方向</a>
                                        <ul class="sub-menu">
                                            <li><a href="departments.html">未来网络体系结构</a></li>
                                            <li><a href="departmentdetail.html">智能网络技术与应用</a></li>
                                            <li><a href="departments.html">智慧城市与大数据</a></li>
                                            <li><a href="departmentdetail.html">网络信息安全</a></li>
                                        </ul>
                                    </li>
                                    <li class="menu-item-has-children">
                                        <a href="javascript:void(0);">研究项目</a>
                                        <ul class="sub-menu">
                                            <li><a href="departments.html">进行项目</a></li>
                                            <li><a href="departmentdetail.html">合作项目</a></li>
                                            <li><a href="departments.html">结题项目</a></li>
                                        </ul>
                                    </li>
                                    <li class="menu-item-has-children">
                                        <a href="javascript:void(0);">科研团队</a>
                                        <ul class="sub-menu">
                                            <li><a href="departments.html">固定科研人员</a></li>
                                            <li><a href="departmentdetail.html">客座科研人员</a></li>
                                            <li><a href="departments.html">流动科研人员</a></li>
                                            <li><a href="departmentdetail.html">研究生阵容</a></li>
                                            <li><a href="departmentdetail.html">人才招聘</a></li>
                                        </ul>
                                    </li>
                                    <li class="menu-item-has-children">
                                        <a href="javascript:void(0);">科研成果</a>
                                        <ul class="sub-menu">
                                            <li><a href="departments.html">论文及专著</a></li>
                                            <li><a href="departmentdetail.html">获奖情况</a></li>
                                            <li><a href="departments.html">专利、软件著作权</a></li>
                                            <li><a href="departmentdetail.html">成果展示</a></li>
                                            <li><a href="departments.html">开源下载</a></li>
                                        </ul>
                                    </li>
                                    <li class="menu-item-has-children">
                                        <a href="javascript:void(0);">开放交流</a>
                                        <ul class="sub-menu">
                                            <li><a href="departmentdetail.html">学术交流</a></li>
                                            <li><a href="departmentdetail.html">开放课题</a></li>
                                        </ul>
                                    </li>
                                    <li class="menu-item-has-children">
                                        <a href="javascript:void(0);">人才培养</a>
                                        <ul class="sub-menu">
                                            <li><a href="departments.html">招生计划</a></li>
                                            <li><a href="departmentdetail.html">培养计划</a></li>
                                            <li><a href="departments.html">课程资源</a></li>
                                        </ul>
                                    </li>
                                    <li class="menu-item-has-children">
                                        <a href="javascript:void(0);">联系我们</a>
                                        <ul class="sub-menu">
                                            <li><a href="departmentdetail.html">联系方式</a></li>
                                            <li><a href="departmentdetail.html">交通指南</a></li>
                                        </ul>
                                    </li>
                                    <li>
                                        <a href="javascript:void(0);">内部网络</a>
                                    </li>
                                </ul>
                            </div>
                        </nav>
                    </div>
                </div>
            </div>
        </div>
    </header>
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
                                            <td class="col-xs-1" style="border-right: 0;border-left: 0;border-top: 0"><button class="label label-info"><a href="/tanklab/detailNotices?id=${notices.id}">More Info</a></button></td>
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
    <footer id="tg-footer" class="tg-footer tg-haslayout">
        <div class="tg-signupbox">
            <!-- 				<div class="tg-signuptextbox">
                                <h3>Free Signup!</h3>
                                <div class="tg-description"><p>Subscribe Monthly Newsletter &amp; Get Latest New &amp; Updates.</p></div>
                            </div>
                            <form class="tg-formtheme tg-formsignupfree">
                                <fieldset>
                                    <div class="form-group"><input type="text" name="emailid" class="form-control" placeholder="Enter Email ID"></div>
                                    <div class="form-group"><button type="submit" class="tg-btn">Signup Now</button></div>
                                </fieldset>
                            </form> -->
        </div>
        <div class="tg-footermiddlebar">
            <div class="container">
                <div class="row">
                    <div class="col-xs-12 col-sm-6 col-md-4 col-lg-4">
                        <div class="tg-widget tg-widgetcompanyinfo">
                            <div class="tg-widgetcontent">
                                <strong class="tg-logo"><a href="index.jsp"><img src="images/logo2.png" alt="image description"></a></strong>
                                <div class="tg-description">
                                    <p>先进未来网络实验室是一个专注于未来网络前沿技术的研究团队，实验室主要有SDN软件定义网络方向...<a href="javascript:void(0);">更多</a></p>
                                </div>
                                <ul class="tg-infolist">
                                    <li>
                                        <i class="icon-location"></i>
                                        <address style="max-width:240px;">天津市津南区海河教育园区雅观路135号天津大学北洋园校区55楼教学楼B座214</address>
                                    </li>
                                    <li>
                                        <i class="icon-phone-handset"></i>
                                        <span>0800 - 1234 - 562 - 6</span>
                                    </li>
                                    <li>
                                        <i class="icon-printer"></i>
                                        <span>+4 1234 567 - 9</span>
                                    </li>
                                    <li>
                                        <a href="mailto:query@domain.com">
                                            <i class="icon-envelope"></i>
                                            <span>dongyuguo@tanktju.com</span>
                                        </a>
                                    </li>
                                </ul>
                                <!-- 下排图标：facebook,twitter等		<ul class="tg-socialicons">
                                                                        <li class="tg-facebook"><a href="javascript:void(0);"><i class="fa fa-facebook"></i></a></li>
                                                                        <li class="tg-twitter"><a href="javascript:void(0);"><i class="fa fa-twitter"></i></a></li>
                                                                        <li class="tg-linkedin"><a href="javascript:void(0);"><i class="fa fa-linkedin"></i></a></li>
                                                                        <li class="tg-googleplus"><a href="javascript:void(0);"><i class="fa fa-google-plus"></i></a></li>
                                                                        <li class="tg-rss"><a href="javascript:void(0);"><i class="fa fa-rss"></i></a></li>
                                                                    </ul> -->
                            </div>
                        </div>
                    </div>
                    <div class="col-xs-12 col-sm-6 col-md-4 col-lg-4">
                        <div class="tg-widget tg-widgettweets">
                            <div class="tg-widgettitle">
                                <h3>微博平台</h3>
                            </div>
                            <div class="tg-widgetcontent">
                                <ul>
                                    <li>
                                        <p>天气越来越热，毕业季的脚步越来越近@人民日报 的文章超实用！毕业生租房攻略 ​​​​</p>
                                        <span><a href="mailto:http://www.domainurl.com">http://cs.tju.edu.cn/csweb/</a></span>
                                        <time datetime="2017-01-01">2 小时前</time>
                                    </li>
                                    <li>
                                        <p>天大双甲子 学子忆北洋天大双甲子 校友忆北洋（计算机学院抢先版） ​​​​查看图片</p>
                                        <span><a href="mailto:http://www.domainurl.com">http://cs.tju.edu.cn/csweb/</a></span>
                                        <time datetime="2017-01-01">3 小时前</time>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </div>
                    <div class="col-xs-12 col-sm-6 col-md-4 col-lg-4">
                        <div class="tg-widget tg-widgetcoursecategories">
                            <div class="tg-widgettitle">
                                <h3>其他服务</h3>
                            </div>
                            <div class="tg-widgetcontent">
                                <ul>
                                    <li><a href="javascript:void(0);">人才招聘</a></li>
                                    <li><a href="javascript:void(0);">招生信息</a></li>
                                    <li><a href="javascript:void(0);">师资队伍</a></li>
                                    <li><a href="javascript:void(0);">科研团队</a></li>
                                    <li><a href="javascript:void(0);">成果登记</a></li>
                                    <li><a href="javascript:void(0);">会议室预定</a></li>
                                    <li><a href="javascript:void(0);">公示</a></li>
                                    <li><a href="javascript:void(0);">服务平台</a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="tg-footerbar">
            <div class="container">
                <div class="row">
                    <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12" id="copyright">
                        <span>Copyright &copy; 2017 All Rights Reserved</span>
                    </div>
                </div>
            </div>
        </div>
    </footer>
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