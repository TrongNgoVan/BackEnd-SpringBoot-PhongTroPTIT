package com.example.PhongTroPTITBE.repository;

import com.example.PhongTroPTITBE.entity.Comment;
import com.example.PhongTroPTITBE.entity.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findAllByPost(Post post);

    Page<Comment> findAllByPost(Post post, Pageable pageable);
}
