package com.wjoansah.posts;

import com.wjoansah.posts.dtos.UpdatePostDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public Post createPost(Post post) {
        return postRepository.save(post);
    }

    public Post getPost(Integer id) {
        return postRepository.findById(id).orElse(null);
    }

    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    public Post updatePost(Integer postId, UpdatePostDTO postDTO) {
        var post = postRepository.findById(postId).orElse(null);
        if (post == null) return null;

        var updatedPost = UpdatePostDTO.toPost(post, postDTO);
        return postRepository.save(updatedPost);
    }

    public void deletePost(Integer id) {
        postRepository.deleteById(id);
    }
}
