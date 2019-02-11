var menus = [
	{
		name:"登录",
		url:"login/login.do",
		path:"login/login",
		clazz:"PP00"
	},{
		name:"退出登录",
		url:"person/dictDefinition/loginOut.do",
		path:"person/dictDefinition/loginOut",
		clazz:"PP00"
	},{
		name:"词汇搜索",
		url:"person/dictDefinition/searchWord.do",
		path:"person/dictDefinition/searchWord",
		clazz:"PP00"
	},{
		name:"获取个人动态（全部）",
		url:"person/dictDefinition/getMyAllDict.do",
		path:"person/dictDefinition/getMyAllDict",
		clazz:"PP02"
	},{
		name:"获取个人动态（被采纳的）",
		url:"person/dictDefinition/getMyUpdateSuccessDict.do",
		path:"person/dictDefinition/getMyUpdateSuccessDict",
		clazz:"PP02"
	},{
		name:"获取个人动态（我创建的）",
		url:"person/dictDefinition/getMyCreateDict.do",
		path:"person/dictDefinition/getMyCreateDict",
		clazz:"PP02"
	},{
		name:"获取个人动态（个人信息）",
		url:"person/dictDefinition/getMyInfomasion.do",
		path:"person/dictDefinition/getMyInfomasion",
		clazz:"PP02"
	},{
		name:"添加词汇-增加词汇分类",
		url:"person/dictDefinition/addWordClass.do",
		path:"person/dictDefinition/addWordClass",
		clazz:"PP03"
	},{
		name:"添加词汇-获得词汇分类",
		url:"person/dictDefinition/getWordClassify.do",
		path:"person/dictDefinition/getWordClassify",
		clazz:"PP03"
	},{
		name:"添加词汇",
		url:"person/dictDefinition/createDict.do",
		path:"person/dictDefinition/createDict",
		clazz:"PP03"
	},{
		name:"添加新释义",
		url:"person/dictDefinition/addDefinition.do",
		path:"person/dictDefinition/addDefinition",
		clazz:"PP03"
	},{
		name:"采纳释义",
		url:"person/dictDefinition/acceptParaphrase.do",
		path:"person/dictDefinition/acceptParaphrase",
		clazz:"PP03"
	},{
		name:"词汇基本释义",
		url:"person/dictDefinition/dictBasicDefinitions.do",
		path:"person/dictDefinition/dictBasicDefinitions",
		clazz:"PP03"
	},{
		name:"获取评论列表",
		url:"person/dictDefinition/getCommentPage.do",
		path:"person/dictDefinition/getCommentPage",
		clazz:"PP03"
	},{
		name:"采纳释义来源",
		url:"person/dictDefinition/adopDefinitionSource.do",
		path:"person/dictDefinition/adopDefinitionSource",
		clazz:"PP03"
	},{
		name:"原始释义历史修改",
		url:"person/dictDefinition/originalDefinitionHistoricalChanges.do",
		path:"person/dictDefinition/originalDefinitionHistoricalChanges",
		clazz:"PP03"
	},{
		name:"其他释义",
		url:"person/dictDefinition/otherDefinition.do",
		path:"person/dictDefinition/otherDefinition",
		clazz:"PP03"
	},{
		name:"同类词汇",
		url:"person/dictDefinition/sameWords.do",
		path:"person/dictDefinition/sameWords",
		clazz:"PP03"
	},{
		name:"点赞数超过500",
		url:"person/dictDefinition/thumbUpMoreThan500.do",
		path:"person/dictDefinition/thumbUpMoreThan500",
		clazz:"PP03"
	},{
		name:"词汇首页列表-最新释义",
		url:"person/dictDefinition/indexOfNewDict.do",
		path:"person/dictDefinition/indexOfNewDict",
		clazz:"PP01"
	},{
		name:"词汇首页列表-高悬赏词汇",
		url:"person/dictDefinition/indexOfHigthPoint.do",
		path:"person/dictDefinition/indexOfHigthPoint",
		clazz:"PP01"
	},{
		name:"词汇首页列表-热门释义",
		url:"person/dictDefinition/indexOfHotDict.do",
		path:"person/dictDefinition/indexOfHotDict",
		clazz:"PP01"
	},{
		name:"词汇首页列表-周排行",
		url:"person/dictDefinition/topOfWeek.do",
		path:"person/dictDefinition/topOfWeek",
		clazz:"PP01"
	},{
		name:"词汇首页列表-积分达人",
		url:"person/dictDefinition/higthPointPerson.do",
		path:"person/dictDefinition/higthPointPerson",
		clazz:"PP01"
	},{
		name:"点赞",
		url:"person/dictDefinition/thumbUp.do",
		path:"person/dictDefinition/thumbUp",
		clazz:"PP01"
	},{
		name:"发表评论",
		url:"person/dictDefinition/setComment.do",
		path:"person/dictDefinition/setComment",
		clazz:"PP01"
	}
];

var tplMenus = [ '{@each menus as item}',
		'<button class="PP ${item.clazz}" data-url="${item.url}" ',
		' data-path="${item.path}" ',
		' onclick="loadForm(this)">${item.name}</button>', '{@/each}' ]
		.join("");

function loadMenus(ftClass,ftCode,ftName) {
	try {
		var datas = [];
		if (ftClass || ftCode || ftName) {
			for (var i = 0, j = menus.length; i < j; i++) {
				var menu = menus[i];
				if (ftName && ftName.length > 0
						&& menu.name.indexOf(ftName) >= 0) {
					datas.push(menu);
				} else if (ftCode && ftCode.length > 0
						&& menu.url.indexOf(ftCode) >= 0) {
					datas.push(menu);
				} else if (ftClass && ftClass.length > 0
						&& menu.clazz.indexOf(ftClass) >= 0) {
					datas.push(menu);
				}
			}
		} else {
			datas = menus;
		}		
		var html = juicer(tplMenus, {
			menus : datas
		});
		$("#TRAN_AREA").html(html);
	} catch (e) {
		alert(e);
	}
}
