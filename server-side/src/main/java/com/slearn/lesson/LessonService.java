package com.slearn.lesson;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Created by E-M on 4/9/2017.
 */
@Service
public class LessonService {

    @Autowired
    private LessonRepository lessonRepository;

    public Lesson getLessonById(long lessonId) {
        Lesson lesson = null;
        try {

            System.out.println("find lesson");
            lesson = lessonRepository.findOne(lessonId);
            System.out.println("l: " + lesson.toString());
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return lesson;

    }


    public ArrayList<Lesson> getLessons() {
        ArrayList<Lesson> lessons = null;
        try {

            System.out.println("find all lessons");
            lessons = (ArrayList<Lesson>) lessonRepository.findAll();


            System.out.println("l: " + lessons.toString());
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return lessons;

    }



}
