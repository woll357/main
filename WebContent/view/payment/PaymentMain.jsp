<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<script src="../js/jquery-3.3.1.min.js"></script>
<link rel="stylesheet" href="../css/nh/tot.css" />
<div style="background-image: url('../img/login.jpg'); width: 1000px; height: 800px;">
<br><br><br><br><br><br><br><br><br><br><br><br><br>
<h2 style="margin-left: 100px;">결제화면</h2>
<form name="frm" action="PaymentReg" method="post">
<c:forEach var="l" items="${basketIDs }" >
	<input type="hidden" name="basketIDs" value="${l }"  />
</c:forEach>
<table style="margin-left: 100px;">
<tr>
<td id="contents" >
<table class="ttcss" border = "" >
		<tr>
			<td class="wbbr">최근 이용 카드</td>
			<td colspan="4" class="wbbr"><input id="check" type="checkbox" /></td>
		</tr>
		
		<tr>
			<td class="wbbr">카드선택</td>
			<td colspan="4" class="wbbr" align="left">
			<select id="cComName" name="cComName">
			<option  value="국민">국민</option>
			<option  value="비씨">비씨</option>
			<option  value="신한">신한</option>
			<option  value="현대">현대</option>
			<option  value="삼성">삼성</option>
			<option  value="롯데">롯데</option>
			</select>
			</td>
		</tr>
		<tr>
			<td class="wbbr">카드번호</td>
			<td class="wbbr"><input style="width: 50px" type="text" maxlength="4" id="cNum1" name="cNum1" /></td>
			<td class="wbbr"><input style="width: 50px" type="text" maxlength="4" id="cNum2" name="cNum2"/></td>
			<td class="wbbr"><input style="width: 50px" type="text" maxlength="4" id="cNum3" name="cNum3"/></td>
			<td class="wbbr"><input style="width: 50px" type="text" maxlength="4" id="cNum4" name="cNum4"/></td>
		</tr>
		<tr>
			<td class="wbbr">유효기간</td>
			<td class="wbbr" colspan="2">
			<select style="width:100%" id="exDateMonth" name="exDateMonth">
			<option value="01">1</option>
			<option value="02">2</option>
			<option value="03">3</option>
			<option value="04">4</option>
			<option value="05">5</option>
			<option value="06">6</option>
			<option value="07">7</option>
			<option value="08">8</option>
			<option value="09">9</option>
			<option value="10">10</option>
			<option value="11">11</option>
			<option value="12">12</option>
			</select>
			</td>

			<td class="wbbr" colspan="2">
			<select style="width:100%" id="exDateYear" name="exDateYear">
			<option value="19">19</option>
			<option value="20">20</option>
			<option value="21">21</option>
			<option value="22">22</option>
			<option value="23">23</option>
			<option value="24">24</option>
			<option value="25">25</option>
			<option value="26">26</option>
			<option value="27">27</option>
			<option value="28">28</option>
			<option value="29">29</option>
			<option value="30">30</option>
			<option value="31">31</option>
			<option value="32">32</option>
			<option value="33">33</option>
			<option value="34">34</option>
			<option value="35">35</option>
			<option value="36">36</option>
			<option value="37">37</option>
			<option value="38">38</option>
			<option value="39">39</option>
			<option value="40">40</option>
			</select>
			</td>
		</tr>
		<tr>
			<td class="wbbr">cvc</td>
			<td class="wbbr" colspan="4" ><input style="width: 50px"  type="password" maxlength="3" id="cvc" name="cvc" /></td>
		</tr>
		<tr>
			<td class="wbbr">카드비밀번호</td>
			<td class="wbb"><input style="width: 50px"  type="password" maxlength="2" id="pw" name="pw" /></td><td class="wbbr" colspan="3">**</td>
		</tr>
		</table>

