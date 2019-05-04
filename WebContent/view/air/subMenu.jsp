<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:choose>
	<c:when test="${param.mypage=='in'}">
		<table border="">
			<tr>
				<td><a href="ModifyMem?mypage=in">회원 정보 수정</a></td>
				<td><a href="DeleteMySign?mypage=in">탈퇴 신청</a></td>
				<c:if test="${mem.grade=='C' }">
				<td><a href="Appbss?mypage=in">등업 신청</a></td>
					<td><a href="../purchase/DetailReserveInfo?mypage=in">예약내역조회</a></td>
					<td><a>구매내역조회</a></td>
					<td><a href="../purchase/RefundReg?mypage=in">환불내역조회</a></td>
				</c:if>
			</tr>
		</table>
	</c:when>
	<c:when test="${param.mgpage=='in'}">
		<table border="">
			<tr>
				<td><a href="MgPage?mgpage=in">회원 검색</a></td>
				<td><a href="MgGradeUp?mgpage=in">등업 관리</a></td>
			</tr>
		</table>
	</c:when>

	<c:when test="${param.center=='in'}">
		<table border="">
			<tr>
				<td><a href="NoticeList?center=in">공지</a></td>
				<td><a href="FnqList?center=in">자주묻는질문</a></td>
				<c:if test="${mem.id!=null }">
					<td><a href="QnaList?center=in">Q&A</a></td>
				</c:if>
			</tr>
			</table>
			</c:when>

			<c:when test="${param.hotcont=='in' }">
				<table border="">
					<tr>
						<td><a href="../hmain/Hdetail?hotcont=in">호텔상세</a></td>
						<td><a href="../hmain/HmodiForm?hotcont=in">호텔수정</a></td>
						<td><a href="../hmain/HroomwriteForm?hotcont=in">방등록</a></td>
						<td><a href="../hmain/HdeletereqForm?hotcont=in">호텔삭제신청</a></td>
						<td><a href="../hmain/Hmain?hotcont=in">메인</a></td>
						<td>매출내역</td>
						<td>예약내역</td>
					</tr>
				</table>
			</c:when>

			<c:when test="${param.aotcont=='in' }">
				<table width=100% >
					<tr>
						<td><a href="../airgreen/AirLine_Detail?aotcont=in">항공사 수정 및 삭제</a></td>
						<td><a href="../airgreen/AirItem_ListY?aotcont=in">지난상품목록조회</a></td>
						<td><a href="../airgreen/AirItem_List?aotcont=in">상품목록조회</a></td>
						<td><a href="../airgreen/Airp_List?aotcont=in">항공편목록</a></td>
					</tr>
				</table>
			</c:when>
			
</c:choose>

