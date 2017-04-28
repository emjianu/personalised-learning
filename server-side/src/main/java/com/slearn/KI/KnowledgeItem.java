package com.slearn.KI;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.slearn.lesson.Lesson;
import com.slearn.question.Question;
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


    @ManyToOne
    @JoinColumn(name = "lesson")
    private Lesson lesson;


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
}
