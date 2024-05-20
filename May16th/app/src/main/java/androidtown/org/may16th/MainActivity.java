package androidtown.org.may16th;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.io.DataInputStream;
import java.io.InputStream;
import java.net.Socket;

public class MainActivity extends AppCompatActivity {

    private Handler handler = new Handler(Looper.getMainLooper());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText input01 = findViewById(R.id.editText01);
        Button button01 = findViewById(R.id.button01);

        button01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String addr = input01.getText().toString().trim();
                ConnectThread thread = new ConnectThread(addr);
                thread.start();
            }
        });
    }

    class ConnectThread extends Thread {
        String hostname;

        public ConnectThread(String addr) {
            hostname = addr;
        }

        @Override
        public void run() {
            try {
                int port = 7777;
                Socket sock = new Socket(hostname, port);

                // 연결 성공 시 서버의 IP 주소와 포트 번호를 포함한 토스트 메시지 표시
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        String message = "서버에 연결되었습니다: " + sock.getInetAddress().getHostAddress() + ":" + port;
                        Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
                    }
                });

                InputStream in = sock.getInputStream();
                DataInputStream dis = new DataInputStream(in);

                Log.d("MainActivity", "서버에서 받은 메시지 : " + dis.readUTF());

                dis.close();
                sock.close();
            } catch(Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}