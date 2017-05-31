$(document).ready(function(){
	var $old = $("#SliderContent ul li:nth-child(1) a");
	var $now = $("#SliderContent ul li:nth-child(2) a");
	var $all = $("#SliderContent ul li:nth-child(3) a");
	var $oldli = $("#SliderContent ul li:nth-child(1)");
	var $nowli = $("#SliderContent ul li:nth-child(2)");
	var $allli = $("#SliderContent ul li:nth-child(3)");
	var $oldoption = $("#oldoption");
	var $nowoption = $("#nowoption");
	var $alloption = $("#alloption");
	var $Slider = $("#Slider");

	//×ÖÌå¿ØÖÆ
	$old.mouseenter(function(){
		$oldli.stop(true, true).animate({paddingRight:"8px"}, "fast");
		$old.stop(true, true).animate({fontSize:"20px"}, "fast");
	});
	
	$old.mouseleave(function(){
		$oldli.stop(true, true).animate({paddingRight:"10px"}, "fast");
		$old.stop(true, true).animate({fontSize:"18px"}, "fast");
	});
	
	$now.mouseenter(function(){
		$nowli.stop(true, true).animate({paddingRight:"8px"}, "fast");
		$now.stop(true, true).animate({fontSize:"20px"}, "fast");
	});
	
	$now.mouseleave(function(){
		$nowli.stop(true, true).animate({paddingRight:"10px"}, "fast");
		$now.stop(true, true).animate({fontSize:"18px"}, "fast");
	});
	
	$all.mouseenter(function(){
		$allli.stop(true, true).animate({paddingRight:"8px"}, "fast");
		$all.stop(true, true).animate({fontSize:"20px"}, "fast");
	});
	
	$all.mouseleave(function(){
		$allli.stop(true, true).animate({paddingRight:"10px"}, "fast");
		$all.stop(true, true).animate({fontSize:"18px"}, "fast");
	});
	
	//»¬¿é¿ØÖÆ
	$old.click(function(){
		$Slider.stop(true, true).animate({left:"11px"}, "fast");
	});
	
	$now.click(function(){
		$Slider.stop(true, true).animate({left:"49px"}, "fast");
	});
	
	$all.click(function(){
		$Slider.stop(true, true).animate({left:"87px"}, "fast");
	});
	
})