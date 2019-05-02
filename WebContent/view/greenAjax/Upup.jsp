<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="../js/jquery-3.3.1.min.js"></script>
<script>
	var no=0;
	var chk = false;
	var chk1=false;
	var chk2=false;
	var chk3=false;
	var chk4=false;
	var chk5=false;
	var chk6=false;
	var chk7=false;
	var chkBnum=false;
	var chkAcrn=false;
	var chkHcrn=false;
	
	var ppchk=false;
	var msg = "공란";
	$(document).ready(function(){
		  
		$('#subBtn').on({
			'click':function(){
				
				if(chk){
					frm.submit();
				}else{
					if("${param.grade}"=="M"){
						chkPat2();
         		   }else if("${param.grade}"=="H"){
         			  chkPat();
         		   }else if("${param.grade}"=="A"){
         			  chkPat();
         		   }
					if(msg=="공란"){
						msg="정보를 모두 입력 부탁드립니다."
							alert(msg);
					}else{
						alert(msg);
					}
					
					
				}
			}
			
		})
		
		 $('#bBtn').on({
		      'click':function(){
		    	  if(chk1){
		    	  dataGet("../greenAjax/UpupChk?bnum="+$('#bnum').val()+"&grade=M");
		    	  
		    	  }else{
		    		  alert(msg);
		    	  }
		      }
		   });
		   $('#aBtn').on({
			      'click':function(){
			    	  console.log(chk7);
			    	  if(chk7){
			    	  dataGet("../greenAjax/UpupChk?crn="+$('#crn').val()+"&grade=A");
			    	
			    	  }else{
			    		  alert(msg);
			    	  }
			      }
			   });
		   $('#hBtn').on({
			      'click':function(){
			    	  if(chk7){
			    	  dataGet("../greenAjax/UpupChk?crn="+$('#crn').val()+"&grade=H");
			    	
			    	  }else{
			    		  alert(msg);
			    	  }
			      }
			   });
		   function dataGet(url){
				$.ajax(url,
		                {
		                   success:function(dd){	                       
		                	   if(dd.trim()=="중"){
		                		   alert("이미 신청하셨습니다.");
		                	   }else if(dd.trim()=="환"){
		                		   alert("관계자는 예약할 수 없습니다. 환불하여주세요.");
		                	   }else if(dd.trim()=="승"){
		                		   alert("사용 가능합니다.");
		                		   if("${param.grade}"=="M" && chk1 && chkBnum){
		                			   chk=true;
		                		   }else{
		                			   chk=false;
		                		   } 
		                		   if("${param.grade}"=="M"){
		                			   chkBnum=true;
		                			   if(chk1){
		                				   chk=true;
		                			   }
		                		   }else if("${param.grade}"=="H"){
										chkHcrn=true;
		                		   }else if("${param.grade}"=="A"){
										chkAcrn=true;
										console.log(chkAcrn);
		                		   }
		                	   }
		                      
		                   },
		                   error:function(){
		                      alert("실패다 실패");
		                   },
		                }
		             );
			}

		
	});
	
	function chkPat(){
		
		var numPat = /^\d*$/;
		var korPat = /^[가-힣]*$/;
		var crnPat = /^\d{3}-\d{2}-\d{5}$/;
		var perPat = /^\d.\d{1}$/;
		var engPat = /^[A-Z]*$/;
		var imgPat = /img|bmp|jpeg|jpg|gif|png$/i;
		var bnumPat = /^[A-Z]{1}[0-9]{6}/;
		
	
		
		
		if(perPat.test($('#salesPercent').val()) && $('#salesPercent').val()>0 && $('#salesPercent').val()<=100){
			
			 chk2=true;

		}else{
			
			chk2=false;
			msg = "수익률 확인 부탁드립니다.";
		
			}
		if(engPat.test($('#info').val()) && $('#info').val().length==2){
			
			 chk3=true;

		}else{
			
			chk3=false;
			msg = "정보 확인 부탁드립니다.";
		
			}
		
		if($('#hinfo').val()!="남기실 말"){
			
			 chk4=true;

		}else{
			
			chk4=false;
			msg = "정보 확인 부탁드립니다.";
		
			}
		if(korPat.test($('#name').val()) && $('#name').val().length>0){
			
			 chk5=true;

		}else{
			
			chk5=false;
			msg = "사업자 이름 확인 부탁드립니다.";
		
			}
		if(imgPat.test($('#img').val().substring($('#img').val().lastIndexOf('.')+1,$('#img').val().length)) ){
			
			 chk6=true;

		}else{
			
			chk6=false;
			msg = "이미지 확인 부탁드립니다.";
		
			}
		if(crnPat.test($('#crn').val()) ){
			
			
			chk7=true;

		}else{
			chkAcrn=false;
			chkHcrn=false;
			chk7=false;
			msg = "사업자 번호 확인 부탁드립니다.";
		
			}
		
			if("${param.grade}"=="A" && chk2 && chk3 && chk7 && chk5 && chk6 && chkAcrn){
				chk=true;
		   }else if("${param.grade}"=="H" && chk2 && chk7 && chk4 && chk5 && chk6 && chkHcrn){
			   chk=true;
		   }else{
			   chk=false;
		   }
			
			
		
		}
	
	
