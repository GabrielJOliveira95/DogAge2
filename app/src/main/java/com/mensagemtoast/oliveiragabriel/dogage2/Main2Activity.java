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
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class Main2Activity extends AppCompatActivity {

    private Toolbar toolbar;
    private ImageView dogPic;
    private MediaPlayer mediaPlayer;
    private TextView age;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        mediaPlayer = MediaPlayer.create(Main2Activity.this, R.raw.song);
        mediaPlayer.start();
        Slide slide = new Slide(Gravity.LEFT);
        getWindow().setEnterTransition(slide);

        age = findViewById(R.id.age);
        dogPic = findViewById(R.id.docPic);
        toolbar = findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);



        Bundle bundle = getIntent().getExtras();
        String a = bundle.getString("result");
        Toast.makeText(Main2Activity.this, a, Toast.LENGTH_LONG ).show();
        age.setText(a + " Years old");
        setImageDog(a);



    }


    private void setImageDog(String age){

        int ageInt = Integer.parseInt(age);

        if (ageInt <= 13){
            dogPic.setImageResource(R.drawable.baby_dog);

        } else if (ageInt > 13 && ageInt <= 18){
            dogPic.setImageResource(R.drawable.teen_dog2);

        } else if (ageInt > 18 && ageInt <= 60){
            dogPic.setImageResource(R.drawable.adult_dog);

        } else if (ageInt > 60){
            dogPic.setImageResource(R.drawable.old);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_toolbar, menu);
        return true;
    }
}



