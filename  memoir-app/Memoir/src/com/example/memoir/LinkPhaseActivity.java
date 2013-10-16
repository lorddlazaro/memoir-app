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
import android.widget.Button;
import android.widget.TextView;

public class LinkPhaseActivity extends Activity {

	GameModel gm = new GameModel(10);
	TextView progressLabel = (TextView)findViewById(R.id.progressLabel);
	TextView firstWordLabel = (TextView)findViewById(R.id.firstWordLabel);
	TextView secondWordLabel = (TextView)findViewById(R.id.secondWordLabel);
	TextView timeLabel = (TextView)findViewById(R.id.timeLabel);
	Button nextWordLabel = (Button)findViewById(R.id.nextWordButton);
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_link_phase);
		
		
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
	
	public void nextWord(){
		if(gm.getCurrentWordIndex()+3==gm.getWordCount()){
			nextWordLabel.setText("Start Quiz!");
		}else if(gm.getCurrentWordIndex()+2==gm.getWordCount()){
			Intent intent = new Intent(this,QuizPhaseActivity.class);
			//
		}else{
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
