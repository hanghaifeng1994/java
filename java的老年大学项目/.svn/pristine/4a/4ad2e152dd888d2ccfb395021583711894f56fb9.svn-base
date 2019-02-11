<%@ page language="java" pageEncoding="UTF-8" %>
<%@ page import="org.springside.modules.security.springsecurity.SpringSecurityUtils" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
function changeProPhase(obj,curRoleId){
	if($(obj).val()!=null&&$(obj).val()!=""){
		window.location.href="${ctx}/clazz/manage/headerclazz!bulletinAll.action?phaseId="+$(obj).val()+"&curRoleId="+curRoleId+""
	}else{
		window.location.href="${ctx}/clazz/manage/headerclazz!bulletinAll.action?curRoleId="+curRoleId+""
	}
}

function changeClazz(obj,curRoleId){
	if($(obj).val()!=null&&$(obj).val()!=""){
		window.location.href="${ctx}/clazz/manage/headerclazz!bulletin.action?headerClazzId="+$(obj).val()+"&curRoleId="+curRoleId+""+"&phaseId="+$("#phaseId").val()+""
	}else{
		window.location.href="${ctx}/clazz/manage/headerclazz!bulletinAll.action?headerClazzId="+$(obj).val()+"&curRoleId="+curRoleId+""+"&phaseId="+$("#phaseId").val()+""
	}
	
}
</script>
<div class="dr-searchbar">
<div class="form-inline dr-form-inline">
<div class="form-group">

<label>项目：</label><select class="form-control input-sm" id="phaseId" onchange="changeProPhase(this,${curRoleId})" >
<option value="">全部</option>
<s:iterator value="proPhases">
<option value="${id}" <s:if test="phaseId==id">selected="selected"</s:if>>${programName}-${name }</option>
</s:iterator>
</select>
<label>&nbsp;&nbsp;&nbsp;我管理的班级</label><select class="form-control input-sm" onchange="changeClazz(this,${curRoleId})" >
<option value="">全部</option>
<s:iterator value="curHeaderClazzs">
<option value="${id}" <s:if test="headerClazzId==id">selected="selected"</s:if>>${clazz.nameplusStatus}</option>
</s:iterator>
</select>
<span class="help-block" style="display: inline">（开放中：${openClazzNum} | 未开始：${unClazzNum} | 结束：${endClazzNum}）</span>
<input name="curRoleId" id="curRoleId" type="hidden" value="${curRoleId}"/>
</div>
</div>
</div>
<s:if test="headerClazzId!=null">
<div class="panel panel-default">
<div class="panel-body row">
<div class="col-md-12">
<table class="table table-bordered dr-table-default">
  <tr>
    <th width="13%">项目类型</th>
    <td>${curHeaderClazz.clazz.itemName}</td>
    <th>培训项目名称</th>
    <td width="35%">${curHeaderClazz.clazz.programName}</td>
  </tr>
  <tr>
    <th width="13%">项目阶段</th>
    <td width="39%">${curHeaderClazz.clazz.phaseName}</td>
    <th width="13%">培训项目代码</th>
    <td width="39%">${curHeaderClazz.clazz.programCode}</td>
  </tr>
  
   <tr>
    <th width="13%">班级名称</th>
    <td width="39%">${curHeaderClazz.clazz.name}</td>
    <th width="13%">班级代码</th>
    <td width="39%">${curHeaderClazz.clazz.code}</td>
  </tr>
  
  
  <tr>
    <th>班级类型</th>
    <td>${curHeaderClazz.clazz.modelString}</td>
    <th>班级人数</th>
 	<td>${curHeaderClazz.clazz.studentCount} 人</td>
  </tr>
  
    <tr>
    <th>班级开放时间</th>
    <td> 
    <s:if test="curHeaderClazz.clazz.StudyUndate">
                      无限期
    </s:if>
    <s:else>
        <s:date name="curHeaderClazz.clazz.startDate" format="yyyy.MM.dd HH:mm "/> - <s:date name="curHeaderClazz.clazz.closeDate" format="yyyy.MM.dd HH:mm "/>
    </s:else>
    </td>
    <th>班级状态</th>
 	<td>${curHeaderClazz.clazz.stateStr}</td>
  </tr>
</table>
</div>
</div>
</div>
</s:if>
