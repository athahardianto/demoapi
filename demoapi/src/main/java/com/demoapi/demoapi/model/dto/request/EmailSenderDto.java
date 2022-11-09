package com.demoapi.demoapi.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmailSenderDto {
    private String sendTo;
    private String subject;
    private String body;
    private String attachment;

}
