package com.slearn.questionTags;

import com.slearn.question.Question;

import javax.persistence.*;

/**
 * Created by E-M on 3/17/2017.
 */

@Entity
public class QuestionTag {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "question")
    private Question question;


    @ManyToOne
    @JoinColumn(name = "word_tag")
    private WordTag word;

    private double rank;

    public QuestionTag() {

    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public WordTag getWord() {
        return word;
    }

    public void setWord(WordTag word) {
        this.word = word;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getRank() {
        return rank;
    }

    public void setRank(double rank) {
        this.rank = rank;
    }
}
