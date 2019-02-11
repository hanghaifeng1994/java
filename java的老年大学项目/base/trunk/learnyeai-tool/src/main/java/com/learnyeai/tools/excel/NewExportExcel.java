/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.learnyeai.tools.excel;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;

import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

/**
 *
 *
 *  功能说明: 导出Excel
 *
 *  创建说明: 2014年6月24日 下午1:56:09 houkun
 *
 *  修改历史:
 *
 */
public class NewExportExcel {

    /**
     * 功能描述:导出Excel表格方法一(以Object的形式导出)
     *
     * @author houkun 2013-11-01 下午03:28:46
     *
     * @param list
     * @param headers
     */
    public static void exportExcel(HttpServletResponse response, String fileName, List<?> list, String[] colums, String[] headers, String dateFormat) throws Exception {
        int rowIndex = 0;
        Workbook workbook = new HSSFWorkbook(); 									// 创建一个工作簿
        Sheet sheet = workbook.createSheet(); 										// 创建一个Sheet页
        sheet.autoSizeColumn((short) 0); 											// 单元格宽度自适应
        Row row = sheet.createRow(rowIndex++); 										// 创建第一行(头部)
        CreationHelper helper = workbook.getCreationHelper();
        CellStyle style = workbook.createCellStyle(); 								// 设置单元格样式
        style.setDataFormat(helper.createDataFormat().getFormat(dateFormat)); 		// 格式化日期类型
        for (int i = 0; i < headers.length; i++) { 									// 输出头部
            row.createCell(i).setCellValue(headers[i]);
        }
        for (Object obj : list) {
            List<Object> values = NewExportExcel.getFieldValuesByNames(colums,obj);
            row = sheet.createRow(rowIndex++);
            for (int j = 0; j < values.size(); j++) {
                row.createCell(j).setCellValue(getValue(values.get(j)));
            }
        }
        String ddate = new SimpleDateFormat("yyyyMMddhhmmss").format(Calendar.getInstance().getTime());
        response.setContentType("application/vnd.ms-excel;charset=UTF-8");
        response.setHeader("Content-Disposition", "attachment; filename="+ new String(fileName.getBytes("gb2312"),"iso8859-1") + "_" + ddate + ".xls");// 设定输出文件头
        OutputStream output = response.getOutputStream();
        workbook.write(output);
        output.flush();
        output.close();
    }

