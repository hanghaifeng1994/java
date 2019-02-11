package com.learnyeai.learnai.net.netConf;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 配置节点
 * 
 * @author yaoym
 * 
 */
public class MBTransItem {
	private String name;
	private String targetName; // 取值字段名，如果为空用name取值
	private String type;
	private boolean requred;
	private String desc;
	private String xmlPath;
	private Integer dolt;// 小数位数
	private String dateFormat; // 日期格式
	// 值类型 dict本地字典、cons常量、res资源
//	private String valType;
	// 数据字典，类型(根据name对应的值，取得数据字典中的标签)
	private String dictType;
	// 缺省功能
	private String defaultValue;



	private int length;// 内容长度
	// 别名：用于定义ALISE // 注：没用到zhangpz 20170215
	private String aliseName;
	// 扩展字段
	private String plugin;
	// LIST固定元素个数
	private String sizeField;// hl add 请求list长度
	
	private String comment;// 字典备注
	/**
	 * 属性字段
	 */
	private Map<String, String> properties = new HashMap<String, String>();

	public String getSizeField() {
		return sizeField;
	}

	public void setSizeField(String sizeField) {
		this.sizeField = sizeField;
	}

	private List<MBTransItem> children;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public boolean isRequred() {
		return requred;
	}

	public void setRequred(boolean requred) {
		this.requred = requred;
	}

	public List<MBTransItem> getChildren() {
		return children;
	}

	public void setChildren(List<MBTransItem> map) {
		this.children = map;
	}

	public String getDictType() {
		return dictType;
	}

	public void setDictType(String dictType) {
		this.dictType = dictType;
	}

	public String getDefaultValue() {
		return defaultValue;
	}

	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}

	/*public String getValType() {
		return valType;
	}

	public void setValType(String valType) {
		this.valType = valType;
	}*/

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getTargetName() {
		return targetName;
	}

	public void setTargetName(String targetName) {
		this.targetName = targetName;
	}

	public String getXmlPath() {
		return xmlPath;
	}

	public void setXmlPath(String xmlPath) {
		this.xmlPath = xmlPath;
	}

	public String getAliseName() {
		return aliseName;
	}

	public void setAliseName(String aliseName) {
		this.aliseName = aliseName;
	}

	public String getPlugin() {
		return plugin;
	}

	public void setPlugin(String plugin) {
		this.plugin = plugin;
	}
	
	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Integer getDolt() {
		return dolt;
	}

	public void setDolt(Integer dolt) {
		this.dolt = dolt;
	}

	public String getDateFormat() {
		return dateFormat;
	}

	public void setDateFormat(String dateFormat) {
		this.dateFormat = dateFormat;
	}

	public Map<String, String> getProperties() {
		return properties;
	}

	public void setPropery(String key, String value) {
		properties.put(key, value);
	}

	public String getProperty(String key) {
		if(!properties.containsKey(key))
			return null;
		return properties.get(key);
	}

	@Override
	public String toString() {
		StringBuffer bf = new StringBuffer();
		bf.append("[name:").append(name);
		bf.append(",\t targetName:").append(targetName);
		bf.append(",\t type:").append(type);
		bf.append(",\t desc:").append(desc);
		bf.append(",\t length:").append(length);
		bf.append(",\t dolt:").append(dolt);
		bf.append(",\t required:").append(requred);
		bf.append(",\t default:").append(defaultValue);
		bf.append(",\t dictType:").append(dictType);
		bf.append(",\t xpath:").append(xmlPath);
		bf.append(",\t plugin:").append(plugin);
		bf.append(",\t aliseName:").append(aliseName);
		bf.append(",\t comment:").append(comment);
		bf.append("]");
		return bf.toString();
	}

	public Map toMap() {
		Map map = new HashMap();
		map.put("name", name);
		map.put("targetName", targetName);
		map.put("type", type);
		map.put("desc", desc);
		map.put("length", length);
		map.put("required", requred);
		map.put("default", defaultValue);
		return map;
	}

}