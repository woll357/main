<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="../css/dk/input.css" type="text/css">

<link rel="stylesheet" href="../css/nh/tot.css" type="text/css">

<script src="../js/odk/AirLine_Modify.js"></script>
<h2>항공사 수정</h2>
<form name="airmod" action="AirLine_ModifyFm" method="post"  enctype="multipart/form-data">
<table border="" style="width: 100%; border : 10px #dcefef solid;" cellspacing="0">
	<input type="hidden" name="id" value="${mem.id }">
	
	<tr>
		
		<td>사업자등록증</td><td><input readonly="readonly" type="text" name="crn" value="${dto.crn }"></td>
	</tr>
	<tr>
		<td>회사명</td><td><input readonly="readonly" type="text" name="air_name" value="${dto.air_name }"></td>
	</tr>
	<tr>
	<td rowspan="2">이미지</td>
	<td>
		<c:choose>
		<c:when test="${dto.img!='' }">${dto.img }<input type="button" value="파일삭제" onclick="fileDelete()"/>		
			<input type="hidden" name="img" value="${dto.img }">
		</c:when>
		<c:otherwise>
			<input type="file" name="img" id="img">
		</c:otherwise>
		</c:choose>		
		</td>
	</tr>
	<tr>
		
		<td><img alt=""src="../img/${dto.img }" width="200px" height="200px"></td>
	
	</tr>
	<tr align="right">
	<td colspan="3"><input type="button" class="airmodimodi"  value="수정" ></td>
	</tr>
	</table>
	</form>
