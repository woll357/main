	$(document).ready(function(){
    		$('.airmodimodi').on({
    			'click':function() {
    				var img = $('#img').val();
    				
    				if($('#img').val()=='파일선택') {
    					alert("파일은 선택해주세요.");
    					
    				}		
             		if(img!=null) {
                		var ssimg = img.substring(img.lastIndexOf(".")+1);
                		console.log(ssimg);
                 		if(ssimg=='txt' || ssimg=='doc' || ssimg=='hwp' || ssimg=='ppt' || ssimg=='xls' || ssimg=='pptx'
                 				|| ssimg=='xlsx' || ssimg=='docx' || ssimg=='mp3' || ssimg=='wma' || ssimg=='wav'){
                  			alert("값이 잘못되었습니다.");
             			}
                 		else{
                 			airmod.submit();
                   		 }
               		 }
    				
    			}
    			
    		})
    		
    	}) ;
	
    	function fileDelete() {
    		airmod.action = "FileDelete";
    		airmod.submit();
    	}