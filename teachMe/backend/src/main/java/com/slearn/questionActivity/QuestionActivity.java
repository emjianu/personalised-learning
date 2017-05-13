package com.slearn.questionActivity;

import com.slearn.KI.KnowledgeItem;
import com.slearn.lesson.Lesson;
import com.slearn.question.Question;
import com.slearn.user.User;

import javax.persistence.*;

/**
 * Created by E-M on 4/24/2017.
 */

@Entity
@Table(name = "question_activity")
public class QuestionActivity {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @ManyToOne
    @JoinColumn(name = "user")
    private User user;

    @ManyToOne
    @JoinColumn(name = "question")
    private Question question;


    @ManyToOne
    @JoinColumn(name = "lesson")
    private Lesson lesson;

    @ManyToOne
    @JoinColumn(name = "knowledge_item")
    private KnowledgeItem knowledgeItem;

    private double difficulty;

    private boolean status; //answered correctly -true(1), answered incorrectly - false(0)


    public QuestionActivity() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Lesson getLesson() {
        return lesson;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }

    public double getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(double difficulty) {
        this.difficulty = difficulty;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public KnowledgeItem getKnowledgeItem() {
        return knowledgeItem;
    }

    public void setKnowledgeItem(KnowledgeItem knowledgeItem) {
        this.knowledgeItem = knowledgeItem;
    }
}
