package com.learnyeai.base.web.user;

import com.learnyeai.base.api.util.BaseCons;
import com.learnyeai.base.model.CustInfo;
import com.learnyeai.base.service.CustInfoWyService;
import com.learnyeai.base.utils.DtHelps;
import com.learnyeai.base.vo.CustInfoXlsCommon;
import com.learnyeai.file.fastdfs.FastDFSUtil;
import com.learnyeai.learnai.context.CtxHeadUtil;
import com.learnyeai.learnai.error.AresRuntimeException;
import com.learnyeai.learnai.support.IBusinessContext;
import com.learnyeai.learnai.support.IController;
import com.learnyeai.tools.common.BeanMapUtils;
import com.learnyeai.tools.excel.ImportExcel;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * excel导入用户
 * Created by zpz on 2018/9/28.
 */
@Component
public class ImportUserController implements IController {

    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private CustInfoWyService custInfoWyService;
    @Override
    public Object execute(IBusinessContext ctx) {
        String fileId = ctx.getParam("fileId");

        // 下载文件到临时目录
        String temFilePath = null;
        try {
            temFilePath = FastDFSUtil.download2Dir(fileId, FastDFSUtil.getFileTemDir());
        }catch (Exception e){
            // 异常怎么处理
            AresRuntimeException e1 = new AresRuntimeException("importUser.down_fail", e);
            e1.iniMessage("导入用户失败");
            throw e1;
        }finally { // 不管成功失败，都删除服务器上的文件
            try {
                FastDFSUtil.delete(fileId);
            } catch (IOException e) {
                logger.warn("删除文件失败", e);
            }
        }

        // 读取excel文件，导入用户

        // 简单导入用户，只导入到用户表

        String method = CtxHeadUtil.getControllerMethod();
        Object rst = null;
        if(method.equals("simpleImp"))
            rst = simpleImp(temFilePath);

        return rst;
    }

    /**
     * 简单导入用户，不作其它处理
     * 姓名、身份证号码、手机号、邮箱、性别、用户生日、所属单位
     * @param filePath
     * @return
     *  新增用户数量
     *  无效用户列表
     *  用户列表
     */
    public Object simpleImp(String filePath){
        // 下载文件成功，解析文件
        File file = new File(filePath);
        List<CustInfoXlsCommon> dataList = null;
        try {
            ImportExcel imp = new ImportExcel(file, 1);
            dataList = imp.getDataList(CustInfoXlsCommon.class, 1);
        } catch (Exception e) {
            AresRuntimeException e1 = new AresRuntimeException("importUser.parse_fail", e);
            e1.iniMessage("解析文件失败");
            throw e1;
        }finally {
            if(file.exists()){
                file.delete();
            }
        }

        // 无效用户
        List<CustInfoXlsCommon> invalidList = new ArrayList<>();
        List<CustInfoXlsCommon> userList = new ArrayList<>();


        // 姓名、身份证号码、手机号、邮箱、性别、用户生日、所属单位
        for(CustInfoXlsCommon user : dataList){

            String idcar = user.getIdcarNo();
            String custName = user.getCustName();
            // 用户名称为空
            if(StringUtils.isBlank(custName))
                continue;

            // 如果身份证号码为空或小6位
            if(StringUtils.isBlank(idcar) || idcar.length() < 6){
                invalidList.add(user);
                continue;
            }

            user.setShortName(custName);
            user.setLoginName(idcar);

            // 性别 1男、2女
            user.setSex(user.getSex() == null || !user.getSex().equals("女")? "1" : "2");
            user.setUserStatus(BaseCons.CUST_INFO_STATUS.N.getVal());
            user.setCustType(BaseCons.CUST_INFO_TYPE.KH.getVal());
            user.setCustIsAdmin("0");
            String pass = DtHelps.entryptPassword(idcar.substring(idcar.length()-6));
            user.setPassword(pass);
            userList.add(user);
        }

        List<CustInfo> custInfoList = new ArrayList<>();
        custInfoList.addAll(userList);
        // 调用service添加用户，存在不用添加了，id回填
        int addUserNum = custInfoWyService.batchaddUser_idCar(custInfoList);

        Map rst = new HashMap<>();
        try {
            rst.put("addUserNum", addUserNum);
            rst.put("invalidUserList", BeanMapUtils.convert2ListMap(invalidList));
            rst.put("userList", BeanMapUtils.convert2ListMap(custInfoList));
        }catch (Exception e){
            logger.error(e.getMessage(),e);
        }

        return rst;
    }

}
