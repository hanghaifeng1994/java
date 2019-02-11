<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<div class="dr-panel-footer">
<s:if test="#request.page == null">
<s:if test="page.totalCount>0">
	<!-- turn page.jsp -->
                        <div class="row">
                            <div class="col-md-12">
                                <div class="dr-page">
                                    <ul>
                                        <li><a href="javascript:jumpPage(1)">首页</a></li>
                                        
                                        <s:if test="#request.page.hasPre"><li><a href="javascript:jumpPage(${request.page.prePage})"><span class="glyphicon glyphicon-chevron-left"></span>上一页</a></li></s:if>
                                        
                                        <s:iterator begin="#request.page.startScope" end="#request.page.endScope" step="1" status="stat" var="stepnum"> 
                                         <li>
                                         <s:if test='#stepnum==page.pageNo'>
	                                      	<a style="background-color: #428BCA;border-color: #428BCA;color: #FFFFFF; z-index: 2;" href="javascript:jumpPage(${stepnum})">${stepnum}</a>
	                                        </s:if>
	                                        <s:else>
	                                           <a href="javascript:jumpPage(${stepnum})">${stepnum}</a>
	                                        </s:else>
                                         </li>
                                        </s:iterator>
                                        
                                         <s:if test="#request.page.hasNext"><li><a href="javascript:jumpPage(${request.page.nextPage})">下一页<span class="glyphicon glyphicon-chevron-right"></span></a> </li></s:if>
                                       
                                        <li><a href="javascript:jumpPage(${request.page.totalPages})">尾页</a></li>
                                        <li style="padding: 0 5px;">
                                                                                                            到第
	                                        <input name="pagenum" id="pagenum" type="text" class="form-control" value="" size="3" />
	                                                                                                页
	                                   </li>
	                                   <li>
	                                      <a href="javascript:jumpPage(document.getElementById('pagenum').value,${request.page.totalPages})">跳页</a>
	                                 
                                        </li>
                                    </ul>
                                </div>
                            </div><!--
                             <div class="col-md-6 datatables-info">
                                                                              共${request.page.totalCount}条记录，当前页显示<s:if test="page.pageSize>0">1-${request.page.pageSize}</s:if><s:else>0</s:else>
                            </div>
                       --></div>     
                         
	<!--<span class="fr">
	  <a href="javascript:jumpPage(1)" class="btn btn-info">首页</a>
	  <s:if test="page.hasPre"><a href="javascript:jumpPage(${page.prePage})">上一页</a></s:if>
	  <s:iterator begin="page.startScope" end="page.endScope" step="1" status="stat" var="stepnum"> 
	  <s:if test='#stepnum==page.pageNo'>
	  html设计师是，但是由于独立出来，选中的就突出出去了，暂时去掉 
	    <a href="#" style="border:1px solid #FF5500; background:#FFEEE5; height:18px; line-height:18px; padding:0 5px; display:block; float:left; margin:0 5px; text-decoration:none; color:#FF7400;margin-top:3px;">1</a>
	  
	  	<a style="border:1px solid #FF5500; background:#FFEEE5;text-decoration:none; color:#FF7400;” href="javascript:jumpPage(${stepnum})">${stepnum}</a>
	  </s:if>
	  <s:else>
	   <a href="javascript:jumpPage(${stepnum})">${stepnum}</a>
	  </s:else>
	  </s:iterator>
	  <s:if test="#request.page.hasNext"><a href="javascript:jumpPage(${page.nextPage})">下一页</a></s:if>
	  <a href="javascript:jumpPage(${page.totalPages})">末页</a>	  
	   共<span class="deep_bule">${page.totalPages}</span>页 到第
	   <input name="pagenum" id="pagenum" type="text" class="txt_input0" value="" size="3" />
	页
	<input name="Submit4" type="button" class="operation_btu3" value="跳页" onclick="jumpPage(document.getElementById('pagenum').value,${page.totalPages})" />
	</span>
--></s:if>
</s:if>

<s:else>

