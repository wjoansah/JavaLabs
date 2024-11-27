package com.wjoansah.posts.dtos;

import com.wjoansah.posts.Post;

public class UpdatePostDTO {
    private String title;
    private String content;

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

    public static Post toPost(Post post, UpdatePostDTO dto) {
        if(dto.getTitle() != null)
            post.setTitle(dto.getTitle());
        if(dto.getContent() != null)
            post.setContent(dto.getContent());
        return post;
    }
}
