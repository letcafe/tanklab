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
	<meta name="description" content="">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="apple-touch-icon" href="../apple-touch-icon.png">
	<link rel="stylesheet" href="../css/bootstrap.min.css">
	<link rel="stylesheet" href="../css/normalize.css">
	<link rel="stylesheet" href="../css/font-awesome.min.css">
	<link rel="stylesheet" href="../css/icomoon.css">
	<link rel="stylesheet" href="../css/animate.css">
	<link rel="stylesheet" href="../css/prettyPhoto.css">
	<link rel="stylesheet" href="../css/owl.carousel.css">
	<link rel="stylesheet" href="../css/owl.theme.default.css">
	<link rel="stylesheet" href="../css/transitions.css">
	<link rel="stylesheet" href="../css/main.css">
	<link rel="stylesheet" href="../css/color.css">
	<link rel="stylesheet" href="../css/responsive.css">
	<script src="../js/vendor/modernizr-2.8.3-respond-1.4.2.min.js"></script>
	
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
	#tg-content div figure {
		text-align:center;
	}
	#tg-content div figure img {
		display:inline-block;
		height:370px;
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
		<%@ include file = "../header.jsp" %>
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
						<div class="col-xs-12 col-sm-4 col-md-3 col-lg-3">
							<aside id="tg-sidebar" class="tg-sidebar">
								<div class="tg-widget tg-widgetaboutusnav">
									<div class="tg-widgettitle">
										<h3>导师介绍</h3>
									</div>
									<div class="tg-widgetcontent">
										<ul>
											<!--<li><a href="javascript:void(0);">Rector's Message</a></li>-->
											<!--<li class="tg-active"><a href="javascript:void(0);">Vision &amp; Mission</a></li>-->
											<!--<li><a href="javascript:void(0);">Leadership</a></li>-->
											<!--<li><a href="javascript:void(0);">Objectives</a></li>-->
											<!--<li><a href="javascript:void(0);">Our Identity</a></li>-->
											<!--<li><a href="javascript:void(0);">Honors &amp; Awards</a></li>-->
											<!--<li><a href="javascript:void(0);">Campus Life</a></li>-->
										</ul>
									</div>
								</div>
							</aside>
						</div>
						<div class="col-xs-12 col-sm-8 col-md-9 col-lg-9">
							<div id="tg-content" class="tg-content">
								<div class="tg-aboutus tg-visionmission">
									<figure><img src="../images/courses/guowei.jpg" alt="image description"></figure>
									<h3>个人简介</h3>
									<p>最高学位：硕士<br>
									邮箱：weiguo@tju.edu.cn<br>
									通讯地址：北洋园校区55楼B420<br>
									个人主页：http://cs.tju.edu.cn/faculty/weiguo/index</p>
									<h3>研究方向</h3>
									<p>计算机系统结构、嵌入式系统、SoC设计、安全处理器、密码电路与密码分析</p>
									<h3>科研项目</h3>
									<p><b>在研究项目</b><br> 
									国家工业和信息化部项目：面向物联网传感器节点的信息安全嵌入式系统芯片及其方案的研发 <br>
									天津市自然科学基金： 高可信密码片上系统的关键技术研究 <br>
									中国科学院计算机体系结构国重实验室开放课题基金: 面向云计算服务器的高可信安全处理器新型体系结构的研究<br>
									苏州国芯半导体有限公司项目：C*Core处理器的ESL建模研究与实现<br>
									国家自然科学基金项目：基于可配置处理器的Ray-Tracing算法专用硬件体系结构的研究 </p>
									<h3>代表性论著</h3>
									<p>【1】《SoC设计与实现》，电子工业出版社，2007年6月。。"十一五"国家级规划教材，2008年教育部普通高等教育精品教材。第二版，电子工业出版社，2011年8月。<br>
									【2】《SoC嵌入式系統晶片設計 ─ 從理論邁向實務》，（台湾）博硕出版，2008年05月。海外发行。 <br>
									【3】Guo W, Ri K H, Cui L, et al. An Area-Efficient Unified Architecture for Multi-Functional Double-Precision Floating-Point Computation[J]. Journal of Circuits, Systems and Computers, 2015, 24(10): 1550151.（SCI） <br>
									【4】Jingwei Hu, Wei Guo, Jizeng Wei, Ray C.C. Cheung， Fast Inversion Architectures over GF(2m) Using Modified Itoh-Tsujii Algorithms，to appear in IEEE Transactions on Circuits and Systems II: Express Briefs. Published online,DOI 10.1109/TCSII.2014.2387612， Jan. 2015. （SCI） <br>
									【5】Jizeng Wei, Xulong Liu, Hao Liu, Wei Guo, A low-time-complexity and secure dual-field scalar multiplication based on co-Z protected NAF, IEICE Electronics Express, Vol.11, No.11, 1-12， 2014 （SCI） </p>
								</div>
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
									<strong class="tg-logo"><a href="../index.jsp"><img src="../images/logo2.png" alt="image description"></a></strong>
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
	<script src="../js/vendor/jquery-library.js"></script>
	<script src="../js/vendor/bootstrap.min.js"></script>
	<script src="../js/mapclustering/data.json"></script>
	<!-- 谷歌地图js，在未使用vpn的情况下，加载超时，因此注释此插件 -->
	<!-- <script src="https://maps.google.com/maps/api/js?key=AIzaSyCR-KEWAVCn52mSdeVeTqZjtqbmVJyfSus&language=en"></script> -->
	<script src="../js/mapclustering/markerclusterer.min.js"></script>
	<script src="../js/mapclustering/infobox.js"></script>
	<script src="../js/mapclustering/map.js"></script>
	<script src="../js/owl.carousel.min.js"></script>
	<script src="../js/isotope.pkgd.js"></script>
	<script src="../js/prettyPhoto.js"></script>
	<script src="../js/countdown.js"></script>
	<script src="../js/collapse.js"></script>
	<script src="../js/moment.js"></script>
	<script src="../js/gmap3.js"></script>
	<script src="../js/main.js"></script>
</body>
</html>