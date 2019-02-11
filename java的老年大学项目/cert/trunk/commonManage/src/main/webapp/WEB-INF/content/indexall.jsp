<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<%
	request.setAttribute("certapiurl", PropertyUtils.getPropertyWithConfigName("sysconfig.properties", "cert.api.url"));
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>   
	<%@ include file="/common/meta.jsp" %> 
	<meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta name="keywords" content="keywords">
    <meta name="description" content="description">
    <title>查询服务-中小学教师教育网</title>
    <link rel="stylesheet" type="text/css" href="cert/css/combo.select.min.css">
    <link rel="stylesheet" type="text/css" href="cert/css/z.min.css">
    <link rel="stylesheet" type="text/css" href="cert/css/app.css">
    <script src="${ctx }/cert/js/jquery.min.js"></script>
    <script src="${ctx }/cert/js/jquery.combo.select.min.js"></script>
    <script src="${ctx }/cert/js/z.min.js"></script>
    <script src="${ctx }/cert/js/aa.js"></script>
    <script src="${ctx }/cert/js/jigsaw.js"></script>
    <script type="text/javascript">
       
        function searchByMobile(){
        	var mobilePhone = $("#mobilePhone").val();
        	if(mobilePhone=='') {
        		alert("请输入手机号码！");
        		return ;
        	}
        	$("#certImage").hide();
        	$.ajax({
				type : "post", //请求方式
				url : "${certapiurl}/cert/usercertoffline/list",
				dataType : "jsonp", //跨域json请求一定是jsonp
				data:{mobilePhone:mobilePhone},
				jsonp : "callback", //跨域请求的参数名，默认是callback
				jsonpCallback : "successCallback", //自定义跨域参数值，回调函数名也是一样，默认为jQuery自动生成的字符串
				crossDomain: true,
				success : function(data) {
					if(data.length<1){
						$("#certList").hide();
						$("#noresult").show();
					}else{
						$("#noresult").hide();
						$("#certList").show();
					}
					var html = ""
					for(var i=0;i<data.length;i++){
						if(i%12==0){
							if(i>=data.length-12){
								html += "</div><div class=\"slide\">";						
							}
							else{
								html += "</div><div class=\"slide right-out\">";
							}
						}
						html = html+"<div class=\"dishn\"><div class=\"hnys1\"><span>●</span>结业证书(单位："+data[i].unit+"|姓名："+data[i].name+")</div>"+
						"<div >"+data[i].genTimeStr+"</div><div><a href=\"#\" onclick=\"downLoadPicture("+data[i].id+")\">下载</a></div></div>";
					}
					if(html!='') html = html.substr(6);
					$("#certList").html("<div id=\"slide-tabs\"></div>");
					$("#certList").prepend(html);
					init_tabs();
				},
				error : function() {
					//请求出错处理
	
				}
			});
        }
        
        function searchByIdcard(){
        	var idcard = $.trim($("#idcard").val());
        	if(idcard=='') {
        		alert("请输入身份证号码！");
        		return ;
        	}
        	$("#certImage").hide();
        	$.ajax({
				type : "post", //请求方式
				url : "${certapiurl}/cert/usercertoffline/list",
				dataType : "jsonp", //跨域json请求一定是jsonp
				data:{idcard:idcard},
				jsonp : "callback", //跨域请求的参数名，默认是callback
				jsonpCallback : "successCallback", //自定义跨域参数值，回调函数名也是一样，默认为jQuery自动生成的字符串
				success : function(data) {
					if(data.length<1){
						$("#certList").hide();
						$("#noresult").show();
					}else{
						$("#noresult").hide();
						$("#certList").show();
						
					}
					var html = ""
					for(var i=0;i<data.length;i++){
						if(i%12==0){
							if(i>=data.length-12){
								html += "</div><div class=\"slide\">";						
							}
							else{
								html += "</div><div class=\"slide right-out\">";
							}
						}
						html = html+"<div class=\"dishn\"><div class=\"hnys1\"><span>●</span>结业证书(单位："+data[i].unit+"|姓名："+data[i].name+")</div>"+
						"<div >"+data[i].genTimeStr+"</div><div><a href=\"#\" onclick=\"downLoadPicture("+data[i].id+")\">下载</a></div></div>";
					}
					if(html!='') html = html.substr(6);
					$("#certList").html("<div id=\"slide-tabs\"></div>");
					$("#certList").prepend(html);
					init_tabs();
				},
				error : function() {
					//请求出错处理
	
				}
			});
        }
        
        function searchByName(){
        	var name = $.trim($("#name").val());
        	if(name=='') {
        		alert("请输入姓名！");
        		return ;
        	}
        	$("#certImage").hide();
        	$.ajax({
				type : "post", //请求方式
				url : "${certapiurl}/cert/usercertoffline/list",
				dataType : "jsonp", //跨域json请求一定是jsonp
				data:{name:name},
				jsonp : "callback", //跨域请求的参数名，默认是callback
				jsonpCallback : "successCallback", //自定义跨域参数值，回调函数名也是一样，默认为jQuery自动生成的字符串
				success : function(data) {
					if(data.length<1){
						$("#certList").hide();
						$("#noresult").show();
					}else{
						$("#noresult").hide();
						$("#certList").show();
						
					}
					var html = ""
					for(var i=0;i<data.length;i++){
						if(i%12==0){
							if(i>=data.length-12){
								html += "</div><div class=\"slide\">";						
							}
							else{
								html += "</div><div class=\"slide right-out\">";
							}
						}
						html = html+"<div class=\"dishn\"><div class=\"hnys1\"><span>●</span>结业证书(单位："+data[i].unit+"|姓名："+data[i].name+")</div>"+
						"<div >"+data[i].genTimeStr+"</div><div><a href=\"#\" onclick=\"downLoadPicture("+data[i].id+")\">下载</a></div></div>";
					}
					if(html!='') html = html.substr(6);
					$("#certList").html("<div id=\"slide-tabs\"></div>");
					$("#certList").prepend(html);
					init_tabs();
				},
				error : function() {
					//请求出错处理
	
				}
			});
        }
        
        function downLoadPicture(id) {
			//文件导出中不在响应
			var form = $("<form id=\"downLoadPicture\" target=\"_blank\">");
			form.attr("style", "display:none");
			form.attr("target", "");
			form.attr("method", "post");
			form.attr("action", "${certapiurl}/cert/usercertoffline/downloadUserCertOffline");
			var usercertId = $("<input />");
			usercertId.attr("type", "hidden");
			usercertId.attr("name", "id");
			usercertId.attr("value", id);
			form.append(usercertId);
			$("body").append(form);
			form.submit();
			$("#downLoadPicture").remove();
			//timer =  window.setInterval("isFinsh()",1000);
		}
    </script>