    /**
     * 功能描述:导出Excel方法二(以Map的方式导出)
     *
     * @author houkun  2014年6月15日 下午6:31:46
     *
     * @param fileName	文件名
     * @param list		数据
     * @param keys		map key 值
     * @param headers	Excel 列名
     * @param title 	标题栏  传空则不需要
     */
    @SuppressWarnings("rawtypes")
    public static void exportMapExcel(HttpServletResponse response, String fileName, String[] sheetName, List<List<Map>> list, String[][] keys, String[][] headers, String dateFormat, String[] title) throws Exception {
        Workbook workbook = new HSSFWorkbook(); 									// 创建一个工作簿
        for(int k=0;k<sheetName.length;k++){
         int rowIndex = 0;
        Sheet sheet = workbook.createSheet(sheetName[k]);
           /* sheet.autoSizeColumn((short) 0); 	*/									// 单元格宽度自适应
            /*sheet.setColumnWidth(0, 3766);*/
            CreationHelper helper = workbook.getCreationHelper();
            CellStyle style = workbook.createCellStyle(); 								// 设置单元格样式
            style.setDataFormat(helper.createDataFormat().getFormat(dateFormat)); 		// 格式化日期类型
            style.setAlignment(CellStyle.ALIGN_CENTER);									//水平居中
            style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);						//垂直居中
            /*Row row = null;*/
            if(title[k] != null || !"".equals(title[k].trim())){
                Row titleRow = sheet.createRow(rowIndex++);
                titleRow.setHeightInPoints(30);
                /*row = sheet.createRow(rowIndex++); 	*/									// 创建第一行(标题)
                sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, headers[k].length-1));
                titleRow.setHeight((short)600);
                //设置字体
                style = workbook.createCellStyle();
                style.setAlignment(CellStyle.ALIGN_CENTER);
                style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
                Font titleFont = workbook.createFont();
                titleFont.setFontName("Arial");
                titleFont.setFontHeightInPoints((short) 16);
                titleFont.setBoldweight(Font.BOLDWEIGHT_BOLD);
                style.setFont(titleFont);
                titleRow.createCell(0).setCellValue(title[k]);
                titleRow.getCell(0).setCellStyle(style);
            }
            /*row = sheet.createRow(rowIndex++);*/
            Row headerRow = sheet.createRow(rowIndex++);
            for (int i = 0; i < headers[k].length; i++) { 									// 输出头部
                sheet.setColumnWidth(i, 3766);
                style = workbook.createCellStyle();
                style.setAlignment(CellStyle.ALIGN_CENTER);
                style.setFillForegroundColor(IndexedColors.GREY_50_PERCENT.getIndex());
                style.setFillPattern(CellStyle.SOLID_FOREGROUND);
                Font headerFont = workbook.createFont();
                headerFont.setFontName("Arial");
                headerFont.setFontHeightInPoints((short) 10);
                headerFont.setBoldweight(Font.BOLDWEIGHT_BOLD);
                headerFont.setColor(IndexedColors.WHITE.getIndex());
                style.setFont(headerFont);
                headerRow.createCell(i).setCellValue(headers[k][i]);
                headerRow.getCell(i).setCellStyle(style);
            }
            for (Map map : list.get(k)) {
                Row row = sheet.createRow(rowIndex++);
                for(int i = 0 ;i<keys[k].length;i++){
                    style = workbook.createCellStyle();
                    style.setAlignment(CellStyle.ALIGN_CENTER);
                    style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
                    style.setBorderRight(CellStyle.BORDER_THIN);
                    style.setRightBorderColor(IndexedColors.GREY_50_PERCENT.getIndex());
                    style.setBorderLeft(CellStyle.BORDER_THIN);
                    style.setLeftBorderColor(IndexedColors.GREY_50_PERCENT.getIndex());
                    style.setBorderTop(CellStyle.BORDER_THIN);
                    style.setTopBorderColor(IndexedColors.GREY_50_PERCENT.getIndex());
                    style.setBorderBottom(CellStyle.BORDER_THIN);
                    style.setBottomBorderColor(IndexedColors.GREY_50_PERCENT.getIndex());
                    Font dataFont = workbook.createFont();
                    dataFont.setFontName("Arial");
                    dataFont.setFontHeightInPoints((short) 10);
                    style.setFont(dataFont);
                    row.createCell(i).setCellValue(getValue(map.get(keys[k][i])));
                    row.getCell(i).setCellStyle(style);
                }
            }
        }// 创建一个Sheet页
        String ddate = new SimpleDateFormat("yyyyMMddhhmmss").format(Calendar.getInstance().getTime());
        response.setContentType("application/vnd.ms-excel;charset=UTF-8");
        response.setHeader("Content-Disposition", "attachment; filename="+ new String(fileName.getBytes("gb2312"),"iso8859-1") + "_" + ddate + ".xls");// 设定输出文件头
        OutputStream output = response.getOutputStream();
        workbook.write(output);
        output.flush();
        output.close();
    }

    /**
     * 功能描述:导出Excel方法食品药品监督管理局药品各类抽验统计报表(以Map的方式导出)
     *
     * @author houkun  2014年6月15日 下午6:31:46
     *
     * @param fileName	文件名
     * @param list		数据
     * @param keys		map key 值
     * @param headers	Excel 列名
     * @param title 	标题栏  传空则不需要
     */
    @SuppressWarnings("rawtypes")
    public static void exportNewMapExcel(HttpServletResponse response, String fileName, String[] sheetName,
                                         List<List<Map>> list, String[][] keys, String[][] headers, int size1, int size2, String dateFormat, String[] title) throws Exception {
        Workbook workbook = new HSSFWorkbook(); 									// 创建一个工作簿
        for(int k=0;k<sheetName.length;k++){
            int rowIndex = 0;
            Sheet sheet = workbook.createSheet(sheetName[k]);
           /* sheet.autoSizeColumn((short) 0); 	*/									// 单元格宽度自适应
            /*sheet.setColumnWidth(0, 3766);*/
            CreationHelper helper = workbook.getCreationHelper();
            CellStyle style = workbook.createCellStyle(); 								// 设置单元格样式
            style.setDataFormat(helper.createDataFormat().getFormat(dateFormat)); 		// 格式化日期类型
            style.setAlignment(CellStyle.ALIGN_CENTER);									//水平居中
            style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);						//垂直居中
            /*Row row = null;*/
            if(title[k] != null || !"".equals(title[k].trim())){
                Row titleRow = sheet.createRow(rowIndex++);
                titleRow.setHeightInPoints(30);
                /*row = sheet.createRow(rowIndex++); 	*/									// 创建第一行(标题)
                sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, headers[k].length-1));
                //抽验情况合并
                sheet.addMergedRegion(new CellRangeAddress(1, 1, 2, 5));
                //检验完成情况合并
                sheet.addMergedRegion(new CellRangeAddress(1, 1, 6, 11));
                //抽样类别合并
                sheet.addMergedRegion(new CellRangeAddress(1, 2, 0, 0));
                //任务量合并
                sheet.addMergedRegion(new CellRangeAddress(1, 2, 1, 1));
                //备注合并
                sheet.addMergedRegion(new CellRangeAddress(1, 2, 12, 12));
                //省评价合并
                sheet.addMergedRegion(new CellRangeAddress(3, size1+3, 0, 0));
                //省监督合并
                sheet.addMergedRegion(new CellRangeAddress(size1+4, size1+size2+4, 0, 0));
                titleRow.setHeight((short)600);
                //设置字体
                style = workbook.createCellStyle();
                style.setAlignment(CellStyle.ALIGN_CENTER);
                style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
                Font titleFont = workbook.createFont();
                titleFont.setFontName("Arial");
                titleFont.setFontHeightInPoints((short) 16);
                titleFont.setBoldweight(Font.BOLDWEIGHT_BOLD);
                style.setFont(titleFont);
                titleRow.createCell(0).setCellValue(title[k]);
                titleRow.getCell(0).setCellStyle(style);
            }
            /*row = sheet.createRow(rowIndex++);*/
            Row headerRow = sheet.createRow(rowIndex++);
            for (int i = 0; i < headers[k].length; i++) { 									// 输出头部
                sheet.setColumnWidth(i, 3766);
                style = workbook.createCellStyle();
                style.setAlignment(CellStyle.ALIGN_CENTER);
                style.setFillForegroundColor(IndexedColors.GREY_50_PERCENT.getIndex());
                style.setFillPattern(CellStyle.SOLID_FOREGROUND);
                Font headerFont = workbook.createFont();
                headerFont.setFontName("Arial");
                headerFont.setFontHeightInPoints((short) 10);
                headerFont.setBoldweight(Font.BOLDWEIGHT_BOLD);
                headerFont.setColor(IndexedColors.WHITE.getIndex());
                style.setFont(headerFont);
                headerRow.createCell(i).setCellValue(headers[k][i]);
                headerRow.getCell(i).setCellStyle(style);
            }
            for (Map map : list.get(k)) {
                Row row = sheet.createRow(rowIndex++);
                for(int i = 0 ;i<keys[k].length;i++){
                    style = workbook.createCellStyle();
                    style.setAlignment(CellStyle.ALIGN_CENTER);
                    style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
                    style.setBorderRight(CellStyle.BORDER_THIN);
                    style.setRightBorderColor(IndexedColors.GREY_50_PERCENT.getIndex());
                    style.setBorderLeft(CellStyle.BORDER_THIN);
                    style.setLeftBorderColor(IndexedColors.GREY_50_PERCENT.getIndex());
                    style.setBorderTop(CellStyle.BORDER_THIN);
                    style.setTopBorderColor(IndexedColors.GREY_50_PERCENT.getIndex());
                    style.setBorderBottom(CellStyle.BORDER_THIN);
                    style.setBottomBorderColor(IndexedColors.GREY_50_PERCENT.getIndex());
                    Font dataFont = workbook.createFont();
                    dataFont.setFontName("Arial");
                    dataFont.setFontHeightInPoints((short) 10);
                    style.setFont(dataFont);
                    row.createCell(i).setCellValue(getValue(map.get(keys[k][i])));
                    row.getCell(i).setCellStyle(style);
                }
                style = workbook.createCellStyle();
                style.setAlignment(CellStyle.ALIGN_CENTER);
                style.setFillForegroundColor(IndexedColors.GREY_50_PERCENT.getIndex());
                style.setFillPattern(CellStyle.SOLID_FOREGROUND);
                Font headerFont = workbook.createFont();
                headerFont.setFontName("Arial");
                headerFont.setFontHeightInPoints((short) 10);
                headerFont.setBoldweight(Font.BOLDWEIGHT_BOLD);
                headerFont.setColor(IndexedColors.WHITE.getIndex());
                style.setFont(headerFont);
                //给抽验情况和检验完成情况设置样式
                sheet.getRow(2).getCell(2).setCellStyle(style);
                sheet.getRow(2).getCell(3).setCellStyle(style);
                sheet.getRow(2).getCell(4).setCellStyle(style);
                sheet.getRow(2).getCell(5).setCellStyle(style);
                sheet.getRow(2).getCell(6).setCellStyle(style);
                sheet.getRow(2).getCell(7).setCellStyle(style);
                sheet.getRow(2).getCell(8).setCellStyle(style);
                sheet.getRow(2).getCell(9).setCellStyle(style);
                sheet.getRow(2).getCell(10).setCellStyle(style);
                sheet.getRow(2).getCell(11).setCellStyle(style);
            }
        }// 创建一个Sheet页
        String ddate = new SimpleDateFormat("yyyyMMddhhmmss").format(Calendar.getInstance().getTime());
        response.setContentType("application/vnd.ms-excel;charset=UTF-8");
        response.setHeader("Content-Disposition", "attachment; filename="+ new String(fileName.getBytes("gb2312"),"iso8859-1") + "_" + ddate + ".xls");// 设定输出文件头
        OutputStream output = response.getOutputStream();
        workbook.write(output);
        output.flush();
        output.close();
    }
    /**
     * 功能描述:导出Excel方法食品药品监督管理局药品各类抽验统计报表(以Map的方式导出)
     *
     * @author houkun  2014年6月15日 下午6:31:46
     *
     * @param fileName	文件名
     * @param list		数据
     * @param keys		map key 值
     * @param headers	Excel 列名
     * @param title 	标题栏  传空则不需要
     */
    @SuppressWarnings("rawtypes")
    public static void exportNbzkMapExcel(HttpServletResponse response, String fileName, String[] sheetName,
                                          List<List<Map>> list, String[][] keys, String[][] headers, String dateFormat, String[] title) throws Exception {
        Workbook workbook = new HSSFWorkbook(); 									// 创建一个工作簿
        for(int k=0;k<sheetName.length;k++){
            int rowIndex = 0;
            Sheet sheet = workbook.createSheet(sheetName[k]);
           /* sheet.autoSizeColumn((short) 0); 	*/									// 单元格宽度自适应
            /*sheet.setColumnWidth(0, 3766);*/
            CreationHelper helper = workbook.getCreationHelper();
            CellStyle style = workbook.createCellStyle(); 								// 设置单元格样式
            style.setDataFormat(helper.createDataFormat().getFormat(dateFormat)); 		// 格式化日期类型
            style.setAlignment(CellStyle.ALIGN_CENTER);									//水平居中
            style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);						//垂直居中
            /*Row row = null;*/
            if(title[k] != null || !"".equals(title[k].trim())){
                Row titleRow = sheet.createRow(rowIndex++);
                titleRow.setHeightInPoints(30);
                /*row = sheet.createRow(rowIndex++); 	*/									// 创建第一行(标题)
                sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, headers[k].length-1));
                //抽验情况合并
                sheet.addMergedRegion(new CellRangeAddress(1, 1, 0, 1));
                sheet.addMergedRegion(new CellRangeAddress(2, 2, 0, 1));
                sheet.addMergedRegion(new CellRangeAddress(3, 3, 0, 1));
                sheet.addMergedRegion(new CellRangeAddress(4, 4, 0, 1));
                sheet.addMergedRegion(new CellRangeAddress(5, 5, 0, 1));
                sheet.addMergedRegion(new CellRangeAddress(6, 6, 0, 1));
                sheet.addMergedRegion(new CellRangeAddress(7, 7, 0, 1));
                sheet.addMergedRegion(new CellRangeAddress(8, 8, 0, 1));
                sheet.addMergedRegion(new CellRangeAddress(9, 9, 0, 1));
                sheet.addMergedRegion(new CellRangeAddress(10, 10, 0, 1));
                sheet.addMergedRegion(new CellRangeAddress(11, 11, 0, 1));
                sheet.addMergedRegion(new CellRangeAddress(12, 12, 0, 1));
                sheet.addMergedRegion(new CellRangeAddress(13, 13, 0, 1));
                sheet.addMergedRegion(new CellRangeAddress(14, 18, 0, 0));

