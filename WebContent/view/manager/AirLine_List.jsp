<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<body>
<table border="" style="width: 100%; border : 10px #dcefef solid;" cellspacing="0">
   <tr>
      <td style="background: #D4F4FA" width="250" ></td>
      <td style="background: #D4F4FA" >항공사 코드</td>
      <td style="background: #D4F4FA" >아아디</td>
      <td style="background: #D4F4FA" >사업자등록번호</td>
      <td style="background: #D4F4FA"  colspan="2">회사이름</td>
   </tr>
   <c:forEach var="dto" items="${data }" varStatus="no">
   <tr>
      <td><img src="../img/${dto.img }" width="250px" height="100px"></td>
      <td>${dto.air_code }</td>
      <td>${dto.id }</td>
      <td>${dto.crn }</td>
      <td>${dto.air_name }</td>
      <td><a href="AirLine_Delete?air_code=${dto.air_code }&id=${dto.id }&partner=in"><input type="button" value="삭제"></a></td>
   </tr>
   </c:forEach>
</table>
</body>
</html>