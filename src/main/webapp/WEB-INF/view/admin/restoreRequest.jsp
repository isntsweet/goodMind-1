<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ko">
<head>
    <%@ include file="../common/top.jsp" %>
    <%@ include file="../common/heading.jsp" %>
</head>

<body>
	<div class="container-fluid" id="inFrame">
    <%@ include file="../common/aside.jsp" %>
		<header id="header">
			<a href="/goodM/user/main" class="logo"><strong><img src="/img/logo.png" alt="" width="30px" height="30px"></strong> by 멀캠가네 둘째 조</a>
		</header>
		<!-- Content -->
		<!-- 제목 -->
		<h2>탈퇴회원 복원 신청</h2><!-- 제목 -->
			<form id="requestForm" action="/goodM/admin/request" method="POST">
				<table class="table table-borderless" id="comeIn">
					<tr>
					    <td><label for="uid">아이디</label></td>
					    <td><input type="text" id="uid" name="uid" required></td>
					</tr>
				<tr>
					<td><label for="pwd">비밀번호</label></td>
					<td><input type="password" id="pwd" name="pwd" required></td>
				</tr>
			    <tr>
					<td colspan="2" style="text-align: center;">
						<input class="btn btn-lavender" type="submit" value="제출">
						<input class="btn btn-secondary" type="reset" value="취소">
					</td>
			    </tr>
			</table>
		</form>
	</div>
<%@ include file="../common/bottom.jsp" %>
</body>
</html>