/**
 * 验证用户名
 * @author qingang
 * @since 2011-02-14
 */	
function onVaild(){
	if(document.getElementById('username').value==''){
			$("#error_username").html("请输入身份证号！");
			$("#username").focus();
			return false;
	}else if(document.getElementById('username').value=='demo'){
			alert("测试用户不能修改密码！");
			return false;
	}else{
		$.post("./findpwd!vaild.excsec",{"username":$("#username").val()},function(data) {
			var data = eval(data);
			if(data.value=="false"){
				//alert(data.label)
				$("#error_username").html(data.label);
				$("#username").focus();
				$("#username").select();
			}else{
				/*document.getElementById('first_div').style.display="none";
				document.getElementById('second_div').style.display="block";
				document.getElementById('answer_span').innerHTML=data.label;
				$("#answer").focus();*/
				//document.getElementById('second_div').style.display="none";
				document.getElementById('first_div').style.display="none";
				document.getElementById('third_div').style.display="";
				$("#pwd").focus();
			}
		});
	}
}

/**
 * 密码问题验证
 * @author qingang
 * @since 2011-02-14
 */
function onAnswer(){
	if(document.getElementById('answer').value==''){
			$("#error_answer").html("请输入密码答案！");
			return false;
	}else{
		$.post("./findpwd!answer.excsec",{"username":$("#username").val(),"answer":$("#answer").val()},function(data) {
			var data = eval(data);
			if(data.value=="false"){
				//document.getElementById('second_span').style.display="";
				$("#error_answer").html(data.label);
				$("#answer").focus();
				$("#answer").select();
			}else{
				document.getElementById('second_div').style.display="none";
				document.getElementById('third_div').style.display="";
				$("#pwd").focus();
			}
		});
	}
}
/**
 * 设置新密码
 * @author qingang
 * @since 2011-02-14
 */
function onSetPassword(){
	var passw = document.getElementById('pwd').value
	if(document.getElementById('pwd').value==''){
		$("#error_pwd").html("请输入新密码！");		
		return false;
	}else if(passw.length < 6 || passw.length > 18){
		$("#error_pwd").html("新密码至少6位，不能超过18位！");		
		return false;
	}
	else if(document.getElementById('repwd').value==''){
		$("#error_repwd").html("请输入重复新密码！");		
		return false;	
	}else if(document.getElementById('pwd').value!=document.getElementById('repwd').value){
		$("#error_repwd").html("两次密码输入不一致！");
		return false;
	}else{
		$.post("./findpwd!setPwd.excsec",{"username":$("#username").val(),"pwd":$("#pwd").val()},function(data) {
			var data = eval(data);
			if(data.value=="false"){
				$("#error_pwd").html(data.label);
			}else{
				document.getElementById('third_div').style.display="none";
				document.getElementById('fourth_div').style.display="block";
			}
		});
	}
}