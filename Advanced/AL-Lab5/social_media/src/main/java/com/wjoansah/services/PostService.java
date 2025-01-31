package com.wjoansah.services;

import com.wjoansah.dtos.post.PostRequest;
import com.wjoansah.entities.Post;
import com.wjoansah.entities.User;
import com.wjoansah.repositories.PostRepository;
import com.wjoansah.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    public Post createPost(PostRequest request) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Post post = new Post();
        post.setContent(request.getContent());
        post.setUser(user);

        return postRepository.save(post);
    }

    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    public List<Post> getUserPosts(Long userId) {
        return postRepository.findByUserIdOrderByCreatedAtDesc(userId);
    }

    public void deletePost(Long postId) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new RuntimeException("Post not found"));

        if (!post.getUser().getUsername().equals(username)) {
            throw new RuntimeException("You can only delete your own posts");
        }

        postRepository.delete(post);
    }
}
