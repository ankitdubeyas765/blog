package com.blog.service;

import com.blog.payload.CommentDto;

import java.util.List;

public interface CommentService {
    CommentDto saveComment(Long postId, CommentDto commentDto);

    List<CommentDto> getCommentByPostId(long postId);

   CommentDto getCommentById(long postId,long commentId);


    CommentDto updateCommentById(long postId, long id, CommentDto commentDto);

    void deleteCommentById(long postId, long id);
}
