<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <link rel="stylesheet" href="../css/nh/tot.css" type="text/css">
    <style>
    	.sitebox{
    		
    	}
    
    </style>
    <h2>사이트맵</h2>
  <div align="center" class="sitebox">


<input type="hidden" value="${mem.id }"/>

<table class="ttcss" border="" style="text-align: center;">
	<tr>
		<td class="wbbr">멤버페이지</td>
		<td class="wbbr">마이페이지</td>
		<td class="wbbr">고객센터</td>
	</tr>
	<tr>
		<td><a href="../greensc/SignUp" >회원가입 </a></td>
		<c:choose>
			<c:when test="${mem.id!=null && mem.id!=''}">
				<td><a href="../greensc/ModifyMem?mypage=in" >회원정보수정 </a></td>
			</c:when>
			<c:otherwise>
				<td><a href="../greensc/Login" >회원정보수정</a></td>
			</c:otherwise>
		</c:choose>
		<td><a href="../greensc/NoticeList?center=in" >공지 </a></td>
	</tr>
	<tr>
		<td><a href="../greensc/FindMySign" >ID/PW찾기 </a></td>
		<c:choose>
			<c:when test="${mem.id!=null && mem.id!=''}">
				<td><a href="../greensc/DeleteMySign?mypage=in" >탈퇴신청 </a></td>
			</c:when>
			<c:otherwise>
				<td><a href="../greensc/Login" >탈퇴신청</a></td>
			</c:otherwise>
		</c:choose>
		<td><a href="../greensc/FnqList?center=in" >자주묻는질문 </a></td>
	</tr>
	<tr>
		<td><a href="../greensc/Login" >로그인 </a></td>
		<c:choose>
			<c:when test="${mem.id!=null && mem.id!=''}">
				<td><a href="../greensc/Appbss?mypage=in" >등업신청 </a></td>
			</c:when>
			<c:otherwise>
				<td><a href="../greensc/Login" >등업신청</a></td>
			</c:otherwise>
		</c:choose>
		<c:choose>
			<c:when test="${mem.id!=null && mem.id!=''}">
				<td><a href="../greensc/QnaList?center=in" >Q&A</a></td>
			</c:when>
			<c:otherwise>
				<td><a href="../greensc/Login" >Q&A</a></td>
			</c:otherwise>
		</c:choose>
	</tr>
	<tr>
		<td></td>
				<c:choose>
			<c:when test="${mem.id!=null && mem.id!=''}">
				<td><a href="../purchase/DetailReserveInfo?mypage=in" >예약내역조회 </a></td>
			</c:when>
			<c:otherwise>
				<td><a href="../greensc/Login" >예약내역조회</a></td>
			</c:otherwise>
		</c:choose>
		<td></td>
	</tr>
	<tr>
		<td></td>
		<c:choose>
			<c:when test="${mem.id!=null && mem.id!=''}">
				<td><a href="../purchase/BuyList?mypage=in" >구매내역조회</a></td>
			</c:when>
			<c:otherwise>
				<td><a href="../greensc/Login" >구매내역조회</a></td>
			</c:otherwise>
		</c:choose>
		<td></td>
	</tr>
	<tr>
		<td></td>
		<c:choose>
			<c:when test="${mem.id!=null && mem.id!=''}">
				<td><a href="../purchase/RefundList?mypage=in" >환불내역조회</a></td>
			</c:when>
			<c:otherwise>
				<td><a href="../greensc/Login" >환불내역조회</a></td>
			</c:otherwise>
		</c:choose>
		<td></td>
	</tr>
</table>
</div>