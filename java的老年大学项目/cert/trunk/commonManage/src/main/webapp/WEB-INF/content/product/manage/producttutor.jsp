<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<%@page import="cn.common.lib.util.web.PropertyUtils"%>
<%
request.setAttribute("innerahstudyUrl",PropertyUtils.getPropertyWithConfigName("sysconfig.properties","traincore.webapp.url.inner"));
request.setAttribute("ahstudyUrl",PropertyUtils.getPropertyWithConfigName("sysconfig.properties","traincore.webapp.url"));
request.setAttribute("manageUrl",PropertyUtils.getPropertyWithConfigName("sysconfig.properties","manage.url"));
%> 
<!-- 书籍辅导老师 -->
<style type="text/css">
<!--
#large_container_chart {  
    position:absolute;
    z-index:99;
    display:none;    /*使div初始化时隐藏*/
}
-->
</style>
<script type="text/javascript">
//dom加载完成时执行
$(function(){
    parent.iFrameHeight();
    //input获取焦点时在其旁边显示div
    $('#toselectTutor').click(function(){
        var input = $("#tutor_div");         
        var offset = input.offset();
        //先后设置div的内容、位置，最后显示出来（渐进效果）
        $('#large_container_chart')
            .css('left',offset.left + 'px')
            .css('top',offset.top +20 +'px')
            .fadeIn();
    	subFrameHeight();
        parent.iFrameHeight();
    });
});


function subFrameHeight() {
	var ifm= document.getElementById("subMainFrame");   
	var subWeb = document.frames ? document.frames["subMainFrame"].document : ifm.contentDocument;  
	if(ifm != null && subWeb != null) {
	   ifm.height = subWeb.body.scrollHeight+20;
	}   
}  

//提交删除,这里的删除不是真的删除辅导老师对象而是只是将其从该门书籍关系去掉，不被加入这么书籍的辅导老师
function ajaxDelete(id){
	var tutorIds = ","+$("#tutorIds").val()+",";
	if(tutorIds.indexOf(","+id+",")>-1){
		tutorIds=tutorIds.replace(","+id+",",",")
	}
	$("#tutorIds").val(tutorIds);
	$('#producttutor_container').load('${ctx}/product/manage/tutor!list.action?tutorUserIds='+tutorIds, false);
	//if(!confirm("确认删除？"))return;
	//将选择中待删除的id从备选辅导老师的串中删除，然后重新加载列表
}

</script>
<input id="tutorIds" name="tutorIds" type="hidden" value="${tutorUserIds}"/>
<table class="table table-bordered dr-table-bordered" style="width:98%;font-size: 12">
<tr>
<th>用户名</th>
<th>姓名</th>
<th>年度内学生限额</th>
<th>现有学生数</th>
<th>操作</th>
</tr>
<s:iterator value="tutors">
   <tr>
    <td>${user.username}<input type="hidden" value="${id}" id="tutorId_${id}"/></td>
    <td>${user.name}</td>
    <td><input name="numlimits" type="text" id="numlimit_${userId}" class="form-control input-sm" value="${numlimit}" /></td>
    <td>${curStudentNum}</td>
    <td><a href="javascript:void(0)" onclick="ajaxDelete(${id});"><img src="${ctx}/css/admin_image/admin_ico03.jpg" width="16" height="16" border="0" /></a></td>
   </tr>	
</s:iterator>
</table>

<div class="btn-group mt10">
        <button id="toselectTutor" class="btn btn-primary btn-sm" type="button" onfocus="javascript:this.blur();">
        <span class="glyphicon glyphicon-plus"></span>
                      新增辅导老师
        </button>
      </div>
<center>
    <div id='large_container_chart' style="display:none;  position:absolute; top:1480px; left:0px; width: 48%; text-align: left; background-color: white; border: 1px; border-color: blue; ">
	<script type="text/javascript">
	//提交选择的辅导老师用户ids
	function ajaxAddTutors(tutorUserIds){
		$("#tutorIds").val($("#tutorIds").val()+tutorUserIds)	
		$.ajax({
	         type: "POST",
	         url: "${ctx}/product/manage/tutor!save.excsec",
	         data: {
	       	 	"tutorUserIds":$("#tutorIds").val()
			 },
	         success: function(data) {
			 	var data = eval(data);
			 	if(data.value=="true"){
					$('#producttutor_container').load('${ctx}/product/manage/tutor.excsec?tutorUserIds='+$("#tutorIds").val(), false);
			 	}else{
					alert(data.label);
			 	}
	         },
	         beforeSend: function() {
	         }
	    });
	}
	
	function closewindow(){
	    $("#large_container_chart").hide();
		subFrameHeight();
	    parent.iFrameHeight();
	}
	</script>
	<iframe src="${ctx}/product/manage/tutor!tutorUsers.action?tutorUserIds=${tutorUserIds}&id=${id}" frameborder="0" scrolling="no" width="680" id="subMainFrame" name="subMainFrame"></iframe>
    </div>
</center>
