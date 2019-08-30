package com.example.santh.myradio;

import android.content.Context;
import android.media.MediaPlayer;
import android.util.Log;
import android.widget.Button;

import java.io.IOException;

public class RadioStation {
    String url;
    Button button;
    Context context;
    RadioStation(String url, Button button, Context context){
        this.url = url;
        this.button = button;
        this.context = context;
    }
    void Play(MediaPlayer mediaPlayer){
        try {
            Log.w("Initiating radio ",url+"");
            mediaPlayer.stop();
            mediaPlayer.reset();
            mediaPlayer.setDataSource(url);
            //mediaPlayer.prepare(); // might take long! (for buffering, etc)
            mediaPlayer.prepareAsync();
            mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mediaPlayer) {
                    mediaPlayer.start();
                }
            });
        } catch (IOException e) {
            Log.w("Encountered Exception "+url+" ",e.getCause());
        }
        button.setBackground(context.getDrawable(R.drawable.play_round_button));
    }
    void Stop(){
        button.setBackground(context.getDrawable(R.drawable.round_button));
    }
}
