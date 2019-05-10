<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="../css/nh/tot.css" type="text/css">

 <script src="../js/jquery-3.3.1.min.js"></script>
 <script>

 $(document).ready(function(){
	
	 $('.awpBtn').on({
		'click':function(){
			
			var str = "";
			var checkBtn = $(this);
			
			var tr = checkBtn.parent().parent();
			var td = tr.children();
			
			$('#awpNo').html(td.eq(0).text());
			$('#awpName').html(td.eq(1).html());
			$('#awpDdate').html(td.eq(2).text());
			$('#awpCdate').html(td.eq(3).text()); 
			$('#awpDarea').html(td.eq(4).text());
			$('#awpCarea').html(td.eq(5).text());
			$('#awpSeatcnt').html(td.eq(6).text());
			$('#awpMoney').html(td.eq(7).text());
			$('#ccode1').val($(this).attr("id"));
			
			
		} 
	 })
	 
	 $('.rtpBtn').on({
		'click':function(){
			
			var str2 = ""
			var checkBtn2 = $(this);
			
			var tr2 = checkBtn2.parent().parent();
			var td2 = tr2.children();
			
			$('#rtpNo').html(td2.eq(0).text());
			$('#rtpName').html(td2.eq(1).html());
			$('#rtpDdate').html(td2.eq(2).text());
			$('#rtpCdate').html(td2.eq(3).text()); 
			$('#rtpDarea').html(td2.eq(4).text());
			$('#rtpCarea').html(td2.eq(5).text());
			$('#rtpSeatcnt').html(td2.eq(6).text());
			$('#rtpMoney').html(td2.eq(7).text());
			$('#ccode2').val($(this).attr("id"));
			
			
		} 
	 })
	 
	 $('#cancel1').on({
		'click':function(){
			
			$('#awpNo').html("");
			$('#awpName').html("");
			$('#awpDdate').html("");
			$('#awpCdate').html("");
			$('#awpDarea').html("");
			$('#awpCarea').html("");
			$('#awpSeatcnt').html("");
			$('#awpMoney').html("");
			$('#ccode1').val("");
			
			
		} 
	 })
	 
	 $('#cancel2').on({
		'click':function(){
			
			var str2 = ""
			var checkBtn2 = $(this);
			
			var tr2 = checkBtn2.parent().parent();
			var td2 = tr2.children();
			console.log(td2.eq(1).val());
			
			$('#rtpNo').html("");
			$('#rtpName').html("");
			$('#rtpDdate').html("");
			$('#rtpCdate').html("");
			$('#rtpDarea').html("");
			$('#rtpCarea').html("");
			$('#rtpSeatcnt').html("");
			$('#rtpMoney').html("");
			$('#ccode2').val("");
			
			
		} 
	 })
	 

	
	$('#btn').on({
		'click':function(){
			if("${mem.id}"==""){
			alert("로그인 하세요");
			}else if("${way}"=='awp' && ($('#ccode1').val()=="" || $('#ccode1').val()==null)){
				alert("가는 편을 선택해 주세요.");
			}else if("${way}"=='rtp' && ($('#ccode1').val()=="" || $('#ccode1').val()==null
					|| $('#ccode2').val()=="" || $('#ccode2').val()==null)){
				alert("비행편을 모두 선택해 주세요");
			}else{
				frm.submit();
			}
		}
		
		})
	 
	 
 })
 
 

 
 </script>
 <style>
#airImg{
	width: 30px;
	height: 30px;
}
table{
width: 1000px;
}
.gogoTr{
	background-color: #d4f5fc;
}
.rrTr{
	background-color: #d8fcd4;
}
.tt{
	padding: 30px 20px 10px 10px;
	font-size: 30px;

}

