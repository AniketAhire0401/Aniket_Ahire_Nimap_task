package com.Nimap.nimap_task.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class CategoryResponseDto {
    private UUID id;
    private String categoryName;
}
