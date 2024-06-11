package org.example.clickup.controller;

import org.example.clickup.dto.ViewDto;
import org.example.clickup.model.Result;
import org.example.clickup.model.View;
import org.example.clickup.service.ViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/view")
public class ViewController {

    @Autowired
    private ViewService viewService;

    @GetMapping
    @PreAuthorize("hasAnyRole(SUPER_ADMIN,ADMIN)")
    public List<View> getViews() {
        return viewService.getAllViews();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole(SUPER_ADMIN,ADMIN)")
    public View getView(@PathVariable Long id) {
        return viewService.getView(id);
    }

    @PostMapping()
    public Result addView(@RequestBody ViewDto viewDto) {
        return viewService.create(viewDto);
    }

    @PutMapping("/{id}")
    public Result update(@PathVariable Long id, @RequestBody ViewDto viewDto) {
        return viewService.updateView(viewDto, id);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole(SUPER_ADMIN,ADMIN)")
    public Result delete(@PathVariable Long id) {
        return viewService.deleteView(id);
    }

}