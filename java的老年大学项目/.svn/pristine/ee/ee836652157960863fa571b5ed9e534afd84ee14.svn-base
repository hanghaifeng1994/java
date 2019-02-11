package com.learnyeai.learnai.net.netConf;

import java.util.ArrayList;
import java.util.List;

import com.learnyeai.learnai.net.INetConfParser;
import com.learnyeai.core.config.ConfigUtils;
import com.learnyeai.core.utils.SpringContextUtils;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.learnyeai.learnai.net.INetConfCaches;
import com.learnyeai.learnai.error.AresRuntimeException;
import com.learnyeai.tools.common.StringUtils;
import com.learnyeai.tools.common.XmlUtil;

/**
 * 加载报文定义
 * 
 * @author LQ
 * 
 */
@Component
public class NetConfParser implements INetConfParser {
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private INetConfCaches ebankConfCaches;
	private String rootpath = ConfigUtils.getValue("DISGRAM_PATH");
	private String template = "{0}{1}.xml";

	public NetConfParser() {
		logger.debug("netbank trans conf path:{}", rootpath);
	}

	public synchronized MBTransConfBean findTransConfById(String id, String prex) {
		MBTransConfBean result = null;
		id = prex + id;// 报文相对路径，唯一性；
		id = id.replaceAll("[\\\\/]+", "/");
		if(id.indexOf("/") == 0){
			id = id.substring(1);
		}
		String filePath = StringUtils.message(template, rootpath, id);
//		filePath = filePath.replaceAll("/[\\\\/]+/", "/");
		if(true)
//		if (!ebankConfCaches.hasTransConfById(id))
		{
			// 当前缓存中没有配置信息进行加载
			Document doc = null;
			logger.debug("trans defined file :{}", filePath);
			try {
				String txt = SpringContextUtils.loadUtf8Resouce(filePath);
				doc = XmlUtil.readText(txt);
			} catch (Exception e) {
				logger.warn("common.file_not_found:", filePath);
				throw new AresRuntimeException("common.file_not_found");
			}
			logger.debug("trans defined file :{}", filePath);
			if (doc != null && doc.hasContent()) {
				Element root = doc.getRootElement();
				MBTransConfBean confbean = parserObject(root);
				ebankConfCaches.addTransConf(id, confbean);
				result = confbean;
			} else {
				logger.error("transcation defined failure:{}", id);
			}
		} else {
			result = ebankConfCaches.getTransConfById(id);
		}
		return result;
	}

	public MBTransConfBean parserObject(Element el) {
		MBTransConfBean conf = new MBTransConfBean();
		conf.setName(el.attributeValue(NetConst.AT_NAME));
		List<Attribute> datas = el.attributes();

		if (el.hasContent()) {
			List<Element> list = el.elements();
			for (Element e : list) {
				if (e.getName().equals(NetConst.XT_SEND)) {
					parserSnd(e, conf);
				} else if (e.getName().equals(NetConst.XT_RCV)) {
					parserRce(e, conf);
				}else if(e.getName().equals(NetConst.XT_SEND_HEAD)){
					parserSndHeader(e,conf);
				}
			}
		}

		boolean isPage = false;
		String sorts = null;
		if(el.attribute("isPage") != null)
			isPage = true;
		if(el.attribute("sorts") != null)
			sorts = el.attribute("sorts").getValue();
		for (Attribute data : datas) {
			conf.setPropery(data.getName(), data.getValue());

		}
		// 添加请求参数
		if(sorts != null){
			MBTransItem st = new MBTransItem();
			st.setName("sorts");
			st.setXmlPath(st.getName());
			st.setDesc("排序");
			st.setComment(sorts + "，格式：a=1&b=0,说明1：升序、0倒序");
			conf.addSedItem(st);
		}
		// 分页
		// 排序
		if(isPage){
			MBTransItem pgno = new MBTransItem();
			pgno.setName("page");
			pgno.setXmlPath(pgno.getName());
			pgno.setDesc("页码");
			conf.addSedItem(pgno);
			MBTransItem pgsz = new MBTransItem();
			pgsz.setName("rows");
			pgsz.setXmlPath(pgsz.getName());
			pgsz.setDesc("页长");
			conf.addSedItem(pgsz);
		}
		return conf;
	}

	/**
	 * 解析发送配置节点
	 * 
	 * @param el
	 * @param transConf
	 */
	public void parserSnd(Element el, MBTransConfBean transConf) {
		List<Element> list = el.elements();
		for (Element e : list) {
			// 仅支持非列表的字段解析
			MBTransItem item = new MBTransItem();
			parseCommonItem(e, item);
			transConf.addSedItem(item);
		}
	}

	/**
	 * 解析发送配置节点
	 * 
	 * @param el
	 * @param transConf
	 */
	public void parserSndHeader(Element el, MBTransConfBean transConf) {
		List<Element> list = el.elements();
		for (Element e : list) {
			if (e.getName().equals(NetConst.XT_ITEM)) {
				// 仅支持非列表的字段解析
				MBTransItem item = new MBTransItem();
				parseCommonItem(e, item);
//				parseListChildItem(item, e);
				logger.debug("send item:{}", item);
				transConf.addSendHeaderItem(item);
			}
		}
	}

