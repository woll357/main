<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<script>

	function formatDate() {
		
	var d = new Date(); 
	var month = '' + (d.getMonth() + 1);
	var day = '' + d.getDate();
	var year = d.getFullYear(); 
	
	if (month.length < 2) month = '0' + month; 
	if (day.length < 2) day = '0' + day; 
	
	return year+'-'+month+'-'+day; 
	} 

	function boarding(id, startDate){
		
		var today = formatDate();
		
		startDate = startDate.substring(0,10);
		
		if(startDate==today){
			location.href="../hotelsell/CheckInReg?basketID="+id+"&hotcont=in";
			
		}
		else{
			alert("체크인 불가 날짜입니다.")
		}
		
	}
</script>
<link rel="stylesheet" href="../css/nh/tot.css" />
<br>
	<table class = "ttcss" border="">
		<tr>
			<td  class="wbbr">방종류</td>
			<td  class="wbbr">체크인날짜</td>
			<td  class="wbbr">체크아웃날짜</td>
			<td  class="wbbr">사람수</td>
			<td  class="wbbr">고객id</td>
			<td  class="wbbr">체크인</td>
		</tr>
		<c:forEach var="i" items="${reserveList }" >
		<tr>
			<c:if test="${i.itemName=='S' }">
			<td>스탠다드</td>
			</c:if>
			<c:if test="${i.itemName=='D' }">
			<td>디럭스</td>
			</c:if>
			<td>${i.ddateStr }</td>
			<td>${i.fdateStr }</td>
			<td>${i.psn }</td>
			<td>${i.id }</td>
			<td><button class="btncss" onclick="boarding('${i.basketID }', '${i.ddateStr }')">체크인</button></td>
		</tr>
		</c:forEach>
		
	</table>