package org.example.clickup.controller;

import org.example.clickup.dto.Workspace_roleDto;
import org.example.clickup.model.Result;
import org.example.clickup.model.Workspace_role;
import org.example.clickup.service.Workspace_roleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/workspace_role")
public class Workspace_roleController {

    @Autowired
    private Workspace_roleService workspace_roleService;

    @GetMapping()
    public List<Workspace_role> getAll() {
        return workspace_roleService.getAllWorkspaceRoles();
    }

    @GetMapping("/{id}")
    public Workspace_role getById(@PathVariable Integer id) {
        return workspace_roleService.getWorkspaceRoleById(id);
    }

    @PostMapping()
    public Result create(@RequestBody Workspace_roleDto workspace_roleDto) {
        return workspace_roleService.create(workspace_roleDto);
    }

    @PutMapping("/{id}")
    public Result update(@PathVariable Integer id, @RequestBody Workspace_roleDto workspace_roleDto) {
        return workspace_roleService.update(workspace_roleDto, id);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        return workspace_roleService.delete(id);
    }

}