</head>
<body>   
<!--header start-->
<div class="z-sm-hide beijing">
    <div class="z-content ">
        <div class="z-row">
            <div class="z-col-lg-6">
                <a href="/" class="logo" title="教师教育">
                    <img class="topp" src="cert/images/a11.png" alt="教师教育">
                </a>
            </div>
            <div class="z-col-lg-6 top10">

                <ul class="links">
                    <li><a href="javascript:;" class="z-action-tip" title="设为首页" onclick="AddFavorite(this, location.href)">设为首页</a></li>
                    <li class="zjx">|</li>
                    <li><a href="javascript:;" class="z-action-tip" title="加入收藏" onclick="AddFavorite(this, location.href)">加入收藏</a></li>
                    <li class="zjx">|</li>
                    <li><a href="javascript:;" class="z-action-tip" title="帮助中心" onclick="AddFavorite(this, location.href)">帮助中心</a></li>
                    <li class="zjx">|</li>
                    <li><a href="javascript:;" class="z-action-tips" title="回到首页" onclick="SetHome(this, location.href)">回到首页</a></li>

                    <!-- <li><a href="#" class="z-action-tips" title="帮助中心">帮助中心</a></li> -->
                </ul>
                <div class="search">
                    <!-- 							<form id="serchForm">
                                                    <div class="z-input-group">
                                                        <input type="text" class="z-input" name="keyword"  placeholder="请输入关键词进行搜索">
                                                        <div class="z-input-group-btn">
                                                            <button class="z-btn z-btn-blue z-icon" type="button" onclick="search();">&#xe621;</button>
                                                        </div>
                                                    </div>
                                                </form> -->
                </div>

            </div>
        </div>
    </div>
