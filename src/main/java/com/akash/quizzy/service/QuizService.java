package com.akash.quizzy.service;

import com.akash.quizzy.dao.QuestionDao;
import com.akash.quizzy.dao.QuizDao;
import com.akash.quizzy.model.Question;
import com.akash.quizzy.model.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizService {

    @Autowired
    QuizDao quizdao;

    @Autowired
    QuestionDao questionDao;


    public ResponseEntity<String> createQuiz(String category, Integer numQ, String title) {

        List<Question> questionsForQuiz = questionDao.findRandomQuestions(category, numQ);

        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestionsList(questionsForQuiz);

        quizdao.save(quiz);

        return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }
}
