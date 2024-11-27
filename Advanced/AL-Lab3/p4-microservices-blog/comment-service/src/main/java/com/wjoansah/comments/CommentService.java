package com.wjoansah.comments;

import com.wjoansah.comments.dtos.UpdateCommentDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    private final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public Comment createComment(Comment comment) {
        return commentRepository.save(comment);
    }

    public Comment editComment(Integer commentId, UpdateCommentDTO commentDTO) {
        var comment = commentRepository.findById(commentId).orElse(null);
        if (comment == null) return null;

        var updatedComment = UpdateCommentDTO.toComment(comment, commentDTO);
        return commentRepository.save(updatedComment);
    }

    public List<Comment> getCommentsForPost(Integer postId) {
        return commentRepository.findCommentsByPostId(postId);
    }

    public Comment getComment(Integer commentId) {
        return commentRepository.findById(commentId).get();
    }

    public void deleteComment(Integer commentId) {
        commentRepository.deleteById(commentId);
    }
}
