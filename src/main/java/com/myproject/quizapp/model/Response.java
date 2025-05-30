package com.myproject.quizapp.model;

public class Response {
    private int id;
    private String response;

    public Response() {
    }

    public Response(String response) {
        this.response = response;
    }


    public Response(int id, String response) {
        this.id = id;
        this.response = response;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}
