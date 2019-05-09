
var regType1 = /^[0-9+]{5,8}$/;

$(document).ready(function(){	
	
     $('.darea').on({
         'change':function(){
               
            var cc = $('.darea').val();
            var dd = $('.carea').val();
            
            if(cc==dd){
            	
            alert("중복");  
            
            $('select').find('option').removeAttr('selected');
            
            $('select').find('option:first').attr('selected', 'selected');
            
  
            
            }
         }
      });
	 
     
     $('.carea').on({
         'change':function(){
               
            var cc = $('.darea').val();
            var dd = $('.carea').val();
            
            if(cc==dd){
            	
            	   alert("중복되었습니다.");  
            	   
            	   $('select').find('option').removeAttr('selected');
            	
            	   $('select').find('option:first').attr('selected', 'selected');

            }
         }
      });
     
     
     
     $(document).ready(function(){
    		$('.airgo').on({
    			'click':function() {
    			
    				
    				if($('.ap_code').val()=='' || $('.ddate').val()=='' || $('.hh').val()=='시' || $('.mm').val()=='분' ||
    						$('.ss').val()=='초' || $('.darea').val()=='출발지' ||  $('.carea').val()=='도착지' || $('.money').val()=='' ) {
    					
    					alert("기입이완료되지않았습니다.");
    				}else if(!regType1.test($('.money').val())){
    					alert("금액을 확인해주세요");
    				}
    				
    				
    				else{
    					AirItem_InsertReg.submit();
    	           		 }
    	       		 
    	       		 }
    				
    			
    		})
     
	});
    
     
     
     
});

