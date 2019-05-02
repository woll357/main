<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:choose>

<c:when test="${msg=='중복'}">중</c:when>
<c:when test="${msg=='환불'}">환</c:when>
<c:otherwise>승</c:otherwise>

</c:choose>