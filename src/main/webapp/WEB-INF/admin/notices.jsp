<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrmoe=1">
  <title>AdminLTE 2 | Data Tables</title>
  <!-- Tell the browser to be responsive to screen width -->
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  <!-- Bootstrap 3.3.7 -->
  <link rel="stylesheet" href="./bower_components/bootstrap/dist/css/bootstrap.min.css">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="./bower_components/font-awesome/css/font-awesome.min.css">
  <!-- Date Picker -->
  <link rel="stylesheet" href="./bower_components/bootstrap-datepicker/dist/css/bootstrap-datepicker.min.css">
  <!-- Ionicons -->
  <link rel="stylesheet" href="./bower_components/Ionicons/css/ionicons.min.css">
  <!-- DataTables -->
  <link rel="stylesheet" href="./bower_components/datatables.net-bs/css/dataTables.bootstrap.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="./dist/css/AdminLTE.min.css">
  <!-- AdminLTE Skins. Choose a skin from the css/skins
       folder instead of downloading all of them to reduce the load. -->
  <link rel="stylesheet" href="./dist/css/skins/_all-skins.min.css">

  <style>
    tbody tr td img {
      width: 180px;
    }
  </style>

  <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
  <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
  <!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->

  <!-- Google Font -->
  <link rel="stylesheet"
        href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">
