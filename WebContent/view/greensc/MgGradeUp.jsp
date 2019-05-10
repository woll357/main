<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="../css/nh/tot.css" type="text/css">

<h2>관리자 등업</h2>
<table style="width: 100%; border : 10px #dcefef solid;" cellspacing="0" cellpadding="5px;">
	<tr>
		<td colspan="5" class="bb" style="border-bottom: 5px #dcefef solid;"><b><br>매니저 등업</b></td>
	</tr>
	<tr>
		<td class="wbbr">요청 번호</td>
		<td class="wbbr">아이디</td>
		<td class="wbbr">요청 등급</td>
		<td class="wbbr">요청 날짜</td>
		<td style="padding-left: 15px;" class="wbb">상세</td>
		</tr>
	<c:forEach var="dto" items="${mgData}" varStatus="no">
		<tr>
		<td class="bbr">${no.index+1 }</td>
		<td class="bbr">${dto.id }</td>
		<td class="bbr">${dto.grade }</td>
		<td class="bbr">${dto.time }</td>
		<td class="bb"><a href="GradeDetail?no=${dto.num }&rq=mg">열람</a></td>
		</tr>
		<tr>
		<td colspan="5"><hr color="#dcefef" size="1px"></td>
		</tr>
	</c:forEach>
	
	<tr>
		<td colspan="5" class="bb" style="border-bottom: 5px #dcefef solid;"><b><br>항공사 등업</b></td>
	</tr>
	
	
	<tr>
		<td class="wbbr">요청 번호</td>
		<td class="wbbr">아이디</td>
		<td class="wbbr">요청 등급</td>
		<td class="wbbr">요청 날짜</td>
		<td style="padding-left: 15px;" class="wbb">상세</td>
		</tr>
		
	<c:forEach var="dto" items="${airData}" varStatus="no">
		<tr>
		<td class="bbr">${no.index+1 }</td>
		<td class="bbr">${dto.id }</td>
		<td class="bbr">${dto.grade }</td>
		<td class="bbr">${dto.time }</td>
		<td class="bb"><a href="GradeDetail?no=${dto.no }&rq=air">열람</a></td>
		</tr>
		<tr>
		<td colspan="5"><hr color="#dcefef" size="1px"></td>
		</tr>
	</c:forEach>
	
	
	<tr>
		<td colspan="5" class="bb" style="border-bottom: 5px #dcefef solid;"><b><br>호텔사 등업</b></td>
	</tr>
	
	<tr>
		<td class="wbbr">요청 번호</td>
		<td class="wbbr">아이디</td>
		<td class="wbbr" >요청 등급</td>
		<td class="wbbr">요청 날짜</td>
		<td style="padding-left: 15px;" class="wbb">상세</td>
		</tr>
	<c:forEach var="dto" items="${hotData}" varStatus="no">
		<tr>
		<td class="bbr">${no.index+1 }</td>
		<td class="bbr">${dto.id }</td>
		<td class="bbr">${dto.grade }</td>
		<td class="bbr">${dto.time }</td>
		<td class="bb"><a href="GradeDetail?no=${dto.no }&rq=hot" style="text-align: left;">열람</a></td>
		</tr>
		
	</c:forEach>
	
</table>
