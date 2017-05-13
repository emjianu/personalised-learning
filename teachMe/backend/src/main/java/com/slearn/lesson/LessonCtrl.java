package com.slearn.lesson;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by E-M on 4/9/2017.
 */
@Controller
public class LessonCtrl {

    @Autowired
    private LessonService lessonService;

    @ResponseBody
    @RequestMapping(value = "/lessons/{lessonid}", method = RequestMethod.GET)
    public Lesson getLesson(@PathVariable long lessonid) {

        System.out.println("in java ctrl");
        Lesson lesson = lessonService.getLessonById(lessonid);


        return lesson;
    }


    @ResponseBody
    @RequestMapping(value = "/lessons", method = RequestMethod.GET)
    public ArrayList<Lesson> getLessons() {

        System.out.println("in java ctrl -- get lessons");
        ArrayList<Lesson> lessons = lessonService.getLessons();


        return lessons;
    }

}
