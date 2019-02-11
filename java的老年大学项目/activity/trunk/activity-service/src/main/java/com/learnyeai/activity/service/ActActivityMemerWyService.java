package com.learnyeai.activity.service;

import com.learnyeai.activity.model.ActActivity;
import com.learnyeai.activity.model.ActActivityMemer;
import com.learnyeai.activity.mapper.ActActivityMemerMapper;
import com.learnyeai.activity.model.IsSignUpVo;
import com.learnyeai.base.api.bean.BaseInfoDao;
import com.learnyeai.base.api.vo.CustInfoVo;
import com.learnyeai.common.support.WeyeBaseService;
import com.learnyeai.core.support.ThreadContext;
import com.learnyeai.learnai.context.CtxReportUtil;
import com.learnyeai.learnai.support.BaseMapper;
import com.learnyeai.learnai.support.BaseService;
import com.learnyeai.learnai.support.MyPage;
import com.learnyeai.learnai.support.iml.CurrentUserInfoIml;
import com.learnyeai.tools.common.MapUtil;
import com.learnyeai.tools.common.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.weekend.Weekend;
import tk.mybatis.mapper.weekend.WeekendCriteria;

import javax.annotation.Resource;
import java.util.*;

/**
 *
 * @author yl
 */
@Service
public class ActActivityMemerWyService extends WeyeBaseService<ActActivityMemer> {

    @Resource
    private ActActivityMemerMapper actActivityMemerMapper;
    @Resource
    private CurrentUserInfoIml currentUserInfoIml;
    @Resource
    private ActActivityWyService actActivityWyService;
    @Resource
    private BaseInfoDao baseInfoDao;
    @Override
    public BaseMapper<ActActivityMemer> getMapper() {
        return actActivityMemerMapper;
    }
    @Override
    protected boolean isLogicDelete(){
        return false;
    }
    @Override
    protected Weekend genSqlExample(ActActivityMemer t, Map params) {
        Weekend<ActActivityMemer> w = super.genSqlExample(t,params);
        WeekendCriteria<ActActivityMemer,Object> c=w.weekendCriteria();
        if(StringUtils.isNotBlank(t.getActId())){
            c.andEqualTo(ActActivityMemer::getActId,t.getActId());
        }
        if(StringUtils.isNotBlank(t.getJoinupUserId())){
            c.andEqualTo(ActActivityMemer::getJoinupUserId,t.getJoinupUserId());
        }
        w.and(c);
        return  w;

    }
    @Transactional
    public Map<String,Object> saveData(ActActivityMemer am){
        String userId =currentUserInfoIml.getId();
       List<ActActivityMemer> list =super.queryList(am,new HashMap());
       if(list.size()>0){
           return MapUtil.newMap("status",1);
       }
        am.setJoinupUserId(userId);
        am.setJoinupDate(new Date());
       int i=  actActivityMemerMapper.insertSelective(am);
      //通过活动id 查询出活动表中人数
        ActActivity aa= actActivityWyService.queryById(am.getActId());
       Integer num=aa.getActSignupNum();
        if(num==null){
            num=0;
        }
        aa.setActSignupNum(i+num);
        actActivityWyService.save(aa);
        return MapUtil.newMap("status",0);
    }

    public  Map<String,Object> personPage(ActActivityMemer am){
        MyPage page= super.queryPage(am,new HashMap());
        Map<String,Object> map=new HashMap<>();
        List<ActActivityMemer> list=page.getList();
        String userId="";
        if(list!=null && list.size()>0){
            for (ActActivityMemer aam :list)
                userId+=aam.getJoinupUserId()+",";
        }
       long total= page.getTotal();
        map.put("total",total);
        map.put("userId",userId);
        return map;
    }

    /**
     * 是否报名
     * @param actActivityMemer
     * @return
     */
    public List<IsSignUpVo> isSignUp(ActActivityMemer actActivityMemer){
        List<IsSignUpVo> list= actActivityMemer.getList();
        ActActivityMemer memer=new ActActivityMemer();
        for (IsSignUpVo vo:list){
            String actId=  vo.getActId();
            String custId=  vo.getCustId();
            memer.setActId(actId);
            memer.setJoinupUserId(custId);
            List<ActActivityMemer> members=  super.queryList(memer,new HashMap());
            if(members.size()>0){
                //有数据
                vo.setStatus("1");
            }else{
                vo.setStatus("0");
            }
        }
        return list;
    }

    public static List rtnPageList4Report(MyPage page) {
        if (page.getTotal() > -1L) {
            Map extData = CtxReportUtil.getListExtResultMap();
            extData.put("totalCount", page.getTotal());
            extData.put("pageNo", page.getPageNo());
            extData.put("pageSize", page.getPageSize());
        }

        return page.getList();
    }
}
