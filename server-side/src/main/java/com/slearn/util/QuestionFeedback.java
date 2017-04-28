package com.slearn.util;

import com.slearn.question.Question;

/**
 * Created by E-M on 4/22/2017.
 */
public class QuestionFeedback {

    private Question answeredQuestion;

    private boolean wasCorrect;

    private String notes;

    public QuestionFeedback() {

    }


    public Question getAnsweredQuestion() {
        return answeredQuestion;
    }

    public void setAnsweredQuestion(Question answeredQuestion) {
        this.answeredQuestion = answeredQuestion;
    }

    public boolean isWasCorrect() {
        return wasCorrect;
    }

    public void setWasCorrect(boolean wasCorrect) {
        this.wasCorrect = wasCorrect;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
