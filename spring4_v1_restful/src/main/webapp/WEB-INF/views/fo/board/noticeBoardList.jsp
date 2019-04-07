<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/views/fo/include/head.jsp" />
<script src="/js/fo/controller/board/noticeBoardController.js"></script>

</head>
<body>
	
	<form name="frm" id="frm">
		<ul>
			<li>
				<input type="text" name="title" />
			</li>
			<li id="title">
				<input type="text" name="items" />
				<input type="text" name="items" />
				<input type="text" name="items" />
			</li>
			<li>
				<label for="useYn_Y">예</label>
				<input type="radio" name="useYn" id="useYn_Y">
				<label for="useYn_N">아니오</label>
				<input type="radio" name="useYn" id="useYn_N">
			</li>
			<li>
				<input type="checkbox" name="option" value="JAVA"> JAVA<br>
				<input type="checkbox" name="option" value="JSP"> JSP<br>
				<input type="checkbox" name="option" value="SQL"> SQL<br>
			</li>
		</ul>
		
		<div>
			<button type="button" onClick="getNoticeList()">검색</button>
		</div>
	</form>
</body>
</html>