
function init() {
	
	//...초기 설정 및 로직
	
	getNoticeList();
}

//공지사항 목록 가져오기
function getNoticeList(){
	var f = document.frm;
	
    cmAxios({
    	method  : 'get',
        url     : '/fo/board/getNoticeBoardList.do',
        params  : $(f).serializeObject(),
        success : function (data) {
        	
        }
    });
}

$(function(){
	init();
});