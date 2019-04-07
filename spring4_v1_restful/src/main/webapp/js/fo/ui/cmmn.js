/**
 * jquery-serialize-object
 */
$.fn.serializeObject = function() {
    "use strict";
    var a = {},
        b = function(b, c) {
            var d = a[c.name];
            "undefined" != typeof d && d !== null ? $.isArray(d) ? d.push(c.value) : a[c.name] = [d, c.value] : a[c.name] = c.value
        };
    return $.each(this.serializeArray(), b), a
};

/**
 * 수정자: linked2ev
 * 수정일: 2019. 2. 21.
 * 설명: 공통 Ajax
 * @param obj
 * @returns
 */
function cmAxios(obj){
	console.log('> params: ', obj.params);
	if(typeof obj.params == 'undefined'){
		obj.params = {};
	}
	
	$.ajax({
		method  : obj.method == '' ? 'GET' : obj.method,
		url     : obj.url,
//		headers: {
//			"X-Auth-Token":"linked2ev"
//		},
		data    : "json="+encodeURI(JSON.stringify(obj.params)), //object to json params
//		data    : obj.params, // object params
		timeout : 30000,
		contentType: 'application/json; charset=UTF-8',
		dataType: 'json',
		success: function (data) {
			console.log('seccess: ', data);
    	    /*
    	    * ... 공통 로직 ...
    	    */
    	    if(typeof (obj.success) === 'function'){
    		    obj.success(data);
    	    }
    	    return data;
		},
		error: function (request, status, error) {
			alert(request.responseText)
		}
	})
}

function jsonEscape (data) {
	return JSON.stringify(data).replace(/&quot;/g, '"');
}

