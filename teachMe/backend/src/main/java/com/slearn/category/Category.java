package com.slearn.category;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.slearn.choice.Choice;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Collection;

/**
 * Created by E-M on 3/1/2017.
 */

/*
* Category class
*
* categories are of 11 types - 10 ranges and one correct choice
*
* the correct choice is of id number 11 and by default is given the whole range 0-5 so that it will be selected at all times
* */


@Entity
@Table(name = "category")
public class Category {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @NotNull
    @Size(min = 2, max = 200)
    private String name;


    private double min;

    private double max;

    @JsonIgnore
    @OneToMany(mappedBy = "category", cascade = CascadeType.REMOVE)
    private Collection<Choice> choices;


    public Category() {

    }

    public double getMin() {
        return min;
    }

    public void setMin(double min) {
        this.min = min;
    }

    public double getMax() {
        return max;
    }

    public void setMax(double max) {
        this.max = max;
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
}
