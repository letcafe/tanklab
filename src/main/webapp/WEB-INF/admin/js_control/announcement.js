$(function(){
    hostip='172.18.16.134'; //server true ip:123.207.162.21

    //隐藏表单空白显示的提示文字
	$('.dataTables_empty').hide();
	//设置日期选择器的基本属性
    $('#add_date').datepicker({
        autoclose: true,
    });
    $('#change_date').datepicker({
        autoclose: true,
    });

    //调用绑定按钮方法


    //对页面的列表进行重新加载
	var refreshAllList = function() {
		$.ajax({
			url:'/tanklab/api/v1/announcement?page=1',
			method:'GET',
			success:function(restMessage) {
				if(restMessage.code == 200) {
					//清空tbody里的所有行
                    $('#announcement_form_body').html('');
					for(var i = 0; i < restMessage.data.length; i++) {
						var newsObj = restMessage.data[i];
						//append遍历添加每一行
						$('#announcement_form_body').append("<tr>\n" +
                            "                  <td class=\"col-xs-1\" id=\"index_" + (i+1) + "\">" + (i+1) + "</td>\n" +
                            "                  <td class=\"col-xs-1\" id=\"announcement_id_" + newsObj.id + "\">" + newsObj.id + "</td>\n" +
                            "                  <td class=\"col-xs-2\" id=\"announcement_date_" + newsObj.id +"\">" + timeStamp2String(newsObj.date) + "</td>\n" +
                            "                  <td class=\"col-xs-2\" id=\"announcement_title_" + newsObj.id + "\">" + newsObj.title + "</td>\n" +
                            "                  <td class=\"col-xs-3\" id=\"announcement_content_" + newsObj.id + "\">" + newsObj.content + "</td>\n" +
                            "                  <td class=\"col-xs-1\">\n" +
                            "                    <button class=\"btn btn-info\" id=\"chg_announcement_" + newsObj.id + "\" data-id=\"" + newsObj.id + "\" btnType=\"chgButton\">修改</button>\n" +
                            "                    <button class=\"btn btn-danger\" id=\"del_announcement_" + newsObj.id + "\" data-id=\"" + newsObj.id + "\" btnType=\"delButton\">删除</button>\n" +
                            "                  </td>\n" +
                            "                  </tr>");
					}
                    bindingEveryDeleteButton();//对新生成的按钮连接进行绑定
                    bindingEveryUpdateButton();
				}
			}
		});
	}


    //单击提交添加公告按钮出发异步上传文件
    $('#add_submit').on('click', function() {
        alert(1);
        add_content_string = CKEDITOR.instances.add_content.getData();
        $('#add_content').val(add_content_string);
        $('#add_announcement_form').ajaxSubmit({
            success: function(restMessage) {
                if(restMessage.code == 200){
                    alert('插入成功');
                    $('#add_announcement_modal').modal('hide');
                    $('#add_title,#add_date').val("");
                    CKEDITOR.instances.add_content.setData("");
                    refreshAllList();
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
                //弹出确认对话框，防止用户失误
                confirm_message = confirm('确认要删除吗？');
                if(confirm_message == true) {
                    $.ajax({
                        url: "/tanklab/api/v1/announcement?id=" + event.data.id,//请求异步的API路径加上变量
                        type: "DELETE",//请求类型，删除的话是DELETE
                        success: function(data) {
                            //根据返回的JSON中的code字段是否为200判断是否删除成功，并给用户提示
                            if(data.code == 200) {
                                $("#del_announcement_" + event.data.id).parent().parent().hide(1500);
                                alert('删除成功');
                            }else {
                                alert('操作失败，请稍后再试');
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
                id:$("#announcement_id_" + chg_id).text(),
                title:$("#announcement_title_" + chg_id).text(),
                content:$("#announcement_content_" + chg_id).html(),//由于首页使用substring()，因此为了读到全文，在该表格的一个属性中封装字段，使其能读出，修改全文
                date:$("#announcement_date_" + chg_id).text()
            }, function(event) {
                var chg_data = event.data;//获取传参数的对象
                $('#change_announcement_modal').modal();//调用弹出模态框
                $('#change_id').val(chg_data.id);
                $('#change_title').val(chg_data.title);
                CKEDITOR.instances.change_content.setData(chg_data.content);
                $('#change_date').val(chg_data.date);
            });
        });
	}

    //绑定修改页面的提交按钮单击事件，修改公告并提交数据库
    $('#change_submit').on('click', function() {
        change_content_string = CKEDITOR.instances.change_content.getData();
        $('#change_content').val(change_content_string);
        $('#change_announcement_form').ajaxSubmit({
            success: function(restMessage) {
            	if(restMessage.code == 200) {
                    alert('修改成功')
                    $('#change_announcement_modal').modal('hide');
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