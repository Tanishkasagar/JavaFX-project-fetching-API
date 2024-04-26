package com.example.fassignment;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class DogBreedController {
    private final String apiUrl;
    private final String apiKey;

    public DogBreedController() {
        this.apiUrl = "https://api.api-ninjas.com/v1/dogs?name=";
        this.apiKey = "BqEshKo2hlWrJWrbNKeZyQ==KXn559zPx4e2jJ2P"; 
    }

    public List<DogInfo> searchDog(String dogName) {
        try {
            String encodedDogName = URLEncoder.encode(dogName, StandardCharsets.UTF_8);
            String uri = apiUrl + encodedDogName;

            URL url = new URL(uri);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("X-Api-Key", apiKey);

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                    StringBuilder response = new StringBuilder();
                    String line;
                    while ((line = reader.readLine()) != null) {
                        response.append(line);
                    }
                    return parseDogData(response.toString());
                }
            } else {
                System.err.println("HTTP error: " + responseCode);
                return List.of(); // Return empty list on HTTP error
            }
        } catch (IOException e) {
            e.printStackTrace();
            return List.of(); // Return empty list on exception
        }
    }

    private List<DogInfo> parseDogData(String jsonString) {
        Gson gson = new Gson();
        Type dogListType = new TypeToken<List<DogInfo>>() {}.getType();
        return gson.fromJson(jsonString, dogListType);
    }
}
