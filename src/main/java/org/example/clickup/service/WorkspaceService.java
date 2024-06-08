package org.example.clickup.service;

import org.example.clickup.dto.WorkspaceDto;
import org.example.clickup.model.Result;
import org.example.clickup.model.User;
import org.example.clickup.model.Workspace;
import org.example.clickup.repository.UserRepo;
import org.example.clickup.repository.WorkspaceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WorkspaceService {

    @Autowired
    WorkspaceRepo workspaceRepo;

    @Autowired
    UserRepo userRepo;

    public List<Workspace> getAllWorkspaces() {
        return workspaceRepo.findAll();
    }

    public Workspace getWorkspaceById(Integer id) {
        return workspaceRepo.findById(id).get();
    }

    public Result createWorkspace(WorkspaceDto workspaceDto) {
        Workspace workspace = new Workspace();
        workspace.setName(workspaceDto.getName());
        workspace.setColor(workspaceDto.getColor());
        workspace.setAvatar_id(workspaceDto.getAvatar_id());
        workspace.setInitial_letter(workspaceDto.getInitial_letter());
        Optional<User> byId = userRepo.findById(workspaceDto.getOwner_id());
        if (byId.isPresent()) {
            User user = byId.get();
            workspace.setOwner_id(user);
        }
        workspaceRepo.save(workspace);
        return new Result(true, "Workspace created");
    }

    public Result updateWorkspace(WorkspaceDto workspaceDto, Integer id) {
        Optional<Workspace> byId = workspaceRepo.findById(id);
        if (byId.isPresent()) {
            Workspace workspace = byId.get();
            workspace.setName(workspaceDto.getName());
            workspace.setColor(workspaceDto.getColor());
            workspace.setAvatar_id(workspaceDto.getAvatar_id());
            workspace.setInitial_letter(workspaceDto.getInitial_letter());
            Optional<User> byId1 = userRepo.findById(workspaceDto.getOwner_id());
            if (byId1.isPresent()) {
                User user = byId1.get();
                workspace.setOwner_id(user);
            }
            workspaceRepo.save(workspace);
            return new Result(true, "Workspace updated");
        }
        return new Result(false, "Workspace not found");
    }

    public Result deleteWorkspace(Integer id) {
        workspaceRepo.deleteById(id);
        return new Result(true, "Workspace deleted");
    }

}
