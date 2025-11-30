package bpk.project.blog.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE) // Change to AUTO for production
    private Integer id;
    private String title;
    private String body;

    @Column(unique = true) // Set unique constraint on slug column
    private String slug;
    private boolean isPublished;
    private boolean isDeleted;
    private long createdAt; // Change to long to handle time in seconds
    private long publishedAt; // Change to long to handle time in seconds
}
