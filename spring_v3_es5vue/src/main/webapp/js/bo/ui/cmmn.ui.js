
/** 
\ * cmmn.ui.js
 * 작성자: jamuge
 * 작성일: 2017.09.18
 */

/* ________인디케이터 공통 설정________ */
jQuery(function(){
	//최초에 인디케이터 로드시 숨긴다  
    jQuery('#Load').css('display','none');

    //Ajax통신시 이벤트
    jQuery(document).ajaxSend(function(){ 
    	jQuery('#Load').css('display','');
    }).ajaxComplete(function(){ 
    	jQuery('#Load').css('display', 'none');
    });
});

//창 이동/닫히기 전에 발생하는 이벤트
window.onbeforeunload = function(e){
    if(e != null && e != undefined){
        jQuery('#Load').css('display','');
    }
};

/* _____________________________________ */


var returnObj = function (){};
var langObj   = function (){}; 
langObj.prototype.locales = null;
/**
 * 작성자: jamuge
 * alert 창 layout
 * returnMsg.alertMsg(msg, type, fn) 호출
 */
returnObj.prototype.alertMsg = function (msg, type, fn) {
	
	if(msg != null && msg != "" && typeof msg != "undefined"){
		   
		if($("#alertMsg").length < 1){
			
			var alertLayout = "";
			alertLayout += '<div class="popupWrap" id="alertWrap" style="z-index:3001;">';
			alertLayout +=     '<div class="dimBack"></div>';
			alertLayout +=     '<div id="alertMsg" class="popupBoxWrap popupAlert" style="width:360px;">';
			alertLayout += 	       '<div class="popupBox">';
			alertLayout +=			   '<div class="popup-container">';
			alertLayout += 			       '<div class="popup-content">';
			alertLayout +=					   '<div class="popup-alert-desc">';
			alertLayout +=						   '<span id="text_alertMsg">' + msg + '</span>';
			alertLayout +=			    	   '</div>';
			alertLayout +=					   '<div class="btn-wrap btnC">';
			alertLayout +=						   '<button type="button" class="btn btn-second btn-red btn-closeAlert" id="fn_closeAlert">확인</button>';
			alertLayout +=					   '</div>'; 
			alertLayout +=				   '</div>';
			alertLayout +=			   '</div>';
			alertLayout +=		   '</div>';
			alertLayout +=	   '</div>';
			alertLayout += '</div>';
			
			$("body").append(alertLayout);
			
		}else{
			$("#text_alertMsg").html(msg);
		}
		//layer_popup("#alertMsg");
		layer_alert("#alertMsg", type, fn);
	
	}else{
		console.log(">>> alertMsg: Error");
	}
};

confirmMsgYn = "N";
returnObj.prototype.confirmMsg = function (msg, type, fn) {
	if(msg != null && msg != "" && typeof msg != "undefined"){
		
		if($("#confirmMsg").length < 1){
			
			var confirmLayout = "";
			
			confirmLayout += '<div class="popupWrap" style="z-index:3001;">';
			confirmLayout +=     '<div class="dimBack"></div>';
			confirmLayout +=     '<div id="confirmMsg" class="popupBoxWrap popupAlert" style="width:360px;">';
			confirmLayout +=         '<div class="popupBox">';
			confirmLayout +=             '<div class="popup-container">';
			confirmLayout += 		         '<div class="popup-content">';
			confirmLayout += 			         '<div class="popup-alert-desc">';
			confirmLayout += 				         '<span id="text_confirmMsg">' + msg + '</span>';
			confirmLayout += 			         '</div>';
			confirmLayout += 			         '<div class="btn-wrap btnC">';
			confirmLayout += 				         '<button type="button" class="btn btn-second btn-white btn-closeAlert" id="confirmN">아니오</button>';
			confirmLayout += 				         '<button type="button" class="btn btn-second btn-red" id="confirmY">예</button>';
			confirmLayout += 			         '</div>';
			confirmLayout += 		         '</div>';
			confirmLayout += 	         '</div>';
			confirmLayout +=         '</div>';
			confirmLayout +=     '</div>';
			confirmLayout += '</div>';
			
			$("body").append(confirmLayout);
			
		}else{
			$("#text_confirmMsg").html(msg);
		}

		if(layer_alert("#confirmMsg", type, fn)){
			return true;
		};
		
	}else{
		console.log(">>> confirmMsg: Error");
	}
};


var returnMsg = new returnObj();