</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">

  <header class="main-header">
    <!-- Logo -->
    <a href="javascript:void(0)" class="logo">
      <!-- mini logo for sidebar mini 50x50 pixels -->
      <span class="logo-mini"><b>T</b>LAB</span>
      <!-- logo for regular state and mobile devices -->
      <span class="logo-lg"><b>Tank</b>LAB</span>
    </a>
    <!-- Header Navbar: style can be found in header.less -->
    <nav class="navbar navbar-static-top">
      <!-- Sidebar toggle button-->
      <a href="#" class="sidebar-toggle" data-toggle="push-menu" role="button">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </a>

      <div class="navbar-custom-menu">
        <ul class="nav navbar-nav">
          <li class="dropdown user user-menu">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
              <img src="./dist/img/user2-160x160.jpg" class="user-image" alt="User Image">
              <span class="hidden-xs">TANK Administrator</span>
            </a>
            <ul class="dropdown-menu">
              <!-- User image -->
              <li class="user-header">
                <img src="./dist/img/user2-160x160.jpg" class="img-circle" alt="User Image">

                <p>
                  DongyuGuo
                  <small>Member since Jan. 2018</small>
                </p>
              </li>
              <!-- Menu Footer-->
              <li class="user-footer">
                <div class="pull-left">
                  <a href="#" class="btn btn-default btn-flat">Profile</a>
                </div>
                <div class="pull-right">
                  <a href="#" class="btn btn-default btn-flat">Sign out</a>
                </div>
              </li>
            </ul>
          </li>
          <!-- Control Sidebar Toggle Button -->
          <li>
            <a href="#" data-toggle="control-sidebar"><i class="fa fa-gears"></i></a>
          </li>
        </ul>
      </div>
    </nav>
  </header>
  <!-- Left side column. contains the logo and sidebar -->
  <aside class="main-sidebar">
    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">
      <!-- Sidebar user panel -->
      <div class="user-panel">
        <div class="pull-left image">
          <img src="./dist/img/user2-160x160.jpg" class="img-circle" alt="User Image">
        </div>
        <div class="pull-left info">
          <p>Administrator</p>
          <a href="#"><i class="fa fa-circle text-success"></i> Online</a>
        </div>
      </div>
      <!-- search form -->
      <form action="#" method="get" class="sidebar-form">
        <div class="input-group">
          <input type="text" name="q" class="form-control" placeholder="Search...">
          <span class="input-group-btn">
                <button type="submit" name="search" id="search-btn" class="btn btn-flat"><i class="fa fa-search"></i>
                </button>
              </span>
        </div>
      </form>
      <!-- /.search form -->
      <!-- sidebar menu: : style can be found in sidebar.less -->
      <ul class="sidebar-menu" data-widget="tree">
        <li class="header">管理</li>
        <li><a href="./news.jsp"><i class="fa fa-circle-o text-red"></i> <span>近期新闻管理</span></a></li>
        <li class="active menu-open"><a href="./notices"><i class="fa fa-circle-o text-yellow"></i> <span>近期提醒管理</span></a></li>
        <li><a href="./announcement"><i class="fa fa-circle-o text-aqua"></i> <span>长期公告管理</span></a></li>
        <li><a href="./file"><i class="fa fa-circle-o text-aqua"></i> <span>文件下载上传管理</span></a></li>
      </ul>
    </section>
    <!-- /.sidebar -->
  </aside>

  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>
                  近期新闻管理控制台
        <small>Admin Console</small>
      </h1>
      <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
        <li><a href="#">Tables</a></li>
        <li class="active">Data tables</li>
      </ol>
    </section>

    <!-- Main content -->
    <section class="content">
      <div class="row">
        <div class="col-xs-12">
          <div class="box">
            <div class="box-header">
              <h3 class="box-title">近期新闻</h3>
            </div>
            <!-- /.box-header -->
            <div class="box-body">
              <div>
              	<button id="add_news" class="btn btn-sm btn-success" data-toggle="modal" data-target="#add_news_modal">添加新闻</button>
              </div>
              <table id="example2" class="table table-bordered table-hover">
                <thead>
                <tr>
                  <th>No</th>
                  <th>新闻ID</th>
                  <th>日期</th>
                  <th>标题</th>
                  <th>内容</th>
                  <th>图片</th>
                  <th>操作</th>
                </tr>
                </thead>
                <tbody id="news_form_body">
                <c:forEach items="${newsList}" var="list" varStatus="idx">
                  <tr>
                  <td class="col-xs-1" id="index_${idx.index+1}"><c:out value="${idx.index+1}"></c:out></td>
                  <td class="col-xs-1" id="news_id_${list.id}"><c:out value="${list.id}"></c:out></td>
                  <td class="col-xs-2" id="news_date_${list.id}"><c:out value="${list.date}"></c:out></td>
                  <td class="col-xs-2" id="news_title_${list.id}"><c:out value="${list.title}"></c:out></td>
                  <td class="col-xs-3" id="news_content_${list.id}">${list.content}</td>
                  <td class="col-xs-2" id="news_imgUrl_${list.id}"><img src="${list.imgUrl}"/></td>
                  <td class="col-xs-1">
                    <button class="btn btn-info" id="chg_news_${list.id}" data-id="${list.id}" btnType="chgButton">修改</button>
                    <button class="btn btn-danger" id="del_news_${list.id}" data-id="${list.id}" btnType="delButton">删除</button>
                  </td>
                  </tr>
                </c:forEach>
                </tbody>            
                </tfoot>
              </table>
            </div>
            <!-- /.box-body -->
          </div>
          <!-- /.box -->

      <!-- /.row -->
    </section>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->
  <footer class="main-footer">
    <div class="pull-right hidden-xs">
      <b>Version</b> 1.0.0
    </div>
    <strong>Copyright &copy; 2014-2016 <a href="http://www.miitbeian.gov.cn">津ICP备17006007号-1</a>.</strong> All rights
    reserved.
  </footer>


  <!-- /.control-sidebar -->
  <!-- Add the sidebar's background. This div must be placed
       immediately after the control sidebar -->
  <div class="control-sidebar-bg"></div>
  <div id="add_news_modal" class="row modal fade" role="dialog" aria-labelledby="add_news_modal" aria_hidden="true">
  	<div class="box box-primary col-lg-6 col-xs-offset-3" style="width:50%;margin-top:5%;">
            <div class="box-header with-border">
              <h3 class="box-title">添加新闻</h3>
            </div>
            <!-- /.box-header -->
            <!-- form start -->
            <form id="add_news_form" role="form" action="/tanklab/api/v1/news/" method="post" enctype="multipart/form-data">
              <div class="box-body">
                <div class="form-group">
                  <label for="add_title">新闻标题</label>
                  <input name="title" type="text" class="form-control" id="add_title" placeholder="请输入新闻标题">
                </div>
                <div class="form-group">
                  <label for="add_content">正文内容</label>
                  <textarea name="content" class="form-control" rows="10" id="add_content" placeholder="请输入新闻主要内容"></textarea>
                </div>
                <div class="form-group" style="padding:0px;">
                  <label for="add_date">日期</label>
                  <div class="form-group">
	                <div class="input-group date">
	                  <div class="input-group-addon">
	                    <i class="fa fa-calendar"></i>
	                  </div>
	                  <input type="text" name="date" class="form-control pull-right" id="add_date" data-date-format="yyyy-mm-dd">
	                </div>
                <!-- /.input group -->
              </div>
                </div>
                <div class="form-group">
                  <label for="add_images">上传图片</label>
                  <input name="imgUrl" type="file" id="add_images"/><br>
                  <p class="help-block">图片格式不限，请上传5M以下的图片</p>
                </div>
              </div>
              <!-- /.box-body -->
              <div class="box-footer">
                <button id="add_submit" type="button" class="btn btn-primary">添加</button>
              </div>
            </form>
          </div>
  </div>
  
  <!-- 修改modal框 -->
  <div id="change_news_modal" class="row modal fade" role="dialog" aria-labelledby="change_news_modal" aria_hidden="true">
  	<div class="box box-primary col-lg-6 col-xs-offset-3" style="width:50%;margin-top:5%;">
            <div class="box-header with-border">
              <h3 class="box-title">修改新闻</h3>
            </div>
            <!-- /.box-header -->
            <!-- form start -->
            <form id="change_news_form" role="form" action="/tanklab/api/v1/news/change" method="post" enctype="multipart/form-data">
              <input name="id" type="hidden" id="change_id">
              <div class="box-body">
                <div class="form-group">
                  <label for="change_title">新闻标题</label>
                  <input name="title" type="text" class="form-control" id="change_title" placeholder="请输入新闻标题">
                </div>
                <div class="form-group">
                  <label for="change_content">正文内容</label>
                  <textarea name="content" class="form-control" rows="10" id="change_content" placeholder="请输入新闻主要内容"></textarea>
                </div>
                <div class="form-group" style="padding:0px;">
                  <label for="change_date">日期</label>
                  <div class="form-group">
	                <div class="input-group date">
	                  <div class="input-group-addon">
	                    <i class="fa fa-calendar"></i>
	                  </div>
	                  <input type="text" name="date" class="form-control pull-right" id="change_date" data-date-format="yyyy-mm-dd">
	                </div>
                <!-- /.input group -->
              </div>
                </div>
                <div class="form-group">
                  <label for="change_images">初始图片</label>
                  <img id="img_change_source" style="width:200px;height:150px;" src=""/>
                  <input name="imgUrl" type="file" id="change_images"/><br>
                  <p class="help-block">图片格式不限，请上传5M以下的图片（修改后的图片将不会直接显示在修改页面，请在控制台上直接查看）</p>
                </div>
              </div>
              <!-- /.box-body -->
              <div class="box-footer">
                <button id="change_submit" type="button" class="btn btn-primary">提交修改</button>
              </div>
            </form>
          </div>
  </div>
