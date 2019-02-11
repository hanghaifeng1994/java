package com.learnyeai.base.service;

import com.learnyeai.base.api.vo.UrDeviceVo;
import com.learnyeai.base.model.UrDevice;
import com.learnyeai.base.mapper.UrDeviceMapper;
import com.learnyeai.common.support.WeyeBaseService;
import com.learnyeai.core.IBusinessContext;
import com.learnyeai.core.exception.BusinessException;
import com.learnyeai.learnai.consts.ReportErrorKey;
import com.learnyeai.learnai.mybatis.impl.Criteria;
import com.learnyeai.learnai.mybatis.impl.CriteriaQuery;
import com.learnyeai.learnai.support.BaseMapper;
import com.learnyeai.tools.common.MapUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.weekend.Weekend;
import tk.mybatis.mapper.weekend.WeekendCriteria;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author zhangpz
 */
@Service
public class UrDeviceWyService extends WeyeBaseService<UrDevice> {

    @Resource
    private UrDeviceMapper urDeviceMapper;

    @Override
    public BaseMapper<UrDevice> getMapper() {
        return urDeviceMapper;
    }
    @Override
    protected boolean isLogicDelete(){
        return true;
    }

    @Override
    protected Weekend genSqlExample(UrDevice urDevice) {
        Weekend<UrDevice> weekend = super.genSqlExample(urDevice);
        WeekendCriteria<UrDevice, Object> c = weekend.createCriteriaAddOn();
        if(StringUtils.isNotBlank(urDevice.getUuid())){
            c.andEqualTo(UrDevice::getUuid, urDevice.getUuid());
        }
        weekend.and(c);
        return weekend;
    }

    @Transactional
    public void loginInit(String custId, String uuid, String clientOs, IBusinessContext ctx){
        //修改用户设备所有登录信息状态为3（在其他设备上登录）
        Map params = new HashMap();
        params.put(UrDeviceVo.CF.devStatus,"3");
        params.put(UrDeviceVo.CF.custId,custId);
        urDeviceMapper.updateDeviceStatusByCustId(params);

        // 修改此设备上所有用户为未登录，同一个app在同一个手机上必须退出才能登录
        params.put(UrDeviceVo.CF.devStatus,"2");
        params.put(UrDeviceVo.CF.uuid,uuid);
        urDeviceMapper.updateDeviceStatusByUUID(params);

        // 查询用户在此设备上登录信息;
        UrDevice deviceMap = null;
        CriteriaQuery criteriaQuery = new CriteriaQuery();
        Criteria criteria = criteriaQuery.createAndCriteria();
        criteria.equalTo("UUID", uuid);
        criteria.equalTo("CUST_ID",custId);
        List<UrDevice> deviceList = urDeviceMapper.queryByCriteria(criteriaQuery);

        if (deviceList!=null&&deviceList.size()>0){
            deviceMap = deviceList.get(0);
        }else {
            deviceMap = new UrDevice();
        }
        deviceMap.setUuid(uuid);
        deviceMap.setClientOs(clientOs);
        deviceMap.setCustId(custId);
        deviceMap.setDevStatus("1");
        // 保存新设备信息到库中
        deviceMap.setClientType(ctx.getParam(UrDeviceVo.CF.clientType));
        deviceMap.setClientInfo(ctx.getParam(UrDeviceVo.CF.clientInfo));
        if(null==deviceMap.getBindDate()){
            deviceMap.setBindDate(new Date());
        }

        save(deviceMap);
    }

    public int updateDeviceStatus(String custId, String uuid, String status){
        Map pp = MapUtil.newMap(UrDeviceVo.CF.custId, custId,
                UrDeviceVo.CF.uuid, uuid,
                UrDeviceVo.CF.devStatus, status);
        return urDeviceMapper.updateDeviceStatus(pp);
    }
    // 根据uuid查询当前登录用户
    public UrDevice queryCurByUuid(String uuid){
        if(uuid == null || uuid.length() == 0){
            throw new BusinessException(ReportErrorKey.common_parameter_empty, "uuid为空");
        }
        UrDevice pp = new UrDevice();
        pp.setUuid(uuid);
        List<UrDevice> deviceList = queryByExample(pp, null);

        if(deviceList.size()<=0){ // 新设备上登录
            return null;
        }

        UrDevice urDevice = null;
        for(UrDevice it:deviceList){
            String deviceStatus =  it.getDevStatus();
            if("1".equals(deviceStatus)){
                if(urDevice == null)
                    urDevice = it;
                else {
                    logger.error(uuid + "设备上登录多个用户{}", it.getCustId());
                }
                break;
            }
        }
        if(null == urDevice){
            urDevice = deviceList.get(0);
        }


        // 1登录、2未登录、3在其它设备登录 4新设备上登录
        /*if(deviceMap==null){
            return deviceStatus;
        }*/
        return urDevice;
    }

}