$(function() {
	
	/**
	 * 작성자: jamuge
	 * 우클릭
	 */ 
	$(document).ready(function(){
		 $(document).bind("contextmenu", function(e) {
		  return false;
		 });
	});
			
	/**
	 * 작성자: jamuge
	 * 엔터 방지
	 * 특정 div 내 class="enterPrevent" 추가
	 */
	$(document).on("keypress", ".enterPrevent", function (e) {
		if (e.keyCode == 13) {
			e.preventDefault();
			return;
		}
	});
 	 
	/**
	 * 작성자: jamuge
	 * 숫자만 입력
	 * 해당 field 내 class="fnNumber" 추가
	 */
	$(".fnNumber").keyup(function(event){
        if (!(event.keyCode >=37 && event.keyCode<=40)) {
            var inputVal = $(this).val();
            $(this).val(inputVal.replace(/[^0-9]/gi, ""));
        }
    });
	
	if($(".datepicker").length > 0){
		/* ---------- bootstrap3 datepicker ---------- */
		var dpVal = "N";
	    $.datepicker.regional["ko"] = {
			autoclose: true,
	        showMonthAfterYear:true, 
	    	yearSuffix: "년", // year 표시 text
		    showOn: "both", // 버튼과 텍스트 필드 모두 캘린더를 보여준다.
		    //buttonImage: "/common/images/ico_calendar.png", // 버튼 이미지
		    buttonText : "",
		    buttonImageOnly: true, // 버튼에 있는 이미지만 표시한다.
		    changeMonth: true, // 월을 바꿀수 있는 셀렉트 박스를 표시한다.
		    changeYear: true, // 년을 바꿀 수 있는 셀렉트 박스를 표시한다.
		    minDate: "-100y", // 현재날짜로부터 100년이전까지 년을 표시한다.
		    nextText: "다음 달", // next 아이콘의 툴팁.
		    prevText: "이전 달", // prev 아이콘의 툴팁.
		    numberOfMonths: [1,1], // 한번에 얼마나 많은 월을 표시할것인가. [2,3] 일 경우, 2(행) x 3(열) = 6개의 월을 표시한다.
		    //stepMonths: 3, // next, prev 버튼을 클릭했을때 얼마나 많은 월을 이동하여 표시하는가. 
		    yearRange: "c-100:c+10", // 년도 선택 셀렉트박스를 현재 년도에서 이전, 이후로 얼마의 범위를 표시할것인가.
		    showButtonPanel: true, // 캘린더 하단에 버튼 패널을 표시한다. 
		    currentText: "오늘 날짜" , // 오늘 날짜로 이동하는 버튼 패널
		    closeText: "닫기",  // 닫기 버튼 패널
		    dateFormat: "yy-mm-dd", // 텍스트 필드에 입력되는 날짜 형식.
		    showAnim: "slideDown", //애니메이션을 적용한다. (show, slide, slideDown, fadeIn)
		    showMonthAfterYear: true , // 월, 년순의 셀렉트 박스를 년,월 순으로 바꿔준다. 
		    dayNamesMin: ['일', '월', '화', '수', '목', '금', '토'], // 요일의 한글 형식.
		    monthNamesShort: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'] // 월의 한글 형식.
	    };
	    $.datepicker.setDefaults($.datepicker.regional["ko"]);
	
		$(".datepicker").datepicker(); 
		
	    var $sDate = $(".s-datepicker"); // 종료일
	    var $eDate = $(".e-datepicker"); // 시작일
	    var $pDate = $(".p-datepicker"); // 이전날짜
	    
	    $sDate.datepicker("option", "maxDate", $eDate.val());
	    $sDate.datepicker("option", "onClose", function ( selectedDate ) {
	        $eDate.datepicker( "option", "minDate", selectedDate );
	    });
	    $eDate.datepicker("option", "minDate", $sDate.val());
	    $eDate.datepicker("option", "onClose", function ( selectedDate ) {
	        $sDate.datepicker( "option", "maxDate", selectedDate );
	    });
	    $pDate.datepicker("option", "minDate", new Date());
	    
	    //datepicker 읽기 전용으로 설정
	    $(".datepicker").prop("readonly", true);
	    /* ---------- --------------------- ---------- */
	}
});

/**
 * 작성자: jamuge
 * FORM  필수값 검사 
 * 해당 field 내 class="requireFileld" / title="항목명" 추가
 * EMAIL경우 이메일 아이디 : name/id="EMAIL_ID", 이메일 도메인 : name/id="EMAIL_CD" 전체 이메일(hidden) : name/id = "EMAIL"
 * @param obj
 */
