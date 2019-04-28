<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%request.setCharacterEncoding("utf-8"); %>
<table>
	<tr>
		<td><a href="/manager/ManagerSellList?bstatus=m">예약내역 조회</a></td>
		<td><a href="/manager/ManagerSellList?bstatus=p">구매내역 조회</a></td>
		<td><a href="/manager/ManagerSellList?bstatus=r">환불내역 조회</a></td>		
	</tr>
</table>