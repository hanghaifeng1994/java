$(document).ready(function(){
	//推荐/取消推荐文章
	var articles = $("a[rel]");
	for(var i = 0;i < articles.length;i++){
		$(articles[i]).click(function(){
			var id = $(this).attr("rel");
			var curState = $(this).attr("rev");
			$.ajax({
				url:"vote!set.action",
				data:"id="+id+"&curState="+curState,
				dataType:"json",
				success:function(data){
					if(data){
						if("true" == curState){
							$("a[rel='"+id+"']").attr("rev",false);
							$("a[rel='"+id+"']").html("<img class=\"operimg\" src=\"${ctx}/image/button/headtopic_3.gif\" title=\"推荐\" border=\"0\" width=\"16\" height=\"16\"/>");
							$("#voteFlag"+id).html("还没推荐");
							alert("推荐成功");
						}else{
							$("a[rel='"+id+"']").attr("rev",true);
							$("a[rel='"+id+"']").html("<img class=\"operimg\" src=\"${ctx}/image/button/headtopic_2.gif\" title=\"取消推荐\" border=\"0\" width=\"16\" height=\"16\"/>");
							$("#voteFlag"+id).html("已经推荐");
							alert("取消推荐成功");
						}
					}else{
						alert("操作失败，稍后再试");
					}
				}
			})
		});
	}
	//全选/取消全选文章
	var selected = false;
	$("#selectAndCancel").click(function(){
		var checkboxs = $("input[name='ids']");
		if(!selected){
			for(var i = 0;i < checkboxs.length; i++){
				$(checkboxs[i]).attr("checked",true);
			}
			selected = true;
		}else{
			for(var i = 0;i < checkboxs.length; i++){
				$(checkboxs[i]).attr("checked",false);
			}
			selected = false;
		}
	})
	
	//验证批量删除文章的列表非空与否
	$("form[name='deleteForm']").submit(function(){
		var checked = false;
		var checkbox = $("input[name='ids']:checked").each(function(){
			checked = true;
		});
		if(!checked){
			alert("至少要选择一个投票");
		}else{
			return confirm("您确认要删除这些投票吗?");
		}
		return checked;
	})
	
	
})