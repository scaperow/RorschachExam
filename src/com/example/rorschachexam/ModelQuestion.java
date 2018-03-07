package com.example.rorschachexam;

import java.util.ArrayList;
import java.util.List;

import android.graphics.Bitmap;

public class ModelQuestion {
	private Bitmap image;
	private int score;
	public String[] options;
	public Integer[] option_score;
	private int answer;

	public ModelQuestion(Bitmap image,String[] option,Integer[] option_score) {
		this.image = image;
		this.options = option;
		this.option_score = option_score;
	}

	public void setAnswer(Integer answer_options) {
		this.answer = answer_options;
//		this.answer.clear();
//		this.score = 0;
//
//		for (Integer item : answer_options) {
//			if (options.length > item) {
//				answer.add(item);
//				score += options[item].score;
//			}
//		}
	}

	public int getScore() {
		return score;
	}

	public Bitmap getImage() {
		return image;
	}

	public static ModelQuestion parseFromString(Bitmap image, String value) {
		ModelQuestion question = null;
		List<String> olist = null;
		List<Integer> slist = null;
		
		String[] options = value.split("\\|");
		
		if (options == null || options.length == 0) {
			return null;
		}

		olist = new ArrayList<String>();
		slist =new ArrayList<Integer>();
		
		for (String item : options) {
			if (item.equals(null)) {
				continue;
			} else {
				String[] ovalues = item.split("#");
				
				if (ovalues == null || ovalues.length < 2) {
					continue;
				} else {
					olist.add(ovalues[0]);
					slist.add(Integer.parseInt(ovalues[1]));
				}
			}
		}

		if(olist.size() > 0){
			String[] oarray = new String[olist.size()];
			Integer[] sarray = new Integer[slist.size()];
			question=new ModelQuestion(image,oarray,sarray);
		}
		
		return question;
	}
}

class ModelOption {
	public String text;
	public int score;
}