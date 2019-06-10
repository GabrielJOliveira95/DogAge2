package com.mensagemtoast.oliveiragabriel.dogage2;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private AppCompatButton btnCalculate;
    private AppCompatEditText editTextAge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);

        btnCalculate = findViewById(R.id.btnCalculate);
        editTextAge = findViewById(R.id.editTextAge);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ageString = editTextAge.getText().toString();
                calculate(ageString);
            }
        });

    }


    private void calculate(String age){

        if (age.isEmpty()){


            Toast.makeText(MainActivity.this, "Insert a value", Toast.LENGTH_LONG).show();
        } else {

            int ageInt = Integer.parseInt(age);
            int resulAge = ageInt * 7;
            String aaa = Integer.toString(resulAge);

            Intent intent = new Intent(MainActivity.this, Main2Activity.class);
            intent.putExtra("result", aaa);
            Bundle bundle = ActivityOptionsCompat.makeSceneTransitionAnimation(MainActivity.this).toBundle();
            startActivity(intent, bundle);


        }


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_toolbar, menu);
        return true;
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.about:
                Bundle bundle = ActivityOptionsCompat.makeSceneTransitionAnimation(MainActivity.this).toBundle();
                Intent intent = new Intent(MainActivity.this, About.class);
                startActivity(intent, bundle);
                break;
            case R.id.setting:
                bundle = ActivityOptionsCompat.makeSceneTransitionAnimation(MainActivity.this).toBundle();
                Intent intent1 = new Intent(MainActivity.this, Settings.class);
                startActivity(intent1, bundle);
        }
        return super.onOptionsItemSelected(item);
    }
}
