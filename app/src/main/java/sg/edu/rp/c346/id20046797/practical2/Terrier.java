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

public class Terrier extends AppCompatActivity {

    private int currentFontSize = 16;

    TextView tvScientific, tvDescription, tvDisplay, tvLearnMore;
    Button btnReturnback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terrier);

        // Text View Find By.
        tvScientific = findViewById(R.id.textViewScientific7);
        tvDescription = findViewById(R.id.textViewDescription7);
        tvDisplay = findViewById(R.id.textViewDisplay7);
        tvLearnMore = findViewById(R.id.textViewLearnMore7);

        // Button Find By.
        btnReturnback = findViewById(R.id.buttonReturn7);

        registerForContextMenu(tvDisplay);

        // On Create Formats.
        tvDisplay.setText(String.format(
                "Most breeders will tell you all the rumors about Ireland’s most popular dog’s large size are an exaggeration. " +
                        "They are big dogs, but only when compared to other terriers. " +
                        "In the world of dogs in general, the Irish terrier is only medium-sized."
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
                        "Most breeders will tell you all the rumors about Ireland’s most popular dog’s large size are an exaggeration. " +
                                "They are big dogs, but only when compared to other terriers. " +
                                "In the world of dogs in general, the Irish terrier is only medium-sized."
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
                        "One of the nicknames of the Irish terrier is “d’Artagnan.” " +
                                "It refers to his winning ways and cool confidence. " +
                                "Another nickname is “Daredevil,” a nod to the pooch’s knack for running into danger.\n\n" +
                                "Stouthearted and rugged, the Irish terrier is one of the original terrier breeds. " +
                                "With her fiery, typically red wiry coat, the dog’s a mid-sized creature that’s suited to her roots in Ireland. " +
                                "The coat can also be dark or black."
                ));
            }
        });

        // Learn More
        tvLearnMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentURL = new Intent(Intent.ACTION_VIEW, Uri.parse("https://a-z-animals.com/animals/irish-terrier/"));
                startActivity(intentURL);
            }
        });

        // The return button
        btnReturnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Terrier.this, MainActivity.class);
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