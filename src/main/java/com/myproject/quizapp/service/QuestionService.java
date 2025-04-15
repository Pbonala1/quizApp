package com.myproject.quizapp.service;

import com.myproject.quizapp.model.Question;
import com.myproject.quizapp.dao.QuestionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {
    @Autowired
    QuestionDAO questionDAO;


    public ResponseEntity<List<Question>> getAllQuestions() {
        try {
            return new ResponseEntity<>(questionDAO.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List<Question>> getByCategory(String category) {
        try {
            return new ResponseEntity<>(questionDAO.findByCategory(category), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);

    }

    public ResponseEntity<String> addQuestion(Question question) {
        try {
            questionDAO.save(question);
            return new ResponseEntity<>("Success", HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>("Cannot create", HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> updateQuestion(Integer id, Question question) {

        //if(questionDAO.findById(id).isPresent()) {
        try {
            Question existingQuestion = questionDAO.findById(id).get();
            existingQuestion.setQuestionTitle(question.getQuestionTitle());
            existingQuestion.setOption1(question.getOption1());
            existingQuestion.setOption2(question.getOption2());
            existingQuestion.setOption3(question.getOption3());
            existingQuestion.setOption4(question.getOption4());
            existingQuestion.setRightAnswer(question.getRightAnswer());
            existingQuestion.setDifficultyLevel(question.getDifficultyLevel());
            existingQuestion.setCategory(question.getCategory());
            questionDAO.save(existingQuestion);
            return new ResponseEntity<>("Updated", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            //throw new RuntimeException("id not found");
        }

        return new ResponseEntity<>("id not found", HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<String> deleteQuestion(Integer id, Question question) {
        //
        //throw new RuntimeException("id not found");}


        try {
            if(questionDAO.findById(id).isPresent()) {
                questionDAO.delete(question);
                return new ResponseEntity<>("deleted", HttpStatus.OK);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>("id not found", HttpStatus.NOT_FOUND);
    }
}
