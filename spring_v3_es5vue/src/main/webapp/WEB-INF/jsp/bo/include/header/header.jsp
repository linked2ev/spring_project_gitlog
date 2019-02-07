<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<header id="header" class="header respWidth">
 
	<div class="header-pc">
		<h1><a href="<c:out value="/fo/mn/panelMainIndex.do"/>">아모레퍼시픽 고객연구센터</a></h1>
		<div class="util">
			<span class="user-name"><em><c:out value="${SESSION_NAME}"/></em>님</span>
			<span class="btn-logout"><button type="button" onclick="fn_logout();">LOGOUT</button></span>
		</div>
	</div>
	<div class="header-mobile">
		<h1><a href="<c:out value="/fo/mn/panelMainIndex.do"/>">아모레퍼시픽 고객연구센터</a></h1>
		<a href="#" id="sidebar-main-trigger" class="mob-all-menu"><span class="screen_out">전체메뉴</span></a>
	</div>
	<aside id="sidebar-main" class="sidebar-mobile">

		<div class="sidebar-close">
			<span><i class="screen_out">닫기</i></span>
		</div>
		<div class="sidebar-container">
			<div class="sidebar-logo">
				<h1>아모레퍼시픽 고객연구센터</h1>
			</div>
			<div class="sidebar-util">
				<div class="sidebar-util-container">
					<span class="user-name"><em><c:out value="${SESSION_NAME}"/></em>님</span>
					<span class="btn-logout"><button type="button" onclick="fn_logout();">LOGOUT</button></span>
				</div>
			</div>

		</div>
	</aside>

</header>