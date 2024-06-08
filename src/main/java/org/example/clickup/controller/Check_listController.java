package org.example.clickup.controller;

import org.example.clickup.dto.Check_listDto;
import org.example.clickup.model.Check_list;
import org.example.clickup.model.Result;
import org.example.clickup.repository.Check_listRepo;
import org.example.clickup.service.Check_listService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/{id}")
public class Check_listController {

    @Autowired
    Check_listService check_listService;

    @GetMapping()
    @PreAuthorize("hasAnyRole(SUPER_ADMIN,ADMIN)")
    public List<Check_list> getAllCheck_lists() {
        return check_listService.getAllCheck_list();
    }

    @GetMapping("/{id}")
    public Check_list getCheck_listById(@PathVariable Integer id) {
        return check_listService.getCheck_listById(id);
    }

    @PostMapping()
    public Result createCheck_list(@RequestBody Check_listDto check_listDto) {
        return check_listService.addCheck_list(check_listDto);
    }

    @PutMapping("/{id}")
    public Result updateCheck_list(@PathVariable Integer id, @RequestBody Check_listDto check_listDto) {
        return check_listService.updateCheck_list(check_listDto, id);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole(SUPER_ADMIN,ADMIN)")
    public Result deleteCheck_list(@PathVariable Integer id) {
        return check_listService.deleteCheck_list(id);
    }

}
