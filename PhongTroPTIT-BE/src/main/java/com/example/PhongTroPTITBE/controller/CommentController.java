package com.example.PhongTroPTITBE.controller;

import com.example.PhongTroPTITBE.entity.Comment;
import com.example.PhongTroPTITBE.model.CommentDTO;
import com.example.PhongTroPTITBE.service.CommentServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@Api(value = "Tìm nhà trọ", description = "Quản lý bình luận")
public class CommentController {
    @Autowired
    CommentServiceImpl commentService;

    @ApiOperation(value = "Lấy các bình luận của một tin đăng")
    @GetMapping("/comments/post/{id}")
    public Page<CommentDTO> getComment(@PathVariable Long id, @RequestParam("page") int page) {
        return commentService.getCommentByIdPost(id, page);
    }

    @ApiOperation(value = "Đăng một bình luận mới")
    @PostMapping("/comment/post")
    @PreAuthorize("#oauth2.hasAnyScope('read')")
    public CommentDTO createComment(@RequestBody CommentDTO commentDTO, OAuth2Authentication auth) {
        return commentService.createComment(commentDTO, auth.getName());
    }

    @ApiOperation(value = "Chỉnh sửa một bình luận")
    @PutMapping("/comment/{id}")
    @PreAuthorize("#oauth2.hasAnyScope('read')")
    public CommentDTO updateComment(@PathVariable Long id, @RequestBody CommentDTO commentDTO, OAuth2Authentication auth) {
        return commentService.updateComment(id, commentDTO, auth.getName());
    }

    @ApiOperation(value = "Xóa một bình luận")
    @DeleteMapping("/comment/{id}")
    @PreAuthorize("#oauth2.hasAnyScope('read')")
    public void deleteComment(@PathVariable Long id) {
        commentService.deleteComment(id);
    }
}