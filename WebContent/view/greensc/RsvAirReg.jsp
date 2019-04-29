<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
#airImg{
	width: 30px;
	height: 30px;
}
</style>

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
		
		<td id="${no.index+1 }_awpNo">${no.index+1 }</td>
		<td id="${no.index+1 }_awpName">
		<img id="airImg" alt="" src="../img/${dto.img }">
		${dto.air_name }
		</td>
		<td id="${no.index+1 }_awpDdate">${dto.ddate }</td>
		<td id="${no.index+1 }_awpCdate">${dto.a_time }</td>
		<td id="${no.index+1 }_awpDarea">${dto.darea }</td>
		<td id="${no.index+1 }_awpCarea">${dto.carea }</td>
		<td id="${no.index+1 }_awpSeatcnt">${dto.seatcnt }</td>
		<td id="${no.index+1 }_awpMoney">${dto.money }</td>
		<td id="${no.index+1 }_awpBtn"><input type="button" value="${dto.cCode}"/></td>
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
		<td id="${no.index+1 }_rtpName">
		<img id="airImg" alt="" src="../img/${dto.img }">
		${dto.air_name }
		</td>
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
		
		<c:choose>
		<c:when test="${mem.id!=null && mem.id!=''}">
		<input type="submit" value="장바구니">
		</c:when>
		<c:otherwise>
		<input type="button" value="장바구니" id="btn"/>
		</c:otherwise>
		</c:choose>
		
		
		</form>
		
		
		
</table>

<script>

$(document).ready(function(){
	
	$('#btn').on({
		'click':function(){
			alert("로그인 하세요");
		}
		
	})
	
})

</script>