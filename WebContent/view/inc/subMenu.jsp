<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:choose>
	<c:when test="${param.mypage=='in'}">
		<table border="">
			<tr>
				<td><a href="../greensc/ModifyMem?mypage=in">회원 정보 수정</a></td>
				<c:if test="${mem.grade=='C' || mem.grade=='M'}">
					<td><a href="../greensc/DeleteMySign?mypage=in">탈퇴 신청</a></td>
					<c:if test="${mem.grade=='C'}">
					<td><a href="../greensc/Appbss?mypage=in">등업 신청</a></td>
					</c:if>
					<td><a href="../purchase/DetailReserveInfo?mypage=in">예약내역조회</a></td>
					<td><a href="../purchase/BuyList?mypage=in">구매내역조회</a></td>
					<td><a href="../purchase/RefundList?mypage=in">환불내역조회</a></td>
				</c:if>
			</tr>
		</table>
	</c:when>
	<c:when test="${param.mgpage=='in'}">
		<table border="">
			<tr>
				<td><a href="../greensc/MgPage?mgpage=in">회원 관리</a></td>
				<td><a href="../greensc/BlackList?mgpage=in">블랙리스트 관리</a></td>
				<td><a href="../greensc/MgGradeUp?mgpage=in">등업 관리</a></td>
				<td></td>
			</tr>
		</table>
	</c:when>

	<c:when test="${param.center=='in'}">
		<table border="">
			<tr>
				<td><a href="../greensc/NoticeList?center=in">공지</a></td>
				<td><a href="../greensc/FnqList?center=in">자주묻는질문</a></td>
				<c:if test="${mem.id!=null }">
					<td><a href="../greensc/QnaList?center=in">Q&A</a></td>
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
				<td><a href="../hotelsell/HotelSalesList?hotcont=in">매출내역</a></td>
				<td><a href="../hotelsell/HotelReserveList?hotcont=in">예약내역</a></td>
			</tr>
		</table>
	</c:when>

	<c:when test="${param.aotcont=='in' }">
		<table border="">
			<tr>
				<td><a href="../airgreen/AirLine_Detail?aotcont=in">항공사 수정 및 삭제</a></td>
				<td><a href="../airgreen/AirItem_ListY?aotcont=in">지난상품목록조회</a></td>
				<td><a href="../airgreen/AirItem_List?aotcont=in">상품목록조회</a></td>
				<td><a href="../airgreen/Airp_List?aotcont=in">항공편목록</a></td>
				<td><a href="../airgreen/Airplane_List?aotcont=in">비행기목록</a></td>
				<td><a href="../airsell/AirSalesList?aotcont=in">매출내역</a></td>
				<td><a href="../airsell/AirReserveList?aotcont=in">예약내역</a></td>

			</tr>
		</table>
	</c:when>
	<c:when test="${param.partner=='in' }">
		<table border="">
			<tr>
				<td><a href="../Manager/AirLine_List?partner=in">항공사 목록</a></td>
				<td><a href="../airgreen/AirItem_ListY?aotcont=in">지난상품목록조회</a></td>
				<td><a href="../Manager/AirItem_List?partner=in">상품목록조회</a></td>
				<td><a href="../Manager/Airplane_List?partner=in">비행기목록</a></td>
				<td><a href="../Manager/Airp_List?partner=in">항공편목록</a></td>
				<td><a href="../Manager/Air_DeleteRequestList?partner=in">삭제신청목록</a></td>
				<td><a href="../Manager/Hlist?partner=in">호텔목록</a></td>
			</tr>
		</table>
	</c:when>


	<c:when test="${param.sales=='in' }">
		<table border="">
			<tr>

				<td><a href="../Manager/ManagerSellList?sales=in&bstatus=m">예약내역조회</a></td>
				<td><a href="../Manager/ManagerSellList?sales=in&bstatus=p">구매내역
						조회</a></td>
				<td><a href="../Manager/ManagerSellList?sales=in&bstatus=r">환불내역
						조회</a></td>



			</tr>
		</table>
	</c:when>



</c:choose>

