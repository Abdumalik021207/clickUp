package org.example.clickup.controller;

import org.example.clickup.dto.Task_tagDto;
import org.example.clickup.model.Result;
import org.example.clickup.model.Task_tag;
import org.example.clickup.service.Task_tagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task_tag")
public class Task_tagController {

    @Autowired
    private Task_tagService task_tagService;

    @GetMapping()
    @PreAuthorize("hasAnyRole(SUPER_ADMIN,ADMIN)")
    public List<Task_tag> getTask_tag() {
        return task_tagService.getTask_tags();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole(SUPER_ADMIN,ADMIN)")
    public Task_tag getTask_tag(@PathVariable Integer id) {
        return task_tagService.getTask_tag(id);
    }

    @PostMapping()
    public Result addTask_tag(@RequestBody Task_tagDto task_tagDto) {
        return task_tagService.createTask_tag(task_tagDto);
    }

    @PutMapping("/{id}")
    public Result updateTask_tag(@PathVariable Integer id, @RequestBody Task_tagDto task_tagDto) {
        return task_tagService.updateTask_tag(task_tagDto, id);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole(SUPER_ADMIN,ADMIN)")
    public Result deleteTask_tag(@PathVariable Integer id) {
        return task_tagService.deleteTask_tag(id);
    }

}
