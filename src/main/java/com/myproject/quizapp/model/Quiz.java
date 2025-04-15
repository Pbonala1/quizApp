package com.myproject.quizapp.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String title;
    @ManyToMany
    List<Question> questions;

    public Integer getId() {
        return id;
    }

    public Quiz() {
    }

    public Quiz(String title, List<Question> questions) {
        this.title = title;
        this.questions = questions;
    }

    public Quiz(Integer id, String title, List<Question> questions) {
        this.id = id;
        this.title = title;
        this.questions = questions;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }




}
