<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<form action="HnoresDatewriteReg" method="post">
     <input type="hidden" name="rcode" value="${param.rcode }" />
     
     <table border="">
     	<tr>
     		<td>날짜선택</td>
     		<td><input type="date" name="noresdate"/></td>
     	</tr>
     	<tr>
     		<td>예약불가갯수</td>
     		<td><input type="number" name="norescnt" /> </td>
     	</tr>
     	<tr>
     		<td>사유</td>
     		<td><input type="text" name="reason" /></td>
     	</tr>
		<tr>
			<td colspan="2" align="right">
			<input type="submit" value="작성" />
			<input type="reset" value="초기화" />
			</td>
		</tr>
     </table>
</form>    