package cn.com.weye.utils.svg;

import freemarker.template.Configuration;
import freemarker.template.Template;
import sun.misc.BASE64Encoder;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zpz on 2016/11/7.
 */
public class WordUtil {
    public static void main(String args[]){
        /**
         *jsp页面引入
         <script src='${ctxStatic}/Highcharts/js/modules/exporting.js' type="text/javascript"></script>
         图表option添加 exporting:{enabled:false}
         var char = $('#container').highcharts();
         var svg = chart.getSVG();
         */
        String svg = "<svg xmlns:xlink=\"http://www.w3.org/1999/xlink\" version=\"1.1\" class=\"highcharts-root\" style=\"font-family:'lucida grande', 'lucida sans unicode', arial, helvetica, sans-serif;font-size:12px;\" xmlns=\"http://www.w3.org/2000/svg\" width=\"600\" viewBox=\"0 0 600 400\" height=\"400\"><desc>Created with Highcharts 5.0.2</desc><defs><clipPath id=\"highcharts-9\"><rect x=\"0\" y=\"0\" width=\"551\" height=\"350\" fill=\"none\"></rect></clipPath></defs><rect fill=\"rgb(0,0,0)\" fill-opacity=\"0\" class=\"highcharts-background\" x=\"0\" y=\"0\" width=\"600\" height=\"400\" rx=\"0\" ry=\"0\"></rect><rect fill=\"none\" class=\"highcharts-plot-background\" x=\"39\" y=\"10\" width=\"551\" height=\"350\"></rect><g class=\"highcharts-grid highcharts-xaxis-grid \"><path fill=\"none\" class=\"highcharts-grid-line\" d=\"M 176.5 10 L 176.5 360\" opacity=\"1\"></path><path fill=\"none\" class=\"highcharts-grid-line\" d=\"M 314.5 10 L 314.5 360\" opacity=\"1\"></path><path fill=\"none\" class=\"highcharts-grid-line\" d=\"M 451.5 10 L 451.5 360\" opacity=\"1\"></path><path fill=\"none\" class=\"highcharts-grid-line\" d=\"M 589.5 10 L 589.5 360\" opacity=\"1\"></path><path fill=\"none\" class=\"highcharts-grid-line\" d=\"M 38.5 10 L 38.5 360\" opacity=\"1\"></path></g><g class=\"highcharts-grid highcharts-yaxis-grid \"><path fill=\"none\" class=\"highcharts-grid-line\" d=\"M 39 360.5 L 590 360.5\" opacity=\"1\"></path><path fill=\"none\" class=\"highcharts-grid-line\" d=\"M 39 273.5 L 590 273.5\" opacity=\"1\"></path><path fill=\"none\" class=\"highcharts-grid-line\" d=\"M 39 185.5 L 590 185.5\" opacity=\"1\"></path><path fill=\"none\" class=\"highcharts-grid-line\" d=\"M 39 98.5 L 590 98.5\" opacity=\"1\"></path><path fill=\"none\" class=\"highcharts-grid-line\" d=\"M 39 10.5 L 590 10.5\" opacity=\"1\"></path></g><rect fill=\"none\" class=\"highcharts-plot-border\" x=\"39\" y=\"10\" width=\"551\" height=\"350\"></rect><g class=\"highcharts-axis highcharts-xaxis \"><path fill=\"none\" class=\"highcharts-tick\" stroke=\"#ccd6eb\" stroke-width=\"1\" d=\"M 176.5 360 L 176.5 370\" opacity=\"1\"></path><path fill=\"none\" class=\"highcharts-tick\" stroke=\"#ccd6eb\" stroke-width=\"1\" d=\"M 314.5 360 L 314.5 370\" opacity=\"1\"></path><path fill=\"none\" class=\"highcharts-tick\" stroke=\"#ccd6eb\" stroke-width=\"1\" d=\"M 451.5 360 L 451.5 370\" opacity=\"1\"></path><path fill=\"none\" class=\"highcharts-tick\" stroke=\"#ccd6eb\" stroke-width=\"1\" d=\"M 590.5 360 L 590.5 370\" opacity=\"1\"></path><path fill=\"none\" class=\"highcharts-tick\" stroke=\"#ccd6eb\" stroke-width=\"1\" d=\"M 38.5 360 L 38.5 370\" opacity=\"1\"></path><path fill=\"none\" class=\"highcharts-axis-line\" stroke=\"#ccd6eb\" stroke-width=\"1\" d=\"M 39 360.5 L 590 360.5\"></path></g><g class=\"highcharts-axis highcharts-yaxis \"><path fill=\"none\" class=\"highcharts-axis-line\" d=\"M 39 10 L 39 360\"></path></g><g class=\"highcharts-series-group\"><g class=\"highcharts-series highcharts-series-0 highcharts-column-series highcharts-color-undefined \" transform=\"translate(39,10) scale(1 1)\" width=\"350\" height=\"551\" clip-path=\"url(#highcharts-9)\"><rect x=\"30\" y=\"347\" width=\"9\" height=\"4\" fill=\"#C0F0FF\" class=\"highcharts-point\"></rect><rect x=\"168\" y=\"351\" width=\"9\" height=\"0\" fill=\"#C0F0FF\" class=\"highcharts-point\"></rect><rect x=\"306\" y=\"342\" width=\"9\" height=\"9\" fill=\"#C0F0FF\" class=\"highcharts-point\"></rect><rect x=\"444\" y=\"351\" width=\"9\" height=\"0\" fill=\"#C0F0FF\" class=\"highcharts-point\"></rect></g><g class=\"highcharts-markers highcharts-series-0 highcharts-column-series highcharts-color-undefined \" transform=\"translate(39,10) scale(1 1)\" width=\"350\" height=\"551\" clip-path=\"none\"></g><g class=\"highcharts-series highcharts-series-1 highcharts-column-series highcharts-color-undefined \" transform=\"translate(39,10) scale(1 1)\" width=\"350\" height=\"551\" clip-path=\"url(#highcharts-9)\"><rect x=\"44\" y=\"307\" width=\"9\" height=\"44\" fill=\"#FFC0A8\" class=\"highcharts-point\"></rect><rect x=\"182\" y=\"299\" width=\"9\" height=\"52\" fill=\"#FFC0A8\" class=\"highcharts-point\"></rect><rect x=\"320\" y=\"290\" width=\"9\" height=\"61\" fill=\"#FFC0A8\" class=\"highcharts-point\"></rect><rect x=\"457\" y=\"281\" width=\"9\" height=\"70\" fill=\"#FFC0A8\" class=\"highcharts-point\"></rect></g><g class=\"highcharts-markers highcharts-series-1 highcharts-column-series highcharts-color-undefined \" transform=\"translate(39,10) scale(1 1)\" width=\"350\" height=\"551\" clip-path=\"none\"></g><g class=\"highcharts-series highcharts-series-2 highcharts-column-series highcharts-color-undefined \" transform=\"translate(39,10) scale(1 1)\" width=\"350\" height=\"551\" clip-path=\"url(#highcharts-9)\"><rect x=\"58\" y=\"246\" width=\"9\" height=\"105\" fill=\"#D8FFC0\" class=\"highcharts-point\"></rect><rect x=\"196\" y=\"237\" width=\"9\" height=\"114\" fill=\"#D8FFC0\" class=\"highcharts-point\"></rect><rect x=\"333\" y=\"229\" width=\"9\" height=\"122\" fill=\"#D8FFC0\" class=\"highcharts-point\"></rect><rect x=\"471\" y=\"220\" width=\"9\" height=\"131\" fill=\"#D8FFC0\" class=\"highcharts-point\"></rect></g><g class=\"highcharts-markers highcharts-series-2 highcharts-column-series highcharts-color-undefined \" transform=\"translate(39,10) scale(1 1)\" width=\"350\" height=\"551\" clip-path=\"none\"></g><g class=\"highcharts-series highcharts-series-3 highcharts-column-series highcharts-color-undefined \" transform=\"translate(39,10) scale(1 1)\" width=\"350\" height=\"551\" clip-path=\"url(#highcharts-9)\"><rect x=\"72\" y=\"185\" width=\"9\" height=\"166\" fill=\"#C0A8D8\" class=\"highcharts-point\"></rect><rect x=\"209\" y=\"176\" width=\"9\" height=\"175\" fill=\"#C0A8D8\" class=\"highcharts-point\"></rect><rect x=\"347\" y=\"167\" width=\"9\" height=\"184\" fill=\"#C0A8D8\" class=\"highcharts-point\"></rect><rect x=\"485\" y=\"159\" width=\"9\" height=\"192\" fill=\"#C0A8D8\" class=\"highcharts-point\"></rect></g><g class=\"highcharts-markers highcharts-series-3 highcharts-column-series highcharts-color-undefined \" transform=\"translate(39,10) scale(1 1)\" width=\"350\" height=\"551\" clip-path=\"none\"></g><g class=\"highcharts-series highcharts-series-4 highcharts-column-series highcharts-color-undefined \" transform=\"translate(39,10) scale(1 1)\" width=\"350\" height=\"551\" clip-path=\"url(#highcharts-9)\"><rect x=\"85\" y=\"124\" width=\"9\" height=\"227\" fill=\"#A8C0FF\" class=\"highcharts-point\"></rect><rect x=\"223\" y=\"115\" width=\"9\" height=\"236\" fill=\"#A8C0FF\" class=\"highcharts-point\"></rect><rect x=\"361\" y=\"106\" width=\"9\" height=\"245\" fill=\"#A8C0FF\" class=\"highcharts-point\"></rect><rect x=\"499\" y=\"97\" width=\"9\" height=\"254\" fill=\"#A8C0FF\" class=\"highcharts-point\"></rect></g><g class=\"highcharts-markers highcharts-series-4 highcharts-column-series highcharts-color-undefined \" transform=\"translate(39,10) scale(1 1)\" width=\"350\" height=\"551\" clip-path=\"none\"></g><g class=\"highcharts-series highcharts-series-5 highcharts-column-series highcharts-color-undefined \" transform=\"translate(39,10) scale(1 1)\" width=\"350\" height=\"551\" clip-path=\"url(#highcharts-9)\"><rect x=\"99\" y=\"62\" width=\"9\" height=\"289\" fill=\"#FFD8A8\" class=\"highcharts-point\"></rect><rect x=\"237\" y=\"54\" width=\"9\" height=\"297\" fill=\"#FFD8A8\" class=\"highcharts-point\"></rect><rect x=\"375\" y=\"45\" width=\"9\" height=\"306\" fill=\"#FFD8A8\" class=\"highcharts-point\"></rect><rect x=\"512\" y=\"36\" width=\"9\" height=\"315\" fill=\"#FFD8A8\" class=\"highcharts-point\"></rect></g><g class=\"highcharts-markers highcharts-series-5 highcharts-column-series highcharts-color-undefined \" transform=\"translate(39,10) scale(1 1)\" width=\"350\" height=\"551\" clip-path=\"none\"></g></g><g class=\"highcharts-axis-labels highcharts-xaxis-labels \"><text x=\"107.875\" style=\"color:#666666;cursor:default;font-size:11px;fill:#666666;width:137.75;text-overflow:ellipsis;\" text-anchor=\"middle\" transform=\"translate(0,0)\" y=\"379\" opacity=\"1\"><tspan>实验室比对项目数(检品总…</tspan><title>实验室比对项目数(检品总数)</title></text><text x=\"245.625\" style=\"color:#666666;cursor:default;font-size:11px;fill:#666666;width:137.75;text-overflow:ellipsis;\" text-anchor=\"middle\" transform=\"translate(0,0)\" y=\"379\" opacity=\"1\"><tspan>实验室比对项目数(测定项…</tspan><title>实验室比对项目数(测定项目数)</title></text><text x=\"383.375\" style=\"color:#666666;cursor:default;font-size:11px;fill:#666666;width:137.75;text-overflow:ellipsis;\" text-anchor=\"middle\" transform=\"translate(0,0)\" y=\"379\" opacity=\"1\"><tspan>对照品协作标定项目数(检…</tspan><title>对照品协作标定项目数(检品总数)</title></text><text x=\"521.125\" style=\"color:#666666;cursor:default;font-size:11px;fill:#666666;width:137.75;text-overflow:ellipsis;\" text-anchor=\"middle\" transform=\"translate(0,0)\" y=\"379\" opacity=\"1\"><tspan>对照品协作标定项目数(测…</tspan><title>对照品协作标定项目数(测定项目数)</title></text></g><g class=\"highcharts-axis-labels highcharts-yaxis-labels \"><text x=\"24\" style=\"color:#666666;cursor:default;font-size:11px;fill:#666666;width:188px;text-overflow:clip;\" text-anchor=\"end\" transform=\"translate(0,0)\" y=\"363\" opacity=\"1\"><tspan>0</tspan></text><text x=\"24\" style=\"color:#666666;cursor:default;font-size:11px;fill:#666666;width:188px;text-overflow:clip;\" text-anchor=\"end\" transform=\"translate(0,0)\" y=\"275\" opacity=\"1\"><tspan>20</tspan></text><text x=\"24\" style=\"color:#666666;cursor:default;font-size:11px;fill:#666666;width:188px;text-overflow:clip;\" text-anchor=\"end\" transform=\"translate(0,0)\" y=\"188\" opacity=\"1\"><tspan>40</tspan></text><text x=\"24\" style=\"color:#666666;cursor:default;font-size:11px;fill:#666666;width:188px;text-overflow:clip;\" text-anchor=\"end\" transform=\"translate(0,0)\" y=\"100\" opacity=\"1\"><tspan>60</tspan></text><text x=\"24\" style=\"color:#666666;cursor:default;font-size:11px;fill:#666666;width:188px;text-overflow:clip;\" text-anchor=\"end\" transform=\"translate(0,0)\" y=\"13\" opacity=\"1\"><tspan>80</tspan></text></g></svg>\n";

        try {
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            SvgPngConverter.convertToPng(svg,out);
            String imageData = getImageStr(out.toByteArray());
            HashMap dataMap = new HashMap();
            ArrayList<Map> userList = new ArrayList<Map>();
            String names[] = {"解丽娜", "孙磊"};
            for(int i=0; i<2; i++){
                Map rec = new HashMap();
                rec.put("id", i+1);
                rec.put("name", names[i]);
                rec.put("dept", "研发部");
                userList.add(rec);
            }
            dataMap.put("imageData", imageData);
            dataMap.put("userList", userList);
            createWord(dataMap, "tt1.xml", "d:/", "tt1.doc");

        }catch (Exception e){
            e.printStackTrace();

        }

    }
    public static void createWord(Map dataMap, String templateName, String filePath, String fileName){
        try {
            //创建配置实例
            Configuration configuration = new Configuration();

            //设置编码
            configuration.setDefaultEncoding("UTF-8");

            //ftl模板文件统一放至 com.lun.template 包下面
            configuration.setClassForTemplateLoading(WordUtil.class,"/word/");

            //获取模板
            Template template = configuration.getTemplate(templateName);

            //输出文件
            File outFile = new File(filePath+File.separator+fileName);

            //如果输出目标文件夹不存在，则创建
            if (!outFile.getParentFile().exists()){
                outFile.getParentFile().mkdirs();
            }

            //将模板和数据模型合并生成文件
            Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile),"UTF-8"));


            //生成文件
            template.process(dataMap, out);

            //关闭流
            out.flush();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static String getImageStr(String filePath) {
        InputStream in = null;
        try {
            in = new FileInputStream(filePath);
            return getImageStr(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static String getImageStr(InputStream in) {
        byte[] data = null;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {
            int bufLen= 1024, len=0;
            data = new byte[bufLen];
            while ((len = in.read(data)) != -1){
                out.write(data,0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                in.close();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encode(out.toByteArray());
    }
    public static String getImageStr(byte[] bytes) {
        BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encode(bytes);
    }
}
