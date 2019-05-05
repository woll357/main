<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%request.setCharacterEncoding("utf-8"); %>
<script src="../js/jquery-3.3.1.min.js"></script>
	<table>
		<tr>
		<td>회사별<input type="radio" id="company" name ="type" /></td>
		<td>월별<input type="radio" id="month" name ="type" /></td>
		</tr>
	</table>
	<div id="serachEngine">
	
	</div>
	
	
<!-- 	<table>
	<tr>
	</tr>
		<tr>
			<td>회사명</td>
			<td>상품종류</td>
			<td>상품명</td>
			<td>환불날짜</td>
			<td>고객id</td>
		</tr> -->
<%-- 		<c:forEach var="i" items="${managerSellList }" >
		<tr>	
			<td>${i.cName }</td>
			<td>${i.cType }</td>
			<td>${i.itemName }</td>
			<td>${i.ddate }</td>
			<td>${i.id }</td>
			<td>${i.totalPrice }</td>
		</tr>
		</c:forEach> --%>


<!-- 		<tr>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		</tr>
	</table> -->
<script>
	$(document).ready(function(){
		$("#company").on({
					click:function(){
						$.ajax("../Sales/RefundCompany",
					            {
				               success:function(dd){
				            	   $("#serachEngine").html(dd)
				            	 
				               },
				               error:function(){
				              
				               },
				            }
				         );
					}
			});
	});
</script>