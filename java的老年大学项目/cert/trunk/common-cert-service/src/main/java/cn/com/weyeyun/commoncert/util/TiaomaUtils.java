package cn.com.weyeyun.commoncert.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

import org.krysalis.barcode4j.impl.code39.Code39Bean;
import org.krysalis.barcode4j.output.bitmap.BitmapCanvasProvider;
import org.krysalis.barcode4j.tools.UnitConv;

/**
 * 条码工具
 * @author jingma
 *
 */
public class TiaomaUtils {
	
	/**
	 * 返回生成图片的相对目录
	 * @return
	 */
	public static String genCodeImage(String imagePathFullPath,String content){
		try {
            //Create the barcode bean
            Code39Bean bean = new Code39Bean();
             
            final int dpi = 130;
             
            //Configure the barcode generator
            bean.setModuleWidth(UnitConv.in2mm(1.2f / dpi)); //makes the narrow bar 
                                                             //width exactly one pixel
            bean.setWideFactor(1.5d);
            bean.doQuietZone(false);
            bean.setBarHeight(6);
            //Open output file
            File outputFile = new File(imagePathFullPath);
            OutputStream out = new FileOutputStream(outputFile);
            try {
                //Set up the canvas provider for monochrome JPEG output 
                BitmapCanvasProvider canvas = new BitmapCanvasProvider(
                        out, "image/jpeg", dpi, BufferedImage.TYPE_BYTE_BINARY, false, 0);
             
                //Generate the barcode
                bean.generateBarcode(canvas, content);
             
                //Signal end of generation
                canvas.finish();
            } finally {
                out.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
		return imagePathFullPath;
	}
	
}
