<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="../js/jquery-3.3.1.min.js"></script>
<script src = "../js/nh/centerWriteChk.js"></script>
<h2>자주묻는질문 / 글쓰기</h2>
<form action="FnqWriteReg" method="post" enctype="multipart/form-data" name="frm">
	<table border="" width="100%" cellpadding="5px;" style="border-collapse: collapse; border : 10px #dcefef solid;">
		<tr>
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
				<a href="../greensc/FnqList?center=in">목록으로</a>
			</td>
		</tr>
	</table>
</form>
