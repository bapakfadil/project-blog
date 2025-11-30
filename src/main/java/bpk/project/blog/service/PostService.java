package bpk.project.blog.service;

import bpk.project.blog.entity.Post;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class PostService {
    Post post1 = new Post(1, "My First Post", "This is my first post", "my-first-post");
    Post post2 = new Post(2, "My Second Post", "This is my second post", "my-second-post");
    List<Post> posts = new ArrayList<Post>(Arrays.asList(post1, post2));

    // Service: Get All Posts
    public List<Post> getPosts() {
        return posts;
    }

    // Service: Get Post by Slug
    public Post getPostBySlug(String slug){
        return posts.stream().filter(p -> p.getSlug().equals(slug)).findFirst().orElse(null);
    }

    // Service: Create Post
    public Post createPost(Post post){
        posts.add(post);
        return post;
    }

    // Service: Update Post
    public Post updatePostBySlug(String slug, Post postDetails){
        Post savedPost = posts.stream().filter(p -> p.getSlug().equals(slug)).findFirst().orElse(null);
        if(savedPost == null) return null;
        posts.remove(savedPost);
        savedPost.setTitle(postDetails.getTitle());
        savedPost.setBody(postDetails.getBody());
        savedPost.setSlug(postDetails.getSlug());
        posts.add(savedPost);
        return savedPost;
    }

    // Service: Delete Post
    public boolean deletePostById(Integer id){
        Post savedPost = posts.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
        if(savedPost == null) return false;
        posts.remove(savedPost);
        return true;
    }

    // Service: Publish Post
    public Post publishPost(Integer id){
        Post savedPost = posts.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
        if(savedPost == null) {
            return null;
        }
        savedPost.setPublished(true);
        return savedPost;
    }
}
