package androidtown.org.march21st;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnStart = findViewById(R.id.btnStartService);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startService(new Intent(MainActivity.this, MyService.class));
            }
        });

        Button btnStop = findViewById(R.id.btnStopService);
        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopService(new Intent(MainActivity.this, MyService.class));
            }
        });
    }


    /*
    String tag = "LifeCycle";
    // Called when the activity is first created.
   @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d (tag, "In the onCreate() event");
    }
    protected void onStart() {
        super.onStart();
        Log.d (tag, "In the onStart() event");
    }
    protected void onRestart() {
        super.onRestart();
        Log.d (tag, "In the onRestart() event");
    }

    protected void onResume() {
        super.onResume();
        Log.d (tag, "In the onRestart() event");
    }

    protected void onPause() {
        super.onPause();
        Log.d (tag, "In the onPause() event");
    }

    protected void onStop() {
        super.onStop();
        Log.d (tag, "In the onStop() event");
    }

    protected void onDestroy() {
        super.onDestroy();
        Log.d (tag, "In the onDestroy() event");
    }

    */
}