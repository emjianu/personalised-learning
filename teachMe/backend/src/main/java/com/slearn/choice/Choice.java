package com.slearn.choice;

import com.slearn.category.Category;
import com.slearn.question.Question;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


/**
 * Created by E-M on 3/1/2017.
 */
@Entity
@Table(name = "choice")
public class Choice {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Size(min = 2, max = 400)
    private String choiceText;

    @ManyToOne
    @JoinColumn(name = "category")
    private Category category;


    @ManyToOne
    @JoinColumn(name = "question")
    private Question question;

  /*  private boolean isRightAnswer;*/

    public Choice() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getChoiceText() {
        return choiceText;
    }

    public void setChoiceText(String choiceText) {
        this.choiceText = choiceText;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Choice{" +
                "id=" + id +
                ", choiceText='" + choiceText + '\'' +
                ", category=" + category +
                '}';
    }
}
