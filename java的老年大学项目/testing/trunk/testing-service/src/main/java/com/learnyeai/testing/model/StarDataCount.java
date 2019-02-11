package com.learnyeai.testing.model;

import java.math.BigDecimal;
import java.util.List;

public class StarDataCount {
    /**
     * 题目名称
     */
    private String name;
    /**
     * 评论星级列表
     */
    private List<CommonStar> commonStars;
    /**
     * 平均分值
     */
    private BigDecimal avgScore;

    public BigDecimal getAvgScore() {
        return avgScore;
    }

    public void setAvgScore(BigDecimal avgScore) {
        this.avgScore = avgScore;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<CommonStar> getCommonStars() {
        return commonStars;
    }

    public void setCommonStars(List<CommonStar> commonStars) {
        this.commonStars = commonStars;
    }
}
