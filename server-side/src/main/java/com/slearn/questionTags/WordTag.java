package com.slearn.questionTags;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.slearn.choice.Choice;
import com.slearn.question.Question;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Collection;

/**
 * Created by E-M on 3/17/2017.
 */

@Entity
public class WordTag {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @NotNull
    @Size(min = 2, max = 200)
    private String word;

    @Min(value = 0)
    @Max(value = 1)
    private double frequency;

    @JsonIgnore
    @OneToMany(mappedBy = "word", cascade = CascadeType.REMOVE)
    private Collection<QuestionTag> questions;


    public WordTag() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public double getFrequency() {
        return frequency;
    }

    public void setFrequency(double frequency) {
        this.frequency = frequency;
    }

    public Collection<QuestionTag> getQuestions() {
        return questions;
    }

    public void setQuestions(Collection<QuestionTag> questions) {
        this.questions = questions;
    }
}
