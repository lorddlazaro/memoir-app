package com.example.memoir;

import android.os.Bundle;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.text.Html;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        ActionBar actionBar = getActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#3498DB")));
        actionBar.setTitle(Html.fromHtml("<large>MEMOIR</large>"));
        
        Typeface myTypeface = Typeface.createFromAsset(getAssets(), "fonts/Lovelo/LoveloBlack.otf");
        TextView myTextView = (TextView)findViewById(R.id.helloTxt);
        myTextView.setTypeface(myTypeface);
        
        Button beginBtn =(Button) findViewById(R.id.beginBtn);
        Typeface type=Typeface.createFromAsset(getAssets(), "fonts/Lovelo/LoveloBlack.otf");
        beginBtn.setTypeface(type);
        
        Button statisticsBtn =(Button) findViewById(R.id.statisticsBtn);
        Typeface type1=Typeface.createFromAsset(getAssets(), "fonts/Lovelo/LoveloBlack.otf");
        statisticsBtn.setTypeface(type1);
        
        beginBtn.setOnClickListener(new OnClickListener(){    
            @Override
			public void onClick(View v) {
            	Intent myIntent = new Intent(MainActivity.this, GameListScreen.class);
                startActivity(myIntent);
			}
        });    
        
        statisticsBtn.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				Intent myIntent = new Intent(MainActivity.this, StatisticsScreen.class);
                startActivity(myIntent);
			}
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
