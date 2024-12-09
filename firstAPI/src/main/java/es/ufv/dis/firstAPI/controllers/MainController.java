package es.ufv.dis.firstAPI.controllers;

import com.sun.tools.javac.Main;
import es.ufv.dis.firstAPI.model.Email;
import es.ufv.dis.firstAPI.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1")
public class MainController {

    private final EmailService emailService;

    @Autowired
    public MainController(EmailService emailServiceparam) {
        this.emailService = emailServiceparam;
    }

    /**
     * Get all products.
     *
     * @return the ResponseEntity with status 200 (OK) and with body of the list of products
     */
    @GetMapping("/emails")
    public ArrayList<Email> getAllProducts() {

        return emailService.getAllEmails();
    }

    @GetMapping("/emails/{to}")
    public ResponseEntity<Email> getEmailByTo(@PathVariable String to) {
        Email email = emailService.getEmailByTo(to);
        return email != null ? ResponseEntity.ok(emailService.getEmailByTo(to)) : ResponseEntity.notFound().build();
    }

    @PostMapping("/emails")
    public ResponseEntity<ArrayList<Email>> createEmail(@RequestBody Email email) {
        return ResponseEntity.ok(emailService.createEmail(email));
    }

    @PutMapping("/emails/{to}")
    public ResponseEntity<Email> updateEmail(@PathVariable String to, @RequestBody Email email) {
        return ResponseEntity.ok(emailService.updateEmail(to, email));
    }

    @DeleteMapping("/emails/{to}")
    public ResponseEntity<Boolean> deleteEmail(@PathVariable String to) {
        if (emailService.getEmailByTo(to) == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(emailService.deleteEmail(to));
    }
}
