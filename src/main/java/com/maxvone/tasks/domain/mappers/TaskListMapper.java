package com.maxvone.tasks.domain.mappers;

import com.maxvone.tasks.domain.dto.TaskListDto;
import com.maxvone.tasks.domain.entities.TaskList;

public interface TaskListMapper {

    TaskList fromDto(TaskListDto taskListDto);
    TaskListDto toDto(TaskList taskList);
}
