var iUp = (function () {
	var t = 0,
		d = 150,
		clean = function () {
			t = 0;
		},
		up = function (e) {
			setTimeout(function () {
				$(e).addClass("up")
			}, t);
			t += d;
		},
		down = function (e) {
			$(e).removeClass("up");
		},
		toggle = function (e) {
			setTimeout(function () {
				$(e).toggleClass("up")
			}, t);
			t += d;
		};
	return {
		clean: clean,
		up: up,
		down: down,
		toggle: toggle
	}
})();


$(document).ready(function () {
	// 弹上来的动效
	$(".iUp").each(function (i, e) {
		iUp.up(e);
	});

	function bingCallback(imageUrl) {
		$('#panel').css('background', 'url("' + imageUrl + '") center center no-repeat #666');
		$('#panel').css('background-size', 'cover');
	}

	// bing 壁纸
	$.get('https://bird.ioliu.cn/v1/?url=https://www.bing.com/HPImageArchive.aspx?format=js&idx=0&n=8', function(res) {
		var imageUrl = 'https://www.bing.com' + res.images[0].url;

		var img = new Image();
		img.src = imageUrl;
		if (img.complete) {
			bingCallback(imageUrl);
		} 
		else {
			img.onload = function () {
				bingCallback(imageUrl);
				img.onload = null;
			};
		};
	});

	$.ajax({
		type: "POST",
		url: 'https://120.78.167.47:8080/footprint/record',
		data: JSON.stringify({ 
			'url': window.location.href 
		}),
		dataType: 'json',
		contentType: 'application/json;'
	});

});

