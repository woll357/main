<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%request.setCharacterEncoding("utf-8"); %>
<script src="../js/jquery-3.3.1.min.js"></script>
<h1>결제화면</h1>

<form name="frm" action="PaymentReg" method="post">

<c:forEach var="l" items="${basketIDs }" >

	<input type="hidden" name="basketIDs" value="${l }"  />

</c:forEach>
<div id="contents">
	<table>
		<tr>
			<td style="width: 120px" >최근 이용 카드</td>
			<td><input id="check" type="checkbox" /></td>
		</tr>
		
		<tr>
			<td style="width: 120px">카드선택</td>
			<td>
			<select style="width: 50px" id="cComName" name="cComName">
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
			<td style="width: 120px">카드번호</td>
			<td><input style="width: 50px" type="text" maxlength="4" id="cNum1" name="cNum1" /></td><td style="width: 10px">-</td>
			<td><input style="width: 50px" type="text" maxlength="4" id="cNum2" name="cNum2"/></td><td style="width: 10px">-</td>
			<td><input style="width: 50px" type="text" maxlength="4" id="cNum3" name="cNum3"/></td><td style="width: 10px">-</td>
			<td><input style="width: 50px" type="text" maxlength="4" id="cNum4" name="cNum4"/></td>
		</tr>
		<tr>
			<td style="width: 120px">유효기간</td>
			<td>
			<select style="width: 50px" id="exDateMonth" name="exDateMonth">
			<option value="01">01</option>
			<option value="02">02</option>
			<option value="03">03</option>
			<option value="04">04</option>
			<option value="05">05</option>
			<option value="06">06</option>
			<option value="07">07</option>
			<option value="08">08</option>
			<option value="09">09</option>
			<option value="10">10</option>
			<option value="11">11</option>
			<option value="12">12</option>
			</select>
			</td><td style="width: 10px">/</td>

			<td>
			<select style="width: 50px" id="exDateYear" name="exDateYear">
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
			<td style="width: 120px">cvc</td>
			<td style="width: 50px" ><input style="width: 50px"  type="password" maxlength="3" id="cvc" name="cvc" /></td>
		</tr>
		<tr>
			<td style="width: 120px">카드비밀번호</td>
			<td style="width: 50px"><input style="width: 50px"  type="password" maxlength="2" id="pw" name="pw" /></td><td style="width: 10px">**</td>
		</tr>
		</table>
		</div>
		
		
		<table>
		<tr>
			<td style= "width: 120px">총액</td>
			<td>
			<input type="text" value=${totalPrice } readonly="readonly" name="totalPrice"/>
			</td>
		</tr>	
		<tr>
			<td><input id="btn" type="button" value="결제하기"/></td>
		</tr>
	</table>

</form>

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
		    	  
		    		if(chk1 && chk2 && chk3 && chk4 && chk5 && chk6){
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
				 alert("유효하지 않은 카드번호 첫번째 4자리입니다.");
			}
		})
		
		$('#cNum2').focusout(function(){
			if(cNum2Pat.test($(this).val())){
				chk2=true;
			}
			else{
				chk2=false;
				 alert("유효하지 않은 카드번호 두번째 4자리입니다.");
			}
		})
		
		$('#cNum3').focusout(function(){
			if(cNum3Pat.test($(this).val())){
				chk3=true;
			}
			else{
				chk3=false;
				 alert("유효하지 않은 카드번호 세번째 4자리입니다.");
			}
		})
		
		$('#cNum4').focusout(function(){
			if(cNum4Pat.test($(this).val())){
				chk4=true;
			}
			else{
				chk4=false;
				 alert("유효하지 않은 카드번호 네번째 4자리입니다.");
			}
		})
		$('#cvc').focusout(function(){
			if(cvcPat.test($(this).val())){
				chk5=true;
			}
			else{
				chk5=false;
				 alert("유효하지 않은 cvc 입니다.");
			}
		})
		$('#pw').focusout(function(){
			if(pwPat.test($(this).val())){
				chk6=true;
			}
			else{
				chk6=false;
				 alert("유효하지 않은 pw 입니다.");
			}
		})
		
		$("#check").on({
			click:function(){
				$.ajax("../PaymentRecent/RecentPayment",
			            {
		               success:function(dd){
		            	   $("#contents").html(dd)
		            	 
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