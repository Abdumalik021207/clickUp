package org.example.clickup.service;

import org.example.clickup.dto.IconDto;
import org.example.clickup.model.Attachmet;
import org.example.clickup.model.Icon;
import org.example.clickup.model.Result;
import org.example.clickup.repository.AttachmentRepo;
import org.example.clickup.repository.IconRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IconService {

    @Autowired
    IconRepo iconRepo;

    @Autowired
    AttachmentRepo attachmentRepo;

    public List<Icon> getAllIcons() {
        return iconRepo.findAll();
    }

    public Icon getIconById(Long id) {
        return iconRepo.findById(id).get();
    }

    public Result createIcon(IconDto iconDto) {
        Icon icon = new Icon();

        icon.setColor(iconDto.getColor());
        icon.setIcon(iconDto.getColor());
        icon.setInnitial_letter(iconDto.getInnitial_letter());

        Optional<Attachmet> byId = attachmentRepo.findById(iconDto.getAttachment_id());
        if (byId.isPresent()) {
            Attachmet attachmet = byId.get();
            icon.setAttachment_id(attachmet);
            iconRepo.save(icon);
            return new Result(true,"Create Icon successfully");
        }
        return new Result(false,"Create Icon failed");
    }

    public Result updateIcon(IconDto iconDto, Long id) {
        Optional<Icon> byId = iconRepo.findById(id);
        if (byId.isPresent()) {
            Icon icon = byId.get();
            icon.setIcon(iconDto.getColor());
            icon.setInnitial_letter(iconDto.getInnitial_letter());
            icon.setColor(iconDto.getColor());

            Optional<Attachmet> byId1 = attachmentRepo.findById(iconDto.getAttachment_id());
            if (byId1.isPresent()) {
                Attachmet attachmet = byId1.get();
                icon.setAttachment_id(attachmet);
                iconRepo.save(icon);
                return new Result(true,"Update Icon successfully");
            }
            return new Result(false,"Update Icon failed");
        }
        return new Result(false,"Update Icon failed");
    }

    public Result deleteIcon(Long id) {
        iconRepo.deleteById(id);
        return new Result(true,"Delete Icon successfully");
    }

}
