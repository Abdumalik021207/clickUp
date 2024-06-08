package org.example.clickup.service;

import org.example.clickup.dto.Workspace_permissionDto;
import org.example.clickup.model.Result;
import org.example.clickup.model.Workspace_permission;
import org.example.clickup.model.Workspace_role;
import org.example.clickup.repository.Workspace_permissionRepo;
import org.example.clickup.repository.Workspace_roleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Workspace_permissionService {

    @Autowired
    Workspace_permissionRepo repo;

    @Autowired
    Workspace_roleRepo workspace_roleRepo;

    public List<Workspace_permission> getAllPermissions() {
        return repo.findAll();
    }

    public Workspace_permission getPermissionById(Integer id) {
        return repo.findById(id).get();
    }

    public Result createPermission(Workspace_permissionDto permissionDto) {
        Workspace_permission workspacePermission = new Workspace_permission();
        workspacePermission.setPermission(permissionDto.getPermission());
        Optional<Workspace_role> byId = workspace_roleRepo.findById(permissionDto.getWorkspace_role_id());
        if (byId.isPresent()) {
            Workspace_role workspaceRole = byId.get();
            workspacePermission.setWorkspace_role_id(workspaceRole);
        }
        repo.save(workspacePermission);
        return new Result(true,"Permission created");
    }

    public Result updatePermission(Integer id, Workspace_permissionDto permissionDto) {
        Optional<Workspace_permission> byId = repo.findById(id);
        if (byId.isPresent()) {
            Workspace_permission workspacePermission = byId.get();
            workspacePermission.setPermission(permissionDto.getPermission());
            Optional<Workspace_role> byId1 = workspace_roleRepo.findById(permissionDto.getWorkspace_role_id());
            if (byId1.isPresent()) {
                Workspace_role workspaceRole = byId1.get();
                workspacePermission.setWorkspace_role_id(workspaceRole);
            }
            repo.save(workspacePermission);
            return new Result(true,"Permission updated");
        }
        return new Result(false,"Permission not found");
    }

    public Result deletePermission(Integer id) {
        repo.deleteById(id);
        return new Result(true,"Permission deleted");
    }

}