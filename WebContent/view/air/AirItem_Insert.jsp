<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 등록</title>
</head>
<body>
<script src="../js/jquery-3.3.1.min.js"></script>   

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
            
            
            ////document.getElementById('carea').options.length = 0;
            
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
     
     
     
     
     
});
function inNumber(){
	  if(event.keyCode<48 || event.keyCode>57){
	     event.returnValue=false;
	  }
	}


</script>
<form action="AirItem_InsertReg">
	<table border="">
		<tr>
			<td>비행기코드</td>
			<td><input type="text" name="ap_code" /></td>
		</tr>
		<tr>
			<td>출발날짜</td>
			<td><input type="text" name="ddate" /></td>
		</tr>
		<tr>
			<td>출발시간</td>
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
				
				
				<select   name="m">		                         
				<option value="00">분</option>
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
				
				<select  name="s">		                         
				<option value="00">초</option>
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
				<td>출발지</td>
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
			<td>도착지</td>
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
			<td>가격</td>
			<td><input type="text" name="money" onkeypress="inNumber();"/></td>
		</tr>

				<tr>
				<td colspan="2" align="right">
				<input type="submit" value="작성" />
				<input type="reset" value="초기화" />
			</td>
		</tr>
	</table>
</form>
</body>
</html>