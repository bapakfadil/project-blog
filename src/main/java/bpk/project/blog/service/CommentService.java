package bpk.project.blog.service;

import bpk.project.blog.entity.Comment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    public Iterable<Comment> getComments(String postSlug, Integer pageNo, Integer limit){
        List<Comment> comments = List.of();
        return comments;
    }

    public Comment getCommentById(Integer id){
        return new Comment();
    }

    public Comment createComment(Comment comment){
        return comment;
    }
}
