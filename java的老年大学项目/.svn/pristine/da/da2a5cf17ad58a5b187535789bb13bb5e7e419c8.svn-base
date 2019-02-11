 <%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="org.springside.modules.security.springsecurity.SpringSecurityUtils" %>
<%@ include file="/common/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>江苏学习在线管理后台</title>
	<%@ include file="/common/meta.jsp" %>	 
	<link href="${ctx }/css/backend.css" rel="stylesheet" type="text/css" /> 
	<link href="${ctx }/css/separate_css/interaction.css" rel="stylesheet" type="text/css"/> 
	<script src="${staticurl}/js/table.js" type="text/javascript"></script>	
	<script src="${staticurl}/js/jquery.js" type="text/javascript"></script> 
	<script src="${staticurl}/js/related.js" type="text/javascript"></script> 
	<script type="text/javascript">
	<!--
    $(document).ready(function(){   
		 
	   $("#checkboxall").click(function(){
		     $("input[name='ids']").attr("checked",$(this).attr("checked"));
		});

		//验证批量删除文章的列表非空与否
	   $("#batchDel").click(
			   function(){
				   var oaction = document.getElementById("deleteForm").action;
				   document.getElementById("deleteForm").action="${ctx }/assist/manage/graderule!delete.action";
			       if($("input:checked").length==0) {
			            alert("没有可操作记录,请勾选");
			            return false;
			       } 
			       if(!confirm('您确定要进行此操作吗?')) return  false;
	
				   $("#deleteForm").submit();
				   document.getElementById("deleteForm").action = oaction;
			 }); 

	 //验证批量删除文章的列表非空与否
	   $("#batchDelDown").click(
			   function(){
				   var oaction = document.getElementById("deleteForm").action;
				   document.getElementById("deleteForm").action="${ctx }/assist/manage/graderule!delete.action";
			       if($("input:checked").length==0) {
			            alert("没有可操作记录,请勾选");
			            return false;
			       } 
			       if(!confirm('您确定要进行此操作吗?')) return  false;
	
				   $("#deleteForm").submit();
				   document.getElementById("deleteForm").action = oaction;
			 }); 		
    });  

-->
	 
	</script>
</head>

<body>
        <!--the beginning of main part-->
        <div id="main" class="mainpart">
            <div class="title">
                <h2 class="ll">头衔管理</h2>
            </div>
            <div class="detailbox">  
	     	<div id="message" style="line-height: 35px;">
	<s:actionmessage theme="custom" cssClass="tipbox"/>
</div>
                <div class="tablebox">
				<form id="mainForm" action="graderule.action" method="post">
					<input type="hidden" name="page.pageNo" id="pageNo" value="${page.pageNo}"/>
					<input type="hidden" name="page.orderBy" id="orderBy" value="${page.orderBy}"/>
					<input type="hidden" name="page.order" id="order" value="${page.order}"/>
				</form>	 
                
    			<form name="deleteForm" id="deleteForm" action="graderule!delete.action" method="post">
    			<ul>
          			<li class=" input">
          				<span class="ll"><input id="batchDel" type="button" value="删除选中" class="button01 mt5 forsubmit" style="width:100px"/></span>
          				<span class="ll"><input type="button" value="新 增" onclick="location.href='graderule!input.action';" class="button01 w60 mt5 forsubmit"/></span>
          				<div class="pager rr">
							<jsp:include page="/common/turnpage.jsp"></jsp:include>
						</div >
          			</li>
	         	</ul>
                <table width="100%" border="0" cellspacing="0" cellpadding="0" class="tablebg font333 ll collapse">
                    <tr>
                        <th width="5%">
                            <input type="checkbox" id="checkboxall"/>
                        </th>
                        <th width="5%">
                         	   No. 
                        </th>
                        <th width="30%">
                           <a href="javascript:sort('title','asc')"> 头衔名称</a>
                        </th>
                        <th width="15%">
                            <a href="javascript:sort('date','asc')">学分开始范围</a>
                        </th>
                        <th width="15%">
                            <a href="javascript:sort('userName','asc')">学分截止范围</a>
                        </th>
                        <th width="30%">
                       	     操作
                        </th> 
                    </tr>
              
                <s:iterator value="page.result" status="stat">
                    <tr>
                        <td>
                           <input type="checkbox" name="ids" value="${id}"/>
                        </td>
                        <td  title="${stat.count}">
                            &nbsp;${stat.count}
                        </td>
                        <td title="${name }">
                        &nbsp;<common:cut len="35" string="${name }"></common:cut>
                        </td>
                        <td title="${startScore}">
                            &nbsp;${startScore}
                        </td>
                        <td title="${endScore}">
                            &nbsp;${endScore}
                        </td> 
                        <td>  
						 	<a href="graderule!input.action?id=${id}">修改</a>
							<a href="#" onclick="delRecord('graderule!delete.action?ids=${id }');">删除</a>	
                        </td>
                    </tr>
                </s:iterator>
				<s:if test="page.result.size ==0">
				<tr>
					<td width="100%" height="30" align="center" class="line_b1" colspan="6"><font color="gray">没有符合条件的记录</font></td> 
				</tr>  
				</s:if>     
                </table>
                <ul>
          			<li class=" input">
          				<span class="ll"><input id="batchDel" type="button" value="删除选中" class="button01 mt5 forsubmit" style="width:100px"/></span>
          				<span class="ll"><input type="button" value="新 增" onclick="location.href='graderule!input.action';" class="button01 w60 mt5 forsubmit"/></span>
          				<div class="pager rr">
							<jsp:include page="/common/turnpage.jsp"></jsp:include>
						</div >
          			</li>
	         	</ul>
                </form>
                </div>
                
            </div>
        </div>
        <p>&nbsp;</p>
</body>
</html>
 