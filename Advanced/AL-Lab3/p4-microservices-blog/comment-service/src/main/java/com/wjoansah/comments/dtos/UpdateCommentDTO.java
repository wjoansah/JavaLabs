package com.wjoansah.comments.dtos;

import com.wjoansah.comments.Comment;

public class UpdateCommentDTO {
    private String comment;

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public static Comment toComment(Comment comment, UpdateCommentDTO updateCommentDTO) {
        if (updateCommentDTO.getComment() != null && !updateCommentDTO.getComment().isEmpty())
            comment.setContent(updateCommentDTO.getComment());

        return comment;
    }
}
