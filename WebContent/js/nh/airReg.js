
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
 
 
