package com.Nimap.nimap_task.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ResponseDto<T> {
    private String message;
    private boolean success;
    private T data;
}
