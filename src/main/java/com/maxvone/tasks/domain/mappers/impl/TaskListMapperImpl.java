package com.maxvone.tasks.domain.mappers.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.maxvone.tasks.domain.dto.TaskListDto;
import com.maxvone.tasks.domain.entities.Task;
import com.maxvone.tasks.domain.entities.TaskList;
import com.maxvone.tasks.domain.entities.TaskStatus;
import com.maxvone.tasks.domain.mappers.TaskListMapper;
import com.maxvone.tasks.domain.mappers.TaskMapper;

@Component
public class TaskListMapperImpl implements TaskListMapper {

    private TaskMapper taskMapper;


    public TaskListMapperImpl(TaskMapper taskMapper) {
        this.taskMapper = taskMapper;
    }

    @Override
    public TaskList fromDto(TaskListDto taskListDto) {
        return new TaskList(
            taskListDto.id(),
            taskListDto.title(),
            taskListDto.description(),
                    Optional.ofNullable(taskListDto.tasks())
                            .map(tasks -> tasks.stream().map(taskMapper::fromDto).toList())
                            .orElse(null),
            null,
            null
        );
    }

    @Override
    public TaskListDto toDto(TaskList taskList) {
        return new TaskListDto(
                taskList.getId(),
                taskList.getTitle(),
                taskList.getDescription(),
                Optional.ofNullable(taskList.getTasks())
                        .map(List::size)
                        .orElse(0),
                calculateProgress(taskList.getTasks()),
                Optional.ofNullable(taskList.getTasks())
                        .map(tasks -> tasks.stream().map(taskMapper::toDto).toList())
                        .orElse(null)
            );
    }

    private Double calculateProgress(List<Task> tasks) {

        if (tasks == null) {
            return null;
        }
        
        long closedTaskCount = tasks.stream().filter(task -> task.getStatus() == TaskStatus.CLOSED).count();

        return (double) (closedTaskCount / tasks.size());
    }

}
