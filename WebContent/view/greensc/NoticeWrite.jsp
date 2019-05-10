<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="../js/jquery-3.3.1.min.js"></script>
<script src = "../js/nh/centerWriteChk.js"></script> 
<link rel="stylesheet" href="../css/nh/tot.css" type="text/css">     

<h2>공지사항 / 글쓰기</h2>
<form action="NoticeWriteReg" method="post" enctype="multipart/form-data" name="frm">
	<table class="ttcss" cellpadding="5px;" cellspacing="0" border="">   

		<tr>
			<td class="wbbr">제목</td>
			<td><input type="text" name="title" id="title"/></td>
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
				<a href="NoticeList?center=in">목록으로</a>
			</td>
		</tr>
	</table>
</form>

