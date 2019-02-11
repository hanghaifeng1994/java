package com.learnyeai.resource.util;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.learnyeai.base.api.bean.BaseInfoDao;
import com.learnyeai.base.api.vo.PtsetSiteVo;
import com.learnyeai.core.utils.SpringContextUtils;
import com.learnyeai.mq.ResourceConstans;
import com.learnyeai.mq.ResourceMq;
import com.learnyeai.rabbitmq.bean.MqVo;
import com.learnyeai.rabbitmq.bean.RabbitMetaMessage;

public class ResourceUtil {

	private static BaseInfoDao baseInfoDao;

	private static BaseInfoDao getBaseInfoDao() {
		if (null == baseInfoDao) {
			baseInfoDao = SpringContextUtils.getBean(BaseInfoDao.class);
		}
		return baseInfoDao;
	}

	// 站点
	public static PtsetSiteVo getSite(String id) {
		return getBaseInfoDao().querySite(id.toString());
	}

	public static List<PtsetSiteVo> getChildsSite(String id) {
		PtsetSiteVo site = getSite(id);
		if ("1".equals(site.getSiteType())) {
			return getBaseInfoDao().querySitesByPt(id);
		}
		return new ArrayList<PtsetSiteVo>();
	}

	public static RabbitMetaMessage toParseRabbitMetaMessage(ResourceMq mq) {
		/** 生成一个发送对象 */
		RabbitMetaMessage rabbitMetaMessage = new RabbitMetaMessage();
		/** 设置交换机 */
		rabbitMetaMessage.setExchange(ResourceConstans.RESOURCE_EXCHANGE);
		/** 指定routing key */
		rabbitMetaMessage.setRoutingKey(ResourceConstans.RESOURCE_KEY);
		/** 设置需要传递的消息体,可以是任意对象 */
		MqVo vo = mq;
		rabbitMetaMessage.setPayload(vo);
		return rabbitMetaMessage;
	}

	public static List<String> convertSiteIds(String ids) {
		List<String> siteIds = new ArrayList<String>();
		if (StringUtils.isNotBlank(ids)) {
			for (String siteId : ids.split(",")) {
				siteIds.add(siteId);
			}
		} else {
			return null;
		}
		return siteIds;
	}
}
