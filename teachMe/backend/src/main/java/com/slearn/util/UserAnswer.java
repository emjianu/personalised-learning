package com.slearn.util;

/**
 * Created by E-M on 4/22/2017.
 */
public class UserAnswer {

    private int questionId;

    private String answerId;

    private int userId;

    private double appliedDifficulty;

    private int xp;

    private int level;


    public UserAnswer() {

    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getAnswerId() {
        return answerId;
    }

    public void setAnswerId(String answerId) {
        this.answerId = answerId;
    }

    public int getUserid() {
        return userId;
    }

    public void setUserid(int userid) {
        this.userId = userid;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public double getAppliedDifficulty() {
        return appliedDifficulty;
    }

    public void setAppliedDifficulty(double appliedDifficulty) {
        this.appliedDifficulty = appliedDifficulty;
    }

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
