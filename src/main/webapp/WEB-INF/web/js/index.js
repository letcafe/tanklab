$(function() {
	host_image = 'tanktju';//tanktju.com
	host_url = '/tanktju/indexNews';
	$.ajax({
		url:host_url,
		type:'GET',
		success: function(json) {
			jsonArray = JSON.parse(json);
			for(i = 1; i <= jsonArray.length; i++) {
				jsonObject = JSON.parse(jsonArray[i - 1]);
				titleString = jsonObject.title.substring(0, 80);
				if(jsonObject.title.length > 35){
					titleString = titleString + '...';
				};
				$('#news_title_' + i + ' a').text(titleString);
				$('#news_date_' + i).text(jsonObject.date);
				$('#news_content_' + i).html(jsonObject.content.substring(0,180) + '...');
				$('#news_img_' + i).attr('src','/tanktju/images/news/' + jsonObject.img_uri);
				$('#news_title_' + i + ' a').attr('href', '/tanktju/detailInformation.html?news_id=' + jsonObject.id);
			}
		}
	})
});