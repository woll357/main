<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="../css/nh/tot.css" type="text/css">
<body onload="calendar()">
<script src="../js/jquery-3.3.1.min.js"></script>   
<script src="../js/yjm/nores_pm.js"></script>
<script src="../js/yjm/nores_cal.js"></script>

<h2 >예약불가날짜선정</h2>
	  
<form  name="nono" action="HnoresDatewriteReg" method="post">
	 <input type="hidden" name="rcnt" value="${param.rcnt }" id="hiddenrcnt" />
     <input type="hidden" name="rcode" value="${param.rcode }" />     
     <table  class="ttcss" border="" style="text-align: center;">

     	<tr>
     		<td width="333px" class="wbbr">날짜선택</td>
     		<!-- <td><input type="date" name="noresdate"/></td> -->
     		<td width="333px" ><input type="text" id="noresdate" name="noresdate" class="noresdate"/></td>
     			<td width="333px" style="text-align: center;" ><div id="ddateCal1" style="margin-left: 85px;"></div></td>  			
     	</tr>
     	
     	<tr>
     		<td  class="wbbr">예약불가갯수</td>
     		<td colspan="2"><input type="number" maxlength="2" oninput="maxLengthCheck(this)"  name="norescnt" value="${dto.rcnt }" id="norescnt"/> </td>
     	</tr>
     	<tr>
     		<td class="wbbr">사유</td>
     		<td colspan="2" ><input type="text" name="reason" id="rs"/></td>
     	</tr>
		<tr>
			<td colspan="3" align="right">
			<input type="button" style="background-color: #dcefef; font-size: 20px; color: #779191 ; border: 0;" value="작성" class="nores"/>
			<input type="reset" style="background-color: #dcefef; font-size: 20px; color: #779191 ; border: 0;" value="초기화" />
			</td>
		</tr>
     </table>
</form>  

</body>
<%-- 		<c:choose>
		<c:when test="${mem.id!=null && mem.id!=''}">
		<td><input type="submit" value="상세조회"/></td>
		</c:when>
		<c:otherwise>
		<td><input type="button" value="상세조회" class="btn"/></td>
		</c:otherwise>
		</c:choose> --%>

