package com.example.PhongTroPTITBE.service;

import com.example.PhongTroPTITBE.entity.Action;
import com.example.PhongTroPTITBE.entity.ActionName;
import com.example.PhongTroPTITBE.entity.Post;
import com.example.PhongTroPTITBE.entity.User;
import com.example.PhongTroPTITBE.model.ActionDTO;
import com.example.PhongTroPTITBE.repository.ActionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ActionServiceImpl implements ActionService {

    @Autowired
    ActionRepository actionRepository;

    @Override
    public void createAction(Post post, User user, ActionName actionName) {
        Action action = new Action(user, post, actionName, LocalDateTime.now());
        actionRepository.save(action);
    }

    @Override
    public Page<ActionDTO> getAction(int page) {
        Page<Action> actionPage = actionRepository.findAll(PageRequest.of(page, 20, Sort.by("time").descending()));
        Page<ActionDTO> actionDTOPage = actionPage.map(action ->
                new ActionDTO(action.getId(), action.getUser().getFullName(), action.getAction(), action.getPost().getTitle(), action.getPost().getId(), action.getTime())
        );
        return actionDTOPage;
    }

    @Override
    public Page<ActionDTO> getActionByApprover(Long id, int page) {
        Page<Action> actionPage = actionRepository.findAllByUser_Id(id, PageRequest.of(page, 20, Sort.by("time").descending()));
        Page<ActionDTO> actionDTOPage = actionPage.map(action ->
                new ActionDTO(action.getId(), action.getUser().getFullName(), action.getAction(), action.getPost().getTitle(), action.getPost().getId(), action.getTime())
        );
        return actionDTOPage;
    }
}

