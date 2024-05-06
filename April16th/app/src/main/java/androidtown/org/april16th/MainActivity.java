package androidtown.org.april16th;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageButton;
import android.graphics.drawable.TransitionDrawable;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton button = (ImageButton) findViewById(R.id.button);
        TransitionDrawable drawable = (TransitionDrawable) button.getDrawable();
        drawable.startTransition(5000);
    }
}