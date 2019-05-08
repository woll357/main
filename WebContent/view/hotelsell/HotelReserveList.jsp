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
	options = $('<option value="">필수입력</option>');
	$("#month").append(options);
	if($('#year').val()==todayYear){
		for (var i = 1; i < 13 ; i++) {
			if(i<13){
			options = $('<option value='+i+'>'+i+'</option>');
			$("#month").append(options);
			}
		}
		/* for (var i = todayMonth; i < todayMonth+3 ; i++) {
			if(i<13){
			options = $('<option value='+i+'>'+i+'</option>');
			$("#month").append(options);
			}
		} */
	}
	else if($('#year').val()==todayYear+1){
		for (var i = 1; i < todayMonth-9 ; i++) {
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
		for (var i = todayDate; i <= lastDate; i++) {
			options = $('<option value='+i+'>'+i+'</option>');
			$("#day").append(options);
		}
		
	}
	else if($('#year').val()==todayYear && $('#month').val()==todayMonth+2){
		for (var i = 1; i < todayDate; i++) {
			options = $('<option value='+i+'>'+i+'</option>');
			$("#day").append(options);
		}
		
	}
	else if($('#year').val()==todayYear+1 && $('#month').val()==todayMonth-10){
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
<h1>예약내역</h1>
<table style="text-align: center; border: 10px #dcefef solid;" cellspacing="0">
<tr>
	<td>방코드</td>
	<td>
	<select style="width: 100px" id="rcode" name="rcode">
	<option value="">방코드 선택</option>
	<c:forEach var="i" items="${ridtos }">
	<option value="${i.rcode }">${i.rcode }</option>
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
	<option value="">필수입력</option>
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
			if($("#rcode").val()!=""){ //방코드가 있을 때
				console.log("방코드있따");
			
				if($("#year").val()!="" && $("#month").val()!="" && $("#day").val()==""){
					$.ajax("../Sales/HotReserveList?rcode="+$("#rcode").val()+"&year="+$('#year').val()+"&month="+$('#month').val(),
				            {
			               success:function(ll){
			            	   $("#searchResult").html(ll)
			    
			               },
			               error:function(){
			              
			               },
			            }
			         ); 
				}
				
				else if($("#year").val()!="" && $("#month").val()!="" && $("#day").val()!=""){
					$.ajax("../Sales/HotReserveList?rcode="+$('#rcode').val()+"&year="+$('#year').val()+"&month="+$('#month').val()+"&day="+$('#day').val(),
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
			else if($("#rcode").val()==""){ //방코드가 없을 때
				console.log("방코드없따");
				if($("#year").val()!="" && $("#month").val()!="" && $("#day").val()==""){
					$.ajax("../Sales/HotReserveList?year="+$('#year').val()+"&month="+$('#month').val(),
				            {
			               success:function(ll){
			            	   $("#searchResult").html(ll)
			    
			               },
			               error:function(){
			              
			               },
			            }
			         ); 
				}
				
				else if($("#year").val()!="" && $("#month").val()!="" && $("#day").val()!=""){
					$.ajax("../Sales/HotReserveList?year="+$('#year').val()+"&month="+$('#month').val()+"&day="+$('#day').val(),
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