<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script src="../js/jquery-3.3.1.min.js"></script>

<script>

var chk1=false;
var chk2=false;
var chk3=false;
var msg="공란 확인";

$(document).ready(function(){
	
	 
	   $('#btn1').on({
	      'click':function(){
	    	  if(chk1){
	    	  dataGet("../greenAjax/Find?id="+$('#id').val()+"&black="+"black");
	    	  $('#id').val("");
	    	  $('#phone').val("");
	    	  $('#name').val("");
	    	  }else{
	    		  alert(msg);
	    	  }
	      }
	   });
	   $('#btn2').on({
		      'click':function(){
		    	  if(chk2){
		    	  dataGet("../greenAjax/Find?pname="+$('#name').val()+"&black="+"black");
		    	  $('#id').val("");
		    	  $('#phone').val("");
		    	  $('#name').val("");
		    	  }else{
		    		  alert(msg);
		    	  }
		      }
		   });
	   $('#btn3').on({
		      'click':function(){
		    	  if(chk3){
		    	  dataGet("../greenAjax/Find?phone="+$('#phone').val()+"&black="+"black");
		    	  $('#id').val("");
		    	  $('#phone').val("");
		    	  $('#name').val("");
		    	  }else{
		    		  alert(msg);
		    	  }
		      }
		   });
	   $('#btn4').on({
		      'click':function(){
		    	  console.log($('#preason').val());
		    	  dataGet("../greenAjax/Find?preason="+$('#preason').val()+"&black="+"black");
		    	  $('#id').val("");
		    	  $('#phone').val("");
		    	  $('#name').val("");
		    	  
		      }
		   });
	   
	   
	function dataGet(url){
		$.ajax(url,
                {
                   success:function(dd){	                       
                	   alert("??");
                      
                   },
                   error:function(){
                      alert("실패다 실패");
                   },
                }
             );
	}
	
	

	
	
})


		function chkPat1(){
		
		var numPat = /^\d*$/;
		var korPat = /^[가-힣]*$/;
		var spPat = /[+.!@#$%^&*-]/;
		var engPat = /^[A-Za-z]*$/;
		var emailPat = /(\w+)[.](\w+)$/
		var idPat =/^[0-9A-Za-z]*$/;
		
		
		if(idPat.test($('#id').val()) && $('#id').val().length>3){
			
			
			chk1=true;
		}else{
			chk1=false;
			msg = "id 확인 부탁드립니다.";
			
		}
		
	}

function chkPat2(){
	
	var numPat = /^\d*$/;
	var korPat = /^[가-힣]*$/;
	var spPat = /[+.!@#$%^&*-]/;
	var engPat = /^[A-Za-z]*$/;
	var emailPat = /(\w+)[.](\w+)$/
	var idPat =/^[0-9A-Za-z]*$/;
	
		
	if(korPat.test($('#name').val()) && $('#name').val().length>0){
		
		chk2=true;
	}else{
		chk2=false;
		msg = "이름 확인 부탁드립니다.";
		
	}
	
}

function chkPat3(){
	
	var numPat = /^\d*$/;
	var korPat = /^[가-힣]*$/;
	var spPat = /[+.!@#$%^&*-]/;
	var engPat = /^[A-Za-z]*$/;
	var emailPat = /(\w+)[.](\w+)$/
	var idPat =/^[0-9A-Za-z]*$/;
	
	if(numPat.test($('#phone').val()) && $('#phone').val().length>3){	
		chk3=true;
	}else{
		chk3=false;
		msg = "연락처 확인 부탁드립니다.";
		
	}
	
}
</script>


<table border="">
	<tr>
		<td id="searchId">블랙리스트 검색</td>
		<td id="searchNum">블랙리스트 회원 총 수 : ${memNum }</td>
	</tr>
	<tr>
		<td colspan="2">
			<table style="width: 100%">
				<tr>
					<td>아이디 검색</td>
					<td><input type="text" id="id" maxlength="8"
						onkeyup="chkPat1()" /></td>
					<td><input type="button" value="검색" id="btn1" /></td>
				</tr>
				<tr>
					<td>이름 검색</td>
					<td><input type="text" id="name" onkeyup="chkPat2()" /></td>
					<td><input type="button" value="검색" id="btn2" /></td>
				</tr>
				<tr>
					<td>핸드폰 뒷자리 검색</td>
					<td><input type="text" id="phone" maxlength="4"
						onkeyup="chkPat3()" /></td>
					<td><input type="button" value="검색" id="btn3" /></td>
				</tr>
				<tr>
					<td>블랙리스트 사유검색</td>
					<td><select name="preason" id="preason">
							<option value="강성고객">강성고객</option>
							<option value="경범죄">경범죄</option>
							<option value="중범죄">중범죄</option>
					</select></td>
					<td><input type="button" value="검색" id="btn4" /></td>
				</tr>
			</table>
		</td>
	</tr>

	<tr>
		<td colspan="2">회원 검색 결과</td>

	</tr>
	<tr>
		<td colspan="3">
			<table>
				<tr>
					<td>번호</td>
					<td>아이디</td>
					<td>이름</td>
					<td>핸드폰 번호</td>
					<td>블랙리스트 여부</td>
					<td>블랙리스트 사유</td>
					<td>상세보기</td>
				</tr>
			</table>

		</td>
	</tr>
	<tr>
		<td colspan="3" id="contents"></td>
	</tr>
</table>