

$(document).ready(function(){
	
	 
	   $('#ok').on({
	      'click':function(){
	    	  $('#ff').attr('action','GradeDetailReg');
	    	  frm.submit();
	      }
	   });
	   $('#no').on({
		      'click':function(){
		    	  $('#ff').attr('action','RejectUp');
		    	  frm.submit();
		      }
		   });
});
