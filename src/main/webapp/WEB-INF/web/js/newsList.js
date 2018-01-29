$(function() {
	host_url = '/tanktju/indexNews';
	$.ajax({
		url:host_url,
		type:'GET',
		data:{
			news_num:20
		},
		success: function(json) {
			jsonArray = JSON.parse(json);
			for(i = 1; i <= jsonArray.length; i++) {
				jsonObject = JSON.parse(jsonArray[i - 1]);
				setNewsList(jsonObject.id, jsonObject.title, jsonObject.content, jsonObject.date, jsonObject.img_uri);
			}
		}
	});
	
	var setNewsList = function(id, title, content, date, image) {
		$('#newsList').append('<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">\
				<article class="tg-themepost tg-newspost">\
					<figure class="tg-featuredimg left_picture">\
						<a href="javascript:void(0);">\
							<img src="/tanktju/images/news/' + image + '" alt="image description">\
						</a>\
					</figure>\
					<div class="tg-themepostcontent">\
						<ul class="tg-matadata">\
							<li>\
								<a href="javascript:void(0);">\
									<i class="fa fa-calendar"></i>\
									<span>' + date + '</span>\
								</a>\
							</li>\
						</ul>\
						<div class="tg-themeposttitle">\
							<h3><a href="javascript:void(0);">' + title + '</a></h3>\
						</div>\
						<div style="text-align:left;" class="tg-description">\
							<p>' + content + '</p>\
						</div>\
						<a class="tg-btn tg-btn-sm" href="/tanktju/detailInformation.html?news_id=' + id + '">Read more</a>\
					</div>\
				</article>\
			</div>');
	}
})