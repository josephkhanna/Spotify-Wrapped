package com.example.spotifytutorialtrialrun;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RecActivityHelper extends AppCompatActivity {

    private final Map<String, String> artistDescriptions = new HashMap<>();
    private final Map<String, List<String>> genreArtists = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        // Initialize artist descriptions and genre artists mapping
        initializeData();

        // Retrieve the artist and song information from the intent
        String fullArtistInfo = getIntent().getStringExtra(RecActivity.EXTRA_MESSAGE);
        String[] parts = fullArtistInfo.split(":");
        String artistName = parts[0].trim();
        String songTitle = parts.length > 1 ? parts[1].trim() : "Song Title Unavailable";

        // Set the song title and artist description
        TextView songTitleView = findViewById(R.id.textViewDescriptionblah);
        songTitleView.setText(songTitle);

        TextView artistDescriptionView = findViewById(R.id.textViewDescriptionblah1);
        artistDescriptionView.setText(artistDescriptions.getOrDefault(artistName, "Description not available."));

        // Populate and display related artists
        List<String> relatedArtists = getRelatedArtists(fullArtistInfo);
        ListView listView = findViewById(R.id.relatedItemsListView);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, relatedArtists);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent detailIntent = new Intent(RecActivityHelper.this, RecActivityHelper.class);
                detailIntent.putExtra(RecActivity.EXTRA_MESSAGE, relatedArtists.get(position));
                startActivity(detailIntent);
            }
        });

        // Implement the revised "Back" button functionality
        Button backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(v -> {
            Intent intent = new Intent(RecActivityHelper.this, RecActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            finish();
        });
    }

    private void initializeData() {
        // Artist descriptions
        artistDescriptions.put("Carrie Underwood", "You seem Interested in Country, here are some other artists I reccomend");
        artistDescriptions.put("Tim McGraw", "You seem Interested in Country, here are some other artists I reccomend");
        artistDescriptions.put("Hank Williams", "You seem Interested in Country, here are some other artists I reccomend");
        artistDescriptions.put("Eminem", "You seem Interested in Rap, here are some other artists I reccomend");
        artistDescriptions.put("50 Cent", "You seem Interested in Rap, here are some other artists I reccomend");
        artistDescriptions.put("Nicki Minaj", "You seem Interested in Rap, here are some other artists I reccomend");
        artistDescriptions.put("Katy Perry", "You seem Interested in Pop, here are some other artists I reccomend");
        artistDescriptions.put("Taylor Swift", "You seem Interested in Pop, here are some other artists I reccomend");
        artistDescriptions.put("Lady Gaga", "You seem Interested in Pop, here are some other artists I reccomend");
        artistDescriptions.put("Ozzy Osbourne", "You seem Interested in Metal, here are some other artists I reccomend");
        artistDescriptions.put("Iron Maiden", "You seem Interested in Metal, here are some other artists I reccomend");
        artistDescriptions.put("Metallica", "You seem Interested in Metal, here are some other artists I reccomend");
        // Add more descriptions as needed for each artist

        // Genre to artists mapping
        List<String> countryArtists = new ArrayList<>();
        countryArtists.add("Carrie Underwood: Before He Cheats");
        countryArtists.add("Tim McGraw: Live Like You Were Dying");
        countryArtists.add("Hank Williams: I'm So Lonesome I Could Cry");
        genreArtists.put("country", countryArtists);

        List<String> rapArtists = new ArrayList<>();
        rapArtists.add("Eminem: Lose Yourself");
        rapArtists.add("50 Cent: In Da Club");
        rapArtists.add("Nicki Minaj: Super Bass");
        genreArtists.put("rap", rapArtists);

        List<String> popArtists = new ArrayList<>();
        popArtists.add("Katy Perry: Firework");
        popArtists.add("Taylor Swift: Shake It Off");
        popArtists.add("Lady Gaga: Bad Romance");
        genreArtists.put("pop", popArtists);

        List<String> metalArtists = new ArrayList<>();
        metalArtists.add("Ozzy Osbourne: Crazy Train");
        metalArtists.add("Metallica: Enter Sandman");
        metalArtists.add("Iron Maiden: The Trooper"); // Assuming "Ares" does not have a specific song listed
        genreArtists.put("metal", metalArtists);
    }

    private List<String> getRelatedArtists(String fullArtistInfo) {
        for (Map.Entry<String, List<String>> entry : genreArtists.entrySet()) {
            for (String artistAndSong : entry.getValue()) {
                if (artistAndSong.equals(fullArtistInfo)) {
                    // Return a new list excluding the current artist
                    List<String> related = new ArrayList<>(entry.getValue());
                    related.remove(fullArtistInfo);
                    return related;
                }
            }
        }
        return new ArrayList<>(); // Return an empty list if the genre is not found
    }

    // Additional helper methods if needed...
}