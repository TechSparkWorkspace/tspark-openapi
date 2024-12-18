package org.techspark.article;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.*;
import org.techspark.article.model.Article;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/articles")
@Tag(name = "Article Management", description = "CRUD operations for managing articles metadata")
@SecurityRequirement(name = "bearerAuth")
public class ArticleController {
    private List<Article> articles = new ArrayList<>();

    @PostConstruct
    public void loadData() {
        articles.add(new Article(1L, "Introduction to Spring Boot", "John Doe", "Content of Spring Boot article"));
        articles.add(new Article(2L, "REST APIs with Spring Boot", "Jane Smith", "Content of REST API article"));
        articles.add(new Article(3L, "Understanding OpenAPI", "James Brown", "Content of OpenAPI article"));
    }

    @Operation(summary = "Get all articles", description = "Fetches a list of all available articles")
    @GetMapping
    public List<Article> getAllArticles() {
        return articles;
    }

    @Operation(summary = "Get article by ID", description = "Fetches an article by its ID")
    @ApiResponse(responseCode = "200", description = "Successfully found the article")
    @ApiResponse(responseCode = "404", description = "Article not found")
    @Parameter(name = "id", description = "ID of the article to retrieve", required = true)
    @GetMapping("/{id}")
    public Article getArticleById(@PathVariable Long id) {
        return articles.stream()
                .filter(article -> article.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Operation(summary = "Create a new article", description = "Adds a new article to the list")
    @ApiResponse(responseCode = "201", description = "Article created successfully")
    @io.swagger.v3.oas.annotations.parameters.RequestBody(
            description = "Article object containing details of the new article",
            required = true
    )
    @PostMapping
    public Article createArticle(@RequestBody Article article) {
        article.setId((long) (articles.size() + 1));
        articles.add(article);
        return article;
    }

    @Operation(summary = "Update an existing article", description = "Updates an article by its ID")
    @PutMapping("/{id}")
    public Article updateArticle(@PathVariable Long id, @RequestBody Article updatedArticle) {
        for (Article article : articles) {
            if (article.getId().equals(id)) {
                article.setTitle(updatedArticle.getTitle());
                article.setAuthor(updatedArticle.getAuthor());
                article.setContent(updatedArticle.getContent());
                return article;
            }
        }
        return null;
    }

    @Operation(summary = "Delete an article", description = "Deletes an article by its ID")
    @DeleteMapping("/{id}")
    public String deleteArticle(@PathVariable Long id) {
        articles.removeIf(article -> article.getId().equals(id));
        return "Article with ID " + id + " deleted successfully";
    }
}
