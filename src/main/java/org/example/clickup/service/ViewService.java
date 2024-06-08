package org.example.clickup.service;

import org.example.clickup.dto.ViewDto;
import org.example.clickup.model.Icon;
import org.example.clickup.model.Result;
import org.example.clickup.model.View;
import org.example.clickup.repository.IconRepo;
import org.example.clickup.repository.ViewRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ViewService {

    @Autowired
    ViewRepo viewRepo;

    @Autowired
    IconRepo iconRepo;

    public List<View> getAllViews() {
        return viewRepo.findAll();
    }

    public View getView(Integer id) {
        return viewRepo.findById(id).get();
    }

    public Result create(ViewDto viewDto) {
        View view = new View();
        view.setName(viewDto.getName());
        Optional<Icon> byId = iconRepo.findById(viewDto.getIcon_id());
        if (byId.isPresent()) {
            Icon icon = byId.get();
            view.setIcon_id(icon);
        }
        viewRepo.save(view);
        return new Result(true,"Successfully craeted view");
    }

    public Result updateView(ViewDto viewDto,Integer id) {
        Optional<View> byId = viewRepo.findById(id);
        if (byId.isPresent()) {
            View view = byId.get();
            view.setName(viewDto.getName());
            Optional<Icon> byId1 = iconRepo.findById(viewDto.getIcon_id());
            if (byId1.isPresent()) {
                Icon icon = byId1.get();
                view.setIcon_id(icon);
            }
            viewRepo.save(view);
            return new Result(true,"Successfully updated view");
        }
        return new Result(false,"No found view");
    }

    public Result deleteView(Integer id) {
        viewRepo.deleteById(id);
        return new Result(true,"Successfully deleted view");
    }

}