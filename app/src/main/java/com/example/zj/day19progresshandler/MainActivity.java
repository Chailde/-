package com.example.zj.day19progresshandler;

import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {
    ProgressBar progressBar;
    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 0:
                        progressBar.setProgress(num);
                    break;
                default:
                    break;
            }
        }
    };
    private static int num=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar= (ProgressBar) findViewById(R.id.pbId);
    }
    public  void click(View view){

        new  Thread(){
            @Override
            public void run() {
                super.run();
              while (num<101){
                  Message  message=new Message();
                  message.what=0;
                  message.arg1=num;
                  handler.sendMessage(message);
                  SystemClock.sleep(1000);
                  num++;
              }
            }
        }.start();
    }
}
