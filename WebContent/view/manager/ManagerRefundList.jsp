<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%request.setCharacterEncoding("utf-8"); %>
<script src="../js/jquery-3.3.1.min.js"></script>
	<table>
		<tr>
		<td>회사별<input type="radio" id="company" name ="type" /></td>
		<td>월별<input type="radio" id="yearMonth" name ="type" /></td>
		</tr>
	</table>
	<div id="serachEngine">
	
	</div>
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