<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%request.setCharacterEncoding("utf-8"); %>

<h1>결제화면</h1>

<form action="PaymentReg" method="post">

<c:forEach var="l" items="${basketIDs }" >

	<input type="hidden" name="basketIDs" value="${l }"  />

</c:forEach>

	<table>
		<tr>
			<td align="right" >최근 이용 카드
			<input id="check" type="checkbox" />
			</td>
		</tr>
		<tr>
			<td>카드선택</td>
			<td>
			<select name="cComName">
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
			<td>카드번호</td>
			<td><input type="text" maxlength="4" name="cNum" />-</td>
			<td><input type="text" maxlength="4" name="cNum"/>-</td>
			<td><input type="text" maxlength="4" name="cNum"/>-</td>
			<td><input type="text" maxlength="4" name="cNum"/></td>
		</tr>
		<tr>
			<td>유효기간</td>
			<td>
			<select name="exDate">
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
			/</td>

			<td>
			<select name="exDate">
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
			<td>cvc</td>
			<td><input type="password" maxlength="3" name="cvc" /></td>
		</tr>
		<tr>
			<td>카드비밀번호</td>
			<td><input type="password" maxlength="2" name="pw" />**</td>
		</tr>
		<tr>
			<td>
			총액
			</td>
			<td>
			<input type="text" value=${totalPrice } readonly="readonly" name="totalPrice"/>
			</td>
		</tr>	
		<tr>
			<td><input type="submit" value="결제하기"/></td>
		</tr>
	</table>
</form>
<a href="../PaymentRecent/RecentPayment?id=aaaa">우후훌</a>

<!-- <script>
$(document).ready(function(){
	$("#check").on({
		click:function(){
			$.ajax("../PaymentRecent/RecentPayment?id=aaaa"{
				
			})
		}
		
	});
});
</script>  -->