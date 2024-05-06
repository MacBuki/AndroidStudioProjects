package androidtown.org.april18th;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;


public class MainActivity extends AppCompatActivity {
    ImageView imageView1;
    EditText editText;
    Button buttonRight, buttonLeft;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView1 = (ImageView) findViewById(R.id.imageView1);
        editText = (EditText) findViewById(R.id.editText);
        buttonRight = (Button) findViewById(R.id.buttonRight);
        buttonLeft = (Button) findViewById(R.id.buttonLeft);

        buttonRight.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Animation animRight = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.translate);
                imageView1.startAnimation(animRight);
                editText.append("오른쪽으로\n");
            }
        });

        buttonLeft.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Animation animLeft = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.move_left);
                imageView1.startAnimation(animLeft);
                editText.append("왼쪽으로\n");
            }
        });
    }
}
