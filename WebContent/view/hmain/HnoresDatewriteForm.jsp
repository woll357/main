<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<body onload="calendar()">
<script src="../js/jquery-3.3.1.min.js"></script>   
<script src="../js/yjm/nores_pm.js"></script>
<script src="../js/yjm/nores_cal.js"></script>
<div align="center" style="margin-top: -250px">
<h1 class="stitle">예약불가날짜선정</h1>
	 <input type="hidden" name="rcnt" value="${param.rcnt }" id="hiddenrcnt" /> 
<form class="contable" name="nono" action="HnoresDatewriteReg" method="post">
     <input type="hidden" name="rcode" value="${param.rcode }" />
     
     <table width="100%" border=""  style="text-align: center; border: 10px #dcefef solid;" cellspacing="0">

     	<tr>
     		<td style="border-bottom: 10px #dcefef solid;">날짜선택</td>
     		<!-- <td><input type="date" name="noresdate"/></td> -->
     		<td><input type="text" id="noresdate" name="noresdate" class="noresdate"/></td>
     			<td><div id="ddateCal1"></div></td>  			
     	</tr>
     	
     	<tr>
     		<td colspan="2" style="border-bottom: 10px #dcefef solid;">예약불가갯수</td>
     		<td><input type="number" maxlength="2" oninput="maxLengthCheck(this)"  name="norescnt" value="${dto.rcnt }" id="norescnt"/> </td>
     	</tr>
     	<tr>
     		<td colspan="2" style="border-bottom: 10px #dcefef solid;">사유</td>
     		<td><input type="text" name="reason" id="rs"/></td>
     	</tr>
		<tr>
			<td colspan="3" align="right">
			<input type="button" value="작성" class="nores"/>
			<input type="reset" value="초기화" />
			</td>
		</tr>
     </table>
</form>  
</div>  
</body>
<%-- 		<c:choose>
		<c:when test="${mem.id!=null && mem.id!=''}">
		<td><input type="submit" value="상세조회"/></td>
		</c:when>
		<c:otherwise>
		<td><input type="button" value="상세조회" class="btn"/></td>
		</c:otherwise>
		</c:choose> --%>

