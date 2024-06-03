//package com.example.PhongTroPTITBE.service;
//
//import com.example.PhongTroPTITBE.config.NotificationEvent;
//import com.example.PhongTroPTITBE.entity.*;
//import com.example.PhongTroPTITBE.exception.PostException;
//import com.example.PhongTroPTITBE.exception.UserException;
//import com.example.PhongTroPTITBE.model.*;
//import com.example.PhongTroPTITBE.repository.*;
//import org.modelmapper.ModelMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.ApplicationEventPublisher;
//import org.springframework.data.domain.*;
//import org.springframework.data.jpa.domain.Specification;
//import org.springframework.security.access.AccessDeniedException;
//import org.springframework.security.oauth2.provider.OAuth2Authentication;
//import org.springframework.stereotype.Service;
//
//import java.time.LocalDateTime;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class PostServiceImpl implements PostService {
//
//    @Autowired
//    PostRepository postRepository;
//
//    @Autowired
//    UserRepository userRepository;
//
//    @Autowired
//    DistrictRepository districtRepository;
//
//    @Autowired
//    ImageServiceImpl imageService;
//
//    @Autowired
//    ActionServiceImpl actionService;
//
//    @Autowired
//    CriteriaRepository criteriaRepository;
//
//    @Autowired
//    NotificationServiceImpl notificationService;
//
//    @Autowired
//    private ApplicationEventPublisher applicationEventPublisher;
//
//    ModelMapper modelMapper = new ModelMapper();
//
//    // HasAuthorize = "KDV, Admin"
//    @Override
//    public Page<PostDTO> getAllPost(Pageable page) {
//        try {
//            Page<PostDTO> posts = postRepository.findAll(page)
//                    .map(this::postToPostDTO);
//
//            return posts;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    @Override
//    public Page<PostDTO> getPostByApproved(boolean bool, int page) {
//        Page<Post> postPage;
//        if (bool == true) {
//            postPage = postRepository.findAllByApprovedAndNotApprovedAndDel(true, false, false,
//                    PageRequest.of(page, 12, Sort.by("createAt").descending()));
//        } else {
//            postPage = postRepository.findAllByApprovedAndNotApproved(false, true,
//                    PageRequest.of(page, 12, Sort.by("createAt").descending()));
//        }
//        Page<PostDTO> postDTOPage = postPage.map(post -> {
//            PostDTO postDTO = postToPostDTO(post);
//            return postDTO;
//        });
//        return postDTOPage;
//    }
//
//    @Override
//    public Page<PostDTO> getPostByIdUser(long idUser, int page, OAuth2Authentication auth) {
//        Optional<User> user = userRepository.findById(idUser);
//        if (user.isPresent()) {
//            if (auth == null || !user.get().getEmail().equals(auth.getName())) {
//                return postRepository.findAllByUser_EmailAndDelAndApproved(user.get().getEmail(),
//                        false, true, PageRequest.of(page, 10, Sort.by("createAt").descending()))
//                        .map(this::postToPostDTO);
//            } else {
//                return postRepository.findByUser(user.get(), PageRequest.of(page, 10, Sort.by("createAt").descending()))
//                        .map(this::postToPostDTO);
//            }
//        } else
//            throw new UserException("Không tìm thấy user id " + idUser);
//    }
//
//    @Override
//    public Page<PostDTO> getPostByUserEmail(String email, Pageable page) {
//        Optional<User> user = userRepository.findByEmail(email);
//        if (user.isPresent()) {
//            return postRepository.findAllByUser_EmailAndDelAndApproved(email, false, true, page)
//                    .map(this::postToPostDTO);
//        } else
//            throw new UserException("Không tìm thấy user email" + email);
//    }
//
//    @Override
//    public PostDTO getPostById(Long id) {
////        try {
//        Optional<Post> post = postRepository.findPostById(id);
//        if (post.isPresent()) {
//            PostDTO postDTO = postToPostDTO(post.get());
//            List<CommentDTO> commentDTOS = new ArrayList<>();
//            List<String> images;
//            images = imageService.getImageByIdPost(id);
//            postDTO.setImageStrings(images);
//            postDTO.setCommentDTOS(commentDTOS);
//            postDTO.setUserDTO(modelMapper.map(post.get().getUser(), UserDTO.class));
//            postDTO.getUserDTO().setB64(null);
//            return postDTO;
//        } else
//            throw new PostException("Post id " + id + " không tồn tại");
////                logger.error("Post id " + id + " không tồn tại");
////        } catch (Exception e) {
////            e.printStackTrace();
////        }
//    }
//
//    @Override
//    public PostDTO createPost(PostDTO postDTO, String name) {
//        try {
//            Optional<User> user = userRepository.findByEmail(name);
//            if (user.isPresent()) {
//                //Gán value cho post
//                Post post;
//                post = modelMapper.map(postDTO, Post.class);
//                post.setCreateAt(LocalDateTime.now());
//                post.setLastUpdate(LocalDateTime.now());
//                post.setUser(user.get());
//                post.setDel(false);
//                post.setApproved(false);
//                post.setNotApproved(false);
//                //Gán value cho accomodation
//                Accomodation accomodation = modelMapper.map(postDTO.getAccomodationDTO(), Accomodation.class);
//                accomodation.setPost(post);
//                Optional<District> district = districtRepository.findById(postDTO.getAccomodationDTO().getIdDistrict());
//                accomodation.setDistrict(district.get());
//                post.setAccomodation(accomodation);
//                post.getAccomodation().setStatus(true);
//                postRepository.save(post);
//                actionService.createAction(post, user.get(), ActionName.CREATE);
//                postDTO = modelMapper.map(post, PostDTO.class);
//                postDTO.setAccomodationDTO(modelMapper.map(accomodation, AccomodationDTO.class));
//                return postDTO;
//            } else
//                throw new UserException("Không tìm thấy user id " + postDTO.getUserDTO().getId());
////                logger.error("Không tìm thấy user " + postDTO.getUsername());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    @Override
//    public PostDTO updatePost(Long id, PostDTO postDTO, String name) {
//        try {
//            Optional<Post> post = postRepository.findById(id);
//            if (post.isPresent()) {
//                if (post.get().getUser().getEmail().equals(name)) {
//                    postDTO.setId(id);
//                    postDTO.getAccomodationDTO().setId(post.get().getAccomodation().getId());
//                    postDTO.setCreateAt(post.get().getCreateAt());
//                    //Tạo post mới từ postDTO
//                    post = Optional.of(modelMapper.map(postDTO, Post.class));
//                    Optional<User> user = userRepository.findById(postDTO.getUserDTO().getId());
//                    post.get().setUser(user.get());
//                    //Tạo accomodation từ postDTO
//                    Accomodation accomodation = modelMapper.map(postDTO.getAccomodationDTO(), Accomodation.class);
//                    accomodation.setPost(post.get());
//                    accomodation.setId(postDTO.getAccomodationDTO().getId());
//                    Optional<District> district = districtRepository.findById(postDTO.getAccomodationDTO().getIdDistrict());
//                    accomodation.setDistrict(district.get());
//                    post.get().setLastUpdate(LocalDateTime.now());
//                    post.get().setAccomodation(accomodation);
//
//                    postRepository.save(post.get());
//                    postDTO = modelMapper.map(post.get(), PostDTO.class);
//                    postDTO.setAccomodationDTO(modelMapper.map(post.get().getAccomodation(), AccomodationDTO.class));
//                    postDTO.setUserDTO(modelMapper.map(post.get().getUser(), UserDTO.class));
//
//                    return postDTO;
//                } else {
//                    throw new AccessDeniedException("Access dined");
//                }
//            } else
//                throw new PostException("Không tìm thấy post id " + id);
////                logger.error("Không tìm thấy post id " + id);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    @Override
//    public PostDTO hidePost(Long id) {
//        try {
//            Optional<Post> post = postRepository.findById(id);
//            if (post.isPresent()) {
//                post.get().setDel(true);
//                postRepository.save(post.get());
//                PostDTO postDTO = modelMapper.map(post.get(), PostDTO.class);
//
//                return postDTO;
//            } else
//                throw new PostException("Không tìm thấy post id " + id);
////                logger.error("Không tìm thấy post id " + id);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    @Override
//    public Page<PostDTO> getMotelPost(boolean bool, int page, int sort) {
//        try {
//            Page<Post> postPage = null;
//            //Get Motel
//            if (bool == true) {
//                if (sort == 1)
//                    postPage = postRepository.findAllByApprovedAndNotApprovedAndAndAccomodation_MotelAndDel(true, false,
//                            true, PageRequest.of(page, 10, Sort.by("accomodation.price").ascending()), false);
//                if (sort == 2)
//                    postPage = postRepository.findAllByApprovedAndNotApprovedAndAndAccomodation_MotelAndDel(true, false,
//                            true, PageRequest.of(page, 10, Sort.by("accomodation.price").descending()), false);
//                if (sort == 3)
//                    postPage = postRepository.findAllByApprovedAndNotApprovedAndAndAccomodation_MotelAndDel(true, false,
//                            true, PageRequest.of(page, 10, Sort.by("accomodation.acreage").ascending()), false);
//                if (sort == 4)
//                    postPage = postRepository.findAllByApprovedAndNotApprovedAndAndAccomodation_MotelAndDel(true, false,
//                            true, PageRequest.of(page, 10, Sort.by("accomodation.acreage").descending()), false);
//                if (sort == 5)
//                    postPage = postRepository.findAllByApprovedAndNotApprovedAndAndAccomodation_MotelAndDel(true, false,
//                            true, PageRequest.of(page, 10, Sort.by("createAt").descending()), false);
//            } else { //Get House
//                if (sort == 1)
//                    postPage = postRepository.findAllByApprovedAndNotApprovedAndAndAccomodation_MotelAndDel(true, false,
//                            false, PageRequest.of(page, 10, Sort.by("accomodation.price").ascending()), false);
//                if (sort == 2)
//                    postPage = postRepository.findAllByApprovedAndNotApprovedAndAndAccomodation_MotelAndDel(true, false,
//                            false, PageRequest.of(page, 10, Sort.by("accomodation.price").descending()), false);
//                if (sort == 3)
//                    postPage = postRepository.findAllByApprovedAndNotApprovedAndAndAccomodation_MotelAndDel(true, false,
//                            false, PageRequest.of(page, 10, Sort.by("accomodation.acreage").ascending()), false);
//                if (sort == 4)
//                    postPage = postRepository.findAllByApprovedAndNotApprovedAndAndAccomodation_MotelAndDel(true, false,
//                            false, PageRequest.of(page, 10, Sort.by("accomodation.acreage").descending()), false);
//                if (sort == 5)
//                    postPage = postRepository.findAllByApprovedAndNotApprovedAndAndAccomodation_MotelAndDel(true, false,
//                            false, PageRequest.of(page, 10, Sort.by("createAt").descending()), false);
//            }
//            Page<PostDTO> postDTOPage = postPage.map(post -> {
//                PostDTO postDTO = postToPostDTO(post);
//                return postDTO;
//            });
//            return postDTOPage;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    // HasAuthorize = "KDV, Admin"
//    @Override
//    public String deletePostByAdmin(Long id) {
//        try {
//            Optional<Post> post = postRepository.findById(id);
//            if (post.isPresent()) {
//                postRepository.delete(post.get());
//                return "Admin đã xóa post id " + id;
//            } else
//                throw new PostException("Không tìm thấy post id " + id);
////                logger.error("Không tìm thấy post id " + id);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    @Override
//    public PostDTO ApprovePost(Long idPost, String usernamApprover, boolean isApprove) {
//        try {
//            Optional<Post> post = postRepository.findById(idPost);
//            if (!post.isPresent())
//                throw new PostException("Không tìm thấy post id " + idPost);
//            if (isApprove) {
//                Optional<User> user = userRepository.findByEmail(usernamApprover);
//                post.get().setApproved(true);
//                post.get().setNotApproved(false);
//                actionService.createAction(post.get(), user.get(), ActionName.APPROVE);
//                applicationEventPublisher.publishEvent(new NotificationEvent(this, post.get()));
////                createNoti(post.get());
//            } else {
//                Optional<User> user = userRepository.findByEmail(usernamApprover);
//                post.get().setNotApproved(true);
//                post.get().setApproved(false);
//                actionService.createAction(post.get(), user.get(), ActionName.BLOCK);
//                applicationEventPublisher.publishEvent(new NotificationEvent(this, post.get()));
//            }
//            postRepository.save(post.get());
//            PostDTO postDTO = modelMapper.map(post.get(), PostDTO.class);
//
//            return postDTO;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    @Override
//    public Page<PostDTO> searchPost(SearchDTO searchForm, int page, int sort) {
//        try {
//            Specification<Post> spec = new PostSpecification(searchForm);
//            Page<Post> postPage = null;
//            if (sort == 1)
//                postPage = postRepository.findAll(spec, PageRequest.of(page, 10, Sort.by("accomodation.price").ascending()));
//            if (sort == 2)
//                postPage = postRepository.findAll(spec, PageRequest.of(page, 10, Sort.by("accomodation.price").descending()));
//            if (sort == 3)
//                postPage = postRepository.findAll(spec, PageRequest.of(page, 10, Sort.by("accomodation.acreage").ascending()));
//            if (sort == 4)
//                postPage = postRepository.findAll(spec, PageRequest.of(page, 10, Sort.by("accomodation.acreage").descending()));
//            if (sort == 5)
//                postPage = postRepository.findAll(spec, PageRequest.of(page, 10, Sort.by("createAt").descending()));
//            Page<PostDTO> postDTOPage = postPage.map(post -> {
//                PostDTO postDTO = postToPostDTO(post);
//                return postDTO;
//            });
//
//            return postDTOPage;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    @Override
//    public Page<PostDTO> searchPostByMaps(SearchDTO searchForm, int page, int sort) {
//        try {
//            Specification<Post> spec = new PostSpecification(searchForm);
//            List<Post> posts = new ArrayList<>();
//            if (sort == 1)
//                posts = postRepository.findAll(spec, Sort.by("accomodation.price").ascending());
//            if (sort == 2)
//                posts = postRepository.findAll(spec, Sort.by("accomodation.price").descending());
//            if (sort == 3)
//                posts = postRepository.findAll(spec, Sort.by("accomodation.acreage").ascending());
//            if (sort == 4)
//                posts = postRepository.findAll(spec, Sort.by("accomodation.acreage").descending());
//            if (sort == 5)
//                posts = postRepository.findAll(spec, Sort.by("createAt").descending());
//            List<PostDTO> postDTOS = new ArrayList<>();
//            Page<PostDTO> postDTOPage = null;
//            PostDTO postDTO;
//            List<String> images;
//            for (Post post : posts) {
//                if (distance(post.getAccomodation().getxCoordinate(), post.getAccomodation().getyCoordinate(), searchForm.getxCoordinate(), searchForm.getyCoordinate())
//                        < searchForm.getRadius()) {
//                    postDTO = modelMapper.map(post, PostDTO.class);
//                    postDTO.setAccomodationDTO(modelMapper.map(post.getAccomodation(), AccomodationDTO.class));
//                    images = imageService.getImageByIdPost(post.getId());
//                    postDTO.setImageStrings(images);
//                    postDTOS.add(postDTO);
//                }
//            }
//            Pageable pageable = PageRequest.of(page, 10);
//
//            int start = (int) pageable.getOffset();
//            int end = (start + pageable.getPageSize()) > postDTOS.size() ? postDTOS.size() : (start + PageRequest.of(page, 10).getPageSize());
//            if (start > end) {
//                int p = Math.round(postDTOS.size() / 10);
//                page = p;
//                pageable = PageRequest.of(page, 10);
//                start = (int) pageable.getOffset();
//                end = (start + pageable.getPageSize()) > postDTOS.size() ? postDTOS.size() : (start + PageRequest.of(page, 10).getPageSize());
//                postDTOPage = new PageImpl<>(postDTOS.subList(start, end), pageable, postDTOS.size());
//            } else {
//                postDTOPage = new PageImpl<>(postDTOS.subList(start, end), pageable, postDTOS.size());
//            }
//
//            return postDTOPage;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    @Override
//    public Page<PostDTO> getPostWaitingApprove(int page) {
//        Page<Post> postPage = postRepository.findAllByApprovedAndNotApproved(false, false,
//                PageRequest.of(page, 10, Sort.by("createAt").ascending()));
//        Page<PostDTO> postDTOPage = postPage.map(this::postToPostDTO);
//        return postDTOPage;
//    }
//
//    public PostDTO postToPostDTO(Post post) {
//        PostDTO postDTO = modelMapper.map(post, PostDTO.class);
//        postDTO.setAccomodationDTO(modelMapper.map(post.getAccomodation(), AccomodationDTO.class));
////        postDTO.setUserDTO(modelMapper.map(post.getUser(), UserDTO.class));
//        List<String> images = imageService.getImageByIdPost(post.getId());
//        postDTO.setImageStrings(images);
//        return postDTO;
//    }
//
//    //Haversine formula
//    public double distance(double lat1, double lng1, double lat2, double lng2) {
//        int r = 6371; // average radius of the earth in km
//        double dLat = Math.toRadians(lat2 - lat1);
//        double dLon = Math.toRadians(lng2 - lng1);
//        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
//                Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
//                        * Math.sin(dLon / 2) * Math.sin(dLon / 2);
//        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
//        double d = r * c;
//        d = Math.pow(d, 2);
//        return d;
//    }
//}
//
