package com.blog.controller;

import com.blog.payload.CommentDto;
import com.blog.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class CommentController {

    private CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    //http://localhost:8080/api/posts/1/comments
    @PostMapping("/posts/{postId}/comments")
    public ResponseEntity<CommentDto> createComment(
            @PathVariable("postId") long postId, @RequestBody CommentDto commentDto) {

        CommentDto dto = commentService.saveComment(postId, commentDto);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    @GetMapping("/posts/{postId}/comments")
    public List<CommentDto> getCommentsByPostId(@PathVariable("postId") long postId) {
        List<CommentDto> commentDto = commentService.getCommentByPostId(postId);

        return commentDto;
    }
    //http://localhost:8080/api/posts/1/comments/2
    @GetMapping("/posts/{postId}/comments/{commentId}")
 public ResponseEntity<CommentDto> getCommentByid(@PathVariable("postId") long postId,@PathVariable("commentId") long commentId){
    CommentDto dto = commentService.getCommentById(postId, commentId);
    return new ResponseEntity<> (dto, HttpStatus.OK);
}
@PutMapping("/posts/{postId}/comments/{id}")
public ResponseEntity<CommentDto> updateCommentById(@PathVariable("postId") long postId,@PathVariable("id") long id,
                                                    @RequestBody CommentDto commentDto) {
    CommentDto dto = commentService.updateCommentById(postId, id, commentDto);
    return new ResponseEntity<>(dto, HttpStatus.OK);

}
@DeleteMapping("/posts/{postId}/comments/{id}")
public ResponseEntity<String> deleteCommentById(@PathVariable("postId") long postId,
                                                @PathVariable("id") long id){
       commentService.deleteCommentById(postId,id);
       return new ResponseEntity<>("Comment is deleted",HttpStatus.OK);


}
}