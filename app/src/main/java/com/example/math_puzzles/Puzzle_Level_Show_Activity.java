package com.example.math_puzzles;

import static com.example.math_puzzles.MainActivity.editor;
import static com.example.math_puzzles.MainActivity.sharedPreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

public class Puzzle_Level_Show_Activity extends AppCompatActivity {
    GridView gridView;
    ImageView imageViewlock,imageViewnext,imageViewback;
    TextView textView;
    Myadapter myadapter;
    int cnt=0;
    static String levelArr1[] = {"1","2","3","4","5","6","7"};
    static String levelArr2[] = {"9","10","11","12","13","14","15","16"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puzzle_level_show);
        gridView = findViewById(R.id.activity_puzzle_level_show_gridview);
        //imageViewlock = findViewById(R.id.activity_puzzle_level_show_item_file_imageview_lock);
        imageViewnext = findViewById(R.id.activity_puzzle_level_show_item_file_imageview_next);
        imageViewback = findViewById(R.id.activity_puzzle_level_show_item_file_imageview_back);
        myadapter = new Myadapter(Puzzle_Level_Show_Activity.this,levelArr1);

        editor.putString("page","p0");
        editor.commit();
     /*   if(levelArr.length<=6)
        {
            myadapter = new Myadapter(Puzzle_Level_Show_Activity.this,levelArr);
            gridView.setAdapter(myadapter);
        } else if (levelArr.length>=7 || levelArr.length<=12) {
            myadapter2 = new Myadapter(Puzzle_Level_Show_Activity.this,levelArr1);
            gridView2.setAdapter(myadapter2);
        }*/
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(Puzzle_Level_Show_Activity.this,Continue_Puzzle_Play_Activity.class);
                intent.putExtra("levelNo",position);
                startActivity(intent);
            }
        });

        imageViewnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cnt++;
                if(cnt==1)
                {
                    myadapter = new Myadapter(Puzzle_Level_Show_Activity.this,levelArr2);
                    gridView.setAdapter(myadapter);
                    editor.putString("page","p1");
                    editor.commit();
                    imageViewnext.setVisibility(View.VISIBLE);
                    imageViewback.setVisibility(View.VISIBLE);
                }
            }
        });
        imageViewback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cnt--;
                if(cnt==0)
                {
                    myadapter = new Myadapter(Puzzle_Level_Show_Activity.this,levelArr1);
                    gridView.setAdapter(myadapter);
                    editor.putString("page","p0");
                    editor.commit();
                    imageViewnext.setVisibility(View.INVISIBLE);
                    imageViewback.setVisibility(View.VISIBLE);
                    imageViewnext.setVisibility(View.VISIBLE);
                }
            }
        });
        gridView.setAdapter(myadapter);
    }
}