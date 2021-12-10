package com.example.demo.services;

import com.example.demo.model.Mail;

import javax.mail.MessagingException;

public interface IMail {

    void sendMail(Mail mail) throws MessagingException;

}
