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

public class Jackabee extends AppCompatActivity {

    // Student ID: 20046797
    // Student NAME: Muhammad Fudayl Bin Mohamin

    private int currentFontSize = 16;

    TextView tvScientific, tvDescription, tvDisplay, tvLearnMore;
    Button btnReturnback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jackabee);

        // Text View ID.
        tvScientific = findViewById(R.id.textViewScientific1);
        tvDescription = findViewById(R.id.textViewDescription1);
        tvDisplay = findViewById(R.id.textViewDisplay1);
        tvLearnMore = findViewById(R.id.textViewLearnMore1);

        // Button View ID.
        btnReturnback = findViewById(R.id.buttonReturn1);

        registerForContextMenu(tvDisplay);

        // On Create Formats
        tvDisplay.setText(String.format(
                "Don’t let its small size fool you. " +
                "The Jackabee has a playful, alert, and energetic personality with a rambunctious streak and a mind of its own. " +
                "Potential owners should be aware that its parent breeds were originally hunting dogs. \n\n" +
                "As such, they were expected to use their intelligence and independence to hunt down and trap prey. " +
                "This does not necessarily mean the Jackabee is a hunting dog now, " +
                "but you should still expect the dog to have some hunting instincts intact."
        ));

        tvScientific.setText(R.string.scientific_classification);
        tvDescription.setTextColor(Color.GRAY);

        // When they Click on the Word Scientific
        tvScientific.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvScientific.setText(R.string.scientific_classification);
                tvScientific.setTextColor(Color.BLACK);

                tvDescription.setText(R.string.description);
                tvDescription.setTextColor(Color.GRAY);

                tvDisplay.setText(String.format(
                        "Don’t let its small size fool you. " +
                        "The Jackabee has a playful, alert, and energetic personality with a rambunctious streak and a mind of its own. " +
                        "Potential owners should be aware that its parent breeds were originally hunting dogs. \n\n" +
                        "As such, they were expected to use their intelligence and independence to hunt down and trap prey. " +
                        "This does not necessarily mean the Jackabee is a hunting dog now, " +
                        "but you should still expect the dog to have some hunting instincts intact."
                ));
            }
        });

        // When they Click on Description
        tvDescription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvScientific.setText(R.string.scientific_classification);
                tvScientific.setTextColor(Color.GRAY);

                tvDescription.setText(R.string.description);
                tvDescription.setTextColor(Color.BLACK);

                tvDisplay.setText(String.format(
                        "The Jackabee is a spunky, hard-working, and upbeat little mix with almost endless reserves of energy. " +
                                "It is produced from a cross between a Jack Russell or Russell Terrier and a Beagle. " +
                                "The Jack Russell Terrier is a curious and lively terrier that was developed in the 19th century for the purpose of fox hunting – " +
                                "a very popular pastime among the English upper class at the time. \n\n" +
                                "The Beagle is a fun-loving, happy-go-lucky pack hound that originated centuries ago to hunt smaller game animals. " +
                                "While on the hunt, the terrier and hound actually had complementary roles. " +
                                "The terrier would chase the fox out of its den, and the hound would hunt it down and trap it."
                ));
            }
        });

        // Learn More
        tvLearnMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentURL = new Intent(Intent.ACTION_VIEW, Uri.parse("https://a-z-animals.com/animals/jackabee/"));
                startActivity(intentURL);
            }
        });

        // The return back
        btnReturnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Jackabee.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.add(0, 0, 0, "Increase Font Size (" + currentFontSize + "sp)");
        menu.add(0, 1, 1, "Decrease Font Size (" + currentFontSize + "sp)");
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        // Performs the check and changes the font size if necessary
        if (currentFontSize > 24 && item.getItemId() == 0) {
            Toast.makeText(this, "Font Size too Large.", Toast.LENGTH_SHORT).show();
        } else if (currentFontSize < 10 && item.getItemId() == 1) {
            Toast.makeText(this, "Font Size too Small.", Toast.LENGTH_SHORT).show();
        } else {
            switch (item.getItemId()) {
                case 0:
                    currentFontSize += 2;
                    break;

                case 1:
                    currentFontSize -= 2;
                    break;
            }
        }

        // Change the Font Size.
        tvDisplay.setTextSize(TypedValue.COMPLEX_UNIT_SP, currentFontSize);
        return super.onContextItemSelected(item);
    }
}