package com.project.todo.user.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class UserPasswordUpdateDTO {
    private Long id;
    private String password;
}
