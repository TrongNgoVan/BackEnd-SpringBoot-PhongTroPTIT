package com.example.PhongTroPTITBE.service;

import com.example.PhongTroPTITBE.entity.Image;
import com.example.PhongTroPTITBE.model.ImageDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ImageService {
    ImageDTO uploadFile(Long idPost, MultipartFile file);

    Image storeImage(Long idPost, MultipartFile file);

    Image getImage(String imageId);

    List<String> getImageByIdPost(Long idPost);

    void deleteAllImage(Long idPost);

    List<ImageDTO> getImageDTOByIdPost(Long idPost);
}

