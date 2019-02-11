package com.learnyeai.album.service;

import com.learnyeai.album.mapper.AbmSitePhotoRelMapper;
import com.learnyeai.album.model.AbmPhoto;
import com.learnyeai.album.mapper.AbmPhotoMapper;
import com.learnyeai.album.model.AbmSitePhotoRel;
import com.learnyeai.album.util.AlbumUtil;
import com.learnyeai.learnai.support.BaseMapper;
import com.learnyeai.learnai.support.BaseService;
import com.learnyeai.learnai.support.IBusinessContext;
import com.learnyeai.learnai.support.iml.CurrentUserInfoIml;
import com.learnyeai.mq.AuditlogMq;
import com.learnyeai.rabbitmq.bean.RabbitMetaMessage;
import com.learnyeai.rabbitmq.sender.RabbitSender;
import com.learnyeai.rabbitmq.util.WeyeRabbitException;
import com.learnyeai.tools.common.JsonUtils;
import com.learnyeai.tools.common.MapUtil;
import com.learnyeai.tools.common.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
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
 * @author yl
 */
@Service
public class AbmPhotoWyService extends BaseService<AbmPhoto> {

    @Resource
    private AbmPhotoMapper abmPhotoMapper;
    @Autowired
    private RabbitSender rabbitSender;
    @Resource
    private CurrentUserInfoIml currentUserInfoIml;
    @Resource
    private AbmSitePhotoRelWyService abmSitePhotoRelWyService;
    @Resource
    private AbmSitePhotoRelMapper abmSitePhotoRelMapper;

    @Override
    public BaseMapper<AbmPhoto> getMapper() {
        return abmPhotoMapper;
    }
    @Override
    protected boolean isLogicDelete(){
        return true;
    }
    @Override
    protected Weekend genSqlExample(AbmPhoto t, Map params) {
        Weekend w=super.genSqlExample(t,params);
        WeekendCriteria<AbmPhoto,Object> c=w.weekendCriteria();
        if(StringUtils.isNotBlank(t.getCreateBy())){
            c.andEqualTo(AbmPhoto::getCreateBy,t.getCreateBy());
        }
        if(StringUtils.isNotBlank(t.getSiteId())){
            c.andEqualTo(AbmPhoto::getSiteId,t.getSiteId());
        }
        if(StringUtils.isNotBlank(t.getPhStatus())){
            c.andEqualTo(AbmPhoto::getPhStatus,t.getPhStatus());
        }
        w.setOrderByClause("CREATE_DATE desc");
        w.and(c);
       return w;
    }

    @Transactional
    public int deleteall(AbmPhoto ap){
        String[] phIds=(ap.getPhId()).split(",");
        ap.setPhImgNames(currentUserInfoIml.getLoginName());

        int num=0;
        for (String id:phIds){
          num +=  super.deleteById(id);
        }
        logger.info("批量删除了"+num+"条数据");
        return num;
    }
<<<<<<< .mine


||||||| .r167
=======

    /**
     * 新增或保存
     * 返回status=0操作成功 1已提交审核不能更新
     * @param ap
     * @return
     */
    public Map<String,Object> saveData(AbmPhoto ap){
        Map<String,Object> map=new HashMap<>();
        if(StringUtils.isNotBlank(ap.getPhId())){
            AbmPhoto photo=super.queryById(ap.getPhId());
            String phId=photo.getPhStatus();
            //审核中或者审核成功不能修改
            if("1".equals(phId)||"2".equals(phId)){
                map.put("status",1);
                return map;
            }
        }else{
            //新增将审核状态设置为0
            ap.setPhStatus("0");
        }
        super.save(ap);
        map.put("status",0);
        return  map;
    }
    @Transactional
    public Map<String,Object> abmPhotoWyService(AbmPhoto ap){
        String[] arr=(ap.getPhId()).split(",");
        AbmPhoto abmPhoto=new AbmPhoto();
        abmPhoto.setPhStatus(ap.getPhStatus());
        int  i=0;
        for (String apId:arr){
            abmPhoto.setPhId(apId);
          i+=  super.save(abmPhoto);
        }
        logger.info("批量操作了"+i+"条数据");
        return MapUtil.newMap("num",i);
    }
    @Transactional
    public Map<String,Object> auditBatch(IBusinessContext ctx) throws WeyeRabbitException {
        String jstr=  JsonUtils.objectToJson(ctx.getParamMap());
        AuditlogMq albumMq=JsonUtils.jsonToObject(jstr,AuditlogMq.class);
        String status= albumMq.getStatus();
        AbmPhoto abmPhoto=new AbmPhoto();
        abmPhoto.setPhStatus(status);
        String[] objIds=(albumMq.getObjId()).split(",");
        albumMq.setAdTime(new Date());
        albumMq.setAdUserId(currentUserInfoIml.getId());
        albumMq.setAdUserName(currentUserInfoIml.getLoginName());
        int count=0;
        for (String objId:objIds){
            abmPhoto.setPhId(objId);
            albumMq.setObjId(objId);
            //先修改数据库状态
            count+= super.save(abmPhoto);
//            发送消息
            RabbitMetaMessage msg= AlbumUtil.toParseRabbitMetaMessage(albumMq);
            AbmPhoto aspr=super.queryById(objId);
            //向站点图片关联表插入记录
            logger.info("发送的消息记录为，{}"+msg);
            //组装关联表实体类
            AbmSitePhotoRel rel=new AbmSitePhotoRel();
            rel.setPhPubStatus(status);
            rel.setSiteId(aspr.getSiteId());
            rel.setPhManageStatus("1");
            rel.setPhCrtSiteId(aspr.getSiteId());
            rel.setPhId(aspr.getPhId());
            rel.setMchtId(aspr.getMchtId());
            rel.setMchtSchmId(aspr.getMchtSchmId());
            //状态为审核通过在站点图片关联表中新建记录
            if("2".equals(status)){
                List<AbmSitePhotoRel> abmrel=abmSitePhotoRelWyService.queryList(rel,new HashMap());
                //关联表中有数据修改，没有则新增
                if(abmrel.size()==0){
                    abmSitePhotoRelMapper.insertSelective(rel);
                }else{
                    abmSitePhotoRelWyService.updateByPrimaryKeySelectiveExt(rel);
                }
            }
            rabbitSender.send(msg);
        }
        return MapUtil.newMap("num",count);
    }
>>>>>>> .r192
}