function chkPat2(){
		
		var numPat = /^\d*$/;
		var korPat = /^[가-힣]*$/;
		var crnPat = /^\d{3}-\d{2}-\d{5}$/;
		var perPat = /^\d.\d{1}$/;
		var engPat = /^[A-Z]*$/;
		var imgPat = /[img|bmp|jpeg|jpg|gif|png]$/i;
		var bnumPat = /^[A-Z]{1}[0-9]{6}/;
		
	
		if(bnumPat.test($('#bnum').val())){
			chkBnum=false;
			chk1=true;

		}else{
			chkBnum=false;
			chk1=false;
			msg = "사번 확인 부탁드립니다.";
		
			}
		
		
		}
	
	
	
	</script>

<c:choose>

	<c:when test="${param.grade=='M' }">

		<form action="UpupReg" method="post" enctype="multipart/form-data" name="frm">
			<input type="hidden" name="grade" value="M" />
			<table>
				<tr>
					<td>아이디</td>
					<td>${mem.id }</td>
				</tr>
				<tr>
					<td>사번</td>
					<td><input type="text" name="bnum" id="bnum" onkeyup="chkPat2()">
						<input type="button" id="bBtn"/>
					</td>
				</tr>
				<tr>
					<td colspan="2"><input type="button" value="제출" id="subBtn" /> 
					<input type="reset" value="초기화"></td>
				</tr>
			</table>
		</form>
	</c:when>
	
	
	<c:when test="${param.grade=='A' }">


		<form action="UpupReg" method="post" enctype="multipart/form-data" name="frm">
			<input type="hidden" name="grade" value="A" />
			<table>
				<tr>
					<td>아이디</td>
					<td>${mem.id }</td>
				</tr>
				<tr>
					<td id="bnum">사업자등록번호</td>
					<td><input type="text" name="crn" id="crn" onkeyup="chkPat()"/>
					<input type="button" id="aBtn"/></td>
				</tr>
				<tr>
					<td>파일</td>
					<td><input type="file" name="img" id="img" onchange="chkPat()"/></td>
				</tr>
				<tr>
					<td>회사명</td>
					<td><input type="text" name="air_name" id="name" onkeyup="chkPat()"/></td>
				</tr>
				<tr>
					<td>회사코드</td>
					<td><input type="text" name="air_codecom" id="info" onkeyup="chkPat()"/></td>
				</tr>
				<tr>
					<td>수익률</td>
					<td><input type="text" name="salesPercent" id="salesPercent" onkeyup="chkPat()"/>%</td>
				</tr>
				<tr>
				<td></td>
					<td>0.1~100.0%, 소수점 1자리까지</td>
				</tr>
				<tr>
					<td colspan="2"><input type="button" value="제출" id="subBtn" /> 
					<input type="reset" value="초기화"></td>
				</tr>
			</table>
		</form>

	</c:when>
	
	
	<c:otherwise>

		<form action="UpupReg" method="post" enctype="multipart/form-data" name="frm">
			<input type="hidden" name="grade" value="H" />

			<table border="">


				<tr>
					<td>아이디</td>
					<td>${mem.id }</td>
				</tr>

				<tr>
					<td>사업자등록번호</td>
					<td><input type="text" name="crn" id="crn" onkeyup="chkPat()"/>
					<input type="button" id="hBtn"/></td>
				</tr>
				<tr>
					<td>호텔이미지</td>
					<td><input type="file" name="himg" id="img" onchange="chkPat()"/></td>
				</tr>
				<tr>
					<td>호텔명</td>
					<td><input type="text" name="hname" id="name" onkeyup="chkPat()"/></td>
				</tr>
				<tr>
					<td>호텔정보</td>
					<td><textarea name="hinfo" rows="5" cols="30" id="hinfo" onkeyup="chkPat()">남기실 말</textarea></td>
				</tr>
				<tr>
					<td>수익률</td>
					<td><input type="text" name="salesPercent" id="salesPercent" onkeyup="chkPat()"/>%</td>
				</tr>
				<tr>
					<td></td>
					<td>0.1~100.0%, 소수점 1자리까지</td>
				</tr>
				<tr>

					<td colspan="2" align="right"><input type="button" value="제출" id="subBtn" />
						<input type="reset" value="초기화" /></td>
				</tr>
			</table>


		</form>

	</c:otherwise>

</c:choose>
