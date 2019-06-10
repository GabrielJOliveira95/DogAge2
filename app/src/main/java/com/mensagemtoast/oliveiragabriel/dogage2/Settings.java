package com.mensagemtoast.oliveiragabriel.dogage2;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.transition.Slide;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Settings extends AppCompatActivity {

    private ListView listSetting;
    private Toolbar toolbar;
    private MediaPlayer mediaPlayer;
    private String[] options = {"Language", "Theme"};
    private AlertDialog.Builder alert;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        mediaPlayer = MediaPlayer.create(Settings.this, R.raw.song);
        mediaPlayer.start();
        Slide slide = new Slide(Gravity.LEFT);
        getWindow().setEnterTransition(slide);
        listSetting = findViewById(R.id.listSetting);
        toolbar = findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, options);
        listSetting.setAdapter(adapter);

        listSetting.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                alert = new AlertDialog.Builder(Settings.this);
                String postionString = listSetting.getItemAtPosition(position).toString();
                switch (postionString){
                    case "Language":
                        alert.setItems(R.array.setLang, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });
                        alert.create();
                        alert.show();

                        break;

                    case "Theme":
                        alert.setItems(R.array.theme, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });
                        alert.create();
                        alert.show();
                }





            }
        });










    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_toolbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}