function isEmptyForm( obj ){
	
	var $formObj = $("#"+ obj);
	var isCheckForm =  $formObj.find("input[type=text], input[type=tel], input[type=hidden], input[type=radio], input[type=email], textarea, select");
	
	for(var i=0; i < isCheckForm.length; i++){ 
		//console.log(">> isCheckText: ", $(isCheckForm[i]));
		
		if($(isCheckForm[i]).is("input[type=text], input[type=tel], input[type=hidden], input[type=email], textarea")){
			//console.log(">> text: ", $(isCheckForm[i]).is("input[type=text], input[type=tel], input[type=email], textarea"));
			
			/* require 검사 */
			if($(isCheckForm[i]).hasClass("requireFileld") == true && ($(isCheckForm[i]).val().trim() == "" || $(isCheckForm[i]).val().trim() == null) ){
				$(isCheckForm[i]).focus();
				var title = $(isCheckForm[i]).attr("title");
				returnMsg.alertMsg(title + " 는(은) 필수 입력 사항입니다.");
				return;
			};
			
			/* validation 검사 */
			// 전화번호
			if($(isCheckForm[i]).is("input[type=tel]")){
				var phone = $("#PHONE1").val() + $("#PHONE2").val() + $("#PHONE3").val();
				if(!isCheckHp( phone )){
					returnMsg.alertMsg("연락처 형식을 다시 확인해주세요.");
					$("#PHONE2").focus();
					return;
				};
			}
			// 이메일 select 형식 일 경우
			if($(isCheckForm[i]).is("input[type=hidden]") && $(isCheckForm[i]).hasClass("email")){
				var email = $formObj.find("#EMAIL_ID").val() + "@" + $formObj.find("#EMAIL_CD").val();
				$formObj.find("#EMAIL").val(email);
				if(!isCheckEmail( $formObj.find("#EMAIL").val() )){  
					returnMsg.alertMsg("이메일 형식을 다시 확인해주세요.");
					$formObj.find("#EMAIL_ID").val("");
					$formObj.find("#EMAIL").val("");
					$formObj.find("#EMAIL").focus();
					return;
				};
			}
			// 이메일 text 형식 일 경우
			if($(isCheckForm[i]).hasClass("email")){
				if(!isCheckEmail( $(isCheckForm[i]).val() )){
					$(isCheckForm[i]).val("");
					$(isCheckForm[i]).focus();
					returnMsg.alertMsg("이메일 형식을 다시 확인해주세요.");
					return;
				};
			} 
			// datepicker
			if($(isCheckForm[i]).is("input[type=text]") && $(isCheckForm[i]).hasClass("datepicker") && dpVal == "Y"){
				if(!isCheckDatePicker( $(isCheckForm[i]).val() )){
					console.log($(isCheckForm[i]).val());
					returnMsg.alertMsg("날짜 형식을 다시 확인해주세요.");
					$(isCheckForm[i]).val("");
					$(isCheckForm[i]).focus();
					return;
				};
			};
		
		// radio
		}else if($(isCheckForm[i]).is("input[type=radio]")){
			//console.log(">> radio:", $(isCheckForm[i]).is("input[type=radio]"));
			/* require 검사 */
			var name = $(isCheckForm[i]).attr("name");
			if($(isCheckForm[i]).hasClass("requireFileld") == true && ($(":radio[name="+ name + "]:checked").length < 1) ){
				var title = $(isCheckForm[i]).attr("title");
				$(isCheckForm[i]).focus();
				returnMsg.alertMsg(title + " 는(은) 필수 입력 사항입니다.");
				return;
			}
			
		// select
		}else if($(isCheckForm[i]).is("select")){
			//console.log(">> select: ", $(isCheckForm[i]).is("select"));
			/* require 검사 */
			if($(isCheckForm[i]).hasClass("requireFileld") == true && ($(isCheckForm[i]).val() == "" || $(isCheckForm[i]).val() == null) ){
				$(isCheckForm[i]).focus();
				var title = $(isCheckForm[i]).attr("title");
				returnMsg.alertMsg(title + " 을(를) 선택해주세요.");
				return;
			};
		};
	};
	
	return true;
	
};

//function refreshForm(obj) {
//    $(obj)
//        .closest('form')
//        .find('input[type="text"], textarea, select').val('');
// 
//    $(obj)
//        .closest('form')
//        .find('input[type="checkbox"]').prop('checked', false);
//}

/**
 * 작성자: jamuge
 * 숫자 유효성 체크
 * @param obj
 * @returns {Boolean}
 */
function isCheckNum( obj ){
	var regx = /^[0-9]*$/;
	if( regx.test(obj) ){
		return true;
	}else{
		return false;
	};
};

/**
 * 작성자: jamuge
 * 핸드폰 번호 유효성 체크
 * @param obj
 * @returns {Boolean}
 */
function isCheckHp( obj ){
	var regx = /^(?:(010\d{4})|(01[1|6|7|8|9]\d{3,4}))(\d{4})$/;
	if( regx.test(obj) ){
		return true;
	}else{
		return false;
	};
};

