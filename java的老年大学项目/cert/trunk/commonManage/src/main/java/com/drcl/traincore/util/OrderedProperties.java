package com.drcl.traincore.util;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;  
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;  
import java.util.HashMap;  
import java.util.List;  
import java.util.Map;  
import java.util.regex.Pattern; 

public class OrderedProperties {  
	
    /** Keys*/  
    private List<String> keys = new ArrayList<String>();  
  
    /** ValueMap*/  
    private Map<String, String> valueMap = new HashMap<String, String>();  
  
    private String filePath;
    public Map<String, String> getValueMap() {
		return valueMap;
	}

	public void setValueMap(Map<String, String> valueMap) {
		this.valueMap = valueMap;
	}

	public String getProperty(String key) {  
        return valueMap.get(key);  
    }  
  
    public List<String> getKeys(String keyPattern) {  
        Pattern pat = Pattern.compile(keyPattern);  
        List<String> kl = new ArrayList<String>();  
        for (String k : keys) {  
            if (pat.matcher(k).matches()) {  
                kl.add(k);  
            }  
        }  
        return kl;  
    }  
  
    /** 
     * 加载Properties文件 
     * @param istream 
     * @throws Exception 
     */  
    public synchronized void load(String filePath) throws Exception {  
    	this.filePath= filePath;
    	File file = new File(filePath);
        List<String> lines = this.toLines(new FileInputStream(file));  
          
        // parse key-value  
        for (String l : lines) {  
            if (l.trim().startsWith("#")) {  
                keys.add(l);  
            } else {  
                if (l.indexOf("=") > -1) {  
                    String k = l.substring(0, l.indexOf("=")).trim();  
                    String v = l.substring(l.indexOf("=") + 1).trim();  
                    keys.add(k);  
                    valueMap.put(k, v);  
                } else {  
                    keys.add(l);  
                }  
            }  
        }  
    }  
  
    public List<String> getKeys() {  
        return keys;  
    }  
  
    @Override  
    public String toString() {  
        return valueMap.toString();  
    }  
  
    public  List<String> toLines(InputStream input, String encoding) throws Exception {  
			InputStreamReader insreader = new InputStreamReader(input, encoding);  
			BufferedReader bin = new BufferedReader(insreader);  
			
			//data.load(input);

			List<String> lines = new ArrayList<String>();  
			String line;  
			while ((line = bin.readLine()) != null) {  
			    lines.add(line);  
			}  
			bin.close();  
			insreader.close();  
			return lines;  
}  

	/** 
	* 以GBK格式将输入流按行置入一个List<String> 
	*  
	* @param input 
	* @return 
	* @throws Exception 
	*/  
	public  List<String> toLines(InputStream input) throws Exception {  
		return toLines(input, "utf-8");  
	}
    
	public void setProperty(String key,String value) {
		valueMap.put(key, value);
	}
	
	public void store() {
		File file = new File(filePath);
		FileOutputStream fos = null;
		OutputStreamWriter osw = null;
		BufferedWriter  bw = null;
		String value = null;
		try {
			fos = new FileOutputStream(file);
			osw = new OutputStreamWriter(fos, "UTF-8");
			bw  = new BufferedWriter(osw);
	        for(String key:keys){
	            try {
	            	value = valueMap.get(key);
	            	
	            	//System.out.println(value==null?"":"="+value);
	            	//System.out.println(key + (value==null?"":"="+value) +"\n");
	            	//修改
					bw.write(key + (value==null?"":"="+value) +"\n");
				} catch (Exception e) {
					e.printStackTrace();
				}
	        }
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			 //注意关闭的先后顺序，先打开的后关闭，后打开的先关闭
	        try {
				bw.close();
				osw.close();
			    fos.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public Map<String,String> listPropertyFile(String platFormCode) {
		Map<String, String> fileMap = new HashMap<String, String>();
		try {
			this.load(OrderedProperties.class.getClassLoader().getResourceAsStream("platformConfig.properties"));
			String filePath = null;
			if("0".equals(platFormCode)) {
				filePath = this.getProperty("manage");
			}else if("1".equals(platFormCode)){
				filePath = this.getProperty("root");
			}else if("2".equals(platFormCode)){
				filePath = this.getProperty("userCenter");
			}else if("3".equals(platFormCode)){
				filePath = this.getProperty("studyPlat");
			}
			System.out.println("============================="+filePath);
			File file = new File(filePath);
	        File[] childFiles = file.listFiles();
	        System.out.println(filePath);
	        if(childFiles!=null){
	        	for(int i=0;i<childFiles.length;i++) {
	        		if(childFiles[i].isDirectory()) {
	        			System.out.println("dirctory is "+childFiles[i].getName());
	        			File file2 = new File(filePath+File.separator+childFiles[i].getName());
	        			File[] childFiles2 = file2.listFiles();
	        			for(int j = 0; j<childFiles2.length ; j++) {
	        				if(!childFiles2[j].isDirectory()) {
	        					if(childFiles2[j].getName().endsWith(".properties")) {
	        						fileMap.put(childFiles[i].getName()+File.separator+childFiles2[j].getName(), childFiles2[j].getAbsolutePath());
	        					}	
	        				}
	        			}
	        		} else {
	        			if(childFiles[i].getName().endsWith(".properties")) {
	        				fileMap.put(childFiles[i].getName(), childFiles[i].getAbsolutePath());
	        			}	
	        			System.out.println("file is "+childFiles[i].getName());
	        		}
	        	}
	        }
	        for(String key : fileMap.keySet()) {
	        	System.out.println("key= "+ key + " and value= " + fileMap.get(key));
	        }
		} catch (Exception e) {
			e.printStackTrace();
		}
		return fileMap;
	}

	private void load(InputStream resourceAsStream) throws Exception {
        List<String> lines = this.toLines(resourceAsStream);  
          
        // parse key-value  
        for (String l : lines) {  
            if (l.trim().startsWith("#")) {  
                keys.add(l);  
            } else {  
                if (l.indexOf("=") > -1) {  
                    String k = l.substring(0, l.indexOf("=")).trim();  
                    String v = l.substring(l.indexOf("=") + 1).trim();  
                    keys.add(k);  
                    valueMap.put(k, v);  
                } else {  
                    keys.add(l);  
                }  
            }  
        }  		
	}

	
	public static void main(String[] args) {
		OrderedProperties op = new OrderedProperties();
		//op.listPropertyFile("0");
		try {
			op.load("D:\\work\\project\\traincore\\trunk\\manage-webapp\\src\\main\\resources\\lmsapi\\mail.properties");
	        for(String key : op.getValueMap().keySet()) {
	        	System.out.println("key= "+ key + " and value= " + op.getValueMap().get(key));
	        }
	        op.store();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}