</div>
<script>
    function search() {
        var formParam = $("#serchForm").serialize();//序列化表格内容为字符串
        $.ajax({
            type: 'post',
            url: '/search/search!listSearch.action',
            data: formParam,
            cache: false,
            dataType: 'json',
            success: function (data) {
            }
        });
    }

</script>

<div class="z-content">
    <div class="user-search">
        <div class="z-row">
            <div class="z-col-lg-5">
                <div class="req">
                    <h3 class="title">选择查询方式</h3>
                    <div class="z-tab">
                        <ul class="z-tab-title">
                            <li>通过手机号码查找</li>
                            <li>通过身份证号码查找</li>
                            <li>通过姓名查找</li>
                        </ul>
                        <form id="servicesForm">
                            <div class="z-tab-content">
                                <div class="z-tab-item">
                                    <input type="text" id="mobilePhone" class="z-input" placeholder="请输入手机号码进行查询" name="mobilePhone">
                                  <!--  <div class="container">
                                      <div id="captcha" style="position: relative"></div>
                                      <div id="msg"></div>
                                    </div>
                                    <script>
                                      jigsaw.init({
                                        el: document.getElementById('captcha'),
                                        onSuccess: function() {
                                          document.getElementById('msg').innerHTML = '验证成功！'
                                          $("#mobileBtn").removeAttr("disabled");
                                        },
                                        onFail: cleanMsg,
                                        onRefresh: cleanMsg
                                      })
                                      function cleanMsg() {
                                        document.getElementById('msg').innerHTML = ''
                                      }
                                    </script> -->
									<!-- <div class="z-btn z-btn-red z-block">2018年08月01日正式开放查询</div> -->
                                    <button class="z-btn z-btn-blue z-block" type="button" onClick="searchByMobile();" id="mobileBtn">查找</button>

                                </div>
                                <div class="z-tab-item">
                                    <!-- 	<select class="combo-select">
                                            <option value="">输入学校名称</option>
                                            <option value="合肥市第1小学">合肥市第1小学</option>
                                        </select> -->
                                    <input type="text" class="z-input" name="idcard" id="idcard" placeholder="输入身份证号码">
                                    <!-- <div class="container">
                                      <div id="captcha02" style="position: relative"></div>
                                      <div id="msg02"></div>
                                    </div>
                                    <script>
                                      jigsaw.init({
                                        el: document.getElementById('captcha02'),
                                        onSuccess: function() {
                                          document.getElementById('msg02').innerHTML = '验证成功！'
                                          $("#idcardBtn").removeAttr("disabled");
                                        },
                                        onFail: cleanMsg02,
                                        onRefresh: cleanMsg02
                                      })
                                      function cleanMsg02() {
                                        document.getElementById('msg02').innerHTML = ''
                                      }
                                    </script> -->
                                    <button class="z-btn z-btn-blue z-block" onClick="searchByIdcard();"  id="idcardBtn" type="button">查找</button>
                                </div>
                                <div class="z-tab-item">
                                    <!-- 	<select class="combo-select">
                                            <option value="">输入学校名称</option>
                                            <option value="合肥市第1小学">合肥市第1小学</option>
                                        </select> -->
                                    <input type="text" class="z-input" name="name" id="name" placeholder="此处输入您的姓名">
                                    <!-- <div class="container">
                                      <div id="captcha03" style="position: relative"></div>
                                      <div id="msg03"></div>
                                    </div>
                                    <script>
                                      jigsaw.init({
                                        el: document.getElementById('captcha03'),
                                        onSuccess: function() {
                                          document.getElementById('msg03').innerHTML = '验证成功！'
                                          $("#nameBtn").removeAttr("disabled");
                                        },
                                        onFail: cleanMsg03,
                                        onRefresh: cleanMsg03
                                      })
                                      function cleanMsg03() {
                                        document.getElementById('msg03').innerHTML = ''
                                      }
                                    </script> -->
                                    <button class="z-btn z-btn-blue z-block" onClick="searchByName();"  id="nameBtn" type="button">查找</button>
                                </div>
                                <!--<center><a style="color:blue; text-decoration:underline;" target="_blank" href="http://nlts2016.ahtvu.ah.cn/mainform/serial.aspx">2016年信息技术能力提升培训发展测评用户名查询</a></center>-->
                            </div>
                        </form>
                    </div>
                </div>
            </div>
            <div class="z-col-lg-7" id="hasresult">
                <div class="res z-rel">
                    <h3 class="title">查询结果</h3>
                    <!-- <a href="" class="z-btn z-btn-blue loginBtn">去首页登录</a> -->
                    <div class="z-row" id="searchPage22">
                        <img src="cert/images/cert.jpg" alt="" style="margin:50px 100px;width:60%;height:60%;" id="certImage"/>
                    </div>
                </div>
                <!--信息列表轮播图-->
                <div class="slide-container" id="certList" onmouseenter="pInterval()" onmouseleave="cInterval()">
                    <!-- 轮播组件  最后一个不用加right-out类-->
                    <!-- 导航点 -->
                    
					<div id="slide-tabs"></div>
                </div>
                <!-- 轮播结束 -->
              	<div class="z-text-center z-mb20" id="noresult" style="display:none;">
		             <button class="z-btn z-btn-blue z-btn-lg blueBtn">没有您要的结果！</button>
		         </div>
            </div>
           

            <!-- <div class="z-text-center z-mb20">
                <button class="z-btn z-btn-blue z-btn-lg blueBtn" id="loadBtn" zdata-loading-text="换一批...">换一批</button>
            </div> -->
        </div>
    </div>
