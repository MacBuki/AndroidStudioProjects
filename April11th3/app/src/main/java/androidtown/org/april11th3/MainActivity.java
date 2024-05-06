package androidtown.org.april11th3;

import androidx.appcompat.app.AppCompatActivity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    private int currentImageIndex = 0;
    private final int[] imageIds = {R.drawable.android_green, R.drawable.android_red, R.drawable.android_blue};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Initialize the LinearLayout container
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);

        // Initialize the ImageView and set the first image
        imageView = new ImageView(this);
        imageView.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));
        Drawable initialDrawable = getResources().getDrawable(imageIds[currentImageIndex], getTheme());
        imageView.setImageDrawable(initialDrawable);

        // Initialize the Button and set its properties
        Button myButton = new Button(this);
        myButton.setText("Push me");
        myButton.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));

        // Set an OnClickListener on the Button
        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentImageIndex = (currentImageIndex + 1) % imageIds.length; // Update the index to show the next image
                Drawable nextDrawable = getResources().getDrawable(imageIds[currentImageIndex], getTheme());
                imageView.setImageDrawable(nextDrawable); // Set the new image in the ImageView
            }
        });

        // Add the ImageView and Button to the LinearLayout
        layout.addView(imageView);
        layout.addView(myButton);

        // Set the LinearLayout as the content view
        setContentView(layout);
    }
}
