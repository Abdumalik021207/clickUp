package org.example.clickup.controller;

import org.example.clickup.dto.Workspace_permissionDto;
import org.example.clickup.model.Result;
import org.example.clickup.model.Workspace_permission;
import org.example.clickup.service.Workspace_permissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/workspace_permission")
public class Workspace_permissionController {

    @Autowired
    private Workspace_permissionService workspace_permissionService;

    @GetMapping()
    @PreAuthorize("hasAnyRole(SUPER_ADMIN,ADMIN)")
    public List<Workspace_permission> getWorkspace_permission() {
        return workspace_permissionService.getAllPermissions();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole(SUPER_ADMIN,ADMIN)")
    public Workspace_permission getWorkspace_permission(@PathVariable Long id) {
        return workspace_permissionService.getPermissionById(id);
    }

    @PostMapping()
    public Result createWorkspace_permission(@RequestBody Workspace_permissionDto workspace_permissionDto) {
        return workspace_permissionService.createPermission(workspace_permissionDto);
    }

    @PutMapping("/{id}")
    public Result updateWorkspace_permission(@PathVariable Long id, @RequestBody Workspace_permissionDto workspace_permission) {
        return workspace_permissionService.updatePermission(id, workspace_permission);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole(SUPER_ADMIN,ADMIN)")
    public Result deleteWorkspace_permission(@PathVariable Long id) {
        return workspace_permissionService.deletePermission(id);
    }

}