</div>
<!--footer 开始-->

<script type="text/javascript">
    function MM_jumpMenu(targ, selObj, restore) { //v3.0
        if (selObj.options[selObj.selectedIndex].value == '')return;
        eval(targ + ".open('" + selObj.options[selObj.selectedIndex].value + "')");
        if (restore) selObj.selectedIndex = 0;
    }
</script>

<div class="footer">
    <div class="z-content">
        <div class="yl">
            <div class="z-clearfix ts"><span class="z-pull-left">友情链接：</span></div>
            <div class="z-row">
                <div class="col bt20">
                    <select class="z-input" onchange="MM_jumpMenu('parent',this,0)">
                        <option selected="selected" value="">-各市教育局网站-</option>
                        <option value="http://www.hfjy.net.cn/">合肥市教育局</option>
                        <option value="http://www.hbjy.net/">淮北市教育局</option>
                        <option value="http://www.abedu.net/">亳州市教育局</option>
                        <option value="http://www.szjy.gov.cn/">宿州市教育局</option>
                        <option value="http://www.fyedu.gov.cn/">阜阳市教育局</option>
                        <option value="http://www.ahhnedu.cn/">淮南市教育局</option>
                        <option value="http://www.czjy.cn/">滁州市教育局</option>
                        <option value="http://www.masedu.cn/index.html">马鞍山市教育局</option>
                        <option value="http://www.whedu.net/cms/">芜湖市教育局</option>
                        <option value="http://www.xcedu.net/">宣城市教育局</option>
                        <option value="http://www.tledu.cn/">铜陵市教育局</option>
                        <option value="http://www.czjyty.gov.cn/Index.html">池州市教育局</option>
                        <option value="http://www.aqedu.gov.cn">安庆市教育局</option>
                        <option value="http://www.hsedu.cn/">黄山市教育局</option>
                    </select>
                </div>
                <div class="col bt20">
                    <select class="z-input" onchange="MM_jumpMenu('parent',this,0)">
                        <option selected="selected" value="">-全国教师网联成员单位-</option>
                        <option value="http://www.bnu.edu.cn/">北京师范大学</option>
                        <option value="http://www.ecnu.edu.cn/">华东师范大学</option>
                        <option value="http://www.nenu.edu.cn/">东北师范大学</option>
                        <option value="http://www.ccnu.edu.cn/">华中师范大学</option>
                        <option value="http://www.swnu.edu.cn/index.jsp">西南大学</option>
                        <option value="http://www.snnu.edu.cn/">陕西师范大学</option>
                        <option value="http://www.fjnu.edu.cn/">福建师范大学</option>
                        <option value="http://www.scnu.edu.cn/scnu/">华南师范大学</option>
                        <option value="http://www.crtvu.edu.cn/">中央广播电视大学</option>
                        <option value="http://www.ncet.edu.cn/">中央电化教育馆</option>
                        <option value="http://www.cetv.cn/">中国教育电视台</option>
                        <option value="http://www.hep.edu.cn/">高等教育出版社</option>
                        <option value="http://www.pep.com.cn/">人民教育出版社</option>
                        <option value="http://train.pkudl.cn:8088/">北京大学</option>

                    </select>
                </div>
                <div class="col bt20">
                    <select class="z-input" onchange="MM_jumpMenu('parent',this,0)">
                        <option selected="selected" value="">-省级示范高中-</option>
                        <option value="http://www.hbyz.cn/">淮北一中</option>
                        <option value="http://www.bzyzh.com/">亳州一中</option>
                        <option value="http://www.ahscyz.net.cn/">宿城一中</option>
                        <option value="http://www.bbez.com/">蚌埠二中</option>
                        <option value="http://www.fyyz.net/">阜阳一中</option>
                        <option value="http://www.hqzx.com.cn/">阜阳市红旗中学</option>
                        <option value="http://www.hnez.com.cn/">淮南二中</option>
                        <option value="http://www.ahczzx.cn/">滁州中学</option>
                        <option value="http://www.layz.net">六安一中</option>
                        <option value="http://www.ahmasez.com.cn/Index.shtm">马鞍山二中</option>
                        <option value="http://www.chsdyzx.com/">巢湖一中</option>
                        <option value="http://www.wuhuyizhong.com/">芜湖一中</option>
                        <option value="http://www.xczx.net.cn/">宣城中学</option>
                        <option value="http://www.tlyz.net/">铜陵一中</option>
                        <option value="http://www.chiznews.com/czmx/gczs/gczx_index.html">贵池中学</option>
                        <option value="http://www.aqyz.net/aqyz1/main/">安庆一中</option>
                        <option value="http://www.txyz.cn/">屯溪中学</option>
                        <option value="http://jsjy.ahtvu.ah.cn/link.htm">更多...</option>
                    </select>
                </div>
                <div class="col bt20">
                    <select class="z-input" onchange="MM_jumpMenu('parent',this,0)">
                        <option selected="selected" style="text-align:center" value="">-教育资源类网站-</option>
                        <option value="http://www.cbe21.com/">中国基础教育网</option>
                        <option value="http://www.21cnjy.com/">21世纪教育网</option>
                        <option value="http://www.teacher.com.cn/">全国中小学教师继续教育网</option>
                        <option value="http://www.zxxk.com/">中学学科网</option>
                        <option value="http://www.jiaoxue.info/">中小学教学资源网</option>
                        <option value="http://www.k12.com.cn/">K12 中国中小学教育教学网</option>
                        <option value="http://www.ahedu.cn">安徽基础教育资源网</option>
                    </select>
                </div>
                <div class="col bt20">
                    <select class="z-input" onchange="MM_jumpMenu('parent',this,0)">
                        <option selected="selected" value="">-其他门户网站-</option>
                        <option value="http://www.xinhuanet.com/">新华网</option>
                        <option value="http://www.people.com.cn/">人民网</option>
                        <option value="http://www.anhuinews.com/">中安在线</option>
                        <option value="http://www.psychcn.com/">华夏心理网</option>
                        <option value="http://www.hudong.com/">互动百科</option>
                        <option value="http://www.sina.com">新浪网</option>
                        <option value="http://www.163.com">网易</option>

                    </select>
                </div>
            </div>
        </div>
        <div class="tp">
            <div class="z-row">
                <div class="col bt20">
                    <a href="http://www.moe.edu.cn/" target="_blank"> <img src="cert/picture/link1.jpg" alt=""></a>
                </div>
                <div class="col bt20">
                    <a href="http://www.gpjh.cn/cms/" target="_blank"><img src="cert/picture/link2.jpg" alt=""></a>
                </div>
                <div class="col bt20">
                    <a href="http://www.ah.gov.cn/" target="_blank"><img src="cert/picture/link3.jpg" alt=""></a>
                </div>
                <div class="col bt20">
                    <a href="http://www.ahedu.gov.cn/" target="_blank"><img src="cert/picture/link4.jpg" alt=""></a>
                </div>
                <div class="col bt20">
                    <a href="http://www.ahtvu.ah.cn/" target="_blank"><img src="cert/picture/link5.jpg" alt=""></a>
                </div>
                <div class="col bt20">
                    <a href="http://jsjy.ahtvu.ah.cn/nltsgc/" target="_blank"><img src="cert/picture/link6.jpg" alt=""></a>
                </div>
                <div class="col bt20">
                    <a href="http://sqjy.ahtvu.ah.cn/" target=_blank><img src="cert/picture/link7.jpg" alt=""></a>
                </div>
            </div>
        </div>

        <div class="ad">地址：安徽省合肥市九华山路3号 Email：anhuijsjy@126.com 邮编：230022<br>
            安徽广播电视大学 版权所有 皖ICP备05003560号
        </div>
    </div>
