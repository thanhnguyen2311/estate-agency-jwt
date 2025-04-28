package com.example.estateagencyrent.repository;


import com.example.estateagencyrent.entity.Comment;
import com.example.estateagencyrent.entity.House;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICommentRepository extends JpaRepository<Comment, Long> {
    void deleteAllByHouse(House house);
}
