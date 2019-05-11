<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<c:choose>
<c:when test="${pdto.cComName!=null }">  
<script src="../js/hsj/recentPayment.js"></script>


 <table class="ttcss" border = "">
		<tr>
			<td class="wbbr" >최근 이용 카드</td>
			<td colspan="4" class="wbbr"><input id="check" type="checkbox"  checked="checked" disabled="disabled" /></td>
		</tr>
		
		<tr>
			<td class="wbbr">카드선택</td>
			<td colspan="4" class="wbbr" align="left">
			<input style="width:51px" id="cComName" name="cComName" type="text" value="${pdto.cComName }" readonly="readonly" /></td>
		</tr>
		<tr>
			<td class="wbbr">카드번호</td>
			<td class="wbbr"><input style="width: 50px" readonly="readonly" type="text" maxlength="4" name="cNum1" value="${pdto.cNum1 }"/></td>
			<td class="wbbr"><input style="width: 50px" readonly="readonly" type="text" maxlength="4" name="cNum2" value="${pdto.cNum2 }"/></td>
			<td class="wbbr"><input style="width: 50px" readonly="readonly" type="text" maxlength="4" name="cNum3" value="${pdto.cNum3 }"/></td>
			<td class="wbbr"><input style="width: 50px" readonly="readonly" type="text" maxlength="4" name="cNum4" value="${pdto.cNum4 }"/></td>
		</tr>
		<tr>
			<td class="wbbr">유효기간</td>
			<td class="wbbr" colspan="2" style="width:100px"><input style="width:100px" readonly="readonly" type="text" maxlength="4" name="exDateMonth" value="${pdto.exDateMonth }"/></td>
			<td class="wbbr" colspan="2" style="width:100px"><input style="width:100px" readonly="readonly" type="text" maxlength="4" name="exDateYear" value="${pdto.exDateYear }"/></td>
		</tr>
		<tr>
			<td class="wbbr">cvc</td>
			<td class="wbbr" colspan="4" ><input style="width: 50px" readonly="readonly" type="text" maxlength="4" name="cvc" value="${pdto.cvc }"/></td>
		</tr>
		<tr>
			<td class="wbbr">카드비밀번호</td>
			<td class="wbb"><input style="width: 50px" type="password" maxlength="2" id="pw" name="pw" /></td><td class="wbbr" colspan="3">**</td>
		</tr>
		</table>
</c:when>
<c:otherwise>
${msg }
</c:otherwise>
</c:choose>
