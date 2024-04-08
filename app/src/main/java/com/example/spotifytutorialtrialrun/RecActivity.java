package com.example.spotifytutorialtrialrun;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RecActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.myapplication.MESSAGE";

    private Spinner spinnerInput;
    private Button buttonAdd;
    private ListView listViewClasses;
    private ArrayAdapter<String> adapter;
    private ArrayList<Map.Entry<String, String>> classesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rec_activity_main);

        spinnerInput = findViewById(R.id.spinnerInput);
        buttonAdd = findViewById(R.id.buttonAdd);
        listViewClasses = findViewById(R.id.listViewClasses);

        // Setup spinner options
        ArrayAdapter<CharSequence> spinnerAdapter = ArrayAdapter.createFromResource(this,
                R.array.input_options, android.R.layout.simple_spinner_item);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerInput.setAdapter(spinnerAdapter);

        classesList = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, new ArrayList<>());
        listViewClasses.setAdapter(adapter);

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String selectedInput = spinnerInput.getSelectedItem().toString();
                ArrayList<String> displayNames = new ArrayList<>(); // List to hold just the song titles for display

                classesList.clear(); // Clear the list for new items

                switch (selectedInput.toLowerCase()) {
                    case "country":
                        addSongWithDisplay("Carrie Underwood: Before He Cheats", displayNames);
                        addSongWithDisplay("Tim McGraw: Live Like You Were Dying", displayNames);
                        addSongWithDisplay("Hank Williams: I'm So Lonesome I Could Cry", displayNames);
                        break;
                    case "rap":
                        addSongWithDisplay("Eminem: Lose Yourself", displayNames);
                        addSongWithDisplay("50 Cent: In Da Club", displayNames);
                        addSongWithDisplay("Nicki Minaj: Super Bass", displayNames);
                        break;
                    case "pop":
                        addSongWithDisplay("Katy Perry: Firework", displayNames);
                        addSongWithDisplay("Taylor Swift: Shake It Off", displayNames);
                        addSongWithDisplay("Lady Gaga: Bad Romance", displayNames);
                        break;
                    case "metal":
                        addSongWithDisplay("Ozzy Osbourne: Crazy Train", displayNames);
                        addSongWithDisplay("Metallica: Enter Sandman", displayNames); // Example addition
                        addSongWithDisplay("Iron Maiden: The Trooper", displayNames); // Example addition
                        break;
                    default:
                        Toast.makeText(RecActivity.this, "Error: Invalid selection.", Toast.LENGTH_LONG).show();
                        return;
                }

                adapter.clear();
                adapter.addAll(displayNames);
                adapter.notifyDataSetChanged();
            }

            private void addSongWithDisplay(String fullEntry, ArrayList<String> displayList) {
                String[] parts = fullEntry.split(":");
                String display = parts.length > 1 ? parts[1].trim() : "Unknown"; // Just the song title
                classesList.add(new AbstractMap.SimpleEntry<>(fullEntry, display)); // Store full info
                displayList.add(display); // Add only song title for display
            }
        });

        listViewClasses.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(RecActivity.this, RecActivityHelper.class);
                String message = classesList.get(position).getKey(); // Get the full artist-song string
                intent.putExtra(EXTRA_MESSAGE, message);
                startActivity(intent);
            }
        });
    }
}