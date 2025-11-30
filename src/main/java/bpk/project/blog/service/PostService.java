package bpk.project.blog.service;

import bpk.project.blog.entity.Post;
import bpk.project.blog.repository.PostRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return postRepository.findFirstBySlug(slug).orElse(null);
    }

    // Service: Create Post
    public Post createPost(Post post){
        return postRepository.save(post);
    }

    // Service: Update Post
    public Post updatePostBySlug(String slug, Post postDetails){
        Post targetPost = postRepository.findFirstBySlug(slug).orElse(null);
        if(targetPost == null) return null;
        postDetails.setId(targetPost.getId());
        return postRepository.save(postDetails);
    }

    // Service: Delete Post
    public boolean deletePostById(Integer id){
        Post targetPost = postRepository.findById(id).orElse(null);
        if(targetPost == null) return false;
        postRepository.delete(targetPost);
        return true;
    }

    // Service: Publish Post
    public Post publishPost(Integer id){
        Post targetPost = postRepository.findById(id).orElse(null);
        if(targetPost == null) {
            return null;
        }
        targetPost.setPublished(true);
        return targetPost;
    }


}
