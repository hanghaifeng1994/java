package cn.com.weye.modules.cfg.dao;

import cn.com.weye.core.persistence.mybatis.DBQuery;
import cn.com.weye.core.persistence.mybatis.MybatisBaseDao;
import cn.com.weye.modules.cfg.entity.CfgApplet;

import cn.com.weye.core.persistence.annotation.MyBatisDao;
import cn.com.weye.modules.cfg.vo.CfgAppletVo;

import java.util.List;

/**
 * @Description: 小程序
 * @author zpzxskxsk@126.com
 */
@MyBatisDao
public interface CfgAppletDao extends MybatisBaseDao<CfgApplet> {
    /**
     * 查询方案上程序，包括方案版本名称
     * @param query
     * @return
     */
    List<CfgAppletVo> queryByCriteriaExt(DBQuery query);
    /**
     * 查询版本选择的小程序列表
     * @param schmEdtId
     * @return
     */
    List<CfgApplet> queryListBySchmEdtId(String schmEdtId);
}
