package androidtown.org.march28th;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.CheckBox;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.util.Log;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    CheckBox chkCream, chkSugar;
    Button btnPay;
    RadioGroup radCoffeeType;
    RadioButton radDecaf, radEspresso, radColombian;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true; // Return true to display the menu
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        int curId = item.getItemId();
        if(curId == R.id.menu_refresh) {
            Toast.makeText(this, "새로고침 메뉴가 선택 됨", Toast.LENGTH_SHORT).show();
        } else if(curId == R.id.menu_search) {
            Toast.makeText(this, "검색 메뉴가 선택 됨", Toast.LENGTH_SHORT).show();
        } else if(curId == R.id.menu_settings) {
            Toast.makeText(this, "설정 메뉴가 선택 됨", Toast.LENGTH_SHORT).show();
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        chkCream = findViewById(R.id.chkCream);
        chkSugar = findViewById(R.id.chkSugar);
        btnPay = findViewById(R.id.btnPay);
        radCoffeeType = findViewById(R.id.radGroupCoffeeType);
        radDecaf = findViewById(R.id.radDecaf);
        radEspresso = findViewById(R.id.radExpresso);
        radColombian = findViewById(R.id.radColombian);


        //여기는 Toast를 이용해서 메세지를 띄우는 부분
        btnPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuilder msg = new StringBuilder("Coffee ");
                if (chkCream.isChecked()) {
                    msg.append("& cream ");
                }
                if (chkSugar.isChecked()) {
                    msg.append("& Sugar");
                }

                int radioId = radCoffeeType.getCheckedRadioButtonId();
                msg.append(determineCoffeeType(radioId));

                Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
            }

            private String determineCoffeeType(int radioId) {
                if (radDecaf.getId() == radioId) {
                    return "Decaf ";
                } else if (radColombian.getId() == radioId) {
                    return "Colombian ";
                } else if (radEspresso.getId() == radioId) {
                    return "Espresso ";
                } else {
                    return "";
                }
            }
        });


        //여기 아래부분은 클릭할때마다 logcat에 로그를 띄우는 부분
        chkCream.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Log.e("Cream Checkbox", "Checked");
                } else {
                    Log.e("Cream Checkbox", "Unchecked");
                }
            }
        });
        chkSugar.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Log.e("Sugar Checkbox", "Checked");
                } else {
                    Log.e("Sugar Checkbox", "Unchecked");
                }
            }
        });
        radCoffeeType.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                String coffeeType = "";
                if(checkedId == R.id.radDecaf) {
                    coffeeType = "Decaf ";
                } else if(checkedId == R.id.radColombian) {
                    coffeeType = "Colombian ";
                } else if(checkedId == R.id.radExpresso) {
                    coffeeType = "Espresso ";
                }
                Log.e("Coffee Type Selected", coffeeType);
            }
        });




    }
}