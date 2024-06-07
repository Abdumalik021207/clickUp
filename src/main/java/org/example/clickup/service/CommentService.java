package org.example.clickup.service;

import org.example.clickup.dto.CommentDto;
import org.example.clickup.model.Comment;
import org.example.clickup.model.Result;
import org.example.clickup.model.Task;
import org.example.clickup.repository.CommentRepo;
import org.example.clickup.repository.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {

    @Autowired
    CommentRepo commentRepo;

    @Autowired
    TaskRepo taskRepo;

    public List<Comment> getComments() {
        return commentRepo.findAll();
    }

    public Comment readComment(Integer id) {
        return commentRepo.findById(id).get();
    }

    public Result createComment(CommentDto commentDto) {
        Comment comment = new Comment();
        comment.setName(commentDto.getName());
        Optional<Task> byId = taskRepo.findById(commentDto.getTask_id());
        if (byId.isPresent()) {
            Task task = byId.get();
            comment.setTask_id(task);
            commentRepo.save(comment);
            return new Result(true, "Comment created");
        }
        return new Result(false, "Task does not exist");
    }

    public Result updateComment(Integer id, CommentDto commentDto) {
        Optional<Comment> byId = commentRepo.findById(id);
        if (byId.isPresent()) {
            Comment comment = byId.get();
            comment.setName(commentDto.getName());

            Optional<Task> byId1 = taskRepo.findById(commentDto.getTask_id());
            if (byId1.isPresent()) {
                Task task = byId1.get();
                comment.setTask_id(task);
                commentRepo.save(comment);
                return new Result(true, "Comment updated");
            }
            return new Result(false, "Task does not exist");
        }
        return new Result(false, "Task does not exist");
    }

    public Result deleteComment(Integer id) {
        commentRepo.deleteById(id);
        return new Result(true, "Comment deleted");
    }

}
