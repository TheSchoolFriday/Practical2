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

public class jellyfish extends AppCompatActivity {

    // Student ID: 20046797
    // Student NAME: Muhammad Fudayl Bin Mohamin

    private int currentFontSize = 16;

    TextView tvScientific, tvDescription, tvDisplay, tvLearnMore;
    Button btnReturnback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jellyfish);

        // Text View Find By.
        tvScientific = findViewById(R.id.textViewScientific5);
        tvDescription = findViewById(R.id.textViewDescription5);
        tvDisplay = findViewById(R.id.textViewDisplay5);
        tvLearnMore = findViewById(R.id.textViewLearnMore5);

        // Button Find By.
        btnReturnback = findViewById(R.id.buttonReturn5);

        registerForContextMenu(tvDisplay);

        // On Create Formats.
        tvDisplay.setText(String.format(
                "These animals go by the scientific name Scyphozoa and belong to the kingdom Animalia and phylum Cnidaria. " +
                        "Scyphozoa comes from two Greek words – skuphos and zōion. While skuphos means “drinking cup,” " +
                        "the word zōion means “animal.” The name is an interpretation to mean that this animal contains water. " +
                        "The phylum cnidaria is interesting as well since it comes from the modern Latin word knidē, which means “nettle.”"
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
                        "These animals go by the scientific name Scyphozoa and belong to the kingdom Animalia and phylum Cnidaria. " +
                                "Scyphozoa comes from two Greek words – skuphos and zōion. While skuphos means “drinking cup,” " +
                                "the word zōion means “animal.” The name is an interpretation to mean that this animal contains water. " +
                                "The phylum cnidaria is interesting as well since it comes from the modern Latin word knidē, which means “nettle.”"
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
                        "Jellyfish form a large family of planktonic creatures, " +
                                "and recent studies show that there are at least 4,000 that have already been discovered. " +
                                "Considering the vastness of the oceans, " +
                                "scientists believe that this number is barely a fraction of what is actually in the sea."
                ));
            }
        });

        // Learn More
        tvLearnMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentURL = new Intent(Intent.ACTION_VIEW, Uri.parse("https://a-z-animals.com/animals/jellyfish/"));
                startActivity(intentURL);
            }
        });

        // The return button
        btnReturnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(jellyfish.this, MainActivity.class);
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