</div>
<!--footer 结束-->
<button class="z-btn z-action-gotop z-gotop z-icon">&#xe6be;</button>

<!--shortcut 开始-->

<!--shortcut 结束-->
<script src="cert/js/template.js"></script>
<script>
    $(function () {
        var ui = {
            fixList: $('.fix-list:first'),
            loadBox: $('#loadBox'),
            loadBtn: $('#loadBtn')
        }

        // 右侧按钮
        var fixHig = parseFloat(ui.fixList.innerHeight())
        $(document).on('scroll', function () {
            if ($(this).scrollTop() > (z.winHeight - fixHig) / 2) {
                ui.fixList.addClass('active').css('marginTop', -fixHig / 2)
            } else {
                ui.fixList.removeClass('active').css('marginTop', 0)
            }
        })

        // 输入下拉框
        $('.combo-select').comboSelect({
            inputClass: 'z-input'
        })


        $(".z-tab-title>li").click(function () {
            $("#tipe").hide();
            $("#mobilephone").val("");
            $("#name").val("");
            $("#school").val("");
        })
        // 搜索切换（更换type）
        $('.search-page input[name="type"]').on('change', function () {
            var type = this.value
            $('.search-page .tag-list>li').removeClass('active')
            $('.search-page .tag-list>li[data-type="' + type + '"]').addClass('active')
        })
        $('.search-page .tag-list>li').on('click', function () {
            $('.search-page input[name="type"]').val($(this).data('type')).change()
        })
        $('.search-page .tag-list>li:first').click()

        // 加载
        ui.loadBtn.on('click', function () {
            var _this = $(this)
            //var html = ui.loadBox.html()
            _this.button()
            // ajax
            setTimeout(function () {
                _this.button()
                pageNumber++;
                search();
                //	ui.loadBox.append(html)
            }, 150)
        })
    })
    var pageNumber = 1;
    function search() {
        $("#tipe").hide();
        var formParam = $("#servicesForm").serialize();//序列化表格内容为字符串
        $.ajax({
            type: 'post',
            url: '/search/search!listServicesSearch.action?pageNumber=' + pageNumber,
            data: formParam,
            cache: false,
            dataType: 'json',
            success: function (data) {
                var shtml = "";
                $.each(data.userLists, function (i, value) {
                    if (value.userName.indexOf('ts') >= 0) {
                        value.platForm = 'sp.nlts.ahtvu.ah.cn';
                        value.platName = "安徽省中小学能力提升";
                    }
                    shtml += "<div class='z-col-lg-6 z-col-sm-6' ><div class='z-box'><ul class='res-list'><li class='r1'>姓名：" + value.name + "</li><li class='r1'>用户名：" + value.userName + "</li><li class='r2'>密码：" + value.passWord + "</li><li class='r3'>平台：<a href='http://" + value.platForm + "' class='z-text-blue' target='_blank'>" + value.platName + "</a></li></ul></div></div>"
                });
                //var shtml = template("searchPageTemp",data);
                $("#searchPage22").html(shtml);
                if (data.userLists == '')
                    $("#tipe").show();
            }
        });
    }
    function search2() {
        $("#tipe").hide();
        var formParam = $("#servicesForm").serialize();//序列化表格内容为字符串
        $.ajax({
            type: 'post',
            url: '/search/search!listServicesSearch.action?pageNumber=' + pageNumber,
            data: formParam,
            cache: false,
            dataType: 'json',
            success: function (data) {
                var shtml = "";
                $.each(data.userLists, function (i, value) {
                    if (value.userName.indexOf('kxkfy') >= 0) {
                        value.platForm = 'kxk.ahtvu.ah.cn';
                        value.platName = "阜阳市教师跨学科专业知识培训";
                    }
                    shtml += "<div class='z-col-lg-6 z-col-sm-6' ><div class='z-box'><ul class='res-list'><li class='r1'>姓名：" + value.name + "</li><li class='r1'>用户名：" + value.userName + "</li><li class='r2'>密码：" + value.passWord + "</li><li class='r3'>平台：<a href='http://" + value.platForm + "' class='z-text-blue' target='_blank'>" + value.platName + "</a></li></ul></div></div>"
                });
                $("#searchPage22").html(shtml);
                if (data.userLists == '')
                    $("#tipe").show();
            }
        });
    }


    function SetHome(obj, url) {
        try {
            obj.style.behavior = 'url(#default#homepage)';
            obj.setHomePage(url);
        } catch (e) {
            if (window.netscape) {
                try {
                    netscape.security.PrivilegeManager.enablePrivilege("UniversalXPConnect");
                } catch (e) {
                    $.alert("抱歉，此操作被浏览器拒绝！");
                }
            } else {
                $.alert("抱歉，您所使用的浏览器无法完成此操作。");
            }
        }
    }

    function AddFavorite(title, url) {
        try {
            window.external.addFavorite(url, title);
        }
        catch (e) {
            try {
                window.sidebar.addPanel(title, url, "");
            }
            catch (e) {
                $.alert("抱歉，您所使用的浏览器无法完成此操作。\n\n加入收藏失败，请进入新网站后使用Ctrl+D进行添加");
            }
        }
    }
</script>
</body>
</html>
