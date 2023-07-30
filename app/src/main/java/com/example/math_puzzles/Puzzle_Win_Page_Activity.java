package com.example.math_puzzles;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Puzzle_Win_Page_Activity extends AppCompatActivity {
    TextView textView;
    Button buttoncontinue,buttonmainmenu,buttonbuypro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puzzle_win_page);
        textView = findViewById(R.id.activity_puzzle_win_page_puzzle_level_no_textview);
        buttoncontinue = findViewById(R.id.activity_puzzle_win_page_continue_button);
        buttonmainmenu = findViewById(R.id.activity_puzzle_win_page_mainmenu_button);
        int levelNo = getIntent().getIntExtra("levelNo",0);
        textView.setText("PUZZLE"+" "+(levelNo)+" "+"COMPLETED");
        buttoncontinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    Intent intent=new Intent(Puzzle_Win_Page_Activity.this,Continue_Puzzle_Play_Activity.class);
                    intent.putExtra("levelNo",levelNo);
                   //levelNo++;
                    startActivity(intent);
                    finish();
            }
        });
        buttonmainmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Puzzle_Win_Page_Activity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}