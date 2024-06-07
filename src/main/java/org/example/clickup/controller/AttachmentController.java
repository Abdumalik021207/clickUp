package org.example.clickup.controller;

import org.example.clickup.dto.AttachmetDto;
import org.example.clickup.model.Attachmet;
import org.example.clickup.model.Result;
import org.example.clickup.service.AttachmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/attachment")
public class AttachmentController {

    @Autowired
    AttachmentService attachmentService;

    @GetMapping()
    public List<Attachmet> getAttachments() {
        return attachmentService.readAll();
    }

    @GetMapping("/{id}")
    public Attachmet getAttachment(@PathVariable Integer id) {
        return attachmentService.readById(id);
    }

    @PostMapping()
    public Result addAttachment(@RequestBody AttachmetDto attachmetDto) {
        return attachmentService.create(attachmetDto);
    }

    @PutMapping("/{id}")
    public Result updateAttachment(@PathVariable Integer id, @RequestBody AttachmetDto attachmetDto) {
        return attachmentService.update(attachmetDto, id);
    }

    @DeleteMapping("/{id}")
    public Result deleteAttachment(@PathVariable Integer id) {
        return attachmentService.delete(id);
    }

}
