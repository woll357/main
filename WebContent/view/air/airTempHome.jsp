<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script src="../js/jquery-3.3.1.min.js"></script> 
<script>

$(document).ready(function(){
	
	$('#grade').on({
		'click':function(){
			var cc=$('#grade').val();
			if(cc=="M"){
				$('#bnum').html('사번');
				$('#num').attr('name','bnum');
				$('#hh').html('');
				$('#hhtxt').html('');
				$('#img').attr('name','img');
				$('#bname').attr('name','air_name');
			}else if(cc=="A"){
				$('#bnum').html('사업자등록번호');
				$('#num').attr('name','crn');
				$('#img').attr('name','img');
				$('#bname').attr('name','air_name');
			}else{
				$('#bnum').html('사업자등록번호');
				$('#num').attr('name','crn');
				$('#hh').html('상세정보');
				$('#hhtxt').html('<input type="text" name="hinfo"/>')
				$('#img').attr('name','himg');
				$('#bname').attr('name','hname');
			}
		}
	})
	
})

</script>  
<body>
<h1>등업신청</h1>
<form action="airTempHomeReg" method="post" enctype="multipart/form-data">
<input type="hidden" value="$('#grade').val()" name='grade'/>

	<table border="">
	
		<tr>
			<td align="center">회원등급</td>
				<td>
				<select name="grade" id="grade">                                   <!-- select 콤보박스 같은거 -->
				<option value="A">A</option>
				<option value="H">H</option>
				<option value="M" >M</option> <!-- selected 미리 선택되어있게 -->
				</select>
			</td>
		</tr>
		<tr>
			<td>id</td>
			<td><input type="text" name="id" /></td>
		</tr>
		<tr>
			<td id="bnum">사업자등록번호</td>
			<td><input type="text" name="crn" id="num"/></td>
		</tr>
		<tr>
			<td>파일</td>
			<td><input type="file" name="img" id="img"/></td>
		</tr>
		<tr>
			<td>회사명</td>
			<td><input type="text" name="air_name" id="bname"/></td>
		</tr>
		<tr>
			<td id="hh"></td>
			<td id="hhtxt"></td>
		
		</tr>
		
			<tr>
				<td colspan="2" align="right">
				<input type="submit" value="작성" />
				<input type="reset" value="초기화" />
				</td>
			</tr>
	</table>
</form>
</body>
</html>