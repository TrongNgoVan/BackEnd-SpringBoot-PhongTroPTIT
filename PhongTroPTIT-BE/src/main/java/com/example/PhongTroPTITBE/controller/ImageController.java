package com.example.PhongTroPTITBE.controller;

import com.example.PhongTroPTITBE.entity.Image;
import com.example.PhongTroPTITBE.model.ImageDTO;
import com.example.PhongTroPTITBE.service.ImageServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
@Api(value = "Tìm nhà trọ", description = "Quản lý hình ảnh")
public class ImageController {
    @Autowired
    private ImageServiceImpl imageService;

    @ApiOperation(value = "Upload 1 hình ảnh cho một tin đăng")
    @PostMapping("/uploadImage/post/{idPost}")
    public ImageDTO uploadFile(@PathVariable Long idPost, @RequestParam("file") MultipartFile file) {
        return imageService.uploadFile(idPost, file);
    }

    @ApiOperation(value = "Delete hình ảnh một tin đăng")
    @DeleteMapping("/deleteImage/post/{idPost}")
    public void deleteFile(@PathVariable Long idPost) {
        imageService.deleteAllImage(idPost);
    }

    @ApiOperation(value = "Upload nhiều hình ảnh cho một tin đăng")
    @PostMapping("/uploadMultipleFiles/post/{idPost}")
    @PreAuthorize("#oauth2.hasAnyScope('read')")
    public List<ImageDTO> uploadMultipleFiles(@PathVariable Long idPost, @RequestParam("files") MultipartFile[] files) {
        return Arrays.asList(files)
                .stream()
                .map(file -> uploadFile(idPost, file))
                .collect(Collectors.toList());
    }

    @ApiOperation(value = "Lấy danh sách hình ảnh của một tin đăng khi chỉnh sửa tin đăng")
    @GetMapping("/imageByte/post/{idPost}")
    public List<ImageDTO> getImageDTOByIdPost(@PathVariable Long idPost) {
        return imageService.getImageDTOByIdPost(idPost);
    }

    @ApiOperation(value = "Render 1 ảnh thành link")
    @GetMapping("/image/{fileId}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileId) {
        // Load file from database
        Image image = imageService.getImage(fileId);

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(image.getFileType()))
//                .header("attachment; filename=\"" + image.getFileName() + "\"")
                .body(new ByteArrayResource(image.getData()));
    }
    @ApiOperation(value = "Lấy danh sách hình ảnh của một tin đăng khi xem chi tiết tin đăng")
    @GetMapping("/image/post/{idPost}")
    public List<String> getImageByIdPost(@PathVariable Long idPost) {
        return imageService.getImageByIdPost(idPost);
    }
}
