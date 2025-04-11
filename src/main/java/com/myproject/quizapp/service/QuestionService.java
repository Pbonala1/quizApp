package com.myproject.quizapp.service;

import com.myproject.quizapp.Question;
import com.myproject.quizapp.dao.QuestionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class QuestionService {
    @Autowired
    QuestionDAO questionDAO;



    public List<Question> getAllQuestions() {
        return questionDAO.findAll();
    }

    public List<Question> getByCategory(String category) {

        return questionDAO.findByCategory(category);

    }

    public String addQuestion(Question question) {

        questionDAO.save(question);
        return "success";
    }

    public String updateQuestion(Integer id, Question question) {

       if(questionDAO.findById(id).isPresent()) {

           Question existingQuestion=questionDAO.findById(id).get();
           existingQuestion.setQuestionTitle(question.getQuestionTitle());
           existingQuestion.setOption1(question.getOption1());
           existingQuestion.setOption2(question.getOption2());
           existingQuestion.setOption3(question.getOption3());
           existingQuestion.setOption4(question.getOption4());
           existingQuestion.setRightAnswer(question.getRightAnswer());
           existingQuestion.setDifficultyLevel(question.getDifficultyLevel());
           existingQuestion.setCategory(question.getCategory());
           questionDAO.save(existingQuestion);
       }
       else{
           throw new RuntimeException("id not found");
       }

        return "updated";
    }

    public String deleteQuestion(Integer id,Question question) {
        if(questionDAO.findById(id).isPresent()) {
            questionDAO.delete(question);
        }
        else{
            throw new RuntimeException("id not found");

        }
        return "deleted";
    }
}
