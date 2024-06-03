package com.example.PhongTroPTITBE.repository;

import com.example.PhongTroPTITBE.entity.Post;
import com.example.PhongTroPTITBE.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<Post, Long>, JpaSpecificationExecutor<Post> {
    Page<Post> findByUser(User user, Pageable pageable);

    Optional<Post> findPostById(Long id);

    Page<Post> findAllByApprovedAndNotApprovedAndDel(boolean approved, boolean notApproved, boolean del, Pageable pageable);

    Page<Post> findAllByApprovedAndNotApproved(boolean approved, boolean notApproved, Pageable pageable);

    Page<Post> findAllByApprovedAndNotApprovedAndAndAccomodation_MotelAndDel(boolean approved, boolean notApproved, boolean motel, Pageable pageable, boolean del);

    Page<Post> findAllByUser_EmailAndDelAndApproved(String email, boolean del, boolean approved, Pageable page);
}