	/**
	 * 解析接受配置节点
	 * 
	 * @param el
	 * @param transConf
	 */
	public void parserRce(Element el, MBTransConfBean transConf) {
		List<Element> list = el.elements();
		for (Element e : list) {
			MBTransItem item = new MBTransItem();
			parseCommonItem(e, item);
			logger.debug("rcv item :{}", item);
			/*if (isListItem(e)) {
				// 如果类型是list 则进行 子节点解析
				List<Element> children = e.elements();
				List<MBTransItem> subList = new ArrayList<MBTransItem>();
				for (Element mapel : children) {
					MBTransItem subItem = new MBTransItem();
					parseCommonItem(mapel, subItem);
					parseListChildItem(subItem, mapel);
					subList.add(subItem);
				}
				item.setChildren(subList);
			}*/
			transConf.addRcvItem(item);
		}
	}

	public void parserRceHeader(Element el, MBTransConfBean transConf) {
		List<Element> list = el.elements();
		for (Element e : list) {
			MBTransItem item = new MBTransItem();
			parseCommonItem(e, item);
			/*if (isListItem(e)) {
				// 如果类型是list 则进行 子节点解析
				List<Element> children = e.elements();
				List<MBTransItem> subList = new ArrayList<MBTransItem>();
				for (Element mapel : children) {
					MBTransItem subItem = new MBTransItem();
					parseCommonItem(mapel, subItem);
					parseListChildItem(subItem, mapel);
					subList.add(subItem);
				}
				item.setChildren(subList);
			}*/
			transConf.addRcvHeaderItem(item);
		}
	}

	/**
	 * 加载接受报文的字段定义
	 * 
	 * @param e
	 * @param item
	 * @return
	 */
	private boolean parseCommonItem(Element e, MBTransItem item) {
		List<Attribute> datas = e.attributes();
		for (Attribute data : datas) {
			item.setPropery(data.getName(), data.getValue());
		}

		String name = e.attributeValue(NetConst.AT_NAME);
//		String targetName = e.attributeValue(NetConst.AT_TARGET_NAME);
		String desc = e.attributeValue(NetConst.AT_DESC);
		String type = e.attributeValue(NetConst.AT_TYPE);
		String length = e.attributeValue(NetConst.AT_LEN);
		String required = e.attributeValue(NetConst.AT_REQUIRED);
		String dictType = e.attributeValue(NetConst.AT_DICT_TYPE);
		String xpath = e.attributeValue(NetConst.AT_XPATH);
		String defaultValue = e.attributeValue(NetConst.AT_DEFVAL);
		String plugin = e.attributeValue(NetConst.AT_PLUS);
		String sizeField = e.attributeValue(NetConst.AT_SIZE_FIELD);
		String comment = e.attributeValue(NetConst.AT_COMMENT);
		String dateFormat = e.attributeValue(NetConst.AT_DATE_FORMAT);
		/*String valType = e.attributeValue(NetConst.AT_VAL_TYPE);
		if(null == valType)
			valType = "0";
		int vvType = isListItem(e);
		switch (vvType){
			case 1:
				valType = NetConst.FILED_TYPE_E;
				break;
			case 2:
				valType = NetConst.FILED_TYPE_OE;
				break;
		}*/

//		targetName = StringUtils.isEmpty(targetName) ? name : targetName;
		int dolt = -1;
		{
			String ss = e.attributeValue(NetConst.AT_DOLT);
			try {
				if(null != ss){
					dolt = Integer.parseInt(ss);
				}

			}catch (Exception t){
				logger.debug(t.getMessage());
			}
		}

		item.setName(name);
		item.setType(type);
		item.setDictType(dictType);
//		item.setTargetName(targetName);
		item.setLength(StringUtils.parseInt(length));
		item.setRequred("true".equalsIgnoreCase(required));
		item.setDesc(desc);
		item.setPlugin(plugin);
		item.setXmlPath(StringUtils.isEmpty(xpath) ? name : xpath);

		item.setDefaultValue(defaultValue);
		item.setSizeField(sizeField);
		item.setComment(comment);
		item.setDateFormat(dateFormat);
//		item.setValType(valType);
		item.setDolt(dolt);

		// 如果有子节点，有子节点继续处理
		parseListChildItem(item, e);
		return true;
	}

	/**
	 * 是否为列表结构或实体
	 * 
	 * @param elem
	 * @return 1列表、2对象
	 */
	private int isListItem(Element elem) {
		String type = elem.attributeValue(NetConst.AT_TYPE);
		if(NetConst.FILED_TYPE_E.equals(type))
			return 1;
		if(NetConst.FILED_TYPE_OE.equals(type))
			return 2;

		String eName = elem.getName();
		if(eName.equals(NetConst.XT_LIST))
			return 1;
		return 0;
	}

	/**
	 * 递归取子结构
	 * 
	 * @param item
	 * @param elem
	 */
	private void parseListChildItem(MBTransItem item, Element elem) {
		if (isListItem(elem) > 0) {
			// 如果类型是list 则进行 子节点解析
			List<Element> mapchild = elem.elements();
			List<MBTransItem> subList = new ArrayList<MBTransItem>();
			for (Element mapel : mapchild) {
				MBTransItem subItem = new MBTransItem();
				parseCommonItem(mapel, subItem);
//				parseListChildItem(subItem, mapel);
				subList.add(subItem);
			}
			item.setChildren(subList);
		}
	}
}