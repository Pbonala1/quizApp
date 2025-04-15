package com.myproject.quizapp.dao;

import com.myproject.quizapp.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface QuizDAO extends JpaRepository<Quiz,Integer> {



}
