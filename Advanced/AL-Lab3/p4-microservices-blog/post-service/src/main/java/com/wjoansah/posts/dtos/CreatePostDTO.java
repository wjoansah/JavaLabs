package com.wjoansah.posts.dtos;

import com.wjoansah.posts.Post;

public class CreatePostDTO {
    private String title;
    private String content;
    private Integer userId;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public static Post toPost(CreatePostDTO createPostDTO) {
        var post = new Post();
        post.setTitle(createPostDTO.getTitle());
        post.setContent(createPostDTO.getContent());
        post.setUserId(createPostDTO.getUserId());
        return post;
    }
}
