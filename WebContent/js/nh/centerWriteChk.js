$(document).ready(function(){
	 
	 var imgPat = /img|bmp|jpeg|jpg|gif|png$/i;
	 
	 
	 $('#btn').on({
		 'click':function(){
			 
			
			if($('#title').val()!="" && $('#content').val()!="" && $('#content').val()!="남기실 말"
					&& (imgPat.test($('#img').val().substring($('#img').val().lastIndexOf('.')+1,$('#img').val().length)) || $('#img').val()=="")){
				frm.submit();
			 }else{
				 alert("정보 확인 부탁드립니다.");
			 }

		 }
	 })
	 
 })