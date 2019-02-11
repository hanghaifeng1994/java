<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<%@ attribute name="nameValue" type="java.lang.String" required="true" description="select name"%>
<%@ attribute name="idValue" type="java.lang.String" required="true" description="select id"%>
<%@ attribute name="val" type="java.lang.String" required="false" description="select value"%>
<%@ attribute name="cssClass" type="java.lang.String" required="false" description="select class"%>
<%@ attribute name="isAll" type="java.lang.String" required="false" description="是否添加全部选项"%>


<select id="${idValue}" name="${nameValue}" class="${cssClass}" value="${val}">
	<c:if test="${isAll == '1'}">
		<option value="">全部</option>
	</c:if>
</select>

<script type="text/javascript">
	var schemeList = [];
    $(document).ready(function() {
        $.get("${ctx}/cfg/CfgSchemeEdition/getListJson",{}, function(data){
            if(!$.isArray(data))
                return;
            var id = '${idValue}';
            var isAll = '${isAll}';
            var ele = $('#' + 	id);
            var val = '${val}';
            if(ele.length == 0 || ele.length > 1)
                return;
            schemeList = data;
            $.each(data, function (i, rec) {
                ele.append($('<option value="' + rec.SCHM_EDT_ID + '" >' + rec.SCHM_EDT_NAME + '</option>'));
            })
//			ele.select2({language: "zh-CN"});
            if(val){
                ele.select2Val(val);
            }
            else if(isAll == '1'){
                ele.select2Val(null);
            }
            else if(schemeList && schemeList.length > 0){
				/*ele.val(schemeList[0].SCHM_ID);
				 ele.trigger('change');*/
                ele.select2Val(schemeList[0].SCHM_EDT_ID);
            }
        }, 'json');
    });

</script>