package com.example.demo.services;

import com.example.demo.model.Mail;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class MailServiceImpl implements IMail {

    private final JavaMailSender javaMailSender;
    private final IFileStorageService storageService;
    private final Path root = Paths.get("uploads");

    @Override
    public void sendMail(Mail mail) throws MailException, MessagingException {

//        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
//        simpleMailMessage.setTo(mail.getMailAddress());
//        simpleMailMessage.setSubject(mail.getMailSubject());
//        simpleMailMessage.setText(mail.getMailMessage());
//        javaMailSender.send(simpleMailMessage);


        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage,true);
        mimeMessageHelper.setTo(mail.getMailAddress());
        mimeMessageHelper.setSubject(mail.getMailSubject());
        mimeMessageHelper.setText(mail.getMailMessage());
        for (int i = 0; i < mail.getMailAttachement().size(); i++){
            Resource file =  storageService.load(mail.getMailAttachement().get(i));
            mimeMessageHelper.addAttachment(Objects.requireNonNull(mail.getMailAttachement().get(i)),file);
        }
//        FileSystemResource fileSystemResource = new FileSystemResource(new File(mail.getMailAttachement()));

        javaMailSender.send(mimeMessage);

    }
}
