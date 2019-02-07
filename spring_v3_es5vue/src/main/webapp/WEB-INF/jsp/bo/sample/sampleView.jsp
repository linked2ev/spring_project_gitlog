<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<jsp:include page="/WEB-INF/jsp/bo/include/head.jsp" />
</head>
<body>

<!-- header -->
<jsp:include page="/WEB-INF/jsp/bo/include/header/header.jsp" />
<!-- // header -->
 
<!-- main -->
<main id="main" class="main respWidth">
	<div class="containerWrap">
	
	<!-- leftNav -->  
	<jsp:include page="/WEB-INF/jsp/bo/include/left/left.jsp" />
	<!-- // leftNav --> 

		<div class="pageWrap rndRecrView">

			<div class="page-title">
				<h2>참여 모집 상세 정보</h2>
				<div class="page-location">
					<span class="home">홈</span> - 참여 모집 공고 - <b>참여 모집 상세 정보</b>
				</div>
			</div>
			
			<div class="page-content">
				<form id="searchForm" name="searchForm">
					<input type="hidden" name="cPageNo" value="<c:out value="${commandMap.cPageNo }"/>"/>
					<input type="hidden" name="searchTeamGbn" value="<c:out value="${commandMap.searchTeamGbn }"/>"/>
					<input type="hidden" name="searchExamWay" value="<c:out value="${commandMap.searchExamWay }"/>"/>
					<input type="hidden" name="searchVisitArea" value="<c:out value="${commandMap.searchVisitArea }"/>"/>
					<input type="hidden" name="searchExamTitle" value="<c:out value="${commandMap.searchExamTitle }"/>"/>
				</form>
				<form id="form" name="form">
					<input type="hidden" name="EXAM_MNG_NO" value="<c:out value="${commandMap.EXAM_MNG_NO }"/>"/>
					<input type="hidden" name="EXAM_WAY_CD" value="<c:out value="${commandMap.EXAM_WAY_CD }"/>"/>
				</form>
				
				<div class="listWrap">
					<div class="recruit-view">
						<div class="recruit-content">
							<div class="recruit-l"> 
								<div class="recruit-r">
									<div class="recruit-label">
									    <c:if test="${info.STATUS eq 'selection'}"><c:set var="STATUS" value="green" /></c:if>
									    <c:if test="${info.STATUS eq 'applying'}"><c:set var="STATUS" value="red" /></c:if>
									    <c:if test="${info.STATUS eq 'available'}"><c:set var="STATUS" value="blue" /></c:if>
										<span class="label-<c:out value="${STATUS}"/> ">
											<c:if test="${info.STATUS eq 'selection'}">패널선정</c:if>
											<c:if test="${info.STATUS eq 'applying'}">신청중</c:if>
											<c:if test="${info.STATUS eq 'available'}">신청가능</c:if>
										</span>
									</div>
								</div>
								<div class="recuit-title">
									<a href="#">
										<em><c:out value="${info.TEAM_GBN }" /></em>
										<c:out value="${info.EXAM_TITLE }" />
									</a>
								</div>
								<div class="recruit-period">
									<span class="recruit-date">
										<em>신청기간</em> : <c:out value="${info.APP_PERIOD }" />
									</span>
									<span class="exam-date">
										<em>참여일자</em> : <c:out value="${info.EXAM_PERIOD }" />
									</span>
								</div>
							</div>
							<div class="recruit-detail">
								<dl>
									<dt>중복참여</dt>
									<dd><c:out value="${info.DUP_APP }" /></dd>
									<dt>모집마감방법</dt> 
									<dd><c:out value="${info.RECRUIT_WAY }" /></dd>
									<dt>연구방식</dt>
									<c:choose>
										<c:when test="${info.EXAM_WAY_CD eq '01'}">
											<dd><c:out value="${info.EXAM_WAY }" /> / <c:out value="${info.VISIT_PLACE }" /></dd>
											<c:if test="${not empty visit_list }">
												<dt>방문일자</dt>
												<dd>
													<c:forEach var="row" items="${visit_list}" varStatus="i">
														<p>
															<c:out value="${row.EXAM_ORDER }" />차&nbsp;&nbsp;&nbsp;
															<c:out value="${row.VISIT }" />
														</p>				
													</c:forEach>
												</dd>
											</c:if>
										</c:when>
										<c:otherwise>
											<dd><c:out value="${info.EXAM_WAY }" /></dd>
											<c:if test="${not empty online_list }">
												<dt>온라인 설문</dt>
												<dd>
													<c:forEach var="row" items="${online_list}" varStatus="i">
														<p>
															<c:out value="${row.SURVEY_PERIOD }" />
														</p>				
													</c:forEach>
												</dd>
											</c:if>
										</c:otherwise>
									</c:choose>
								</dl>
							</div>
						</div>
						<div class="recruit-context">
						
							<c:out value="${info.EXAM_OUTLINE }" escapeXml="false"/>
						
						</div>
						<div class="recruit-btn btnC">
							<c:if test="${info.EXAM_APP_YN eq 'N'}">
								<button type="button" class="btn btn-prim btn-red wd100" id="fn_goApplicationStep1">참여신청</button>
							</c:if>
							<c:if test="${info.APP_CANCEL_YN eq 'Y'}">
								<button type="button" class="btn btn-prim btn-gray wd100" id="fn_cancel">신청취소</button>
							</c:if>
						</div>  
					</div> 
				</div>
				<div class="btn-wrap btnR">
					<button type="button" class="btn btn-prim btn-white wd100" id="fn_goList">목록</button>
				</div>				

			</div><!-- // page-content -->
		</div><!-- // pageWrap -->


	</div><!-- // container -->
</main>
<!-- // main -->

<!-- footer -->
<jsp:include page="/WEB-INF/jsp/bo/include/footer.jsp" />
<!-- // footer -->

<script>
	$(function(){
		
		// 목록 버튼 클릭 이벤트
		$(document).on("click", "#fn_goList", function(){
			var $searchForm = $("#searchForm");
			$searchForm.attr({"action":"<c:url value='/bo/sample/sampleList.do'/>", "target":"_self", "method":"post"}).submit();
		});
		
	});
</script>
</body>
</html>