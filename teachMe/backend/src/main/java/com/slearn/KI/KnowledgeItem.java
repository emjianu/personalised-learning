package com.slearn.KI;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.slearn.lesson.Lesson;
import com.slearn.question.Question;
import com.slearn.questionActivity.QuestionActivity;
import com.slearn.userKnowledge.UserKnowledge;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Collection;

/**
 * Created by E-M on 3/31/2017.
 */

@Entity
@Table(name = "knowledge_item")
public class KnowledgeItem {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Size(min = 2, max = 200)
    private String name;


    @JsonIgnore
    @OneToMany(mappedBy = "knowledgeItem", cascade = CascadeType.REMOVE)
    private Collection<UserKnowledge> knowledgeItemScores;

    @JsonIgnore
    @OneToMany(mappedBy = "knowledgeItem", cascade = CascadeType.REMOVE)
    private Collection<Question> questions;

    @JsonIgnore
    @OneToMany(mappedBy = "knowledgeItem", cascade = CascadeType.REMOVE)
    private Collection<QuestionActivity> activities;


    @ManyToOne
    @JoinColumn(name = "lesson")
    private Lesson lesson;

    //number of total theoretical questions available for this kn item
    private int totalTheoreticalQs;

    //number of total reasoning questions available for this kn item
    private int totalReasoningQs;


    public KnowledgeItem() {

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

    public Lesson getLesson() {
        return lesson;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }

    public Collection<UserKnowledge> getKnowledgeItemScores() {
        return knowledgeItemScores;
    }

    public void setKnowledgeItemScores(Collection<UserKnowledge> knowledgeItemScores) {
        this.knowledgeItemScores = knowledgeItemScores;
    }

    public Collection<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(Collection<Question> questions) {
        this.questions = questions;
    }

    public int getTotalTheoreticalQs() {
        return totalTheoreticalQs;
    }

    public void setTotalTheoreticalQs(int totalTheoreticalQs) {
        this.totalTheoreticalQs = totalTheoreticalQs;
    }

    public int getTotalReasoningQs() {
        return totalReasoningQs;
    }

    public void setTotalReasoningQs(int totalReasoningQs) {
        this.totalReasoningQs = totalReasoningQs;
    }

    public Collection<QuestionActivity> getActivities() {
        return activities;
    }

    public void setActivities(Collection<QuestionActivity> activities) {
        this.activities = activities;
    }

    @Override
    public String toString() {
        return "KnowledgeItem{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lesson=" + lesson +
                ", totalTheoreticalQs=" + totalTheoreticalQs +
                ", totalReasoningQs=" + totalReasoningQs +
                '}';
    }
}