<s:if test="#request.page.totalCount>0">
	<!-- turn page.jsp -->
                        <div class="row">
                            <div class="col-md-12">
                                <div class="dr-page">
                                    <ul>
                                        <li><a href="javascript:jumpPage(1)">首页</a></li>
                                        
                                        <s:if test="#request.page.hasPre"><li><a href="javascript:jumpPage(${request.page.prePage})"><span class="glyphicon glyphicon-chevron-left"></span>上一页</a></li></s:if>
                                        
                                        <s:iterator begin="#request.page.startScope" end="#request.page.endScope" step="1" status="stat" var="stepnum"> 
                                         <s:if test='#stepnum==#request.page.pageNo'>
                                         <li style="background-color: #428BCA;color: #FFFFFF;">
	                                      	<a style="background-color: #428BCA;color: #FFFFFF;" href="javascript:jumpPage(${stepnum})">${stepnum}</a>
                                         </li>
	                                        </s:if>
	                                        <s:else>
	                                         <li>
	                                           <a href="javascript:jumpPage(${stepnum})">${stepnum}</a>
	                                         </li>
	                                        </s:else>
                                        </s:iterator>
                                        
                                         <s:if test="#request.page.hasNext"><li><a href="javascript:jumpPage(${request.page.nextPage})">下一页<span class="glyphicon glyphicon-chevron-right"></span></a> </li></s:if>
                                       
                                        <li><a href="javascript:jumpPage(${request.page.totalPages})">尾页</a></li>
                                        <li style="padding: 0 5px;">
                                                                                                            到第
	                                        <input name="pagenum" id="pagenum" type="text" class="form-control" value="" size="3" />
	                                                                                                页
	                                   </li>
	                                   <li>
	                                      <a href="javascript:jumpPage(document.getElementById('pagenum').value,${request.page.totalPages})">跳页</a>
	                                 
                                        </li>
                                    </ul>
                                </div>
                            </div><!--
                             <div class="datatables-info" style="margin-right: 15px;">
                                                                              共${request.page.totalCount}条记录，当前页显示<s:if test="page.pageSize>0">1-<s:property value="page.result.size"/></s:if><s:else>0</s:else>
                            </div>
                        --></div>     
                    <!--
                    
	<span class="fr">
	  <a href="javascript:jumpPage(1)" class="btn btn-info btn-xs">首页</a>
	  <s:if test="#request.page.hasPre"><a href="javascript:jumpPage(${request.page.prePage})" class="btn btn-info btn-xs">上一页</a></s:if>
	  <s:iterator begin="#request.page.startScope" end="#request.page.endScope" step="1" status="stat" var="stepnum"> 
	  <s:if test='#stepnum==#request.page.pageNo'>
	  html设计师是，但是由于独立出来，选中的就突出出去了，暂时去掉 
	    <a href="#" style="border:1px solid #FF5500; background:#FFEEE5; height:18px; line-height:18px; padding:0 5px; display:block; float:left; margin:0 5px; text-decoration:none; color:#FF7400;margin-top:3px;">1</a>
	  
	  	<a style="border:1px solid #FF5500; background:#FFEEE5;text-decoration:none; color:#FF7400;” href="javascript:jumpPage(${stepnum})">${stepnum}</a>
	  </s:if>
	  <s:else>
	   <a href="javascript:jumpPage(${stepnum})">${stepnum}</a>
	  </s:else>
	  </s:iterator>
	  <s:if test="#request.page.hasNext"><a href="javascript:jumpPage(${request.page.nextPage})" class="btn btn-info btn-xs">下一页</a></s:if>
	  <a href="javascript:jumpPage(${request.page.totalPages})" class="btn btn-info btn-xs">末页</a>	  
	   共<span class="deep_bule">${request.page.totalPages}</span>页 到第
	   <input name="pagenum" id="pagenum" type="text" class="txt_input0" value="" size="3" />
	页
	<input name="Submit4" type="button" class="btn btn-info btn-xs" value="跳页" onclick="jumpPage(document.getElementById('pagenum').value,${request.page.totalPages})" />
	</span>-->
</s:if>

</s:else>
</div>