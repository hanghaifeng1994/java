package com.drcl.traincore.vo;

import org.compass.annotations.Index;
import org.compass.annotations.Searchable;
import org.compass.annotations.SearchableId;
import org.compass.annotations.SearchableProperty;
import org.compass.annotations.Store;

import cn.common.lib.util.web.PropertyUtils;

@Searchable(alias = "search")
public class GsearchVO {

	public static final String Course = "course";
	public static final String Article = "article";
	public static final String Project = "project";
	public static final String Phase = "phase";

	private String id;

	private String type;

	private String searchId;

	private String title;

	private String content;

	public String getUrl() {
		if (type.equals(Course))
			return PropertyUtils.getProperty("traincore.webapp.url", "") + PropertyUtils.getProperty("serach.course.url", "") + this.id;
		if (type.equals(Article))
			return PropertyUtils.getProperty("traincore.webapp.url", "") + PropertyUtils.getProperty("serach.article.url", "") + this.id;
		if (type.equals(Project))
			return PropertyUtils.getProperty("traincore.webapp.url", "") + PropertyUtils.getProperty("serach.project.url", "") + this.id;
		if (type.equals(Phase))
			return PropertyUtils.getProperty("traincore.webapp.url", "") + PropertyUtils.getProperty("serach.phase.url", "") + this.id;
		
		return null;
	}

	@SearchableProperty(index = Index.UN_TOKENIZED, store = Store.YES)
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@SearchableProperty(index = Index.TOKENIZED, store = Store.YES, converter = "htmlPropertyConverter")
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		if(content==null)
			this.content=  "";
		this.content = content;
	}

	@SearchableProperty(index = Index.TOKENIZED, store = Store.YES)
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@SearchableId
	public String getSearchId() {
		return searchId;
	}

	public void setSearchId(String searchId) {
		this.searchId = searchId;
	}

	@SearchableProperty(index = Index.UN_TOKENIZED, store = Store.YES)
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
