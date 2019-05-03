<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 등록</title>
</head>
<body onload="calendar()">
<script src="../js/jquery-3.3.1.min.js"></script>   
<script src="../js/odk/textnum.js"></script> 



<script>







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
    						$('.ss').val()=='초' || $('.darea').val()=='' ||  $('.carea').val()=='') {
    					
    					alert("기입이완료되지않았습니다.");
    				
    				}	else{
    					AirItem_InsertReg.submit();
    	           		 }
    	       		 }
    				
    			
    		})
     
	});
    
     
     
     
     

     
     
     
     
});

function calendar(year,month, id){ //달력 함수  
    //내장 객체
    var nowDate = new Date(); //오늘 날짜 객체 선언  
    var nYear = nowDate.getFullYear(); //오늘의 년도  
    var nMonth = nowDate.getMonth(); //오늘의 월 ※ 0월부터 시작  
    var nDate = nowDate.getDate(); //오늘의 날  
    var nNumday = nowDate.getDay(); //오늘의 요일 0=일요일...6=토요일  
    var endDay=new Array(31,28,31,30,31,30,31,31,30,31,30,31); //각달의 마지막 날짜  
    var dayName=new Array("일", "월", "화", "수", "목", "금", "토"); // 숫자 요일을 문자 요일 바꿀 함수  
    var col=0; //나중에 앞뒤 빈 날짜칸 계산   
    if (year==null){ //null 일경우, 처음 페이지의 년도는 현재 년도를 가져옴   
        year=nYear;
    } 

    if (month==null){ //null 일경우, 처음 페이지의 월은 현재 월을 가져옴
        month=nMonth;  
    }

    eDate= new Date(); //달을 넘길 때 바뀌는 날짜
    eDate.setFullYear(year); //바뀌는 년도 
    eDate.setMonth(month); //바뀌는 월 
    eDate.setDate(1); // 날짜는 1일로 설정  
    var fNumday=eDate.getDay(); //넘길때 달 1일 요일 (숫자)  
    var lastDay=endDay[eDate.getMonth()]; //바뀌는 월의 마지막 날짜  

    if ((eDate.getMonth()==1)&&(((eDate.getYear()%4==0)&&(eDate.getYear() %100 !=0))||eDate.getYear() % 400 ==0 )){
        //0월 부터 시작하므로 배열의 첫번째는 2월-> 윤달 계산 4년마다 29일, 100년는 28일, 400년 째는 29일
        lastDay=29;
    }   

    calendarStr  = "<table>"  
    calendarStr += "<tr align=center><td valign=middle>"  
    calendarStr += "<a href=javascript:calendar("+year+","+(month-1)+") class=preNext><</a>" //월을 넘길때 빼기 -1을 해서 넘긴다(년도는 자동 계산)  
    calendarStr += "</td><td colspan=5 >"  
    calendarStr += "<font size=3 color=black><b>"+eDate.getFullYear()+"년 "+(eDate.getMonth()+1)+"월</b></font> "//해당하는 년도와 월 표시  
    calendarStr += "</td><td valign=middle>"  
    calendarStr += "<a href=javascript:calendar("+year+","+(month+1)+") class=preNext>></a>" //월을 넘길때 더하기 +1을 해서 넘긴다(년도는 자동 계산)  
    calendarStr += "</td></tr><tr>"  
    for (i=0;i<dayName.length;i++){            
        calendarStr += "<td class=week>"+dayName[i] + "</td>" //숫자 요일을 날짜로 입력  
    }  

    calendarStr += "</tr><tr align=center>"  

    for (i=0;i<fNumday;i++){ // 첫번째 날짜의 숫자 요일을 구해서 그전까지는 빈칸 처리  
        calendarStr += "<td>&nbsp;</td>"   
        col++;                       
    }  

    for ( i=1; i<=lastDay; i++){ //해당 월의 달력 출력  
        if(eDate.getFullYear()==nYear&&eDate.getMonth()==nMonth&&i==nDate){ //오늘이면 today 스타일로 표시  
            calendarStr += "<td class=today>"+i+"</td>"   
        }
        else if(eDate.getFullYear()<nYear ||  (eDate.getFullYear()==nYear && eDate.getMonth()<nMonth)
        		|| (eDate.getFullYear()==nYear && eDate.getMonth()==nMonth && i<(nDate+2))){
        	if(col==0){//일요일 
                calendarStr += "<td class=sunday>"+i+"</td>"  
            }
            else if(1<=col&&col<=5){//평일  
                calendarStr += "<td class=workday>"+i+"</td>"   
            }
            else if(col==6){ //토요일  
                calendarStr += "<td class=satday>"+i+"</td>"   
            }
        }else{  
            if(col==0){//일요일 
                calendarStr += "<td class=sunday onClick=datePicker("+year+","+month+","+i+",'"+id+"')>"+i+"</td>"  
            }
            else if(1<=col&&col<=5){//평일  
                calendarStr += "<td class=workday onClick=datePicker("+year+","+month+","+i+",'"+id+"')>"+i+"</td>"   
            }
            else if(col==6){ //토요일  
                calendarStr += "<td class=satday onClick=datePicker("+year+","+month+","+i+",'"+id+"')>"+i+"</td>"   
            }  
        }             
        col++;  

        if(col==7){ //7칸을 만들면 줄 바꾸어 새 줄을 만들고 다시 첫 칸부터 시작  
            calendarStr += "</tr><tr align=center>"  
            col=0;  
        }  
    }     

    for (i=col;i<dayName.length;i++){ //마지막 날에서 남은 요일의 빈 칸 만들기  
        calendarStr += "<td>&nbsp;</td>"  
    } 

    $('#ddateCal1').html(calendarStr);  
	
    $('#ddateCal1').css({
		 'visibility': 'visible'
	 })
    
}



