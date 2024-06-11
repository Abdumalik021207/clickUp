package org.example.clickup.controller;

import org.example.clickup.dto.Time_trackerDto;
import org.example.clickup.model.Result;
import org.example.clickup.model.Time_tracker;
import org.example.clickup.service.Time_trackerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/time_tracker")
public class Time_trackerController {

    @Autowired
    private Time_trackerService time_trackerService;

    @GetMapping()
    @PreAuthorize("hasAnyRole(SUPER_ADMIN,ADMIN)")
    public List<Time_tracker> getTime_tracker() {
        return time_trackerService.getAll();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole(SUPER_ADMIN,ADMIN)")
    public Time_tracker getTime_trackerById(@PathVariable Long id) {
        return time_trackerService.getById(id);
    }

    @PostMapping()
    public Result createTime_tracker(@RequestBody Time_trackerDto time_trackerDto) {
        return time_trackerService.create(time_trackerDto);
    }

    @PutMapping("/{id}")
    public Result updateTime_tracker(@PathVariable Long id, @RequestBody Time_trackerDto time_trackerDto) {
        return time_trackerService.update(time_trackerDto, id);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole(SUPER_ADMIN,ADMIN)")
    public Result deleteTime_tracker(@PathVariable Long id) {
        return time_trackerService.delete(id);
    }

}
