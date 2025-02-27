package com.maxvone.tasks.domain.mappers;

import com.maxvone.tasks.domain.dto.TaskDto;
import com.maxvone.tasks.domain.entities.Task;

public interface TaskMapper {

    Task fromDto(TaskDto dto);
    TaskDto toDto(Task entity);
}
