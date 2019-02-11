package com.drcl.traincore.vo;

/**
 * 简单课程vo
 * @author ycguo
 *
 */
public class SimpleCourseVO {
	private Long id;//课程id
	private String name;//课程名称
	private String desc;//课程简述
	private String mainer;//主讲
	private String pic;//图片绝对url
	
	public SimpleCourseVO(){
		
	}
	
	public SimpleCourseVO(Long id, String name ,String desc, String mainer, String pic){
		this.id = id;
		this.desc = desc;
		this.name = name;
		this.pic = pic;
		this.mainer = mainer;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}

	public String getMainer() {
		return mainer;
	}

	public void setMainer(String mainer) {
		this.mainer = mainer;
	}
	
}
