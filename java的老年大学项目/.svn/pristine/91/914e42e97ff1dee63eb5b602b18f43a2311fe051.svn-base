<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<link href="${ctx}/css/cycle_pic.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
		var $$ = function (id) {
			return document.getElementById(id);
		}

		var getByClass = function (parent, className) {
			var aEle = parent.getElementsByTagName("*");
			var re = new RegExp("\\b"+className+"\\b", "i" );
			var arr = [];
			for (var i = 0; i < aEle.length; i++) {
				if (re.test(aEle[i].className)) {
					arr.push(aEle[i]);
				}
			}
			return arr;
		}

		var zIndex = 2;
		var timer = null;
		
		var slide = function () {
			var oSlide = $$("slideBox");
			var aSlides = getByClass(oSlide, "slide");
			var aBtns = getByClass(oSlide, "xbtns")[0].getElementsByTagName("li");
			for (var i = 0; i < aBtns.length; i++) {
				aBtns[i].index = i;
				aBtns[i].onmouseover = function () {
					clearInterval(timer);
					for (var j = 0; j < aSlides.length; j++) {
						aSlides[j].style.zIndex = 0 ;
						aBtns[j].className = "";
					}
					aSlides[this.index].style.zIndex = zIndex++ ;
					this.className = "current";
				}
				aBtns[i].onmouseout = function () {
					autoSlide(this.index);
				}
			}
		}
			var autoSlide = function (iPara) {
			var oSlide = $$("slideBox");
			var aSlides = getByClass(oSlide, "slide");
			var aBtns = getByClass(oSlide, "xbtns")[0].getElementsByTagName("li");
			var iPara = iPara || 0;
			timer = setInterval(function () {
				if (iPara >= aBtns.length) {
					iPara = 0;
				}
				for (var i = 0, j = 0; i < aBtns.length, j < aSlides.length; i++, j++) {
					aBtns[i].className = "";
					aSlides[j].style.zIndex = 0;
				}
				aBtns[iPara].className = "current";
				aSlides[iPara].style.zIndex = zIndex++;
				iPara++;
			}, 2000);
		}
		$(document).ready(function() {
			slide();
		    autoSlide();
		 })
</script>
<div class="slideBox" id="slideBox">
	<s:iterator value="picArticles" status="stat">
	<div class="slide slide0${stat.index+1}">
		<a class="pic" href="${ctx}/news/article!home.action?id=${id }&menuId=${firstCategory.id}" target="_blank" index="${stat.index+1}" >
			<img border=0 src="<common:prop name="traincore.uploadpath.url"  propfilename=""></common:prop>/${imgname}" alt="${title}" width="440" height="226"/>				
		</a> 
		<span class="txt"><a target="_blank" href="${ctx}/news/article!home.action?id=${id }&menuId=${firstCategory.id}"><common:cut len="26" string="${title}"></common:cut></a></span>
	</div>
	</s:iterator>
	<ul class="xbtns">
	<s:iterator value="picArticles" status="stat">
	<s:if test="#stat.getIndex()==0"><li class="current"><a href="#">${stat.index+1}</a></li></s:if>
	<s:else><li><a href="#">${stat.index+1}</a></li></s:else> 
	</s:iterator>
	</ul>
</div>
