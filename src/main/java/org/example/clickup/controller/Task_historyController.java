package org.example.clickup.controller;

import org.example.clickup.dto.Task_historyDto;
import org.example.clickup.model.Result;
import org.example.clickup.model.Task_history;
import org.example.clickup.service.Task_historyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task_history")
public class Task_historyController {

    @Autowired
    private Task_historyService task_historyService;

    @GetMapping()
    @PreAuthorize("hasAnyRole(SUPER_ADMIN,ADMIN)")
    public List<Task_history> getTask_history() {
        return task_historyService.findAll();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole(SUPER_ADMIN,ADMIN)")
    public Task_history getTask_history(@PathVariable Integer id) {
        return task_historyService.findById(id);
    }

    @PostMapping()
    public Result createTask_history(@RequestBody Task_historyDto task_history) {
        return task_historyService.create(task_history);
    }

    @PutMapping("/{id}")
    public Result updateTask_history(@PathVariable Integer id, @RequestBody Task_historyDto dto) {
        return task_historyService.update(dto, id);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole(SUPER_ADMIN,ADMIN)")
    public Result deleteTask_history(@PathVariable Integer id) {
        return task_historyService.delete(id);
    }

}
