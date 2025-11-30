package bpk.project.blog.entity;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.*;
import lombok.Data;

@Data
@JsonPropertyOrder({ "id", "title", "body", "slug", "isPublished", "isDeleted", "createdAt", "publishedAt", "updatedAt" })
@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Changed to IDENTITY
    private Integer id;
    private String title;
    private String body;

    @Column(unique = true) // Set unique constraint on slug column
    private String slug;
    private boolean isPublished;
    private boolean isDeleted;
    private Long createdAt; // Change to long to handle time in seconds
    private Long updatedAt; // Change to long to handle time in seconds
    private Long publishedAt; // Change to long to handle time in seconds
}
