<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1 align="left">예약불가목록</h1>
    
    <c:choose>

		<c:when test="${data.size()==0 }">
			<h2>조회된 결과가 없습니다.</h2>
		</c:when>
	</c:choose>
    
      <table  width="100%" border=""  style="text-align: center; border: 10px #dcefef solid;" cellspacing="0">  
          	<tr>
    		<td>날짜</td>
    		<td>예약불가갯수</td>
    		<td>사유</td>
    		<td>삭제</td>
    	</tr>    
    <c:forEach var="data" items="${data }" varStatus="no">
    	<tr>
    		<td>${data.noresdate }</td>
    		<td>${data.norescnt }</td>
    		<td>${data.reason }</td> 
    		<td><a href="HnoresListDelete?no=${data.no }">삭제</a></td>
    	</tr>    

    </c:forEach>
        </table>

