package bpk.project.blog.controller;

import bpk.project.blog.entity.Post;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class PostController {

   Post post1 = new Post(1, "My First Post", "This is my first post", "my-first-post");
   Post post2 = new Post(2, "My Second Post", "This is my second post", "my-second-post");
   List<Post> posts = new ArrayList<Post>(Arrays.asList(post1, post2));

   // Get All Posts
   @GetMapping("/")
   public List<Post> getPosts(){
       return posts;
   }

   // Get Post by Slug
   @GetMapping("/{slug}")
   public Post getPostBySlug(@PathVariable String slug){
       return posts.stream().filter(post -> post.getSlug().equals(slug)).findFirst().orElse(null);
   }

   // Create Post
   @PostMapping("/")
   public Post createPost(@RequestBody Post post){
       posts.add(post);
       return post;
   }

   // Update Post
   @PutMapping("/{slug}")
   public Post updatePost(@PathVariable String slug, @RequestBody Post postDetails){
       Post savedPost = posts.stream().filter(p -> p.getSlug().equals(slug)).findFirst().orElse(null);
       if(savedPost == null) return null;
       posts.remove(savedPost);
       savedPost.setTitle(postDetails.getTitle());
       savedPost.setBody(postDetails.getBody());
       savedPost.setSlug(postDetails.getSlug());
       posts.add(savedPost);
       return savedPost;
   }

   // Delete Post
   @DeleteMapping("/{id}")
   public boolean deletePostById(@PathVariable Integer id){
       Post savedPost = posts.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
       if(savedPost == null) return false;
       posts.remove(savedPost);
       return true;
   }

   @PostMapping("/{id}/publish")
   public Post publishPost(@PathVariable Integer id){
       Post savedPost = posts.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
       if(savedPost == null) {
           return null;
       }
       savedPost.setPublished(true);
       return savedPost;
   }
}
