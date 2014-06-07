$('#urlData').bind('paste', function() {
	setTimeout(function() {
		urlgrabber.getURLData($('#urlData').val());
	}, 100);
});

var urlgrabber = {
	getURLData : function(reqUrl) {
		urlgrabber.jqueryGetJson('./URLgrabber', {
			url : reqUrl
		}, function(data) {			
			if(data != null){
				$('#imgSrc').attr('src',data.image);
				$('#title').html(data.title);
				$('#description').html(data.description);
				$('#pageUrl').html(data.pageUrl);
				$('#keywords').html(data.keywords);
			}
		});
	},
	jqueryGetAjax : function(url, params, callback) {
		$.ajax({
			url : url,
			data : params,
			type : 'GET',
			dataType:'json',
			success : callback
		});
	},
	jqueryGetJson:function(url,params,callback){
		$.getJSON(url,params,function(data){
			if(callback)
				callback(data);
		});
	}

};