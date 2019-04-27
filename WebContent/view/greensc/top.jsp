<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script src="../js/jquery-3.3.1.min.js"></script>


<table>
	<tr>
		
		<c:choose>
			<c:when test="${mem.id!=null }">

			<td><a href="LogOut">로그아웃</a></td>
			<td><a href="ModifyMem?mypage=in">마이페이지</a></td>
			<td><a href="NoticeList">공지</a></td>
			<td><a href="FnqList">자주묻는 질문</a></td>
			<td><a href="QnaList">Q&A</a></td>
			<td><a href="Home">홈</a></td>
			
			</c:when>
			<c:otherwise>
			<td><a href="Login">로그인</a></td>
			<td>회원가입</td>
			<td><a href="NoticeList">공지</a></td>
			<td><a href="FnqList">자주묻는 질문</a></td>
			<td><a href="Home">홈</a></td>
			</c:otherwise>
		</c:choose>
		
		
		
		
		<c:if test="${mem.grade=='M' }">
		<td><a href="MgPage?mgpage=in">관리자</a></td>
		</c:if>
	</tr>
</table>