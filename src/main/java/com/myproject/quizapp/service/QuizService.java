package com.myproject.quizapp.service;

import com.myproject.quizapp.model.Question;
import com.myproject.quizapp.dao.QuestionDAO;
import com.myproject.quizapp.dao.QuizDAO;
import com.myproject.quizapp.model.QuestionWrapper;
import com.myproject.quizapp.model.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {
    @Autowired
    QuizDAO quizDAO;

    @Autowired
    QuestionDAO questionDAO;



    public ResponseEntity<String> createQuiz(String category, int numofQ, String title) {
        List<Question> questions=questionDAO.generateRandomqns(category,numofQ);
        Quiz quiz=new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);
        quizDAO.save(quiz);
        return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuiz(Integer id) {
        Optional<Quiz> quiz=quizDAO.findById(id);
        List<Question> fromDb =quiz.get().getQuestions();
        List<QuestionWrapper> toDb=new ArrayList<>();
        for(Question q:fromDb){
            QuestionWrapper qn=new QuestionWrapper(q.getId(),q.getQuestionTitle(),
                    q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4());
            toDb.add(qn);

        }
    return new ResponseEntity<>(toDb,HttpStatus.OK);
    }


}
