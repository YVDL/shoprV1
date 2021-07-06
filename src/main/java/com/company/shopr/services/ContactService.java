package com.company.shopr.services;

import com.company.shopr.domain.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class ContactService {

    @Autowired
    private JavaMailSender jms;

    public void sendMail(Contact newContact){
        SimpleMailMessage email = new SimpleMailMessage();
        email.setFrom(newContact.getEmail());
        email.setTo("yourivanderleyden@gmail.com");
        email.setSubject("Nieuw contact : " + newContact.getFirstName() + " " + newContact.getLastName());
        email.setText(newContact.getMessage());
        jms.send(email);
    }

}
