package com.example.estateagencyrent.controller;

import com.example.estateagencyrent.entity.Comment;
import com.example.estateagencyrent.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/estate/comment")
public class CommentController {
    @Autowired
    private ICommentService commentService;

    @GetMapping
    public ResponseEntity<Iterable<Comment>> findAll() {
        return new ResponseEntity<>(commentService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Comment> create(@RequestBody Comment comment) {
        commentService.save(comment);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
