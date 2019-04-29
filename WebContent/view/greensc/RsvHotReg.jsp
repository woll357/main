<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	
    
    

    	<table>
    		<tr>
    			<td>체크인 :</td>
    			<td><input type="text" readonly="readonly" value="${param.startDay }"/></td>
    			<td>체크 아웃 :</td>
    			<td><input type="text" readonly="readonly" value="${param.endDay }"/></td>
    		</tr>
    	</table>

    <table border="">
    <tr>
    <td colspan="2">국가</td>
    <td>도시</td>
    <td>호텔이름</td>
    <td>방 등급</td>
    <td>간단정보</td>
    <td>상세</td>
    </tr>
    
    <c:forEach var="dto" items="${dto}" varStatus="no">
		<tr>
		
		<td>${no.index+1 }</td>
		<td>${dto.country }</td>
		<td>${dto.city }</td>
		<td>
		<img alt="" src="../img/${dto.himg }">
		 ${dto.hname }</td>
		<td>${dto.rkind }</td>
		<td>${dto.hinfo }</td>

		<c:choose>
		<c:when test="${mem.id!=null && mem.id!=''}">
		<td><a href="Hdetail?hcode=${dto.hcode }&startDay=${param.startDay }&endDay=${param.endDay }">상세조회</a></td>
		</c:when>
		<c:otherwise>
		<td><input type="button" value="상세조회" class="btn"/></td>
		</c:otherwise>
		</c:choose>
		
		
		</tr>
		
		</c:forEach>
    
    
    </table>
    
    <script>

$(document).ready(function(){
	
	$('.btn').on({
		'click':function(){
			alert("로그인 하세요");
		}
		
	})

})



</script>