package org.example.clickup.service;

import org.example.clickup.dto.Space_viewDto;
import org.example.clickup.model.Result;
import org.example.clickup.model.Space;
import org.example.clickup.model.Space_view;
import org.example.clickup.model.View;
import org.example.clickup.repository.SpaceRepo;
import org.example.clickup.repository.Space_viewRepo;
import org.example.clickup.repository.ViewRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Space_viewService {

    @Autowired
    Space_viewRepo space_viewRepo;

    @Autowired
    SpaceRepo spaceRepo;

    @Autowired
    ViewRepo viewRepo;

    public List<Space_view> getAllSpaces() {
        return space_viewRepo.findAll();
    }

    public Space_view getSpaceById(Integer id) {
        return space_viewRepo.findById(id).get();
    }

    public Result create(Space_viewDto space_viewDto) {
        Space_view spaceView = new Space_view();
        Optional<Space> byId = spaceRepo.findById(space_viewDto.getSpace_id());
        if (byId.isPresent()) {
            spaceView.setId(space_viewDto.getSpace_id());
            space_viewRepo.save(spaceView);
        }
        Optional<View> byId1 = viewRepo.findById(space_viewDto.getView_id());
        if (byId1.isPresent()) {
            spaceView.setId(space_viewDto.getView_id());
            space_viewRepo.save(spaceView);
        }
        return new Result(true,"Successfully created space view");
    }

    public Result update(Space_viewDto space_viewDto, Integer id) {
        Optional<Space_view> byId = space_viewRepo.findById(id);
        if (byId.isPresent()) {
            Space_view spaceView = byId.get();
            Optional<View> byId1 = viewRepo.findById(space_viewDto.getView_id());
            if (byId1.isPresent()) {
                spaceView.setId(space_viewDto.getView_id());
                space_viewRepo.save(spaceView);
            }
            Optional<View> byId2 = viewRepo.findById(space_viewDto.getView_id());
            if (byId2.isPresent()) {
                spaceView.setId(space_viewDto.getView_id());
                space_viewRepo.save(spaceView);
            }
            return new Result(true,"Successfully updated space view");
        }
        return new Result(false,"Not found space view");
    }

    public Result delete(Integer id) {
        space_viewRepo.deleteById(id);
        return new Result(true,"Successfully deleted space view");
    }

}
