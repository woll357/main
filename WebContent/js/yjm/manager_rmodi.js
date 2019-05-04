function fileDelete() {
    		roommod.action = "FileDelete2";
    		roommod.submit();
    	}
        function maxLengthCheck(object) {
        	if (object.value.length > object.maxLength) {
        		object.value = object.value.slice(0, object.maxLength);
        	}
        }
        $(document).ready(function(){       	
        	$('.modimodi').on({
         	'click':function(){  
		
         		var img = $('#rimg').val();
         		console.log(img);
         		
         		if($('#rcnt').val()=='' || $('#money').val()=='' || $('#wmoney').val()=='' || $('#rimg').val()=='') {
         			alert("기입이 완료되지않았습니다.")
         			roommod.button();
         		}
         		
         		if(img!=null) {
            		var ssimg = img.substring(img.lastIndexOf(".")+1);
            		console.log(ssimg);
             		if($('#rcnt').val()<0 || $('#money').val()<0 || $('#wmoney').val()<0 || ssimg=='txt' 
             				|| ssimg=='doc' || ssimg=='hwp' || ssimg=='ppt' || ssimg=='xls' || ssimg=='pptx'
             				|| ssimg=='xlsx' || ssimg=='docx' || ssimg=='mp3' || ssimg=='wma' || ssimg=='wav'){
              			alert("값이 잘못되었습니다.");
         			}
             		else{
                   		roommod.submit();
               		 }
           		 }
         		else {
         			if(($('#rcnt').val()<0 || $('#money').val()<0 || $('#wmoney').val()<0) ){
         				alert("값이 잘못되었습니다.")
         			}else{
         			roommod.submit();
         			}
         		}
        	 }      
      		})
      	  })