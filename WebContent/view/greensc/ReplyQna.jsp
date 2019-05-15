<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<script src="../js/jquery-3.3.1.min.js"></script>
<script src = "../js/nh/centerWriteChk.js"></script>     
<link rel="stylesheet" href="../css/nh/tot.css" type="text/css">

<h2>Q&A 답변하기</h2>
<table class="ttcss" border="" cellpadding="5px">
	<tr><td colspan="2">회원 문의</td>
	</tr><tr>
		<td style="width: 200px;" class="wbbr">글번호</td><td>${param.no }</td>
	</tr><tr>
		<td class="wbbr">제목</td><td>${dto.title }</td>
	</tr><tr>
		<td class="wbbr">작성자</td><td>${dto.id }</td>
	</tr><tr>
		<td class="wbbr">작성일</td><td>${dto.time }</td>
	</tr><tr>
		<td class="wbbr">내용</td><td><c:if test="${dto.img!=null}"><img alt="" src="../img/${dto.img}"></c:if>${dto.contentBr }</td>
	</tr>
</table>



<form action="ReplyQnaWriteReg" method="post" enctype="multipart/form-data" name="frm">
	<input type="hidden" name="num" value="${dto.num }"/>
	<input type="hidden" name="qnum" value="${dto.num }"/>
	<input type="hidden" name="no" value="${param.no}"/>
	<table class="ttcss" cellpadding="5px;" cellspacing="0" border="">
	<tr><td colspan="2">답변 내용</td>
	</tr><tr>
			<td style="width: 200px;" class="wbbr">제목</td>
			<td><input type="text" name="title" id="title" width="100%"/></td>
		</tr>
		<tr>
			<td class="wbbr">이미지 업로드</td>
			<td><input type="file" name="img" id="img"/></td>
		</tr>
		<tr>
			<td class="wbbr">내용</td>
			<td><textarea name="content" cols="50" rows="20" id="content"></textarea></td>
		</tr>
		<tr>
			<td colspan="2" align="right">
				<input type="button" value="작성" id="btn" class="btncss"/>
				<input type="reset" value="초기화" class="btncss"/>
				<a href="QnaList?center=in">목록으로</a>
			</td>
		</tr>
	</table>
 </form>   