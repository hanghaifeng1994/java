package cn.common.lib.security.xss;

import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class XssHttpServletRequestWrapperNew extends HttpServletRequestWrapper {

	HttpServletRequest orgRequest = null;

	public XssHttpServletRequestWrapperNew(HttpServletRequest request) {
		super(request);
		orgRequest = request;
	}

	/**
	 * 覆盖getParameter方法，将参数名和参数值都做xss过滤。
	 * 如果需要获得原始的值，则通过super.getParameterValues(name)来获取
	 * getParameterNames,getParameterValues和getParameterMap也可能需要覆盖
	 */
	@Override
	public String getParameter(String name) {
		String value = super.getParameter(xssEncode(name));
		if (value != null) {
			value = xssEncode(value);
		} 
		return value;
	}

	/**
	 * 覆盖getHeader方法，将参数名和参数值都做xss过滤。 如果需要获得原始的值，则通过super.getHeaders(name)来获取
	 * getHeaderNames 也可能需要覆盖
	 */
	@Override
	public String getHeader(String name) {

		String value = super.getHeader(xssEncode(name));
		if (value != null) {
			value = xssEncode(value);
		}
		return value;
	}

	public final static String filterSQLInjection(String s) {
	    if (s == null || "".equals(s)) {
	        return "";
	    }
	    try {
	        s = s.trim().replaceAll("</?[s,S][c,C][r,R][i,I][p,P][t,T]>?", "");//script
	        s = s.trim().replaceAll("[a,A][l,L][e,E][r,R][t,T]\\(", "");// alert
	        s = s.trim().replace("\\.swf", "").replaceAll("\\.htc", "");
	        s = s.trim().replace("\\.php\\b", "").replaceAll("\\.asp\\b", "");
	        s = s.trim().replace("document\\.", "").replaceAll("[e,E][v,V][a,A][l,L]\\(", "");
	        s = s.trim().replaceAll("'", "").replaceAll(">", "");
	        s = s.trim().replaceAll("<", "");
	        s = s.trim().replaceAll(" [o,O][r,R]", "");
	        s = s.trim().replaceAll("etc/", "").replaceAll("cat ", "");
	        s = s.trim().replaceAll("/passwd ", "");
	        s = s.trim().replaceAll("sleep\\(", "").replaceAll("limit ", "").replaceAll("LIMIT ", "");
	        s = s.trim().replaceAll("[d,D][e,E][l,L][e,E][t,T][e,E] ", "");// delete
	        s = s.trim().replaceAll("[s,S][e,E][l,L][e,E][c,C][t,T] ", "");// select;
	        s = s.trim().replaceAll("[u,U][p,P][d,D][a,A][t,T][e,E] ", "");// update
	        s = s.trim().replaceAll("[d,D][e,E][l,L][a,A][y,Y] ", "").replaceAll("waitfor ", "");
	        s = s.trim().replaceAll("print\\(", "").replaceAll("md5\\(", "");
	        s = s.trim().replaceAll("cookie\\(", "").replaceAll("send\\(", "");
	        s = s.trim().replaceAll("response\\.", "").replaceAll("write\\(", "")
	                .replaceAll("&", "");
	    } catch (Exception e) {
	        e.printStackTrace();
	        return "";
	    }
	    return s;
	} 
	public static String escape(String s) {
		StringBuilder sb = new StringBuilder(s.length() + 16);
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			switch (c) {
			case '>':
				sb.append('＞');// 全角大于号
				break;
			case '<':
				sb.append('＜');// 全角小于号
				break;
			case '\'':
				sb.append('‘');// 全角单引号
				break;
/*			case '\"':
				sb.append('“');// 全角双引号
				break;*/
			case '\\':
				sb.append('＼');// 全角斜线
				break;
			case '%':
				sb.append('％'); // 全角冒号
				break;
			default:
				sb.append(c);
				break;
			}

		}
		return sb.toString();
	}

	/**
	 * 将容易引起xss漏洞的半角字符直接替换成全角字符
	 * 
	 * @param s
	 * @return
	 */
	public static String xssEncode(String s) {

		/*
		 * if (s == null || s.isEmpty()) { return s; }
		 * 
		 * StringReader reader = new StringReader(s); StringWriter writer = new
		 * StringWriter(); try { HTMLParser.process(reader, writer, new
		 * XSSFilter(), true);
		 * 
		 * 
		 * String result = writer.toString();
		 * 
		 * System.out.println("xssEncode-------------------------" + s + " = " +
		 * result);
		 * 
		 * return result; } catch (NullPointerException e) { return s; } catch
		 * (Exception ex) { ex.printStackTrace(); }
		 * 
		 * return null;
		 */

		if (s == null || s.isEmpty()) {
			return s;
		}

		String result = stripXSS(s);
		if (null != result) {
			result = escape(result);
		}

		//在过滤sql
		if (null != result) {
			result = filterSQLInjection(result);
		}
		return result;
	}

	public static String stripXSS(String value) {
		if (value != null) {
			// NOTE: It's highly recommended to use the ESAPI library and
			// uncomment the following line to
			// avoid encoded attacks.
			// value = ESAPI.encoder().canonicalize(value);
			// Avoid null characters
			//value = value.replaceAll(" ", "");
			// Avoid anything between script tags
			Pattern scriptPattern = Pattern.compile("<script>(.*?)</script>",
					Pattern.CASE_INSENSITIVE);
			value = scriptPattern.matcher(value).replaceAll("");
			// Avoid anything in a src='...' type of expression
			scriptPattern = Pattern.compile("src[\r\n]*=[\r\n]*\\\'(.*?)\\\'",
					Pattern.CASE_INSENSITIVE | Pattern.MULTILINE
							| Pattern.DOTALL);
			value = scriptPattern.matcher(value).replaceAll("");
			scriptPattern = Pattern.compile("src[\r\n]*=[\r\n]*\\\"(.*?)\\\"",
					Pattern.CASE_INSENSITIVE | Pattern.MULTILINE
							| Pattern.DOTALL);
			value = scriptPattern.matcher(value).replaceAll("");
			// Remove any lonesome </script> tag
			scriptPattern = Pattern.compile("</script>",
					Pattern.CASE_INSENSITIVE);
			value = scriptPattern.matcher(value).replaceAll("");
			// Remove any lonesome <script ...> tag
			scriptPattern = Pattern.compile("<script(.*?)>",
					Pattern.CASE_INSENSITIVE | Pattern.MULTILINE
							| Pattern.DOTALL);
			value = scriptPattern.matcher(value).replaceAll("");
			// Avoid eval(...) expressions
			scriptPattern = Pattern.compile("eval\\((.*?)\\)",
					Pattern.CASE_INSENSITIVE | Pattern.MULTILINE
							| Pattern.DOTALL);
			value = scriptPattern.matcher(value).replaceAll("");
			// Avoid expression(...) expressions
			scriptPattern = Pattern.compile("expression\\((.*?)\\)",
					Pattern.CASE_INSENSITIVE | Pattern.MULTILINE
							| Pattern.DOTALL);
			value = scriptPattern.matcher(value).replaceAll("");
			// Avoid javascript:... expressions
			scriptPattern = Pattern.compile("javascript:",
					Pattern.CASE_INSENSITIVE);
			value = scriptPattern.matcher(value).replaceAll("");
			// Avoid vbscript:... expressions
			scriptPattern = Pattern.compile("vbscript:",
					Pattern.CASE_INSENSITIVE);
			value = scriptPattern.matcher(value).replaceAll("");
			// Avoid onload= expressions
			scriptPattern = Pattern.compile("onload(.*?)=",
					Pattern.CASE_INSENSITIVE | Pattern.MULTILINE
							| Pattern.DOTALL);
			value = scriptPattern.matcher(value).replaceAll("");

			scriptPattern = Pattern.compile("<iframe>(.*?)</iframe>",
					Pattern.CASE_INSENSITIVE);
			value = scriptPattern.matcher(value).replaceAll("");

			scriptPattern = Pattern.compile("</iframe>",
					Pattern.CASE_INSENSITIVE);
			value = scriptPattern.matcher(value).replaceAll("");
			// Remove any lonesome <script ...> tag
			scriptPattern = Pattern.compile("<iframe(.*?)>",
					Pattern.CASE_INSENSITIVE | Pattern.MULTILINE
							| Pattern.DOTALL);
			value = scriptPattern.matcher(value).replaceAll("");
		}
		return value;
	}

	/**
	 * 获取最原始的request
	 * 
	 * @return
	 */
	public HttpServletRequest getOrgRequest() {
		return orgRequest;
	}

	/**
	 * 获取最原始的request的静态方法
	 * 
	 * @return
	 */
	public static HttpServletRequest getOrgRequest(HttpServletRequest req) {
		if (req instanceof XssHttpServletRequestWrapperNew) {
			return ((XssHttpServletRequestWrapperNew) req).getOrgRequest();
		}

		return req;
	}
}