//                //检验完成情况合并
//                sheet.addMergedRegion(new CellRangeAddress(1, 1, 6, 11));
//                //抽样类别合并
//                sheet.addMergedRegion(new CellRangeAddress(1, 2, 0, 0));
//                //任务量合并
//                sheet.addMergedRegion(new CellRangeAddress(1, 2, 1, 1));
//                //备注合并
//                sheet.addMergedRegion(new CellRangeAddress(1, 2, 12, 12));
                titleRow.setHeight((short)600);
                //设置字体
                style = workbook.createCellStyle();
                style.setAlignment(CellStyle.ALIGN_CENTER);
                style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
                Font titleFont = workbook.createFont();
                titleFont.setFontName("Arial");
                titleFont.setFontHeightInPoints((short) 16);
                titleFont.setBoldweight(Font.BOLDWEIGHT_BOLD);
                style.setFont(titleFont);
                titleRow.createCell(0).setCellValue(title[k]);
                titleRow.getCell(0).setCellStyle(style);
            }
            /*row = sheet.createRow(rowIndex++);*/
            Row headerRow = sheet.createRow(rowIndex++);
            for (int i = 0; i < headers[k].length; i++) { 									// 输出头部
                sheet.setColumnWidth(i, 3766);
                style = workbook.createCellStyle();
                style.setAlignment(CellStyle.ALIGN_CENTER);
                style.setFillForegroundColor(IndexedColors.GREY_50_PERCENT.getIndex());
                style.setFillPattern(CellStyle.SOLID_FOREGROUND);
                Font headerFont = workbook.createFont();
                headerFont.setFontName("Arial");
                headerFont.setFontHeightInPoints((short) 10);
                headerFont.setBoldweight(Font.BOLDWEIGHT_BOLD);
                headerFont.setColor(IndexedColors.WHITE.getIndex());
                style.setFont(headerFont);
                headerRow.createCell(i).setCellValue(headers[k][i]);
                headerRow.getCell(i).setCellStyle(style);
            }
            for (Map map : list.get(k)) {
                Row row = sheet.createRow(rowIndex++);
                for(int i = 0 ;i<keys[k].length;i++){
                    style = workbook.createCellStyle();
                    style.setAlignment(CellStyle.ALIGN_CENTER);
                    style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
                    style.setBorderRight(CellStyle.BORDER_THIN);
                    style.setRightBorderColor(IndexedColors.GREY_50_PERCENT.getIndex());
                    style.setBorderLeft(CellStyle.BORDER_THIN);
                    style.setLeftBorderColor(IndexedColors.GREY_50_PERCENT.getIndex());
                    style.setBorderTop(CellStyle.BORDER_THIN);
                    style.setTopBorderColor(IndexedColors.GREY_50_PERCENT.getIndex());
                    style.setBorderBottom(CellStyle.BORDER_THIN);
                    style.setBottomBorderColor(IndexedColors.GREY_50_PERCENT.getIndex());
                    Font dataFont = workbook.createFont();
                    dataFont.setFontName("Arial");
                    dataFont.setFontHeightInPoints((short) 10);
                    style.setFont(dataFont);
                    row.createCell(i).setCellValue(getValue(map.get(keys[k][i])));
                    row.getCell(i).setCellStyle(style);
                }
                style = workbook.createCellStyle();
                style.setAlignment(CellStyle.ALIGN_CENTER);
                style.setFillForegroundColor(IndexedColors.GREY_50_PERCENT.getIndex());
                style.setFillPattern(CellStyle.SOLID_FOREGROUND);
                Font headerFont = workbook.createFont();
                headerFont.setFontName("Arial");
                headerFont.setFontHeightInPoints((short) 10);
                headerFont.setBoldweight(Font.BOLDWEIGHT_BOLD);
                headerFont.setColor(IndexedColors.WHITE.getIndex());
                style.setFont(headerFont);
            }
        }// 创建一个Sheet页
        String ddate = new SimpleDateFormat("yyyyMMddhhmmss").format(Calendar.getInstance().getTime());
        response.setContentType("application/vnd.ms-excel;charset=UTF-8");
        response.setHeader("Content-Disposition", "attachment; filename="+ new String(fileName.getBytes("gb2312"),"iso8859-1") + "_" + ddate + ".xls");// 设定输出文件头
        OutputStream output = response.getOutputStream();
        workbook.write(output);
        output.flush();
        output.close();
    }

    public static String getValue(Object obj){
        if(obj != null){
            return obj.toString();
        }
        return "";
    }

    public static List<Object> getFieldValuesByNames(String[] fieldNames, Object o) {
        List<Object> list= new ArrayList<Object>();
        try {
            Class<?> clz=o.getClass();
            for(String fieldName : fieldNames){
                String firstLetter = fieldName.substring(0, 1).toUpperCase();
                String getter = "get" + firstLetter + fieldName.substring(1);
                Method method = clz.getMethod(getter, new Class[] {});
                Object value = method.invoke(o, new Object[] {});
                list.add(value);
            }
            return list;
        } catch (Exception e) {
            return null;
        }
    }

    @SuppressWarnings("rawtypes")
    public static void exportMapExcel1(HttpServletResponse response, String fileName, List<Map> list, String[] keys, String[] headers, String dateFormat, String title) throws Exception {
        int rowIndex = 0;
        Workbook workbook = new HSSFWorkbook(); 									// 创建一个工作簿
        Sheet sheet = workbook.createSheet(); 										// 创建一个Sheet页
        sheet.autoSizeColumn((short) 0); 											// 单元格宽度自适应
        CreationHelper helper = workbook.getCreationHelper();
        CellStyle style = workbook.createCellStyle(); 								// 设置单元格样式
        style.setDataFormat(helper.createDataFormat().getFormat(dateFormat)); 		// 格式化日期类型
        style.setAlignment(CellStyle.ALIGN_CENTER);									//水平居中
        style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);						//垂直居中
        Row row = null;
        if(title == null || "".equals(title.trim())){
            row = sheet.createRow(rowIndex++); 										// 创建第一行(标题)
            sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, headers.length-1));
            row.setHeight((short)600);
            //设置字体
            Font font = workbook.createFont();
            font.setFontHeightInPoints((short)16);
            style.setFont(font);
            row.createCell(0).setCellValue(title);
            row.getCell(0).setCellStyle(style);
        }
        row = sheet.createRow(rowIndex++);
        for (int i = 0; i < headers.length; i++) { 									// 输出头部
            row.createCell(i).setCellValue(headers[i]);
        }
        for (Map map : list) {
            row = sheet.createRow(rowIndex++);
            for(int i = 0 ;i<keys.length;i++){
                if(keys[i].equals("spzt")){
                    map.get(keys[i]);
                    if(map.get(keys[i]).equals("0")){
                        row.createCell(i).setCellValue(getValue("未审批"));
                    }

                }
                row.createCell(i).setCellValue(getValue(map.get(keys[i])));
            }
        }
        String ddate = new SimpleDateFormat("yyyyMMddhhmmss").format(Calendar.getInstance().getTime());
        response.setContentType("application/vnd.ms-excel;charset=UTF-8");
        response.setHeader("Content-Disposition", "attachment; filename="+ new String(fileName.getBytes("gb2312"),"iso8859-1") + "_" + ddate + ".xls");// 设定输出文件头
        OutputStream output = response.getOutputStream();
        workbook.write(output);
        output.flush();
        output.close();
    }

}

