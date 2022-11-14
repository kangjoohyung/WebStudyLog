//javaScript 문법
document.write("난 어디에 나오니?<br>"); 
document.write("<h4 style='color:red'>신기하다</h4>");

document.write("<h4> 잘 나온다....</h4>");


//마우스를 올렸을때 기능-함수만들기
function mouseOver(th){//th는 변수이다. 전달되는 this를 받는 변수이다.
	//h3태그에 border 디자인 추가
	//script 내에서는 inline과 다르게 this 사용 안됨 this.style.border='double red 5px';
	//그래서 위에 함수에 this넣고 여기function 인수에 th를 넣는다.
	
	console.log("th="+th);
	
	th.style.border='double red 5px';
	th.style.fontFamily='궁서체';
}
//마우스를 out했을때 기능
function mouseOut(th){	
	//h3태그에 border 디자인 제거
	th.style.border="none"; //하나일땐 '',""둘다 되는듯
}