<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="t" uri="http://tiles.apache.org/tag-tiles" %>
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
		<t:insertAttribute name="header"></t:insertAttribute>
		<!--************************************
				Header End
		*************************************-->
		<!--************************************
				Home Slider Start
		*************************************-->
		<div class="clearfix"></div>
		<div class="container">
			<div class="row">
				<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
					<div class="tg-homebannervtwo">
						<div id="tg-homeslider" class="tg-homeslider owl-carousel tg-btnround tg-haslayout">
							<c:forEach items="${newsList}" var="list">
								<div class="item">
									<figure>
										<!-- 网站分辨率：873*424 -->
										<img style="width: 873px;height: 424px" src="images/slider/31.jpg" alt="image description">
										<figcaption class="tg-slidercontent">
											<div class="tg-slidercontentbox">
												<a class="tg-btn" href="/tanklab/detailNews?id=${list.id}">更多</a>
												<div class="tg-titledescription">
													<h1>${list.title} ${list.date}</h1>
													<div class="tg-description">${list.content.substring(0, 200)}</div>
												</div>
											</div>
										</figcaption>
									</figure>
								</div>
							</c:forEach>
						</div>
						<div class="tg-noticeboardarea">
							<div class="tg-widget tg-widgetadmissionform">
								<div class="tg-widgetcontent">
									<h3>2017年工作成果</h3>
									<div class="tg-description">
										<p>2017年计算机互联网高校云计算大赛中，在王晓飞教授的带领下，我院学生勇获特等奖...</p>
									</div>
									<a class="tg-btn tg-btnicon" href="javascript:void(0);">
										<i class="fa fa-file-pdf-o"></i>
										<span>View More</span>
									</a>
								</div>
							</div>
							<div class="tg-widget tg-widgetadmissionform">
								<div class="tg-widgetcontent">
									<h3>2018年工作规划</h3>
									<div class="tg-description">
										<p>随着云计算与大数据时代的深入，对于云计算的理解与认识需要不断提高对系统软硬件架构的理解...</p>
									</div>
									<a class="tg-btn tg-btnicon" href="javascript:void(0);">
										<i class="fa fa-file-pdf-o"></i>
										<span>View More</span>
									</a>
								</div>
							</div>
						</div>
					</div>
					<div class="tg-tickerbox">
						<span>日常公告:</span>
						<div id="tg-ticker" class="tg-ticker owl-carousel">
							<c:forEach items="${noticesList}" var="notices">
								<div class="item">
									<div class="tg-description">
										<p>${notices.title}</p>
									</div>
								</div>
							</c:forEach>
						</div>
					</div>
				</div>
			</div>
		</div>
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
						<div class="col-xs-12 col-sm-8 col-md-9 col-lg-9">
							<div id="tg-content" class="tg-content">
								<section class="tg-sectionspace tg-haslayout">
									<div class="tg-borderheading">
										<h2>近期新闻</h2>
									</div>
									<div class="tg-events">
										<article class="tg-themepost tg-themepostleftimg">
											<figure class="tg-featuredimg">
												<a href="javascript:void(0);">
													<img id="news_img_1" style="width: 270px;height: 185px;" src="${news_index1.imgUrl}" alt="image description">
												</a>
											</figure>
											<div class="tg-themepostcontent">
												<ul class="tg-matadata">
													<li>
														<a href="javascript:void(0);">
															<i class="fa fa-calendar"></i>
															<span id="news_date_1">${news_index1.date}</span>
														</a>
													</li>
												</ul>
												<div class="tg-themeposttitle">
													<h3 id="news_title_1"><a href="javascript:void(0);">${news_index1.title}</a></h3>
												</div>
												<div class="tg-description" id="news_content_1">
													<p>${news_index1.content.substring(0, 300)}</p>
												</div>
											</div>
										</article>
										<div class="clearfix"></div>
										<div class="row">
											<c:forEach items="${news_index2To4}" var="news">
												<div class="col-xs-6 col-sm-6 col-md-6 col-lg-4">
													<article class="tg-themepost tg-themepostleftthumb">
														<figure class="tg-featuredimg">
															<a href="javascript:void(0);">
																<img id="news_img_2"  src="${news.imgUrl}" alt="image description">
															</a>
														</figure>
														<div class="tg-themepostcontent">
															<ul class="tg-matadata">
																<li>
																	<a href="javascript:void(0);">
																		<i class="fa fa-calendar"></i>
																		<span id="news_date_2">${news.date}</span>
																	</a>
																</li>
															</ul>
															<div class="tg-themeposttitle">
																<h3 id="news_title_2"><a href="javascript:void(0);">${news.title}</a></h3>
															</div>
														</div>
													</article>
												</div>
											</c:forEach>
										</div>
									</div>
								</section>
								<section class="tg-sectionspace tg-haslayout">
									<div class="row">
										<div class="col-xs-12 col-sm-12 col-md-7 col-lg-7">
											<div class="tg-glanceatuoeandk">
												<div class="tg-borderheading">
													<h2>实验室风采</h2>
												</div>
												<ul class="tg-gallery">
													<li>
														<figure>
															<a class="tg-btnview" href="images/brands/fc1.png" data-rel="prettyPhoto[glance]"><i class="icon-magnifier"></i></a>
															<img src="images/brands/fc1.png" alt="image description">
														</figure>
													</li>
													<li>
														<figure>
															<a class="tg-btnview" href="images/brands/fc2.jpg" data-rel="prettyPhoto[glance]"><i class="icon-magnifier"></i></a>
															<img src="images/brands/fc2.jpg" alt="image description">
														</figure>
													</li>
													<li>
														<figure>
															<a class="tg-btnview" href="images/brands/fc3.png" data-rel="prettyPhoto[glance]"><i class="icon-magnifier"></i></a>
															<img src="images/brands/fc3.png" alt="image description">
														</figure>
													</li>
													<li>
														<figure>
															<a class="tg-btnview" href="images/brands/fc4.png" data-rel="prettyPhoto[glance]"><i class="icon-magnifier"></i></a>
															<img src="images/brands/fc4.png" alt="image description">
														</figure>
													</li>
													<li>
														<figure>
															<a class="tg-btnview" href="images/brands/fc5.png" data-rel="prettyPhoto[glance]"><i class="icon-magnifier"></i></a>
															<img src="images/brands/fc5.png" alt="image description">
														</figure>
													</li>
													<li>
														<figure>
															<a class="tg-btnview" href="images/brands/fc6.png" data-rel="prettyPhoto[glance]"><i class="icon-magnifier"></i></a>
															<img src="images/brands/fc6.png" alt="image description">
														</figure>
													</li>
													<li>
														<figure>
															<a class="tg-btnview" href="images/brands/fc7.png" data-rel="prettyPhoto[glance]"><i class="icon-magnifier"></i></a>
															<img src="images/brands/fc7.png" alt="image description">
														</figure>
													</li>
													<li>
														<figure>
															<a class="tg-btnview" href="images/brands/fc8.png" data-rel="prettyPhoto[glance]"><i class="icon-magnifier"></i></a>
															<img src="images/brands/fc8.png" alt="image description">
														</figure>
													</li>
												</ul>
											</div>
										</div>
										<div class="col-xs-12 col-sm-12 col-md-5 col-lg-5">
											<div class="tg-widget tg-widgetquicklinks tg-widgetquicklinksvtwo">
												<div class="tg-borderheading">
													<h2>快速链接 </h2>
												</div>
												<div class="tg-widgetcontent">
													<ul id="quickLinkList">
														<li><a href="http://cs.tju.edu.cn/csweb/">天大计算机学院</a></li>
														<li><a href="http://www.tju.edu.cn/">天津大学主页</a></li>
														<li><a href="http://gs.tju.edu.cn">天大研究生院</a></li>
														<li><a href="https://www.twt.edu.cn/">天外天</a></li>
														<li><a href="http://nc.tju.edu.cn/">信网中心</a></li>
														<li><a href="http://e.tju.edu.cn/">天大办公网</a></li>
														<li><a href="http://tieba.baidu.com/f?kw=%CC%EC%BD%F2%B4%F3%D1%A7&fr=ala0&tpl=5">百度贴吧</a></li>
														<li><a href="http://j.map.baidu.com/DE_lO">百度地图</a></li>
													</ul>
												</div>
											</div>
										</div>
									</div>
								</section>
							</div>
						</div>
						<div class="col-xs-12 col-sm-4 col-md-3 col-lg-3">
							<aside id="tg-sidebar" class="tg-sidebar">
								<div class="tg-widget">
									<div class="tg-widgetcontent">
										<form class="tg-formtheme tg-formsearch">
											<fieldset>
												<input type="search" name="search" class="form-control" placeholder="关键词...">
												<button type="submit" class="tg-btnsearch"><i class="icon-magnifier"></i></button>
											</fieldset>
										</form>
									</div>
								</div>
								<div class="tg-widget tg-widgetnoticeboard">
									<div class="tg-widgettitle">
										<h3>公告板</h3>
									</div>
									<div class="tg-widgetcontent">
										<ul>
											<c:forEach items="${announcementList}" var="announcement">
												<li>
													<a href="/announcementList?id=${announcement.id}">${announcement.title}</a>
												</li>
											</c:forEach>
										</ul>
									</div>
								</div>
								<div class="tg-widget tg-widgetadmissionform">
									<div class="tg-widgetcontent">
										<h3>2017工作安排</h3>
										<div class="tg-description">
											<p>培养适应社会主义现代化建设需要的，德智体美等全面发展的，掌握计算机硬件，软件及其应用的基本理论知识...</p>
										</div>
										<a class="tg-btn tg-btnicon" href="javascript:void(0);">
											<i class="fa fa-file-pdf-o"></i>
											<span>View More</span>
										</a>
									</div>
								</div>
								<div class="tg-widget tg-widgetdownload">
									<div class="tg-widgettitle">
										<h3>下载专区</h3>
									</div>
									<div class="tg-widgetcontent">
										<ul>
											<li>
												<a href="javascript:void(0);">
													<i class="fa fa-paperclip"></i>
													<span><a href="/tanklab/fileList">下载文件</a></span>
												</a>
											</li>
											<li>
												<a href="javascript:void(0);">
													<i class="fa fa-map-signs"></i>
													<span>申请指南</span>
												</a>
											</li>
											<li>
												<a href="javascript:void(0);">
													<i class="fa fa-list-ul"></i>
													<span>2017 优秀生名单</span>
												</a>
											</li>
											<li>
												<a href="javascript:void(0);">
													<i class="fa fa-calendar-check-o "></i>
													<span>考核日期表</span>
												</a>
											</li>
											<li>
												<a href="javascript:void(0);">
													<i class="fa fa-bookmark-o"></i>
													<span>2017 考核指引</span>
												</a>
											</li>
										</ul>
									</div>
								</div>
							</aside>
						</div>
						<!--<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">-->
							<!--<section class="tg-sectionspace tg-haslayout">-->
								<!--<div class="tg-affiliationscertifications">-->
									<!--<div class="tg-borderheading">-->
										<!--<h2>合作伙伴</h2>-->
									<!--</div>-->
									<!--<div id="tg-affiliationscertificationsslider" class="tg-affiliationscertificationsslider owl-carousel">-->
										<!--<div class="item">-->
											<!--<figure>-->
												<!--<a href="javascript:void(0);">-->
													<!--<img src="images/brands/img-01.png" alt="image description">-->
												<!--</a>-->
											<!--</figure>-->
										<!--</div>-->
										<!--<div class="item">-->
											<!--<figure>-->
												<!--<a href="javascript:void(0);">-->
													<!--<img src="images/brands/img-02.png" alt="image description">-->
												<!--</a>-->
											<!--</figure>-->
										<!--</div>-->
										<!--<div class="item">-->
											<!--<figure>-->
												<!--<a href="javascript:void(0);">-->
													<!--<img src="images/brands/img-03.png" alt="image description">-->
												<!--</a>-->
											<!--</figure>-->
										<!--</div>-->
										<!--<div class="item">-->
											<!--<figure>-->
												<!--<a href="javascript:void(0);">-->
													<!--<img src="images/brands/img-04.png" alt="image description">-->
												<!--</a>-->
											<!--</figure>-->
										<!--</div>-->
										<!--<div class="item">-->
											<!--<figure>-->
												<!--<a href="javascript:void(0);">-->
													<!--<img src="images/brands/img-05.png" alt="image description">-->
												<!--</a>-->
											<!--</figure>-->
										<!--</div>-->
										<!--<div class="item">-->
											<!--<figure>-->
												<!--<a href="javascript:void(0);">-->
													<!--<img src="images/brands/img-06.png" alt="image description">-->
												<!--</a>-->
											<!--</figure>-->
										<!--</div>-->
									<!--</div>-->
								<!--</div>-->
							<!--</section>-->
						<!--</div>-->
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
							<span><a style="color:grey;" href="http://www.miitbeian.gov.cn">津ICP备17006007号-1</a></span>
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
	<script src="js/index.js"></script>
</body>
</html>