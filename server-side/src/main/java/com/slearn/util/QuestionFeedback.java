package com.slearn.util;

import com.slearn.question.Question;

/**
 * Created by E-M on 4/22/2017.
 */
public class QuestionFeedback {

    private Question answeredQuestion;

    private boolean correct;

    private String notes;

    public QuestionFeedback() {

    }


    public Question getAnsweredQuestion() {
        return answeredQuestion;
    }

    public void setAnsweredQuestion(Question answeredQuestion) {
        this.answeredQuestion = answeredQuestion;
    }

    public boolean isCorrect() {
        return correct;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        return "QuestionFeedback{" +
                "answeredQuestion=" + answeredQuestion +
                ", correct=" + correct +
                ", notes='" + notes + '\'' +
                '}';
    }
}
