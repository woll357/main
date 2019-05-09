<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<table border="" style="width: 100%; border : 10px #dcefef solid;" cellspacing="0">
<input type="hidden" name= "aotcont"  value="in"/>
<input type="hidden" value="${param.air_code }" name="air_code" />
<input type="hidden" value="${param.air_p}" name="air_p" />

	<tr>
		<td style="background: #D4F4FA">항공편코드</td>
		<td style="background: #D4F4FA">출발지</td>
		<td style="background: #D4F4FA">도착지</td>
	</tr>

<c:forEach var="dto" items="${data}" varStatus="no">	
	<tr>
	<td><a href="Airp_List2?air_p=${dto.air_p }&air_code=${mem.air_code }&aotcont=in">${dto.air_p }</a></td>	
		<td>${dto.darea }</td>
		<td>${dto.carea }</td>
		
	</tr>
	</c:forEach>
	</table>
</body>
</html>