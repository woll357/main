<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${mem.grade=='M' }">
<table border="">
<tr>
<td>회원 관리</td>
<td>공지 등록</td>
<td>자주 묻는 질문 등록</td>
<td>Q&A 답변</td>
</tr>
</table>
</c:if>

<c:if test="${param.mypage=='in'}">
<table border="">
<tr>
<td><a href="ModifyMem?mypage=in">회원 정보 수정</a></td>
<td>탈퇴 신청</td>
<td>구매 정보</td>
<td>등업 신청</td>
</tr>
</table>
</c:if>

<c:if test="${param.mgpage=='in'}">
<table border="">
<tr>
<td><a href="MgPage?mgpage=in">회원 검색</a></td>
<td>탈퇴 신청</td>
<td>구매 정보</td>
<td><a href="MgGradeUp?mgpage=in">등업 관리</a></td>
</tr>
</table>
</c:if>