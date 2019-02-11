package com.learnyeai.core.flow.define;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.learnyeai.core.utils.SpringContextUtils;
import org.dom4j.Document;
import org.dom4j.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.learnyeai.core.flow.AresServiceStep;
import com.learnyeai.core.flow.IAresFlowDefine;
import com.learnyeai.core.flow.IAresFlowDispatch;
import com.learnyeai.core.flow.IAresSerivce;
import com.learnyeai.tools.common.StringUtils;
import com.learnyeai.tools.common.XmlUtil;

@Component
public class AresFlowDefineByXml implements IAresFlowDefine {

	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private SpringContextUtils springContextUtils;

	/*
	 * json方式定义加载服务编排
	 * 
	 * @see
	 * cn.com.zhisou.ares.flow.IAresFlowDefine#parserDefine(java.lang.String,
	 * cn.com.zhisou.ares.flow.AresServiceDispatch)
	 */
	public boolean parserDefine(String define, IAresFlowDispatch flow) {
		logger.debug("flow loading:{}", define);
		/*String content = null;
		Resource res = springContextUtils.getApplicationContext().getResource(define);
		InputStream ioStream = null;
		try {
			ioStream = res.getInputStream();
			String temp = FileUtil.readFileAsString(ioStream);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			IOUtils.closeQuietly(ioStream);
		}*/

		String content = SpringContextUtils.loadUtf8Resouce(define);
		Document doc = null;
		try {
			doc = XmlUtil.readText(content);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		// logger.debug("config:\n{}", doc.asXML());

		// 初始化JsonMap定义
		Map map = new HashMap();
		Element root = doc.getRootElement();
		// 解析成节点定义
		String name = root.attributeValue("title");
		logger.info("config name {}", name);
		List<Element> actionNodes = root.element("actions").elements("action");

		logger.info("flow loading define ,step number:{}", actionNodes.size());

		List<AresServiceStep> steps = new ArrayList();
		Map EMPTY_MAP = new HashMap();
		for (int i = 0; i < actionNodes.size(); i++) {
			Element item = (Element) actionNodes.get(i);
			String index = item.attributeValue("index");
			if (StringUtils.isEmpty(index)) {
				index = "" + (i + 1);
			}
			String defAct = item.attributeValue("ref");// ref bean
			IAresSerivce service = SpringContextUtils.getBean(defAct);
			// 设置节点参数
			AresServiceStep step = new AresServiceStep();
			step.setIndex(StringUtils.parseInt(index));
			step.setAresService(service);
			steps.add(step);
			// 设置预置代码
			Element datasElem = item.element("datas");
			if (datasElem != null) {
				List dataNodes = datasElem.elements("data");
				if (dataNodes != null) {
					Map defData = new HashMap();
					for (Object dataNode : dataNodes) {
						Element dataElem = (Element) dataNode;
						defData.put(dataElem.attributeValue("key"),
								dataElem.getText());
					}
					step.setDatas(defData);
				}
			}
			// 设置分支映射的流程节点
			Element mapingElem = item.element("mapping");
			if (null != mapingElem) {
				List fwdNodes = mapingElem.elements("forward");
				if (fwdNodes != null) {
					Map<Integer, Integer> trueMapping = new HashMap();
					for (Object fwdNode : fwdNodes) {
						Element fwdElem = (Element) fwdNode;
						String fwdKey = fwdElem.attributeValue("key");
						if (StringUtils.isNotEmpty(fwdKey)) {
							fwdKey = fwdKey.replaceAll("next", "");
						}
						if (!StringUtils.isNumber(fwdKey)) {
							continue;
						}
						trueMapping.put(StringUtils.parseInt(fwdKey),
								StringUtils.parseInt(fwdElem.getText()));
					}
					if (!trueMapping.isEmpty()) {
						step.setMapping(trueMapping);
					}
				}
			}

		}
		flow.setSteps(steps);
		// 设置预置代码
		Map defData = (Map) map.get("datas");
		flow.setDatas(defData);

		return true;
	}
}
