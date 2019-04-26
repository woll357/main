<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h3>예약불가목록</h3>
    
    <c:forEach var="data" items="${data }" varStatus="no">
    <table border="" width="100%">
    	<tr>
    		<td>날짜</td>
    		<td>예약불가갯수</td>
    		<td>사유</td>
    	</tr>
    	<tr>
    		<td>${data.noresdate }</td>
    		<td>${data.norescnt }</td>
    		<td>${data.reason }</td> 
    	</tr>    
    </table>
    </c:forEach>

