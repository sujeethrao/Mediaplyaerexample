package com.example.sujeeth.mediaplyaerexample;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener {
    SeekBar seek_bar;
    ImageButton play, pause, stop;
    MediaPlayer player;
   // TextView text_shown;
    Handler seekHandler = new Handler();
    /** Called when the activity is first created. */ @Override

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getInit();
        seekUpdation();
    }

    public void getInit() {
        seek_bar = (SeekBar) findViewById(R.id.seek_bar);
        play = (ImageButton) findViewById(R.id.play_button);
        pause = (ImageButton) findViewById(R.id.pause_button);
        stop = (ImageButton) findViewById(R.id.stop_button);
     //   text_shown = (TextView) findViewById(R.id.text_shown);
        play.setOnClickListener(this);
        pause.setOnClickListener(this);
        stop.setOnClickListener(this);
        player = MediaPlayer.create(this, R.raw.sundari);
        seek_bar.setMax(player.getDuration());
    }

    Runnable run = new Runnable() { @Override

    public void run()
    {
        seekUpdation();
    } };

    public void seekUpdation() {
        seek_bar.setProgress(player.getCurrentPosition());
        seekHandler.postDelayed(run, 1000);
    } @Override

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.play_button:
                player.start();
             //   text_shown.setText("Playing...");
                Toast.makeText(getApplicationContext(), "Playing...",Toast.LENGTH_SHORT).show();
                break;
            case R.id.pause_button:
                player.pause();
             //   text_shown.setText("Paused...");
                Toast.makeText(getApplicationContext(), "Paused...",Toast.LENGTH_SHORT).show();
                break;
            case R.id.stop_button:
                player.stop();
            //    text_shown.setText("Stopped...");
                Toast.makeText(getApplicationContext(), "Stopped...",Toast.LENGTH_SHORT).show();
                player = MediaPlayer.create(this, R.raw.sundari);
        } }
}

