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

public class Iguana extends AppCompatActivity {

    private int currentFontSize = 16;

    TextView tvScientific, tvDescription, tvDisplay, tvLearnMore;
    Button btnReturnback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iguana);

        // Text View Find By.
        tvScientific = findViewById(R.id.textViewScientific8);
        tvDescription = findViewById(R.id.textViewDescription8);
        tvDisplay = findViewById(R.id.textViewDisplay8);
        tvLearnMore = findViewById(R.id.textViewLearnMore8);

        // Button Find By.
        btnReturnback = findViewById(R.id.buttonReturn8);

        registerForContextMenu(tvDisplay);

        // On Create Formats.
        tvDisplay.setText(String.format(
                "The scientific name of this animal is Iguana iguana. " +
                        "It most commonly refers to the green iguana that is distributed through much of the southern United States. " +
                        "All iguana are reptiles who are members of the order Squamata and the suborder Iguania and the family Iguanidae. \n\n" +
                        "The rhino iguana, found primarily on the Caribbean island of Hispaniola, has the scientific name Cyclura cornuta. " +
                        "The blue iguana has the scientific name Cyclura lewisi. " +
                        "Other genera include the desert iguana, Dipsosaurus dorsalis, and the marine, Amblyrynchus, and terrestrial, " +
                        "Conolophus, iguanas of the Galapagos Islands."
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
                        "The scientific name of this animal is Iguana iguana. " +
                                "It most commonly refers to the green iguana that is distributed through much of the southern United States. " +
                                "All iguana are reptiles who are members of the order Squamata and the suborder Iguania and the family Iguanidae. \n\n" +
                                "The rhino iguana, found primarily on the Caribbean island of Hispaniola, has the scientific name Cyclura cornuta. " +
                                "The blue iguana has the scientific name Cyclura lewisi. " +
                                "Other genera include the desert iguana, Dipsosaurus dorsalis, and the marine, Amblyrynchus, and terrestrial, " +
                                "Conolophus, iguanas of the Galapagos Islands."
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
                        "Native to the jungles of Central and South America and many islands in the Caribbean, " +
                                "Iguanas are large lizards that are also popular with Americans who want to keep them as pets.\n" +
                                "\n" +
                                "The name iguana comes from the original Taino name for these lizards, iwana. " +
                                "Green iguanas are the most widely known species as they are often kept as pets. " +
                                "Most pet iguanas have a low price. " +
                                "They are also considered nuisances in Puerto Rico and some parts of the United States, " +
                                "particularly Florida, where they have become an invasive species."
                ));
            }
        });

        // Learn More
        tvLearnMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentURL = new Intent(Intent.ACTION_VIEW, Uri.parse("https://a-z-animals.com/animals/iguana/"));
                startActivity(intentURL);
            }
        });

        // The return button
        btnReturnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Iguana.this, MainActivity.class);
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