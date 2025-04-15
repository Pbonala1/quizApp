package com.myproject.quizapp.dao;

import com.myproject.quizapp.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface QuestionDAO extends JpaRepository<Question,Integer> {
     List<Question> findByCategory(String category);


     @Query(value = "SELECT * FROM Question q  Where q.category=:category ORDER BY RANDOM() LIMIT :numofQ", nativeQuery = true)
     List<Question> generateRandomqns(String category, int numofQ);

}