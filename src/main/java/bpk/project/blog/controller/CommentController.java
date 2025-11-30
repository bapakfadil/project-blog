package bpk.project.blog.controller;

import bpk.project.blog.entity.Comment;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/comments")
public class CommentController {
    @GetMapping
    public Iterable<Comment> getComments(
            @RequestParam(required = false) String postSlug,
            @RequestParam(required = false) Integer pageNo,
            @RequestParam(required = false) Integer limit){
        List<Comment> comments = new ArrayList<>();
        return comments;
    }

    @GetMapping("/{id}")
    public Comment getCommentById(@PathVariable Integer id){
        return new Comment();
    }

    @PostMapping
    public Comment createComment(@RequestBody Comment comment){
        return comment;
    }


}
