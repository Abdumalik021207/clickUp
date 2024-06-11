package org.example.clickup.controller;

import org.example.clickup.dto.IconDto;
import org.example.clickup.model.Icon;
import org.example.clickup.model.Result;
import org.example.clickup.service.IconService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/icon")
public class IconController {

    @Autowired
    private IconService iconService;

    @GetMapping()
    @PreAuthorize("hasAnyRole(SUPER_ADMIN,ADMIN)")
    public List<Icon> getIcons() {
        return iconService.getAllIcons();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole(SUPER_ADMIN,ADMIN)")
    public Icon getIcon(@PathVariable Long id) {
        return iconService.getIconById(id);
    }

    @PostMapping()
    public Result addIcon(@RequestBody IconDto iconDto) {
        return iconService.createIcon(iconDto);
    }

    @PutMapping("/{id}")
    public Result updateIcon(@PathVariable Long id, @RequestBody IconDto iconDto) {
        return iconService.updateIcon(iconDto, id);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole(SUPER_ADMIN,ADMIN)")
    public Result deleteIcon(@PathVariable Long id) {
        return iconService.deleteIcon(id);
    }

}
