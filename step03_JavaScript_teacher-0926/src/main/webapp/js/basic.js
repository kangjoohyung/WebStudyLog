//javaScript 문법
 //브라우져에 출력하고 싶다.(javaScript에서 html태그를 사용할수 있다.)
document.write("난 어디에 나오니?<br>");
document.write("<h4 style='color:red'>신기히다</h4>");

 
document.write("<h4> 잘 나온다....</h4>");


 //마우스를 올렸을때 기능 = 
function mouseOver( th ){ //th는 변수이다. 전달되는 this를 받는 변수이다
	console.log("th = " + th);
	
	//h3태그에 border 디자인 추가 
	th.style.border='double red 5px';
	th.style.fontFamily='궁서체'
}

//마우스를 out 했을때 기능 
function mouseOut(th){
	//h3태그에 border 디자인 제거 
	th.style.border="none";
}