package org.example.clickup.controller;

import org.example.clickup.dto.Space_click_appsDto;
import org.example.clickup.model.Result;
import org.example.clickup.model.Space_click_apps;
import org.example.clickup.service.Space_click_appsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/space_click_apps")
public class Space_click_appsController {

    @Autowired
    private Space_click_appsService space_click_appsService;

    @GetMapping()
    public List<Space_click_apps> getSpace_click_apps() {
        return space_click_appsService.getSpace_click_apps();
    }

    @GetMapping("/{id}")
    public Space_click_apps getSpace_click_apps(@PathVariable Integer id) {
        return space_click_appsService.getSpace_click_apps(id);
    }

    @PostMapping()
    public Result createSpace_click_apps(@RequestBody Space_click_appsDto spaceClickAppsDto) {
        return space_click_appsService.createSpace_click_apps(spaceClickAppsDto);
    }

    @PutMapping("/{id}")
    public Result updateSpace_click_apps(@PathVariable Integer id, @RequestBody Space_click_appsDto spaceClickAppsDto) {
        return space_click_appsService.update(spaceClickAppsDto, id);
    }

    @DeleteMapping("/{id}")
    public Result deleteSpace_click_apps(@PathVariable Integer id) {
        return space_click_appsService.delete(id);
    }

}
