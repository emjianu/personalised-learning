package com.slearn.test;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.slearn.choice.Choice;
import com.slearn.question.Question;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by E-M on 2/28/2017.
 */

//     I DONT REALLY NEED THIS FOR NOW.
    // QUESTIONS BELONG TO A LESSON!
@Entity
@Table(name = "test")
public class Test {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @NotNull
    @Size(min = 2, max = 400)
    private String name;
/*
    private double result;*/

/*
    @JsonIgnore
    @OneToMany(mappedBy = "test", cascade = CascadeType.REMOVE)
    private Collection<Question> questions;*/

    public Test() {

    }


/*
    public void addQuestion(Question q) {
        if (questions == null) {
            questions = new HashSet<>();
        }
        questions.add(q);
    }
*/


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
/*
    public Collection<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(Set<Question> questions) {
        this.questions = questions;
    }*/

    @Override
    public String toString() {
        return "Test{" +
                "id=" + id +
                ", name='" + name + '\'' +

                '}';
    }
}
