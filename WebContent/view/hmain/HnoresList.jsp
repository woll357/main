<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <div align="center" style="margin-top: -250px">
<h1>예약불가목록</h1>
    
    <c:choose>

		<c:when test="${data.size()==0 }">
			<h2>조회된 결과가 없습니다.</h2>
		</c:when>
	</c:choose>
    
    
    <c:forEach var="data" items="${data }" varStatus="no">
    
    <table border="" width="100%" style="text-align: center;">
    	<tr>
    		<td>날짜</td>
    		<td>예약불가갯수</td>
    		<td>사유</td>
    		<td>삭제</td>
    	</tr>
    	<tr>
    		<td>${data.noresdate }</td>
    		<td>${data.norescnt }</td>
    		<td>${data.reason }</td> 
    		<td><a href="HnoresListDelete?no=${data.no }">삭제</a></td>
    	</tr>    
    </table>
    </c:forEach>
</div>
