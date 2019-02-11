package cn.com.weyeyun.commoncert.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springside.modules.utils.reflection.ReflectionUtils;

import cn.common.lib.springside.service.EntityManager;

/**
 * 缓存业务基类
 * 
 * @author houbing.qian
 * 
 * @param <T>
 * @param <PK>
 */
@Component
public abstract class CacheEntityService<T, PK extends Serializable> extends EntityManager<T, PK> {

	/**
	 * 从对象列表中取得id列表
	 * 
	 * @param dataList
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<PK> getIDs(List<T> dataList) {
		List<PK> idList = new ArrayList<PK>();
		for (T t : dataList) {
			idList.add((PK) ReflectionUtils.invokeGetterMethod(t, "id"));
		}
		return idList;
	}

	/**
	 * 将id列表转化成对象列�?
	 * 
	 * @param idList
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<T> getObjectsbyIds(List<PK> idList) {
		List<T> dataList = new ArrayList<T>();
		for (PK pk : idList) {
			try {
				Object object2 = super.get(pk);

				if (object2 != null) {
					T t = (T) object2;
					dataList.add(t);
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return dataList;
	}

}
