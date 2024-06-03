package com.example.PhongTroPTITBE.service;

import com.example.PhongTroPTITBE.entity.Comment;
import com.example.PhongTroPTITBE.entity.Post;
import com.example.PhongTroPTITBE.entity.User;
import com.example.PhongTroPTITBE.exception.CommentException;
import com.example.PhongTroPTITBE.exception.PostException;
import com.example.PhongTroPTITBE.model.CommentDTO;
import com.example.PhongTroPTITBE.model.UserDTO;
import com.example.PhongTroPTITBE.repository.CommentRepository;
import com.example.PhongTroPTITBE.repository.PostRepository;
import com.example.PhongTroPTITBE.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.stereotype.Service;

import java.nio.file.AccessDeniedException;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    CommentRepository commentRepository;

    @Autowired
    PostRepository postRepository;

    @Autowired
    UserRepository userRepository;

    ModelMapper modelMapper = new ModelMapper();

    @Override
    public CommentDTO createComment(CommentDTO commentDTO, String email) {
        try {
            Optional<Post> post = postRepository.findById(commentDTO.getIdPost());
            if (post.isPresent()) {
                Comment comment;
                comment = modelMapper.map(commentDTO, Comment.class);
                comment.setLastUpdate(LocalDateTime.now());
                Optional<User> user = userRepository.findByEmail(email);
                comment.setUser(user.get());
                commentRepository.save(comment);
                commentDTO = modelMapper.map(comment, CommentDTO.class);
                commentDTO.setUserDTO(modelMapper.map(comment.getUser(), UserDTO.class));
                return commentDTO;
            } else
                throw new PostException("Không tồn tại post id " + commentDTO.getIdPost());
        } catch (Exception e) {
            throw new CommentException("Xảy ra lỗi khi thêm bình luận ", e);
        }
    }

    @Override
    public CommentDTO updateComment(Long id, CommentDTO commentDTO, String email) {
        try {
            Optional<Comment> comment = commentRepository.findById(id);
            if (!comment.isPresent())
                throw new CommentException("Comment id " + id + "không tồn tại!!!");
            else {
                if (comment.get().getUser().getEmail().equals(email)) {
                    commentDTO.setId(id);
                    comment.get().setContent(commentDTO.getContent());
                    comment.get().setRate(commentDTO.getRate());
                    commentRepository.save(comment.get());
                    commentDTO = modelMapper.map(comment.get(), CommentDTO.class);
                    return commentDTO;
                } else {
                    throw new AccessDeniedException("Access dined");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void deleteComment(Long id) {
        try {
            Optional<Comment> comment = commentRepository.findById(id);
            if (!comment.isPresent())
                throw new CommentException("Comment id " + id + "không tồn tại!!!");
            else {
                commentRepository.delete(comment.get());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Page<CommentDTO> getCommentByIdPost(Long idPost, int page) {

        Optional<Post> post = postRepository.findById(idPost);
        if (post.isPresent()) {
            Page<Comment> commentPage = commentRepository.findAllByPost(post.get(), PageRequest.of(page, 10, Sort.by("lastUpdate").descending()));
            Page<CommentDTO> commentDTOPage = commentPage.map(comment -> {
                CommentDTO commentDTO = modelMapper.map(comment, CommentDTO.class);
                commentDTO.setUserDTO(modelMapper.map(comment.getUser(), UserDTO.class));
                return commentDTO;
            });

            return commentDTOPage;
        } else {
            throw new PostException("Post " + idPost + " không tồn tại");
        }

    }
}

