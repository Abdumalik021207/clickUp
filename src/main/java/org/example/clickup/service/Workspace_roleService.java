package org.example.clickup.service;

import org.example.clickup.dto.Workspace_roleDto;
import org.example.clickup.model.Result;
import org.example.clickup.model.Workspace;
import org.example.clickup.model.Workspace_role;
import org.example.clickup.repository.WorkspaceRepo;
import org.example.clickup.repository.Workspace_roleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Workspace_roleService {

    @Autowired
    Workspace_roleRepo workspace_roleRepo;

    @Autowired
    WorkspaceRepo workspaceRepo;

    public List<Workspace_role> getAllWorkspaceRoles() {
        return workspace_roleRepo.findAll();
    }

    public Workspace_role getWorkspaceRoleById(Integer id) {
        return workspace_roleRepo.findById(id).get();
    }

    public Result create(Workspace_roleDto workspace_roleDto) {
        Workspace_role workspaceRole = new Workspace_role();
        workspaceRole.setName(workspace_roleDto.getName());
        workspaceRole.setExtends_role(workspace_roleDto.getExtends_role());
        Optional<Workspace> byId = workspaceRepo.findById(workspace_roleDto.getWorkspace_id());
        if (byId.isPresent()) {
            Workspace workspace = byId.get();
            workspaceRole.setWorkspace_id(workspace);
        }
        workspace_roleRepo.save(workspaceRole);
        return new Result(true,"Workspace role created");
    }

    public Result update(Workspace_roleDto workspace_roleDto, Integer id) {
        Optional<Workspace_role> byId = workspace_roleRepo.findById(id);
        if (byId.isPresent()) {
            Workspace_role workspaceRole = byId.get();
            workspaceRole.setName(workspace_roleDto.getName());
            workspaceRole.setExtends_role(workspace_roleDto.getExtends_role());
            Optional<Workspace> byId1 = workspaceRepo.findById(workspace_roleDto.getWorkspace_id());
            if (byId1.isPresent()) {
                Workspace workspace = byId1.get();
                workspaceRole.setWorkspace_id(workspace);
            }
            workspace_roleRepo.save(workspaceRole);
            return new Result(true,"Workspace role updated");
        }
        return new Result(false,"Workspace role not found");
    }

    public Result delete(Integer id) {
        workspace_roleRepo.deleteById(id);
        return new Result(true,"Workspace role deleted");
    }

}