package com.taskListEmailSender.toDoListEmailSender.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmailDto {

    private String recipientAddress;
    private String title;
    private String text;
}
