<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script src="../js/jquery-3.3.1.min.js"></script>


<table>
	<tr>
		
	<c:choose>

			<c:when test="${mem.grade=='C' }">

			<td><a href="../greensc/LogOut">로그아웃</a></td>
			<td><a href="../greensc/ModifyMem?mypage=in">마이페이지</a></td>
			<td><a href="../greensc/NoticeList?center=in">고객센터</a></td>
			<td><a href="../Basket/BasketMain">장바구니</a></td>
			<td><a href="../greensc/Home">홈</a></td>
			
			</c:when>
			
			
			<c:when test="${mem.grade=='M' }">

			<td><a href="../greensc/LogOut">로그아웃</a></td>
			<td><a href="../greensc/ModifyMem?mypage=in">마이페이지</a></td>
			<td><a href="../greensc/NoticeList?center=in">고객센터</a></td>
			<td><a href="../greensc/MgPage?mgpage=in">고객관리</a></td>
			<td><a href="../Manager/AirLine_List?partner=in">협력업체관리</a></td>
			<td><a href="../Manager/ManagerSellList?bstatus=m">판매관리</a></td>
			<td><a href="../greensc/Home">홈</a></td>
			
			</c:when>
			
			<c:when test="${mem.grade=='H' }">

			<td><a href="../greensc/LogOut">로그아웃</a></td>
			<td><a href="../greensc/ModifyMem?mypage=in">마이페이지</a></td>
			<td><a href="../hmain/Hmain?hotcont=in">호텔관리</a></td>
			<td><a href="../greensc/Home">홈</a></td>
			
			</c:when>
			
			<c:otherwise>

			<td><a href="../greensc/Login">로그인</a></td>
			<td><a href="../greensc/SignUp?">회원가입</a></td>
			<td><a href="../greensc/NoticeList?center=in">고객센터</a></td>
			<td><a href="../greensc/Home">홈</a></td>
			
			</c:otherwise>
		</c:choose>

	</tr>
	
</table>