package androidtown.org.may7th;

import androidx.appcompat.app.AppCompatActivity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    Button submit, exit;
    String username, password;
    EditText userinput, passinput;
    SharedPreferences sh_Pref;
    SharedPreferences.Editor toEdit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        submit = findViewById(R.id.submit);
        exit = findViewById(R.id.exit);
        userinput = findViewById(R.id.userinput);
        passinput = findViewById(R.id.passinput);
        submit.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view) {
                username = userinput.getText().toString();
                password = passinput.getText().toString();
                sharedPreference();
                Toast.makeText(getApplicationContext(), "Details are saved", Toast.LENGTH_LONG).show();
            }
        });
        exit.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        applySharedPreference();
    }
    public void sharedPreference() {
        sh_Pref = getSharedPreferences("Login Credentials", MODE_PRIVATE);
        toEdit = sh_Pref.edit();
        toEdit.putString("Username", username);
        toEdit.putString("Password", password);
        toEdit.commit();
    }
    public void applySharedPreference(){
        sh_Pref = getSharedPreferences("Login Credentials", MODE_PRIVATE);
        if (sh_Pref!=null && sh_Pref.contains("Username")){
            String name = sh_Pref.getString("Username", "noname");
            userinput.setText(name);
        }
    }
}