
$(document).ready(function(){
	setInterval('AutoScroll("#scrollDiv")',2000);
	$("#train_mall").Scroll({line:4,speed:800,timer:2000});
});
jQuery(document).ready(function() {
    jQuery('#mycarousel').jcarousel({
        auto: 2,
        wrap: 'last',
        initCallback: mycarousel_initCallback
    });
});
/**
 * 证书展览滑动
 * @param carousel
 * @return
 */
function mycarousel_initCallback(carousel)
{
    // Disable autoscrolling if the user clicks the prev or next button.
    carousel.buttonNext.bind('click', function() {
        carousel.startAuto(0);
    });

    carousel.buttonPrev.bind('click', function() {
        carousel.startAuto(0);
    });

    // Pause autoscrolling if the user moves with the cursor over the clip.
    carousel.clip.hover(function() {
        carousel.stopAuto();
    }, function() {
        carousel.startAuto();
    });
};
/**
 * 收藏证书翻屏
 * @param obj
 * @return
 */
function AutoScroll(obj){
	$(obj).find("ul:first").animate({
		marginTop:"-28px"
	},528,function(){
	$(this).css({marginTop:"0px"}).find("li:first").appendTo(this);
	});
}


/**
 * 培训广场又下向上滚动
 */
(function($){
$.fn.extend({
	Scroll:function(opt,callback){
	//参数初始化
	if(!opt) var opt={};
	var _this=this.eq(0).find("ul:first");
	var        lineH=_this.find("li:first").height(), //获取行高
	line=opt.line?parseInt(opt.line,10):parseInt(this.height()/lineH,10), //每次滚动的行数，默认为一屏，即父容器高度
	speed=opt.speed?parseInt(opt.speed,10):500, //卷动速度，数值越大，速度越慢（毫秒）
	timer=opt.timer?parseInt(opt.timer,10):3000; //滚动的时间间隔（毫秒）
	if(line==0) line=1;
	var upHeight=0-line*lineH;
	//滚动函数
	scrollUp=function(){
	_this.animate({
	marginTop:upHeight
	},speed,function(){
	for(i=1;i<=line;i++){
	_this.find("li:first").appendTo(_this);
	}
	_this.css({marginTop:0});
	});
	}
	//鼠标事件绑定
	_this.hover(function(){
	clearInterval(timerID);
	},function(){
		timerID=setInterval("scrollUp()",timer);
	}).mouseout();
	}      
	})
})(jQuery);


	