<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


 <script src="../js/jquery-3.3.1.min.js"></script>


<table border="">
	<tr>
		<td colspan="9">
			가는 편
		</td>
	</tr>
	<tr>
		<td colspan="2">항공사</td>
		<td>출발일</td>
		<td>도착일</td>
		<td>출발도시</td>
		<td>도착도시</td>
		<td>잔여석</td>
		<td>가격</td>
		<td>선택</td>
		</tr>
		<c:forEach var="dto" items="${dto1}" varStatus="no">
		<tr>
		
		<td id="${no.index+1 }_arpNo">${no.index+1 }</td>
		<td id="${no.index+1 }_arpName">${dto.air_name }</td>
		<td id="${no.index+1 }_arpDdate">${dto.ddate }</td>
		<td id="${no.index+1 }_arpCdate">${dto.a_time }</td>
		<td id="${no.index+1 }_arpDarea">${dto.darea }</td>
		<td id="${no.index+1 }_arpCarea">${dto.carea }</td>
		<td id="${no.index+1 }_arpSeatcnt">${dto.seatcnt }</td>
		<td id="${no.index+1 }_arpMoney">${dto.money }</td>
		<td id="${no.index+1 }_arpBtn"><input type="button" value="${dto.cCode}"/></td>
		</tr>
		</c:forEach>
		
		
		
		<c:if test="${way=='rtp' }">
		<tr>
			<td colspan="9">
				오는 편
			</td>
		</tr>
		
		<tr>
		<td colspan="2">항공사</td>
		<td>출발일</td>
		<td>도착일</td>
		<td>출발도시</td>
		<td>도착도시</td>
		<td>잔여석</td>
		<td>가격</td>
		<td>선택</td>
		</tr>
		<c:forEach var="dto" items="${dto2}" varStatus="no">
		<tr>
		<td id="${no.index+1 }_rtpNo">${no.index+1 }</td>
		<td id="${no.index+1 }_rtpName">${dto.air_name }</td>
		<td id="${no.index+1 }_rtpDdate">${dto.ddate }</td>
		<td id="${no.index+1 }_rtpCdate">${dto.a_time }</td>
		<td id="${no.index+1 }_rtpDarea">${dto.darea }</td>
		<td id="${no.index+1 }_rtpCarea">${dto.carea }</td>
		<td id="${no.index+1 }_rtpSeatcnt">${dto.seatcnt }</td>
		<td id="${no.index+1 }_rtpMoney">${dto.money }</td>
		<td><input type="button" value="${dto.cCode}"/></td>
		</tr>
		</c:forEach>
		
		</c:if>
		
		<form action="../Basket/BasketAirReg" method="post">
		<input type="hidden" name="seatcnt" value="${param.seatcnt }"/>
		<table border="">
			<tr>
				<td colspan="8">
				가는 편
				</td>
			</tr>
			<tr>
				<td>항공사</td>
				<td>출발일</td>
				<td>도착일</td>
				<td>출발도시</td>
				<td>도착도시</td>
				<td>잔여석</td>
				<td>가격</td>
				<td>취소</td>
			</tr>
			
			<tr>
				<td id="arpName"></td>
				<td id="arpDdate"></td>
				<td id="arpCdate"></td>
				<td id="arpDarea"></td>
				<td id="arpCarea"></td>
				<td id="arpSeatcnt"></td>
				<td id="arpMoney"></td>
				<td id="rpBtn"><input type="button" value="취소"/></td>
			</tr>
			
			
			
			
			
			
			
		<c:if test="${way=='rtp' }">
		
			<tr>
			<td colspan="8">
				오는 편
			</td>
			</tr>
			
			<tr>
			<td>항공사</td>
			<td>출발일</td>
			<td>도착일</td>
			<td>출발도시</td>
			<td>도착도시</td>
			<td>잔여석</td>
			<td>가격</td>
			<td>취소</td>
			</tr>
		</c:if>
		</table>
		
		
		
		상품코드<input name="ccode"><input name="ccode">
		
		<input type="submit" value="장바구니">
		</form>
		
		
		
</table>
