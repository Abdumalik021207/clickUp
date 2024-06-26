package org.example.clickup.controller;

import org.example.clickup.dto.Click_appsDto;
import org.example.clickup.model.Click_apps;
import org.example.clickup.model.Result;
import org.example.clickup.service.Click_appsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/click_apps")
public class Click_appsController {

    @Autowired
    Click_appsService click_appsService;

    @GetMapping()
    @PreAuthorize("hasAnyRole(SUPER_ADMIN,ADMIN)")
    public List<Click_apps> getClick_apps() {
        return click_appsService.getClick_apps();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole(SUPER_ADMIN,ADMIN)")
    public Click_apps getClick_apps(@PathVariable Long id) {
        return click_appsService.getClick_apps(id);
    }

    @PostMapping()
    public Result createClick_apps(@RequestBody Click_appsDto click_appsDto) {
        return click_appsService.addClick_apps(click_appsDto);
    }

    @PutMapping("/{id}")
    public Result updateClick(@PathVariable Long id, @RequestBody Click_appsDto click_appsDto) {
        return click_appsService.updateClick_apps(click_appsDto, id);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole(SUPER_ADMIN,ADMIN)")
    public Result deleteClick(@PathVariable Long id) {
        return click_appsService.deleteClick_apps(id);
    }

}
