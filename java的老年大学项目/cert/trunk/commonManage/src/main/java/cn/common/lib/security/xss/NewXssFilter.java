package cn.common.lib.security.xss;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;

public class NewXssFilter implements Filter {

	FilterConfig filterConfig = null;

	@Override
	public void destroy() {
		this.filterConfig = null;
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		// 有sql关键字，跳转到error.html
		boolean isError=false;
		String contentType=req.getContentType();
		if(StringUtils.isNotBlank(contentType)&&contentType.contains("multipart/form-data")){
			isError =false;
		}else{
		    isError =false;// validatePayload(req);
		}
		/*
		 * String sql = ""; try{ sql = addSql(req); }catch (Exception e) {
		 * isError = true; // TODO: handle exception }
		 */
		/*
		 * if(!isError){ isError = sqlValidate(sql); }
		 */
		if (!isError) {
			isError = validateParaNames(req);
		}
		if (isError) {
			request.getRequestDispatcher("/common/501.jsp").forward(request,
					response);
		} else {
			chain.doFilter(request, response);
		}
	}

	@SuppressWarnings("unchecked")
	private String addSql(HttpServletRequest req) throws Exception {
		String sql = "";
		try {
			// 获得所有请求参数名
			Enumeration params = req.getParameterNames();
			while (params.hasMoreElements()) {
				// 得到参数名
				String name = params.nextElement().toString();
				// System.out.println("name===========================" + name +
				// "--");
				// 得到参数对应值
				String[] value = req.getParameterValues(name);

				for (int i = 0; i < value.length; i++) {
					if (value[i].length() > 0) {
						sql = sql + value[i];
					}
				}
			}
		} catch (Exception e) {
			throw new Exception("get praramter error");
			// TODO: handle exception
		}
		return sql;
	}

	private boolean validatePayload(HttpServletRequest req) {
		String payload = getRequestPayload(req);
		if (StringUtils.isNotBlank(payload)) {
			String[] kvs = payload.split("&");
			for (String kv : kvs) {
				if (StringUtils.isNotBlank(kv)) {
					String[] paramValue = kv.split("=");
					if (paramValue.length > 0) {
						if (validateParamNvalue(
								paramValue[0],
								new String[] { paramValue.length > 1 ? paramValue[1]
										: "" }))
							return true;
					}

				}
			}
		}
		return false;

	}

	private String getRequestPayload(HttpServletRequest req) {
		StringBuilder sb = new StringBuilder();
		try {
			BufferedReader reader = req.getReader();
			char[] buff = new char[1024];
			int len;
			while ((len = reader.read(buff)) != -1) {
				sb.append(buff, 0, len);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sb.toString();
	}

	private boolean validateParamNvalue(String name, String[] values) {
		String newName = XssHttpServletRequestWrapperNew.xssEncode(name);
		if (!name.equals(newName)) {
			return true;// 有非法字符
		}
		String oldValue;
		String newValue;
		for (int i = 0; i < values.length; i++) {
			oldValue = values[i];
			if (StringUtils.isNotEmpty(oldValue)) {
				oldValue = oldValue.trim();
				newValue = XssHttpServletRequestWrapperNew.xssEncode(oldValue);
				if (!oldValue.equals(newValue)) {
					return true;// 有非法字符
				}
			}
		}
		return false;

	}

	/**
	 * 处理参数名和值 是否有非法字符
	 * 
	 * @param req
	 * @return 2017.3.27 chenbo 重写此方法 见下
	 */
	/*
	 * @SuppressWarnings("unchecked") private boolean
	 * validateParaNames(HttpServletRequest req){ Enumeration params =
	 * req.getParameterNames(); while (params.hasMoreElements()) { //得到参数名
	 * String name = params.nextElement().toString(); String newName =
	 * XssHttpServletRequestWrapperNew.xssEncode(name);
	 * if(!name.equals(newName)){ return true;//有非法字符 }
	 * //System.out.println("name===========================" + name + "--");
	 * //得到参数对应值 String[] value = req.getParameterValues(name); String newValue;
	 * String oldValue; for (int i = 0; i < value.length; i++) { oldValue =
	 * value[i]; if(StringUtils.isNotEmpty(oldValue)){ oldValue =
	 * oldValue.trim(); newValue =
	 * XssHttpServletRequestWrapperNew.xssEncode(oldValue);
	 * if(!oldValue.equals(newValue)){ return true;//有非法字符 } } } } return false;
	 * }
	 */

	@SuppressWarnings("unchecked")
	private boolean validateParaNames(HttpServletRequest req) {
		Enumeration params = req.getParameterNames();
		while (params.hasMoreElements()) {
			// 得到参数名
			String name = params.nextElement().toString();

			String[] values = req.getParameterValues(name);
			if (validateParamNvalue(name, values))
				return true;
		}
		return false;
	}

	// 效验
	protected static boolean sqlValidate(String str) {
		str = str.toLowerCase();// 统一转为小写
		String badStr = "'|and|exec|execute|insert|select|delete|update|count|drop|*|%|chr|mid|master|truncate|"
				+ "char|declare|sitename|net user|xp_cmdshell|;|or|+|,|like'|and|exec|execute|insert|create|drop|confirm|script|"
				+ "table|from|grant|use|group_concat|column_name|"
				+ "information_schema.columns|table_schema|union|where|select|delete|update|order|by|count|*|"
				+ "chr|mid|master|truncate|char|declare|or|;|--|+|,|like|//|/|%|#";// 过滤掉的sql关键字，可以手动添加
		String[] badStrs = badStr.split("\\|");
		for (int i = 0; i < badStrs.length; i++) {
			if (str.indexOf(badStrs[i]) >= 0) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;
	}
}