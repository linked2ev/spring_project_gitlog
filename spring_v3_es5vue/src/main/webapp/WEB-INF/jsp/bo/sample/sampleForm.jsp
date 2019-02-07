<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/jsp/bo/include/head.jsp" />
</head>

<body>

<!-- header -->
<jsp:include page="/WEB-INF/jsp/bo/include/header/header.jsp" />
<!-- // header 

<!-- main -->
<main id="main" class="main respWidth">
	<div class="containerWrap">
	
		<!-- leftNav -->  
		<jsp:include page="/WEB-INF/jsp/bo/include/left/left.jsp" />
		<!-- // leftNav -->
	
		<div class="pageWrap rndContact">
		
			<div class="page-title">
				<h2>샘플 등록</h2>
				<div class="page-location">
					<span class="home">홈</span> - <b>샘플 등록</b>
				</div>
			</div>
			
			<div class="page-content"> 
				
				<form id="form" name="form" enctype="multipart/form-data">
					<div class="tblWrap tbl-wm">
						<table>
							<caption>개인 정보 확인 입력 테이블</caption>
							<colgroup>
								<col width="25%">
								<col width="75%">
							</colgroup>
							<tbody>
								<tr>
									<th>제목</th>
									<td><input type="text" id="TITLE" name="TITLE" class="inputBox requireFileld" title="제목"></td>
								</tr>
								<tr>
									<th>내용</th> 
									<td><textarea type="text" id="CONTENTS" name="CONTENTS" class="inputBox summernote requireFileld" title="내용" style="height: 300px;"></textarea></td>
								</tr>
								<tr>
									<th>첨부파일</th>
									<td>
										<div class="divForm file-box-0">
											<input type="text" class="fileName inputBox" readonly="readonly" style="width:340px;">
											<label for="upload-name-0" class="btn btn-5th btn-blue btn_file">찾아보기</label>
											<input type="file" id="upload-name" class="upload-name-0" name="SEND_UPLOAD_FILE">
										</div>
									</td>
								</tr>
								<tr>
									<th>첨부파일</th>
									<td>
										<div class="divForm file-box-1">
											<input type="text" class="fileName inputBox" readonly="readonly" style="width:340px;">
											<label for="upload-name-1" class="btn btn-5th btn-blue btn_file">찾아보기</label>
											<input type="file" id="upload-name" class="upload-name-1" name="SEND_UPLOAD_FILE">
										</div>
									</td>
								</tr> 
								<tr>
									<th>첨부파일</th>
									<td>
										<div class="divForm file-box-2">
											<input type="text" class="fileName inputBox" readonly="readonly" style="width:340px;">
											<label for="upload-name-2" class="btn btn-5th btn-blue btn_file">찾아보기</label>
											<input type="file" id="upload-name" class="upload-name-2" name="SEND_UPLOAD_FILE">
										</div>
									</td>
								</tr>
							</tbody>
						</table>
					</div>
				</form>
					
				<div class="btn-wrap btnC">
					<button type="button" class="btn btn-prim btn-red wd100" id="fnSave">저장</button>
				</div>

			</div><!-- // page-content -->
		</div><!-- // pageWrap -->

	</div><!-- // container -->
</main>
<!-- // main -->

<!-- footer -->
<jsp:include page="/WEB-INF/jsp/bo/include/footer.jsp" />
<!-- // footer --> 

<script language="javascript" defer="defer">

	for(var i=0;i<3;i++){ 
		var uploadFile = $('.file-box-'+i+' .upload-name-'+i);
		console.log(">> uploadFile : " , uploadFile);    
		uploadFile.unbind().on('change', function(){        
			if(window.FileReader){ 
				var filename = $(this)[0].files[0].name;
			} else { 
				var filename = $(this).val().split('/').pop().split('\\').pop();
			}
			$(this).siblings('.fileName').val(filename);
		});
	}
 	 
	$(function(){
		
		// 저장 버튼 클릭 이벤트
		$(document).on("click", "#fnSave", function () {
			var $form = $("form");

			if(isEmptyForm("form")){
				$form.attr({"action":"<c:url value='/bo/sample/sampleProc.do'/>", "target":"_self", "method":"post"}).submit();
			}
		});
		 
	});
</script>

</body>
</html>