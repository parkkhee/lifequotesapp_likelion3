package org.example;

public class Book {

    private Long no;
    private String author;
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
