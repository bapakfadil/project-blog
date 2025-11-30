package bpk.project.blog.controller;

import bpk.project.blog.entity.Post;
import bpk.project.blog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {
   @Autowired
   PostService postService = new PostService();

   // Get All Posts
   @GetMapping("/")
   public List<Post> getPosts(){
       return postService.getPosts();
   }

   // Get Post by Slug
   @GetMapping("/{slug}")
   public Post getPostBySlug(@PathVariable String slug){
       return postService.getPostBySlug(slug);
   }

   // Create Post
   @PostMapping("/")
   public Post createPost(@RequestBody Post post){
       return postService.createPost(post);
   }

   // Update Post
   @PutMapping("/{slug}")
   public Post updatePost(@PathVariable String slug, @RequestBody Post postDetails){
       return postService.updatePostBySlug(slug, postDetails);
   }

   // Delete Post
   @DeleteMapping("/{id}")
   public boolean deletePostById(@PathVariable Integer id){
       return postService.deletePostById(id);
   }

   // Publish Post
   @PostMapping("/{id}/publish")
   public Post publishPost(@PathVariable Integer id){
       return postService.publishPost(id);
   }
}