</td>
</tr>
</table>
		<table style="text-align: center;color: #779191;background-color: #dcefef; margin-left: 100px;" cellspacing="0">
		<tr>
			<td class="wbr" style="width:115px">총액</td>
			<td style="width:120px;" align="left">
			<input type="text" value=${totalPrice } readonly="readonly" name="totalPrice"/>
			</td>
			<td style="width:100px;"><input class="btncss" id="btn" type="button" value="결제하기"/></td>
		</tr>	
		<tr>
			
		</tr>
	</table>

</form>
</div>
<script>
	
	var chk = false;
	
	var chk1=false;
	var chk2=false;
	var chk3=false;
	var chk4=false;
	var chk5=false;
	var chk6=false;

	var msg = "";
	
	var cNum1Pat= /^[0-9]{4}$/;
	var cNum2Pat= /^[0-9]{4}$/;
	var cNum3Pat= /^[0-9]{4}$/;
	var cNum4Pat= /^[0-9]{4}$/;
	var cvcPat= /^[0-9]{3}$/;
	var pwPat= /^[0-9]{2}$/;
	
	function chkPat(){
		
		if(chk1 && chk2 && chk3 && chk4 && chk5 && chk6){
			chk=true;
			frm.submit();
		}
		else{
			alert("잘못된 입력값이 존재합니다.");
		}
			
	}
	
	$(document).ready(function(){
		
		  $('#btn').on({
		      'click':function(){
		    	  
		    	 var exDateYear =  $('#exDateYear').val();
		    	 var exDateMonth = $('#exDateMonth').val();
		    
		    	 var chk11 = true;
		    	 var chk12 = true;
		    	 var today = new Date();
		    	 var thisyear = ""+today.getFullYear();
		    	 
		    	 if(eval(exDateMonth-today.getMonth()<0)){
		    		 chk11 = false;
		    		 console.log("여긴오니?");
		    	 }
		    	 
		    	 if (thisyear.substring(2,4)==exDateYear && !chk11){
		    		 chk12 = false;
		    	 }
		    	  
		    		if(chk1 && chk2 && chk3 && chk4 && chk5 && chk6 && chk12){
		    			chk=true;
		    			frm.submit();
		    		}
		    		else if($('#check').attr("checked") == "checked" && chk6){

		    			frm.submit();			
		    		}
		    		else{
		    			alert("잘못된 입력값이 존재합니다.");
		    		}
		      }
		   });
		
		$('#cNum1').focusout(function(){
			if(cNum1Pat.test($(this).val())){
				chk1=true;
			}
			else{
				chk1=false;
				
			}
		})
		
		$('#cNum2').focusout(function(){
			if(cNum2Pat.test($(this).val())){
				chk2=true;
			}
			else{
				chk2=false;
				
			}
		})
		
		$('#cNum3').focusout(function(){
			if(cNum3Pat.test($(this).val())){
				chk3=true;
			}
			else{
				chk3=false;
				
			}
		})
		
		$('#cNum4').focusout(function(){
			if(cNum4Pat.test($(this).val())){
				chk4=true;
			}
			else{
				chk4=false;
				
			}
		})
		$('#cvc').focusout(function(){
			if(cvcPat.test($(this).val())){
				chk5=true;
			}
			else{
				chk5=false;
			
			}
		})
		$('#pw').focusout(function(){
			if(pwPat.test($(this).val())){
				chk6=true;
			}
			else{
				chk6=false;
				
			}
		})
		
		$("#check").on({
			click:function(){
				$.ajax("../PaymentRecent/RecentPayment?",
			            {
		               success:function(dd){
		            	   console.log(dd.trim());
		            	   if(dd.trim()=='최근 이용 내역이 없습니다.'){
		            		   $(this).checked = false;
		            		   alert("최근이용내역이 없습니다.");
		            		   
		            	   }else{
		            	   $("#contents").html(dd)
		            	   }
		               },
		               error:function(){
		                  alert("최근이용내역이 없습니다.");
		               },
		            }
		         );
			}
		});
	});
</script>