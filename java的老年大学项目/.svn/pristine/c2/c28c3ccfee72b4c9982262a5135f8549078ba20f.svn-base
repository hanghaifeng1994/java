package com.learnyeai.tools.common;

import org.springframework.util.Assert;

import java.util.*;

/**
 * Map 相关的工具类 提供简单的xpath功能遍历json map;
 * 
 * @author yaoym
 * 
 */
public class MapUtil {

	private static final String[] EMPTY_ARY = {};
	private static final Map EMPTY_MAP = new HashMap();
	private static final List EMPTY_LIST = new ArrayList();

	private static final String SPIT_CHAR = "/";

	/**
	 * 节点遍历<br>
	 * 相当于dom4j.selectSingleNode(xpath)<br>
	 * 
	 * @param map
	 * @param xpath
	 * @return
	 */
	public static Map singleNode(Map map, String xpath) {
		String[] paths = splitPath(xpath);
		return singleNode(map, paths, 0, paths.length - 1);
	}

	/**
	 * 深度遍历节点
	 * 
	 * @param map
	 * @param paths
	 * @param index
	 * @param endIndex
	 * @return
	 */
	private static Map singleNode(Map map, String[] paths, int index,
			int endIndex) {
		if (index > endIndex) {
			return map;
		}
		String curPath = paths[index];
		if (StringUtils.isEmpty(curPath)) {
			if (index < endIndex) {
				return singleNode(map, paths, index + 1, endIndex);
			}
			return EMPTY_MAP;
		}
		Object node = map.get(paths[index]);
		if (null == node) {
			return EMPTY_MAP;
		}
		// 继续深入
		if (node instanceof Map) {
			return singleNode((Map) node, paths, index + 1, endIndex);
		} else if (node instanceof List) {
			System.out.println("current list ");
			List<Map> nodes = (List) node;
			if (nodes != null) {
				return singleNode(nodes.get(0), paths, index + 1, endIndex);
			}
			// System.out.println("list ies empty");
		}
		return EMPTY_MAP;
	}

	private static String[] splitPath(String xpath) {
		if (StringUtils.isEmpty(xpath)) {
			return EMPTY_ARY;
		}
		return xpath.split(SPIT_CHAR);
	}

	/**
	 * 获取单节点文本 <br>
	 * 相当于 dom4j.selectSingleNode(xpath).getText()<br>
	 * 
	 * @param map
	 * @param xpath
	 * @return
	 */
	public static String singleNodeText(Map map, String xpath) {
		String[] paths = splitPath(xpath);
		if (paths.length > 1) {
			String last = paths[paths.length - 1];
			Map node = singleNode(map, paths, 0, paths.length - 2);
			if (null != node)
				return getMapString(node, last, "");
			return "";
		}
		return getMapString(map, xpath, "");
	}

	public static <T> T singleNodeValue(Map map, String xpath) {
		String[] paths = splitPath(xpath);
		if (paths.length > 1) {
			String last = paths[paths.length - 1];
			Map node = singleNode(map, paths, 0, paths.length - 2);
			if (null != node)
				return getMapValue(node, last, null);
			return null;
		}
		return getMapValue(map, xpath, null);
	}

	private static String getMapString(Map node, String key, String def) {
		if (node.containsKey(key) && node.get(key) != null) {
			Object o = node.get(key);
			return node.get(key)+"";
		}
		return def;
	}

	/**
	 * 获取列表 相当于 dom4j.selectNodes(xpath) <br>
	 * 
	 * @param map
	 * @param xpath
	 * @return
	 */
	public static List selectNodes(Map map, String xpath) {
		String[] paths = splitPath(xpath);
		if (paths.length > 1) {
			Object obj = singleObject(map, paths, 0, paths.length - 1);
			if (obj instanceof List) {
				return (List) obj;
			}
			return EMPTY_LIST;
		}
		Object obj = map.get(xpath);
		if (obj instanceof List) {
			return (List) obj;
		}
		return EMPTY_LIST;
	}

	private static Object singleObject(Map map, String[] paths, int index,
			int endIndex) {
		if (index > endIndex) {
			return map;
		}
		String curPath = paths[index];
		if (StringUtils.isEmpty(curPath)) {
			if (index < endIndex) {
				return singleObject(map, paths, index + 1, endIndex);
			}
			return EMPTY_MAP;
		}
		Object node = map.get(paths[index]);
		if (null == node) {
			return null;
		}
		// System.out.println("current index: " + index + ":" + node);
		// 继续深入
		if (node instanceof Map) {
			return singleObject((Map) node, paths, index + 1, endIndex);
		} else if (node instanceof List) {
			// System.out.println("current list ");
			List<Map> nodes = (List) node;
			if (nodes != null) {
				if (index == endIndex)
					return nodes;
				return singleObject(nodes.get(0), paths, index + 1, endIndex);
			}
			// System.out.println("list ies empty");
		}
		return null;
	}

	public static String toListPath(String xpath) {
		if (xpath != null) {
			return xpath.replaceAll("\\/e\\/", "/");
		}
		return null;
	}

	/**
	 * 任意位置节点 <br>
	 * 任意节点查找以//开头，不支持两层连续列表<br>
	 * <span>真实路径：list/map/AcctNo </span><br>
	 * <span>任意节点 写法：//map/AcctNo </span><br>
	 * <span>任意节点 写法：//AcctNo </span>
	 * 
	 * @param map
	 * @param xpath
	 * @return
	 */
	public static String singleAnsyNodeText(Map map, String xpath, String def) {
		// if (xpath == null || !xpath.startsWith("//")) {
		// return "";
		// }
		// xpath = xpath.substring(2);

		Object obj = singleAnsyNode(map, xpath.split("/"), 0, false);
		return obj == null ? def : obj.toString();
	}

