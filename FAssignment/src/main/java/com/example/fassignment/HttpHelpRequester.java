package com.example.fassignment;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.List;

public class HttpHelpRequester {
    private static final String API_URL = "https://api.api-ninjas.com/v1/dogs?name=";
    private static final String API_KEY = "BqEshKo2hlWrJWrbNKeZyQ==KXn559zPx4e2jJ2P";

    public static List<DogInfo> getDogBreedInfo(String dogBreedName) throws IOException, InterruptedException {
        String encodedName = URLEncoder.encode(dogBreedName, StandardCharsets.UTF_8);
        String apiUrl = API_URL + encodedName;

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder(new URI(apiUrl))
                    .header("X-Api-Key", API_KEY)
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                return parseJsonResponse(response.body());
            }
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    private static List<DogInfo> parseJsonResponse(String json) {
        Gson gson = new Gson();
        return gson.fromJson(json, new TypeToken<List<DogInfo>>() {}.getType());
    }
}
