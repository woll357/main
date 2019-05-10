<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%request.setCharacterEncoding("utf-8"); %>
<script>
function TravelerInfoDetail(id){
	
	location.href="TravelerInfoDetail?basketID="+id+"&mypage=in";	
}
function Refund(id){
	
	location.href="RefundReg?basketID="+id+"&mypage=in";	
}

</script>
<h2>항공예약내역</h2>
	<table width="100%" style="text-align: center; border: 10px #dcefef solid;" cellspacing="0" >
		<tr>
			<td style="border-bottom: 10px #dcefef solid;">항공사명</td>
			<td style="border-bottom: 10px #dcefef solid;">비행기코드</td>
			<td style="border-bottom: 10px #dcefef solid;">출발날짜</td>
			<td style="border-bottom: 10px #dcefef solid;">도착날짜</td>
			<td style="border-bottom: 10px #dcefef solid;">출발도시</td>
			<td style="border-bottom: 10px #dcefef solid;">도착도시</td>
			<td style="border-bottom: 10px #dcefef solid;">예약인원</td>
			<td style="border-bottom: 10px #dcefef solid;">여행객정보</td>
			<td style="border-bottom: 10px #dcefef solid;">환불</td>
		</tr>
		<c:forEach var="adto" items="${adtos }"   >
		<tr>
			<td>${adto.cName }</td>
			<td>${adto.itemName }</td>
			<td>${adto.ddateStr }</td>
			<td>${adto.fdateStr }</td>
			<td>${adto.location1 }</td>
			<td>${adto.location2 }</td>
			<td>${adto.psn }</td>
			<td><button onclick="TravelerInfoDetail('${adto.basketID}')" >여행객 상세 정보</button></td>
			<td><button onclick="Refund('${adto.basketID}')" >환불</button></td>
		</tr>
		</c:forEach>
	</table>
		 <c:choose>
		<c:when test="${adtos.size()==0 }">
			<h2>조회된 결과가 없습니다.</h2>
		</c:when>
		</c:choose>
	
	<h2>호텔예약내역</h2>
	<table width="100%" style="text-align: center; border: 10px #dcefef solid;" cellspacing="0">
		<tr>
			<td style="border-bottom: 10px #dcefef solid;">호텔이름</td>
			<td style="border-bottom: 10px #dcefef solid;">방이름</td>
			<td style="border-bottom: 10px #dcefef solid;">체크인날짜</td>
			<td style="border-bottom: 10px #dcefef solid;">체크아웃날짜</td>
			<td style="border-bottom: 10px #dcefef solid;">국가명</td>
			<td style="border-bottom: 10px #dcefef solid;">도시명</td>
			<td style="border-bottom: 10px #dcefef solid;">방인원</td>
			<td style="border-bottom: 10px #dcefef solid;">환불</td>
		</tr>
		
		<c:forEach var="hdto" items="${hdtos }" >
		<tr>
			<td>${hdto.cName }</td>
			<td>${hdto.itemName }</td>
			<td>${hdto.ddateStr }</td>
			<td>${hdto.fdateStr }</td>
			<td>${hdto.location1 }</td>
			<td>${hdto.location2 }</td>
			<td>${hdto.psn }</td>
			
			<td><button onclick="Refund('${hdto.basketID}')" >환불</button></td>

		</tr>
		</c:forEach>
	</table>
		 <c:choose>
		<c:when test="${hdtos.size()==0 }">
			<h2>조회된 결과가 없습니다.</h2>
		</c:when>
		</c:choose>
	