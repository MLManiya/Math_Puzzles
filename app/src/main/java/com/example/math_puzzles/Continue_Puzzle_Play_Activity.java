package com.example.math_puzzles;

import static com.example.math_puzzles.MainActivity.editor;
import static com.example.math_puzzles.MainActivity.sharedPreferences;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Continue_Puzzle_Play_Activity extends AppCompatActivity implements View.OnClickListener {
    EditText editText;
    TextView txtlevel;
    ImageView imageView,skip,hint;
    Button one,two,three,four,five,six,seven,eight,nine,zero,clear,submit;
    String temp,t;
    Button B[] = new Button[10];
    int cnt=0;
    static String[] ansArr = {"10","20","30","40","50","60","70","80","90","100","110","120","130","140","150","160"};
    int levelNo=0;
    private ArrayList<String> imgArr=new ArrayList<>();
    private List<String> arrayList=new ArrayList<>();
    private java.io.InputStream InputStream;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_continue_puzzle_play);
        editText = findViewById(R.id.activity_continue_puzzle_play_answer_edittext);
        txtlevel = findViewById(R.id.activity_continue_puzzle_play_level_show_textview);
        /*one = findViewById(R.id.activity_continue_puzzle_play_one_button);
        two = findViewById(R.id.activity_continue_puzzle_play_two_button);
        three = findViewById(R.id.activity_continue_puzzle_play_three_button);
        four = findViewById(R.id.activity_continue_puzzle_play_four_button);
        five = findViewById(R.id.activity_continue_puzzle_play_five_button);
        six = findViewById(R.id.activity_continue_puzzle_play_six_button);
        seven = findViewById(R.id.activity_continue_puzzle_play_seven_button);
        eight = findViewById(R.id.activity_continue_puzzle_play_eight_button);
        nine = findViewById(R.id.activity_continue_puzzle_play_nine_button);
        zero = findViewById(R.id.activity_continue_puzzle_play_zero_button);*/
        skip = findViewById(R.id.activity_continue_puzzle_play_skip_imageview);
        hint = findViewById(R.id.activity_continue_puzzle_play_hint_imageview);
        imageView = findViewById(R.id.activity_continue_puzzle_play_puzzle_stage_imageview);
        clear = findViewById(R.id.activity_continue_puzzle_play_clear_button);
        submit = findViewById(R.id.activity_continue_puzzle_play_submit_button);

        levelNo=getIntent().getIntExtra("LevelNo",0);
       // levelNo++;
        txtlevel.setText("Puzzle"+" "+(levelNo+1));
        getImage(); 
        for(int i=0;i<B.length;i++)
        {
            int id = getResources().getIdentifier("B"+i,"id",getPackageName());
            B[i] = findViewById(id);
            B[i].setOnClickListener(this);
        }

    /*    one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                temp = String.valueOf(editText.getText());
                t = temp+"1";
                editText.setText(""+t);
                System.out.println(""+t);
            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                temp = String.valueOf(editText.getText());
                t = temp+"2";
                editText.setText(""+t);
                System.out.println(""+t);
            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                temp = String.valueOf(editText.getText());
                t = temp+"3";
                editText.setText(""+t);
                System.out.println(""+t);
            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                temp = String.valueOf(editText.getText());
                t = temp+"4";
                editText.setText(""+t);
                System.out.println(""+t);
            }
        });
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                temp = String.valueOf(editText.getText());
                t = temp+"5";
                editText.setText(""+t);
                System.out.println(""+t);
            }
        });
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                temp = String.valueOf(editText.getText());
                t = temp+"6";
                editText.setText(""+t);
                System.out.println(""+t);
            }
        });
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                temp = String.valueOf(editText.getText());
                t = temp+"7";
                editText.setText(""+t);
                System.out.println(""+t);
            }
        });
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                temp = String.valueOf(editText.getText());
                t = temp+"8";
                editText.setText(""+t);
                System.out.println(""+t);
            }
        });
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                temp = String.valueOf(editText.getText());
                t = temp+"9";
                editText.setText(""+t);
                System.out.println(""+t);
            }
        });
        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                temp = String.valueOf(editText.getText());
                t = temp+"0";
                editText.setText(""+t);
                System.out.println(""+t);
            }
        });*/
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               /* temp = String.valueOf(editText.getText());
                if(editText.getText().length()>0)
                {
                    t=temp.substring(0,temp.length()-1);
                    editText.setText(""+t);
                }
                else
                {
                    editText.setText("");
                }*/
                temp="";
                editText.setText(""+temp);
            }
        });
        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder1 = new AlertDialog.Builder(Continue_Puzzle_Play_Activity.this);
                builder1.setTitle("SKIP");
                builder1.setMessage("Are You Sure Want TO SKip This Level");
                builder1.setCancelable(true);

                builder1.setPositiveButton(
                        "OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                levelNo++;
                                editor.putInt("LevelNo",levelNo);
                                editor.putString("levelstatus"+(levelNo-1),"SKIP");
                                editor.commit();
                                Intent intent = new Intent(Continue_Puzzle_Play_Activity.this,Continue_Puzzle_Play_Activity.class);
                                intent.putExtra("levelNo",levelNo);
                                startActivity(intent);
                                finish();
                            }
                        });

                builder1.setNegativeButton(
                        "CANCLE",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });

                AlertDialog alert11 = builder1.create();
                alert11.show();
            }
        });
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Log.d("TTT", "onClick: Submit");
                if(editText.getText().toString().equals(ansArr[levelNo]))
                {
                    String status = sharedPreferences.getString("levelstatus"+(levelNo),"pending");
                    levelNo++;
                    if(status.equals("WIN") || status.equals("SKIP"))
                    {
                        Intent intent = new Intent(Continue_Puzzle_Play_Activity.this,Puzzle_Win_Page_Activity.class);
                        intent.putExtra("levelNo",levelNo);
                        startActivity(intent);
                        finish();
                    }
                    else
                    {
                        editor.putInt("LevelNo",levelNo);
                        editor.putString("levelstatus"+(levelNo),"WIN");
                        editor.commit();
                        Intent intent = new Intent(Continue_Puzzle_Play_Activity.this,Puzzle_Win_Page_Activity.class);
                        intent.putExtra("levelNo",levelNo);
                        startActivity(intent);
                        finish();
                    }
                    /*Log.d("TTT", "onClick: true");
                    levelNo++;
                    Intent intent=new Intent(Continue_Puzzle_Play_Activity.this,Continue_Puzzle_Play_Activity.class);
                    intent.putExtra("levelNo",levelNo);
                    startActivity(intent);*/
                    //finish();
                }
                else {
                    Toast.makeText(Continue_Puzzle_Play_Activity.this, "Wrong Answer", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        for(int i=0;i<B.length;i++){
            if(v.getId()==B[i].getId()){
                temp+=i;
                editText.setText(""+temp);
            }
        }
    }
    private void getImage()
    {
        String[] images = new String[0];
        try {
            images = getAssets().list("");
            Log.d("MMM", "Imgs Length= "+images.length);
            imgArr = new ArrayList<String>(Arrays.asList(images));
        } catch (IOException e) {
            e.getLocalizedMessage();
            Log.d("MMM", "getImage: Exception"+e.getLocalizedMessage());
        }
        for(int i=0;i<images.length;i++)
        {
            Log.d("MMM", "getImage: "+images[i]);
        }
        Collections.sort(imgArr);
        Log.d("MMM","Before ALl Images"+imgArr);
        //arrayList = imgArr.subList(0,imgArr.size());

     /*   arrayList.remove("android-logo-mask.png");
        arrayList.remove("android-logo-shine.png");
        arrayList.remove("clock_font.png");
        arrayList.remove("progress_font.png");*/

       /* Log.d("MMM","After All Images"+arrayList.get(0));*/
        InputStream inputStream = null;
        try
        {
            // get input stream
            inputStream = getAssets().open(""+imgArr.get(levelNo));
            // load image as Drawable
            Drawable d = Drawable.createFromStream(inputStream, null);
            // set image to ImageView
            imageView.setImageDrawable(d);
            inputStream.close();
        }
        catch(IOException ex)
        {
            ex.printStackTrace();
        }
    }

    /*@Override
    public void onClick(View v) {

    }*/
}
