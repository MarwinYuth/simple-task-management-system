package com.assignment.simple_task_management_system.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.simple_task_management_system.model.TaskModel;
import com.assignment.simple_task_management_system.service.TaskService;

import jakarta.validation.Valid;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/tasks")
public class TaskController {
    
   private final TaskService taskService;

   public TaskController(TaskService taskService){
    this.taskService = taskService;
   }

   @GetMapping
   public ResponseEntity<List<TaskModel>> getAllTasks(){
    return ResponseEntity.ok(taskService.getAllTasks());
   }
   
   @GetMapping("/{id}")
   public ResponseEntity<TaskModel> findById(@PathVariable Long id){
     TaskModel tasks = taskService.findById(id);
     return ResponseEntity.ok(tasks);
   }

   @PostMapping
   public ResponseEntity<TaskModel> createTask(@Valid @RequestBody TaskModel taskModel){
    TaskModel created = taskService.createTask(taskModel);
    return new ResponseEntity<>(created,HttpStatus.CREATED);
   }

   @PutMapping("/{id}")
   public ResponseEntity<TaskModel> updateTask(@PathVariable Long id,@Valid @RequestBody TaskModel taskModel){
      TaskModel updated = taskService.updateTask(id, taskModel);
      return ResponseEntity.ok(updated);
   }

   @DeleteMapping("/{id}")
   public Map<String,String> deleteTask(@PathVariable Long id){
      taskService.deleteTask(id);
      Map<String,String> response = Map.of("message","Task delete successfully");
      return response;
   }
   
}
