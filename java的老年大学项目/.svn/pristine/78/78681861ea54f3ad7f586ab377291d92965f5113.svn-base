package cn.com.weye.modules.sh.service;

import cn.com.weye.core.persistence.Page;
import cn.com.weye.core.persistence.mybatis.DBQuery;
import cn.com.weye.core.persistence.mybatis.MybatisBaseDao;
import cn.com.weye.core.persistence.mybatis.impl.Criteria;
import cn.com.weye.core.persistence.mybatis.impl.CriteriaQuery;
import cn.com.weye.core.service.mybatis.MybatisBaseService;
import cn.com.weye.core.utils.ConfigUtils;
import cn.com.weye.modules.cfg.entity.CfgApplet;
import cn.com.weye.modules.cfg.service.*;
import cn.com.weye.modules.sh.dao.ShMerchantSchemeDao;
import cn.com.weye.modules.sh.entity.*;
import cn.com.weye.tools.common.MapUtil;
import cn.com.weye.tools.common.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author yl
 */
@Service
public class ShMerchantSchemeService extends MybatisBaseService<ShMerchantScheme> {

    @Resource
    private ShMerchantSchemeDao shMerchantSchemeDao;
    @Autowired
    private ShMerchantService shMerchantService;
    @Autowired
    private CfgSchmEdtPackageService cfgSchmEdtPackageService;
    @Autowired
    private CfgAddedServiceService cfgAddedServiceService;
    @Autowired
    private CfgSchemeEditionPriceService cfgSchemeEditionPriceService;
    @Autowired
    private CfgSchemeEditionHisService cfgSchemeEditionHisService;
    @Autowired
    private ShOrderService shOrderService;
    @Autowired
    private ShOrderPackageService shOrderPackageService;
    @Autowired
    private ShOrderAddserviceRelService shOrderAddserviceRelService;
    @Autowired
    private ShAppletSettingService shAppletSettingService;
    @Autowired
    private ShActivityService shActivityService;

    @Override
    public String getTableName() {
        return ConfigUtils.getValue("schema.interPlat") + ".SH_MERCHANT";
    }

    @Override
    public String getIdKey() {
        return "mchtSchmId";
    }

    @Override
    public MybatisBaseDao<ShMerchantScheme> getDao() {
        return shMerchantSchemeDao;
    }
    
    @Override
    protected boolean isLogicDelete(){
        return true;
    }


    @Override
    protected DBQuery genSqlQuery(ShMerchantScheme params, String mainTableAs) {
        String as = mainTableAs == null? "" : mainTableAs + ".";
        CriteriaQuery q = (CriteriaQuery)super.genSqlQuery(params, mainTableAs);

        if(null == params)
            return q;
        Criteria c = q.createAndCriteria();
        if(StringUtils.isNotBlank(params.getMchtName())){
            c.like("m." + "MCHT_NAME", "%"+params.getMchtName()+"%");
        }
        c.equalTo("s."+ShMerchantScheme.TF.delFlag,"0");
        return q;
    }
    public Page<Map> queryCodePage(ShMerchantScheme params, Page<Map> page){
        Map pp = MapUtil.newMap(
                "page", page
                , "mchtName",params.getMchtName()
        );
        shMerchantSchemeDao.queryCodeList(pp);
        return page;
    }

    public Page<ShMerchantSchemeExt> queryExtPage(ShMerchantScheme params, Page<ShMerchantSchemeExt> page){
        DBQuery q = genSqlQuery(params, "c");
        if(null != page)
            q.setPage(page);

        shMerchantSchemeDao.queryByCriteriaExt(q);
        return page;
    }

    public int startOrForbiddenUse(ShMerchantScheme shMerchantScheme){
        shMerchantSchemeDao.startOrForbiddenUse(shMerchantScheme);
        return 0;
    }

    /**
     * 根据方案版本id 查询出方案名称以及方案版本名称
     * @param schmEdtId
     * @return
     */
    public List<Map<String,Object>> getEditionList(String schmEdtId){

        return shMerchantSchemeDao.getEditionList(schmEdtId);
    }

