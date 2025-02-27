package br.edu.ifpb.exemplosjpa.email;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/email")
public class EmailContoller {
    private EmailService emailService;

    public EmailContoller(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping
    public ResponseEntity<String> send() {
        Email email = new Email("wesley.c.alves98@gmail.com", "teste", "teste body");
        emailService.sendEmail(email);
        return ResponseEntity.ok("Email enviado");
    }

}
