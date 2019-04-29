<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<c:choose>

<c:when test="${param.rq=='mg' }">
    <form action="GradeDetailReg" method="post">
    <input type="hidden" name="id" value="${dto.id }"/>
    <input type="hidden" name="bnum" value="${dto.bnum }"/>
    <input type="hidden" name="grade" value="${dto.grade }"/>
    <input type="hidden" name="time" value="${dto.time }"/>
    	<table border="">
    		<tr>
    			<td>ID</td>
    			<td>${dto.id }</td>
    		</tr>
    		<tr>
    			<td>사번</td>
    			<td>${dto.bnum }</td>
    		</tr>
    		<tr>
    			<td>요청 등급</td>
    			<td>${dto.grade }</td>
    		</tr>
    		<tr>
    			<td>요청 시간</td>
    			<td>${dto.time }</td>
    		</tr>
    		<tr>
    			<td colspan="2"><input type="submit" value="승인"/></td>
    		</tr>
    	</table>
    </form>

</c:when>

<c:when test="${param.rq=='air' }">
    <form action="GradeDetailReg" method="post">
    <input type="hidden" name="no" value="${dto.no }"/>
    <input type="hidden" name="id" value="${dto.id }"/>
    <input type="hidden" name="crn" value="${dto.crn }"/>
    <input type="hidden" name="air_name" value="${dto.air_name }"/>
    <input type="hidden" name="grade" value="${dto.grade }"/>
    <input type="hidden" name="air_codecom" value="${dto.air_codecom }"/>
    <input type="hidden" name="img" value="${dto.img }"/>
    	<table border="">
    		<tr>
    			<td>요청 등급</td>
    			<td>${dto.grade }</td>
    		</tr>
    		<tr>
    			<td>ID</td>
    			<td>${dto.id }</td>
    		</tr>
    		<tr>
    			<td>사업자 번호</td>
    			<td>${dto.crn }</td>
    		</tr>
    		<tr>
    			<td>항공사 이름</td>
    			<td>${dto.air_name }</td>
    		</tr>
    		<tr>
    			<td>항공사 사진</td>
    			<td><img alt="" src="../img/${dto.img }"> </td>
    		</tr>
    		<tr>
    			<td>요청 시간</td>
    			<td>${dto.time }</td>
    		</tr>
    		<tr>
    			<td colspan="2"><input type="submit" value="승인"/></td>
    		</tr>
    	</table>
    </form>

</c:when>



<c:otherwise>

<form action="GradeDetailReg" method="post">
    <input type="hidden" name="no" value="${dto.no }"/>
    <input type="hidden" name="id" value="${dto.id }"/>
    <input type="hidden" name="crn" value="${dto.crn }"/>
    <input type="hidden" name="hname" value="${dto.hname }"/>
    <input type="hidden" name="country" value="${dto.country }"/>
    <input type="hidden" name="city" value="${dto.city }"/>
    <input type="hidden" name="hinfo" value="${dto.hinfo }"/>
    <input type="hidden" name="grade" value="${dto.grade }"/>
    <input type="hidden" name="himg" value="${dto.himg }"/>
    	<table border="">
    	<tr>
    			<td>요청 등급</td>
    			<td>${dto.grade }</td>
    		</tr>
    		<tr>
    			<td>ID</td>
    			<td>${dto.id }</td>
    		</tr>
    		<tr>
    			<td>사업자 번호</td>
    			<td>${dto.crn }</td>
    		</tr>
    		<tr>
    			<td>호텔 이름</td>
    			<td>${dto.hname }</td>
    		</tr>
    		<tr>
    			<td>호텔 사진</td>
    			<td><img alt="" src="../img/${dto.himg }"></td>
    		</tr>
    		
    		<tr>
    			<td>요청 시간</td>
    			<td>${dto.time }</td>
    		</tr>
    		<tr>
    			<td colspan="2"><input type="submit" value="승인"/></td>
    		</tr>
    	</table>
    </form>

</c:otherwise>
</c:choose>


