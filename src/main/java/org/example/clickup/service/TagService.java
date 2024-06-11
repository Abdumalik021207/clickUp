package org.example.clickup.service;

import org.example.clickup.dto.TagDto;
import org.example.clickup.model.Result;
import org.example.clickup.model.Tag;
import org.example.clickup.model.Workspace;
import org.example.clickup.repository.TagRepo;
import org.example.clickup.repository.WorkspaceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TagService {

    @Autowired
    TagRepo tagRepo;

    @Autowired
    WorkspaceRepo workspaceRepo;

    public List<Tag> getAllTags() {
        return tagRepo.findAll();
    }

    public Tag getTagById(Long id) {
        return tagRepo.findById(id).get();
    }

    public Result createTag(TagDto tagDto) {
        Tag tag = new Tag();
        tag.setName(tagDto.getName());
        tag.setColor(tagDto.getColor());
        Optional<Workspace> byId = workspaceRepo.findById(tagDto.getWorkspaceId());
        if (byId.isPresent()) {
            Workspace workspace = byId.get();
            tag.setWorkspaceId(workspace);
            tagRepo.save(tag);
        }
        tagRepo.save(tag);
        return new Result(true,"Successfully created tag");
    }

    public Result updateTag(TagDto tagDto, Long id) {
        Optional<Tag> byId = tagRepo.findById(id);
        if (byId.isPresent()) {
            Tag tag = byId.get();
            tag.setName(tagDto.getName());
            tag.setColor(tagDto.getColor());
            tagRepo.save(tag);
            Optional<Workspace> byId1 = workspaceRepo.findById(tagDto.getWorkspaceId());
            if (byId1.isPresent()) {
                Workspace workspace = byId1.get();
                tag.setWorkspaceId(workspace);
                tagRepo.save(tag);
            }
            return new Result(true,"Successfully updated tag");
        }
        return new Result(false,"Not found tag");
    }

    public Result deleteTag(Long id) {
        tagRepo.deleteById(id);
        return new Result(true,"Successfully deleted tag");
    }

}