package androidtown.org.april4th_2;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    Button changeListButton;

    String[] names = {"LEE", "CHOI", "KIM", "JEONG", "RHO"};
    String[] otherNames = {"PARK", "YUN", "HWANG", "MOON", "CHO"};
    boolean showingFirstList = true; // 상태 변수 추가

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listview);
        changeListButton = (Button) findViewById(R.id.changeListButton);

        // 초기 리스트 설정
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, names);
        listView.setAdapter(adapter);

        changeListButton.setOnClickListener(v -> {
            // 버튼 클릭 시 리스트 전환
            ArrayAdapter<String> newAdapter;
            if (showingFirstList) {
                newAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, otherNames);
            } else {
                newAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, names);
            }
            listView.setAdapter(newAdapter);
            showingFirstList = !showingFirstList; // 상태 전환
        });
    }
}
