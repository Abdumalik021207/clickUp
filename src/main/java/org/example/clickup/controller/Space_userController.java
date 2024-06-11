package org.example.clickup.controller;

import org.example.clickup.dto.Space_userDto;
import org.example.clickup.model.Result;
import org.example.clickup.model.Space_user;
import org.example.clickup.service.Space_userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/space_user")
public class Space_userController {

    @Autowired
    private Space_userService space_userService;

    @GetMapping()
    @PreAuthorize("hasAnyRole(SUPER_ADMIN,ADMIN)")
    public List<Space_user> getSpace_user() {
        return space_userService.findAll();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole(SUPER_ADMIN,ADMIN)")
    public Space_user getSpace_user(@PathVariable Long id) {
        return space_userService.findById(id);
    }

    @PostMapping()
    public Result createSpace_user(@RequestBody Space_userDto space_userDto) {
        return space_userService.save(space_userDto);
    }

    @PutMapping("/{id}")
    public Result updateSpace_user(@PathVariable Long id, @RequestBody Space_userDto space_userDto) {
        return space_userService.update(space_userDto, id);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole(SUPER_ADMIN,ADMIN)")
    public Result deleteSpace_user(@PathVariable Long id) {
        return space_userService.delete(id);
    }

}
