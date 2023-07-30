package com.example.math_puzzles;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView Continue,Puzzles,Buypro;
    int levelNo=0;
    public  static SharedPreferences sharedPreferences;
    public static SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Continue = findViewById(R.id.activity_main_continue);
        Puzzles = findViewById(R.id.activity_main_puzzles);
        Buypro = findViewById(R.id.activity_main_continue);
        sharedPreferences = getSharedPreferences("MyDownload",MODE_PRIVATE);
        editor = sharedPreferences.edit();
        levelNo = sharedPreferences.getInt("LevelNo",0);


        Continue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Continue_Puzzle_Play_Activity.class);
                intent.putExtra("levelNo",levelNo);
                startActivity(intent);
                finish();
            }
        });
        Puzzles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Puzzle_Level_Show_Activity.class);
                intent.putExtra("levelNo",levelNo);
                startActivity(intent);
                finish();
            }
        });
    }
}