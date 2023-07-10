package com.codesoom.assignment.models.request;

import com.codesoom.assignment.exception.custom.InvalidTaskRequest;
import com.codesoom.assignment.models.domain.Task;

public class TaskEdit {
    private Long id;

    private String title;

    public TaskEdit(Long id, String title) {
        this.id = id;
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void validate() {
        if (this.id == null) {
            throw new InvalidTaskRequest("id","id 은 필수값 입니다.");
        }
    }
    public Task toTask() {
        return new Task(this.id,this.title);
    }
}