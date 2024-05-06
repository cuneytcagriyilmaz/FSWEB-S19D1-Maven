package com.workintech.s18d2.exceptions;


import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class FruitErrorResponse {
    private Integer status;
    private String message;
    private LocalDateTime dateTime;

}