/**
 * 작성자: jamuge
 * 이메일 유효성 체크
 * @param obj
 * @returns {Boolean}
 */
function isCheckEmail( obj ){
	var regx = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
	if( regx.test(obj) ){
		return true;
	}else{
		return false;
	};
};

/**
 * 작성자: jamuge
 * DataPicker 날짜 유효성 체크
 * @param obj
 * @returns {Boolean}
 */
function isCheckDatePicker( obj ) {
	var regx = /^(19[7-9][0-9]|20\d{2})-(0[0-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[0-1])$/;
	if( regx.test(obj) ){
		return true;
	}else{
		return false;
	};
};

/**
 * 작성자: Dodam
 * inputBox 시작값 종료값 체크
 * 시작input : searchFrom, 종료input : searchTo 클래스 추가
 * @param
 * @returns {Boolean}
 */
function chkInputfromTo(){
	var fromArr = $(".searchFrom");
	var toArr = $(".searchTo");

	for(var i = 0; i < fromArr.length; i++){
		var itemFromVal = $(fromArr[i]).val().replace(/-/g, "");
		var itemToVal = $(toArr[i]).val().replace(/-/g, "");
		
		//inputBox를 둘중 하나만 입력했을때
		if((itemFromVal != "" && itemToVal == "") || (itemFromVal == "" && itemToVal != "")){
			returnMsg.alertMsg("시작값과 종료값을 둘 다 입력해주세요.", "", function(){$(fromArr[i]).focus();});
			return false;
		}
		//종료값보다 시작값이 클때
		else{
			if(itemFromVal > itemToVal){
				returnMsg.alertMsg("시작값이 종료값보다 클 수 없습니다.", "", function(){$(fromArr[i]).focus();});
				return false;
			}
		}
	}
	return true;
}

/**
 * 작성자: Dodam
 * inputBox Required 속성 Value값 체크
 * @param
 * @returns {Boolean}
 */
function chkInputRequired(){
	var item;
	
	$("input[required]").each(function(){
		if($(this).val() == ""){
			item = this;
			//each문 빠져 나온다
			return false;
		}
	});
	//빈값이 있을 경우
	if(item != null){
		returnMsg.alertMsg("미입력사항이 있습니다.", "", function(){ $(item).focus(); });
		return false;
	}else{
		return true;
	}
}

/**
 * 작성자: Dodam
 * DataPicker 오늘 날짜로 설정
 * @param
 * @returns 
 */
function setTodayDatepicker(){
	//날짜 형식 재 설정
	$(".datepicker").datepicker({dateFormat: "yy-mm-dd"}); 
	
	//날짜 타입 오늘 날짜로 설정
	$(".datepicker").datepicker().datepicker('setDate', new Date());
}

/**
 * 작성자: Dodam
 * 폼안에 값을 넘길 Input Hidden을 생성
 * @param jqGridId
 * @returns 
 */
function createHiddenInput(form, name, value){
	var el = document.createElement("input");
	el.type = "hidden";
	el.className = "HiddenInput";
    el.name = name;
    el.value = value;
    $(form).append(el);  
}

/**
 * 작성자: jamuge
 * JSON > toString
 * @param object
 * @returns {String}
 */
function JSONtoString(object) {
    var results = [];
    for (var property in object) {
        var value = object[property];
        if (value) 
        	results.push(property.toString() + ': ' + value);
        	console.log(property.toString() + ': ' + value);
        }
    return '{' + results.join(', ') + '}';
}

/**
 * 작성자: jamuge
 * 메시지 다국어 변환
 * @param text : 메시지
 * @param dl   : 디렉토리
 * @param code : 코드
 */
function fnLang(text, code){

	console.log(">> [fnLang] code:", code);
	console.log(">> code type:", typeof code);
	  
	var msg = "";

	if(localeLang == null || localeLang == "" || typeof localeLang == "undefined"){
		console.log(">> ko Msg: " + text);
		msg = text;
		
	}else{
		
		if(localeLang == "ko"){
			
		    if(String(code).indexOf("LC") < 0){ 
		    	console.log(">> ko ajax Error Msg: " + langMsg["common"]["999"]);
		        msg = langMsg["common"]["999"];
		    }
		    else{
		    	console.log(">> ko Msg: " + text);
	    		msg = text;
			}
		
		}else{
			
		    if(String(code).indexOf("LC") < 0){ 
		    	console.log(">> common transMsg: " + langMsg["common"]["999"]);
		        msg = langMsg["common"]["999"];
		    }
		    else{
				console.log(">> jsp transMsg: " + langMsg[localeJsp][code]);
	    		msg = langMsg[localeJsp][code];
			}
		}
	}
    
	return msg;
}
