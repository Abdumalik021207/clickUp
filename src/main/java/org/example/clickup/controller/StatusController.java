package org.example.clickup.controller;

import org.example.clickup.dto.StatusDto;
import org.example.clickup.model.Result;
import org.example.clickup.model.Status;
import org.example.clickup.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/status")
public class StatusController {

    @Autowired
    private StatusService statusService;

    @GetMapping()
    @PreAuthorize("hasAnyRole(SUPER_ADMIN,ADMIN)")
    public List<Status> getStatus() {
        return statusService.getAll();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole(SUPER_ADMIN,ADMIN)")
    public Status getStatus(@PathVariable Integer id) {
        return statusService.getStatus(id);
    }

    @PostMapping()
    public Result createStatus(@RequestBody StatusDto statusDto) {
        return statusService.addStatus(statusDto);
    }

    @PutMapping("/{id}")
    public Result updateStatus(@PathVariable Integer id, @RequestBody StatusDto statusDto) {
        return statusService.updateStatus(id, statusDto);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole(SUPER_ADMIN,ADMIN)")
    public Result deleteStatus(@PathVariable Integer id) {
        return statusService.deleteStatus(id);
    }

}
