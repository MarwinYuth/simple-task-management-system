package com.assignment.simple_task_management_system.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import com.assignment.simple_task_management_system.exception.DuplicateTitleException;
import com.assignment.simple_task_management_system.mapper.TaskMapper;
import com.assignment.simple_task_management_system.model.TaskModel;

@Service
public class TaskService {

    private final TaskMapper taskMapper;

    public TaskService(TaskMapper taskMapper){
        this.taskMapper = taskMapper;
    }
    
    public List<TaskModel> getAllTasks(){
        return taskMapper.findAll();
    }

    public TaskModel findById(Long id){
        TaskModel tasks = taskMapper.findById(id);
        if(tasks == null){
            throw new NoSuchElementException("Tasks not found");
        }
        return tasks;
    }

    public TaskModel createTask(TaskModel taskModel){
        taskMapper.insert(taskModel);
        return taskModel;
    }

    public TaskModel updateTask(Long id,TaskModel taskModel){
        TaskModel existing = findById(id);
        if(taskMapper.findExistTaskTitle(taskModel.getTitle()) > 0){
            throw new DuplicateTitleException("Task title already exist");
        }
        existing.setTitle(taskModel.getTitle());
        existing.setDescription(taskModel.getDescription());
        existing.setStatus(taskModel.getStatus());
        taskMapper.update(existing);
        return existing;
    }

    public void deleteTask(Long id){
        findById(id);
        taskMapper.delete(id);
    }
}