    /**
     * 生成订单 及保存商户方案
     * @param entity
     * @param request
     * @param redirectAttributes
     * @return
     */
    @Transactional
    public boolean toGenerateOrder(ShMerchantSchemeExt entity, HttpServletRequest request, RedirectAttributes redirectAttributes){
        logger.info("--------生成订单开始-------");
        boolean flag=true;
        //计算该商户方案总金额
        Map<String,BigDecimal> total=getTotalMoney(entity);
        BigDecimal totalMoney=total.get("totalMoney");
        BigDecimal asPrice=total.get("asPrice");
        BigDecimal edtPrice=total.get("edtPrice");
        logger.info("商户方案总金额={}",totalMoney);
        try{

            //查询订单所需参数
            ShOrder shOrder=getOrdParams(entity,asPrice,totalMoney,edtPrice);
//            新增订单
            shOrderService.save(shOrder);
            logger.info("生成订单={}",shOrder);
            String ordId=shOrder.getOrdId();
            //更新商户订单并向商户方案中插入商户订单id
            String schmEdtHisId =shOrder.getSchmEdtHisId();
            entity.setOrdId(ordId);
            entity.setSchmEdtHisId(schmEdtHisId);
            super.save(entity);
            //向订单及功能包关联表插入数据
            shOrderPackageService.saveOrderPackage(entity,ordId);
            //向增值服务与订单关联表插入数据
            shOrderAddserviceRelService.saveOrderAdded(entity,ordId);
        }catch (Exception e){
            e.printStackTrace();
            flag=false;
            logger.error("生成订单异常！");
        }
        return flag;
    }
    /**
     * 获取订单总金额
     * @param entity
     * @return
     */
    public  Map<String, BigDecimal> getTotalMoney(ShMerchantSchemeExt entity){
        String[] pkgIds=new String[0];
        String[] asIds=new String[0];
        BigDecimal pkPrice=new BigDecimal(0);
        BigDecimal asPrice=new BigDecimal(0);
        if(entity.getPkgId()!=null){
            pkgIds=entity.getPkgId().split(",");
        }
        if(entity.getAsId()!=null){
            asIds=entity.getAsId().split(",");
        }
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("pkgIds",pkgIds);
        map.put("schmEdtPayType",entity.getSchmEdtPayType());
        map.put("asIds",asIds);
        map.put("schmEdtId",entity.getSchmEdtId());
        //查询出增值包的价格
        if(entity.getPkgId()!=null){
            pkPrice=cfgSchmEdtPackageService.getPkPrice(map);
        }
        //查询出增值服务价格
        if(entity.getAsId()!=null){
             asPrice=cfgAddedServiceService.asPrice(map);
        }
        //方案版本价格
        BigDecimal edtPrice=cfgSchemeEditionPriceService.getEdtPrice(map);
        //每一份的金额
        BigDecimal money=pkPrice.add(asPrice).add(edtPrice);
//        总金额
        BigDecimal totalMoney=money.multiply(BigDecimal.valueOf(entity.getOrdBuyNum()));
        Map<String,BigDecimal> total=
                MapUtil.newMap("totalMoney",totalMoney,
                        "asPrice",asPrice,"edtPrice",edtPrice);
        return total;
    }

    /**
     * 拼装订单所需参数
     * @param entity
     * @param totalAddMoney
     * @param totalMoney
     * @param edtPrice
     * @return
     */
    public ShOrder getOrdParams(ShMerchantSchemeExt entity,BigDecimal totalAddMoney,BigDecimal totalMoney,BigDecimal edtPrice){
        logger.info("------拼装订单所需参数------");
        ShOrder shOrder=new ShOrder();
        String actId=entity.getActId();
        BigDecimal disAmount=new BigDecimal(0);
        if( !("".equals(actId))){
            //根据活动id 查询出活动价格
            ShActivity ac=shActivityService.queryById(actId);
            disAmount.add(new BigDecimal(ac.getActDiscountAmount())).multiply(BigDecimal.valueOf(entity.getOrdBuyNum()));
            shOrder.setActId(actId);
        }
        BigDecimal realAmount=totalMoney.subtract(disAmount);
        //查询订单所需的字段
        Map<String,Object> map= cfgSchemeEditionHisService.queryByHisId(entity);
        shOrder.setSchmEdtHisId((String)map.get("schmEdtHisId"));
        shOrder.setEdtPrcId((String) map.get("edtPrcId"));
        shOrder.setSchmEdtPayType(entity.getSchmEdtPayType());
        shOrder.setSchmEdtPrice(Long.parseLong(edtPrice.toString()));
        shOrder.setSchmEdtIncreasePrice(Long.parseLong(totalAddMoney.toString()));
        shOrder.setOrdBuyNum(entity.getOrdBuyNum());
        shOrder.setOrdPayStatus(entity.getMchtSchmPayStatus());
        shOrder.setServiceStartDate(entity.getServiceStartDate());
        shOrder.setServiceEndDate(entity.getMchtSchmExpireDate());
        shOrder.setOrdTotalAmount(Long.parseLong(totalMoney.toString()));
        //根据商户id找到商户经理及id
        ShMerchant sh=shMerchantService.queryById(entity.getMchtId());
        shOrder.setClientManagerId(sh.getClientManagerId());
        shOrder.setClientManagerName(sh.getClientManagerName());
        //商户方案id
        shOrder.setMchtSchmId(entity.getMchtSchmId());
//        商户id
        shOrder.setMchtId(entity.getMchtId());
        //优惠金额
        shOrder.setOrdDiscountAmount(disAmount.longValue());
        //状态默认设为正常
        shOrder.setOrdStatus("0");
        shOrder.setOrdNum("weye"+System.currentTimeMillis());
        shOrder.setOrdRealAmount(realAmount.longValue());
        shOrder.setOrdPayType(entity.getOrdPayType());
        shOrder.setOrdPayDate(entity.getOrdPayDate());
        shOrder.setOrdPayUsername(entity.getOrdPayUsername());
        shOrder.setOrdSaleType(entity.getOrdSaleType());
        return shOrder;
    }

    /**
     * 通过方案版本id 查询出方案名称等
     * @param entity
     * @return
     */
    public ShMerchantSchemeExt  querySchemeByMchtSchmId(ShMerchantSchemeExt entity){
        CriteriaQuery q = new CriteriaQuery();
        Criteria c = q.createAndCriteria();
        if(StringUtils.isNotBlank(entity.getMchtSchmId())){
            c.equalTo("s."+ShMerchantScheme.TF.mchtSchmId,entity.getMchtSchmId());
        }
        List<ShMerchantSchemeExt> list=shMerchantSchemeDao.queryByCriteriaExt(q);
        return list.get(0);
    }

}
