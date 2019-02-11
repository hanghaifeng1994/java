package com.drcl.traincore.vo;

import java.util.List;

public class BatchUserVO {
	
	private Long userId;				//用户id
	private String userName;			//用户姓名
	private String uccId;				//uccid
	private String userExamCode; 		//考生编号
	private Long examtimeId; 			//考次id
	private String score;				//综合分数
	private String speechScore;			//演讲分数
	private String qaScore;				//问答分数
	private List<ScoreListVO>scoreLists;//分数列表
	public BatchUserVO(Long id, String name, String examScore, String userExamCode, List<ScoreListVO> list,String speechScore,String qaScore,Long examtimeId, String uccId) {
		this.userId=id;
		this.userName=name;
		this.userExamCode=userExamCode;
		this.score=examScore;
		this.scoreLists=list;
		this.speechScore=speechScore;
		this.qaScore=qaScore;
		this.examtimeId=examtimeId;
		this.uccId=uccId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserExamCode() {
		return userExamCode;
	}
	public void setUserExamCode(String userExamCode) {
		this.userExamCode = userExamCode;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	public List<ScoreListVO> getScoreLists() {
		return scoreLists;
	}
	public void setScoreLists(List<ScoreListVO> scoreLists) {
		this.scoreLists = scoreLists;
	}
	public String getSpeechScore() {
		return speechScore;
	}
	public void setSpeechScore(String speechScore) {
		this.speechScore = speechScore;
	}
	public String getQaScore() {
		return qaScore;
	}
	public void setQaScore(String qaScore) {
		this.qaScore = qaScore;
	}
	public Long getExamtimeId() {
		return examtimeId;
	}
	public void setExamtimeId(Long examtimeId) {
		this.examtimeId = examtimeId;
	}
	public String getUccId() {
		return uccId;
	}
	public void setUccId(String uccId) {
		this.uccId = uccId;
	}
}
