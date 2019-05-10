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
		for (var i = todayMonth; i < todayMonth+3 ; i++) {
			if(i<13){
			options = $('<option value='+i+'>'+i+'</option>');
			$("#month").append(options);
			}
		}
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
<table>
<tr>

	<td style="border-bottom: 10px #dcefef solid;">
	<select style="width: 80px" id="year" name="year" onchange="mkmonth()">
	<option value="">필수입력</option>
	<c:forEach var="i" items="${years }">
	<option value="${i }">${i }</option>
	</c:forEach>
	</select>
	</td>
	<td  style="width: 25px" >년</td>

	<td style="border-bottom: 10px #dcefef solid;">
	<select style="width: 80px" id="month" name="month" onchange="mkdate()">
	<option value="">필수입력</option>
	</select>
	</td>
	<td  style="width: 25px" >월</td>

		<td style="border-bottom: 10px #dcefef solid;">
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
	<div id="searchResult">

	</div>
<script>

$(document).ready(function(){
	$("#search").on({
		click:function(){
			if($("#year").val()!="" && $("#month").val()!="" && $("#day").val()==""){
				$.ajax("../Sales/ReserveDateList?year="+$('#year').val()+"&month="+$('#month').val(),
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
				$.ajax("../Sales/ReserveDateList?year="+$('#year').val()+"&month="+$('#month').val()+"&day="+$('#day').val(),
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
});

});
</script>