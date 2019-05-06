<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="../css/nh/centerList.css" type="text/css">


<div id="back">
<table border="" width="100%" cellpadding="5px;" style="border : 10px #dcefef solid;">
	<tr>
		<td class="listDetail" id="listDetail">글번호</td><td class="listDetail">${dto.num }</td>
	</tr><tr>
		<td class="listDetail">제목</td><td class="listDetail">${dto.title }</td>
	</tr><tr>
		<td class="listDetail">작성자</td>
		<c:choose>
			<c:when test="${mem.grade=='M' }"><td class="listDetail">${dto.id }</td></c:when>
			<c:otherwise><td class="listDetail">운영자</td></c:otherwise>
		</c:choose>
	</tr><tr>
		<td class="listDetail">작성일</td><td class="listDetail">${dto.time }</td>
	</tr><tr>
		<td class="listDetail">조회수</td><td class="listDetail">${dto.view }</td>
	</tr><tr>
		<td class="listDetail">내용</td>
		<td class="listDetail">
		<c:if test="${dto.img!=null}"><img alt="" src="../img/${dto.img}"><br></c:if>
		
		${dto.contentBr }</td>
	</tr><tr>
		<td colspan="2" align="right">
			<a href="../greensc/NoticeList?center=in">목록으로</a>
			
		</td>
	</tr>
</table>
</div>