package com.myproject.quizapp.controller;

import com.myproject.quizapp.model.Question;
import com.myproject.quizapp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("questions")
public class QuestionController {

    @Autowired
    QuestionService questionService;
    @GetMapping("allQuestions")
    public ResponseEntity<List<Question>> getAllQuestions(){
        return questionService.getAllQuestions();
    }
    @GetMapping("category/{category}")
    public ResponseEntity<List<Question> >getByCategory(@PathVariable String category){
        return questionService.getByCategory(category);
    }

    @PostMapping("addquestion")
    public ResponseEntity<String> addQuestion(@RequestBody Question question){
        return questionService.addQuestion(question);
    }
    @PutMapping("updatequestion/{id}")
    public ResponseEntity<String> updateQuestion(@PathVariable Integer id,@RequestBody Question question){
        return questionService.updateQuestion(id,question);
    }
    @DeleteMapping("deletequestion/{id}")
    public  ResponseEntity<String> deleteQuestion(@PathVariable Integer id,Question question){
        return questionService.deleteQuestion(id,question);
    }
}
