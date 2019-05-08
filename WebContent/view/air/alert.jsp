<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:choose>
<c:when test="${msg!=null }">
<script>
	alert("${msg}");
	location.href = "${goUrl}"; 
</script>
</c:when>
<c:otherwise>
<script>
	location.href = "${goUrl}"; 
</script>
</c:otherwise>
</c:choose>
