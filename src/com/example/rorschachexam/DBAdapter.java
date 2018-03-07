package com.example.rorschachexam;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class DBAdapter {

	private static int current_question_index = 0;
	private static List<ModelQuestion> datas;
	static {
		datas = new ArrayList<ModelQuestion>();
	}

	public static boolean loadDB(Context context) {
		Resources resources = context.getResources();
		Bitmap image = BitmapFactory.decodeResource(resources, R.drawable.a1);
		String text = resources.getString(R.string.a1);
		datas.add(ModelQuestion.parseFromString(image, text));

		image = BitmapFactory.decodeResource(resources, R.drawable.a1);
		text = resources.getString(R.string.a1);
		datas.add(ModelQuestion.parseFromString(image, text));

		image = BitmapFactory.decodeResource(resources, R.drawable.a2);
		text = resources.getString(R.string.a2);
		datas.add(ModelQuestion.parseFromString(image, text));

		image = BitmapFactory.decodeResource(resources, R.drawable.a3);
		text = resources.getString(R.string.a3);
		datas.add(ModelQuestion.parseFromString(image, text));

		image = BitmapFactory.decodeResource(resources, R.drawable.a4);
		text = resources.getString(R.string.a4);
		datas.add(ModelQuestion.parseFromString(image, text));

		image = BitmapFactory.decodeResource(resources, R.drawable.a5);
		text = resources.getString(R.string.a5);
		datas.add(ModelQuestion.parseFromString(image, text));

		image = BitmapFactory.decodeResource(resources, R.drawable.a6);
		text = resources.getString(R.string.a6);
		datas.add(ModelQuestion.parseFromString(image, text));

		return true;
	}

	public static boolean canNext() {
		if (current_question_index + 1 >= datas.size()) {
			return false;
		}

		return true;
	}

	public static boolean canPrevious() {
		if (current_question_index - 1 < 0) {
			return false;
		}

		return true;
	}

	public static ModelQuestion getNextQuestion() {
		return datas.get(++current_question_index);
	}

	public static ModelQuestion getPreviousQuestion() {
		return datas.get(--current_question_index);
	}

	public static ModelQuestion getQuestion(int index) {
		if (index < 0 || index >= datas.size()) {
			return null;
		}

		return datas.get(index);
	}

	public static int getCurrentQuestionIndex() {
		return current_question_index;
	}

	public static int getQuestionSize() {
		return datas.size();
	}
}
