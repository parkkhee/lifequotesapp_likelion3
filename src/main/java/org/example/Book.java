package org.example;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Book {

    @JsonProperty("id")
    private Long no;
    @JsonProperty("author")
    private String author;
    @JsonProperty("content")
    private String content;

    public Book(Long no, String author, String content) {
        this.no = no;
        this.author = author;
        this.content = content;
    }

    public Long getNo() {
        return no;
    }

    public String getAuthor() {
        return author;
    }

    public String getContent() {
        return content;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
