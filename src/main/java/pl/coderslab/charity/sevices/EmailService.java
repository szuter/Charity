package pl.coderslab.charity.sevices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.dto.MessageDTO;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender emailSender;

    public void sendSimpleMessage(MessageDTO data) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject(data.getFirstName() + " " + data.getLastName());
        message.setText(data.getMessage());
        message.setTo("piotrstrzelec1989@gmail.com");
        message.setFrom(data.getEmail());
        emailSender.send(message);
    }

}
