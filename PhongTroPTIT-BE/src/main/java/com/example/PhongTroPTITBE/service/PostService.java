package com.example.PhongTroPTITBE.service;

import com.example.PhongTroPTITBE.model.PostDTO;
import com.example.PhongTroPTITBE.model.SearchDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.oauth2.provider.OAuth2Authentication;

import java.util.List;

public interface PostService {
    Page<PostDTO> getAllPost(Pageable page);

//    List<PostDTO> getPostByApproved(boolean bool);

    Page<PostDTO> getPostByApproved(boolean bool, int page);

    Page<PostDTO> getPostByIdUser(long idUser, int page, OAuth2Authentication auth);

    Page<PostDTO> getPostByUserEmail(String email, Pageable page);

    PostDTO getPostById(Long id);

    PostDTO createPost(PostDTO postDTO, String name);

    PostDTO updatePost(Long id, PostDTO postDTO, String name);

    PostDTO hidePost(Long id);

    Page<PostDTO> getMotelPost(boolean bool, int page, int sort);

    String deletePostByAdmin(Long id);

//    PostDTO ApprovePost(Long idPost, Long idUserApprove, boolean isApprove);

    PostDTO ApprovePost(Long idPost, String usernameApprover, boolean isApprove);

//    List<PostDTO> searchPost(SearchDTO searchForm);

    Page<PostDTO> searchPost(SearchDTO searchForm, int page, int sort);

    Page<PostDTO> searchPostByMaps(SearchDTO searchForm, int page, int sort);

    Page<PostDTO> getPostWaitingApprove( int page);
}
