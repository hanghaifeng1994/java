package com.learnyeai.interact.web;

import com.github.pagehelper.PageHelper;
import com.learnyeai.base.api.bean.BaseInfoDao;
import com.learnyeai.base.api.vo.CustInfoVo;
import com.learnyeai.common.support.BaseUserDao;
import com.learnyeai.core.cache.RedisUtil;
import com.learnyeai.core.cache.RedisUtilFactory;
import com.learnyeai.interact.model.ItaInteractionTimes;
import com.learnyeai.interact.service.ItaInteractionTimesWyService;
import com.learnyeai.learnai.context.CtxHeadUtil;
import com.learnyeai.learnai.support.BaseController;
import com.learnyeai.common.support.WeyeBaseService;

import com.learnyeai.interact.model.ItaComment;
import com.learnyeai.interact.service.ItaCommentWyService;
import com.learnyeai.learnai.support.IBusinessContext;
import com.learnyeai.learnai.support.MyPage;
import com.learnyeai.learnai.support.iml.CurrentUserInfoIml;
import com.learnyeai.tools.common.JsonMapper;
import com.learnyeai.tools.common.MapUtil;
import com.learnyeai.tools.common.StringUtils;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;

/**
 *
 * @author yl
 */
@Component
public class ItaCommentController extends BaseController<ItaComment> {
    public static final String BASE_URL = "/ItaComment/";
    protected org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private ItaCommentWyService itaCommentWyService;
    @Autowired
    CurrentUserInfoIml currentUserInfoIml;
    @Autowired
    BaseInfoDao baseInfoDao;
    @Autowired
    ItaInteractionTimesWyService itaInteractionTimesWyService;
    @Autowired
    @Qualifier(value = "redisTemplateMq")
    private RedisTemplate<String, Object> redisTemplate;
    @Override
    protected WeyeBaseService<ItaComment> getService() {
        return itaCommentWyService;
    }
    @Override
    public Object execute(IBusinessContext ctx){
        String method = CtxHeadUtil.getControllerMethod();
        ItaComment itaComment= itaCommentWyService.convert2Bean(ctx.getParamMap());
        if("insert".equals(method)){
            itaComment.setCmtDate(new Date());
            itaComment.setCmtUserName(currentUserInfoIml.getLoginName());
          return   itaCommentWyService.saveData(itaComment);
        }
        if("queryPage".equals(method)){
            MyPage<ItaComment> page= itaCommentWyService.queryPage(itaComment,new HashMap());
            List<ItaComment>  list=page.getList();
            for (ItaComment ita :list){
                String userId=ita.getCreateBy();
                CustInfoVo vo= baseInfoDao.queryCustInfo(userId);
                String photo=vo.getPhoto();
                ita.setPhoto(photo);
            }
            page.setList(list);
            return  super.rtnPageList4Report(page);
        }
        if("myQueryPage".equals(method)){
            itaComment.setCreateBy(currentUserInfoIml.getId());
            if (itaComment != null) {
                itaComment.initPage();
                PageHelper.startPage(itaComment.getPage(), itaComment.getRows());
            }
            MyPage<ItaComment> page= itaCommentWyService.queryPage(itaComment,new HashMap());
            List<ItaComment>  list=page.getList();
            for (ItaComment ita :list){
                String userId=ita.getCreateBy();
                CustInfoVo vo= baseInfoDao.queryCustInfo(userId);
                String photo=vo.getPhoto();
                ita.setPhoto(photo);
            }
            page.setList(list);
            return  super.rtnPageList4Report(page);
        }
        if("delete".equals(method)){
             int total= itaCommentWyService.deleteData(itaComment);
            return  MapUtil.newMap("num",total);
        }
        return  super.execute(ctx);
    }
}
