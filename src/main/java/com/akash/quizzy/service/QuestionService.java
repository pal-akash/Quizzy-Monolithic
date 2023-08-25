package com.akash.quizzy.service;

import com.akash.quizzy.Question;
import com.akash.quizzy.dao.QuestionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionDao questionDao;

    public List<Question> getAllQuestions() {
        return questionDao.findAll();
    }

    public List<Question> getQuestionsByCategory(String category) {
        return questionDao.findByCategory(category);
    }

    public Question getQuestionById(Integer id) {
        return questionDao.findById(id).get();
    }

    public String addQuestion(Question question) {
        questionDao.save(question);
        return "Success";
    }
}