	/**
	 * 任意节点查找以//开头，不支持两层连续列表<br>
	 * <span>list/map/AcctNo </span><br>
	 * <span>//map/AcctNo </span>
	 * 
	 * @param map
	 * @param xpaths
	 * @param index
	 * @param needJoin
	 *            是否已开始
	 * @return
	 */
	private static Object singleAnsyNode(Map map, String[] xpaths, int index,
			boolean needJoin) {
		needJoin = needJoin ? true : map.containsKey(xpaths[index]);
		if (needJoin) {
			Object obj = map.get(xpaths[index]);
			if (obj == null) {
				return null;
			}
			if (index == (xpaths.length - 1)) {
				// 已适配完成
				return obj;
			}
			// System.out.println("-------" + xpaths[index]);
			if (obj instanceof Map) {
				return singleAnsyNode((Map) obj, xpaths, index + 1, true);
			} else if (obj instanceof List) {
				// 进入列表遍历:最多两层连续的列表
				List datas = (List) obj;
				Object next = datas.get(0);
				if (next instanceof Map) {
					return singleAnsyNode((Map) next, xpaths, index + 1, true);
				} else if (next instanceof List) {
					// 进入第二层列表递归
					return null;
				}
			}
		} else {
			Set<String> keys = map.keySet();
			for (String key : keys) {
				Object item = map.get(key);
				if (item instanceof List) {
					// 进入列表遍历:不支持连续的列表
					List datas = (List) item;
					Object next = datas.get(0);
					if (next instanceof Map) {
						return singleAnsyNode((Map) next, xpaths, 0, false);
					}
				} else if (item instanceof Map) {
					return singleAnsyNode((Map) item, xpaths, 0, false);
				}
			}
		}
		return null;
	}

	public static <T> T getMapValue(Map map, String key, Object def) {
		if (null != map && null != key && map.containsKey(key)) {
			try {
				return (T) map.get(key);
			} catch (Exception e) {
			}
		}
		return (T) def;
	}

	public static <T> T getMapValue(Map map, String key, Object def, Class<T> czz) {
		if (null != map && null != key && map.containsKey(key)) {
			try {
				return TypeHelper.toType(map.get(key), czz);
			} catch (Exception e) {
			}
		}
		return (T) def;
	}

	/**
	 * 清理currs没有的key内容
	 * 
	 * @param map
	 * @param currs
	 */
	public static void cleanMap(Map<String, ?> map, List<String> currs) {
		List<String> outs = new ArrayList<String>();
		for (String key : map.keySet()) {
			if (!currs.contains(key))
				outs.add(key);
		}
		for (String out : outs) {
			map.remove(out);
		}
	}
	public static void cleanMap(Map<String, ?> map, String... currs) {
		cleanMap(map, Arrays.asList(currs));
	}

	/**
	 * 保留map中的值，删除其它数据
	 * @param map
	 * @param keys
     */
	public static void holdMap(Map<String, ?> map, String... keys){
		Map newMap = new HashMap();
		for (String key : keys){
			newMap.put(key, map.get(key));
		}
		map.clear();
		map.putAll(newMap);
	}

	public static Map copyMap(Map<String, ?> map, List<String> currs) {
		Map rtnMap = new HashMap();
		for (String key : map.keySet()) {
			if (currs.contains(key))
				rtnMap.put(key, map.get(key));
		}
		return rtnMap;
	}
	public static Map copyMap(Map<String, ?> map, String... currs) {
		return copyMap(map, Arrays.asList(currs));
	}
	public static Map newMap(Object... keyvals){
		HashMap rtnMap = new HashMap();
		if(keyvals.length % 2 > 0)
			return rtnMap;
		for(int i=0; i< keyvals.length; i=i+2){
			rtnMap.put(keyvals[i], keyvals[i+1]);
		}
		return rtnMap;
	}

	public static Map getMapWithkeyStart(Map prop, String prefix) {
		Assert.isTrue(prefix != null,"前缀不能为空");
		prefix = prefix + ".";
		int prefixLen = prefix.length();
		Map pp = new HashMap<>();

		for (Object key : prop.keySet()) {
			if(!(key instanceof String)) {
				continue;
			}

			if(((String) key).startsWith(prefix)) {
				pp.put(((String) key).substring(prefixLen), prop.get(key));
			}
		}
		return pp;
	}

	/**
	 * 转换map
	 * @param source 原map
	 * @param key2Keys 原key - 》 目标key
     * @return 转换后map
     */
	public static Map transformMap(Map<String,?> source, String... key2Keys){
		HashMap rtnMap = new HashMap();
		if(key2Keys.length % 2 > 0)
			return rtnMap;
		for(int i=0; i< key2Keys.length; i=i+2){
			rtnMap.put(key2Keys[i+1], source.get(key2Keys[i]));
		}
		return rtnMap;
	}

	public static void main(String[] args) {
		Map map = new HashMap();
		Map subMap = new HashMap();
		Map subMap2 = new HashMap();
		map.put("a", subMap);
		subMap.put("b", subMap2);
		subMap2.put("c", "aaaaaa");

		System.out.println(singleAnsyNodeText(map, "a/b/c", ""));
	}
}