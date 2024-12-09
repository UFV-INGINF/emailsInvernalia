package es.ufv.dis.firstAPI.InputOutput;


import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import es.ufv.dis.firstAPI.model.Email;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class InputOutput {

    Gson gson = new Gson();

    public Email readJson(String path) {
        try (FileReader reader = new FileReader(path)) {
            return gson.fromJson(reader, Email.class);
        } catch (JsonIOException | JsonSyntaxException | IOException e) {
            e.printStackTrace();
            return null;
        }

    }

    public ArrayList<Email> readEMails(String path) {
        try (FileReader reader = new FileReader(path)) {
            return gson.fromJson(reader, new TypeToken<ArrayList<Email>>() {
            }.getType());
        } catch (JsonIOException | JsonSyntaxException | IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<Email> writeEmails(String path, ArrayList<Email> emails) {
        try (FileWriter writer = new FileWriter(path)) {
            gson.toJson(emails, writer);
            return emails;
        } catch (JsonIOException | IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
