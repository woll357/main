<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:choose>
<c:when test="${msg=='아이디' }">아이디가 이미 존재합니다.</c:when>
<c:when test="${msg=='핸드폰' }">핸드폰 번호가 이미 존재합니다.</c:when>
<c:when test="${msg1=='id체크'}">완료1</c:when>
<c:when test="${msg2=='pp체크'}">완료2</c:when>
</c:choose>