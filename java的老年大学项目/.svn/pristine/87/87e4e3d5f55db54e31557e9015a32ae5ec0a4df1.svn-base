package com.learnyeai.base.action.common;

/**
 * 头像上传业务处理
 * Created by hejie on 15.8.24.
 */
/*
@Component
public class HeadPortraitOP implements IAresSerivce {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Value("${RES_BASEPATH}")
    private String resPath;

    @Value("${RES_PHOTO_PATH}")
    private String res_photo_path;

    @Autowired
    private ICustChanImg custChanImg;

    public int execute(IBaseBusinessContext context) {
        IBusinessContext ctx = (IBusinessContext) context;
        //获取Request
        HttpServletRequest request = ctx.getRequest();

        String fileName= request.getParameter("fileName");
        String[] nameAll = fileName.split("\\.");
        String fileType = nameAll[nameAll.length-1];
        logger.debug("fileName= {}", fileName);
        logger.debug("fileType= {}", fileType);
        ValidUtils.validEmpty("文件名", fileName);
        ValidUtils.validEmpty("文件类型", fileType);

        //文件目录
        File file = new File(resPath+res_photo_path);
        //判断上传文件的保存目录是否存在
        if (!file.exists() || !file.isDirectory()) {
            logger.info("----------目录不存在，创建----------");
            //创建目录
            file.mkdirs();
        }
        //客户号
        String custNO = ctx.getSessionObject(SessR.CUST_NO);
        ValidUtils.validEmpty("客户号", custNO);
        //生成文件名
        fileName = custNO+"_"+System.currentTimeMillis()+"."+fileType;
        //存放资源全路径
        String path = resPath+res_photo_path+fileName;//资源根目录 + 图片目录 + 文件名

        try {
            InputStream is = request.getInputStream();
            FileOutputStream fos = new FileOutputStream(path);
            logger.debug("fileUpload  ------------path=" + path);

            byte[] buffer = new byte[1024];
            int len = 0;
            while((len = is.read(buffer)) > 0){
                fos.write(buffer, 0 ,len);
            }
            logger.debug(path + "文件已上传");

            fos.close();
            //保存客户头像到数据库，参数
            Map paramMap = new HashMap();
            //客户号
            paramMap.put("CUST_NO", custNO);
            //头像路径
            paramMap.put("UP_URL_NAME",res_photo_path+fileName);

            Date now = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
            String nowStr = sdf.format(now);
            String[] str = nowStr.split(" ");
            //更新日期
            paramMap.put("UP_DATE",str[0]);
            //更新时间
            paramMap.put("UP_TIME", str[1]);

            //查询客户是否已经上传头像
            Map custImg = custChanImg.queryCustImg(paramMap);
            if(custImg==null||custImg.get("UP_URL_NAME")==null){
                custChanImg.saveHeadPortrait(paramMap);//
            }else {
                custChanImg.updateHeadPortrait(paramMap);
            }
        } catch (FileNotFoundException e) {
            logger.error("HeadPortraitOP:文件未找到");
            throw new AresRuntimeException("HeadPortraitOP:文件未找到");
        } catch (IOException e) {
            throw new AresRuntimeException("HeadPortraitOP:{}",e);
        }
        return NEXT;
    }
}
*/
