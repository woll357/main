<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%request.setCharacterEncoding("utf-8"); %>
<table>
	<tr>
	<td>
	<select style="width: 200px" id="comName" name="comName">
	<c:forEach var="i" items="${clists }">
	<option  value="${i.key }">${i.value }</option>
	</c:forEach>
	</select>
	</td>
	
	<td>
	<input id="search" type="button" value="검색" />
	</td>
	</tr>
</table>
<div id="refundListByCom">

</div>

<script>
	$(document).ready(function(){
		$("#search").on({
					click:function(){
						$.ajax("../Sales/RefundCompanyList?comcode=$('#comName').val()",
					            {
				               success:function(aa){
				            	alert(aa);
				    
				               },
				               error:function(){
				              
				               },
				            }
				         );
					}
			});
	});
</script>


<%-- <table>
	<tr>
	</tr>
		<tr>
			<td>회사명</td>
			<td>상품종류</td>
			<td>상품명</td>
			<td>환불날짜</td>
			<td>고객id</td>
		</tr>
		<c:forEach var="i" items="${managerSellList }" >
		<tr>	
			<td>${i.cName }</td>
			<td>${i.cType }</td>
			<td>${i.itemName }</td>
			<td>${i.ddate }</td>
			<td>${i.id }</td>
			<td>${i.totalPrice }</td>
		</tr>
		</c:forEach>
		<tr>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		</tr>
	</table> --%>