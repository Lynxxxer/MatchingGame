package com.example.matchinggame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
        ImageView curView = null;
        private int countPair = 0;
        final int[] drawable = new int[]{R.drawable.sample_0,R.drawable.sample_1,R.drawable.sample_2,R.drawable.sample_3,
                R.drawable.sample_4,R.drawable.sample_5,R.drawable.sample_6,R.drawable.sample_7,};
        int[] pos ={0,1,2,3,4,5,6,7,5,0,2,3,7,1,6,4};
        int currentPos =-1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridView gridView= (GridView) findViewById(R.id.gridView);
        ImageAdapter imageAdapter = new ImageAdapter(this);
        gridView.setAdapter(imageAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if (currentPos <0)
                {
                    currentPos = position;
                    curView = (ImageView)view;
                    ((ImageView)view).setImageResource(drawable[pos[position]]);
                }
                else
                {
                    if (currentPos == position)
                    {
                        ((ImageView)view).setImageResource(R.drawable.hidden);
                    }
                    else if (pos[currentPos]!= pos[position])
                    {
                        curView.setImageResource(R.drawable.hidden);
                       // Toast.makeText(getApplicationContext(),"NOT MATCH",Toast.LENGTH_SHORT).show();
                    }
                    else {
                        ((ImageView)view).setImageResource(drawable[pos[position]]);
                        countPair++;

                        if (countPair==0)
                        {
                         //   Toast.makeText(getApplicationContext(),"YOU WIN", Toast.LENGTH_SHORT).show();
                        }
                    }
                    currentPos = -1;

                }
            }
        });
    }
}
