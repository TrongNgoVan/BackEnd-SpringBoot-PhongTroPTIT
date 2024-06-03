//package com.example.PhongTroPTITBE.controller;
//
//import com.example.PhongTroPTITBE.model.PostDTO;
//import com.example.PhongTroPTITBE.model.SearchDTO;
//import com.example.PhongTroPTITBE.service.PostServiceImpl;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.web.PageableDefault;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.security.oauth2.provider.OAuth2Authentication;
//import org.springframework.web.bind.annotation.*;
//
//
//@RestController
//@RequestMapping("/api")
//@Api(value = "Tìm nhà trọ", description = "Quản lý tin đăng")
//public class PostController {
//
//    @Autowired
//    PostServiceImpl postService;
//
//    @ApiOperation(value = "Lấy danh sách tin đăng tìm kiếm theo tiêu chí")
//    @GetMapping("/posts/search")
//    public Page<PostDTO> searchPost(SearchDTO searchForm, @RequestParam int page, @RequestParam int sort){
//        searchForm.setPriceStart(searchForm.getPriceStart()*1000000);
//        searchForm.setPriceEnd(searchForm.getPriceEnd()*1000000);
//        return postService.searchPost(searchForm, page, sort);
//    }
//
//    @ApiOperation(value = "Lấy danh sách tin đăng tìm kiếm xung quanh một vị trí")
//    @GetMapping("/posts/searchbymaps")
//    public Page<PostDTO> searchPostMaps(SearchDTO searchForm, @RequestParam int page, @RequestParam int sort){
//        searchForm.setPriceStart(searchForm.getPriceStart()*1000000);
//        searchForm.setPriceEnd(searchForm.getPriceEnd()*1000000);
////        searchForm.setRadius(searchForm.getRadius()/1000);
//        return postService.searchPostByMaps(searchForm, page, sort);
//    }
//
//    @ApiOperation(value = "Lấy tất cả tin đăng")
//    @GetMapping("/posts")
//    public Page<PostDTO> getAllPost(@PageableDefault(page = 0, size = 12) Pageable  page) {
//        return postService.getAllPost(page);
//    }
//
//    @ApiOperation(value = "Lấy danh sách tin đăng đã được duyệt")
//    @GetMapping("/posts/approved/true")
//    public Page<PostDTO> getAllPostApproved(@RequestParam int page) {
//        return postService.getPostByApproved(true, page);
//    }
//
//    @ApiOperation(value = "Lấy danh sách tin đăng đã bị khóa")
//    @GetMapping("/posts/approved/false")
//    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_MODERATOR')")
//    public Page<PostDTO> getAllPostNotApproved(@RequestParam int page) {
//        return postService.getPostByApproved(false, page);
//    }
//
//    @ApiOperation(value = "Nếu bool = true lấy danh sách tin nhà trọ, ngược lại lấy danh sách tin nhà nguyên căn")
//    @GetMapping("/posts/motel/{bool}")
//    public Page<PostDTO> getMotelPost(@PathVariable boolean bool, @RequestParam int page, @RequestParam int sort) {
//        return postService.getMotelPost(bool, page, sort);
//    }
//
//    @ApiOperation(value = "Lấy danh sách tin đăng chờ duyệt")
//    @GetMapping("/posts/waiting")
//    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_MODERATOR')")
//    public Page<PostDTO> getPostWaitingApprove(@RequestParam int page) {
//        return postService.getPostWaitingApprove(page);
//    }
//
//    @ApiOperation(value = "Lấy danh sách tin đăng của một người dùng")
//    @GetMapping("/post/user/{idUser}")
//    public Page<PostDTO> getPostByIdUser(@PathVariable long idUser, @RequestParam int page, OAuth2Authentication auth) {
//        return postService.getPostByIdUser(idUser, page, auth);
//    }
//
//    @ApiOperation(value = "Lấy thông tin của một tin đăng")
//    @GetMapping("/post/{id}")
//    public PostDTO getPostById(@PathVariable Long id) {
//        return postService.getPostById(id);
//    }
//
//    @ApiOperation(value = "Đăng tin mới")
//    @PostMapping("/post")
//    @PreAuthorize("#oauth2.hasAnyScope('read')")
//    public PostDTO createPost(@RequestBody PostDTO postDTO, OAuth2Authentication auth) {
//        return postService.createPost(postDTO, auth.getName());
//    }
//
//    @ApiOperation(value = "Duyệt/Khóa tin đăng")
//    @PutMapping("/post/{id}/approve/{bool}")
//    @PreAuthorize("#oauth2.hasAnyScope('read')")
//    public PostDTO ApprovePostAndLogging(@PathVariable Long id, @PathVariable boolean bool, OAuth2Authentication auth) {
//        return postService.ApprovePost(id, auth.getName(), bool);
//    }
//
//    @ApiOperation(value = "Cập nhật một tin đăng")
//    @PutMapping("/post/{id}")
//    @PreAuthorize("#oauth2.hasAnyScope('read')")
//    public PostDTO updatePost(@PathVariable Long id, @RequestBody PostDTO postDTO, OAuth2Authentication auth) {
//        return postService.updatePost(id, postDTO, auth.getName());
//    }
//
//    @ApiOperation(value = "Ẩn một tin đăng")
//    @PutMapping("/post/hide/{id}")
//    @PreAuthorize("#oauth2.hasAnyScope('read')")
//    public PostDTO hidePost(@PathVariable Long id) {
//        return postService.hidePost(id);
//    }
//
//    @ApiOperation(value = "Xóa một tin đăng")
//    @DeleteMapping("/post/{id}")
//    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_MODERATOR')")
//    public String deletePostByAdmin(@PathVariable Long id) {
//        return postService.deletePostByAdmin(id);
//    }
//
//}
