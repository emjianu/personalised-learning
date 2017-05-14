package com.slearn.KI;

import com.slearn.lesson.Lesson;
import com.slearn.user.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by E-M on 5/4/2017.
 */
@Service
public class KnowledgeItemService {

    @Autowired
    private KnowledgeItemRepository knowledgeItemRepository;

    public List<KnowledgeItem> getTackledKIsForUser(User user, Lesson lesson) {

        List<KnowledgeItem> KIs = new ArrayList<>();

        try {
            KIs = knowledgeItemRepository.getAllTackledKIsForUserAndLesson(user.getId(), lesson.getId());
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return KIs;
    }

    public List<KnowledgeItem> getNextUNTackledKIForUser(User user, Lesson lesson) {

        List<KnowledgeItem> KIs = new ArrayList<>();

        try {
            KIs = knowledgeItemRepository.getNextUNTackledKIforUserAndLesson(user.getId(), lesson.getId(), new PageRequest(0, 1));
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return KIs;
    }


    public KnowledgeItem getById(long id) {
        KnowledgeItem ki = null;
        try {
            ki = knowledgeItemRepository.findOne(id);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return ki;
    }

    public KnowledgeItem getFirstKI(long lessonId) {
        List<KnowledgeItem> kis = new ArrayList<>();
        try {
             kis = knowledgeItemRepository.findFirst(lessonId, new PageRequest(0, 1));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return kis.get(0);
    }


}
