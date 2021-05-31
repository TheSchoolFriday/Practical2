package sg.edu.rp.c346.id20046797.practical2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Tortoise extends AppCompatActivity {

    // Student ID: 20046797
    // Student NAME: Muhammad Fudayl Bin Mohamin

    private int currentFontSize = 16;

    TextView tvScientific, tvDescription, tvDisplay, tvLearnMore;
    Button btnReturnback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tortoise);

        // Text View Find By.
        tvScientific = findViewById(R.id.textViewScientific10);
        tvDescription = findViewById(R.id.textViewDescription10);
        tvDisplay = findViewById(R.id.textViewDisplay10);
        tvLearnMore = findViewById(R.id.textViewLearnMore10);

        // Button Find By.
        btnReturnback = findViewById(R.id.buttonReturn10);

        registerForContextMenu(tvDisplay);

        // On Create Formats.
        tvDisplay.setText(String.format(
                "The scientific name for the Indian star tortoise is Geochelone elegans. " +
                        "This tortoise is just one of two extant members of the genus Geochelone; " +
                        "the other is the Burmese star tortoise, Geochelone platynotan, " +
                        "which is native to Myanmar.\n" +
                        "\n" +
                        "The Indian star tortoise belongs to the class Reptilia, " +
                        "the order Testudines, the family Testudinidae and the genus Geochelone."
        ));

        tvScientific.setText(R.string.scientific_classification);

        tvDescription.setTextColor(Color.GRAY);

        // When they Click on Scientific
        tvScientific.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvScientific.setText(R.string.scientific_classification);
                tvScientific.setTextColor(Color.BLACK);

                tvDescription.setText(R.string.description);
                tvDescription.setTextColor(Color.GRAY);

                tvDisplay.setText(String.format(
                        "The scientific name for the Indian star tortoise is Geochelone elegans. " +
                                "This tortoise is just one of two extant members of the genus Geochelone; " +
                                "the other is the Burmese star tortoise, Geochelone platynotan, " +
                                "which is native to Myanmar.\n" +
                                "\n" +
                                "The Indian star tortoise belongs to the class Reptilia, " +
                                "the order Testudines, the family Testudinidae and the genus Geochelone."
                ));
            }
        });

        // When they Click on Description
        tvDescription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvDescription.setText(R.string.description);
                tvDescription.setTextColor(Color.BLACK);

                tvScientific.setText(R.string.scientific_classification);
                tvScientific.setTextColor(Color.GRAY);

                tvDisplay.setText(String.format(
                        "With its unique star-shaped patterns and relatively compact size, " +
                                "the Indian star tortoise is one of the most striking tortoises on the planet.\n" +
                                "\n" +
                                "Found in forests, grasslands, and shrublands across much of India, " +
                                "Pakistan and Sri Lanka, the species has a high tolerance for seasonally wet or dry habitats and therefore is fairly adaptable. " +
                                "Unfortunately, Indian star tortoises are popular in the international exotic pet trade, " +
                                "and this is primarily why the species is now listed as Vulnerable on the IUCN Red List. " +
                                "Various efforts are in place to protect these tortoises, including the Indian Wildlife Act of 1972."
                ));
            }
        });

        // Learn More
        tvLearnMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentURL = new Intent(Intent.ACTION_VIEW, Uri.parse("https://a-z-animals.com/animals/indian-star-tortoise/"));
                startActivity(intentURL);
            }
        });

        // The return button
        btnReturnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Tortoise.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    // When the Text is being held.
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.add(0, 0, 0, "Increase Font Size (" + currentFontSize + "sp)");
        menu.add(0, 1, 1, "Decrease Font Size (" + currentFontSize + "sp)");
    }

    // Which Item is Selected and the Function.
    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        // Performs the Check and Changes font size if necessary.
        if (currentFontSize > 24 && item.getItemId() == 0) {
            Toast.makeText(this, "Font Size too Large.", Toast.LENGTH_SHORT).show();
        } else if (currentFontSize < 10 && item.getItemId() == 1){
            Toast.makeText(this, "Font Size too Small.", Toast.LENGTH_SHORT).show();
        } else {
            switch(item.getItemId()) {
                case 0:
                    currentFontSize+=2;
                    break;
                case 1:
                    currentFontSize-=2;
                    break;
            }
        }

        // Change the Font SIZE.
        tvDisplay.setTextSize(TypedValue.COMPLEX_UNIT_SP, currentFontSize);
        return super.onContextItemSelected(item);
    }
}