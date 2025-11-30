package bpk.project.blog.entity;

import lombok.Data;

@Data
public class Comment {
    private Integer id;
    private String name;
    private String body;
    private String email;
    private Integer postId;
    private Long createdAt;
}
