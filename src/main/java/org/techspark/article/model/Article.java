package org.techspark.article.model;

import io.swagger.v3.oas.annotations.media.Schema;

public class Article {

    private Long id;
    @Schema(description = "Title of the article", example = "Sample Title")
    private String title;
    @Schema(description = "Author of the article", example = "Unknown Author")
    private String author;
    @Schema(description = "Content of the article", example = "Sample Content")
    private String content;

    // Constructors, getters, and setters
    public Article(Long id, String title, String author, String content) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.content = content;
    }

    public Article() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
