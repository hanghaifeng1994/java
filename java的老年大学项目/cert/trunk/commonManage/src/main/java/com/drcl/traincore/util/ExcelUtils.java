//-------------------------------------------------------------------------
// Copyright (c) 2000-2010 Digital. All Rights Reserved.
//
// This software is the confidential and proprietary information of
// Digital
//
// Original author: qingang
//
//-------------------------------------------------------------------------
// LOOSOFT MAKES NO REPRESENTATIONS OR WARRANTIES ABOUT THE SUITABILITY OF
// THE SOFTWARE, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED
// TO THE IMPLIED WARRANTIES OF MERCHANTABILITY, FITNESS FOR A
// PARTICULAR PURPOSE, OR NON-INFRINGEMENT. UFINITY SHALL NOT BE
// LIABLE FOR ANY DAMAGES SUFFERED BY LICENSEE AS A RESULT OF USING,
// MODIFYING OR DISTRIBUTING THIS SOFTWARE OR ITS DERIVATIVES.
//
// THIS SOFTWARE IS NOT DESIGNED OR INTENDED FOR USE OR RESALE AS ON-LINE
// CONTROL EQUIPMENT IN HAZARDOUS ENVIRONMENTS REQUIRING FAIL-SAFE
// PERFORMANCE, SUCH AS IN THE OPERATION OF NUCLEAR FACILITIES, AIRCRAFT
// NAVIGATION OR COMMUNICATION SYSTEMS, AIR TRAFFIC CONTROL, DIRECT LIFE
// SUPPORT MACHINES, OR WEAPONS SYSTEMS, IN WHICH THE FAILURE OF THE
// SOFTWARE COULD LEAD DIRECTLY TO DEATH, PERSONAL INJURY, OR SEVERE
// PHYSICAL OR ENVIRONMENTAL DAMAGE ("HIGH RISK ACTIVITIES"). UFINITY
// SPECIFICALLY DISCLAIMS ANY EXPRESS OR IMPLIED WARRANTY OF FITNESS FOR
// HIGH RISK ACTIVITIES.
//-------------------------------------------------------------------------
package com.drcl.traincore.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils
{
    private static final int BUFFER_SIZE = 16 * 1024;

    /**
     * description: 把一个List生成为Excel<br>
     * 
     * @param linkedList
     * @param file
     * @author WeiXiaodong
     */
    public static void list2excel(List<Map<String, String>> list,
            List<String> keyList, File file)
    {
        List<LinkedHashMap<String, String>> linkedList = new ArrayList<LinkedHashMap<String, String>>();
        for (Map<String, String> map : list)
        {
            LinkedHashMap<String, String> tmpMap = new LinkedHashMap<String, String>();
            for (String key : keyList)
            {
                tmpMap.put(key, map.get(key));
            }
            linkedList.add(tmpMap);
        }

        if (!file.isDirectory())
        {
            file.getParentFile().mkdirs();
        }
        Workbook wb = new HSSFWorkbook();
        Sheet sheet = wb.createSheet("Sheet1");

        for (int i = 0; i < linkedList.size(); i++)
        {
            Row row = sheet.createRow(i);
            Map<String, String> map = linkedList.get(i);
            int column = 0;
            for (String key : map.keySet())
            {
                Cell cell = row.createCell(column++);
                cell.setCellValue(map.get(key));
            }
        }
        try
        {
            FileOutputStream fileOut = new FileOutputStream(file);
            wb.write(fileOut);
            fileOut.close();
        }
        catch (Exception e)
        {
            System.out.println("生成文件出错");
            e.printStackTrace();
        }
    }

    /**
     * description: 读取一个Excel文件并返回List<br>
     * 
     * @param keyList
     * @param file
     * @param flag
     *            true:2003,false:2007
     * @return
     * @author WeiXiaodong
     */
    public static List<Map<String, String>> excel2List(List<String> keyList,
            File file, boolean flag)
    {
        if (!file.isFile())
        {
            throw new RuntimeException(file + " 不存在");
        }
        POIFSFileSystem fs = null;
        Workbook wb = null;
        Sheet sheet = null;
        try
        {
            if (flag)
            {// 2003
                fs = new POIFSFileSystem(new FileInputStream(file));
                wb = new HSSFWorkbook(fs);
            }
            else
            {// 2007
                wb = new XSSFWorkbook(file.getPath());
            }
            sheet = wb.getSheetAt(0);
        }
        catch (IOException e)
        {
            System.out.println(file + "读取错误");
            e.printStackTrace();
        }
        List<Map<String, String>> resultList = new ArrayList<Map<String, String>>();
        for (Row row : sheet)
        {
            Map<String, String> tmpMap = new HashMap<String, String>();
            for (Cell cell : row)
            {
                int columnIndex = cell.getColumnIndex();
                String value = null;

                switch (cell.getCellType())
                {
                case Cell.CELL_TYPE_FORMULA:
                    value = "" + cell.getCellFormula();
                    break;
                case Cell.CELL_TYPE_NUMERIC:
                    if (HSSFDateUtil.isCellDateFormatted(cell))
                    {
                        value = "" + cell.getDateCellValue();
                    }
                    else
                    {
                        value = "" + cell.getNumericCellValue();
                    }
                    break;

                case Cell.CELL_TYPE_STRING:
                    value = "" + cell.getStringCellValue();
                    break;

                case Cell.CELL_TYPE_BOOLEAN:
                    value = "" + cell.getBooleanCellValue();
                    cell.getDateCellValue();
                    break;
                default:
                }

                tmpMap.put(keyList.get(columnIndex), value);
            }
            resultList.add(tmpMap);
        }
        return resultList;
    }

    /**
     * description: 读取一个Excel文件并返回List<br>
     * Description of this Method
     * 
     * @since 2010-8-25
     * @author wxd
     * @param keyList
     * @param file
     * @param flag
     * @param sheetNum
     * @param columnNum
     * @param cellNum
     * @return
     */
    public static List<Map<String, String>> excel2List(List<String> keyList,
            File file, boolean flag, int sheetNum, int columnNum, int cellNum)
    {
        if (!file.isFile())
        {
            throw new RuntimeException(file + " 不存在");
        }
        POIFSFileSystem fs = null;
        Workbook wb = null;
        Sheet sheet = null;
        try
        {
            if (flag)
            {// 2003
                fs = new POIFSFileSystem(new FileInputStream(file));
                wb = new HSSFWorkbook(fs);
            }
            else
            {// 2007
                wb = new XSSFWorkbook(file.getPath());
            }
            sheet = wb.getSheetAt(sheetNum);
        }
        catch (IOException e)
        {
            System.out.println(file + "读取错误");
            e.printStackTrace();
        }
        List<Map<String, String>> resultList = new ArrayList<Map<String, String>>();
        for (Row row : sheet)
        {
            Map<String, String> tmpMap = new HashMap<String, String>();
            for (Cell cell : row)
            {
                int columnIndex = cell.getColumnIndex();
                String value = null;

                switch (cell.getCellType())
                {
                case Cell.CELL_TYPE_FORMULA:
                    value = "" + cell.getCellFormula();
                    break;
                case Cell.CELL_TYPE_NUMERIC:
                    if (HSSFDateUtil.isCellDateFormatted(cell))
                    {
                        value = "" + cell.getDateCellValue();
                    }
                    else
                    {
                        value = "" + cell.getNumericCellValue();
                    }
                    break;

                case Cell.CELL_TYPE_STRING:
                    value = "" + cell.getStringCellValue();
                    break;

                case Cell.CELL_TYPE_BOOLEAN:
                    value = "" + cell.getBooleanCellValue();
                    cell.getDateCellValue();
                    break;
                default:
                }

                tmpMap.put(keyList.get(columnIndex - 1), value);
            }
            resultList.add(tmpMap);
        }
        return resultList;
    }

    // 自己封装的一个把源文件对象复制成目标文件对象
    public static void copy(File src, File dst)
    {
        InputStream in = null;
        OutputStream out = null;
        try
        {
            in = new BufferedInputStream(new FileInputStream(src), BUFFER_SIZE);
            out = new BufferedOutputStream(new FileOutputStream(dst),
                    BUFFER_SIZE);
            byte[] buffer = new byte[BUFFER_SIZE];
            int len = 0;
            while ((len = in.read(buffer)) > 0)
            {
                out.write(buffer, 0, len);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            if (null != in)
            {
                try
                {
                    in.close();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
            if (null != out)
            {
                try
                {
                    out.close();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }
    }
}
