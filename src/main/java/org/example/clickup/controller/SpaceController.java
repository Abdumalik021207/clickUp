package org.example.clickup.controller;

import org.example.clickup.dto.SpaceDto;
import org.example.clickup.model.Result;
import org.example.clickup.model.Space;
import org.example.clickup.service.SpaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/space")
public class SpaceController {

    @Autowired
    private SpaceService spaceService;

    @GetMapping()
    public List<Space> getSpaces() {
        return spaceService.getSpaces();
    }

    @GetMapping("/{id}")
    public Space getSpace(@PathVariable Integer id) {
        return spaceService.getSpace(id);
    }

    @PostMapping()
    public Result addSpace(@RequestBody SpaceDto spaceDto) {
        return spaceService.createSpace(spaceDto);
    }

    @PutMapping("/{id}")
    public Result updateSpace(@PathVariable Integer id, @RequestBody SpaceDto spaceDto) {
        return spaceService.updateSpace(spaceDto, id);
    }

    @DeleteMapping("/{id}")
    public Result deleteSpace(@PathVariable Integer id) {
        return spaceService.deleteSpace(id);
    }

}
