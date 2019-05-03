<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <script src="../js/jquery-3.3.1.min.js"></script>
 <script>
 
 $(document).ready(function(){
	
	 $('#awp').on({
		 'click' : function(){
			 $('#dd').css({
				 'visibility': 'hidden'
			 })

		 }
	 })
	 $('#rtp').on({
		 'click' : function(){
			 $('#dd').css({
				 'visibility': 'visible'
			 })

		 }
	 })
	 
	 
	 
	$('.start').on({
		'click':function(){
			$('#startCity').val(($(this).attr('id')));
		}
	})
	$('.arrive').on({
		'click':function(){
			$('#arriveCity').val(($(this).attr('id')));
		}
	})
	$('.hotdd').on({
		'click':function(){
			$('#hotDir').val(($(this).attr('id')));
		}
	})
	
	$('#ssdate1').on({
		'click':function(){
			var cal = new Date();
			var yy = cal.getYear()+1900;
			var mm = cal.getMonth();
			
			calendar(yy,mm, $(this).attr("id"));
			
			
		}
	})
	$('#ssdate2').on({
		'click':function(){
			var cal = new Date();
			var yy = cal.getYear()+1900;
			var mm = cal.getMonth();
			
			calendar(yy,mm, $(this).attr("id"));
			
			
		}
	})
	
	$('#startDay').on({
		'click':function(){
			var cal = new Date();
			var yy = cal.getYear()+1900;
			var mm = cal.getMonth();
			
			calendar(yy,mm, $(this).attr("id"));
			
			
		}
	})
	$('#endDay').on({
		'click':function(){
			var cal = new Date();
			var yy = cal.getYear()+1900;
			var mm = cal.getMonth();
			
			calendar(yy,mm, $(this).attr("id"));
			
			
		}
	})
	
	 
 })
 
 
 
 
 function calendar(year,month, id){ //달력 함수  
        //내장 객체
        console.log(id);
        if(id=='ssdate1' || id=='startDay'){
	        var nowDate = new Date(); //오늘 날짜 객체 선언  
	        var nYear = nowDate.getFullYear(); //오늘의 년도  
	        var nMonth = nowDate.getMonth(); //오늘의 월 ※ 0월부터 시작  
	        var nDate = nowDate.getDate(); //오늘의 날  
	        var nNumday = nowDate.getDay(); //오늘의 요일 0=일요일...6=토요일  
	        var endDay=new Array(31,28,31,30,31,30,31,31,30,31,30,31); //각달의 마지막 날짜  
	        var dayName=new Array("일", "월", "화", "수", "목", "금", "토"); // 숫자 요일을 문자 요일 바꿀 함수  
        }else if(id=='ssdate2'){
        	var std = $('.ssdate1').val();
        	var stdArr = std.split('-');
        	var nowDate = new Date(stdArr[0], eval(stdArr[1])-1, stdArr[2]);
        	var nYear = nowDate.getFullYear(); //오늘의 년도  
 	        var nMonth = nowDate.getMonth(); //오늘의 월 ※ 0월부터 시작  
 	        var nDate = nowDate.getDate(); //오늘의 날  
            var nNumday = nowDate.getDay(); //오늘의 요일 0=일요일...6=토요일  
            var endDay=new Array(31,28,31,30,31,30,31,31,30,31,30,31); //각달의 마지막 날짜  
            var dayName=new Array("일", "월", "화", "수", "목", "금", "토"); // 숫자 요일을 문자 요일 바꿀 함수  
        }else if(id=='endDay'){
        	var std = $('.startDay').val();
        	var stdArr = std.split('-');
        	var nowDate = new Date(stdArr[0], eval(stdArr[1])-1, stdArr[2]);
        	var nYear = nowDate.getFullYear(); //오늘의 년도  
 	        var nMonth = nowDate.getMonth(); //오늘의 월 ※ 0월부터 시작  
 	        var nDate = nowDate.getDate(); //오늘의 날  
            var nNumday = nowDate.getDay(); //오늘의 요일 0=일요일...6=토요일  
            var endDay=new Array(31,28,31,30,31,30,31,31,30,31,30,31); //각달의 마지막 날짜  
            var dayName=new Array("일", "월", "화", "수", "목", "금", "토"); // 숫자 요일을 문자 요일 바꿀 함수  
        }
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
 
 

<div id="ddateCal1" style="visibility: hidden;" >

</div>


<table>
	<tr>
		<td>항공</td>
		<td>숙박</td>
	</tr>
	<tr>
		<td>
			<form action="RsvAirReg" method="post">
			<input type="hidden" name="id" value="${mem.id }"/>
			<input type="hidden" name="grade" value="${mem.grade }"/>
			<table border="">
				<tr>
					<td colspan="2"><table border="">
							<tr>
								<td id="rtp">왕복</td>
								<td id="awp">편도</td>
							</tr>
						</table></td>
				</tr>
				<tr>
					<td>출국도시</td>
					<td>도착도시</td>
				</tr>
				<tr>
					<td>
					<select name="darea">
					<option value="상해">상해</option>
					<option value="베이징">베이징</option>
					<option value="도쿄">도쿄</option>
					<option value="오사카">오사카</option>
					<option value="마닐라">마닐라</option>
					<option value="보라카이">보라카이</option>
					<option value="세부">세부</option>
					<option value="푸켓">푸켓</option>
					</select>
					</td>
					<td>
					<select name="carea">
					<option value="상해">상해</option>
					<option value="베이징">베이징</option>
					<option value="도쿄">도쿄</option>
					<option value="오사카">오사카</option>
					<option value="마닐라">마닐라</option>
					<option value="보라카이">보라카이</option>
					<option value="세부">세부</option>
					<option value="푸켓">푸켓</option>
					</select>
					</td>
				</tr>
				<tr>
					<td class="start">출발날짜</td>
					<td class="return"><div id="dd">귀국날짜</div></td>
				</tr>
				<tr>
					<td class="start">
					<input type="text" name="ddate1" class="ssdate1"/><input type="button" value="날짜검색" id="ssdate1">
					</td>
					<td class="return"><div id="dd">
					<input type="text" name="ddate2" class="ssdate2"/><input type="button" value="날짜검색" id="ssdate2"/>
					</div></td>
				</tr>
				<tr>
					<td>인원</td>
					<td>좌석</td>
				</tr>
				<tr>
					<td><input type="number" name="seatcnt" id="seatcnt"/>명</td>
					<td>
					<select name="flightclass" id="flightclass">
					<option value="일반">일반</option>
					<option value="비즈니스">비즈니스</option>
					</select>
					</td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" id="plane"/></td>
				</tr>


			</table>
			</form>

		</td>
		<td>
		
		<form action="RsvHotReg" method="post">
		<input type="hidden" name="id" value="${mem.id }"/>
		<input type="hidden" name="grade" value="${mem.grade }"/>
		<table border="">
			<tr>
				<td>목적지</td>
			</tr>
			<tr>
				<td>
					<select name="city">
					<option value="상해">상해</option>
					<option value="베이징">베이징</option>
					<option value="도쿄">도쿄</option>
					<option value="오사카">오사카</option>
					<option value="마닐라">마닐라</option>
					<option value="보라카이">보라카이</option>
					<option value="세부">세부</option>
					<option value="푸켓">푸켓</option>
					</select>
					</td>
					</tr>
			<tr>
				<td>체크인</td>
			</tr>
			<tr>
				<td><input type="text" name="startDay" class="startDay"/><input type="button" value="날짜검색" id="startDay"></td>
			</tr>
			<tr>
				<td>체크아웃</td>
			</tr>
			<tr>
				<td><input type="text" name="endDay" class="endDay"/><input type="button" value="날짜검색" id="endDay"></td>
			</tr>
			<tr>
				<td>인원</td>
			</tr>
			<tr>
				<td><input type="number" name="pcnt" id="pcnt"/></td>
			</tr>
			<tr>
				<td>등급</td>
			</tr>
			<tr>
				<td>
				<select name="rkind" id="rkind">
					<option value="D">디럭스룸</option>
					<option value="S">스위트룸</option>
					</select>
				</td>
			</tr>
			<tr>
				<td><input type="button" id="hott" /></td>
			</tr>
			
		</table>
		
		
		
		
		</form>
		
		</td>
	</tr>
</table>