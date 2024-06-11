package org.example.clickup.service;

import org.example.clickup.dto.AttachmetDto;
import org.example.clickup.model.Attachmet;
import org.example.clickup.model.Result;
import org.example.clickup.repository.AttachmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AttachmentService {

    @Autowired
    AttachmentRepo attachmentRepo;

    public List<Attachmet> readAll() {
        return attachmentRepo.findAll();
    }

    public Attachmet readById(Long id) {
        return attachmentRepo.findById(id).get();
    }

    public Result create(AttachmetDto attachmetDto) {
        Attachmet attachmet = new Attachmet();
        attachmet.setName(attachmetDto.getName());
        attachmet.setSize(attachmetDto.getSize());
        attachmet.setContent_type(attachmetDto.getContent_type());
        attachmet.setOriginal_name(attachmetDto.getOriginal_name());
        attachmentRepo.save(attachmet);
        return new Result(true, "Successfully created");
    }

    public Result update(AttachmetDto attachmetDto, Long id) {
        Optional<Attachmet> byId = attachmentRepo.findById(id);
        if (byId.isPresent()) {
            Attachmet attachmet = byId.get();
            attachmet.setName(attachmetDto.getName());
            attachmet.setSize(attachmetDto.getSize());
            attachmet.setContent_type(attachmetDto.getContent_type());
            attachmet.setOriginal_name(attachmetDto.getOriginal_name());
            attachmentRepo.save(attachmet);
            return new Result(true, "Successfully updated");
        }
        return new Result(false, "Attachmet not found");
    }

    public Result delete(Long id) {
        attachmentRepo.deleteById(id);
        return new Result(true, "Successfully deleted");
    }

}
