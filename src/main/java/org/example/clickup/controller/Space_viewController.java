package org.example.clickup.controller;

import org.example.clickup.dto.Space_viewDto;
import org.example.clickup.model.Result;
import org.example.clickup.model.Space_view;
import org.example.clickup.service.Space_viewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/space_view")
public class Space_viewController {

    @Autowired
    private Space_viewService space_viewService;

    @GetMapping()
    @PreAuthorize("hasAnyRole(SUPER_ADMIN,ADMIN)")
    public List<Space_view> readAll() {
        return space_viewService.getAllSpaces();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole(SUPER_ADMIN,ADMIN)")
    public Space_view readByID(@PathVariable Long id) {
        return space_viewService.getSpaceById(id);
    }

    @PostMapping()
    public Result create(@RequestBody Space_viewDto space_viewDto) {
        return space_viewService.create(space_viewDto);
    }

    @PutMapping("/{id}")
    public Result update(@PathVariable Long id, @RequestBody Space_viewDto space_viewDto) {
        return space_viewService.update(space_viewDto, id);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole(SUPER_ADMIN,ADMIN)")
    public Result delete(@PathVariable Long id) {
        return space_viewService.delete(id);
    }

}
