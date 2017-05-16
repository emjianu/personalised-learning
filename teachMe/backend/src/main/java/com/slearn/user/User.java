package com.slearn.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.slearn.choice.Choice;
import com.slearn.questionActivity.QuestionActivity;
import com.slearn.userKnowledge.UserKnowledge;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Collection;

/**
 * Created by E-M on 4/1/2017.
 */

@Entity
@Table(name = "user")
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Size(min = 2, max = 100)
    private String username;

    @Size(min = 2, max = 100)
    private String email;


    @NotNull
    @Size(min = 2, max = 300)
    private String password;

    @Min(0)
    @Max(5)
    private double theoryScore;

    @Min(0)
    @Max(5)
    private double reasoningScore;

    private int level;

    private int xp;

    private int rank; //these will be predefined - must make a table for them


    @Transient
    int xp_gain_correct = 10;

    @Transient
    int xp_gain_wrong = 5;




    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    private Collection<UserKnowledge> knowledgeItemScores;

    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    private Collection<QuestionActivity> questionActivities;


    public User() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getTheoryScore() {
        return theoryScore;
    }

    public void setTheoryScore(double theoryScore) {
        this.theoryScore = theoryScore;
    }

    public double getReasoningScore() {
        return reasoningScore;
    }

    public void setReasoningScore(double reasoningScore) {
        this.reasoningScore = reasoningScore;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public Collection<UserKnowledge> getKnowledgeItemScores() {
        return knowledgeItemScores;
    }

    public void setKnowledgeItemScores(Collection<UserKnowledge> knowledgeItemScores) {
        this.knowledgeItemScores = knowledgeItemScores;
    }



    //helper functions for scores and stuff

    public void addKPForCorrect(){
        int currentXP = this.xp;
        this.setXp(currentXP + xp_gain_correct);
        checkLevel();

    }

    public void addKPForWrong(){
        int currentXP = this.xp;
        this.setXp(currentXP + xp_gain_wrong);
        checkLevel();

    }


    public void checkLevel(){
        if(this.level > 0) {
            if (this.xp / this.level == 100 && this.xp % this.level < 5){
                levelUp();
            }
        }
    }

    public void levelUp(){
        this.level++;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", theoryScore=" + theoryScore +
                ", reasoningScore=" + reasoningScore +
                ", level=" + level +
                ", xp=" + xp +
                ", rank=" + rank +
                '}';
    }
}
