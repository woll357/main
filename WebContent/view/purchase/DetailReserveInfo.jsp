<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<link rel="stylesheet" href="../css/nh/tot.css" />
<script>
function TravelerInfoDetail(id){
	
	location.href="TravelerInfoDetail?basketID="+id+"&mypage=in";	
}
function Refund(id){
	
	location.href="RefundReg?basketID="+id+"&mypage=in";	
}

</script>
<h2>항공예약내역</h2>
	<table class="ttcss" border="" >
		<tr>
			<td class="wbbr">항공사명</td>
			<td class="wbbr">상품코드</td>
			<td class="wbbr">출발날짜</td>
			<td class="wbbr">도착날짜</td>
			<td class="wbbr">출발도시</td>
			<td class="wbbr">도착도시</td>
			<td class="wbbr">예약인원</td>
			<td class="wbbr">여행객정보</td>
			<td class="wbbr">환불</td>
		</tr>
		<c:forEach var="adto" items="${adtos }"   >
		<tr>
			<td>${adto.cName }</td>
			<td>${adto.code }</td>
			<td>${adto.ddateStr }</td>
			<td>${adto.fdateStr }</td>
			<td>${adto.location1 }</td>
			<td>${adto.location2 }</td>
			<td>${adto.psn }</td>
			<td><button class="btncss" style="width:100%" onclick="TravelerInfoDetail('${adto.basketID}')" >여행객 정보</button></td>
			<td><button class="btncss" style="width:100%" onclick="Refund('${adto.basketID}')" >환불</button></td>
		</tr>
		</c:forEach>
	</table>
		 <c:choose>
		<c:when test="${adtos.size()==0 }">
			<h2>조회된 결과가 없습니다.</h2>
		</c:when>
		</c:choose>
	
	<h2>호텔예약내역</h2>
	<table class="ttcss" border="">
		<tr>
			<td class="wbbr">호텔이름</td>
			<td class="wbbr">방이름</td>
			<td class="wbbr">체크인날짜</td>
			<td class="wbbr">체크아웃날짜</td>
			<td class="wbbr">국가명</td>
			<td class="wbbr">도시명</td>
			<td class="wbbr">방인원</td>
			<td class="wbbr">환불</td>
		</tr>
		
		<c:forEach var="hdto" items="${hdtos }" >
		<tr>
			<td>${hdto.cName }</td>
		<c:choose>
		<c:when test="${hdto.itemName=='S' }">
			<td>스탠다드</td>
		</c:when>
		<c:when test="${hdto.itemName=='D' }">
			<td>디럭스</td>
		</c:when>
		</c:choose>
			<td>${hdto.ddateStr }</td>
			<td>${hdto.fdateStr }</td>
			<td>${hdto.location1 }</td>
			<td>${hdto.location2 }</td>
			<td>${hdto.psn }</td>
			
			<td><button class="btncss" style="width:100%" onclick="Refund('${hdto.basketID}')" >환불</button></td>

		</tr>
		</c:forEach>
	</table>
		 <c:choose>
		<c:when test="${hdtos.size()==0 }">
			<h2>조회된 결과가 없습니다.</h2>
		</c:when>
		</c:choose>
	