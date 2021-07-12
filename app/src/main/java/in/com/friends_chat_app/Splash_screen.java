package in.com.friends_chat_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class Splash_screen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        getSupportActionBar().hide();
        
        Thread th = new Thread(){
            @Override
            public void run(){
                try {
                    sleep(4000);
                }
                catch (Exception e){
                    Toast.makeText(Splash_screen.this, "", Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }
                finally {
                    Intent i = new Intent(Splash_screen.this,MainActivity.class);
                    startActivity(i);
                }
                
            }
        };
        th.start();
    }
}