<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<table>
	<tr>
	<td >
	<select style="width: 200px" id="comName" name="comName">
	<c:forEach var="i" items="${clists }">
	<option  value="${i.key }">${i.value }</option>
	</c:forEach>
	</select>
	</td>
	
	<td>
	<input class="btncss2" id="search" type="button" value="검색" />
	</td>
	</tr>
</table>
<div id="refundListByCom">

</div>

<script>
	$(document).ready(function(){
		$("#search").on({
					click:function(){
						$.ajax("../Sales/RefundCompanyList?comcode="+$('#comName').val(),
					            {
				               success:function(ll){
				            	   $("#refundListByCom").html(ll)
				    
				               },
				               error:function(){
				              
				               },
				            }
				         );
					}
			});
	});
</script>