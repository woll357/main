<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%request.setCharacterEncoding("utf-8"); %>
<table class="ttcss" border = "">
	<tr>
	<td style="border-bottom: 10px #dcefef solid;">
	<select style="width:100%" id="year" name="year">
	<c:forEach var="i" items="${years }">
	<option value="${i }">${i }</option>
	</c:forEach>
	</select>
	</td>
	<td class = "wbbr"  style="width: 25px" >년</td>
	
	<td  style="border-bottom: 10px #dcefef solid;">
	<select style="width:100%"  style="width: 50px" id="month" name="month">
	<option value="1">1</option>
	<option value="2">2</option>
	<option value="3">3</option>
	<option value="4">4</option>
	<option value="5">5</option>
	<option value="6">6</option>
	<option value="7">7</option>
	<option value="8">8</option>
	<option value="9">9</option>
	<option value="10">10</option>
	<option value="11">11</option>
	<option value="12">12</option>
	</select>
	</td>
	<td class = "wbbr"  style="width: 25px" >월</td>
	
	<td>
	<input class="btncss2" id="search" style="width:100%" type="button" value="검색" />
	</td>
	</tr>
</table>
<div id="refundListByYearMonth">

</div>


<script>
	$(document).ready(function(){
		$("#search").on({
					click:function(){
						$.ajax("../Sales/RefundDateList?year="+$('#year').val()+"&month="+$('#month').val(),
					            {
				               success:function(ll){
				            	   $("#refundListByYearMonth").html(ll)
				    
				               },
				               error:function(){
				              
				               },
				            }
				         );
					}
			});
	});
</script>