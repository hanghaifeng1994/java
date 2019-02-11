package cn.com.weye.core.utils;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;


/**
 * HTPP请求参数转换工具类
 * <ul>
 * <li>A => _A: 加工参数</li>
 * <li>A => A ：保留原参数</li>
 * <li>_A=>_A : 保留加工过的参数</li>
 * <li>_A=> A : 还原加工过的参数</li>
 * </ul>
 * @author uke
 * 
 */
public class ParamCover {
	/**
	 * HttpServletRequest 参数前缀
	 */
	private static final String PREX = "_";
	private HttpServletRequest request;
	private String[] forbids = new String[] { "action", "pageNo", "v"};

	public ParamCover(HttpServletRequest request) {
		this.request = request;
	}


	/**
	 * 解析参数, 将_a => _a, 参数以Hidden Input方式存储
	 * 注：prex前缀参数，生成input
	 * 使用场景：list页面跳转到其它页面中，再重定向到list页面时的参数，如form页面中保存表单中引入
	 *  在跳转的action中需要添加参数：调用defixParam添加到redirectAttributes
	 *  redirectAttributes.addAllAttributes(getParamCover(request).defixParam(request));
	 * @return
	 */
	public String getUnCovered_Inputs() {
		return ParamUtil.generyFixParamToHtml(request, PREX);
	}

	/**
	 * 还原加工的参数，将_a => a，参数以Hidden Input方式存储 未包含_backUrl
	 * 注：只把前缀prex的参数，转换成input，并去掉prex
	 * 使用场景：list页面跳转到其它页面，返回到list页面中，如form页面中点击标签中的连接，返回到list页面
	 * @return
	 */
	public String getDecodeInputs() {
		return ParamUtil.decodeParamToHtml(request, PREX);
	}

	/**
	 * 加工参数，a => _a ，参数以Hidden Input方式存储
	 * 注：所有参数名前缀都加prex
	 * <ul>
	 * <li>参数名不包括action</li>
	 * <li>参数名不包括空值及NULL值</li>
	 * </ul>
	 * 使用场景：list页面中，删除等操作不需要跳转页面，需要用户确认时
	 * @return
	 */
	public String getCoveredInputs() {
		return ParamUtil.fixParamToHtml(request, PREX);
	}

	/**
	 * 解析参数, 将a => a, 参数以Hidden Input方式存储
	 * 注：所有参数不变输出
	 * 使用场景：list页面，搜索表单中引入
	 * @return
	 */
	public String getUnCoveredInputs() {
		return ParamUtil.fixParamToHtml(request, "");
	}






	/**
	 * 解析参数, 将a => a, 参数以Hidden Input方式存储, 除必要的forbids参数外
	 *
	 * @return
	 */
	public String getUnCoveredForbidInputs() {
		return ParamUtil.forbidFixParamToHtml(request, "", forbids);
	}


	public String[] getForbids() {
		return forbids;
	}

	public void setForbids(String[] forbids) {
		this.forbids = forbids;
	}

	/**
	 * 将裝飾過的HttpServletRequest參數分离出来，存储到MAP中
	 * <li>request: _name ==> map:_name </li>
	 *
	 * @param request
     * @return
     */
	public Map enfixParam(HttpServletRequest request) {
		return ParamUtil.enfixParam(request, PREX);
	}

	/**
	 *< li>还原被装饰过的HttpServletRequest參數</li>
	 * <li>去除装饰，并将还原后的参数存储到MAP中</li>
	 * <li>request: _name ==> map:name </li>
	 * @param request
	 * @return
     */
	public Map defixParam(HttpServletRequest request) {
		return ParamUtil.defixParam(request, PREX);
	}

	public <E> E get(){
		return null;
	}
}