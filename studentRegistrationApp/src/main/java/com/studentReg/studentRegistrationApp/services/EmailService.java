package com.studentReg.studentRegistrationApp.services;

import com.studentReg.studentRegistrationApp.entities.Module;
import com.studentReg.studentRegistrationApp.entities.Qualification;
import com.studentReg.studentRegistrationApp.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailParseException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class EmailService {
    @Autowired
    private JavaMailSender javaMailSender;

    public void sendMail(String emailSubject, Student student){
        htmlEmail(emailSubject, student);
    }

    public void htmlEmail(String emailSubject, Student student){
        MimeMessage message = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, false, "utf-8");
            String htmlMsg = "<body><h4 style='color:green;'> Dear <b style='color:red;'>" + student.getName() + " " + student.getSurName() + "</b><br><br>"
                    + "\n Your registration information is successfully uploaded with following details: <br><table>";

            for(Qualification qualification : student.getQualifications()){
                htmlMsg += "<tr><td>Qualification:     </td><td>  " + qualification.getName() + "</td></tr>"
                        + "<tr><td>Qualification Code:   </td><td>  " + qualification.getCode() + "</td></tr>";

                for(Module module : qualification.getModules()){
                    htmlMsg += "<tr><td>Module Name:   </td><td>  " + module.getName() + "</td></tr>"
                            + "<tr><td>Module Code:   </td><td>  " + module.getCode() + "</td></tr>";
                }
            }

            htmlMsg+= "</h4</body>";

            message.setContent(htmlMsg, "text/html");
            helper.setTo(student.getEmail());
            helper.setSubject(emailSubject);

            javaMailSender.send(message);
        } catch (MessagingException e) {
            throw new MailParseException(e);
        }
    }
}
