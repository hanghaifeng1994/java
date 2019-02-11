package com.drcl.traincore.util;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;

/**
 * 二维码攻击
 * @author jingma
 *
 */
public class QrUtils {
	
	/**
	 * 返回生成图片的相对目录
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static String genCodeImage(String imagePath,String relativePath,String content, String filename,int w, int h){
	    //String filename = FileUtils.generateFileName("", ".jpg");
		try {
		     MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
		     Map hints = new HashMap();
		     hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
		     hints.put(EncodeHintType.MARGIN, 0);
		     BitMatrix bitMatrix = multiFormatWriter.encode(content, BarcodeFormat.QR_CODE, w, h,hints);
		     int margin = 0;
		     File filedir = new File(imagePath+relativePath);
		     if(!filedir.exists()){
		    	 filedir.mkdirs();
		     }
		     File file1 = new File(imagePath+relativePath,filename);
		     if(!file1.exists()){
		    	 file1.createNewFile();
		     }
		     bitMatrix = updateBit(bitMatrix, margin); 
		     
		     MatrixToImageWriter.writeToFile(bitMatrix, "jpg", file1);
		     
		} catch (Exception e) {
		     e.printStackTrace();
		}
		return relativePath+File.separator+filename;
	}
	
	private static BitMatrix updateBit(BitMatrix matrix, int margin){
        int tempM = margin*2;
       int[] rec = matrix.getEnclosingRectangle();   //获取二维码图案的属性
            int resWidth = rec[2] + tempM;
            int resHeight = rec[3] + tempM;
            BitMatrix resMatrix = new BitMatrix(resWidth, resHeight); // 按照自定义边框生成新的BitMatrix
            resMatrix.clear();
        for(int i= margin; i < resWidth- margin; i++){   //循环，将二维码图案绘制到新的bitMatrix中
            for(int j=margin; j < resHeight-margin; j++){
                if(matrix.get(i-margin + rec[0], j-margin + rec[1])){
                    resMatrix.set(i,j);
                }
            }
        }
         return resMatrix;
    }
	
	
	public static void main(String[] args) {
		//QrUtils.genCodeImage("D:\\work\\fileserver\\apache-tomcat-6.0.29\\webapps\\fileserver", "", "http://learn.wxjy.com.cn/lms/task/teach/view/list?courseId=1185865&teacherId=1179706", "20151225.jpg", 120, 120);
		QrUtils.genCodeImage("e:\\cert", "", "http://www.zjzx.ah.cn:81/user/portal!printcert.excsec?certid=944674&programid=237259", "20151225erweima.jpg", 111, 111);

	
	}
}
