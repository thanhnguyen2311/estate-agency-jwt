package com.example.estateagencyrent.service;

import com.example.estateagencyrent.entity.Comment;
import com.example.estateagencyrent.entity.House;
import com.example.estateagencyrent.repository.ICommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CommentService implements ICommentService {
    @Autowired
    private ICommentRepository commentRepository;

    @Override
    public Iterable<Comment> findAll() {
        return commentRepository.findAll();
    }

    @Override
    public Optional<Comment> findById(Long id) {
        return commentRepository.findById(id);
    }

    @Override
    public House save(Comment comment) {
        commentRepository.save(comment);
        return null;
    }

    @Override
    public void remove(Long id) {
       commentRepository.deleteById(id);
    }
}
