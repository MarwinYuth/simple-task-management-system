package com.assignment.simple_task_management_system.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class TaskModel {

    @Valid    

    private Long id;

    @NotBlank(message = "Title is require")
    @NotEmpty(message = "Title cannot be empty")
    private String title;

    @NotBlank(message = "Description is require")
    @NotEmpty(message = "Description cannot be empty")
    @Size(min=5,max = 50,message = "Description must between 5 and 50 chars")
    private String description;

    @NotBlank(message = "Status is require")
    @NotEmpty(message = "Status cannot be empty")
    @Pattern(regexp = "complete|pending|decline",message = "Status must be either 'complete' or 'pending' or 'decline")
    private String status;

    @JsonProperty("created_at")
    private LocalDateTime created_at;

    @JsonProperty("updated_at")
    private LocalDateTime updated_at;

    public TaskModel(Long id,String title,String description,String status,LocalDateTime created_at,LocalDateTime updated_at){
        this.id = id;
        this.title = title;
        this.description = description;
        this.status = status;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public String getStatus(){
        return status;
    }

    public void setStatus(String status){
        this.status = status;
    }

    @JsonProperty("created_at")
    public LocalDateTime getCreatedAt() {
        return created_at;
    }

    @JsonProperty("updated_at")
    public LocalDateTime getUpdatedAt() {
        return updated_at;
    }

    public void onCreatedAt() {
        this.created_at = LocalDateTime.now();
    }

    public void onUpdateAt() {
        this.updated_at = LocalDateTime.now();
    }
}
