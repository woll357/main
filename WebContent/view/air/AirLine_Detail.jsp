<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" href="../css/dk/input.css" type="text/css">

<link rel="stylesheet" href="../css/nh/tot.css" type="text/css">

<h2>항공사 정보</h2>

<form action="AirLine_Modify?id=${mem.id }" method="post" enctype="multipart/form-data">
	<input type="hidden" name="id" value="${mem.id }">
<table border="" class="ttcss">
		<tr>
			<td class="wbbr" width="200" >이미지</td>
			<td class="wbbr">사업자등록증</td>
			<td class="wbbr">회사명</td>
		</tr>
		<tr>
			<td ><img alt=""src="../img/${dto.img }" ></td>
			<td>${dto.crn }</td>
			<td>${dto.air_name }</td>
		</tr>
		<tr align="right" >
		<td colspan="3"><input type="submit" class="btncss" value="수정">
		<a href="AirLine_Delete?air_code=${mem.air_code }&id=${mem.id }&aotcont=in"><input type="button" class="btncss" value="삭제"></a></td>
		</tr>
	</table>
</form>