</style>



	
			<h2>가는 편</h2>

	<table class="ttcss" border="">
	<tr class="gogoTr">
		<td colspan="2" width="180px" class="wbbr">항공사</td>
				<td width="190px" class="wbbr">출발일</td>
				<td width="220px" class="wbbr">도착일</td>
				<td width="80px" class="wbbr">출발도시</td>
				<td width="80px" class="wbbr">도착도시</td>
				<td width="70px" class="wbbr">잔여석</td>
				<td width="80px" class="wbbr">가격</td>
				<td width="50px" class="wbb">선택</td>
		</tr>
		<c:forEach var="dto" items="${dto1}" varStatus="no">
		<tr>
		
		<td width="15px">${no.index+1 }</td>
		<td>
		<img id="airImg" alt="" src="../img/${dto.img }">
		${dto.air_name }
		</td>
		<td>${dto.ddate }</td>
		<td>${dto.a_time }</td>
		<td>${dto.darea }</td>
		<td>${dto.carea }</td>
		<td>${dto.totseatcnt-dto.seatcnt }</td>
		<td>${dto.money }</td>
		<td><input type="button" value="선택" id="${dto.cCode}" class="awpBtn"/></td>
		</tr>
		</c:forEach>
		</table>
		
		
		<c:if test="${way=='rtp' }">
		
		
				<h2>오는 편</h2>

		<table class="ttcss" border="">
		<tr class="rrTr">
		<td colspan="2" class="wbbr">항공사</td>
		<td class="wbbr">출발일</td>
		<td class="wbbr">도착일</td>
		<td class="wbbr">출발도시</td>
		<td class="wbbr">도착도시</td>
		<td class="wbbr">잔여석</td>
		<td class="wbbr">가격</td>
		<td class="wbb">선택</td>
		</tr>
		<c:forEach var="dto" items="${dto2}" varStatus="no">
		<tr>
		<td>${no.index+1 }</td>
		<td>
		<img id="airImg" alt="" src="../img/${dto.img }">
		${dto.air_name }
		</td>
		<td>${dto.ddate }</td>
		<td>${dto.a_time }</td>
		<td>${dto.darea }</td>
		<td>${dto.carea }</td>
		<td>${dto.totseatcnt-dto.seatcnt }</td>
		<td>${dto.money }</td>
		<td><input type="button" value="선택"  id="${dto.cCode}" class="rtpBtn"/></td>
		</tr>
		</c:forEach>
		</table>
		</c:if>
		<br><br>
		<hr color="#dcefef" noshade />
		<br>
		<form action="../Basket/BasketAirReg" method="post" name="frm" >
		<input type="hidden" name="seatcnt" value="${param.seatcnt }"/>
		
			
				
				<input type="hidden" id="ccode1" name="ccode">
				
				<h2>선택하신 가는 편</h2>
			<table class="ttcss" border="">	
			<tr class="gogoTr">
				<td colspan="2" width="180px" class="wbbr">항공사</td>
				<td width="190px" class="wbbr">출발일</td>
				<td width="220px" class="wbbr">도착일</td>
				<td width="80px" class="wbbr">출발도시</td>
				<td width="80px" class="wbbr">도착도시</td>
				<td width="70px" class="wbbr">잔여석</td>
				<td width="80px" class="wbbr">가격</td>
				<td width="50px" class="wbb">취소</td>
			</tr>
			
			<tr>
				<td id="awpNo" width="15px"></td>
				<td id="awpName"></td>
				<td id="awpDdate"></td>
				<td id="awpCdate"></td>
				<td id="awpDarea"></td>
				<td id="awpCarea"></td>
				<td id="awpSeatcnt"></td>
				<td id="awpMoney"></td>
				<td><input type="button" value="취소" id="cancel1"/></td>
			</tr>
		</table>	
			
			
			
			
			
			
		<c:if test="${way=='rtp' }">
		
			
			<input type="hidden" id="ccode2" name="ccode">
				<h2>선택하신 오는 편</h2>
			
			<table class="ttcss" border="">	
			<tr class="rrTr">
				<td colspan="2" width="180px" class="wbbr">항공사</td>
				<td width="190px" class="wbbr">출발일</td>
				<td width="220px" class="wbbr">도착일</td>
				<td width="80px" class="wbbr">출발도시</td>
				<td width="80px" class="wbbr">도착도시</td>
				<td width="70px" class="wbbr">잔여석</td>
				<td width="80px" class="wbbr">가격</td>
				<td width="50px" class="wbb">취소</td>
			</tr>
			<tr>
				<td id="rtpNo"></td>
				<td id="rtpName"></td>
				<td id="rtpDdate"></td>
				<td id="rtpCdate"></td>
				<td id="rtpDarea"></td>
				<td id="rtpCarea"></td>
				<td id="rtpSeatcnt"></td>
				<td id="rtpMoney"></td>
				<td><input type="button" value="취소" id="cancel2"/></td>
			</tr>
			</table>
		</c:if>
		
		<table>	
		<tr>
		<td colspan="9" align="right"style="padding: 20px;">
		<input type="button" value="장바구니" id="btn" style="width: 100px; height: 50px;"/>
		</td>
		</tr>
		</table>
		
		
		

		
		
		</form>
		
		
		


