package com.example.demo.model;

import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
public class Mail {
    protected String mailSubject;
    protected String mailMessage;
    protected String mailAddress;
    protected List<String> mailAttachement;
}
