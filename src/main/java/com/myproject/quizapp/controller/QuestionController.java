package com.myproject.quizapp.controller;

import com.myproject.quizapp.Question;
import com.myproject.quizapp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("questions")
public class QuestionController {

    @Autowired
    QuestionService questionService;
    @GetMapping("allQuestions")
    public List<Question> getAllQuestions(){
        return questionService.getAllQuestions();
    }
    @GetMapping("category/{category}")
    public List<Question> getByCategory(@PathVariable String category){
        return questionService.getByCategory(category);
    }

    @PostMapping("addquestion")
    public String addQuestion(@RequestBody Question question){
        return questionService.addQuestion(question);
    }
    @PutMapping("updatequestion/{id}")
    public String updateQuestion(@PathVariable Integer id,@RequestBody Question question){
        return questionService.updateQuestion(id,question);
    }
    @DeleteMapping("deletequestion/{id}")
    public  String deleteQuestion(@PathVariable Integer id,Question question){
        return questionService.deleteQuestion(id,question);
    }
}
