package com.slearn.lesson;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.slearn.KI.KnowledgeItem;
import com.slearn.choice.Choice;
import com.slearn.question.Question;
import com.slearn.questionActivity.QuestionActivity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Collection;

/**
 * Created by E-M on 3/31/2017.
 */


@Entity
@Table(name = "lesson")
public class Lesson {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @NotNull
    @Size(min = 2, max = 200)
    private String title;

    @NotNull
    @Size(min = 2, max = 1000)
    private String content;

    @JsonIgnore
    @OneToMany(mappedBy = "lesson", cascade = CascadeType.REMOVE)
    private Collection<KnowledgeItem> knowledgeItems;



    @JsonIgnore
    @OneToMany(mappedBy = "lesson", cascade = CascadeType.REMOVE)
    private Collection<Question> questions;

    @JsonIgnore
    @OneToMany(mappedBy = "lesson", cascade = CascadeType.REMOVE)
    private Collection<QuestionActivity> questionActivities;


    @JsonIgnore
    @OneToMany(mappedBy = "lesson1", cascade = CascadeType.REMOVE)
    private Collection<LessonConnection> fwLessonConnection;

    @JsonIgnore
    @OneToMany(mappedBy = "lesson2", cascade = CascadeType.REMOVE)
    private Collection<LessonConnection> backLessonConnection;

    public Lesson() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
