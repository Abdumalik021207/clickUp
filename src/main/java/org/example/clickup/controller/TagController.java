package org.example.clickup.controller;

import org.example.clickup.dto.TagDto;
import org.example.clickup.model.Result;
import org.example.clickup.model.Tag;
import org.example.clickup.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tag")
public class TagController {

    @Autowired
    private TagService tagService;

    @GetMapping()
    @PreAuthorize("hasAnyRole(SUPER_ADMIN,ADMIN)")
    public List<Tag> getAllTags() {
        return tagService.getAllTags();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole(SUPER_ADMIN,ADMIN)")
    public Tag getTag(@PathVariable Long id) {
        return tagService.getTagById(id);
    }

    @PostMapping()
    public Result addTag(@RequestBody TagDto tagDto) {
        return tagService.createTag(tagDto);
    }

    @PutMapping("/{id}")
    public Result updateTag(@PathVariable Long id, @RequestBody TagDto tagDto) {
        return tagService.updateTag(tagDto, id);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole(SUPER_ADMIN,ADMIN)")
    public Result deleteTag(@PathVariable Long id) {
        return tagService.deleteTag(id);
    }

}
