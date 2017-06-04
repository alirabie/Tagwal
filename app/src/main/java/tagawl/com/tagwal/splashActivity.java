package tagawl.com.tagwal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class splashActivity extends AppCompatActivity {
TextView txtphone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
       // txtphone=(TextView)findViewById(R.id.txtphone);
        Thread mythread = new Thread() {
            public void run() {
                try {
                    int mythread = 0;
                    while (mythread < 3500) {
                        sleep(100);
                        mythread = mythread + 100;
                    }

                    startActivity(new Intent(splashActivity.this, NavDrawerActivity.class));

                } catch (InterruptedException ie) {
                    ie.printStackTrace();

                } finally {
                    finish();
                }
            }

        };
        mythread.start();
    }
    }

