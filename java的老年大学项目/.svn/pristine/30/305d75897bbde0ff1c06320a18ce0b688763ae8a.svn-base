package com.drcl.traincore.vo;

import java.util.List;

import com.google.common.collect.Lists;

/**
 * tree的节点vo用于转换为json在页面被treeview js调用
 * @author zhaowei
 *
 */
public class TreeNodeVO {
	private String id=""; //ID只能包含英文数字下划线中划线
	private String text = "";
	private String value = "1";
	@SuppressWarnings("unused")
	private boolean showcheck;
	private int checkstate = 0;         //0,1,2 选中状态
	private boolean hasChildren = true;//是否有子节点
	private String code; // 栏目编码　

	private boolean isexpand = false;//是否展开
	private boolean complete = false;// 是否已加载子节点
	private List<TreeNodeVO> childNodes = Lists.newArrayList();// child nodes
	
	public TreeNodeVO(){}
	public TreeNodeVO(String id,String text,String value,boolean showcheck, int checkstate,
			boolean hasChildren,boolean isexpand,boolean complete,String code){
		this.id = id;
		this.text = text;
		this.value = value;
		this.checkstate = checkstate;
		this.showcheck= showcheck;
		this.complete = complete;
		this.hasChildren = hasChildren;
		this.isexpand = isexpand;
		this.code = code;
	}
	public TreeNodeVO(String id,String text,String value,boolean showcheck, int checkstate,
			boolean hasChildren,boolean isexpand,boolean complete){
		this.id = id;
		this.text = text;
		this.value = value;
		this.checkstate = checkstate;
		this.showcheck= showcheck;
		this.complete = complete;
		this.hasChildren = hasChildren;
		this.isexpand = isexpand;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public boolean isShowcheck() {
		if(this.checkstate==1)
			return true;
		else{
			for(TreeNodeVO c : this.childNodes){
				if(c.getCheckstate()==1)
					return true;
			}
		}
		return false;
	}
	public void setShowcheck(boolean showcheck) {
		this.showcheck = showcheck;
	}
	public int getCheckstate() {
		return checkstate;
	}
	public void setCheckstate(int checkstate) {
		this.checkstate = checkstate;
	}
	public boolean isHasChildren() {
		return hasChildren;
	}
	public void setHasChildren(boolean hasChildren) {
		this.hasChildren = hasChildren;
	}
	
	public boolean isIsexpand() {
		return isexpand;
	}
	
	public void setIsexpand(boolean isexpand) {
		this.isexpand = isexpand;
	}
	public boolean isComplete() {
		return complete;
	}
	public void setComplete(boolean complete) {
		this.complete = complete;
	}
	public List<TreeNodeVO> getChildNodes() {
		return childNodes;
	}
	public void setChildNodes(List<TreeNodeVO> childNodes) {
		this.childNodes = childNodes;
	}
	
	public boolean isCheck() {
		if(this.checkstate==1)
			return true;
		else{
			for(TreeNodeVO c : this.childNodes){
				if(c.getCheckstate()==1)
					return true;
			}
		}
		return false;
		//return isexpand;
	}
}
