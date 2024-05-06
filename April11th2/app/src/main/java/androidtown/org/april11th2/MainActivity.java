package androidtown.org.april11th2;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import org.android.customview.canvas.MyDrawEx; // Import your custom view class

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyDrawEx myDrawView = new MyDrawEx(this);
        setContentView(myDrawView);
    }
}
