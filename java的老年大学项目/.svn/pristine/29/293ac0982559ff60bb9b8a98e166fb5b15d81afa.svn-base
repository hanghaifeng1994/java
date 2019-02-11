package cn.com.weyeyun.codegen;

import cn.com.weyeyun.codegen.util.CodegenConfigUtils;
import cn.com.weyeyun.codegen.util.DbUtils;
import cn.com.weyeyun.codegen.util.FreemarkerUtils;
import cn.com.weyeyun.codegen.vo.TableEntity;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.io.*;
import java.util.Collection;
import java.util.Properties;

/**
* 代码生成主类.
*/
public class CodeGen {

    private static final Logger logger = LoggerFactory.getLogger(CodeGen.class);

    private static final String separator = File.separator;

    private static final String DB2_TYPE = "db2";

    public static void main(String[] args) throws IOException {

        // 代码模板配置
        Configuration cfg = new Configuration();
        cfg.setDirectoryForTemplateLoading(CodegenConfigUtils.getTplPath());
        cfg.setDefaultEncoding("UTF-8");

        // 定义模板变量
        Properties model = CodegenConfigUtils.getConfigs();


        // 生成 Entity
        Template entityTpl = cfg.getTemplate("Entity.ftl");
        Template voTpl = cfg.getTemplate("Vo.ftl");
        Template daoTpl = cfg.getTemplate("EntityDao.ftl");
        Template serviceTpl = cfg.getTemplate("EntityService.ftl");
        Template controllerTpl = cfg.getTemplate("EntityController.ftl");
        Template formTpl = cfg.getTemplate("viewForm.ftl");
        Template listTpl = cfg.getTemplate("viewList.ftl");
        Template sqlMapperTpl = cfg.getTemplate("SqlMapper.ftl");
        Template sqlMapperDB2Tpl = cfg.getTemplate("SqlMapperForDB2.ftl");
        Template sqlMapperExtTpl = cfg.getTemplate("SqlMapperExt.ftl");
        Template reportTpl = cfg.getTemplate("detail_report.ftl");

        Template clientTpl = cfg.getTemplate("Client.ftl");

        Collection<TableEntity> tables = DbUtils.getTables(CodegenConfigUtils.getTableSchema(),
                CodegenConfigUtils.getTablePattern());
        if (logger.isTraceEnabled()) {
            logger.trace("tables:[{}]", tables.toString());
        }

        String genFileType = model.getProperty("genFileType", null);
        if(null != genFileType) {
            genFileType = genFileType.toUpperCase();
        }
        for (TableEntity table : tables) {
            model.put("table", table);
            String filePath = null;
            String content = null;

            if(null == genFileType || genFileType.contains("M")) {
                filePath = CodegenConfigUtils.getJavaBasePath() + separator + "model"
                        + separator + table.getClassName() + ".java";
                content = FreemarkerUtils.process2String(entityTpl, model);
                writeFile(content, filePath, true);
                logger.info("Entity: {}", filePath);

                filePath = CodegenConfigUtils.getJavaBasePath() + separator + "vo"
                        + separator + table.getClassName() + "Vo.java";
                content = FreemarkerUtils.process2String(voTpl, model);
                writeFile(content, filePath, true);
                logger.info("Vo: {}", filePath);

                filePath = CodegenConfigUtils.getMapperBasePath() + separator
                        + table.getName() + ".xml";
                content = FreemarkerUtils.process2String(sqlMapperTpl, model);
                writeFile(content, filePath, true);
                logger.info("SqlMapper: {}", filePath);

                filePath = CodegenConfigUtils.getMapperBasePath() + separator
                        + table.getName() + "_ext.xml";
                content = FreemarkerUtils.process2String(sqlMapperExtTpl, model);
                writeFile(content, filePath, false);
                logger.info("SqlMapperExt: {}", filePath);

                /*filePath = CodegenConfigUtils.getMapperDB2Path() + separator
                        + table.getName() + ".xml";
                content = FreemarkerUtils.process2String(sqlMapperDB2Tpl, model);
                writeFile(content, filePath, true);
                logger.info("SqlMapperDB2: {}", filePath);

                filePath = CodegenConfigUtils.getMapperDB2Path() + separator
                        + table.getName() + "_ext.xml";
                content = FreemarkerUtils.process2String(sqlMapperExtTpl, model);
                writeFile(content, filePath, false);
                logger.info("SqlMapperDB2Ext: {}", filePath);*/
            }

            if(null == genFileType || genFileType.contains("F")) {
                filePath = CodegenConfigUtils.getJavaBasePath() + separator + "client"
                        + separator + table.getClassName() + "Client.java";
                content = FreemarkerUtils.process2String(clientTpl, model);
                writeFile(content, filePath, false);
                logger.info("Dao: {}", filePath);
            }

            if(null == genFileType || genFileType.contains("D")) {
                filePath = CodegenConfigUtils.getJavaBasePath() + separator + "mapper"
                        + separator + table.getClassName() + "Mapper.java";
                content = FreemarkerUtils.process2String(daoTpl, model);
                writeFile(content, filePath, false);
                logger.info("Dao: {}", filePath);
            }

            if(null == genFileType || genFileType.contains("S")) {
                filePath = CodegenConfigUtils.getJavaBasePath() + separator + "service"
                        + separator + table.getClassName() + "WyService.java";
                content = FreemarkerUtils.process2String(serviceTpl, model);
                writeFile(content, filePath, false);
                logger.info("Service: {}", filePath);
            }

            if(null == genFileType || genFileType.contains("C")) {
                filePath = CodegenConfigUtils.getJavaBasePath() + separator + "web"
                        + separator + table.getClassName() + "Controller.java";
                content = FreemarkerUtils.process2String(controllerTpl, model);
                writeFile(content, filePath, false);
                logger.info("Controller: {}", filePath);
            }

            if(null == genFileType || genFileType.contains("J")) {
                filePath = CodegenConfigUtils.getViewBasePath() + separator
                        + table.getClassName() + "List.jsp";
                content = FreemarkerUtils.process2String(listTpl, model);
                writeFile(content, filePath, false);
                logger.info("viewList: {}", filePath);

                filePath = CodegenConfigUtils.getViewBasePath() + separator
                        + table.getClassName() + "Form.jsp";
                content = FreemarkerUtils.process2String(formTpl, model);
                writeFile(content, filePath, false);
                logger.info("viewForm: {}", filePath);
            }

            if(null == genFileType || genFileType.contains("R")){
                filePath = CodegenConfigUtils.getReportBasePath() + separator
                        + table.getClassName() + separator + "detail.xml";
                content = FreemarkerUtils.process2String(reportTpl, model);
                writeFile(content, filePath, false);

            }
        }

        logger.info("Generate Success.");
    }

    /**
     * 将内容写入文件
     *
     * @param content  文件内容
     * @param filePath 路径
     * @param cover 是否覆盖已有文件
     */
    public static void writeFile(String content, String filePath, boolean cover) {
        if(null == content || null == filePath) {
            return;
        }
        BufferedWriter bufferedWriter = null;
        try {
            File file = new File(filePath);
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            if (cover || !file.exists()) {
                bufferedWriter = new BufferedWriter(
                        new OutputStreamWriter(new FileOutputStream(file, false), "UTF-8"));
                bufferedWriter.write(content);
            } else {
                logger.info("文件[{}]已存在，直接跳过！", filePath);
            }
        } catch (Exception e) {
            logger.error("写到文件时出错", e);
        } finally {
            if(null != bufferedWriter) {
                try {
                    bufferedWriter.flush();
                    bufferedWriter.close();
                } catch (IOException e) {
                    logger.error("关闭文件时出错", e);
                }
            }
        }
    }


}
