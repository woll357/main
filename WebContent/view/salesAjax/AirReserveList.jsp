<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<script>

	function TravelerInfoDetail(id){
		
		location.href="../purchase/TravelerInfoDetail?basketID="+id+"&aotcont=in";
			
	}
	
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
			location.href="../airsell/BoardingReg?basketID="+id+"&aotcont=in";
		}
		else{
			alert("보딩 불가 날짜입니다.")
		}
		
	}
</script>
<link rel="stylesheet" href="../css/nh/tot.css" />
<br>
	<table class = "ttcss" border="">
		<tr>
			<td class="wbbr">상품코드</td>
			<td class="wbbr">상품이름</td>
			<td class="wbbr">이륙날짜</td>
			<td class="wbbr">착륙날짜</td>
			<td class="wbbr">사람수</td>
			<td class="wbbr">고객id</td>
			<td class="wbbr">보딩</td>
			<td class="wbbr">여행객 상세 정보</td>
		</tr>
		<c:forEach var="i" items="${reserveList }" >
		<tr id="bd">
			<td>${i.code }</td>
			<td>${i.itemName }</td>
			<td>${i.ddateStr }</td>
			<td>${i.fdateStr }</td>
			<td>${i.psn }</td>
			<td>${i.id }</td>
			<td><button class="btncss" onclick="boarding('${i.basketID }', '${i.ddateStr }')">보딩</button></td>
			<td><button class="btncss" onclick="TravelerInfoDetail('${i.basketID}')" >여행객 상세 정보</button></td>
		</tr>
		</c:forEach>
		
	</table>