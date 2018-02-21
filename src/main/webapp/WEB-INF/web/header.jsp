<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<!doctype html>
<!--[if lt IE 7]>		<html class="no-js lt-ie9 lt-ie8 lt-ie7" lang=""> <![endif]-->
<!--[if IE 7]>			<html class="no-js lt-ie9 lt-ie8" lang=""> <![endif]-->
<!--[if IE 8]>			<html class="no-js lt-ie9" lang=""> <![endif]-->
<!--[if gt IE 8]><!-->	<html class="no-js" lang="zxx"> <!--<![endif]-->
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title><s:message code="title"></s:message></title>
    <meta name="description" content="">
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
                <span class="tg-rtltextbox"><em>Tianjin Advanced future Network laboratory</em></span>
            </div>
            <div class="tg-rightbox">
                <span class="tg-tollfree"><s:message code="address"></s:message></span>
                <div class="tg-themedropdown tg-languagesdropdown">
                    <a href="javascript:void(0);" id="tg-languages" class="tg-btndropdown" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        <span><img src="images/flags/img-01.jpg" alt="image description"></span>
                        <s:message code="locale"></s:message>
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
                            <li>
                                <span><img src="images/flags/img-02.jpg" alt="image description"></span>
                                <span>El español</span>
                            </li>
                            <li>
                                <span><img src="images/flags/img-02.jpg" alt="image description"></span>
                                <span>日本語の</span>
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
                        <strong class="tg-logo"><a href="/tanklab/index"><img src="/tanklab/images/logo.png" alt="University of Education and knowledge"></a></strong>
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
                                        <a href="/tanklab/index"><s:message code="nav_index"></s:message></a>
                                    </li>
                                    <li class="menu-item-has-children">
                                        <a href="javascript:void(0);"><s:message code="nav_lab"></s:message></a>
                                        <ul class="sub-menu">
                                            <li><a href="/tanklab/introduction">实验室简介</a></li>
                                            <li><a href="javascript:void(0)">主任祝语</a></li>
                                            <li><a href="javascript:void(0)">学术委员会</a></li>
                                            <li><a href="javascript:void(0)">仪器设备</a></li>
                                            <li><a href="javascript:void(0)">科研环境</a></li>
                                        </ul>
                                    </li>
                                    <li class="menu-item-has-children">
                                        <a href="javascript:void(0);"><s:message code="nav_news"></s:message></a>
                                        <ul class="sub-menu">
                                            <li><a href="/tanklab/announcementList?page=1">通知公告</a></li>
                                            <li><a href="/tanklab/newsList?page=1">新闻动态</a></li>
                                        </ul>
                                    </li>
                                    <li class="menu-item-has-children">
                                        <a href="javascript:void(0);"><s:message code="nav_research"></s:message></a>
                                        <ul class="sub-menu">
                                            <li><a href="/tanklab/research">未来网络体系结构</a></li>
                                            <li><a href="/tanklab/research">智能网络技术与应用</a></li>
                                            <li><a href="/tanklab/research">智慧城市与大数据</a></li>
                                            <li><a href="/tanklab/research">网络信息安全</a></li>
                                        </ul>
                                    </li>
                                    <li class="menu-item-has-children">
                                        <a href="javascript:void(0);"><s:message code="nav_project"></s:message></a>
                                        <ul class="sub-menu">
                                            <li><a href="javascript:void(0)">进行项目</a></li>
                                            <li><a href="javascript:void(0)">合作项目</a></li>
                                            <li><a href="javascript:void(0)">结题项目</a></li>
                                        </ul>
                                    </li>
                                    <li class="menu-item-has-children">
                                        <a href="javascript:void(0);"><s:message code="nav_team"></s:message></a>
                                        <ul class="sub-menu">
                                            <li><a href="/tanklab/teacherGridView">固定科研人员</a></li>
                                            <li><a href="/tanklab/teacherGridView">客座科研人员</a></li>
                                            <li><a href="/tanklab/teacherGridView">流动科研人员</a></li>
                                            <li><a href="/tanklab/teacherGridView">研究生阵容</a></li>
                                            <li><a href="/tanklab/teacherGridView">人才招聘</a></li>
                                        </ul>
                                    </li>
                                    <li class="menu-item-has-children">
                                        <a href="javascript:void(0);"><s:message code="nav_output"></s:message></a>
                                        <ul class="sub-menu">
                                            <li><a href="javascript:void(0)">论文及专著</a></li>
                                            <li><a href="javascript:void(0)">获奖情况</a></li>
                                            <li><a href="javascript:void(0)">专利、软件著作权</a></li>
                                            <li><a href="javascript:void(0)">成果展示</a></li>
                                            <li><a href="javascript:void(0)">开源下载</a></li>
                                        </ul>
                                    </li>
                                    <li class="menu-item-has-children">
                                        <a href="javascript:void(0);"><s:message code="nav_exchange"></s:message></a>
                                        <ul class="sub-menu">
                                            <li><a href="javascript:void(0)">学术交流</a></li>
                                            <li><a href="javascript:void(0)">开放课题</a></li>
                                        </ul>
                                    </li>
                                    <li class="menu-item-has-children">
                                        <a href="javascript:void(0);"><s:message code="nav_educate"></s:message></a>
                                        <ul class="sub-menu">
                                            <li><a href="javascript:void(0)">招生计划</a></li>
                                            <li><a href="javascript:void(0)">培养计划</a></li>
                                            <li><a href="javascript:void(0)">课程资源</a></li>
                                        </ul>
                                    </li>
                                    <li class="menu-item-has-children">
                                        <a href="javascript:void(0);"><s:message code="nav_contact"></s:message></a>
                                        <ul class="sub-menu">
                                            <li><a href="">联系方式</a></li>
                                            <li><a href="javascript:void(0)">交通指南</a></li>
                                        </ul>
                                    </li>
                                    <li>
                                        <a href="http://tanktju.com:214"><s:message code="nav_innernet"></s:message></a>
                                    </li>
                                </ul>
                            </div>
                        </nav>
                    </div>
                </div>
            </div>
        </div>
    </header>

