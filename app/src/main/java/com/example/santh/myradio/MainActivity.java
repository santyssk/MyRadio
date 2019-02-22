package com.example.santh.myradio;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    Button[] button=new Button[9];
    Button mute,refresh;
    Button[] close=new Button[4];
    TextView text;
    CountDownTimer countDownTimer;
    MediaPlayer mediaPlayer = new MediaPlayer();
    int current=-1;
    String[] urls={"http://16813.live.streamtheworld.com/RADIO_TAMIL_PST_128.mp3","http://16813.live.streamtheworld.com/RADIO_TAMIL_CST_128.mp3",
            "http://17473.live.streamtheworld.com/RADIO_TAMIL_EST_128_SC","bigfm","http://163.172.165.94:8320/;stream.mp3","http://163.172.165.94:8736/;stream.mp3",
            "http://104.238.193.114:7077/;","http://163.172.165.94:8728/;stream.mp3","http://163.172.165.94:8720/;stream.mp3"};

    public void Radio(int url){
        if(current!=url) {
            if(current!=-1)
                button[current].setBackground(getDrawable(R.drawable.round_button));
            button[url].setBackground(getDrawable(R.drawable.play_round_button));
            try {
                Log.w("Initiating radio ",url+"");
                mediaPlayer.stop();
                mediaPlayer.reset();
                mediaPlayer.setDataSource(urls[url]);
                mediaPlayer.prepare(); // might take long! (for buffering, etc)
                mediaPlayer.start();
                current = url;
            } catch (IOException e) {
                Log.w("Encountered Exception "+url+" ",e.getCause());
            }
        }
    }

    public  void Close(int i){
        if(countDownTimer!=null)
            countDownTimer.cancel();
        Calendar now=Calendar.getInstance();
        now.add(Calendar.MINUTE,(i+1)*15);
        text.setText("App will close at "+new SimpleDateFormat("hh:mm aa").format(now.getTime()));
        for(int j=0;j<4;j++){
            if(j!=i)
                close[j].setBackground(getDrawable(R.drawable.round_button));
            else
                close[j].setBackground(getDrawable(R.drawable.stop_round_button));
        }
        final int minutes_int=(i+1)*15*60*1000;
        countDownTimer = new CountDownTimer(minutes_int,60000) {
            @Override
            public void onTick(long l) {
                //Log.w("Time left to close app",(l/1000)/60+"");
            }
            @Override
            public void onFinish() {
                finishAndRemoveTask();
                System.exit(0);
            }
        };
        countDownTimer.start();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.w("Starting App ","myRadio");
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        button[0]=findViewById(R.id.button10);
        button[1]=findViewById(R.id.button11);
        button[2]=findViewById(R.id.button12);
        button[3]=findViewById(R.id.button2);
        button[4]=findViewById(R.id.button3);
        button[5]=findViewById(R.id.button4);
        button[6]=findViewById(R.id.button50);
        button[7]=findViewById(R.id.button51);
        button[8]=findViewById(R.id.button6);
        mute=findViewById(R.id.mute);
        refresh=findViewById(R.id.refresh);
        close[0]=findViewById(R.id.close15);
        close[1]=findViewById(R.id.close30);
        close[2]=findViewById(R.id.close45);
        close[3]=findViewById(R.id.close60);
        text=findViewById(R.id.text);
        button[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Radio(0);
            }
        });
        button[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Radio(1);
            }
        });
        button[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Radio(2);
            }
        });
        button[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Radio(3);
            }
        });
        button[4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Radio(4);
            }
        });
        button[5].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Radio(5);
            }
        });
        button[6].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Radio(6);
            }
        });
        button[7].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Radio(7);
            }
        });
        button[8].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Radio(8);
            }
        });
        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.w("Current Radio ",current+" ");
                if(current!=-1) {
                    try {
                        Log.w("Initiating refresh for ", current + "");
                        mediaPlayer.reset();
                        mediaPlayer.setDataSource(urls[current]);
                        mediaPlayer.prepare(); // might take long! (for buffering, etc)
                        mediaPlayer.start();
                    } catch (IOException e) {
                        Log.w("Refresh Exception", e.getCause());
                    }
                }
            }
        });
        mute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mute.getText() == "Mute") {
                    mediaPlayer.setVolume(0,0);
                    mute.setBackground(getDrawable(R.drawable.play_round_button));
                    mute.setText("Unmute");
                } else {
                    mediaPlayer.setVolume(0,1);
                    mute.setBackground(getDrawable(R.drawable.stop_round_button));
                    mute.setText("Mute");
                }
            }
        });
        close[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Close(0);
            }
        });
        close[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Close(1);
            }
        });
        close[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Close(2);
            }
        });
        close[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Close(3);
            }
        });
    }
}
