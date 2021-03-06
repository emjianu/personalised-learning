package com.slearn.question;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.slearn.KI.KnowledgeItem;
import com.slearn.category.Category;
import com.slearn.choice.Choice;
import com.slearn.lesson.Lesson;
import com.slearn.questionActivity.QuestionActivity;



import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.*;

/**
 * Created by E-M on 2/28/2017.
 */
@Entity
@Table(name = "question")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

/*    private String name;*/

    @NotNull
    @Size(min = 2, max = 400)
    private String questionText;

/*    private double difficulty;*/


    @OneToMany(mappedBy = "question", cascade = CascadeType.REMOVE)
    private Collection<Choice> answerChoices;



    @JsonIgnore
    @OneToMany(mappedBy = "question", cascade = CascadeType.REMOVE)
    private Collection<QuestionActivity> questionActivities;

    @ManyToOne
    @JoinColumn(name = "lesson")
    private Lesson lesson;

    @ManyToOne
    @JoinColumn(name = "knowledge_item")
    private KnowledgeItem knowledgeItem;

    /**
     * type of question:
     * 0 - theoretical
     * 1 - problem/reasoning
     */
    private int type;

    @Transient
    private double appliedDifficulty;

/*
    private Set<Question> childQuestions;*/


    //these are the choices that the user receives from the pool of choices according to his diff. can be 2, 3 or 4 choices
    @Transient
    private List<Choice> currentChoices;

    /** properties for displaying activity ONLY for demo **/

    @Transient
    private boolean answeredBefore;

    @Transient
    private boolean latestStatus;

    @Transient
    private int noOfPreviousAnswers;


    @Transient
    private int noOfPreviousCorrectAnswers;


    @Transient
    private int noOfPreviousWrongAnswers;

    @Transient
    private double currentAbility;

    @Transient //if any
    private double lastPrevAppDiff;



    public Question() {

    }

    public void addChoice(Choice ch) {
        if (answerChoices == null) {
            answerChoices = new HashSet<>();
        }
        answerChoices.add(ch);
    }

    //these are the choices that the user receives according to his diff. can be 2, 3 or 4 choices
    public void addCurrentChoice(Choice ch) {
        if (currentChoices == null) {
            currentChoices = new ArrayList<>();
        }
        currentChoices.add(ch);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

/*    public double getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(double difficulty) {
        this.difficulty = difficulty;
    }*/


    public Collection<Choice> getAnswerChoices() {
        return answerChoices;
    }

    public void setAnswerChoices(Set<Choice> answerChoices) {
        this.answerChoices = answerChoices;
    }

    public List<Choice> getCurrentChoices() {
        return currentChoices;
    }

    public void setCurrentChoices(List<Choice> currentChoices) {
        this.currentChoices = currentChoices;
    }

    public void setAnswerChoices(Collection<Choice> answerChoices) {
        this.answerChoices = answerChoices;
    }



    /*    public Set<Choice> getCurrentChoices() {
        return currentChoices;
    }

    public void setCurrentChoices(Set<Choice> currentChoices) {
        this.currentChoices = currentChoices;
    }*/

   /* public Set<Question> getChildQuestions() {
        return childQuestions;
    }

    public void setChildQuestions(Set<Question> childQuestions) {
        this.childQuestions = childQuestions;
    }

    public void addChild(Question q) {
        if (childQuestions == null) {
            childQuestions = new HashSet<>();
        }
        childQuestions.add(q);
    }
*/


    public Lesson getLesson() {
        return lesson;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }

    public KnowledgeItem getKnowledgeItem() {
        return knowledgeItem;
    }

    public void setKnowledgeItem(KnowledgeItem knowledgeItem) {
        this.knowledgeItem = knowledgeItem;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }


    public Collection<QuestionActivity> getQuestionActivities() {
        return questionActivities;
    }

    public void setQuestionActivities(Collection<QuestionActivity> questionActivities) {
        this.questionActivities = questionActivities;
    }

    public double getAppliedDifficulty() {
        return appliedDifficulty;
    }

    public void setAppliedDifficulty(double appliedDifficulty) {
        this.appliedDifficulty = appliedDifficulty;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Question question = (Question) o;

        if (type != question.type) return false;
        if (Double.compare(question.appliedDifficulty, appliedDifficulty) != 0) return false;
        if (id != null ? !id.equals(question.id) : question.id != null) return false;
        return questionText != null ? questionText.equals(question.questionText) : question.questionText == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id != null ? id.hashCode() : 0;
        result = 31 * result + (questionText != null ? questionText.hashCode() : 0);
        result = 31 * result + type;
        temp = Double.doubleToLongBits(appliedDifficulty);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }


    public boolean isAnsweredBefore() {
        return answeredBefore;
    }

    public void setAnsweredBefore(boolean answeredBefore) {
        this.answeredBefore = answeredBefore;
    }

    public boolean isLatestStatus() {
        return latestStatus;
    }

    public void setLatestStatus(boolean latestStatus) {
        this.latestStatus = latestStatus;
    }

    public int getNoOfPreviousAnswers() {
        return noOfPreviousAnswers;
    }

    public int getNoOfPreviousCorrectAnswers() {
        return noOfPreviousCorrectAnswers;
    }

    public void setNoOfPreviousCorrectAnswers(int noOfPreviousCorrectAnswers) {
        this.noOfPreviousCorrectAnswers = noOfPreviousCorrectAnswers;
    }

    public int getNoOfPreviousWrongAnswers() {
        return noOfPreviousWrongAnswers;
    }

    public void setNoOfPreviousWrongAnswers(int noOfPreviousWrongAnswers) {
        this.noOfPreviousWrongAnswers = noOfPreviousWrongAnswers;
    }

    public void setNoOfPreviousAnswers(int noOfPreviousAnswers) {
        this.noOfPreviousAnswers = noOfPreviousAnswers;


    }

    public double getCurrentAbility() {
        return currentAbility;
    }

    public void setCurrentAbility(double currentAbility) {
        this.currentAbility = currentAbility;
    }

    public double getLastPrevAppDiff() {
        return lastPrevAppDiff;
    }

    public void setLastPrevAppDiff(double lastPrevAppDiff) {
        this.lastPrevAppDiff = lastPrevAppDiff;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", questionText='" + questionText + '\'' +

                ", currentChoices=" + currentChoices +
                '}';
    }
}
