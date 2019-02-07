<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<div class="leftNav">
	<ul class="leftNav-list">
		<li <c:if test="${fn:indexOf(REQUEST_URI,'/mp/testTEST') > -1}">class="on"</c:if>>
			<a href="#">
				사이트 안내
			</a>
		</li>
		<li <c:if test="${fn:indexOf(REQUEST_URI,'/sample/sampleForm') > -1}">class="on"</c:if>>
			<a href="<c:out value="/bo/sample/sampleForm.do"/>">
				샘플 등록
			</a>
		</li> 
		<li <c:if test="${fn:indexOf(REQUEST_URI,'/fo/mp/') > -1}">class="on"</c:if>>
			<a href="#">마이페이지</a>
			<ul class="sub">
				<li <c:if test="${fn:indexOf(REQUEST_URI,'/mp/testApplicationStatusList') > -1 || fn:indexOf(REQUEST_URI,'/mp/qnaBoardList') > -1}">class="on"</c:if>>
					<a href="<c:out value="/fo/mp/testApplicationStatusList.do"/>">
						참여 신청 현황
					</a>
				</li>
				<li <c:if test="${fn:indexOf(REQUEST_URI,'/mp/testApplicationHistoryList') > -1}">class="on"</c:if>>
					<a href="<c:out value="/fo/mp/testApplicationHistoryList.do"/>">
						참여 신청 이력
					</a>
				</li>
				<li <c:if test="${fn:indexOf(REQUEST_URI,'/mp/myInfo') > -1}">class="on"</c:if>>
					<a href="<c:out value="/fo/mp/myInfo.do"/>">
						회원 정보 변경
					</a>
				</li>
				<li <c:if test="${fn:indexOf(REQUEST_URI,'/mp/memberLeave') > -1}">class="on"</c:if>>
					<a href="<c:out value="/fo/mp/memberLeave.do"/>">
						회원 탈퇴
					</a>
				</li>
			</ul>
		</li>
		<li <c:if test="${fn:indexOf(REQUEST_URI,'/fo/qna/') > -1}">class="on"</c:if>>
			<a href="#">소통광장</a>
			<ul class="sub">
				<li <c:if test="${fn:indexOf(REQUEST_URI,'/qna/oneQnaSendForm') > -1}">class="on"</c:if>>
					<a href="<c:out value="/fo/qna/oneQnaSendForm.do"/>">
						1:1 Q&amp;A
					</a>
				</li>
			</ul>
		</li>
		
	</ul>
</div>