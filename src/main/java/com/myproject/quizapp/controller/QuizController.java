package com.myproject.quizapp.controller;

import com.myproject.quizapp.model.Question;
import com.myproject.quizapp.model.QuestionWrapper;
import com.myproject.quizapp.model.Response;
import com.myproject.quizapp.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizController {
    @Autowired
    QuizService quizService ;

    @PostMapping("create")
    ResponseEntity<String> createQuiz(@RequestParam String category,@RequestParam int numofQ,@RequestParam String title){
        return (quizService.createQuiz(category,numofQ,title));
    }

    @GetMapping("getQuiz/{id}")
    ResponseEntity<List<QuestionWrapper>> getQuiz(@PathVariable Integer id){
        return quizService.getQuiz(id);
    }
    @PostMapping("submit/{id}")
    ResponseEntity<Integer> submitQuiz(@PathVariable Integer id,@RequestBody List<Response> response){
        return quizService.submitQuiz(id,response);
    }

}
