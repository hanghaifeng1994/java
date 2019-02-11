package com.learnyeai.tools.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class FileUtil {

	private static Logger log = LoggerFactory.getLogger(FileUtil.class);

	private static final SimpleDateFormat dateFmt = new SimpleDateFormat("yyyyMMddHHmmss");

	/**
	 * 复制单个文件，如果目标文件存在，则不覆盖
	 * @param srcFileName 待复制的文件名
	 * @param descFileName 目标文件名
	 * @return 如果复制成功，则返回true，否则返回false
	 */
	public static boolean copyFile(String srcFileName, String descFileName) {
		return FileUtil.copyFileCover(srcFileName, descFileName, false);
	}

	public static boolean isFileExists(String dicname,String filename){
		File srcFile = new File(dicname+filename);
		if(srcFile.exists()){
			return true;
		}else {
			return false;
		}
	}

	/**
	 * 复制单个文件
	 * @param srcFileName 待复制的文件名
	 * @param descFileName 目标文件名
	 * @param coverlay 如果目标文件已存在，是否覆盖
	 * @return 如果复制成功，则返回true，否则返回false
	 */
	public static boolean copyFileCover(String srcFileName,
										String descFileName, boolean coverlay) {
		File srcFile = new File(srcFileName);
		// 判断源文件是否存在
		if (!srcFile.exists()) {
			log.debug("复制文件失败，源文件 " + srcFileName + " 不存在!");
			return false;
		}
		// 判断源文件是否是合法的文件
		else if (!srcFile.isFile()) {
			log.debug("复制文件失败，" + srcFileName + " 不是一个文件!");
			return false;
		}
		File descFile = new File(descFileName);
		// 判断目标文件是否存在
		if (descFile.exists()) {
			// 如果目标文件存在，并且允许覆盖
			if (coverlay) {
				log.debug("目标文件已存在，准备删除!");
				if (!FileUtil.delFile(descFileName)) {
					log.debug("删除目标文件 " + descFileName + " 失败!");
					return false;
				}
			} else {
				log.debug("复制文件失败，目标文件 " + descFileName + " 已存在!");
				return false;
			}
		} else {
			if (!descFile.getParentFile().exists()) {
				// 如果目标文件所在的目录不存在，则创建目录
				log.debug("目标文件所在的目录不存在，创建目录!");
				// 创建目标文件所在的目录
				if (!descFile.getParentFile().mkdirs()) {
					log.debug("创建目标文件所在的目录失败!");
					return false;
				}
			}
		}

		// 准备复制文件
		// 读取的位数
		int readByte = 0;
		InputStream ins = null;
		OutputStream outs = null;
		try {
			// 打开源文件
			ins = new FileInputStream(srcFile);
			// 打开目标文件的输出流
			outs = new FileOutputStream(descFile);
			byte[] buf = new byte[1024];
			// 一次读取1024个字节，当readByte为-1时表示文件已经读取完毕
			while ((readByte = ins.read(buf)) != -1) {
				// 将读取的字节流写入到输出流
				outs.write(buf, 0, readByte);
			}
			log.debug("复制单个文件 " + srcFileName + " 到" + descFileName
					+ "成功!");
			return true;
		} catch (Exception e) {
			log.debug("复制文件失败：" + e.getMessage());
			return false;
		} finally {
			// 关闭输入输出流，首先关闭输出流，然后再关闭输入流
			if (outs != null) {
				try {
					outs.close();
				} catch (IOException oute) {
					oute.printStackTrace();
				}
			}
			if (ins != null) {
				try {
					ins.close();
				} catch (IOException ine) {
					ine.printStackTrace();
				}
			}
		}
	}

	/**
	 * 复制整个目录的内容，如果目标目录存在，则不覆盖
	 * @param srcDirName 源目录名
	 * @param descDirName 目标目录名
	 * @return 如果复制成功返回true，否则返回false
	 */
	public static boolean copyDirectory(String srcDirName, String descDirName) {
		return FileUtil.copyDirectoryCover(srcDirName, descDirName,
				false);
	}

	/**
	 * 复制整个目录的内容
	 * @param srcDirName 源目录名
	 * @param descDirName 目标目录名
	 * @param coverlay 如果目标目录存在，是否覆盖
	 * @return 如果复制成功返回true，否则返回false
	 */
	public static boolean copyDirectoryCover(String srcDirName,
											 String descDirName, boolean coverlay) {
		File srcDir = new File(srcDirName);
		// 判断源目录是否存在
		if (!srcDir.exists()) {
			log.debug("复制目录失败，源目录 " + srcDirName + " 不存在!");
			return false;
		}
		// 判断源目录是否是目录
		else if (!srcDir.isDirectory()) {
			log.debug("复制目录失败，" + srcDirName + " 不是一个目录!");
			return false;
		}
		// 如果目标文件夹名不以文件分隔符结尾，自动添加文件分隔符
		String descDirNames = descDirName;
		if (!descDirNames.endsWith(File.separator)) {
			descDirNames = descDirNames + File.separator;
		}
		File descDir = new File(descDirNames);
		// 如果目标文件夹存在
		if (descDir.exists()) {
			if (coverlay) {
				// 允许覆盖目标目录
				log.debug("目标目录已存在，准备删除!");
				if (!FileUtil.delFile(descDirNames)) {
					log.debug("删除目录 " + descDirNames + " 失败!");
					return false;
				}
			} else {
				log.debug("目标目录复制失败，目标目录 " + descDirNames + " 已存在!");
				return false;
			}
		} else {
			// 创建目标目录
			log.debug("目标目录不存在，准备创建!");
			if (!descDir.mkdirs()) {
				log.debug("创建目标目录失败!");
				return false;
			}

		}

		boolean flag = true;
		// 列出源目录下的所有文件名和子目录名
		File[] files = srcDir.listFiles();
		for (int i = 0; i < files.length; i++) {
			// 如果是一个单个文件，则直接复制
			if (files[i].isFile()) {
				flag = FileUtil.copyFile(files[i].getAbsolutePath(),
						descDirName + files[i].getName());
				// 如果拷贝文件失败，则退出循环
				if (!flag) {
					break;
				}
			}
			// 如果是子目录，则继续复制目录
			if (files[i].isDirectory()) {
				flag = FileUtil.copyDirectory(files[i]
						.getAbsolutePath(), descDirName + files[i].getName());
				// 如果拷贝目录失败，则退出循环
				if (!flag) {
					break;
				}
			}
		}

		if (!flag) {
			log.debug("复制目录 " + srcDirName + " 到 " + descDirName + " 失败!");
			return false;
		}
		log.debug("复制目录 " + srcDirName + " 到 " + descDirName + " 成功!");
		return true;

	}

	/**
	 *
	 * 删除文件，可以删除单个文件或文件夹
	 *
	 * @param fileName 被删除的文件名
	 * @return 如果删除成功，则返回true，否是返回false
	 */
	public static boolean delFile(String fileName) {
		File file = new File(fileName);
		if (!file.exists()) {
			log.debug(fileName + " 文件不存在!");
			return true;
		} else {
			if (file.isFile()) {
				return FileUtil.deleteFile(fileName);
			} else {
				return FileUtil.deleteDirectory(fileName);
			}
		}
	}

	/**
	 *
	 * 删除单个文件
	 *
	 * @param fileName 被删除的文件名
	 * @return 如果删除成功，则返回true，否则返回false
	 */
	public static boolean deleteFile(String fileName) {
		File file = new File(fileName);
		if (file.exists() && file.isFile()) {
			if (file.delete()) {
				log.debug("删除单个文件 " + fileName + " 成功!");
				return true;
			} else {
				log.debug("删除单个文件 " + fileName + " 失败!");
				return false;
			}
		} else {
			log.debug(fileName + " 文件不存在!");
			return true;
		}
	}

	/**
	 *
	 * 删除目录及目录下的文件
	 *
	 * @param dirName 被删除的目录所在的文件路径
	 * @return 如果目录删除成功，则返回true，否则返回false
	 */
	public static boolean deleteDirectory(String dirName) {
		String dirNames = dirName;
		if (!dirNames.endsWith(File.separator)) {
			dirNames = dirNames + File.separator;
		}
		File dirFile = new File(dirNames);
		if (!dirFile.exists() || !dirFile.isDirectory()) {
			log.debug(dirNames + " 目录不存在!");
			return true;
		}
		boolean flag = true;
		// 列出全部文件及子目录
		File[] files = dirFile.listFiles();
		for (int i = 0; i < files.length; i++) {
			// 删除子文件
			if (files[i].isFile()) {
				flag = FileUtil.deleteFile(files[i].getAbsolutePath());
				// 如果删除文件失败，则退出循环
				if (!flag) {
					break;
				}
			}
			// 删除子目录
			else if (files[i].isDirectory()) {
				flag = FileUtil.deleteDirectory(files[i]
						.getAbsolutePath());
				// 如果删除子目录失败，则退出循环
				if (!flag) {
					break;
				}
			}
		}

		if (!flag) {
			log.debug("删除目录失败!");
			return false;
		}
		// 删除当前目录
		if (dirFile.delete()) {
			log.debug("删除目录 " + dirName + " 成功!");
			return true;
		} else {
			log.debug("删除目录 " + dirName + " 失败!");
			return false;
		}

	}

	/**
	 * 创建单个文件
	 * @param descFileName 文件名，包含路径
	 * @return 如果创建成功，则返回true，否则返回false
	 */
	public static boolean createFile(String descFileName) {
		File file = new File(descFileName);
		if (file.exists()) {
			log.debug("文件 " + descFileName + " 已存在!");
			return false;
		}
		if (descFileName.endsWith(File.separator)) {
			log.debug(descFileName + " 为目录，不能创建目录!");
			return false;
		}
		if (!file.getParentFile().exists()) {
			// 如果文件所在的目录不存在，则创建目录
			if (!file.getParentFile().mkdirs()) {
				log.debug("创建文件所在的目录失败!");
				return false;
			}
		}

		// 创建文件
		try {
			if (file.createNewFile()) {
				log.debug(descFileName + " 文件创建成功!");
				return true;
			} else {
				log.debug(descFileName + " 文件创建失败!");
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.debug(descFileName + " 文件创建失败!");
			return false;
		}

	}

	/**
	 * 创建目录
	 * @param descDirName 目录名,包含路径
	 * @return 如果创建成功，则返回true，否则返回false
	 */
	public static boolean createDirectory(String descDirName) {
		String descDirNames = descDirName;
		if (!descDirNames.endsWith(File.separator)) {
			descDirNames = descDirNames + File.separator;
		}
		File descDir = new File(descDirNames);
		if (descDir.exists()) {
			log.debug("目录 " + descDirNames + " 已存在!");
			return true;
		}
		// 创建目录
		if (descDir.mkdirs()) {
			log.debug("目录 " + descDirNames + " 创建成功!");
			return true;
		} else {
			log.debug("目录 " + descDirNames + " 创建失败!");
			return false;
		}

	}
	public static boolean mkDir(String filePath){
		try{
			File file = new File(filePath);
			if(!file.exists())
				file.mkdirs();
			return true;
		}catch (Exception e){
			return false;
		}
	}
	/**
	 *分离完整文件名的文件名和后缀,并在中间加入字符串后返回
	 * @param fullName 文件名
	 * @param newName 文件id
	 * @return 重命名后文件名，后缀名不变
	 */
	public static String replaceName(String fullName, String newName){
		String ext = ""; // 后缀
		char point = '.';
		int index = fullName.lastIndexOf(point);
		if (index > 0) {// 如果有后缀
			ext = fullName.substring(index);
		}
		StringBuffer bf = new StringBuffer(newName);
		bf.append(ext);
		return bf.toString();
	}

	/**
	 * 根据老文件生成一个新的文件名
	 * @param dir
	 * @param fileName
     * @return
     */
	public static String genFileNameFromOld(String dir, String fileName){
		String type = "";
		String name = null;
		int index = fileName.indexOf(".");
		if (index > 0) {
			type = fileName.substring(index+1);
			name = fileName.substring(0, index);
		}else
			name = fileName;

		String newFileName = null;
		String nameExt = null;
		int newFileNameIndex = 0;
		File f = null;
		do {
			if(newFileNameIndex == 0){
				nameExt = "";
			}else {
				nameExt = String.format("(%d)",newFileNameIndex);
			}
			newFileNameIndex++;

			if(null == type || type.length() == 0)
				newFileName = String.format("%s%s", name, nameExt);
			else
				newFileName = String.format("%s%s.%s",name, nameExt, type);
			f = new File(dir, newFileName);
		} while(f.exists());
		return f.getName();
	}
	/**
	 * 在指定目录中，生成文件名：时间 + 随机数，后缀名不变
	 * @param dir
	 * @param fileName
	 * @return
	 */
	public static String genDateFileName(String dir, String fileName) {

		return getDateNameFile(dir, fileName).getName();
	}
	public static File getDateNameFile(String dir, String fileName) {
		String newFileName = null;
		String type = getFileSuffix(fileName);
		Random r = new Random();
		File f = null;
		do {
			if(null == type || type.length() == 0)
				newFileName = dateFmt.format(new Date()) + r.nextInt(10);
			else
				newFileName = String.format("%s.%s",dateFmt.format(new Date()) + r.nextInt(10), type);
			f = new File(dir, newFileName);
		} while(f.exists());
		return f;
	}

	/**
	 * 解析文件的扩展名
	 * 
	 * @param oldName
	 * @return
	 */
	public static String getFileSuffix(String oldName) {
		if(null == oldName)
			return "";
		String ext = "";
		int lastIndex = oldName.lastIndexOf(".");
		if (lastIndex > 0) {
			ext = oldName.substring(lastIndex+1);
		}
		return ext;
	}

	public static String readFileAsString(String fileName) {
		String content = "";
		try {
			content = new String(readFileBinary(fileName), "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return content;
	}

	/**
	 * 
	 * 读取文件并返回为给定字符集的字符串.
	 * 
	 * @param fileName
	 * @param encoding
	 * @return
	 * @throws Exception
	 */
	public static String readFileAsString(String fileName, String encoding)
			throws Exception {
		return new String(readFileBinary(fileName), encoding);
	}

	/**
	 * 
	 * 读取文件并返回为给定字符集的字符串.
	 * 
	 * @param in
	 * @return
	 * @throws Exception
	 */
	public static String readFileAsString(InputStream in) throws Exception {
		byte[] data = readFileBinary(in);
		if(null == data)
			return null;
		return new String(data, "utf-8");
	}

	/**
	 * Read content from local file to binary byte array.
	 * 
	 * @param fileName
	 *            local file name to read
	 * @return
	 * @throws Exception
	 */
	public static byte[] readFileBinary(String fileName) {
		byte[] rst = null;
		try {
			FileInputStream fin = new FileInputStream(fileName);
			rst = readFileBinary(fin);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return rst;

	}

	/**
	 * 
	 * 从输入流读取数据为二进制字节数组.
	 * 
	 * @param streamIn
	 * @return
	 * @throws IOException
	 */
	public static byte[] readFileBinary(InputStream streamIn) {
		BufferedInputStream in = null;
		ByteArrayOutputStream out = null;
		try {
			in = new BufferedInputStream(streamIn);
			out = new ByteArrayOutputStream(10240);
			int len;
			byte buf[] = new byte[1024];
			while ((len = in.read(buf)) >= 0)
				out.write(buf, 0, len);
			return out.toByteArray();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}

	public static boolean writeFileString(String fileName, String content) {
		FileWriter fout = null;
		try {
			fout = new FileWriter(fileName);
			fout.write(content);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fout != null) {
				try {
					fout.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return true;

	}

	public static boolean writeFileString(String fileName, String content,
			String encoding) {
		OutputStreamWriter fout = null;
		try {
			fout = new OutputStreamWriter(new FileOutputStream(fileName),
					encoding);
			fout.write(content);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fout != null) {
				try {
					fout.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return true;
	}

	public static boolean writeFileBinary(String fileName, byte[] content) {
		FileOutputStream fout = null;
		try {
			fout = new FileOutputStream(fileName);
			fout.write(content);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fout != null) {
				try {
					fout.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return true;
	}
	public static int writeFileStream(String filePath, InputStream in){
		File file = null;
		try{
			file = new File(filePath);
			if (!file.getParentFile().exists()) {
				file.getParentFile().mkdirs();
			}

		}catch (Exception e){
			e.printStackTrace();
		}

		return writeFileStream(file, in);

	}
	public static int writeFileStream(File file, InputStream in){
		if(in == null)
			return -1;

		OutputStream out = null;
		BufferedInputStream bin = new BufferedInputStream(in);

		try{
			out = new FileOutputStream(file);
			return StreamUtils.copy(bin, out);
			/*int size = 0;
			int len = 0;
			byte[] buf = new byte[1024];
			while ((size = bin.read(buf)) != -1) {
				len += size;
				out.write(buf, 0, size);
			}

			bin.close();
			out.close();
			return len;
			*/
		}catch (Exception e){
			e.printStackTrace();
			return -1;
		}finally {
			try {
				bin.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 
	 * 检查文件名是否合法.文件名字不能包含字符\/:*?"<>|
	 * 
	 * 
	 * 
	 * @param fileName 文件名
	 *            ,不包含路径
	 * 
	 * @return boolean is valid file name
	 */

	public static boolean isValidFileName(String fileName) {
		boolean isValid = true;
		String errChar = "\\/:*?\"<>|"; //
		if (fileName == null || fileName.length() == 0) {
			isValid = false;
		} else {
			for (int i = 0; i < errChar.length(); i++) {
				if (fileName.indexOf(errChar.charAt(i)) != -1) {
					isValid = false;
					break;
				}
			}
		}
		return isValid;

	}

	/**
	 * 
	 * 把非法文件名转换为合法文件名.
	 * 
	 * 
	 * 
	 * @param fileName
	 * 
	 * @return
	 */

	public static String replaceInvalidFileChars(String fileName) {
		StringBuffer out = new StringBuffer();
		for (int i = 0; i < fileName.length(); i++) {
			char ch = fileName.charAt(i);
			// Replace invlid chars: \\/:*?\"<>|
			switch (ch) {
			case '\\':
			case '/':
			case ':':
			case '*':
			case '?':
			case '\"':
			case '<':
			case '>':
			case '|':
				out.append('_');
				break;
			default:
				out.append(ch);
			}
		}
		return out.toString();
	}

	public static String filePathToURL(String fileName) {
		return new File(fileName).toURI().toString();
	}

	public static boolean appendFileString(String fileName, String content) {
		OutputStreamWriter fout = null;
		try {
			fout = new OutputStreamWriter(new FileOutputStream(fileName, true),
					"GBK");
			fout.write(content);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fout != null) {
				try {
					fout.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return true;

	}
	
	/** 
	 * 通过类路径来取工程路径 
	 *  
	 * @return 
	 * @throws Exception 
	 */  
	public static String getAbsolutePathByClass(){  
	    String webPath = FileUtil.class.getResource("/").getPath().replaceAll("^\\/", "");  
	    webPath = webPath.replaceAll("[\\\\\\/]WEB-INF[\\\\\\/]classes[\\\\\\/]?", "/");  
	    webPath = webPath.replaceAll("[\\\\\\/]+", "/");  
	    webPath = webPath.replaceAll("%20", " ");  
	  
	    if (webPath.matches("^[a-zA-Z]:.*?$")) {  
	  
	    } else {  
	        webPath = "/" + webPath;  
	    }  
	  
	    webPath += "/";  
	    webPath = webPath.replaceAll("[\\\\\\/]+", "/");  
	  
	    return webPath;  
	} 


	public static void main(String[] args) {
		System.out.println(replaceInvalidFileChars("http://www.abc.com/"));
	}

}