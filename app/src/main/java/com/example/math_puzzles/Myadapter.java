package com.example.math_puzzles;

import static com.example.math_puzzles.MainActivity.editor;
import static com.example.math_puzzles.MainActivity.sharedPreferences;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class Myadapter extends BaseAdapter {
    Puzzle_Level_Show_Activity puzzle_level_show_activity;
    String[] levelArr;
    public Myadapter(Puzzle_Level_Show_Activity puzzle_level_show_activity, String[] levelArr) {
        this.puzzle_level_show_activity = puzzle_level_show_activity;
        this.levelArr = levelArr;
    }

    @Override
    public int getCount() {
        return levelArr.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(puzzle_level_show_activity).inflate(R.layout.activity_puzzle_level_show_item_file,parent,false);
        ImageView imageViewlock = convertView.findViewById(R.id.activity_puzzle_level_show_item_file_imageview_lock);
        ImageView imageViewtick = convertView.findViewById(R.id.activity_puzzle_level_show_item_file_imageview_tick);
        TextView textView = convertView.findViewById(R.id.activity_puzzle_level_show_item_file_textview_level_no);
        String Page = sharedPreferences.getString("page","pp");
        if(Page.equals("p0"))
        {
            String status = sharedPreferences.getString("levelstatus"+(position+1),"pending");
            int levelNo = sharedPreferences.getInt("LevelNo",0);

            textView.setText(" ");
            if(status.equals("WIN"))
            {
                imageViewlock.setVisibility(View.INVISIBLE);
                textView.setText(""+(levelArr[position]));
                imageViewtick.setImageResource(R.drawable.tick);

            } else if (status.equals("SKIP") || levelNo==position) {
                imageViewlock.setVisibility(View.INVISIBLE);
                textView.setText(""+levelArr[position]);
            }
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(puzzle_level_show_activity,Continue_Puzzle_Play_Activity.class);
                    intent.putExtra("LevelNo",position);
                    puzzle_level_show_activity.startActivity(intent);
                }
            });
            Log.d("MMM","getView : Status"+status);
        }
        if (Page.equals("p1")) {
            String status = sharedPreferences.getString("levelstatus"+(position+7),"pending");
            int levelNo = sharedPreferences.getInt("LevelNo",0);

            textView.setText(" ");
            if(status.equals("WIN"))
            {
                imageViewlock.setVisibility(View.INVISIBLE);
                imageViewtick.setImageResource(R.drawable.tick);
                textView.setText(""+(levelArr[position]));
            } else if (status.equals("SKIP") || levelNo==position+7) {
                imageViewlock.setVisibility(View.INVISIBLE);
                textView.setText(""+(levelArr[position]));
            }
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(puzzle_level_show_activity,Continue_Puzzle_Play_Activity.class);
                    intent.putExtra("LevelNo",position);
                    puzzle_level_show_activity.startActivity(intent);
                }
            });
            Log.d("MMM","getView  : Status"+status);
        }
        return convertView;
    }
}
