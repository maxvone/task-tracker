package com.maxvone.tasks.domain.dto;

import java.time.LocalDateTime;
import java.util.UUID;

import com.maxvone.tasks.domain.entities.TaskPriority;
import com.maxvone.tasks.domain.entities.TaskStatus;

public record TaskDto(
    UUID id,
    String title,
    String description,
    LocalDateTime dueDate,
    TaskPriority priority,
    TaskStatus status
) {

}
