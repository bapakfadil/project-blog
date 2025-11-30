package bpk.project.blog.service;

import bpk.project.blog.entity.Post;
import bpk.project.blog.repository.PostRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class PostService {
    @Autowired
    PostRepository postRepository;

    // Service: Get All Posts
    public Iterable<Post> getPosts() {
        return postRepository.findAll();
    }

    // Service: Get Post by Slug
    public Post getPostBySlug(String slug){
        return postRepository.findFirstBySlugAndIsDeleted(slug, false).orElse(null);
    }

    // Service: Create Post
    public Post createPost(Post post){
        post.setCreatedAt(Instant.now().getEpochSecond()); // Add value to createdAt
        return postRepository.save(post);
    }

    // Service: Update Post
    public Post updatePostBySlug(String slug, Post postDetails){
        Post targetPost = postRepository.findFirstBySlugAndIsDeleted(slug, false).orElse(null);
        if(targetPost == null) return null;
        postDetails.setId(targetPost.getId());
        postDetails.setCreatedAt(targetPost.getCreatedAt());
        postDetails.setPublishedAt(targetPost.getPublishedAt());
        postDetails.setUpdatedAt(Instant.now().getEpochSecond());
        postDetails.setPublished(targetPost.isPublished());
        postDetails.setDeleted(targetPost.isDeleted());
        return postRepository.save(postDetails);
    }

    // Service: Delete Post
    public boolean deletePostById(Integer id){
        Post targetPost = postRepository.findById(id).orElse(null);
        if(targetPost == null) return false;
        targetPost.setDeleted(true);
        postRepository.save(targetPost);
        return true;
    }

    // Service: Publish Post
    public Post publishPost(Integer id){
        Post targetPost = postRepository.findById(id).orElse(null);
        if(targetPost == null) {
            return null;
        }
        targetPost.setPublished(true);
        targetPost.setPublishedAt(Instant.now().getEpochSecond());
        return postRepository.save(targetPost);
    }


}
