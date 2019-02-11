package com.drcl.traincore.util;

public class HtmlStringUtil {
	public static String removeHTML(String str, boolean addSpace) {  
        
        //System.out.println(str);   
          
        if(str == null) return "";  
        StringBuffer ret = new StringBuffer(str.length());  
        int start = 0;  
        int beginTag = str.indexOf("<");  
        int endTag = 0;  
        if(beginTag == -1) return str;  
          
        while(beginTag >= start) {  
            if(beginTag > 0) {  
                ret.append(str.substring(start, beginTag));  
                  
                // replace each tag with a space (looks better)   
                if(addSpace) ret.append(" ");  
            }  
            endTag = str.indexOf(">", beginTag);  
              
            // if endTag found move "cursor" forward   
            if(endTag > -1) {  
                start = endTag + 1;  
                beginTag = str.indexOf("<", start);  
            }  
              
            // if no endTag found, get rest of str and break   
            else {  
                ret.append(str.substring(beginTag));  
                break;  
            }  
        }  
        // append everything after the last endTag   
        if(endTag >-1 && endTag + 1 < str.length()) {  
            ret.append(str.substring(endTag + 1));  
        }  
          
        //System.out.println(ret.toString());   
          
        return ret.toString().trim();  
    }  
      
    /** 
     * Remove occurences of html, defined as any text 
     * between the characters "<" and ">". 
     * Replace any HTML tags with a space.  
     * @param str 
     * @return 
     */  
    public static String removeHTML(String str) {  
        return removeHTML(str, true);  
    }  
}
