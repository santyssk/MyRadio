package com.example.santh.myradio;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    Button button10,button11,button12,button2,button3,button4,button5,button6,mute,previous;
    String url = "http://17473.live.streamtheworld.com/RADIO_TAMIL_EST_128_SC"; // your URL here
    MediaPlayer mediaPlayer = new MediaPlayer();

    public void Radio(String url){
        try{
            mediaPlayer.stop();
            mediaPlayer.reset();
            mediaPlayer.setDataSource(url);
            mediaPlayer.prepare(); // might take long! (for buffering, etc)
            mediaPlayer.start();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.w("Radio","Start");
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        button10=findViewById(R.id.button10);
        button11=findViewById(R.id.button11);
        button12=findViewById(R.id.button12);
        button2=findViewById(R.id.button2);
        button3=findViewById(R.id.button3);
        button4=findViewById(R.id.button4);
        button5=findViewById(R.id.button5);
        button6=findViewById(R.id.button6);
        mute=findViewById(R.id.mute);
        button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                button10.setBackgroundColor(getResources().getColor(R.color.Green));
                if(previous!=null&&previous!=button10)
                    previous.setBackgroundColor(getResources().getColor(R.color.Lightblue));
                previous=button10;
                Log.w("Listening","8K EST");
                url="http://17473.live.streamtheworld.com/RADIO_TAMIL_EST_128_SC";
                Radio(url);
            }
        });
        button11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                button11.setBackgroundColor(getResources().getColor(R.color.Green));
                if(previous!=null&&previous!=button11)
                    previous.setBackgroundColor(getResources().getColor(R.color.Lightblue));
                previous=button11;
                Log.w("Listening","8K PST");
                url="http://16813.live.streamtheworld.com/RADIO_TAMIL_PST_128.mp3";
                Radio(url);
            }
        });
        button12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                button12.setBackgroundColor(getResources().getColor(R.color.Green));
                if(previous!=null&&previous!=button12)
                    previous.setBackgroundColor(getResources().getColor(R.color.Lightblue));
                previous=button12;
                Log.w("Listening","8K CST");
                url="http://16813.live.streamtheworld.com/RADIO_TAMIL_CST_128.mp3";
                Radio(url);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                button2.setBackgroundColor(getResources().getColor(R.color.Green));
                if(previous!=null&&previous!=button2)
                    previous.setBackgroundColor(getResources().getColor(R.color.Lightblue));
                previous=button2;
                Log.w("Listening","Big Fm");
                url="http://163.172.158.94:8062/;";
                Radio(url);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                button3.setBackgroundColor(getResources().getColor(R.color.Green));
                if(previous!=null&&previous!=button3)
                    previous.setBackgroundColor(getResources().getColor(R.color.Lightblue));
                previous=button3;
                Log.w("Listening","Radio Mirchi");
                url="http://163.172.158.94:8052/;stream.mp3";
                Radio(url);
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                button4.setBackgroundColor(getResources().getColor(R.color.Green));
                if(previous!=null&&previous!=button4)
                    previous.setBackgroundColor(getResources().getColor(R.color.Lightblue));
                previous=button4;
                Log.w("Listening","Radio City");
                url="http://prclive1.listenon.in:9948/;";
                Radio(url);
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                button5.setBackgroundColor(getResources().getColor(R.color.Green));
                if(previous!=null&&previous!=button5)
                    previous.setBackgroundColor(getResources().getColor(R.color.Lightblue));
                previous=button5;
                Log.w("Listening","Sooriyan Fm");
                url="http://104.238.193.114:7077/;";
                Radio(url);
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                button6.setBackgroundColor(getResources().getColor(R.color.Green));
                if(previous!=null&&previous!=button6)
                    previous.setBackgroundColor(getResources().getColor(R.color.Lightblue));
                previous=button6;
                Log.w("Listening","Hello Fm");
                url="http://163.172.158.94:8048/;/;";
                Radio(url);
            }
        });
        /*mute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mute.getText()=="Mute"){
                    AudioManager audioManager=(AudioManager)getSystemService(Context.AUDIO_SERVICE);
                    audioManager.adjustStreamVolume(AudioManager.STREAM_MUSIC, AudioManager.ADJUST_MUTE, 0);
                    mute.setText("Unmute");
                }
                else{
                    AudioManager audioManager=(AudioManager)getSystemService(Context.AUDIO_SERVICE);
                    audioManager.adjustStreamVolume(AudioManager.STREAM_MUSIC, AudioManager.ADJUST_UNMUTE, 0);
                    mute.setText("Mute");
                }
            }
        });*/
    }
}
