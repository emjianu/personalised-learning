package com.slearn.lesson;

import javax.persistence.*;

/**
 * Created by E-M on 4/1/2017.
 */

@Entity
@Table(name = "lesson_connection")
public class LessonConnection {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @ManyToOne
    @JoinColumn(name = "lesson1")
    private Lesson lesson1;


    @ManyToOne
    @JoinColumn(name = "lesson2")
    private Lesson lesson2;

    private double connectionValue;


    public LessonConnection() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Lesson getLesson1() {
        return lesson1;
    }

    public void setLesson1(Lesson lesson1) {
        this.lesson1 = lesson1;
    }

    public Lesson getLesson2() {
        return lesson2;
    }

    public void setLesson2(Lesson lesson2) {
        this.lesson2 = lesson2;
    }

    public double getConnectionValue() {
        return connectionValue;
    }

    public void setConnectionValue(double connectionValue) {
        this.connectionValue = connectionValue;
    }
}
