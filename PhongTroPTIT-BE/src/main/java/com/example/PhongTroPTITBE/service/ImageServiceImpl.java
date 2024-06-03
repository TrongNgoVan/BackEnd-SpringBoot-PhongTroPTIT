package com.example.PhongTroPTITBE.service;

import com.example.PhongTroPTITBE.entity.Image;
import com.example.PhongTroPTITBE.entity.Post;
import com.example.PhongTroPTITBE.exception.ImageException;
import com.example.PhongTroPTITBE.exception.PostException;
import com.example.PhongTroPTITBE.model.ImageDTO;
import com.example.PhongTroPTITBE.model.PostDTO;
import com.example.PhongTroPTITBE.repository.ImageRepository;
import com.example.PhongTroPTITBE.repository.PostRepository;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

@Service
public class ImageServiceImpl implements ImageService {
    @Autowired
    ImageRepository imageRepository;

    @Autowired
    PostRepository postRepository;

    ModelMapper modelMapper = new ModelMapper();

    @Override
    public ImageDTO uploadFile(Long idPost, MultipartFile file) {
        Optional<Post> post = postRepository.findById(idPost);
        if (post.isPresent()) {
            Image image = storeImage(idPost, file);

            String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                    .path("/api/image/")
                    .path(image.getId())
                    .toUriString();
            return new ImageDTO(image.getId(), image.getFileName(), file.getContentType(), fileDownloadUri, idPost);
        } else {
            throw new PostException("Không tìm thấy post id " + idPost);
        }
    }

    @Override
    public Image storeImage(Long idPost, MultipartFile file) {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        try {
            // Check if the file's name contains invalid characters
            if (fileName.contains("..")) {
                throw new ImageException("Tệp có đường dẫn không hợp lệ" + fileName);
            }
            Optional<Post> post = postRepository.findById(idPost);
            Image image = new Image(fileName, file.getContentType(), file.getBytes(), post.get());

            return imageRepository.save(image);
        } catch (IOException ex) {
            throw new ImageException("Xảy ra lỗi trong quá trình lưu ảnh " + fileName + ".!", ex);
        }
    }

    @Override
    public Image getImage(String imageId) {
        return imageRepository.findById(imageId)
                .orElseThrow(() -> new ImageException("Không tim thấy ảnh có id " + imageId));
    }

    @Override
    public List<String> getImageByIdPost(Long idPost) {
        List<String> Uri = new ArrayList<>();
        Optional<Post> post = postRepository.findById(idPost);
        List<Image> images = imageRepository.findImageByPost(post.get());
        for (Image image : images)
            Uri.add(ServletUriComponentsBuilder.fromCurrentContextPath()
                    .path("/api/image/")
                    .path(image.getId())
                    .toUriString());
        return Uri;
    }

    @Override
    public void deleteAllImage(Long idPost) {
        Optional<Post> post = postRepository.findById(idPost);
        if (post.isPresent()) {
            List<Image> images = imageRepository.findImageByPost(post.get());
            for (Image image : images) {
                imageRepository.delete(image);
            }
        } else {
            throw new PostException("Không tìm thấy post id " + idPost);
        }
    }

    @Override
    public List<ImageDTO> getImageDTOByIdPost(Long idPost) {
        Optional<Post> post = postRepository.findById(idPost);
        if (post.isPresent()) {
            List<Image> images = imageRepository.findImageByPost(post.get());
            List<ImageDTO> imageDTOS = new ArrayList<>();
            for (Image image : images) {
                ImageDTO imageDTO = modelMapper.map(image, ImageDTO.class);
                imageDTO.setUri(Base64.getEncoder().encodeToString(image.getData()));
                imageDTOS.add(imageDTO);
            }
            return imageDTOS;
        } else {
            throw new PostException("Không tìm thấy post id " + idPost);
        }
    }
}