function datePicker(yy,mm,dd,id){
 
 console.log(yy+"년 "+(mm+1)+"월"+dd+"일"+id);
 
 if((mm+1)<10){
	 mm="0"+(mm+1);
 }
 if((dd)<10){
	 dd="0"+(dd);
 }
 
 var idd = "."+id;
 $(idd).val(yy+"-"+mm+"-"+dd);
 
 
}




</script>
<form name="AirItem_InsertReg" action="AirItem_InsertReg">
	<table border="">
		<tr>
			<td colspan="2">비행기코드</td>
			<td><input type="text" name="ap_code"  class="ap_code"/></td>
		</tr>
		<tr>
			<td>출발날짜</td>
			<td><input type="text" id="ddate" name="ddate" class="ddate"/></td>
			<td><div id="ddateCal1"></div></td>  

		</tr>
		<tr>
			<td colspan="2">출발시간</td>
			<td>
				<select class="hh" name="h">		                         
				<option>시</option>
				<option value="00">00</option>
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
				<option value="13">13</option>
				<option value="14">14</option>
				<option value="15">15</option>
				<option value="16">16</option>
				<option value="17">17</option>
				<option value="18">18</option>
				<option value="19">19</option>
				<option value="20">20</option>
				<option value="21">21</option>
				<option value="22">22</option>
				<option value="23">23</option>
				
				</select>
				
				
				<select class="mm"  name="m">		                         
				<option >분</option>
				<option value="00">00</option>
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
				<option value="13">13</option>
				<option value="14">14</option>
				<option value="15">15</option>
				<option value="16">16</option>
				<option value="17">17</option>
				<option value="18">18</option>
				<option value="19">19</option>
				<option value="20">20</option>
				<option value="21">21</option>
				<option value="22">22</option>
				<option value="23">23</option>
				<option value="23">24</option>
				<option value="23">25</option>
				<option value="23">26</option>
				<option value="23">27</option>
				<option value="23">28</option>
				<option value="23">29</option>
				<option value="23">30</option>
				<option value="23">31</option>
				<option value="23">32</option>
				<option value="23">33</option>
				<option value="23">34</option>
				<option value="23">35</option>
				<option value="23">36</option>
				<option value="23">37</option>
				<option value="23">38</option>
				<option value="23">39</option>
				<option value="23">40</option>
				<option value="23">41</option>
				<option value="23">42</option>
				<option value="23">43</option>
				<option value="23">44</option>
				<option value="23">45</option>
				<option value="23">46</option>
				<option value="23">47</option>
				<option value="23">48</option>
				<option value="23">49</option>
				<option value="23">50</option>
				<option value="23">51</option>
				<option value="23">52</option>
				<option value="23">53</option>
				<option value="23">54</option>
				<option value="23">55</option>
				<option value="23">56</option>
				<option value="23">57</option>
				<option value="23">58</option>
				<option value="23">59</option>
				<option value="23">60</option>
				
				</select>
				
				<select class="ss"  name="s">		                         
				<option >초</option>
				<option value="00">00</option>
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
				<option value="13">13</option>
				<option value="14">14</option>
				<option value="15">15</option>
				<option value="16">16</option>
				<option value="17">17</option>
				<option value="18">18</option>
				<option value="19">19</option>
				<option value="20">20</option>
				<option value="21">21</option>
				<option value="22">22</option>
				<option value="23">23</option>
				<option value="23">24</option>
				<option value="23">25</option>
				<option value="23">26</option>
				<option value="23">27</option>
				<option value="23">28</option>
				<option value="23">29</option>
				<option value="23">30</option>
				<option value="23">31</option>
				<option value="23">32</option>
				<option value="23">33</option>
				<option value="23">34</option>
				<option value="23">35</option>
				<option value="23">36</option>
				<option value="23">37</option>
				<option value="23">38</option>
				<option value="23">39</option>
				<option value="23">40</option>
				<option value="23">41</option>
				<option value="23">42</option>
				<option value="23">43</option>
				<option value="23">44</option>
				<option value="23">45</option>
				<option value="23">46</option>
				<option value="23">47</option>
				<option value="23">48</option>
				<option value="23">49</option>
				<option value="23">50</option>
				<option value="23">51</option>
				<option value="23">52</option>
				<option value="23">53</option>
				<option value="23">54</option>
				<option value="23">55</option>
				<option value="23">56</option>
				<option value="23">57</option>
				<option value="23">58</option>
				<option value="23">59</option>
				<option value="23">60</option>
				
				
				
				</select>
				</td>
				
		</tr>
		<tr>
				<td colspan="2">출발지</td>
				<td>
				<select class="darea"  name="darea">
				<option >출발지</option>                                  
				<option value="인천">인천</option>
				<option value="도쿄">도쿄</option>
				<option value="오사카">오사카</option>
				<option value="상해">상해</option>
				<option value="베이징">베이징</option>
				<option value="마닐라">마닐라</option>
				<option value="보라카이">보라카이</option>
				<option value="세부">세부</option>
				<option value="푸켓">푸켓</option>
			 
			
				</select>
			</td>
		</tr>
		<tr>
		<tr>
			<td colspan="2">도착지</td>
				<td>
				<select class="carea" name="carea">   
				<option >도착지</option>      				                    
				<option value="인천">인천</option>
				<option value="도쿄">도쿄</option>
				<option value="오사카">오사카</option>
				<option value="상해">상해</option>
				<option value="베이징">베이징</option>
				<option value="마닐라">마닐라</option>
				<option value="보라카이">보라카이</option>
				<option value="세부">세부</option>
				<option value="푸켓">푸켓</option>
				</select>
			</td>
		</tr>
		<tr>

		</tr>
		<tr>
			<td colspan="2">가격</td>
			<td><input type="text" name="money" onkeypress="inNumber();"/></td>
		</tr>

				<tr>
				<td colspan="3" align="right">
				<input type="button" value="작성" class="airgo" />
				<input type="reset" value="초기화" />
			</td>
		</tr>
	</table>
</form>
</body>
</html> 







