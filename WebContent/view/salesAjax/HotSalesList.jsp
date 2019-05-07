<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%request.setCharacterEncoding("utf-8"); %>

<script type="text/javascript">

	

</script>
<table width="100%" style="text-align: center; border: 10px #dcefef solid;" cellspacing="0">
		<tr>
			<td style="border-bottom: 10px #dcefef solid;">상품코드</td>
			<td style="border-bottom: 10px #dcefef solid;">상품명</td>
			<td style="border-bottom: 10px #dcefef solid;">시작날짜</td>
			<td style="border-bottom: 10px #dcefef solid;">인원</td>
			<td style="border-bottom: 10px #dcefef solid;">매출액</td>
			<td style="border-bottom: 10px #dcefef solid;">이익</td>
		</tr>
		<c:forEach var="i" items="${salesList }">
		<tr>
			<td>${i.code }</td>
			<c:if test="${i.itemName=='S' }">
				<td>스탠다드</td>
			</c:if>
			<c:if test="${i.itemName=='D' }">
				<td>디럭스</td>
			</c:if>
			<td>${i.ddateStr }</td>
			<td>${i.psn }</td>
			<td>${i.totalPrice }</td>
			<td>${i.comSales }</td>
		</tr>
		</c:forEach>
		<tr>
		<td></td><td></td><td></td>
		<td>총액</td><td id="aa">${totalPrice }원</td>
		<td>${totalSalesPrice }원</td>
		</tr>
</table>