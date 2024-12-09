package es.ufv.dis.firstAPI.services;


import es.ufv.dis.firstAPI.InputOutput.InputOutput;
import es.ufv.dis.firstAPI.model.Email;
import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

@Service
public class EmailService {

    public ArrayList<Email> getAllEmails() {

        InputOutput inputOutput = new InputOutput();
        this.writeCounterToFile("exit/salida.txt", 1);
        return inputOutput.readEMails("ListEmails.json");


    }

    private void writeCounterToFile(String fileName, int counter) {
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write("Counter: " + counter);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Email getEmailByTo(String to) {
        InputOutput inputOutput = new InputOutput();
        ArrayList<Email> emails = inputOutput.readEMails("ListEmails.json");
        for (Email email : emails) {
            if (email.getTo().toLowerCase().equals(to.toLowerCase())) {
                return email;
            }
        }
        return null;
    }

    public ArrayList<Email> createEmail(Email email) {
        InputOutput inputOutput = new InputOutput();
        ArrayList<Email> emails = inputOutput.readEMails("ListEmails.json");
        emails.add(email);

        return inputOutput.writeEmails("ListEmails.json", emails);
    }

    public Email updateEmail(String to, Email email) {
        InputOutput inputOutput = new InputOutput();
        ArrayList<Email> emails = inputOutput.readEMails("ListEmails.json");
        for (int i = 0; i < emails.size(); i++) {
            if (emails.get(i).getTo().toLowerCase().equals(to.toLowerCase())) {
                emails.set(i, email);
            }
        }
        inputOutput.writeEmails("ListEmails.json", emails);
        return email;
    }

    public Boolean deleteEmail(String to) {
        InputOutput inputOutput = new InputOutput();
        ArrayList<Email> emails = inputOutput.readEMails("ListEmails.json");
        for (int i = 0; i < emails.size(); i++) {
            if (emails.get(i).getTo().toLowerCase().equals(to.toLowerCase())) {
                emails.remove(i);
                inputOutput.writeEmails("ListEmails.json", emails);
                return true;
            }
        }

        emails.stream().forEach(element -> {
            if (element.getTo().toLowerCase().equals(to.toLowerCase())) {
                inputOutput.writeEmails("ListEmails.json", emails);
            }
            System.out.println(element);
        });
        return false;
    }

}
