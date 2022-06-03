package com.example.tic_tak_toe_189;

import androidx.appcompat.app.AppCompatActivity;
import androidx.gridlayout.widget.GridLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    boolean iswin = false;
    int imageclick = -1;

    int[]tournament = {-1,-1,-1};
    int x=0;

    int p=1;
    int [][]winning = {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    int[]game = {-1,-1,-1,-1,-1,-1,-1,-1,-1};
    public void load(View view)
    {
        if(iswin == false && imageclick == -1)
        {
            ImageView v = (ImageView) view;
            int tag = Integer.parseInt(v.getTag().toString());
            imageclick = game[tag];
            if (p == 1) {
                v.setImageResource(R.drawable.cross);
                game[tag] = p;
                Toast.makeText(this, tag + " " + "Cross", Toast.LENGTH_SHORT).show();
                p = 0;
            } else {
                v.setImageResource(R.drawable.zero);
                game[tag] = p;
                Toast.makeText(this, tag + " " + "Zero", Toast.LENGTH_SHORT).show();
                p = 1;
            }
            int count=0;
            for (int i = 0; i < winning.length; i++) {
                if (game[winning[i][0]] == game[winning[i][1]] && game[winning[i][1]] == game[winning[i][2]] && game[winning[i][0]] > -1) {
//                    Toast.makeText(this, "Winner is " + (p==0 ? 1 : 0), Toast.LENGTH_SHORT).show();
                    tournament[x] = p;
                    x++;
                    if(tournament[i]==1){
                        count++;
                    }
                    iswin = true;
                    if(i==winning.length-1)
                    {
                        result(count);
                    }
                }
            }
        }
//        for(int i=0;i<3;i++)
//        {
//            System.out.print(tournament[i]+" ");
//        }
        //int count=0;
        /*for(int i=0;i<3;i++)
        {
            if(tournament[i] == 1)
                count++;
        }*/

    }

    public void result(int count){
        if(count>=2)
            Toast.makeText(this, "Winner is cross" , Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this, "Winner is zero" , Toast.LENGTH_SHORT).show();
    }

    public void restart(View view)
    {
        GridLayout grid = findViewById(R.id.gridlayout);
        int tot_img = grid.getChildCount();
        for(int i =0 ; i< tot_img ; i++)
        {
            ImageView v1 = (ImageView) grid.getChildAt(i);
            v1.setImageDrawable(null);
        }
        iswin = false;
        imageclick = -1;
        for(int i =0 ;i<game.length;i++)
            game[i] = -1;
        p=1;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}