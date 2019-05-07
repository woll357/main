<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%request.setCharacterEncoding("utf-8"); %>
<script src="../js/jquery-3.3.1.min.js"></script>
<script>
function mkmonth(){
	var today = new Date();
	var todayYear = today.getFullYear();
	var todayMonth = today.getMonth()+1;
	var options;
	 $("#month *").remove();
	options = $('<option value="">입력없음</option>');
	$("#month").append(options);
	if($('#year').val()==todayYear){
		for (var i = 1; i <= todayMonth; i++) {
			options = $('<option value='+i+'>'+i+'</option>');
			$("#month").append(options);
		}
	}
	else{
		for (var i = 1; i <= 12; i++) {
			options = $('<option value='+i+'>'+i+'</option>');
			$("#month").append(options);
		}
	}
}

function mkdate(){
	
	var today = new Date();
	var todayYear = today.getFullYear();
	var todayMonth = today.getMonth()+1;
	var todayDate = today.getDate();
	
	var yearMonth = new Date($('#year').val(),$('#month').val(),0);
	var lastDate = yearMonth.getDate();
	
	var options;
	$("#day *").remove();
	options = $('<option value="">입력없음</option>');
	$("#day").append(options);
	
	if($('#year').val()==todayYear && $('#month').val()==todayMonth){
		for (var i = 1; i < todayDate; i++) {
			options = $('<option value='+i+'>'+i+'</option>');
			$("#day").append(options);
		}
		
	}
	else{
		for (var i = 1; i <= lastDate; i++) {
			options = $('<option value='+i+'>'+i+'</option>');
			$("#day").append(options);
		}
	}
}
</script>
<div align="center">
<h1 align="center">매출내역</h1>
<table style="text-align: center; border: 10px #dcefef solid;" cellspacing="0">
	<tr>
	<td  style="width: 50px" >방코드</td>
	<td>
	<select style="width: 200px" id="rcode" name="rcode">
	<option value="">방선택</option>
	<c:forEach var="i" items="${rlists }">
	<option  value="${i.rcode }">${i.rcode }</option>
	</c:forEach>
	</select>
	</td>
	
	
	<td>
	<select style="width: 80px" id="year" name="year" onchange="mkmonth()">
	<option value="">필수입력</option>
	<c:forEach var="i" items="${years }">
	<option value="${i }">${i }</option>
	</c:forEach>
	</select>
	</td>
	<td  style="width: 25px" >년</td>

	<td>
	<select style="width: 80px" id="month" name="month" onchange="mkdate()">
	<option value="">입력없음</option>
	</select>
	</td>
	<td  style="width: 25px" >월</td>

		<td>
	<select style="width: 80px" id="day" name="day">
	<option value="">입력없음</option>
	</select>
	</td>
	<td  style="width: 25px" >일</td>


	<td>
	<input id="search" type="button" value="검색" />
	</td>
	</tr>
	</table>
	</div>
	<div id="searchResult" align="center">

	</div>

<script>
	$(document).ready(function(){
		$("#search").on({
			click:function(){
				if($("#rcode").val()==""){
					console.log("회사명이 없을 때");
					
					if($("#year").val()!="" && $("#month").val()=="" && $("#day").val()==""){ //연도까지
						console.log("회사명x연도O")
						$.ajax("../Sales/HotSalesList?year="+$('#year').val(),
					            {
				               success:function(ll){
				            	   $("#searchResult").html(ll)
				    
				               },
				               error:function(){
				              
				               },
				            }
				         ); 
					}
					else if($("#year").val()!="" && $("#month").val()!="" && $("#day").val()==""){ //달까지
						$.ajax("../Sales/HotSalesList?year="+$('#year').val()+"&month="+$('#month').val(),
					            {
				               success:function(ll){
				            	   $("#searchResult").html(ll)
				    
				               },
				               error:function(){
				              
				               },
				            }
				         ); 
					}
					else if($("#year").val()!="" && $("#month").val()!="" && $("#day").val()!=""){ //날짜까지
						$.ajax("../Sales/HotSalesList?year="+$('#year').val()+"&month="+$('#month').val()+"&day="+$('#day').val(),
					            {
				               success:function(ll){
				            	   $("#searchResult").html(ll)
				    
				               },
				               error:function(){
				              
				               },
				            }
				         ); 
					}
				}
				else if($("#rcode").val()!=""){
					console.log("회사명이 있다");
					
					if($("#year").val()!="" && $("#month").val()=="" && $("#day").val()==""){ //연도까지
						$.ajax("../Sales/HotSalesList?rcode="+$('#rcode').val()+"&year="+$('#year').val(),
					            {
				               success:function(ll){
				            	   $("#searchResult").html(ll)
				    
				               },
				               error:function(){
				              
				               },
				            }
				         ); 
					}
					else if($("#year").val()!="" && $("#month").val()!="" && $("#day").val()==""){ //달까지
						$.ajax("../Sales/HotSalesList?rcode="+$('#rcode').val()+"&year="+$('#year').val()+"&month="+$('#month').val(),
					            {
				               success:function(ll){
				            	   $("#searchResult").html(ll)
				    
				               },
				               error:function(){
				              
				               },
				            }
				         ); 
					}
					else if($("#year").val()!="" && $("#month").val()!="" && $("#day").val()!=""){ //날짜까지
						$.ajax("../Sales/HotSalesList?rcode="+$('#rcode').val()+"&year="+$('#year').val()+"&month="+$('#month').val()+"&day="+$('#day').val(),
					            {
				               success:function(ll){
				            	   $("#searchResult").html(ll)
				    
				               },
				               error:function(){
				              
				               },
				            }
				         ); 
					}
					
				}
				
			}
	});

});

</script>

<%-- <form action="">
	<table>
		<tr>
			<td>방이름</td>
			<td>체크인날짜</td>
			<td>체크아웃날짜</td>
			<td>매출액</td>
		</tr>
		<c:forEach var="i" items="${salesList }" >
		<tr>
			<td>${i.itemName }</td>
			<td>${i.ddate }</td>
			<td>${i.fdate }</td>
			<td>${i.totalPrice }</td>
		</tr>
		</c:forEach>
		<tr>
		<td>총매출</td>
		<td>${totalSalse }</td>
		</tr>
	</table>
</form> --%>