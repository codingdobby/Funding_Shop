$(function(){
var auto_slide;
var auto_time = 1000;  // 슬라이드 시간 1000 = 1초
var auto_num = 0;

$(".slider img").eq(auto_num).css({"left":"0%"});  // 처음로드시 첫이미지 보이기
auto_slide = setInterval(function(){ slide_start() },auto_time);

function slide_start(){  // 슬라이드 구현
      var no = auto_num +1;
      if(no >= $(".slider img").length){
            no = 0;
      }
      $(".slider img").eq(no).css({"left":"-100%"}).stop().animate({"left":"0%"});
      $(".slider img").eq(auto_num).stop().animate({"left":"100%"});
      auto_num = no;
}
$(".slider").hover(function(){  // 마우스 오버시 슬라이드 멈춤
      clearInterval(auto_slide);
},function(){  // 마우스 아웃시 다시 시작
      auto_slide = setInterval(function(){ slide_start() },auto_time);
});

});