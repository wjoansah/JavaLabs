package com.wjoansah.comments;

import com.wjoansah.comments.dtos.CreateCommentDTO;
import com.wjoansah.comments.dtos.UpdateCommentDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentController {
    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping
    public ResponseEntity<Comment> createComment(@RequestBody CreateCommentDTO request) {
        var comment = commentService.createComment(CreateCommentDTO.toComment(request));
        return ResponseEntity.ok(comment);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Comment> getComment(@PathVariable Integer id) {
        var comment = commentService.getComment(id);
        return ResponseEntity.ok(comment);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Comment> updateComment(@PathVariable Integer id, @RequestBody UpdateCommentDTO request) {
        var updatedComment = commentService.editComment(id, request);
        if (updatedComment == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(updatedComment);
    }


    @GetMapping("/post/{postId}")
    public ResponseEntity<List<Comment>> getCommentPost(@PathVariable Integer postId) {
        var comments = commentService.getCommentsForPost(postId);
        return ResponseEntity.ok(comments);
    }

    @DeleteMapping("/{id}")
    public void deleteComment(@PathVariable Integer id) {
        commentService.deleteComment(id);
    }
}
