<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<link rel="stylesheet" href="../css/nh/tot.css" />
<div>
<form  name = "basket" action="BasketReg" method="post">
	<h2>항공장바구니</h2>
	<table  class="ttcss" border = "" >
		<tr>
			<td class="wbbr">상태</td>
			<td class="wbbr">항공사명</td>
			<td class="wbbr">상품코드</td>
			<td class="wbbr">출발날짜</td>
			<td class="wbbr">도착날짜</td>
			<td class="wbbr">출발도시</td>
			<td class="wbbr">도착도시</td>
			<td class="wbbr">예약인원</td>
			<td class="wbbr">금액</td>
			<td class="wbbr">삭제</td>
		</tr>
		<c:forEach var="adto" items="${adtos }"   >
		<tr>
			<td><input class="chk" name="basketIDs" type="checkbox" value="${adto.basketID }" /></td>
			<td>${adto.cName }</td>
			<td>${adto.code }</td>
			<td>${adto.ddateStr }</td>
			<td>${adto.fdateStr }</td>
			<td>${adto.location1 }</td>
			<td>${adto.location2 }</td>
			<td>${adto.psn }</td>
			<td>${adto.totalPrice }</td>
			<td  class="btncss"><a style="width:100%;" href="BasketItemDeleteReg?basketID=${adto.basketID }" >삭제</a></td>
		</tr>
		</c:forEach>
	</table>
		<h2>호텔장바구니</h2>
	<table class="ttcss" border = "">
		<tr>
			<td class="wbbr">상태</td>
			<td class="wbbr">호텔이름</td>
			<td class="wbbr">방이름</td>
			<td class="wbbr">체크인날짜</td>
			<td class="wbbr">체크아웃날짜</td>
			<td class="wbbr">국가명</td>
			<td class="wbbr">도시명</td>
			<td class="wbbr">방인원</td>
			<td class="wbbr">금액</td>
			<td class="wbbr">삭제</td>
		</tr>
		
		<c:forEach var="hdto" items="${hdtos }" >
		<tr>
			<td><input class="chk" name="basketIDs" type="checkbox" value="${hdto.basketID }" /></td>
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
			<td>${hdto.totalPrice }</td>
			<td class="btncss"><a style="width:100%;" href="BasketItemDeleteReg?basketID=${hdto.basketID }" >삭제</a></td>
		</tr>
		</c:forEach>
	</table>
	<div align="right" ><input class="btncss" id="basketPay" type="button" value="결제하기" /></div>
</form>
</div>

<script>

	$(document).ready(function(){
		var chkchked = 0;
		
		$('#basketPay').on({

			'click':function(){
				
				$('.chk').each(function(){
					if($(this).is(':checked')){
						chkchked++;
					}
				});
				if(chkchked==0){
					alert("장바구니 항목을 선택해주세요");
				}
				else{
					basket.submit();
				}
			}
		})
	})
	/* div두개로 나눠서 스크롤로 뽑기 */
</script>