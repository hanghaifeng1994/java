package com.drcl.traincore.vo;
/**
* 
* label value class
*
* @author            houbing.qian
* @version           1.0
* @since             2010-8-19
*/
public class ResVO
{
	
 private boolean success;
 private String label;

 public ResVO(){}
 
 public ResVO(boolean success,String label){
     this.success = success;
     this.label = label;
 }

 public boolean isSuccess() {
	return success;
}

public void setSuccess(boolean success) {
	this.success = success;
}

public String getLabel() {
     return label;
 }
 public void setLabel(String label) {
     this.label = label;
 }
}
