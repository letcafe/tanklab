$(function(){
    hostip='172.18.16.134'; //server true ip:123.207.162.21

    //隐藏表单空白显示的提示文字
	$('.dataTables_empty').hide();
	//设置日期选择器的基本属性
    $('#add_uploadTime').datepicker({
        autoclose: true,
    });
    $('#change_uploadTime').datepicker({
        autoclose: true,
    });

    //调用绑定按钮方法


    //对页面的列表进行重新加载
	var refreshAllList = function() {
		$.ajax({
			url:'/tanklab/api/v1/file',
			method:'GET',
			success:function(restMessage) {
				if(restMessage.code == 200) {
					//清空tbody里的所有行
                    $('#file_form_body').html('');
					for(var i = 0; i < restMessage.data.length; i++) {
						var fileObj = restMessage.data[i];
						//append遍历添加每一行
						$('#file_form_body').append("<tr>\n" +
                            "                  <td class=\"col-xs-1\" id=\"index_" + (i+1) + "\">" + (i+1) + "</td>\n" +
                            "                  <td class=\"col-xs-1\" id=\"file_id_" + fileObj.id + "\">" + fileObj.id + "</td>\n" +
                            "                  <td class=\"col-xs-2\" id=\"file_fileName_" + fileObj.id + "\">" + fileObj.fileName + "</td>\n" +
                            "                  <td class=\"col-xs-2\" id=\"file_uploadTime_" + fileObj.id +"\">" + timeStamp2String(fileObj.uploadTime) + "</td>\n" +
                            "                  <td class=\"col-xs-2\" id=\"file_path_" + fileObj.id + "\"><a href=\"" + fileObj.path + "\" download=\""+fileObj.fileName+suffixes.get(fileObj.path)+"\">" + fileObj.path+" </a></td>\n" +
                            "                  <td class=\"col-xs-1\">\n" +
                            "                    <button class=\"btn btn-info\" id=\"chg_file_" + fileObj.id + "\" data-id=\"" + fileObj.id + "\" btnType=\"chgButton\">修改</button>\n" +
                            "                    <button class=\"btn btn-danger\" id=\"del_file_" + fileObj.id + "\" data-id=\"" + fileObj.id + "\" btnType=\"delButton\">删除</button>\n" +
                            "                  </td>\n" +
                            "                  </tr>");
					}
                    bindingEveryDeleteButton();//对新生成的按钮连接进行绑定
                    bindingEveryUpdateButton();
				}
			}
		});
	}


    //单击提交添加新闻按钮出发异步上传文件
    $('#add_submit').on('click', function() {
        // add_content_string = CKEDITOR.instances.add_content.getData();
        // $('#add_content').val(add_content_string);
        $('#add_file_form').ajaxSubmit({
            success: function(restMessage) {
                if(restMessage.code == 200){
                    alert('插入成功');
                    $('#add_file_modal').modal('hide');
                    $('#add_fileName,#add_uploadTime,#add_file').val("");
                    refreshAllList();
                }else if(restMessage.code == 213) {
                    alert('文件大小超出限制，插入失败');
                } else {
                    alert('插入失败');
                }
            }
        });
    });

	//根据按钮的btnType属性遍历每个删除按钮
	var bindingEveryDeleteButton = function() {
        $('button[btnType="delButton"]').each(function() {
            param_del_id = $(this).data('id');
            //获取遍历中的当前按钮，绑定单击事件，传递其data-id属性对应的参数
            $(this).on('click', {id:param_del_id}, function(event) {
                //弹出确认对话框，防止用户失(shou)误(can)
                confirm_message = confirm('确认要删除吗？');
                if(confirm_message == true) {
                    $.ajax({
                        url: "/tanklab/api/v1/file?id=" + event.data.id,//请求异步的API路径加上变量
                        type: "DELETE",//请求类型，删除的话是DELETE
                        success: function(data) {
                            //根据返回的JSON中的code字段是否为200判断是否删除成功，并给用户提示
                            if(data.code == 200) {
                                $("#del_file_" + event.data.id).parent().parent().hide(1500);
                                alert('删除成功');
                            }else {
                                alert('操作失拜，请稍后再试');
                            }
                        }
                    });
                } else {
                    alert('删除操作已撤销');
                }
            });
        });
	}


    //根据按钮的btnType属性遍历每个修改按钮
    var bindingEveryUpdateButton = function() {
        $('button[btnType="chgButton"]').each(function() {
            var chg_id = $(this).data('id');
            //获取遍历中的当前按钮，绑定修改单击事件，传递其data-id属性对应的参数，并获取每个id选择器对应的值传递参数
            $(this).on('click', {
                id:$("#file_id_" + chg_id).text(),
                fileName:$("#file_fileName_" + chg_id).text(),
                uploadTime:$("#file_uploadTime_" + chg_id).text(),
                path:$("#file_path_" + chg_id).attr("href"),//获取图片标签的src源并准备赋值给模态框中的图片预览
            }, function(event) {
                var chg_data = event.data;//获取传参数的对象

                $('#change_file_modal').modal();//调用弹出模态框
                $('#change_id').val(chg_data.id);
                $('#change_fileName').val(chg_data.fileName);
                //CKEDITOR.instances.change_content.setData(chg_data.content);
                $('#change_uploadTime').val(chg_data.uploadTime);
                $('#file_change_source').attr('href',chg_data.path);
            });
        });
	}

    //绑定修改页面的提交按钮单击事件，修改新闻并提交数据库
    $('#change_submit').on('click', function() {
        //change_content_string = CKEDITOR.instances.change_content.getData();
        //$('#change_content').val(change_content_string);
        $('#change_file_form').ajaxSubmit({
            success: function(restMessage) {
            	if(restMessage.code == 200) {
                    alert('修改成功');
                    $('#change_file_modal').modal('hide');
                    refreshAllList();
				} else {
            		alert('修改失败，请稍后再试');
				}
            }
        });
    });

	//调用绑定的方法
    bindingEveryDeleteButton();
    bindingEveryUpdateButton();

    //定义时间戳到日期格式的转换
    function timeStamp2String (time){
        var datetime = new Date();
        datetime.setTime(time);
        var year = datetime.getFullYear();
        var month = datetime.getMonth() + 1;
        var date = datetime.getDate();
        var hour = datetime.getHours();
        var minute = datetime.getMinutes();
        var second = datetime.getSeconds();
        var mseconds = datetime.getMilliseconds();
        return year + "-" + month + "-" + date;
    };
});