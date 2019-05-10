<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%request.setCharacterEncoding("utf-8"); %>
<script src="../js/jquery-3.3.1.min.js"></script>
<link rel="stylesheet" href="../css/nh/tot.css" />
<h2>환불내역조회</h2>
	<table class = "ttcss">
		<tr>
		<td class="wbbr" >전체<input type="radio" id="total" name ="type" /></td>
		<td class="wbbr" >회사별<input type="radio" id="company" name ="type" /></td>
		<td class="wbbr" >월별<input type="radio" id="yearMonth" name ="type" /></td>
		</tr>
	</table>
	<div id="serachEngine">
	</div>
<script>
	$(document).ready(function(){
		$("#total").on({
			click:function(){
				$.ajax("../Sales/RefundTotal",
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
		$("#yearMonth").on({
			click:function(){
				$.ajax("../Sales/RefundDate",
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