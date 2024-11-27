package com.wjoansah.comments.dtos;

import com.wjoansah.comments.Comment;

public class CreateCommentDTO {
    private Integer postId;
    private Integer userId;
    private String content;

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public static Comment toComment(CreateCommentDTO createCommentDTO) {
        Comment comment = new Comment();
        comment.setPostId(createCommentDTO.getPostId());
        comment.setUserId(createCommentDTO.getUserId());
        comment.setContent(createCommentDTO.getContent());
        return comment;
    }

}
