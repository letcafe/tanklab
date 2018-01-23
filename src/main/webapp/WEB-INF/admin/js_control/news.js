$(function(){
	//隐藏表单空白显示的提示文字
	$('.dataTables_empty').hide();
	//设置日期选择器的基本属性
    $('#add_date').datepicker({
        autoclose: true,
    });
    $('#change_date').datepicker({
        autoclose: true,
    });
    //模拟点击事件，将左侧的列表导航
    $(".sidebar-toggle").click();
    //设置“添加新闻”的“添加”按钮的点击提交事件
    $('#add_submit').on('click', function() {
    	add_content_string = CKEDITOR.instances.add_content.getData();
    	$('#add_content').val(add_content_string);
    	$('#add_news_form').ajaxSubmit({
    		success: function(data) {
    			if(data == "fail"){
    				alert('插入失败');
    			}else {
    				alert('插入成功');
    				$('#add_news_modal').modal('hide');
    				change_del_binding(JSON.parse(data));
    				$('#add_title,#add_date,#add_images').val('');
    				CKEDITOR.instances.add_content.setData('');
    			}
    		}
    	});
    });
    
	hostip='tanktju.com'; //server true ip:123.207.162.21
	
	//读取新闻列表AJAX
	$.ajax({
		url:'/tanktju/News',
		type:"GET",
		contentType: "charset=utf-8",
		success:function(jsonResult) {
			var jsonArray = eval(jsonResult);
			for(i = 0; i < jsonArray.length; i++) {
				change_del_binding(JSON.parse(jsonArray[i]));
			}
		}
	});
	
	//修改新闻并提交数据库
	$('#change_submit').on('click', function() {
		change_content_string = CKEDITOR.instances.change_content.getData();
    	$('#change_content').val(change_content_string);
		$('#change_news_form').ajaxSubmit({
			type: "PUT",
			success: function(data) {
				alert('修改成功')
				$('#change_news_modal').modal('hide');
				json = JSON.parse(data);
				$('#news_title_' + json.id).text(json.title);
				$('#news_date_' + json.id).text(json.date);
				$('#news_content_' + json.id).html(json.content);
				$('#news_img_uri_' + json.id).attr('src', '/tanktju/images/news/' +  json.img_uri);
			}
		});
	});
	
	//定义了复用函数，用于绑定删除和修改的点击事件
	var change_del_binding = function(json) {
		$('#tableNews').append('<tr><td>' 
				+ eval(i+1) + '</td><td style="width:80px;">' 
				+ json.id 
				+ '</td><td style="width:110px;" id="news_date_' + json.id + '">' 
				+ json.date + '</td><td><div id="news_title_' + json.id + '" style="height:100%;">' 
				+ json.title + '</div></td><td><div id="news_content_' + json.id + '" style="height:100%;">' 
				+ json.content + '</div><td><img id="news_img_uri_' + json.id + '" src="/tanktju/images/news/' 
				+ json.img_uri + '" style="height:150px;width:250px;"/><td style="vertical-align:middle;width:150px;"><a id="del_news_' 
				+ json.id +'" class="btn btn-sm btn-danger" style="margin-right:10px;">删除</a><a id="chg_news_' 
				+ json.id + '" class="btn btn-sm btn-info">修改</a></td></td></tr>');
    	$('#del_news_' + json.id).on('click', { del_id:json.id,imageFullName:json.img_uri }, function(event) {
			json_id = event.data.del_id;
			json_image = event.data.imageFullName;
			var confirm_message = confirm('确认要删除吗？');
			if(confirm_message == true) {
				$.ajax({
					url:'/tanktju/News?del_id=' + json_id + '&imageFullName=' + json_image,
					type:"DELETE",
					success:function(jsonResult) {
						if(jsonResult=='success') {
							$('#del_news_' + json_id).parent().parent().hide(1500);
							alert('删除成功');
						}else { 
							alert('操作失拜，请稍后再试');
						}
					}
				});
			}else {
				alert('删除操作已撤销');
			}
		});
		$('#chg_news_' + json.id).on('click', { chg_id:json.id, chg_title:json.title, chg_content:json.content,chg_date:json.date, chg_img_uri:json.img_uri }, function(event) {
			chg_data = event.data;
			$('#change_news_modal').modal();
			$('#change_id').val(chg_data.chg_id);
			$('#change_title').val($('#news_title_' + chg_data.chg_id).text());
		    CKEDITOR.instances.change_content.setData($('#news_content_' + chg_data.chg_id).text());
			$('#change_date').val($('#news_date_' + chg_data.chg_id).text());
			$('#img_change_source').attr('src',$('#news_img_uri_' + chg_data.chg_id).attr('src'));
		});
    }
});