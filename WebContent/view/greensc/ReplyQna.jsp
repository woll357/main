<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<script src="../js/jquery-3.3.1.min.js"></script>
<script src = "../js/nh/centerWriteChk.js"></script>     
    <link rel="stylesheet" href="../css/nh/centerList.css" type="text/css">
 
<table border="" width="100%" cellpadding="5px;" style="border : 10px #dcefef solid;">
	<tr><td colspan="2">회원 문의</td>
	</tr><tr>
		<td>글번호</td><td>${dto.num }</td>
	</tr><tr>
		<td>제목</td><td>${dto.title }</td>
	</tr><tr>
		<td>작성자</td><td>${dto.id }</td>
	</tr><tr>
		<td>작성일</td><td>${dto.time }</td>
	</tr><tr>
		<td>내용</td><td><c:if test="${dto.img!=null}"><img alt="" src="../img/${dto.img}"></c:if>${dto.contentBr }</td>
	</tr>
</table>



<form action="ReplyQnaWriteReg" method="post" enctype="multipart/form-data" name="frm">
	<input type="hidden" name="num" value="${dto.num }"/>
	<input type="hidden" name="qnum" value="${dto.num }"/>
	<table border="" width="100%" cellpadding="5px;" style="border : 10px #dcefef solid;">
	<tr><td colspan="2">답변 내용</td>
	</tr><tr>
			<td>제목</td>
			<td><input type="text" name="title" id="title"/></td>
		</tr>
		<tr>
			<td>이미지 업로드</td>
			<td><input type="file" name="img" id="img"/></td>
		</tr>
		<tr>
			<td>내용</td>
			<td><textarea name="content" cols="30" rows="5" id="content">남기실 말</textarea></td>
		</tr>
		<tr>
			<td colspan="2" align="right">
				<input type="button" value="작성" id="btn"/>
				<input type="reset" value="초기화" />
				<a href="QnaList?center=in">목록으로</a>
			</td>
		</tr>
	</table>
 </form>   