package com.example.PhongTroPTITBE.service;

import com.example.PhongTroPTITBE.entity.ActionName;
import com.example.PhongTroPTITBE.entity.Post;
import com.example.PhongTroPTITBE.entity.User;
import com.example.PhongTroPTITBE.model.ActionDTO;
import org.springframework.data.domain.Page;

public interface ActionService {
    void createAction(Post post, User user, ActionName actionName);

    Page<ActionDTO> getAction(int age);

    Page<ActionDTO> getActionByApprover(Long id, int page);
}
