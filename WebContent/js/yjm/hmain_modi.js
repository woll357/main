function fileDelete() {
    		hotmod.action = "FileDelete";
    		hotmod.submit();
    	}
    	
     	$(document).ready(function(){
    		$('.hotmodimodi').on({
    			'click':function() {
    				var img = $('#himg').val();
    				
    				if($('#himg').val()=='' || $('#hinfo').val()=='' || $('#hname').val()=='') {
    					alert("기입이완료되지않았습니다.");
    					hotmod.button();
    				}
             		if(img!=null) {
                		var ssimg = img.substring(img.lastIndexOf(".")+1);
                		console.log(ssimg);
                 		if(ssimg=='txt' || ssimg=='doc' || ssimg=='hwp' || ssimg=='ppt' || ssimg=='xls' || ssimg=='pptx'
                 				|| ssimg=='xlsx' || ssimg=='docx' || ssimg=='mp3' || ssimg=='wma' || ssimg=='wav'){
                  			alert("값이 잘못되었습니다.");
             			}
                 		else{
                       		hotmod.submit();
                   		 }
               		 }
    				
    			}
    			
    		})
    		
    	}) 