</div>
<!-- ./wrapper -->

<!-- jQuery 3 -->
<script src="./bower_components/jquery/dist/jquery.min.js"></script>
<!-- Bootstrap 3.3.7 -->
<script src="./bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
<!-- DataTables -->
<script src="./bower_components/datatables.net/js/jquery.dataTables.min.js"></script>
<script src="./bower_components/datatables.net-bs/js/dataTables.bootstrap.min.js"></script>
<!-- Date Picker -->
<script src="./bower_components/bootstrap-datepicker/dist/js/bootstrap-datepicker.min.js"></script>
<!-- SlimScroll -->
<script src="./bower_components/jquery-slimscroll/jquery.slimscroll.min.js"></script>
<!-- FastClick -->
<script src="./bower_components/fastclick/lib/fastclick.js"></script>
<!-- jQuery.Form.js -->
<script src="./bower_components/jquery.form.js/jquery.form.js"></script>
<!-- AdminLTE App -->
<script src="./dist/js/adminlte.min.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="./dist/js/demo.js"></script>
<!-- CK Editor -->
<script src="./bower_components/ckeditor/ckeditor.js"></script>
<!-- Bootstrap WYSIHTML5 -->
<script src="./plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js"></script>

<script src="./js_control/notices.js"></script>
<script>
  $(function () {
    // Replace the <textarea id="editor1"> with a CKEditor
    // instance, using default configuration.
    CKEDITOR.replace('add_content');
    CKEDITOR.replace('change_content');
  })
</script>
</body>
</html>
