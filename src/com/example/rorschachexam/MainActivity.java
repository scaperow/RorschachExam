package com.example.rorschachexam;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.util.TypedValue;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener,DialogInterface.OnClickListener {

	Button button_previous = null;
	Button button_next = null;
	Button button_answer = null;
	Button button_result = null;
	ImageView image_question = null;
	ImageView image_map = null;
	ModelQuestion question = null;
	int BUTTON_STATE = ButtonState.ANSWER;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		setupControls();

		DBAdapter.loadDB(this);
	}

	private void setupControls() {
		// if (button_previous == null) {
		// button_previous = (Button) findViewById(R.id.button_previous);
		// button_previous.setOnClickListener(this);
		// }
		// if (button_next == null) {
		// button_next = (Button) findViewById(R.id.button_next);
		// button_next.setOnClickListener(this);
		// }
		// if (button_result == null) {
		// button_result = (Button) findViewById(R.id.button_result);
		// }
		// if (button_answer == null) {
		// button_answer = (Button) findViewById(R.id.button_answer);
		// button_answer.setOnClickListener(this);
		// }
		// if(image_map == null){
		// image_map = (ImageView)findViewById(R.id.image);
		// image_map.setOnClickListener(this);
		// }
		if (image_question == null) {
			image_question = (ImageView) findViewById(R.id.image_question);
			image_question.setOnClickListener(this);
			// image_question.setAnimation(Animation.RELATIVE_TO_SELF);
		}

		if (button_answer == null) {
			button_answer = (Button) findViewById(R.id.button_answer);
		}

		button_answer.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);

		AssetManager asset = getAssets();
		return true;
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		int id = arg0.getId();

		switch (arg0.getId()) {
		case R.id.button_answer:
			if(BUTTON_STATE == ButtonState.ANSWER){
				button_answer.setText(R.string.next_quest);
			new AlertDialog.Builder(this).setItems(question.options, new DialogInterface.OnClickListener(){

				public void onClick(DialogInterface v,int index) {
					// TODO Auto-generated method stub
					
				}
			}).show();
				
				BUTTON_STATE = ButtonState.NEXT;
				break;
			}
			
			if(BUTTON_STATE == ButtonState.NEXT){
				
				break;
			}
			break;
		}
		// if (id == R.id.button_previous) {
		// if (DBAdapter.canPrevious()) {
		// showQuestion(DBAdapter.getPreviousQuestion());
		// }
		// return;
		// }
		//
		// if (id == R.id.button_next) {
		// if (DBAdapter.canNext()) {
		// showQuestion(DBAdapter.getNextQuestion());
		// }
		// return;
		// }
		//
		// if(id == R.id.image){
		//
		// }
		// if (arg0 == button_previous) {
		// if(DBAdapter.canNext()){
		// showQuestion(DBAdapter.getNextQuestion());
		// }
		// return;
		// }
		//
		// if (arg0 == button_previous) {
		//
		// return;
		// }

	}

	private void showQuestion(ModelQuestion question) {
		image_question.setImageBitmap(question.getImage());
	}

	@Override
	public void onClick(DialogInterface dialog, int which) {
		// TODO Auto-generated method stub
		
	}

}

class QuestionButtonClickListener implements OnClickListener{

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	}
	
}

class ButtonState {
	public static int ANSWER = 1;
	public static int NEXT = 2;
}
