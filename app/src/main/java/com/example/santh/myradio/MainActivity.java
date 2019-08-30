package com.example.santh.myradio;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    Button mute,refresh;
    Button[] close=new Button[4];
    TextView text;
    CountDownTimer countDownTimer;
    MediaPlayer mediaPlayer = new MediaPlayer();
    RadioStation current = null;

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
        Button est8k = findViewById(R.id.est8k);
        Button bigfm = findViewById(R.id.bigfm);
        Button mirchi = findViewById(R.id.mirchi);
        Button radiocity = findViewById(R.id.radiocity);
        Button suryafm = findViewById(R.id.suryanfm);
        Button hellofm = findViewById(R.id.hellofm);

        mute=findViewById(R.id.mute);
        refresh=findViewById(R.id.refresh);
        close[0]=findViewById(R.id.close15);
        close[1]=findViewById(R.id.close30);
        close[2]=findViewById(R.id.close45);
        close[3]=findViewById(R.id.close60);
        text=findViewById(R.id.text);

        final RadioStation Mirchi = new RadioStation("http://51.15.200.126:8002/1",mirchi,this);
        final RadioStation Suryanfm = new RadioStation("http://51.15.86.61:8002/1",suryafm,this);
        final RadioStation Radiocity = new RadioStation("http://51.15.86.61:8002/3",radiocity,this);
        final RadioStation Hellofm = new RadioStation("http://51.15.200.126:8002/5",hellofm,this);
        final RadioStation Bigfm = new RadioStation("http://51.15.86.61:8002/5",bigfm,this);
        final RadioStation Est8k = new RadioStation("http://17473.live.streamtheworld.com/RADIO_TAMIL_EST_128_SC",est8k,this);

        est8k.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(current != null)
                    current.Stop();
                Est8k.Play(mediaPlayer);
                current=Est8k;
            }
        });
        bigfm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(current != null)
                    current.Stop();
                Bigfm.Play(mediaPlayer);
                current=Bigfm;
            }
        });
        mirchi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(current != null)
                    current.Stop();
                Mirchi.Play(mediaPlayer);
                current=Mirchi;
            }
        });
        radiocity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(current != null)
                    current.Stop();
                Radiocity.Play(mediaPlayer);
                current=Radiocity;
            }
        });
        suryafm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(current != null)
                    current.Stop();
                Suryanfm.Play(mediaPlayer);
                current=Suryanfm;
            }
        });
        hellofm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(current != null)
                    current.Stop();
                Hellofm.Play(mediaPlayer);
                current=Hellofm;
            }
        });

        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.w("Current Radio ",current+" ");
                if(current != null)
                    current.Play(mediaPlayer);
            }
        });
        mute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mute.getText() == "Mute") {
                    mediaPlayer.setVolume(0,0);
                    mute.setBackground(getDrawable(R.drawable.play_round_button));
                    mute.setText(R.string.Unmute);
                } else {
                    mediaPlayer.setVolume(0,1);
                    mute.setBackground(getDrawable(R.drawable.stop_round_button));
                    mute.setText(R.string.Mute);
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

                close[3].setText("");
            }
        });
    }
}
