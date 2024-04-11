package com.example.spotifytutorialtrialrun;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;

public class LLMChat {
    String prompt = "Describe how I would act/think/dress based on my favorite artists who include ";
    public static String chatGPT(String prompt) {
        String url = "https://api.openai.com/v1/chat/completions";
        String apiKey = "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";
        String model = "gpt-3.5-turbo";
        Wrapped wrapped = new Wrapped();
        List<Artist> favArtists = wrapped.getFavoriteArtists();
        String favArtistDescription = "";

        for (Artist artist : favArtists) {
            if (favArtists.indexOf(artist) == favArtists.size() - 1) {
                favArtistDescription += artist.getName();
                break;
            }
            favArtistDescription = favArtistDescription + artist.getName() + ", ";
        }
        String finalPrompt = prompt + favArtistDescription + ". ";

        try {
            URL obj = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) obj.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Authorization", "Bearer " + apiKey);
            connection.setRequestProperty("Content-Type", "application/json");

            // Request
            String body = "{\"model\": \"" + model + "\", \"messages\": [{\"role\": \"user\", \"content\": \"" + finalPrompt + "\"}], \"max_tokens\": 20}";
            connection.setDoOutput(true);
            OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream());
            writer.write(body);
            writer.flush();
            writer.close();

            // Response from ChatGPT
            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;

            StringBuffer response = new StringBuffer();

            while ((line = br.readLine()) != null) {
                response.append(line);
            }
            br.close();

            // Converts JSON response to String format
            return extractGeneratedResponse(response.toString());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static String extractGeneratedResponse(String jsonResponse) {
        try {
            JSONObject responseObject = new JSONObject(jsonResponse);
            JSONArray completions = responseObject.getJSONArray("completions");

            // Iterate over completions to find assistant's response
            for (int i = 0; i < completions.length(); i++) {
                JSONObject completion = completions.getJSONObject(i);
                String role = completion.getString("role");
                if (role.equals("assistant")) {
                    return completion.getString("content");
                }
            }

            // If no assistant response found, return null or handle appropriately
            return null;
        } catch (JSONException e) {
            // Handle JSON parsing exception
            e.printStackTrace();
            return null;
        }
    }
}