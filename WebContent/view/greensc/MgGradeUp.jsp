<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="../css/nh/centerList.css" type="text/css">

<div id="back">
<table style="width: 100%; border : 10px #dcefef solid;" cellspacing="0">
	<tr>
		<td colspan="5" class="ggtitle">관리자 등업</td>
	</tr>
	<tr>
		<td colspan="5"><hr color="#dcefef" size="3px"></td>
	</tr>
	<tr>
		<td class="ggList">요청 번호</td>
		<td class="ggList">아이디</td>
		<td class="ggList">요청 등급</td>
		<td class="ggList">요청 날짜</td>
		<td class="ggList">상세</td>
		</tr>
	<c:forEach var="dto" items="${mgData}" varStatus="no">
		<tr>
		<td class="ggList">${no.index+1 }</td>
		<td class="ggList">${dto.id }</td>
		<td class="ggList">${dto.grade }</td>
		<td class="ggList">${dto.time }</td>
		<td class="ggList"><a href="GradeDetail?no=${dto.num }&rq=mg">열람</a></td>
		</tr>
		<tr>
		<td colspan="5"><hr color="#dcefef" size="1px"></td>
		</tr>
	</c:forEach>
	
	<tr>
		<td colspan="5" class="ggtitle">항공 등업</td>
	</tr>
	<tr>
		<td colspan="5"><hr color="#dcefef" size="3px"></td>
	</tr>
	
	<tr>
		<td class="ggList">요청 번호</td>
		<td class="ggList">아이디</td>
		<td class="ggList">요청 등급</td>
		<td class="ggList">요청 날짜</td>
		<td class="ggList">상세</td>
		</tr>
		
	<c:forEach var="dto" items="${airData}" varStatus="no">
		<tr>
		<td class="ggList">${no.index+1 }</td>
		<td class="ggList">${dto.id }</td>
		<td class="ggList">${dto.grade }</td>
		<td class="ggList">${dto.time }</td>
		<td class="ggList"><a href="GradeDetail?no=${dto.no }&rq=air">열람</a></td>
		</tr>
		<tr>
		<td colspan="5"><hr color="#dcefef" size="1px"></td>
		</tr>
	</c:forEach>
	
	
	<tr>
		<td colspan="5" class="ggtitle">호텔 등업</td>
	</tr>
	<tr>
		<td colspan="5"><hr color="#dcefef" size="3px"></td>
	</tr>
	<tr>
		<td class="ggList">요청 번호</td>
		<td class="ggList">아이디</td>
		<td class="ggList">요청 등급</td>
		<td class="ggList">요청 날짜</td>
		<td class="ggList">상세</td>
		</tr>
	<c:forEach var="dto" items="${hotData}" varStatus="no">
		<tr>
		<td class="ggList">${no.index+1 }</td>
		<td class="ggList">${dto.id }</td>
		<td class="ggList">${dto.grade }</td>
		<td class="ggList">${dto.time }</td>
		<td class="ggList"><a href="GradeDetail?no=${dto.no }&rq=hot">열람</a></td>
		</tr>
		<tr>
		<td colspan="5"><hr color="#dcefef" size="1px"></td>
		</tr>
	</c:forEach>
	
</table>
</div>