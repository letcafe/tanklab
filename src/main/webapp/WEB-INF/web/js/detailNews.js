$(function() {
	host_image = 'tanktju.com';
	url_param = window.location.search;
	$.ajax({
		url:'/tanktju/detailNews' + url_param,
		type:'GET',
		success:function(json){
			jsonObject = JSON.parse(json);
			$('#news_detail_img').attr('src', 'http://' + host_image + ':8080/tanktju/images/news/' + jsonObject.img_uri);
			$('#news_detail_title').text(jsonObject.title);
			$('#news_detail_content').html(jsonObject.content);
		}
	})
});