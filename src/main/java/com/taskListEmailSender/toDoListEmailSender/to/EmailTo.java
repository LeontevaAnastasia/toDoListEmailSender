package com.taskListEmailSender.toDoListEmailSender.to;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmailTo {
    private String recipientAddress;
    private String title;
    private String text;
}
