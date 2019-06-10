package com.mensagemtoast.oliveiragabriel.dogage2;

import android.media.MediaPlayer;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.transition.Slide;
import android.view.Gravity;
import android.view.Menu;

public class About extends AppCompatActivity {
    private Toolbar toolbar;
    private MediaPlayer mediaPlayer;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        mediaPlayer = MediaPlayer.create(About.this, R.raw.song);
        mediaPlayer.start();

        toolbar = findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);

        Slide slide = new Slide(Gravity.LEFT);
        getWindow().setEnterTransition(slide);



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_toolbar, menu);
        return true;
    }
}
