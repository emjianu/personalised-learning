package com.slearn.userKnowledge;

import com.slearn.KI.KnowledgeItem;
import com.slearn.user.User;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

/**
 * Created by E-M on 4/1/2017.
 */
@Entity
@Table(name = "user_knowledge")
public class UserKnowledge {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @ManyToOne
    @JoinColumn(name = "user")
    private User user;

    @ManyToOne
    @JoinColumn(name = "knowledge_item")
    private KnowledgeItem knowledgeItem;


    @Min(0)
    @Max(5)
    private double score;


    private int theoreticalQsAnswered;

    private int reasoningQsAnswered;


    public UserKnowledge() {

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

    public KnowledgeItem getKnowledgeItem() {
        return knowledgeItem;
    }

    public void setKnowledgeItem(KnowledgeItem knowledgeItem) {
        this.knowledgeItem = knowledgeItem;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public int getTheoreticalQsAnswered() {
        return theoreticalQsAnswered;
    }

    public void setTheoreticalQsAnswered(int theoreticalQsAnswered) {
        this.theoreticalQsAnswered = theoreticalQsAnswered;
    }

    public int getReasoningQsAnswered() {
        return reasoningQsAnswered;
    }

    public void setReasoningQsAnswered(int reasoningQsAnswered) {
        this.reasoningQsAnswered = reasoningQsAnswered;
    }
}
