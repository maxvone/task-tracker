package com.maxvone.tasks.domain.mappers.impl;

import org.springframework.stereotype.Component;

import com.maxvone.tasks.domain.dto.TaskDto;
import com.maxvone.tasks.domain.entities.Task;
import com.maxvone.tasks.domain.mappers.TaskMapper;

@Component
public class TaskMapperImpl implements TaskMapper{

    @Override
    public Task fromDto(TaskDto dto) {
        return new Task(
            dto.id(),   
            dto.title(),
            dto.description(),
            dto.dueDate(),
            dto.status(),
            dto.priority(),
            null,
            null,
            null
        );
    }

    @Override
    public TaskDto toDto(Task entity) {
        return new TaskDto(
            entity.getId(),
            entity.getTitle(),
            entity.getDescription(),
            entity.getDueDate(),
            entity.getPriority(),
            entity.getStatus()
        );
    }

}
