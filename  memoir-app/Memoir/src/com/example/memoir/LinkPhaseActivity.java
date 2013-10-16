package com.example.memoir;

import Model.GameModel;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Html;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LinkPhaseActivity extends Activity {

	
	GameModel gm;
	TextView progressLabel;
	TextView firstWordLabel;
	TextView secondWordLabel;
	TextView timeLabel;
	Button nextWordLabel;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_link_phase);
		
		
		gm = new GameModel(10);
		progressLabel = (TextView)findViewById(R.id.progressLabel);
		firstWordLabel = (TextView)findViewById(R.id.firstWordLabel);
		secondWordLabel = (TextView)findViewById(R.id.secondWordLabel);
		timeLabel = (TextView)findViewById(R.id.timeLabel);
		nextWordLabel = (Button)findViewById(R.id.nextWordButton);
		
		
		ActionBar actionBar = getActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#3498DB")));
        actionBar.setTitle(Html.fromHtml("<large>LINKING PHASE</large>"));
        
		int progress = gm.getCurrentWordIndex()+1;
		progressLabel.setText(progress+"/"+gm.getWordCount()+ "words");
		try {
			firstWordLabel.setText(gm.getWordOne());
			secondWordLabel.setText(gm.getWordTwo());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.link_phase, menu);
		return true;
	}
	
	
	public void nextWord(View v){
		if(gm.getCurrentWordIndex()+2==gm.getWordCount()){
			Intent intent = new Intent(this,QuizPhaseActivity.class);
			//
		}else{
			if(gm.getCurrentWordIndex()+3==gm.getWordCount()){
				nextWordLabel.setText("Start Quiz!");
			}
			gm.linkNextWord();
			int progress = gm.getCurrentWordIndex()+1;
			progressLabel.setText(progress+"/"+gm.getWordCount()+ "words");
			try {
				firstWordLabel.setText(gm.getWordOne());
				secondWordLabel.setText(gm.getWordTwo());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
