package com.drcl.traincore.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;

import cn.common.lib.util.web.PropertyUtils;
/**
 * ffmpeg视频转换工具
 * @author hbqian
 *
 */
public class FfmpegUtil
{
    // 运行命令
    private static java.io.OutputStream runCmd(String command)
    {
        try
        {
            Runtime rt = Runtime.getRuntime();
            System.out.println("command" + command);
            Process proc = rt.exec(command);
            InputStream stderr = proc.getErrorStream();
            InputStreamReader isr = new InputStreamReader(stderr);
            BufferedReader br = new BufferedReader(isr);
            String line = null;
            System.out.println("<ERROR>");
            while ((line = br.readLine()) != null)
            {
            	if(line.trim().startsWith("Duration")){
            		System.out.println("00-"+line.substring(8,line.indexOf(",")));
            	}
                System.out.println("dsf--"+line);
            }
            System.out.println("</ERROR>");
            int exitVal = proc.waitFor();
            System.out.println("Process exitValue: " + exitVal);
            return proc.getOutputStream();
        }
        catch (Throwable t)
        {
            t.printStackTrace();
        }
        return null;
    }
    
    /**
     * 取得时长
     * @param command
     * @return
     */
    private static String runLenCmd(String file,String command)
    {
        try
        {
            Runtime rt = Runtime.getRuntime();
            System.out.println("command:" + command);
            Process proc = rt.exec(command);
            InputStream stderr = proc.getErrorStream();
            InputStreamReader isr = new InputStreamReader(stderr);
            BufferedReader br = new BufferedReader(isr);
            String line = null;
            //System.out.println("<ERROR>");
            String len ="";
            while ((line = br.readLine()) != null)
            {
            	if(line.trim().startsWith("Duration")){
            		len = line.substring(12,line.indexOf(","));
            		len = len.indexOf(".")>0?len.substring(0,len.indexOf(".")):len;          		
            	}
            }
            //System.out.println("</ERROR>");
            proc.waitFor();
            //System.out.println("Process exitValue: " + exitVal);
            return len;
        }
        catch (Throwable t)
        {
            t.printStackTrace();
        }
        return "0";
    }

    // 视频转码，infile输入文件(包括完整路径)，outfile输出文件
    public static boolean transfer(String infile, String outfile)
    {
        String avitoflv = PropertyUtils.getProperty("traincore.ffmpeg")+ " -i " + infile
                + " -ar 22050 -ab 56 -f flv -y -s 320x240 " + outfile;
        try
        {
            Runtime rt = Runtime.getRuntime();
            Process proc = rt.exec(avitoflv);
            InputStream stderr = proc.getErrorStream();
            InputStreamReader isr = new InputStreamReader(stderr);
            BufferedReader br = new BufferedReader(isr);
            String line = null;
            System.out.println("<ERROR>");
            while ((line = br.readLine()) != null)
            {
                System.out.println(line);
            }
            System.out.println("</ERROR>");
            int exitVal = proc.waitFor();
            System.out.println("Process exitValue: " + exitVal);
        }
        catch (Throwable t)
        {
            t.printStackTrace();
            return false;
        }
        return true;
    }

    // 读取文件,fileName输入文件，id行数
    private static String readFile(String fileName, int id)
    {
        String dataStr = "";
        FileInputStream fis = null;
        try
        {
            FileReader file = new FileReader(fileName);// 建立FileReader对象，并实例化为fr
            BufferedReader br = new BufferedReader(file);// 建立BufferedReader对象，并实例化为br
            String Line = br.readLine();// 从文件读取一行字符串
            dataStr = Line;
            br.close();// 关闭BufferedReader对象
        }
        catch (Exception e)
        {
        }
        finally
        {
            try
            {
                if (fis != null)
                {
                    fis.close();
                }
            }
            catch (Exception e)
            {
            }
        }
        return dataStr;
    }

    // 读时长信息
    public static String readtime(String file)
    {
        String timelen = "";
        String cmd = "ffmpeg -i " + file;
        timelen = runLenCmd(file,cmd);
        return timelen;
    }
   
    /**
     * 递归处理目录
     * @param me
     * @param pathFile
     */
    public static void handlePath(File pathFile,String outFile){
    	
        //遍历目录的视频文件,支持flv，wmv，
        for(File tmpfile: pathFile.listFiles()){
            //时长
        	if(tmpfile.isDirectory()){
        		handlePath(tmpfile,outFile);
        	}else{
	            String timelen = readtime(tmpfile.getAbsolutePath());
	            String rpath = tmpfile.getAbsolutePath();
	            writeFile(outFile,rpath+","+timelen);
	            System.out.println(rpath+" timelen is :" + timelen);
            }
        }
        return ;
    }

    private static void writeFile(String outFile,String linemsg){
    	FileWriter bufferedOutput = null;

        try{
            bufferedOutput = new FileWriter (outFile,true);
            bufferedOutput.write(linemsg);
            bufferedOutput.write("\n");
        }catch (Exception e) {
            // TODO: handle exception
        }finally{
            try{
            	bufferedOutput.close();
            }catch (Exception e) {
                // TODO: handle exception
            }
        }
    	
    }
    public static void main(String args[])
    {
        String filepath = "d:\\work\\devtool" +
        		"\\1.flv";// "/opt/cgogo/test/02.avi";
         //String outfile = args[1];// "/opt/cgogo/test/info.txt";
        //String outfile = args[1];
        File file = new File(filepath);
/*        if(!file.exists()){
        	System.out.println("目录不存在");
        	return;
        }
        if(!file.isDirectory()){
        	System.out.println("不是一个目录");
        	return;
        }*/
        FfmpegUtil.readtime(filepath);
    }
}