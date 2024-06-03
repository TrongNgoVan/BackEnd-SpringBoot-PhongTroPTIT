package com.example.PhongTroPTITBE.repository;

import com.example.PhongTroPTITBE.entity.Image;
import com.example.PhongTroPTITBE.entity.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImageRepository extends JpaRepository<Image, String> {
    List<Image> findImageByPost(Post post);
}
