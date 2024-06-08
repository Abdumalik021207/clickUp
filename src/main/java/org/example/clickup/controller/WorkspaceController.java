package org.example.clickup.controller;

import org.example.clickup.dto.WorkspaceDto;
import org.example.clickup.model.Result;
import org.example.clickup.model.Workspace;
import org.example.clickup.service.WorkspaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/workspace")
public class WorkspaceController {

    @Autowired
    private WorkspaceService workspaceService;

    @GetMapping()
    @PreAuthorize("hasAnyRole(SUPER_ADMIN,ADMIN)")
    public List<Workspace> getAllWorkspaces() {
        return workspaceService.getAllWorkspaces();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole(SUPER_ADMIN,ADMIN)")
    public Workspace getWorkspaceById(@PathVariable Integer id) {
        return workspaceService.getWorkspaceById(id);
    }

    @PostMapping()
    public Result createWorkspace(@RequestBody WorkspaceDto workspaceDto) {
        return workspaceService.createWorkspace(workspaceDto);
    }

    @PutMapping("/{id}")
    public Result updateWorkspace(@PathVariable Integer id, @RequestBody WorkspaceDto workspaceDto) {
        return workspaceService.updateWorkspace(workspaceDto, id);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole(SUPER_ADMIN,ADMIN)")
    public Result deleteWorkspace(@PathVariable Integer id) {
        return workspaceService.deleteWorkspace(id);
    }

}
