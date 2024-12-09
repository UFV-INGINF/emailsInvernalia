package es.ufv.dis.email.services;

import java.io.IOException;
import java.io.Serializable;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import es.ufv.dis.email.model.Email;
import org.springframework.stereotype.Service;

@Service
public class EmailService implements Serializable {

    public String greet(String name) {
        if (name == null || name.isEmpty()) {
            return "Hello anonymous user";
        } else {
            return "Hello " + name;
        }
    }



    public ArrayList<Email> getEmails() {

        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI("http://backend-emails:8081/api/v1/emails"))
                    .GET()
                    .build();
            HttpClient client = HttpClient.newHttpClient();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            Gson gson = new Gson();

            ArrayList<Email> emails = gson.fromJson(response.body(), new TypeToken<ArrayList<Email>>(){}.getType());

            System.out.println(emails);
            return emails;


        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }
}
