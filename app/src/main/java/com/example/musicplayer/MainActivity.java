package com.example.musicplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.IOException;
import java.net.URI;

public class MainActivity extends AppCompatActivity {

    Button play_button;
    Button pause_button;
    Button stop_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        play_button = findViewById(R.id.play_music);
        pause_button = findViewById(R.id.pause_music);
        stop_button = findViewById(R.id.stop_music);

        MediaPlayer mp =new MediaPlayer();
        mp.setAudioStreamType(AudioManager.STREAM_MUSIC);

        String audioPath = "android.resource://"+ getPackageName()+"/raw/jujutsu_kaisen";
        String onlineAudioPath = "https://commondatastorage.googleapis.com/codeskulptor-demos/DDR_assets/Sevish_-__nbsp_.mp3";

//        Uri audioURI = Uri.parse(audioPath);
        Uri onlineURI = Uri.parse(onlineAudioPath);
        try {
            mp.setDataSource(this,onlineURI);
            mp.prepare();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        play_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.start();
            }
        });
        pause_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.pause();
            }
        });
        stop_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.pause();
                mp.seekTo(0);
            }
        });

    }
}