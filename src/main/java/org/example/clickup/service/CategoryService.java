package org.example.clickup.service;

import org.example.clickup.dto.CategoryDto;
import org.example.clickup.model.Category;
import org.example.clickup.model.Project;
import org.example.clickup.model.Result;
import org.example.clickup.repository.CategoryRepo;
import org.example.clickup.repository.ProjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    CategoryRepo categoryRepo;

    @Autowired
    ProjectRepo projectRepo;

    public List<Category> getAllCategories() {
        return categoryRepo.findAll();
    }

    public Category getCategoryById(Integer id) {
        return categoryRepo.findById(id).get();
    }

    public Result addCategory(CategoryDto categoryDto) {
        Category category = new Category();
        category.setName(categoryDto.getName());
        category.setColor(categoryDto.getColor());
        category.setArchived(categoryDto.isArchived());
        category.setAcces_type(categoryDto.getAcces_type());
        Optional<Project> byId = projectRepo.findById(categoryDto.getProjectId());
        Project project = byId.get();
        category.setProjectId(project);
        categoryRepo.save(category);

        return new Result(true,"Created successfully");
    }

    public Result updateCategory(CategoryDto categoryDto, Integer id) {
        Optional<Category> byId = categoryRepo.findById(id);
        Category category = byId.get();

        category.setName(categoryDto.getName());
        category.setColor(categoryDto.getColor());
        category.setArchived(categoryDto.isArchived());
        category.setAcces_type(categoryDto.getAcces_type());

        Optional<Project> byId1 = projectRepo.findById(categoryDto.getProjectId());
        Project project = byId1.get();

        category.setProjectId(project);
        categoryRepo.save(category);

        return new Result(true,"Updated successfully");
    }

    public Result deleteCategory(Integer id) {
        categoryRepo.deleteById(id);
        return new Result(true,"Deleted successfully");
    }

}
