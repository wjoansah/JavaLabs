package com.wjoansah.posts;

import com.wjoansah.posts.dtos.CreatePostDTO;
import com.wjoansah.posts.dtos.UpdatePostDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping
    public ResponseEntity<Post> createPost(@RequestBody CreatePostDTO request) {
        var post = postService.createPost(CreatePostDTO.toPost(request));
        return ResponseEntity.ok(post);
    }

    @GetMapping
    public ResponseEntity<List<Post>> getPosts() {
        var posts = postService.getAllPosts();
        return ResponseEntity.ok(posts);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Post> getPost(@PathVariable Integer id) {
        var post = postService.getPost(id);
        return ResponseEntity.ok(post);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Post> updatePost(@PathVariable Integer id, @RequestBody UpdatePostDTO request) {
        var updatedPost = postService.updatePost(id, request);
        if (updatedPost == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(updatedPost);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable Integer id) {
        postService.deletePost(id);
        return ResponseEntity.noContent().build();
    }
}
